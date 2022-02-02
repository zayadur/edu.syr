{-  Assignment 1    Part 2                      -}
{-  Zayadur Khan    01/19/17    CIS-252 M001    -}

--  checks whether or not m is strictly between y and z
between :: Int -> Int -> Int -> Bool
between m y z = (m > y && m < z)

--  implements and checks if e1 and e2 are exclusive-or
--  from annevankesteren.nl's implementation of xor in haskell:
--      not (e1 && e2) to enforce e1 and e2 exclusivity
xor :: Bool -> Bool -> Bool
xor e1 e2 = (e1 || e2) && not (e1 && e2)

--  converts Delisle temperature to Fahrenheit scale
convertDtoF :: Float -> Float
convertDtoF temp = 212.0 - 1.2 * temp

--  converts Fahrenheit temperature to Delisle scale
convertFtoD :: Float -> Float
convertFtoD temp = (-5.0 * temp + 1060.0) / 6
