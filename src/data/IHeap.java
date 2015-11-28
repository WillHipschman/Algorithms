package data;

public interface IHeap<T extends Comparable> {

	T Head();
	int Size();
	T Parent(int index);
	T LeftChild(int index);
	T RightChild(int index);
}
