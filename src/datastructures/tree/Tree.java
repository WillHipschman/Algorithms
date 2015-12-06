package datastructures.tree;

public interface Tree {

	public TreeNode Search(int key);
	public void Insert(TreeNode t);
	public void Delete(TreeNode t);
	public TreeNode Root();
}
