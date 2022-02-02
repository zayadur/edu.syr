--  Zayadur Khan    02/08/17    CIS-252 M001    Lab 4

--  cycle3 creates a list of length n, repeatedly cycling among item1, item2, item3
--  report error if n < 0

cycle3 :: Int -> Integer -> Integer -> Integer -> [Integer]
cycle3 n item1 item2 item3
    | n == 0    = []
    | n == 1    = [item1]
    | n > 1     = item1 : cycle3 (n-1) item2 item3 item1
    | otherwise = error "cycle3 requires positive input"

--  switchback returns a list of length n, with the following pattern:
--  1 copy of item1, followed by 2 copies of item2,
--  followed by 2 copies of item 2,
--  followed by 2 copies of item 1
--  report error if n < 0

switchback :: Int -> Integer -> Integer -> [Integer]
switchback n item1 item2
    | n == 0    = []
    | n == 1    = [item1]
    | n > 1     = item1 : (item2 : switchback (n-2) item2 item1)
    | otherwise = error "switchback requires nonnegative input"