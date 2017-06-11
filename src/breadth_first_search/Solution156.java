//156. Binary Tree Upside Down

package breadth_first_search;

public class Solution156 {
	    private TreeNode prev=null;
	    private TreeNode nroot=null;
	public TreeNode upsideDownBinaryTree(TreeNode root) {
	    if(root == null){   return null;}
	    in_V(root);
	    root.left=null;	root.right=null;
	    return nroot;
	}
	
	private void in_V(TreeNode root){
	    
		if(root == null){   
	    	return;
	    }
	    //Actually this time the right visit is redundant
		//So leave it.
	    in_V(root.left);
	    
	    if(prev == null){
	        prev = root;
	        nroot = root;
	    }else{
	        
	        if(root.right !=null){
	            prev.left=root.right;
	            
	        }else{
	            prev.left=null;
	        }
	        prev.right=root;
	        prev=root;
	    }
	
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);

		//n1.left=n2; n1.right=n3;
		//n2.left=n4;n2.right=n5;
		//n4.left=n6;n4.right=n7;
		//n6.left=n8;n6.right=n9;
		n1.left=n2;n2.left=n4;
		
		
		Solution156 s = new Solution156();
		TreeNode res = s.upsideDownBinaryTree(n1);
		System.out.print(res);
		
		
	} 
}
