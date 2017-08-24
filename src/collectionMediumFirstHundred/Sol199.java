package collectionMediumFirstHundred;

import collectionUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/21.
 * Binary Tree Right Side View
 */
public class Sol199 {
    public List<Integer> rightSideView(TreeNode root) {
        // Visit order should be from right to left
        // If BFS, then only record last node for each level

        List<Integer> result = new ArrayList<>();
        if(root == null) {  return result;}
        rightFirstVisit(result, root, 1);
        return  result;
    }

    private void rightFirstVisit(List<Integer> result, TreeNode root, int level) {
        if(result.size() < level) {
            result.add(root.val);
        }
        if(root.right != null) {    rightFirstVisit(result, root.right, level+1); }
        if(root.left != null ) {    rightFirstVisit(result, root.left, level+1); }
    }
}
