package collectionMedium;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/8/11.
 * Binary Search Tree Iterator
 */
public class Sol173BSTIterator {
    private Deque<TreeNode> stack = new ArrayDeque<>();

    public Sol173BSTIterator(TreeNode root) {
        pushLeft(root);
    }

    /** @return whether we have a next smallest number */
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /** @return the next smallest number */
    public int next() {
        TreeNode minNode = stack.pop();
        pushLeft(minNode.right);
        return minNode.val;
    }

    private void pushLeft(TreeNode node) {
        while(node != null)
        {
            stack.push(node);
            node = node.left;
        }
    }
}
