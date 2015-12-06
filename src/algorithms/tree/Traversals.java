package algorithms.tree;

import datastructures.tree.BinaryTree;
import datastructures.tree.BinaryTreeNode;
import datastructures.tree.GenericTree;
import datastructures.tree.TreeNode;
import util.commands.Command;

public class Traversals 
{
	// O(N)
	public static void PreOrderTraversal(GenericTree tree, Command<TreeNode> action)
	{
		VisitPreOrder(tree.root, action);
	}
	
	// O(N)
	public static void PostOrderTraversal(GenericTree tree, Command<TreeNode> action)
	{
		VisitPostOrder(tree.root, action);
	}
	
	// O(N)
	public static void InOrderTraversal(BinaryTree tree, Command<BinaryTreeNode> action)
	{
		VisitInOrder((BinaryTreeNode)tree.root, action);
	}
	
	// O(N)
	public static void PreOrderTraversal(BinaryTree tree, Command<BinaryTreeNode> action)
	{
		VisitPreOrder((BinaryTreeNode)tree.root, action);
	}
	
	public static void PostOrderTraversal(BinaryTree tree, Command<BinaryTreeNode> action)
	{
		VisitPostOrder((BinaryTreeNode)tree.root, action);
	}
	
	// O(N)
	private static void VisitInOrder(BinaryTreeNode root, Command<BinaryTreeNode> action)
	{
		VisitInOrder((BinaryTreeNode)root.leftChild, action);
		action.Run(root);
		VisitInOrder((BinaryTreeNode)root.rightChild, action);		
	}
	
	// The children can be visited in any order, as long as the root is visited first
	private static void VisitPreOrder(TreeNode root, Command<TreeNode> action)
	{
		if(root != null)
		{
			action.Run(root);
			
			TreeNode next = root.GetLeft();
			
			while(next != null)
			{
				VisitPostOrder(next, action);
				next = next.Next();
			}	
		}	
	}
	
	// The children can be visited in any order, as long as the root is visited last
	private static void VisitPostOrder(TreeNode root, Command<TreeNode> action)
	{
		if(root != null)
		{
			TreeNode next = root.GetLeft();
			
			while(next != null)
			{
				VisitPostOrder(next, action);
				next = next.Next();
			}	
			
			action.Run(root);
		}
	}
	
	// The children can be visited in any order, as long as the root is visited first
	private static void VisitPreOrder(BinaryTreeNode root, Command<BinaryTreeNode> action)
	{
		if(root != null)
		{
			action.Run(root);
			VisitPreOrder((BinaryTreeNode)root.leftChild, action);
			VisitPreOrder((BinaryTreeNode)root.rightChild, action);		
		}
	}
	
	// The children can be visited in any order, as long as the root is visited last
	private static void VisitPostOrder(BinaryTreeNode root, Command<BinaryTreeNode> action)
	{
		if(root != null)
		{
			VisitPostOrder((BinaryTreeNode)root.leftChild, action);
			VisitPostOrder((BinaryTreeNode)root.rightChild, action);	
			action.Run(root);
		}
	}
}
