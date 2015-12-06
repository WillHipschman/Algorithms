package datastructures.tree;

public class TreeNode {

	//we could genericize Tree, but that makes the algorithms harder to read
	public Object data; 
	
	private TreeNode parent;
	private TreeNode leftChild;
	private TreeNode next;
	private TreeNode prev;
	
	public TreeNode(Object data)
	{
		this.data = data;
	}
	
	public TreeNode GetParent()
	{
		return this.parent;
	}
	
	public void SetParent(TreeNode node)
	{
		this.parent = node;
	}
	
	public TreeNode GetLeft()
	{
		return this.leftChild;
	}
	
	public void SetLeftChild(TreeNode node)
	{
		this.leftChild = node;
	}
	
	public TreeNode Next()
	{
		return this.next;
	}
	
	public void SetNext(TreeNode node)
	{
		this.next = node;
	}
	
	public TreeNode Prev()
	{
		return this.prev;
	}
	
	public void SetPrev(TreeNode node)
	{
		this.prev = node;
	}
}
