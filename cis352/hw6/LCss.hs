------------------------------------------------------------------------
-- LC, Small-step semantic interpreter
-- Authors:  Forgot to add my name, please subtract some points 
-- Version 5.1: 23 Feb 2018

import LC 
import State
import LCParser
import Test.QuickCheck
import LCCEK (cekSteps)

------------------------------------------------------------------------
-- Contents
--   * Types LC prases, configurations, and continuations
--         NB: These are small-step configurations!!!!
--   * step: takes a configuration to the next configuration (if any)
--   * terminal: tests if a config is terminal
--   * steps: takes a config and repeatedly applies step until (if ever)
--         you end up with a terminal config
--   * steps': same as steps, but you get the list of all the configurations
--         of the computation (e.g., the trace)
--   * showConfig: a pretty printer for configs
--   * ss_prop: test if a given command has the same result under
--           both the small-step and CEK interpretors.
--   * run, run': given a comand and a state, prints the final state (if any)
--         e.g., try: run (Set 0 (AConst 99)) step4
--         e.g., try: run' "while val(x0)>0 do x0 := 0" step4
--   * stepRunA, stepRunA': These both step you through a trace of
--         the evaluation of an arithmetic expression.
--   * stepRunB, stepRunB': These both step you through a trace of
--         the evaluation of a boolean expression.
--   * stepRunC, stepRunC': These both step you through a trace of
--         the evaluation of a command.
--   * E.g., try:
--       stepRunA (AConst 7) state4
--       stepRunA' "7" state4
--       stepRunC' "x0 := 100" state4
------------------------------------------------------------------------
    
fixMe from = error ("Please fill in a definition for" ++ from)

------------------------------------------------------------------------

data Phrase = A AExp | B BExp | C Command deriving (Show)

type Config = (Phrase,State) 

-- Integer expressions
step (A (ABin iop (AConst n1) (AConst n2)),s)
    = (A (AConst n),s)
      where n = aApply iop n1 n2
                
step (A (ABin iop (AConst n1) ae2),s)
    = (A (ABin iop (AConst n1) ae2'),s')
      where (A ae2',s') = step (A ae2,s)

step (A (ABin iop ae1 ae2),s)
    = (A (ABin iop ae1' ae2),s')
      where (A ae1',s') = step (A ae1,s)    

step (A (Val loc),s)
    = (A (AConst (fetch s loc)),s)

-- Boolean expressions
step (B (Compare cop (AConst n1) (AConst n2)),s) = (B (BConst b),s)
    where b = bApply cop n1 n2
step (B (Compare cop (AConst n1) ae2),s) = (A ae2,s,(DoBOp2 cop n1))
step (B (Compare cop ae1 ae2),s) = (A ae1,s,(DoBOp1 ae2 cop))

-- Set 
step (C (Set loc (AConst n)),s) = (C Skip,set s loc n)
step (C (Set loc ae),s) = (C ae,s,(DoSet loc))

-- sequencing 
step (C (Seq Skip c2),s) = (C c2,s)
step (C (Seq c1 c2),s) = (C c1,s,(DoSeq c2))

-- if
step (C (If (BConst True)  c1 c2),s) = (C c1,s)
step (C (If (BConst False) c1 c2),s) = (C c2,s)
step (C (If be c1 c2),s) = (C be,s,(DoIf c1 c2))
      
-- while
step (C (While be c),s) = (C (If be (Seq c (While be c)) Skip),s)

-- do-whilst
step (C (DoWhilst c be),s) = (C (Seq c (While be c)),s)


-- terminal c, tests if c is a terminal config.
terminal (A (AConst _),_) = True
terminal (B (BConst _),_) = True
terminal (C Skip      ,_) = True
terminal _                = False

-- steps c = the result of iterating step until a terminal config appears
steps  c = if terminal c then c   else steps (step c)

-- steps' c = the same as steps **except** we return the entire
--            sequence of configurations
steps' c = if terminal c then [c] else c:steps' (step c)

-- showConfig c, prints the config c
showConfig n (phr,s)    = putStr $ "Step: " ++ show n 
              ++ "\n " ++ take 72 (show phr)
              ++ "\n " ++ concatMap f (dump s)
      where f (l,n) = "s["++ show l ++ "]=" ++ show n ++ "   "

-- Try: steps (A (aparse ae3), state4)
-- When you get things working, try: stepRunC' fact state4


-- Run: quickCheck ss_prop
--   This checks that your small-step evaluator gives the same final
--   states as the CEK evaluator on the same commands. 
--   N.B. The test commands have no while-loops.

ss_prop :: Command -> Bool
ss_prop cmd = (s1==s2)
    where (_,s1) = steps (C cmd,state4)
          s2     = cekSteps cmd state4

------------------------------------------------------------------------
------------------------------------------------------------------------
-- Some more testing tools
------------------------------------------------------------------------
------------------------------------------------------------------------

-- Source version of sample expressions and commands

-- integer expressions
ae0 = "0"
ae1 = "1+2"
ae2 = "val(x1)+2"
ae3 = "(val(x0)-3)*(7-val(x1))"

-- boolean expressions
be0 = "tt"
be1 = "9>8"
be2 = "9<8"
be3 = "(val(x0)-3) == (7-val(x1))"

-- commands 
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
cmd9 = "do x0 := val(x0) + 10 whilst val(x0)<=20"
factorial n = "{ x0 := "++show n++
              "; x1 := 1; while val(x0)>0 do " ++
              "{ x1 := val(x0)*val(x1); x0 := val(x0)-1 }}"    
cmd10 = factorial 3
fact4 = factorial 4

-- a sample state
state0 = load empty [1,0,3] -- So: val(x0)=1, val(x1)=0, val(x2)=3

------------------------------------------------------------------------
-- For running commands and seeing the final configuration
------------------------------------------------------------------------
-- run cmd state
--   prints the final configuration of the run of (C cmd, state)
run :: Command -> State -> IO ()
run cmd state = do showConfig (-1) (steps (C cmd,state))
                   putStrLn ""

-- run' inp state
--   parses inp to get a command cmd
--   then prints the final configuration of the run of (C cmd, state)
-- Try: (run cmd0 state0)
run' :: String -> State -> IO ()
run' inp state = run (cparse inp) state

------------------------------------------------------------------------
-- For running commands step by step
------------------------------------------------------------------------

-- stepRunA ae state
--   prints the run of the small step semantics started
--   on initial configuration (A ae, state)
stepRunA :: AExp -> State -> IO ()
stepRunA ae state = stepByStep 0 (steps' (A ae,state))

-- Try: (stepRunA' ae3 state0)
stepRunA' inp state = stepRunA (aparse inp) state

-- stepRunB be state
--   prints the run of the small step semantics started
--   on initial configuration (B be, state)
stepRunB :: BExp -> State -> IO ()
stepRunB be state = stepByStep 0 (steps' (B be,state))

-- Try: (stepRunB' be3 state0)
stepRunB' inp state = stepRunB (bparse inp) state

-- stepRunC cmd state
--   prints the run of the small step semantics started
--   on initial configuration (C cmd, state)
stepRunC :: Command -> State -> IO ()
stepRunC cmd state = stepByStep 0 (steps' (C cmd,state))

-- stepRunC' inp state
--   parses inp to get a command cmd, then
--   prints the run of the small step semantics started
--   on initial configuration (C cmd, state)
-- Try: (stepRunC' cmd0 state0)
stepRunC' :: String -> State -> IO ()
stepRunC'  inp state = stepRunC (cparse inp) state

-- Print out steps one at a time (utility for stepRunA, stepRunB, stepRunC)
stepByStep _ [] = putStr ""
stepByStep n (c:cs)
    = do { showConfig n c
         ; putStr "  <tap return>"
         ; getChar
         ; stepByStep (n+1) cs 
         }
