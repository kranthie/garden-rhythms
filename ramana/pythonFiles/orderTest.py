import unittest
import order

class TestSortingFunctions(unittest.TestCase):
  def setUp(self):
    self.a = [3, 7, 2, 5, 4, 8, 1, 9, 10, 6]

  def compare(self, i, j):
    return i - j

  def testBubbleSort(self):
    order.bubbleSort(self.a, self.compare)
    self.assertEqual(self.a, range(1, 11))

  def testSelectionSort(self):
    order.selectionSort(self.a, self.compare)
    self.assertEqual(self.a, range(1, 11))

  def testInsertionSort(self):
    order.insertionSort(self.a, self.compare)
    self.assertEqual(self.a, range(1, 11))

  def testMergeSort(self):
    order.mergeSort(self.a, self.compare)
    self.assertEqual(self.a, range(1, 11))

  def testHeapSort(self):
    order.heapSort(self.a, self.compare)
    self.assertEqual(self.a, range(1, 11))

  def testQuickSort(self):
    order.quickSort(self.a, self.compare)
    self.assertEqual(self.a, range(1, 11))

  def testMergeMultipleSortedArrays(self):
    arrays = []
    arrays.append( [1, 6, 9, 23 ])
    arrays.append([2, 16, 19, 24, 25 ])
    arrays.append([4, 5, 12, 21, 22 ])
    arrays.append([3, 7, 11, 17, 18 ])
    arrays.append([8, 10, 13, 14, 15, 20 ])
    arrays = order.mergeMultipleSortedArrays(arrays, self.compare)
    self.assertEqual(arrays, range(1, 26))

if __name__ == '__main__':
  unittest.main()
 
