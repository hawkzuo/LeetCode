//99. Recover Binary Search Tree

package tags.breadth_first_search;

import collectionUtils.TreeNode;

public class Solution099 {
    private TreeNode e1=null;
    private TreeNode  e2=null;
    private TreeNode prev=new TreeNode(Integer.MIN_VALUE);
	public void recoverTree(TreeNode root) {
	    inorderVisit(root);
	    int temp = e1.val;
	    e1.val = e2.val;
	    e2.val = temp;
	    
	}
	private void inorderVisit(TreeNode root){
	    if(root == null){
	        return;
	    }
	    inorderVisit(root.left);
	    if(e1 == null && root.val < prev.val){
	        e1 = prev; prev = root;
	        //Add this line can solve the situations like [2,1,3]
	        e2 = root; 
	    }else if(e1 != null && root.val < prev.val){
	        e2 = root; prev = root;
	    }else{
	        prev = root;
	    }
	    inorderVisit(root.right);   
	}

    
    


	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
