package collectionMediumFirstHundred;

import collectionUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/7/27.
 * Unique Binary Search Trees II
 */
public class Sol095 {
    public List<TreeNode> generateTrees(int n) {
        if(n<=0){   return new ArrayList<TreeNode>();}

        List<TreeNode>[] dp = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new TreeNode(-1));
        dp[1].add(new TreeNode(1));

        return generateTree(n,dp);
    }

    private List<TreeNode> generateTree(int i, List<TreeNode>[] dp){
        if(dp[i].size() > 0){	return dp[i];}

        for(int k=0;k<i;k++){
            // These two lines are due to BST property: left < middle, right > middle
            // DP table always stores value starts with 1, so have to perform offset changes0
            List<TreeNode> leftHalf = generateTree(k,dp);
            List<TreeNode> rightHalf = generateTree(i-k-1,dp);

            for(TreeNode l:leftHalf){
                for(TreeNode r:rightHalf){
                    //Construct Tree
                    TreeNode root = new TreeNode(k+1);
                    // Value of offset is very important:  offset = root.val
                    int offset = k+1;

                    // Deep copy left/right half tree with offset value
                    if(k == 0){
                        root.left = null;
                    }else{
                        root.left = clone(l,0);
                    }
                    if(k == i-1){
                        root.right = null;
                    }else{
                        root.right = clone(r,offset);
                    }

                    // Save this value to DP table
                    dp[i].add(root);
                }
            }
        }
        return dp[i];
    }

    private static TreeNode clone(TreeNode n, int offset) {
        if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
}
