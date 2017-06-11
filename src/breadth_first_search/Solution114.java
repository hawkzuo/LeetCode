//114. Flatten Binary Tree to Linked List

package breadth_first_search;

public class Solution114 {

	public Solution114() {
		// TODO Auto-generated constructor stub
	}
    private TreeNode prev=null;
    
    
    public void flatten(TreeNode root) {        
        rlmV(root);        
    }
    
    private void rlmV(TreeNode root){        
        if(root == null){   return;}
        
        rlmV(root.right);
        rlmV(root.left);
        
        if(prev == null){
            prev = root;
        }else{
            root.left=null;
            root.right=prev;
            prev = root;
        }
        
        
    }
}
