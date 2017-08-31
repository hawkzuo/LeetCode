//173. Binary Search Tree Iterator

package tags.breadth_first_search;

import collectionUtils.TreeNode;

import java.util.Stack;

public class BSTIterator_Q173 {

	private Stack<TreeNode> stack = new Stack<TreeNode>();

	public BSTIterator_Q173(TreeNode root) {
	    pushAllNodes(root);
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {
	    return !stack.isEmpty();
	}

	/** @return the next smallest number */
	public int next() {
	    TreeNode minNode = stack.pop();
	    pushAllNodes(minNode.right);
	    return minNode.val;
	}

	private void pushAllNodes(TreeNode node) {
	    while(node != null)
	    {
	        stack.push(node);
	        node = node.left;
	    }
	}

}
