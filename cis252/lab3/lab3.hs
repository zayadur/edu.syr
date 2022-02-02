---------------------------------------------------------------
--
--  Starting file for Lab 3  (Spring 2017)
--
--  Zayadur Khan  02/01/17  CIS-252 M001
---------------------------------------------------------------

--
-- load Char module to get definition of isUpper, etc.
--
import Data.Char   

replaceThisTextWithYourAnswer = error "Question not yet answered"

---------------------------------------------------------------
--  Some predefined functions
---------------------------------------------------------------
bigOdd :: Int -> Bool
bigOdd x = odd x || x > 25

compares :: Int -> Int -> Int -> Int -> Bool
compares x y z w = (x > y) && (y > z) && (z > w) && (y > 400)

baffle :: Int -> Char -> Bool
baffle x c = isDigit c && even x

riddle :: Integer -> Bool 
riddle x = (2*x /= x)

query :: Int -> Bool -> Int
query x b 
    | not b     = x+1
    | x == 0    = -10
    | otherwise = (x-1)^2

mystery :: Char -> Char -> Bool
mystery c ch =  (toLower c == toLower ch) && (c /= ch)

enigma :: Integer -> Char -> Bool
enigma n c =  even n || isUpper c 

wonder :: Int -> Int -> Int
wonder x y = (div x y) + (mod x y)


---------------------------------------------------------------
--   An example problem (see the lab writeup for a solution)
---------------------------------------------------------------
--  Fill in the blanks so that zero evaluates to 5:
--      zero = wonder ____ ____
--
-- Problem zero is an example that is worked out in the lab.
--
zero :: Int
zero = wonder fillInBlank1 fillInBlank2
  where
    fillInBlank1 = 11
    fillInBlank2 = 3

---------------------------------------------------------------

---------------------------------------------------------------
-- Your problems start here...
---------------------------------------------------------------

--
--  Fill in the blank so that one evaluates to 9.0:
--      one = sqrt ____
--
one :: Float
one = sqrt fillInBlank
  where
   fillInBlank = 81


-- 
--  Fill in the blank so that two evaluates to False:
--      two = bigOdd ___________
--
two :: Bool
two = bigOdd fillInBlank
  where
   fillInBlank = 24

--
--  Fill in the blank so that three evaluates to False:
--      three =  isUpper (toUpper ___)
--
three :: Bool
three = isUpper (toUpper fillInBlank)
  where
   fillInBlank = '1'

--
--  Fill in the blank so that four evaluates to "Syracuse":
--      four = ____ ++ "cuse" 
--
four :: String
four = fillInBlank ++ "cuse"
  where
   fillInBlank = "Syra"

--
--  Fill in the blank so that five evaluates to True:
--      five = not (isAlphaNum ___)
--
five :: Bool
five = not (isAlphaNum fillInBlank)
  where
    fillInBlank = '!'

-- 
--  Fill in the blanks so that six evaluates to True:
--      six = baffle ____ ____
--
six :: Bool
six = baffle fillInBlank1 fillInBlank2
  where
   fillInBlank1 = 2
   fillInBlank2 = '1'

-- 
--  Fill in the blank so that seven evaluates to True:
--      seven = ____ /=  (query 3 True)
--
seven :: Bool
seven = fillInBlank /= (query 3 True)
  where
   fillInBlank = 5



--
--  Fill in the blanks so that eight evaluates to True:
--      eight = compares ___ ___ ___ ___ 
--
eight :: Bool
eight = compares fillInBlank1 fillInBlank2 fillInBlank3 fillInBlank4
  where
   fillInBlank1 = 402
   fillInBlank2 = 401
   fillInBlank3 = 400
   fillInBlank4 = 399

--
--  Fill in the blank so that nine evaluates to False:
--      nine = enigma (5^3) ___ 
--
nine :: Bool
nine = enigma (5^3) fillInBlank
  where
   fillInBlank = 'a'


--
--  Fill in the blanks so that ten evaluates to True:
--      ten = mystery ___ ___ 
--
ten :: Bool
ten = mystery fillInBlank1 fillInBlank2
  where
   fillInBlank1 = 'a'
   fillInBlank2 = 'A'

--
--  Fill in the blank so that eleven evaluates to 100:
--      eleven = ceiling ( _____ + 6.7)
--
eleven :: Int
eleven = ceiling ( fillInBlank + 6.7)
  where
   fillInBlank = 93

--
--  Fill in the blank so that twelve evaluates to 25:
--      twelve = query ___ (not False)
--
twelve :: Int
twelve = query fillInBlank (not False)
  where
   fillInBlank = 6


--
--  Fill in the blank so that thirteen evaluates to False:
--      thirteen = riddle ____
--
thirteen :: Bool
thirteen = riddle fillInBlank
  where
   fillInBlank = 0




--
--  Fill in the blank so that fourteen evaluates to True: 
--      fourteen = riddle (_______ (query 3 False))
--
fourteen :: Bool
fourteen = riddle (fillInBlank (query 3 False))
  where
   fillInBlank = toInteger

--
--  Fill in the blanks so that fifteen evaluates to 49:
--      fifteen = query (wonder ___ ____ )  (bigOdd ____)
--
fifteen :: Int
fifteen = query (wonder fillInBlank1 fillInBlank2) (bigOdd fillInBlank3)
  where
   fillInBlank1 = 16
   fillInBlank2 = 2
   fillInBlank3 = 26
