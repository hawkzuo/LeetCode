//103. Binary Tree Zigzag Level Order Traversal

package breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution103 {

	public Solution103() {
		// TODO Auto-generated constructor stub
	}
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
    	List<List<Integer>> res = new ArrayList<List<Integer>>();
    	if(root == null){	return res;}
    	
    	Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
    	queue.add(root);
    	boolean rtol = true;
    	
    	while(!queue.isEmpty()){
    		List<Integer> s = new ArrayList<Integer>();
    		int len = queue.size();
    		//Must use a local variable
    		for(int i=0;i<len;i++){
    			TreeNode op = queue.remove();
    			if(rtol){
    			s.add(op.val);}
    			else{	s.add(0,op.val);}
	    		if(op.left != null){
	    			queue.add(op.left);
	    		}
	    		if(op.right != null){
	    			queue.add(op.right);
	    		}    			    			
    		}
	    	res.add(s);
	    	rtol = !rtol;
    	}    	    	
    	return res;        

    }
	public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        levelHelper(res, root, 0);
        return res;
    }
    
    public void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<Integer>());
        }
        if(height % 2 == 0){        
        	res.get(height).add(root.val);
        }else{
        	res.get(height).add(0,root.val);
        }
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }    
}
