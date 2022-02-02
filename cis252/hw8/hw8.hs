--  Zayadur Khan    CIS-252 M001    03/31/17    Assignment 8

import BinaryTrees

--  height tree calculates the height of a tree
--  empty tree returns -1

height :: BTree a -> Int
height Empty            = -1
height (BNode _ t1 t2)  = 1 + (max (height t1) (height t2))

--  autumn tree returns the tree obtained by removing
--  every leaf from tree
--  TODO

autumn :: BTree a -> BTree a
autumn Empty                    = Empty
autumn (BNode b Empty Empty)    = (BNode b Empty Empty)
autumn (BNode b left right)     = (BNode b Empty Empty)

--  full tree determines whether a tree is a full
--  binary tree
--  TODO

full :: BTree a -> Bool
full Empty                  = False
full (BNode b Empty Empty)  = False
full (BNode b left right)   = True

--  mirror tree returns mirror image of tree

mirror :: BTree a -> BTree a
mirror Empty = Empty
mirror (BNode b left right) = BNode b (mirror right) (mirror left)

--  mapTree f tree returns tree obtained by applying
--  function f to every label in tree
--  i.e.    mapTree (\ w -> w*10) tree2 returns:
--
--      BNode 80 (BNode 130 Empty (BNode 120 Empty Empty))
--                  (BNode 200 Empty Empty)
--  NOTE: method not working

mapTree :: (a -> b) -> BTree a -> BTree b
mapTree f (BNode c Empty Empty)   = (BNode c Empty Empty)
mapTree f (BNode c left right)  = BNode (f c) (mapTree f left) (mapTree f right)

--  depthVals n tree returns a list containing all of the
--  labels associated with nodes at depth n
--  if n < 0, return empty list
--  i.e.    depthVals 1 tree2 returns [13,20]
--          depthVals 2 tree2 returns [12]

depthVals :: Int -> BTree a -> [a]
depthVals n Empty   = []
depthVals n (BNode b left right)
    | n == 1    = [b]
    | n > 1     = depthVals (n-1) left ++ depthVals (n-1) right
    | otherwise = []

--  minValue val tree returns the minimum value that appears in tree
--  if tree is empty, then return val
-- NOTE: method not working

minValue :: Ord a => a -> BTree a -> a
minValue val Empty                  = val
minValue val (BNode b Empty Empty)  = b
minValue val (BNode b left right)   = (minValue left)

--  onPath path tree returns the list of labels encountered
--  by following the path in tree
--  i.e. onPath [Lft, Rght] tree2 returns [8,13,12]
--       onPath path Empty returns []
--  NOTE: method not working

onPath :: Path -> BTree a -> [a]
onPath path Empty               = []
onPath path (BNode b Empty Empty) = []
onPath path (BNode b left right)
    | path == Lft   = [b] ++ (onPath left) ++ (onPath right)
    | path == Rght  = (onPath right) ++ [b] ++ (onPath left)
    | otherwise = [b]