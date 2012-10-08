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

if __name__ == '__main__':
  unittest.main()
 
