package sorting;

import algorithms.array.Array;
import data.Heap;

public class Sorting 
{	
	public static void CountingSort(int[] array, int numberOfDistinctElementTypes)
	{
		int[] counts = new int[numberOfDistinctElementTypes];
		
		for(int i = 0; i < array.length; i++)
		{
			counts[array[numberOfDistinctElementTypes]] ++;
		}
		
		int k = 0;
		for(int i = 0; i < array.length; i ++)
		{
			for(int j = 0;  j < counts[k]; j ++)
			{
				array[i] = counts[k];
			}
			
			k ++;
		}
	}
	
	
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
		Comparable[] left = new Comparable[middle - start];
		Comparable[] right = new Comparable[end - middle];
		
		int j = 0;
		for(int i = start; i < middle; i++)
		{
			left[j] = array[i];
			j++;
		}
		
		j = 0;
		for(int i = middle; i < end; i++)
		{
			right[j] = array[i];
			j++;
		}
		
		int i = 0;
		j = 0;
		Comparable leftVal, rightVal;
		while(i + j < end - start)
		{
			if (i > left.length)
			{
				leftVal = Integer.MAX_VALUE;
			}
			else
			{
				leftVal = left[i];
			}
			
			if (i > right.length)
			{
				rightVal = Integer.MAX_VALUE;
			}
			else
			{
				rightVal = right[i];
			}
			
			if (leftVal.compareTo(rightVal) == 1)
			{
				array[start + i + j] = right[j];
				j++;
			}
			else
			{
				array[start + i + j] = left[i];
				i++;
			}
		}
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
