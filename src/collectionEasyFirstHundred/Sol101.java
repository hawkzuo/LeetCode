package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/25.
 * Symmetric Tree
 */
public class Sol101 {
    public boolean isSymmetric(TreeNode root) {
        return root == null ||
                root.left == null && root.right == null ||
                checkSym(root.left, root.right);
    }

    private boolean checkSym(TreeNode left, TreeNode right) {
        return (left == null && right == null) ||
                (left != null && right != null &&
                left.val == right.val &&
                checkSym(left.left, right.right) && checkSym(left.right, right.left));
    }
}
