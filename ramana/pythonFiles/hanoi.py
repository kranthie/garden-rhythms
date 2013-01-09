def hanoi(source, spare, destination, n):
 if n == 0:
  return
 hanoi(source, destination, spare, n-1)
 destination.append(source.pop())
 hanoi(spare, source, destination, n-1)

a = [3, 2, 1]
b = []
c = []
hanoi(a, b, c, 3)
print c
print a
print b
d = [3, 2, 1]
print c == d
