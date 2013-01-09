class Queue:
 def __init__(self):
  self.popper = []
  self.pusher = []

 def pushToPop(self):
  while len(self.pusher) != 0:
   self.popper.append(self.pusher.pop())

 def insert(self, a):
  self.pusher.append(a)

 def remove(self):
  if len(self.popper) == 0:
   self.pushToPop()
  return self.popper.pop()

 def isEmpty(self):
  return len(self.popper) == 0 and len(self.pusher) == 0

q = Queue()
q.insert(10)
q.insert(9)
print q.remove()
q.insert(8)
q.insert(7)
print q.remove()
print q.remove()
print q.pusher
print q.popper