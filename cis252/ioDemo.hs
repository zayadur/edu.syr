main :: IO ()
main = do   putStr "\nEnter a string: "
            resp <- getLine
            putStrLn ("\nYour string was: " ++ resp)
            putStrLn "\nGoodbye!"