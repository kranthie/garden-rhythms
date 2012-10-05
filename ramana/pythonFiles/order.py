def bubbleSort(array, compare):
  sorted = False
  l = len(array)
  while sorted == False:
    sorted = True
    for i in range(1, l):
      if compare(array[i-1], array[i]) > 0:
        sorted = False
        swap(array, i, i-1)

def selectionSort(array, compare):
  l = len(array)
  for i in range(l):
    minIndex = i
    for j in range(i+1, l):
      if compare(array[minIndex], array[j]) > 0:
        minIndex = j
    swap(array, minIndex, i)

def insertionSort(array, compare):
  l = len(array)
  for i in range(1, l):
    sortedUpTo = i-1
    if compare(array[i-1], array[i]) > 0:
      swap(array, i, sortedUpTo)
      for j in range(sortedUpTo, 0, -1):
        if compare(array[j-1], array[j]) <= 0:
          break
        else:
          swap(array, j, j-1)

def mergeSort(array, compare):
  b = mergeSortInternal(array, 0, len(array)-1, compare)
  del(array[:])
  array.extend(b)

def mergeSortInternal(array, start, end, compare):
  if start >= end:
    return [array[start]]
  mid = (start + end) / 2
  return merge(mergeSortInternal(array, start, mid, compare), mergeSortInternal(array, mid+1, end, compare), compare)

def merge(a, b, compare):
  la = len(a)
  lb = len(b)
  c = []
  i = 0
  j = 0
  while (True):
    if compare(a[i], b[j]) > 0:
      c.append(b[j])
      j = j + 1
      if j == lb:
        c.extend(a[i:])
        break
    else:
      c.append(a[i])
      i = i + 1
      if i == la:
        c.extend(b[j:])
        break
  return c
def swap(array, i, j):
  temp = array[i]
  array[i] = array[j]
  array[j] = temp

def compare(i, j):
  return i - j

a = [3, 7, 2, 5, 4, 8, 1, 9, 10, 6]
mergeSort(a, compare)
for i in a:
  print i
 