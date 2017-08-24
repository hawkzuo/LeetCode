package collectionMediumFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/10.
 * Binary Tree Upside Down
 */
public class Sol156 {
    private TreeNode prev=null;
    private TreeNode newRoot =null;
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if(root == null){   return null;}
        Left_Visit(root);
        root.left=null;	    root.right=null;
        return newRoot;
    }

    private void Left_Visit(TreeNode root){
        // Base case
        if(root == null){
            return;
        }
        Left_Visit(root.left);
        if(prev == null){
            // First node encountered
            prev = root;
            newRoot = root;
        }else{
            // UpsideDown
            prev.left = root.right;
            prev.right = root;
            prev = root;
        }
    }
}
