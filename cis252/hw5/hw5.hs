--  Zayadur Khan    02/27/17    CIS-252 M001    Assignment 5

--  duplicates takes a string s and determines whether any 
--  characters appear more than once in the string
--  i.e.    duplicates "Two or more" returns True
--          duplicates "Exactly four" returns False

duplicates :: String -> Bool
duplicates ""       = False
duplicates (x:xs)
    | x `elem` xs   = True
    | otherwise     = duplicates xs

--  zap ch cs returns the string obtained from cs by removing
--  all occurences of ch
--  i.e.    zap 'a' "Abracadabra" returns "Abrcdbr"

zap :: Char -> String -> String
zap c cs    = [ch | ch <- cs, ch /= c]

--  unique cs returns a string that contains those characters that
--  occur exactly once in cs
--  i.e.    unique "Abracadabra" returns "Acd"

unique :: String -> String
unique ""   = ""
unique (c:cs)
    | c `elem` cs   = unique (zap c cs)
    | otherwise     = c : unique cs
    
--  prefix xs ys determines whether xs is a prefix of ys
--  i.e.    prefix "music" "musician" returns True
--          prefix "music" "musingcian" returns False
--  TODO: non-exhaustive patterns in function prefix
--  STRATEGY:   look at first character of each list
--              if equal, recursively call prefix again
--              if not equal, return False
--              if empty, return True

prefix :: String -> String -> Bool
prefix "" ""    = True
prefix "" y     = True
prefix x ""     = False
prefix (x:xs) (y:ys)
    | x == y    = prefix xs ys
    | x /= y    = False

--  subseq xs ys determines whether xs is a subsequence of ys
--  i.e.    subseq "music" "computer science" returns True
--          subseq "music" "mustard cider" returns False

subseq :: String -> String -> Bool
subseq [] []    = True
subseq xs []    = False
subseq [] ys    = True
subseq (x:xs) (y:ys)
    | x == y    = subseq xs ys
    | otherwise = subseq (x:xs) ys

--  substring xs ys determines whether xs is a substring of ys
--  i.e.    substring "music" "computer science" returns False
--          substring "mile" "smiled" returns True

substring :: String -> String -> Bool
substring xs []     = False
substring (x:xs) (y:ys)
    | prefix (x:xs) (y:ys) == False = substring (x:xs) ys
    | otherwise                     = True

--  subsequences xs returns a list containing all of the
--  subsequences of xs
--  i.e.    subsequences "abcb" returns
--              [ " abcb " ," bcb " ," acb " ," cb " ," abb " ," bb " ," ab " ," b " ," abc " ," bc " ," ac " ," c " ," ab " ," b " ," a " ," " ]

subsequences :: String -> [String]
subsequences []     = [[]]
subsequences (x:xs) = [x:z | z <- subsequences xs] ++ subsequences xs