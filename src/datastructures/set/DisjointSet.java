package datastructures.set;

public class DisjointSet<T>
{
	public T val;
	public DisjointSet<T> parent;
	public int rank = 0;
	
	public DisjointSet(T val)
	{
		this.val = val;
		this.parent = this;
	}
}