package collectionMediumSecondHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/22.
 * Count Complete Tree Nodes
 */
public class Sol222 {
    public int countNodes(TreeNode root) {
        //Divide and Conquer
        if(root == null){   return 0;}
        int maxH = findL(root);
        int internalH = findL(root.right);

        // Based on the internal node's height, either add all left nodes or add all right nodes
        // And then recursive calculating
        if(maxH == internalH + 1) {
            return (1<<(maxH))+countNodes(root.right);
        } else {
            return (1<<(maxH-1))+countNodes(root.left);
        }
    }
    private int findL(TreeNode root){
        if(root == null){
            return -1;
        }
        return findL(root.left)+1;
    }
}
