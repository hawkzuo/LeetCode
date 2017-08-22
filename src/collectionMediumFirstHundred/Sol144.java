package collectionMediumFirstHundred;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Amos on 2017/8/10.
 * Binary Tree Pre-order Traversal
 */
public class Sol144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        // Idea: pushLeft       this time add to list while pushing
        List<Integer> res = new ArrayList<>();
        if(root == null){	return res;}

        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(stack, root, res);
        while(!stack.isEmpty()) {
            // Must use pop instead of peek
            TreeNode step = stack.pop();
            if(step.right != null) {
                pushLeft(stack, step.right, res);
            }
        }
        return res;
    }

    private void pushLeft(Deque<TreeNode> stack, TreeNode current, List<Integer> res) {
        while(current != null) {
            res.add(current.val);
            stack.push(current);
            current = current.left;
        }
    }



}
