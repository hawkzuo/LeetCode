package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/9/10.
 * Sum of Left Leaves
 */
public class Sol404 {
    // Idea: Inorder-Visiting and at the visiting part, only left leaves' values will be added
    private TreeNode prev=null;
    private int total=0;

    public int sumOfLeftLeaves(TreeNode root) {
        inorderTraverse(root);
        return total;
    }

    private void inorderTraverse(TreeNode root){
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
        inorderTraverse(root.left);
        inorderTraverse(root.right);
    }
}
