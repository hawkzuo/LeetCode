package scatter;

import collectionUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

/*
 * Created by Amos on 10/15/17.
 * Longest Univalue Path
 */
public class Sol687 {

    private int maxCount = 0;

    public int longestUnivaluePath(TreeNode root) {

        if(root == null) {  return 0; }

        Map<TreeNode, Integer> maxSingleSide = new HashMap<>();

        postVisit(root, maxSingleSide);
        return maxCount - 1;

    }

    private void postVisit(TreeNode root, Map<TreeNode, Integer> maxSingleSide) {
        if(root == null) {
            return;
        }
        postVisit(root.left, maxSingleSide);
        postVisit(root.right, maxSingleSide);

        if(root.left == null && root.right == null) {
            maxSingleSide.put(root, 1);
            maxCount = Math.max(maxCount, 1);
        } else if(root.left == null) {
            if(root.val == root.right.val) {
                int rightMost = maxSingleSide.get(root.right);
                maxSingleSide.put(root, 1+rightMost);
                maxCount = Math.max(maxCount, 1+rightMost);
            } else {
                maxSingleSide.put(root, 1);
                maxCount = Math.max(maxCount, 1);
            }

        } else if(root.right == null) {
            if(root.val == root.left.val) {
                int leftMost = maxSingleSide.get(root.left);
                maxSingleSide.put(root, 1+ leftMost);
                maxCount = Math.max(maxCount, 1+leftMost);
            } else {
                maxSingleSide.put(root, 1);
                maxCount = Math.max(maxCount, 1);
            }
        } else {
            // Some cases here
            if( root.val == root.right.val && root.val == root.left.val) {
                int rightMost = maxSingleSide.get(root.right);
                int leftMost = maxSingleSide.get(root.left);
                maxCount = Math.max(maxCount, 1+rightMost+leftMost);
                maxSingleSide.put(root, 1+Math.max(leftMost, rightMost));

            } else if(root.val == root.right.val) {
                int rightMost = maxSingleSide.get(root.right);
                maxSingleSide.put(root, 1+rightMost);
                maxCount = Math.max(maxCount, 1+rightMost);
            } else if(root.val == root.left.val) {
                int leftMost = maxSingleSide.get(root.left);
                maxSingleSide.put(root, 1+leftMost);
                maxCount = Math.max(maxCount, 1+leftMost);
            } else {
                maxSingleSide.put(root, 1);
                maxCount = Math.max(maxCount, 1);
            }
        }


    }



}
