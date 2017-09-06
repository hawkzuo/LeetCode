package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/9/6.
 * Binary Tree Paths
 */
public class Sol257 {
    // Idea: Basic operations on List<String> and StringBuilder backtracking
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) {  return result;}

        StringBuilder path = new StringBuilder();

        constructPath(root, path, result);
        return result;
    }

    private void constructPath(TreeNode root, StringBuilder path, List<String> res) {
        if(root.left == null && root.right == null) {
            // Base case
            int prevLength = path.length();
            path.append(root.val);
            res.add(path.toString());
            path.setLength(prevLength);
        } else if(root.left == null) {
            int prevLength = path.length();
            path.append(root.val);
            path.append("->");
            constructPath(root.right, path, res);
            path.setLength(prevLength);
        } else if(root.right == null) {
            int prevLength = path.length();
            path.append(root.val);
            path.append("->");
            constructPath(root.left, path, res);
            path.setLength(prevLength);
        } else {
            int prevLength = path.length();
            path.append(root.val);
            path.append("->");
            int addedLength = path.length();
            constructPath(root.left, path, res);
            path.setLength(addedLength);
            constructPath(root.right, path, res);
            path.setLength(prevLength);
        }
    }



}
