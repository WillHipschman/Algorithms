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

	
	public void IncreaseValue(int index, Comparable value) throws Exception
	{
		if(!isIndexWithinArray(index))
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(value.compareTo(array[index]) < 1)
		{
			throw new Exception("New value must be larger than old value");
		}
		
		array[index] = value;
		
		int parentIndex = this.parentIndex(index);
		while(index > 0 && array[index].compareTo(array[parentIndex]) == 1)
		{
			Array.Swap(array, index, parentIndex);
			index = parentIndex;
			parentIndex = this.parentIndex(index);
		}
	}
	
	public Comparable RemoveHead() throws IndexOutOfBoundsException
	{
		if(!isIndexWithinArray(0))
		{
			throw new IndexOutOfBoundsException();
		}
		
		Comparable head = this.Head();
		
		array[0] = array[this.Size() - 1];
		this.size = this.Size() - 1;
		this.maxHeapify(0);
		
		return head;
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
