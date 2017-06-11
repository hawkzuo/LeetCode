//98. Validate Binary Search Tree

package breadth_first_search;

public class Solution098 {
    private TreeNode prev=null;
	public boolean isValidBST(TreeNode root) {
	
	    return inorderVisit(root);
	}
	private boolean inorderVisit(TreeNode root){
	    if(root == null){
	        return true;
	    }
	    boolean lhalf = inorderVisit(root.left);
	    if(lhalf == false) {    return false; }
	    if(prev == null){
	        prev = root;
	        
	    }
	    else if(root.val <= prev.val){
	        return false;
	    }else{
	        prev = root;
	    }
	    boolean rhalf = inorderVisit(root.right); 
	    return lhalf && rhalf;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
