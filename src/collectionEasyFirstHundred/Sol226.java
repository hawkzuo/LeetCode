package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/9/2.
 * Invert Binary Tree
 */
public class Sol226 {
    // Idea: Seems confusing at first, dig deeper you'll find pattern
    // Just revert children and then revert self
    // Quite like post-order traversal
    public TreeNode invertTree(TreeNode root) {
        if(root == null){   return null;}
        reverseLR(root);
        return root;
    }

    private void reverseLR(TreeNode root){
        if(root.left!=null){
            reverseLR(root.left);
        }
        if(root.right!=null){
            reverseLR(root.right);
        }
        // Perform root
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
    }
}
