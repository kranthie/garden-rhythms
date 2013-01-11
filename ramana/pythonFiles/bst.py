import math

class Node:
 def __init__(self):
  self.left = None
  self.right = None
  self.data = None

class BST:
 def __init__(self):
  self.root = None

 def insert(self, d):
  if self.root is None:
   self.root = Node()
   self.root.data = d
  else:
   done = False
   x = self.root
   while not done:
    if x.data > d:
     y = x.left
     if y is None:
      x.left = Node()
      x.left.data = d
      done = True
     else:
      x = y
    else:
     y = x.right
     if y is None:
      x.right = Node()
      x.right.data = d
      done = True
     else:
      x = y

 def printInOrder(self):
  x = self.root
  if x is not None:
   self.printIO(x)

 def printIO(self, x):
  if x is not None:
   self.printIO(x.left)
   print x.data
   self.printIO(x.right)

 def height(self, n):
  if n is None:
   return 0
  l = self.height(n.left)
  r = self.height(n.right)
  if l > r:
   return l+1
  else:
   return r+1

 def isBalanced(self, n):
  if n is None:
   return True
  if int(math.fabs(self.height(n.left) - self.height(n.right))) > 1:
   return False
  return self.isBalanced(n.left) and self.isBalanced(n.right)

bst = BST()
bst.insert(4)
bst.insert(7)
bst.insert(3)
bst.insert(1)
bst.insert(0)

bst.printInOrder()
print bst.height(bst.root)
print bst.isBalanced(bst.root)