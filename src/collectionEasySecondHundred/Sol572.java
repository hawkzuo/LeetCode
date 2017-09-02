package collectionEasySecondHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/9/2.
 * Subtree of Another Tree
 */
public class Sol572 {
    // Idea: DFS on s && matching t then DFS on t
    public boolean isSubtree(TreeNode s, TreeNode t) {
        if (s == null || t == null) {
            return false;
        }

        boolean result = false;
        if (s.val == t.val) {
            // Start a DFS on t
            result = checkSame(s, t);
        }
        return result || isSubtree(s.left, t) || isSubtree(s.right, t);
    }

    private boolean checkSame(TreeNode s, TreeNode t) {
        if(s == null || t == null) {
            return s==null && t==null;
        }
        return s.val == t.val && checkSame(s.left, t.left) && checkSame(s.right, t.right);
    }
}
