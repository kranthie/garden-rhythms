using System;
using System.Collections.Generic;

namespace TopMonkeys.AlgoStuff
{
	public class InsertionSort<T>
	{
		public static List<T> Sort (List<T> list, IComparer<T> comparer)
		{
			for (int i = 0; i < list.Count; i++)
			{
				T item = list[i];
				int index = i;
				while (index > 0 && comparer.Compare(list[index - 1], item) > 0 )
				{
					list[index] = list[index - 1];
					index--;
				}
				list[index] = item;
			}
			return list;
		}		
	}
}

