--
--  Assorted examples of pattern matching 
--

example1 :: (Int,Int) -> [Int]
example1 (3,x) = [x,1,x]
example1 (_,3) = []
example1 (w,y) = [w,y]

example2 :: (Int,Int) -> [Int]
example2 (w,y) = [w,y]
example2 (3,x) = [x,1,x]  


example3 :: [Integer] -> (Char, Integer)
example3 (a:b:cs) = ('#', b) 
example3 _ = ('?', 29) 

example4 :: [(Char,Int)] -> Int
example4 [] = 0
example4 ((c,i):(d,e):rest) = e
example4 ((c,i):rest) = i*100



----------------------------------------------------------------------
-- Recursion on lists, using pattern matching to break out cases
----------------------------------------------------------------------

--
-- myLength :: [a] -> Int
--
-- calculate length of a list  (equivalent to built-in function: length)
--
myLength :: [a] -> Int
myLength [] = 0
myLength (x:xs) = 1 + myLength xs

--
-- mySum :: [Integer] -> Integer
--
-- calculate sum of a list of integers  (see built-in function: sum)
--

mySum :: [Integer] -> Integer
mySum [] = 0
mySum (x:xs) = x + mySum xs


--
-- count :: Char -> String -> Int
--
-- count occurrences of particular char in string
--
--     Example: count 'a' "fadeaway"  returns 3
--              count 'i' "fadeaway"  returns 0

count :: Char -> String -> Int
count ch [] = 0
count ch (c:cs) 
    | c == ch   = 1 + count ch cs
    | otherwise = count ch cs

----------------------------------------------------------------------
----------------------------------------------------------------------
----------------------------------------------------------------------
--   Functions where we need to look at only one item at a time
----------------------------------------------------------------------
----------------------------------------------------------------------

count :: Char -> String -> Int
count ch [] = 0
count ch (c:cs) 
    | c == ch   = 1 + count ch cs
    | otherwise = count ch cs

{- this would be nice, but we can't use the same name in two 
   different patterns in the same equation. 

count2 :: Char -> String -> Int
count2 ch [] = 0
count2 c (c:cs) = 1 + count2 c cs      -- this line is problematic
count2 ch (c:cs) = count2 c cs
-}

--
-- double :: [a] -> [a]
--   
--    double xs  returns a list that contains two copies of every 
--       item in xs
--
--   Example:  double [1,2,4,2]  returns  [1,1,2,2,4,4,2,2]
--

double :: [a] -> [a]
double [] = []
double (x:xs) = x: x: double xs

--
-- oddify :: [Integer] -> [Integer]
--
--    oddify xs returns a list that contains all of the odd 
--       numbers that appear in xs
--
--    Example:  oddify [1,4,6,3,9,7,2]  returns  [1,3,9,7]
--

oddify :: [Integer] -> [Integer]
oddify [] = []
oddify (x:xs)
    | odd x     = x: oddify xs
    | otherwise = oddify xs



--
-- firstOdd :: [(Char,Int)] -> Char
--
--    firstOdd ps  returns the first character in the list ps that is 
--       paired with an odd number; if no odd, return '#'
-- 
--    Example:  firstOdd [('r',2), ('g',4), ('w',29), ('#',3), ('z',6)]
--                  returns   'w'

firstOdd :: [(Char,Int)] -> Char
firstOdd [] = '#'
firstOdd ((c,n):xs)
    | odd n     = c
    | otherwise = firstOdd xs


--
-- member :: Char -> String -> Bool
--
--   member c str  determines whether c appears in str
--
--    Example:  member 'e' "steelers" returns True
--              member 'e' "cubs" returns False
--              

member :: Char -> String -> Bool
member ch [] = False
{-
member ch (c:cs) 
    | ch == c   = True
    | otherwise = member ch cs
-}
member ch (c:cs) = (ch == c) || member ch cs





----------------------------------------------------------------------
----------------------------------------------------------------------
--   Functions where we do recursion on *two* lists
----------------------------------------------------------------------
----------------------------------------------------------------------



-- 
--  myZip behaves like the built-in function zip
--
--       myZip [1,2,5] [True, True, False, True, False]  returns:
--            [ (1,True), (2,True), (5,False)]
--


myZip :: [a] -> [b] -> [(a,b)]
--myZip [] _ = []
--myZip _ [] = []

myZip (x:xs) (y:ys) = (x,y) : myZip xs ys
myZip _ _ = []




--
--  merge takes two lists, which we assume to be in ascending order 
--      (if they're not, we don't care what happens)
--    and returns a single list in ascending order with all elements
--    from the original lists
--
--      merge [1,3,3,6]  [2,3,4]  returns [1,2,3,3,3,4,6]
--


merge :: [Integer] -> [Integer] -> [Integer]
merge (x:xs) (y:ys)
    | x <= y    = x : merge xs (y:ys)
    | otherwise = y : merge (x:xs) ys
merge [] ys = ys
merge xs [] = xs





----------------------------------------------------------------------
----------------------------------------------------------------------
--   Functions where we need to look at multiple items at a time
----------------------------------------------------------------------
----------------------------------------------------------------------


--
-- dropHalf :: [a] -> [a]
--
--  Drop every second element from a list
--
--     dropHalf [4,2,3,7,5,9,8,1,2]  returns [4,3,5,8,2]
--

dropHalf :: [a] -> [a]
dropHalf (a:b:cs) = a : dropHalf cs
{-
dropHalf [] = []
--dropHalf (x:xs) = [x]
--dropHalf (x:[]) = [x]
dropHalf [x] = [x]
-}
dropHalf xs = xs






--
-- ascending :: [Float] -> Bool
--
--  Determine whether a list of numbers is in ascending order:
--
--     ascending [2,3,3,5,8,10,57]  returns True
--     ascending [2,3,3,8,5,10,57]  returns False   
--

ascending :: [Float] -> Bool
ascending (x:y:zs) = (x <= y)  && ascending (y:zs)
ascending _ = True