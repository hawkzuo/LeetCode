package collectionMediumSecondHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/22.
 * Kth Smallest Element in a BST
 */
public class Sol230 {
    // Idea: Just brute-force In-order visiting

    private int result;
    private int counter;
    public int kthSmallest(TreeNode root, int k) {
        counter = 0;
        inorderVisit(root,k);
        return result;
    }
    private void inorderVisit(TreeNode root, int k){
        if(root == null){   return;}
        inorderVisit(root.left,k);
        counter++;
        if(counter == k){
            result = root.val;
            return;
        }
        inorderVisit(root.right,k);
    }
}
