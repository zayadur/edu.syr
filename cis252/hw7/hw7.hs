--  Zayadur Khan    03/22/17    CIS-252 M001    HW 7

import Data.Char

--  locate x ys returns a list of indices of locations of x in ys
--  i.e.    locate 'i' "mississippi"
--          returns [2,5,8,11]

locate :: Eq a => a -> [a] -> [Int]
locate x ys = map fst (filter (\(z,y) -> x == y)  (zip [1..] ys))

--  histogram xs produces a histogram string for sequence of non-negative Ints
--  i.e.    putStrLn ( histogram [5 ,3 ,1 ,4])
--          returns
--              *****
--              ***
--              *
--              ****

histogram :: [Int] -> String
histogram xs = concat (map f xs)
	where
		f :: Int -> String
		f x = replicate x '*' ++ "\n"

--  manyFuns fs v apply each function in fs to a value v
--  i.e.    manyFuns [reverse, tail, take 2] "hello"
--          returns ["olleh","ello","he"]

manyFuns :: [a -> b] -> a -> [b]
manyFuns fs v = map ($ v) fs

--  insertion sort algorithm

isort :: Ord a => [a] -> [a]
isort []        = []
isort (x:xs)    = ins x (isort xs)
    where
        ins y []        = [y]
        ins y (z:zs)
            | y <= z    = y:z:zs
            | otherwise = z:(ins y zs)

--  mySort p xs sorts xs according to binary predicate p
--  and is a generalized version of isort
--  mySort (<=) xs sorts xs in ascending order (like isort)
--  mySort (=>) xs sorts xs in descending order

mySort :: Ord a => (a -> a -> Bool) -> [a] -> [a]
mySort f [] = []
mySort f (x:xs) = ins x (mySort f xs)
    where
        ins y []    = [y]
        ins y (z:zs)
            | f y z = y:z:zs
            | otherwise = z:(ins y zs)

--  isFixPt f val determines whetehr val is a fixed point of function f
--  i.e.    isFixPt (\x -> x*x) 0   returns True
--          isFixPt (\x -> x*x) 2   returns False
--          isFixPt toUpper 'A'     returns True
--          isFixPt toUpper 'b'     returns False

isFixPt :: Eq a => (a -> a) -> a -> Bool
isFixPt f val
    | (f val) /= val    = False
    | otherwise         = True

--  changeFirst p val xs returns list that looks like xs,
--  except that the leftmost item in xs that satisfies p
--  is replaced by val; return xs by default
--  i.e.    changeFirst even 33 [1,7,4,8,2]
--              returns [1,7,33,8,2]
--          changeFirst even 33 [1,7,9,5]
--              returns [1,7,9,5]
--          changeFirst isLower '!' "Syracuse"
--              returns "S!racuse"
--          changeFirst isLower '!' "SYRACUSE"
--              returns "SYRACUSE"

changeFirst :: (a -> Bool) -> a -> [a] -> [a]
changeFirst p val []    = []
changeFirst p val (x:xs)
    | (p x) == False    = x : changeFirst p val xs
    | otherwise         = val : xs