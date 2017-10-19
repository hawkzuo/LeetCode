package collectionMediumSecondHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/10/18.
 * Lowest Common Ancestor of a Binary Tree
 */
public class Sol236 {
    // Do not store the parent tree, instead only update when come across 'p' or 'q'
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null) {
            return null;
        }
        if(root == p || root == q) { return root;}
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        if(left != null && right != null) {
            return root;
        } else if(left != null) {
            // This indicates that either the LCA has already been found, or it's on one side
            return left;
        } else if(right != null) {
            return right;
        } else {
            return null;
        }
    }
}
