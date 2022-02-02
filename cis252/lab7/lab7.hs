--  Zayadur Khan    03/07/17    CIS-252 M001    Lab 7

roundEm :: [Float] -> [Integer]
roundEm rs = map round rs

getLengths :: [String] -> [(String,Int)]
getLengths strs = map (\strs -> (strs,length strs)) strs

grabOdds :: [Integer] -> [Integer]
grabOdds nums = filter odd nums

--  TODO
negatives :: [(Char,Int)] -> [(Char,Int)]
negatives ps = filter (\(c,i) -> (i<0)) ps

mystery :: Int -> [Int] -> [Int]
mystery k qs = [q*100 | q <- qs, q < 3*k]

--  TODO
mystery2 :: Int -> [Int] -> [Int]
mystery2 k qs = map (\q -> q*100) (filter (\q -> (q < (3*k))) qs)