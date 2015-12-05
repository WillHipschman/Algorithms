package data;

public class DisjointSetForest<T> {
	
	public DisjointSet<T> MakeSet(T val)
	{
		return new DisjointSet<T>(val);
	}
	
	public DisjointSetForest<T> FindSet(T val)
	{
		return null;
	}
	
	public DisjointSetForest<T> Union(T set1, T set2)
	{
		return null;
	}
}
