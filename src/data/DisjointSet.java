package data;

public class DisjointSet<T>
{
	public T val;
	public DisjointSet<T> parent;
	
	public DisjointSet(T val)
	{
		this.val = val;
		this.parent = this;
	}
}