package datastructures.tree;

public class BinaryTreeNode extends TreeNode{
	
	public BinaryTreeNode leftChild;
	public BinaryTreeNode rightChild;
	public int key;
	
	public BinaryTreeNode(Object data)
	{
		super(data);
	}
	
	@Override
	public BinaryTreeNode GetParent()
	{
		return (BinaryTreeNode)super.GetParent();
	}
	
	@Override
	public void SetParent(TreeNode newParent)
	{
		if(newParent instanceof BinaryTreeNode)
		{
			super.SetParent(newParent);
		}
	}
}
