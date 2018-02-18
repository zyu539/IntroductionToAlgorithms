//Chapter 12.2 Successor
public class TreeSuccessor {
  public static void main(String[] args) {
	  //treeSuccessor(n1);
  }
  
  public static int TreeSuccessor(TreeNode t) {
    //if have subtree on right, find the least element in subtree
	  if (t.right != null) {
		  t = t.right;
		  while (t.left != null) {
			  t = t.left;
		  }
		  return t.val;
	  }
    //if not subtree on right, find the lowest parent that if on the right side of it.
	  TreeNode k = t.p;
	  while (k != null && k.right == t) {
		  t = k;
		  k = t.p;
	  }
	  return k.val;
  }
  
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	TreeNode p;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
