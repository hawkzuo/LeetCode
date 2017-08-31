//110. Balanced Binary Tree

package tags.breadth_first_search;

import collectionUtils.TreeNode;

public class Solution110 {

    private boolean balanced = true;
    
    public boolean isBalanced(TreeNode root) {
        if(root == null){   return true;}
        markHeight(root);
        return balanced;
    }
    
    private int markHeight(TreeNode root){
        if(root == null){   return -1;}        
        int lh = markHeight(root.left);
        int rh = markHeight(root.right);        
        if(Math.abs(lh-rh)>1){  balanced = false;}
        return Math.max(lh,rh)+1;
    }

}
