package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/25.
 * Path Sum
 */
public class Sol112 {
    // Idea: BFS or DFS is okay, by nature DFS is easy to come up with
    public boolean hasPathSum(TreeNode root, int sum) {
        return root != null && checkPathSum(root, sum, 0);
    }

    private boolean checkPathSum(TreeNode root, int sum, int now){
        if(root==null)
            return false;
        //leaf node
        if(root.left==null && root.right==null){
            return sum == now + root.val;
        }
        return checkPathSum(root.left, sum, now + root.val) || checkPathSum(root.right, sum, now + root.val);
    }
}
