//404. Sum of Left Leaves

package tags.breadth_first_search;

import collectionUtils.TreeNode;

public class Solution404 {

    private TreeNode prev=null;
    private int total=0;
    
    public int sumOfLeftLeaves(TreeNode root) {
        IV(root);
        return total;
    }
    
    private void IV(TreeNode root){
        if(root == null){
            return;
        }
        if(prev == null){
            prev = root;
        }else{
            if(root.left == null && root.right == null && prev.left == root){
                total+=root.val;
            }
            prev = root;
        }
        
        IV(root.left);
        IV(root.right);
        
        
    }

}
