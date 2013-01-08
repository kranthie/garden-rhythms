def insertionSort (a):
 for j in range(1, len(a)):
  key=a[j]
  #Insert A[j] into the sorted sequence A[1. . j-1]. 
  i=j-1
  while i>=0 and a[i]>key:
   a[i+1]=a[i]
   i=i-1
  a[i+1]=key

a = [3, 7, 4, 2, 1, 9, 5, 10, 8, 6]
insertionSort(a)
for i in a:
 print i