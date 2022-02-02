data Shape =    Point | Circle Float | Square Float | 
                Rectangle Float Float | Triangle Float Float Float

--  Type constructors
--      Point :: Shape
--      Circle :: Float -> Shape
--      Square :: Float -> Shape
--      Rectangle :: Float -> Float -> Shape
--      Triangle :: Float -> Float -> Float -> Shape

--  Calculating the area of a shape

area :: Shape -> Float
area Circle r       = pi * r * r
area Rectangle h w  = h * w
area Triangle a b c = sqrt(s*(s-a)*(s-b)*(s-c))
    where
        s = (a*b*c) `div` 2

--  some sample list of Shapes
someShapes :: [Shape]
someShapes = [Point, Circle 5, Square 10, Rect 1 4]

moreShapes :: [Shape]
moreShapes = [shape1, shape2, Square 1, shape 3, shape 4]

--  

countCircle :: [Shape] -> Int
countCircle []                  = 0
countCircle (Circle r : rest)   = 1 + countCircle rest
countCircle (Circle r : rest)   = countCircle rest

countCircleLC :: [Shape] -> Int
countCircleLC xs =  [1 | Circle r <- xs]