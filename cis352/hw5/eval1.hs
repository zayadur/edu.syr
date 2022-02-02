import AS1
import Parser1 (aparse)
import Debug.Trace

fixMe from = error ("Please fix " ++ from)

-- For a simple trace, uncomment the next line
-- eval e | trace ("entering eval with arg: "++ show e) False = undefined 
eval (Num  n)           = n
eval (Add  a1 a2)       = (eval a1) + (eval a2)
eval (Sub  a1 a2)       = (eval a1) - (eval a2)
eval (Mult a1 a2)       = (eval a1) * (eval a2)
eval (Div  a1 a2)       = 
eval (Cond a1 a2 a3)    = fixMe "the Cond case of eval"
------------------------------------------------------------------------
-- run e 
--   parses e, evaluates e, prints the answer
--   Try: (run "2+3*5")
run :: String -> IO ()
run etxt = do { let e = aparse etxt
              ; putStrLn $ "Evaluating: " ++ show e
              ; let val = eval e
              ; putStrLn $ "    Result: " ++ show val
              }

-- read-eval-print
rep :: IO ()
rep = do { etxt <- getLine;
         ; let e = aparse etxt
         ; let val = eval e
         ; putStrLn $ "Evaluates to:\t"++ show val
         }
