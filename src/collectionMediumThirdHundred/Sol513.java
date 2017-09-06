package collectionMediumThirdHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/9/6.
 * Find Bottom Left Tree Value
 */
public class Sol513 {
    // Idea: Just In-order visiting will work
    // Note the fact that DFS visiting will always visit leftmost node the first time it touches this level
    private int globalDepthMax = -1;
    private int result;

    public int findBottomLeftValue(TreeNode root) {
        // Leftmost must be the first of its level to be DFS visited via in-order
        inorderVisit(root, 0);
        return result;
    }

    private void inorderVisit(TreeNode root, int depth) {
        if(root == null) {  return; }
        inorderVisit(root.left, depth+1);
        if(depth > globalDepthMax) {
            // Only first time depth greater than previous max will trigger this function
            globalDepthMax = depth;
            result = root.val;
        }
        inorderVisit(root.right, depth+1);
    }
}
