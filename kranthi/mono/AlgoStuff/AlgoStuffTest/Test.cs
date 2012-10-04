using System;
using System.Collections.Generic;
using NUnit.Framework;
using TopMonkeys.AlgoStuff;

namespace TopMonkeys.AlgoStuff.Test
{
	[TestFixture()]
	public class Test
	{
		// Integer Comparer - Ascending
		private class IntAscendingComparer :IComparer<int>
		{
			public int Compare (int x, int y)
			{
				return x - y;
			}
		}

		// Integer Comparer - Descending
		private class IntDescendingComparer :IComparer<int>
		{
			public int Compare (int x, int y)
			{
				return y - x;
			}
		}

		[Test()]
		public void TestSimpleBubbleSortInAscendingOrder ()
		{
			IntAscendingComparer ascendingComparer = new IntAscendingComparer();
			List<int> testList = new List<int>() { 5, 1, 3, 4, 2 };
			List<int> expectedList = new List<int>() { 1, 2, 3, 4, 5 };
			Assert.AreEqual(expectedList, SimpleBubbleSort<int>.Sort(testList, ascendingComparer)); 
		}

		[Test()]
		public void TestSimpleBubbleSortInDescendingOrder ()
		{
			IntDescendingComparer descendingComparer = new IntDescendingComparer();
			List<int> testList = new List<int>() { 5, 1, 3, 4, 2 };
			List<int> expectedList = new List<int>() { 5, 4, 3, 2, 1 };
			Assert.AreEqual(expectedList, SimpleBubbleSort<int>.Sort(testList, descendingComparer)); 
		}
	}
}

