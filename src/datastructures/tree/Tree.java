package datastructures.tree;

public interface Tree<T extends Comparable<T>> {

	public boolean Search();
	public T Minimum();
	public T Maximum();
	public void Insert(T t);
	public void Delete(T t);
	
	
}
