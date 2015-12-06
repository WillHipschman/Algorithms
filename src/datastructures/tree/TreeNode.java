package datastructures.tree;

public class TreeNode {

	//we could genericize Tree, but that makes the algorithms harder to read
	public Object data; 
	public TreeNode parent;
	
	public TreeNode(Object data)
	{
		this.data = data;
	}
}
