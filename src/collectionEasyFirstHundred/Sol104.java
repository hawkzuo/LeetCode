package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/25.
 * Maximum Depth of Binary Tree
 */
public class Sol104 {
    // Idea: Brute-force DFS
    public int maxDepth(TreeNode root) {
        return calculateDepth(root, 0);
    }

    private int calculateDepth(TreeNode cur, int curDepth) {
        if(cur == null) {   return curDepth; }
        return Math.max(calculateDepth(cur.left, curDepth+1), calculateDepth(cur.right, curDepth+1));
    }
}
