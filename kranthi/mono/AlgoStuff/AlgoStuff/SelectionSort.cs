using System;
using System.Collections.Generic;

namespace TopMonkeys.AlgoStuff
{
	public class SelectionSort<T>
	{
		public static List<T> Sort (List<T> list, IComparer<T> comparer)
		{
			for (int i = 0; i < list.Count; i++)
			{
				int minIndex = i;
				for (int j = i + 1; j < list.Count; j++) {
					if( comparer.Compare(list[j], list[minIndex]) > 0)
					{
						minIndex = j;
					}
				}
				if( minIndex != i)
				{
					Swap(list, i, minIndex);
				}
			}
			return list;
		}

		private static void Swap (List<T> list, int i, int j)
		{
			T temp = list[i];
			list[i] = list[j];
			list[j] = temp;
		}
	}
}

