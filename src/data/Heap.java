package data;

import algorithms.array.Array;

public class Heap implements IHeap<Comparable>{
	
	private Comparable[] array;
	private int size = 0;
	
	public Heap(Comparable[] array)
	{
		this.size = array.length;
		this.array = array;
	}

	@Override
	public Comparable Head() {
		return isIndexWithinArray(0) ? array[0] : null;
	}

	@Override
	public int Size() {
		return size;
	}

	@Override
	public Comparable Parent(int index) {
		int parentIndex = parentIndex(index);
		return isIndexWithinArray(parentIndex) ? array[parentIndex] : null;
	}

	@Override
	public Comparable LeftChild(int index) {
		int leftChildIndex = leftIndex(index);
		return isIndexWithinArray(leftChildIndex) ? array[leftChildIndex] : null;
	}

	@Override
	public Comparable RightChild(int index) {
		int rightChildIndex = rightIndex(index);
		return isIndexWithinArray(rightChildIndex) ? array[rightChildIndex] : null;
	}
	
	public static void HeapSort(Comparable[] array)
	{
		Heap heap = new Heap(array);
		for(int i = array.length; i >= 1; i--)
		{
			Array.Swap(array, 0, i);
			heap.size = heap.size - 1;
			heap.maxHeapify(1);
		}
	}
	
	private void BuildMaxHeap(Comparable array)
	{
		for(int i = Size() / 2; i >= 0; i--)
		{
			maxHeapify(i);;
		}
	}
	
	///logn run time
	private void maxHeapify(int index)
	{
		int largest = index;
		int left = leftIndex(index);
		int right = rightIndex(index);
		
		if(isIndexWithinArray(left) && array[left].compareTo(array[index]) == 1)
		{
			largest = left;
		}
		else if(isIndexWithinArray(right) && array[right].compareTo(array[index]) == 1)
		{
			largest = right;
		}
		
		if(largest != index)
		{
			Array.Swap(array, largest, index);
			maxHeapify(largest);
		}
	}
	
	private int leftIndex(int index)
	{
		return 2 * index;
	}
	
	private int rightIndex(int index)
	{
		return 2 * index + 1;
	}
	
	private int parentIndex(int index)
	{
		return index / 2;
	}
	
	private boolean isIndexWithinArray(int index)
	{
		return index > 0 && index < this.Size();
	}
}
