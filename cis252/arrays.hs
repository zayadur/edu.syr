-----------------------------------------------------------------------------
--- Example: myUnzip
-----------------------------------------------------------------------------

myUnzip :: [(a,b)] -> ([a],[b])
myUnzip [] = ([], [])
myUnzip ((x,y):rest) = (x:xs, y:ys)
    where
      (xs,ys) = myUnzip rest


-----------------------------------------------------------------------------
-- Run length encoding:
-- simple forms of data compression
-- represents aaabcaaaccbbbba as
-- 3 a's, 1 b, 1 c, 3 a's , 2 c's , 4 b's 1 a
-- put it in the form of a list of tuples
-- [('a',3), ('b',1), ... , ('a',1)] 
-----------------------------------------------------------------------------
--- Example on run time coding
-----------------------------------------------------------------------------

-- 1. decode: example
-- *Main> decode [('a',3),('b',3),('c',2),('d',2),('a',2)]
-- "aaabbbccddaa"

-----------------------------------------------------------------------------

decode :: [(Char,Int)] -> String
decode [] = [] 
--decode ((c,n):rest) = [ c | x <- [1..n] ]  ++  decode rest
decode ((c,n):rest) = replicate n c  ++  decode rest


-----------------------------------------------------------------------------
-- 2. encode: example
-- *Main> encode "aaabbbccddaa"
-- [('a',3),('b',3),('c',2),('d',2),('a',2)]

-- Approach 1: count the number of occurrences of each
-- character
-----------------------------------------------------------------------------

encode :: String -> [(Char,Int)] 
encode [] = []
encode (c:cs) = count 1 c cs 
   where
     -- count i ch rest  
     --     so far, we've seen i many copies of the
     --     character ch,  and we still have to process rest
     count :: Int -> Char -> String -> [(Char,Int)]
     count i ch [] = [(ch,i)]
     count i ch (c:cs) 
         | ch == c = count (i+1) ch cs 
         | otherwise = (ch,i) : count 1 c cs



-----------------------------------------------------------------------------
-- Approach 2:  work from right to left
-- assume we already have the result the rest of the list
-- like:  [(c1, n1), (c2, n2), (c3, n3), ...,(ck, nk)]
-- check if c == c1 and act accordingly 
-----------------------------------------------------------------------------



encode2 :: String -> [(Char,Int)] 
encode2 [] = []
encode2 [c] = [(c,1)]
encode2 (c:cs) 
    | c == ch = (ch,n+1):rest
    | otherwise = (c,1): rr -- (ch,n):rest
  where
     rr@((ch,n):rest) = encode2 cs
