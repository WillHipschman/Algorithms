package datastructures.tree;

import algorithms.tree.Traversals;
import util.commands.FindTreeNode;

public class GenericTree implements Tree{

	public TreeNode root;
	
	public GenericTree()
	{
		
	}

	@Override
	public TreeNode Search(int key) {
		return null;
	}
	
	public boolean Contains(TreeNode toFind) {
		
		FindTreeNode action = new FindTreeNode(toFind);
		Traversals.PreOrderTraversal(this, action);
		return action.Found;
	}

	@Override
	public void Insert(TreeNode t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void Delete(TreeNode t) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public TreeNode Root() {
		return this.root;
	}
}
