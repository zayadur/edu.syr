--  Zayadur Khan    02/08/18    CIS-352     HW3

--  Problem 1
rmChar :: Char -> String -> String
rmChar _ "" = ""
rmChar c str = (filter(/=c)) str

--  Problem 2
rmCharsRec :: String -> String -> String
rmCharsRec _ "" = ""
rmCharsRec [] s2 = s2
rmCharsRec (c:s1) s2 = s1 `rmCharsRec` (rmChar c s2)

rmCharsFold :: String -> String -> String
rmCharsFold _ "" = ""
rmCharsFold [] s2 = s2
rmCharsFold s1 s2 = foldr (rmChar) s2 s1

--  Problem 3
andRec :: [Bool] -> Bool
andRec [] = True
andRec (x:xs) = x && andRec xs

andFold :: [Bool] -> Bool
andFold xs = foldr (&&) True xs

--  Problem 4
same :: [Int] -> Bool
same xs = and (zipWith (==) xs (tail xs))

