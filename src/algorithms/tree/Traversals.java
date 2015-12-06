package algorithms.tree;

import datastructures.tree.BinaryTree;
import datastructures.tree.BinaryTreeNode;
import util.commands.Command;

public class Traversals 
{
	public static void InOrderTraversal(BinaryTree tree, Command<BinaryTreeNode> action)
	{
		VisitInOrder((BinaryTreeNode)tree.root, action);
	}
	
	public static void PreOrderTraversal(BinaryTree tree, Command<BinaryTreeNode> action)
	{
		VisitPreOrder((BinaryTreeNode)tree.root, action);
	}
	
	public static void PostOrderTraversal(BinaryTree tree, Command<BinaryTreeNode> action)
	{
		VisitPostOrder((BinaryTreeNode)tree.root, action);
	}
	
	private static void VisitInOrder(BinaryTreeNode root, Command<BinaryTreeNode> action)
	{
		VisitInOrder((BinaryTreeNode)root.leftChild, action);
		action.Run(root);
		VisitInOrder((BinaryTreeNode)root.rightChild, action);		
	}
	
	// The children can be visited in any order, as long as the root is visited first
	private static void VisitPreOrder(BinaryTreeNode root, Command<BinaryTreeNode> action)
	{
		action.Run(root);
		VisitInOrder((BinaryTreeNode)root.leftChild, action);
		VisitInOrder((BinaryTreeNode)root.rightChild, action);		
	}
	
	// The children can be visited in any order, as long as the root is visited last
	private static void VisitPostOrder(BinaryTreeNode root, Command<BinaryTreeNode> action)
	{
		VisitInOrder((BinaryTreeNode)root.leftChild, action);
		VisitInOrder((BinaryTreeNode)root.rightChild, action);	
		action.Run(root);
	}
}
