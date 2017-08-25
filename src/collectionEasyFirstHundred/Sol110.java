package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/25.
 * Balanced Binary Tree
 */
public class Sol110 {
    // Idea: DFS to find out all heights for each leaf and by definition to judge
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
