package util.commands;

import datastructures.tree.TreeNode;

public class FindTreeNode implements Command<TreeNode> {

	private TreeNode treeNodeToFind;
	
	public boolean Found = false;
	
	public FindTreeNode(TreeNode toFind)
	{
		this.treeNodeToFind = toFind;
	}
	
	@Override
	public void Run(TreeNode other)
	{
		if (this.treeNodeToFind == other)
		{
			this.Found = true;
		}
	}
}
