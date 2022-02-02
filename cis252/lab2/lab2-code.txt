{-  Zayadur Khan    zrkhan@syr.edu  -}
{-  Lab 2   CIS-252     01/24/17    -}

simple :: Integer -> Integer -> Integer
simple a b  = a + 3 * b

twoForOne :: Integer -> Integer -> Integer
twoForOne items price
    | items <= 0 || price <= 0  = 0
    | even items                = (div items 2) * price
    | otherwise                 = (1 + (div items 2)) * price

price :: Integer -> Integer -> Integer
price big tiny
    | big < 0 || tiny < 0   = 0
    | (big + tiny) > 9      = (795 * big) + (550 * tiny)
    | otherwise             = (850 * big) + (625 * tiny)