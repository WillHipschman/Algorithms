package sorting;

import algorithms.array.Array;
import data.Heap;

public class Sorting 
{
	///
	/// Worst: 		O(nlogn)
	/// Best: 		O(nlogn)
	/// Average: 	O(nlogn)
	/// Properties:
	///		In Place
	///		Not Stable
	public static void HeapSort(Comparable[] array)
	{
		Heap.HeapSort(array);;
	}
	
	///
	/// Worst: 		O(nlogn)
	/// Best: 		O(nlogn)
	/// Average: 	O(nlogn)
	/// Properties:
	///		In Place
	///		Not Stable
	public static void MergeSort(Comparable[] array)
	{
		MergeSort(array, 0, array.length);
	}
	
	private static void MergeSort(Comparable[] array, int start, int end)
	{
		if(start == end)
		{
			return;
		}
		
		int pivot = (start + end) / 2;
		
		MergeSort(array, start, pivot);
		MergeSort(array, pivot, end);
		
		Merge(array, start, pivot, end);
	}
	
	///
	/// Worst: 		O(n^2)
	/// Best: 		O(n^2)
	/// Average: 	O(n^2)
	/// Properties:
	///		In Place
	///		Not Stable (depends on min/max implementation)
	public static void SelectionSort(Comparable[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			int maxIndex = Array.Max(array, 0, i);
			Array.Swap(array, i, maxIndex);
		}
	}
	
	///
	/// Worst: 		O(n^2)
	/// Best: 		O(n)
	/// Average: 	O(n^2)
	/// Space:		O(nlogn)
	/// Properties:
	///		In Place
	///		Stable
	public static void BubbleSort(Comparable[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = i; j < array.length; j++)
			{
				if(array[i].compareTo(array[j]) == 1)
				{
					Array.Swap(array, i, j);
				}
			}
		}
	}
	
	///
	/// Worst: 		O(n^2)
	/// Best: 		O(n)
	/// Average: 	O(n^2)
	/// Space:		O(nlogn)
	/// Properties:
	///		In Place
	///		Not Stable (depends on Insert implementation)
	public static void InsertionSort(Comparable[] array)
	{
		for(int i = 0; i < array.length; i++)
		{
			for(int j = 0; j < i; j++)
			{
				if(array[i].compareTo(array[j]) == -1)
				{
					Insert(array, i, j);
					break;
				}
			}
		}
	}
	
	/// merges array[start:middle] and array[middle:end]
	/// start <= middle < end and array[start:middle] and array[middle:end] ar ein sorted order
	private static void Merge(Comparable[] array, int start, int middle, int end)
	{
		
		
		
	}
	
	private static void Insert(Comparable[] array, int oldPos, int newPos)
	{
		Comparable valueToMove = array[oldPos];
		
		for(int i = oldPos; i > newPos; i--)
		{
			array[i] = array[i - 1];
		}
		
		array[newPos] = valueToMove;
	}
}
