package datastructures.tree;

public interface Heap<T extends Comparable<T>> {

	T Head();
	int Size();
	T Parent(int index);
	T LeftChild(int index);
	T RightChild(int index);
}
