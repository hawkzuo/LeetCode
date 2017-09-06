package collectionEasySecondHundred;

import collectionUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/9/6.
 * Find Mode in Binary Search Tree
 */
public class Sol501 {
    private Integer prev = null;
    private int count = 0;
    private int prevMax = -1;
    private List<Integer> result;

    // Idea: Use in-order visiting will use O(1) counter space, and O(res) space is unavoidable for correctly deliver
    //      results
    public int[] findMode(TreeNode root) {
        if(root == null) {  return new int[0];}
        result = new ArrayList<>();
        inorder(root);

        if(count > prevMax) {
            // One element
            int[] res = new int[1];
            res[0] = prev;
            return res;
        } else if(count == prevMax) {
            result.add(prev);
            int[] res = new int[result.size()];
            for(int i=0;i<result.size();i++) {
                res[i] = result.get(i);
            }
            return res;
        } else {
            int[] res = new int[result.size()];
            for(int i=0;i<result.size();i++) {
                res[i] = result.get(i);
            }
            return res;
        }
    }

    private void inorder(TreeNode root) {
        if(root == null) {  return; }
        inorder(root.left);

        if(prev == null) {
            prev = root.val;
            count = 1;
        } else {
            if(root.val != prev) {
                if(count > prevMax) {
                    result = new ArrayList<>();
                    result.add(prev);
                    prevMax = count;
                } else if(count == prevMax) {
                    result.add(prev);
                }
                count = 1;
                prev = root.val;
            } else {
                count++;
            }
        }

        inorder(root.right);
    }
}
