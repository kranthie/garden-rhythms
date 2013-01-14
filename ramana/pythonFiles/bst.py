import math

class Link:
 def __init__(self):
  self.next = None
  self.data = None

class LinkedList:
 def __init__(self):
  self.head = None

 def insert(self, data):
  l = Link()
  l.data = data
  l.next = self.head
  self.head = l

 def printLL(self):
  x = self.head
  while x is not None:
   print x.data
   x = x.next

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

def sortedArrayToBst(a):
 l = len(a)
 if a > 0:
  bst = BST()
  bst.root = Node()
  satbst(bst.root, a, 0, l-1)
  return bst
def satbst(n, a, low, high):
 if low == high:
  n.data = a[low]
  return
 m = (low+high)/2
 n.data = a[m]
 if m > low:
  n.left = Node()
  satbst(n.left, a, low, m-1)
 if m < high:
  n.right = Node()
  satbst(n.right, a, m+1, high)

bst = BST()
bst.insert(4)
bst.insert(7)
bst.insert(3)
bst.insert(1)
bst.insert(0)
print "Inserted 4, 7, 3, 1 and 0 into a BST."
print "Printing in order"
bst.printInOrder()
print "Printing the height"
print bst.height(bst.root)
print "Printing whether or not the tree is balanced"
print bst.isBalanced(bst.root)
print "Inserting a sorted array and trying to obtain a reasonably balanced tree"
a = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
bst = sortedArrayToBst(a)
print "Printing in order"
bst.printInOrder()
print "Level 1 (root)"
print bst.root.data
print "Level 2"
print bst.root.left.data
print bst.root.right.data
print "Level 3"
print bst.root.left.left.data
print bst.root.left.right.data
print bst.root.right.left.data
print bst.root.right.right.data
print "Level 4"
print bst.root.left.right.right.data
print bst.root.right.left.right.data
print bst.root.right.right.right.data

print "Testing linked list"
ll = LinkedList()
ll.insert(4)
ll.insert(5)
ll.insert(7)
ll.printLL()

def bstToLinkedLists(t):
 lls = []
 ll = LinkedList()
 ll.insert(t.root)
 lls.append(ll)
 while True:
  x = LinkedList()
  y = lls[-1]
  z = y.head
  while z is not None:
   if z.data.left is not None:
    x.insert(z.data.left)
   if z.data.right is not None:
    x.insert(z.data.right)
   z = z.next
  if x.head is not None:
   lls.append(x)
  else:
   break
 return lls

lls = bstToLinkedLists(bst)
print "Printing Linked Lists"
for i in lls:
 x = i.head
 while x is not None:
  print x.data.data,
  x = x.next
 print