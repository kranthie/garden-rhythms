import random

class Node:
 def __init__(self):
  self.left = None
  self.right = None
  self.parent = None
  self.data = None
  self.name = None

class BinaryTree:
 def __init__(self):
  self.root = None

 def insert(self, d):
  if self.root is None:
   self.root = Node()
   self.root.data = d
   self.root.name = "root"
   return
  x = self.root
  y = x.right
  if random.random() < .5:
   y = x.left
  while y is not None:
   if random.random() < .5:
    x = y
    y = y.left
   else:
    x = y
    y = y.right
  if x.left is not None:
   x.right = Node()
   x.right.data = d
   x.right.name = x.name + ".right"
   x.right.parent = x
  else:
   x.left = Node()
   x.left.data = d
   x.left.name = x.name + ".left"
   x.left.parent = x

 def printIO(self, x):
  if x is not None:
   self.printIO(x.left)
   print x.data,
   print x.name
   self.printIO(x.right)

 def pathLength(self, n):
  #print n.data
  if n == self.root:
   return 0
  return 1 + self.pathLength(n.parent)

 def lowestCommonAncestor(self, a, b):
  la = self.pathLength(a)
  lb = self.pathLength(b)
  l = 0
  if la > lb:
   l = la - lb
   while l > 0:
    a = a.parent
    l -= 1
  else:
   l = lb - la
   while l > 0:
    b = b.parent
    l -= 1
  while a is not b:
   a = a.parent
   b = b.parent
  return a

bt = BinaryTree()
for i in range(300):
 bt.insert(i)
#bt.printIO(bt.root)
print bt.pathLength(bt.root.left.left.right)
x = bt.lowestCommonAncestor(bt.root.left.right.left, bt.root.left.right.right.left)
print x.data,
print x.name