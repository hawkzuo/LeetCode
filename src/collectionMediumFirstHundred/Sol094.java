package collectionMediumFirstHundred;

import collectionUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Amos on 2017/7/27.
 * Binary Tree Inorder Traversal
 */
public class Sol094 {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){	return res;}

        Deque<TreeNode> stack = new ArrayDeque<>();
        pushLeft(root, stack);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            res.add(cur.val);
            pushLeft(cur.right, stack);
        }
        return res;
    }

    private void pushLeft(TreeNode root, Deque<TreeNode> stack) {
        while(root != null) {
            stack.push(root);
            root = root.left;
        }
    }

    public List<Integer> inorderTraversalOld(TreeNode root) {

        List<Integer> res = new ArrayList<>();
        if(root == null){	return res;}

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);
        boolean down = true;

        // This solution mimic the process of performing Inorder Traversal
        while(!stack.isEmpty()){
            TreeNode cur = stack.peek();
            if(down){
                // Left has a node => add to stack and keep going down
                if(cur.left != null){
                    stack.push(cur.left);
                    down = true;
                }else{
                    // Leftmost, add to list and tries to move to right
                    res.add(cur.val);
                    stack.pop();
                    if(cur.right != null){
                        //res.add(cur.val);
                        //stack.pop();
                        // Right isn't null, add to stack and keep going down
                        stack.push(cur.right);
                        down = true;
                    }else{
                        //This time this can be done inside the downward process
                        //res.add(cur.val);
                        //stack.pop();
                        // No node, return upwards
                        down = false;
                    }
                }

            }else{
                // During upwards process, always add to list first
                res.add(cur.val);
                stack.pop();
                if(cur.right == null){
                    //res.add(cur.val);
                    //stack.pop();
                    down = false;
                }else{
                    //res.add(cur.val);
                    //stack.pop();
                    stack.push(cur.right);
                    down = true;
                }
            }
        }
        return res;
    }
}
