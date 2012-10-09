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

def heapSort(array, compare):
  buildHeap(array, compare)
  size = len(array)
  for i in range(size):
    size -= 1
    swap(array, 0, size)
    heapify(array, 0, compare, size)

def buildHeap(array, compare):
  size = len(array)
  for i in range(size / 2 - 1, -1, -1):
    heapify(array, i, compare, size)

def heapify(array, i, compare, size):
  l = left(i)
  r = right(i)
  smallest = i
  if l < size and compare(array[i], array[l]) < 0:
    smallest = l
  if r < size and compare(array[smallest], array[r]) < 0:
    smallest = r
  if i != smallest:
    swap(array, smallest, i)
    heapify(array, smallest, compare, size)

def left(i):
  return 2*i + 1

def right(i):
  return 2*i + 2

def quickSort(array, compare):
  quickSortInternal(array, 0, len(array)- 1, compare)

def quickSortInternal(array, start, end, compare):
  if start >= end:
    return
  p = partition(array, start, end, compare)
  quickSortInternal(array, start, p-1, compare)
  quickSortInternal(array, p+1, end, compare)

def partition(array, start, end, compare):
  p = start-1
  for i in range(start, end):
    if compare(array[i], array[end]) < 0:
      p += 1
      swap(array, i, p)
  p += 1
  swap(array, p, end)
  return p

def swap(array, i, j):
  temp = array[i]
  array[i] = array[j]
  array[j] = temp
