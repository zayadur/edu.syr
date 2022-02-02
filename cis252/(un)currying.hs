f :: Int -> Int -> Int
f x y   = x <= y

--  uncurry f

g :: (Int,Int) -> Bool
g (x,y) = x <= y