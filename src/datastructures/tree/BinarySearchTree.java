package datastructures.tree;


public class BinarySearchTree extends BinaryTree{
	
	
	
	@Override
	public TreeNode Search(int key) 
	{	
		return this.Search(this.Root(), key);
	}

	@Override
	public void Insert(TreeNode t) 
	{
		if(t instanceof BinaryTreeNode)
		{
			BinaryTreeNode toInsert = (BinaryTreeNode)t;
			BinaryTreeNode node = this.Root();
			BinaryTreeNode parent = null;
			
			while(node != null)
			{
				parent = node;
				if(toInsert.key < node.key)
				{
					node = node.leftChild;
				}
				else
				{
					node = node.rightChild;
				}
			}
			
			toInsert.SetParent(parent);
			
			if(parent == null)
			{
				this.root = toInsert;
			} else
			{
				if(toInsert.key < parent.key)
				{
					parent.leftChild = toInsert;
				}
				else
				{
					parent.rightChild = toInsert;
				}
			}
		}
	}

	@Override
	public void Delete(TreeNode t) 
	{
		if(t instanceof BinaryTreeNode)
		{
			BinaryTreeNode toDelete = (BinaryTreeNode)t;

			// If both left and right children are NULL
			// then we will just execute the first if,
			// which will set the node to null.
			if(toDelete.leftChild == null)
			{
				Transplant(toDelete, toDelete.rightChild);
			}
			else if(toDelete.rightChild == null)
			{
				Transplant(toDelete, toDelete.leftChild );
			}
			else
			{
				//We know there is a right child, so we don't need to call this.Successor
				BinaryTreeNode successor = Minimum(toDelete.rightChild);
				if(successor.GetParent() != toDelete)
				{
					Transplant(successor, successor.rightChild);
					successor.rightChild = toDelete.rightChild;
					successor.rightChild.SetParent(successor);
				}
				
				Transplant(toDelete, successor);
				successor.leftChild = toDelete.leftChild;
				successor.leftChild.SetParent(successor);
			}
		}
	}
	
	@Override
	public BinaryTreeNode Root() {
		return (BinaryTreeNode)super.Root();
	}
	
	

	// O(LogN)
	// assumes distinct keys
	public BinaryTreeNode Successor(BinaryTreeNode n)
	{
		if(n.rightChild != null)
		{
			return this.Minimum(n.rightChild);
		}
		
		// If keys are distinct, then our parnet and our parents right child
		// may have the same value as us. We would need to return the lowest ancestor
		// of n whose left child is also an ancestor of n
		return n.GetParent();
	}
	
	public BinaryTreeNode Predecessor(BinaryTreeNode n){
		
		if(n.leftChild != null)
		{
			return this.Maximum(n.leftChild);
		}
		
		// If keys are distinct, then our parnet and our parents right child
		// may have the same value as us. We would need to return the lowest ancestor
		// of n whose right child is also an ancestor of n
		return n.GetParent();
	}
	
	public BinaryTreeNode Maximum()
	{
		return this.Maximum(this.Root());
	}
	
	public BinaryTreeNode Minimum()
	{
		return this.Minimum(this.Root());
	}
	
	private BinaryTreeNode Maximum(BinaryTreeNode node)
	{
		while(node != null)
		{
			if(node.rightChild == null)
			{
				return node;
			}
			node = node.rightChild;
		}
		
		return null;
	}
	
	private BinaryTreeNode Minimum(BinaryTreeNode node)
	{
		while(node != null)
		{
			if(node.leftChild == null)
			{
				return node;
			}
			node = node.leftChild;
		}
		
		return null;
	}
	
	private void Transplant(BinaryTreeNode toBeReplaced, BinaryTreeNode newVal)
	{
		if(toBeReplaced.GetParent() == null)
		{
			this.root = newVal;
		}
		else if(toBeReplaced == ((BinaryTreeNode)toBeReplaced.GetParent()).leftChild)
		{
			((BinaryTreeNode)toBeReplaced.GetParent()).leftChild = newVal;
		}
		else
		{
			((BinaryTreeNode)toBeReplaced.GetParent()).rightChild = newVal;
		}
		
		if(newVal != null)
		{
			newVal.SetParent(toBeReplaced.GetParent());
		}
	}
	
	// O(LogN)
	private TreeNode Search(BinaryTreeNode root, int key) 
	{	
		if(root != null)
		{
			if(key == root.key)
			{
				return this.Root();
			}
			else if(key < root.key)
			{
				return Search(root.leftChild, key);
			}
			else
			{
				return Search(root.rightChild, key);
			}
		}
		
		return null;
	}

}
