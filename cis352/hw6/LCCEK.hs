------------------------------------------------------------------------
-- A CEK interpreter for LC
-- Version 4.1: 23 Feb 2018

module LCCEK where
import LC
import LCParser
import State
import Text.Printf

------------------------------------------------------------------------
-- Contents
--   * Types LC prases, configurations, and continuations
--         NB: These are CEK-configurations!!!!
--   * step: takes a configuration to the next configuration (if any)
--   * terminal: tests if a config is terminal
--   * steps: takes a config and repeatedly applies step until (if ever)
--         you end up with a terminal config
--   * cekSteps: given a comand and a state, returns the final state
--         (if any)
--   * steps': same as steps, but you get the list of all the configurations
--         of the computation (e.g., the trace)
--   * showConfig: a pretty printer for configs
--   * stepRun, stepRun': These both step you through a trace
--         e.g., try: stepRun (Set 9 (AConst 88)) step4
--         e.g., try: stepRun' "while val(x0)>0 do x0 := 0" step4
------------------------------------------------------------------------

data Phrase = A AExp | B BExp | C Command  deriving (Show)

type Config = (Phrase,State,Cont)   

type Cont = [ToDo]

data ToDo = DoAOp1 AExp AOp | DoAOp2 AOp Int -- arith. ops
          | DoBOp1 AExp COp | DoBOp2 COp Int -- boolean ops
          | DoSet Location                   -- store in a loc
          | DoSeq Command                    -- sequence cmds
          | DoIf Command Command             -- if cmd
          | Halt                             -- what the name says
            deriving (Show)

-- step c = the next cek-configuration after c
step :: Config -> Config
-- arithmetic expressions
step (A (Val loc),s,ks)                    = (A (AConst n),s,ks)
    where n = fetch s loc   
step (A (ABin aop ae1 ae2),s,ks)           = (A ae1,s,(DoAOp1 ae2 aop):ks)
step (A (AConst n1),s,(DoAOp1 ae2 aop):ks) = (A ae2,s,(DoAOp2 aop n1):ks)
step (A (AConst n2),s,(DoAOp2 aop n1):ks)  = (A (AConst n),s,ks)
    where n = aApply aop n1 n2 
-- boolean expressions
step (B (Compare cop ae1 ae2),s,ks)        = (A ae1,s,(DoBOp1 ae2 cop):ks)
step (A (AConst n1),s,(DoBOp1 ae2 cop):ks) = (A ae2,s,(DoBOp2 cop n1):ks)
step (A (AConst n2),s,(DoBOp2 cop n1):ks)  = (B (BConst b),s,ks)
    where b = bApply cop n1 n2 
-- commands: set
step (C (Set loc ae),s,ks)                 = (A ae,s,(DoSet loc):ks)
step (A (AConst n),s,(DoSet loc):ks)       = (C Skip,set s loc n,ks)
-- commands: sequencing
step (C (Seq c1 c2),s,ks)                  = (C c1,s,(DoSeq c2):ks)
step (C Skip,s,(DoSeq c2):ks)              = (C c2,s,ks)
-- commands: if
step (C (If be c1 c2),s,ks)                = (B be,s,(DoIf c1 c2):ks)
step (B (BConst True) ,s,(DoIf c1 c2):ks)  = (C c1,s,ks)
step (B (BConst False),s,(DoIf c1 c2):ks)  = (C c2,s,ks)
-- commands: while
step (C (While be c),s,ks) 
    = (C (If be (Seq c (While be c)) Skip),s,ks)
-- commands: do-whilst
step (C (DoWhilst c be),s,ks) 
    = (C (Seq c (While be c)),s,ks)
                                             
-- terminal c, tests if c is a terminal config.
terminal :: Config -> Bool
terminal (A (AConst _),_,[Halt]) = True
terminal (B (BConst _),_,[Halt]) = True
terminal (C Skip      ,_,[Halt]) = True
terminal _                       = False

-- steps c = the result of iterating step until a terminal config appears
steps :: Config -> Config
steps  c = if (terminal c) then c else steps (step c)

-- cekSteps cmd state = final-state
cekSteps cmd state = finState
    where (_,finState,_) = steps (C cmd,state,[Halt])

-- steps' c = the same as steps **except** we return the entire
--            sequence of configurations
steps' :: Config -> [Config]
steps' c = if terminal c then [c] else c:steps' (step c)

-- showConfig c, prints the config c
showConfig n (phr,s,ks)
    = putStr $ "Step: " ++ show n 
              ++ "\n " ++ take 72 (show phr)
              ++ "\n " ++ concatMap f (dump s)
              ++ "\n " ++ take 72 (show ks)
      where f (l,n) = "s["++ show l ++ "]=" ++ show n ++ "   "

-- stepRun cmd state, prints the run of the CEK machine started
--   on initial configuration (C cmd, state, [Halt])
--   Try: (stepRun (cparse fact) state4) -- Warning: 112 steps
stepRun :: Command -> State -> IO ()
stepRun cmd state = helper 0 (steps' (C cmd,state,[Halt]))
    where 
      helper n [] = putStr ""
      helper n (c:cs)
          = do { showConfig n c   
               ; getChar          -- get a character from the user
               ; helper (n+1) cs 
               }

sample = "if val(x0)>0 then { x1 := val(x0)+1; x2 := 42 } else skip"
-- Try: (stepRun sample state4) -- 16 steps
stepRun' :: String -> State -> IO ()
stepRun' inp state = stepRun (cparse inp) state

cmd0 = "skip"
cmd1 = "x0 := 100"
cmd2 = "{ x0 := 100; x1 := val(x0)-1 }"
cmd3 = "{ x0 := (-2); x3 := ((-3)+val(x1)) }"
cmd4 = "if tt then x0 := 100 else x0 := 200"
cmd5 = "if ff then x0 := 100 else x0 := 200"
cmd6 = "if (val(x0)>0) then x0 := val(x0)-1 else x1 := val(x1)+3}"
cmd7 = "while (val(x0)>0) do { x0 := val(x0)-1; x1 := val(x1)+3 }"
cmd8 = "{ x1 := 1; x2 := val(x0); while (val(x2)>0) do "
       ++ "{ x1 := (val(x1)*val(x2)); x2 := (val(x2)-1) } }"
cmd9 = "iter x0 := val(x0) + 10 by 3"
cmd10 = "while val(x0)>0 do x0 := 0"

{- also try (stepRun' fact state4) which computes 4! in 112 steps. -}
