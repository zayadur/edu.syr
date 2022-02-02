{-# LANGUAGE CPP #-}
{-# OPTIONS_GHC -fno-warn-missing-import-lists #-}
{-# OPTIONS_GHC -fno-warn-implicit-prelude #-}
module Paths_QuickCheck (
    version,
    getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir,
    getDataFileName, getSysconfDir
  ) where

import qualified Control.Exception as Exception
import Data.Version (Version(..))
import System.Environment (getEnv)
import Prelude

#if defined(VERSION_base)

#if MIN_VERSION_base(4,0,0)
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#else
catchIO :: IO a -> (Exception.Exception -> IO a) -> IO a
#endif

#else
catchIO :: IO a -> (Exception.IOException -> IO a) -> IO a
#endif
catchIO = Exception.catch

version :: Version
version = Version [2,11,3] []
bindir, libdir, dynlibdir, datadir, libexecdir, sysconfdir :: FilePath

bindir     = "C:\\Users\\zayadur\\AppData\\Roaming\\cabal\\bin"
libdir     = "C:\\Users\\zayadur\\AppData\\Roaming\\cabal\\x86_64-windows-ghc-8.2.2\\QuickCheck-2.11.3-19mdm5lhmxMFf4AANg83KE"
dynlibdir  = "C:\\Users\\zayadur\\AppData\\Roaming\\cabal\\x86_64-windows-ghc-8.2.2"
datadir    = "C:\\Users\\zayadur\\AppData\\Roaming\\cabal\\x86_64-windows-ghc-8.2.2\\QuickCheck-2.11.3"
libexecdir = "C:\\Users\\zayadur\\AppData\\Roaming\\cabal\\QuickCheck-2.11.3-19mdm5lhmxMFf4AANg83KE\\x86_64-windows-ghc-8.2.2\\QuickCheck-2.11.3"
sysconfdir = "C:\\Users\\zayadur\\AppData\\Roaming\\cabal\\etc"

getBinDir, getLibDir, getDynLibDir, getDataDir, getLibexecDir, getSysconfDir :: IO FilePath
getBinDir = catchIO (getEnv "QuickCheck_bindir") (\_ -> return bindir)
getLibDir = catchIO (getEnv "QuickCheck_libdir") (\_ -> return libdir)
getDynLibDir = catchIO (getEnv "QuickCheck_dynlibdir") (\_ -> return dynlibdir)
getDataDir = catchIO (getEnv "QuickCheck_datadir") (\_ -> return datadir)
getLibexecDir = catchIO (getEnv "QuickCheck_libexecdir") (\_ -> return libexecdir)
getSysconfDir = catchIO (getEnv "QuickCheck_sysconfdir") (\_ -> return sysconfdir)

getDataFileName :: FilePath -> IO FilePath
getDataFileName name = do
  dir <- getDataDir
  return (dir ++ "\\" ++ name)
