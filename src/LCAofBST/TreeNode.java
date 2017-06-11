package LCAofBST;

public class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;
	public TreeNode(int x) {
		// TODO Auto-generated constructor stub

		val=x;
	}
	
	
	
	//For testing use
	public TreeNode(int x, TreeNode l, TreeNode r){
		val=x;
		left=l;
		right=r;
	}
	public String toString(){
		return "Node"+val;
	}

}
