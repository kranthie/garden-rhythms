using System;
using System.Collections.Generic;

namespace TopMonkeys.AlgoStuff
{
	public class SimpleBubbleSort<T>
	{
		public static List<T> Sort (List<T> list, IComparer<T> comparer)
		{
			bool swapped = true;
			while (swapped == true)
			{
				swapped = false;
				for (int i = 1; i < list.Count; i++)
				{
					if(comparer.Compare(list[i - 1], list[i]) > 0)
					{
						Swap(list, i-1, i);
						swapped = true;
					}
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

