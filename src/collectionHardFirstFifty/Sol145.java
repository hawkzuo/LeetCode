package collectionHardFirstFifty;

import collectionUtils.TreeNode;

import java.util.*;

/**
 * Created by Amos on 2017/8/30.
 * Binary Tree Postorder Traversal
 */
public class Sol145 {
    // Idea: Three ways to solve this problem
    // Key is to know the flow how post-order works
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){	return res;}

        Deque<TreeNode> stack = new ArrayDeque<>();
        pushRight(res, root, stack);

        while(!stack.isEmpty()){
            TreeNode step = stack.pop();
            pushRight(res, step.left, stack);
        }
        Collections.reverse(res);

        return res;
    }

    private void pushRight(List<Integer> res, TreeNode cur, Deque<TreeNode> stack) {
        while(cur != null) {
            res.add(cur.val);
            stack.push(cur);
            cur = cur.right;
        }
    }

    public List<Integer> postorderTraversalMethod2(TreeNode root) {
        LinkedList<Integer> ans = new LinkedList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;

        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pop();
            ans.addFirst(cur.val);
            if (cur.left != null) {
                stack.push(cur.left);
            }
            if (cur.right != null) {
                stack.push(cur.right);
            }
        }
        return ans;
    }

    public List<Integer> postorderTraversalOld(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null){	return res;}

        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.push(root);	res.add(root.val);
        boolean down = true;

        while(!stack.isEmpty()){

            TreeNode cur = stack.peek();
            if(down){
                if(cur.right != null){
                    stack.push(cur.right);
                    res.add(cur.right.val);
                    down = true;
                }else{
                    down=false;
                    //This line is redundant and it causes problems
                    //stack.pop();
                }

            }else{
                if(cur.left == null){
                    stack.pop();
                    down = false;
                }else{
                    stack.pop();
                    stack.push(cur.left);res.add(cur.left.val);
                    down = true;
                }

            }

        }
        Collections.reverse(res);
        return res;
    }
}
