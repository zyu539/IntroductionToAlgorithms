//Chapter 12.1-3: inorder walk without using stack.
//Push all most left chain to stack, then for each element in stack first go right and then keep go left.
public class InorderTreeWalk {
  public static void main(String[] args) {
	  TreeNode n1 = new TreeNode(15);
	  TreeNode n2 = new TreeNode(6);
	  TreeNode n3 = new TreeNode(3);
	  TreeNode n4 = new TreeNode(2);
	  TreeNode n5 = new TreeNode(4);
	  TreeNode n6 = new TreeNode(7);
	  TreeNode n7 = new TreeNode(14);
	  TreeNode n8 = new TreeNode(19);
	  TreeNode n9 = new TreeNode(18);
	  TreeNode n10 = new TreeNode(17);
	  TreeNode n11 = new TreeNode(20);
	  TreeNode n12 = new TreeNode(9);
	  n1.left = n2;
	  n1.right = n9;
	  n2.left = n3;
	  n2.right = n6;
	  n3.left = n4;
	  n3.right = n5;
	  n6.right = n7;
	  n7.left = n12;
	  n9.left = n10;
	  n9.right = n11;
	  inorderWalk(n1);
  }
  
  public static void inorderWalk(TreeNode root) {
	  if (root == null) return;
	  Stack<TreeNode> s = new Stack<>();
	  while (root != null) {
		  s.push(root);
		  root = root.left;
	  }
	  
	  while (!s.isEmpty()) {
		  TreeNode t = s.pop();
		  System.out.println(t.val);
		  if (t.right != null) {
			  t = t.right;
			  while (t != null) {
				  s.push(t);
				  t = t.left;
			  }
		  }
	  }
  }
  
}

class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	
	public TreeNode(int val) {
		this.val = val;
	}
}
