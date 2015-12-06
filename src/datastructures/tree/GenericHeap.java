package datastructures.tree;

import algorithms.array.Array;

public class GenericHeap<T extends Comparable<T>> implements Heap<T>{
	
	private T[] array;
	private int size = 0;
	private int compareVal;
	
	public GenericHeap(T[] array, boolean maxHeap)
	{
		this.size = array.length;
		this.array = array;
		compareVal = maxHeap ? 1 : -1;
	}
	
	//let an augmentation of a value be greater if it's a max heap and less if it's a min heap
	public void AugmentValue(int index, T value) throws Exception
	{
		if(!isIndexWithinArray(index))
		{
			throw new IndexOutOfBoundsException();
		}
		
		if(value.compareTo(array[index]) != compareVal)
		{
			throw new Exception("New value must be an augmentation of the original value");
		}
		
		array[index] = value;
		
		int parentIndex = this.parentIndex(index);
		while(index > 0 && array[index].compareTo(array[parentIndex]) == compareVal)
		{
			Array.Swap(array, index, parentIndex);
			index = parentIndex;
			parentIndex = this.parentIndex(index);
		}
	}
	
	public T RemoveHead() throws IndexOutOfBoundsException
	{
		if(!isIndexWithinArray(0))
		{
			throw new IndexOutOfBoundsException();
		}
		
		T head = this.Head();
		
		array[0] = array[this.Size() - 1];
		this.size = this.Size() - 1;
		this.maxHeapify(0);
		
		return head;
	}
	
	@Override
	public T Head() {
		return isIndexWithinArray(0) ? array[0] : null;
	}

	@Override
	public int Size() {
		return size;
	}

	@Override
	public T Parent(int index) {
		int parentIndex = parentIndex(index);
		return isIndexWithinArray(parentIndex) ? array[parentIndex] : null;
	}

	@Override
	public T LeftChild(int index) {
		int leftChildIndex = leftIndex(index);
		return isIndexWithinArray(leftChildIndex) ? array[leftChildIndex] : null;
	}

	@Override
	public T RightChild(int index) {
		int rightChildIndex = rightIndex(index);
		return isIndexWithinArray(rightChildIndex) ? array[rightChildIndex] : null;
	}
	
	public static <T extends Comparable<T>> void HeapSort(T[] array)
	{
		GenericHeap<T> heap = new GenericHeap<T>(array, true);
		for(int i = array.length; i >= 1; i--)
		{
			Array.Swap(array, 0, i);
			heap.size = heap.size - 1;
			heap.maxHeapify(1);
		}
	}
	
	/// O(logN)
	private void maxHeapify(int index)
	{
		int root = index;
		int left = leftIndex(index);
		int right = rightIndex(index);
		
		if(isIndexWithinArray(left) && array[left].compareTo(array[index]) == compareVal)
		{
			root = left;
		}
		else if(isIndexWithinArray(right) && array[right].compareTo(array[index]) == compareVal)
		{
			root = right;
		}
		
		if(root != index)
		{
			Array.Swap(this.array, root, index);
			maxHeapify(root);
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
