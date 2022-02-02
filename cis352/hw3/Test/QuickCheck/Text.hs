-- | Terminal control. Internal QuickCheck module.
module Test.QuickCheck.Text
  ( Str(..)
  , ranges

  , number
  , short
  , showErr
  , oneLine
  , isOneLine
  , bold

  , newTerminal
  , withStdioTerminal
  , withNullTerminal
  , terminalOutput
  , handle
  , Terminal
  , putTemp
  , putPart
  , putLine
  )
 where

--------------------------------------------------------------------------
-- imports

import System.IO
  ( hFlush
  , hPutStr
  , stdout
  , stderr
  , Handle
  , BufferMode (..)
  , hGetBuffering
  , hSetBuffering
  , hIsTerminalDevice
  )

import Data.IORef
import Test.QuickCheck.Exception

--------------------------------------------------------------------------
-- literal string

newtype Str = MkStr String

instance Show Str where
  show (MkStr s) = s

ranges :: (Show a, Integral a) => a -> a -> Str
ranges k n = MkStr (show n' ++ " -- " ++ show (n'+k-1))
 where
  n' = k * (n `div` k)

--------------------------------------------------------------------------
-- formatting

number :: Int -> String -> String
number n s = show n ++ " " ++ s ++ if n == 1 then "" else "s"

short :: Int -> String -> String
short n s
  | n < k     = take (n-2-i) s ++ ".." ++ drop (k-i) s
  | otherwise = s
 where
  k = length s
  i = if n >= 5 then 3 else 0

showErr :: Show a => a -> String
showErr = unwords . words . show

oneLine :: String -> String
oneLine = unwords . words

isOneLine :: String -> Bool
isOneLine xs = '\n' `notElem` xs

bold :: String -> String
-- not portable:
--bold s = "\ESC[1m" ++ s ++ "\ESC[0m"
bold s = s -- for now

--------------------------------------------------------------------------
-- putting strings

data Terminal
  = MkTerminal (IORef ShowS) (IORef Int) (String -> IO ()) (String -> IO ())

newTerminal :: (String -> IO ()) -> (String -> IO ()) -> IO Terminal
newTerminal out err =
  do res <- newIORef (showString "")
     tmp <- newIORef 0
     return (MkTerminal res tmp out err)

withBuffering :: IO a -> IO a
withBuffering action = do
  mode <- hGetBuffering stderr
  -- By default stderr is unbuffered.  This is very slow, hence we explicitly
  -- enable line buffering.
  hSetBuffering stderr LineBuffering
  action `finally` hSetBuffering stderr mode

withStdioTerminal :: (Terminal -> IO a) -> IO a
withStdioTerminal action = do
  isatty <- hIsTerminalDevice stderr
  let err = if isatty then handle stderr else const (return ())
  withBuffering (newTerminal (handle stdout) err >>= action)

withNullTerminal :: (Terminal -> IO a) -> IO a
withNullTerminal action =
  newTerminal (const (return ())) (const (return ())) >>= action

terminalOutput :: Terminal -> IO String
terminalOutput (MkTerminal res _ _ _) = fmap ($ "") (readIORef res)

handle :: Handle -> String -> IO ()
handle h s = do
  hPutStr h s
  hFlush h

putPart, putTemp, putLine :: Terminal -> String -> IO ()
putPart tm@(MkTerminal res _ out _) s =
  do putTemp tm ""
     force s
     out s
     modifyIORef res (. showString s)
  where
    force :: [a] -> IO ()
    force = evaluate . seqList

    seqList :: [a] -> ()
    seqList [] = ()
    seqList (x:xs) = x `seq` seqList xs

putLine tm s = putPart tm (s ++ "\n")

putTemp tm@(MkTerminal _ tmp _ err) s =
  do n <- readIORef tmp
     err $
       replicate n ' ' ++ replicate n '\b' ++
       s ++ [ '\b' | _ <- s ]
     writeIORef tmp (length s)

--------------------------------------------------------------------------
-- the end.
