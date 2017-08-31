//102. Binary Tree Level Order Traversal

package tags.breadth_first_search;

import collectionUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution102 {

	public Solution102() {
		// TODO Auto-generated constructor stub
	}
	public List<List<Integer>> levelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        res.get(height).add(root.val);
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root == null){	return res;}
    	
    	Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.add(root);
    	
    	while(!queue.isEmpty()){
    		List<Integer> s = new ArrayList<Integer>();
    		int len = queue.size();
    		//Must use a local variable
    		for(int i=0;i<len;i++){
    			TreeNode op = queue.remove();
    			s.add(op.val);
	    		if(op.left != null){
	    			queue.add(op.left);
	    		}
	    		if(op.right != null){
	    			queue.add(op.right);
	    		}    			    			
    		}
	    	res.add(s);
    	}    	
    	
    	return res;
    }	
    public List<List<Integer>> levelOrderSlow(TreeNode root) {
        
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root == null){	return res;}
    	
    	Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    	TreeNode helper = new TreeNode(0);
    	helper.left = root;
    	queue.add(helper);
    	
    	while(true){
    		Deque<TreeNode> step = new ArrayDeque<TreeNode>();
	    	while(!queue.isEmpty()){   		
	    		TreeNode op = queue.remove();
	    		if(op.left != null){
	    			step.add(op.left);
	    		}
	    		if(op.right != null){
	    			step.add(op.right);
	    		}    		
	    	}
	    	if(step.isEmpty()){
	    		break;
	    	}
	    	List<Integer> s = new ArrayList<Integer>();
	    	while(!step.isEmpty()){
	    		TreeNode op = step.remove();
	    		s.add(op.val);
	    		queue.add(op);
	    	}
	    	res.add(s);
    	}    	
    	
    	return res;
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
