//107. Binary Tree Level Order Traversal II

package breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Solution107 {

	public Solution107() {
		// TODO Auto-generated constructor stub
	}
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        
    	List<List<Integer>> res = new LinkedList<List<Integer>>();
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
    		//List can be accessed by index, but doesn't have the addFirst or addLast method
    		//Makes List more like array than a LinkedList
    		//Even though you know LinkedList has a addFirst() method, you still cannot
    		//use it as res.addFirst(), due to the dynamic calling mechanism of Java
    		//For res is only regarded as a list, the reason res has addFirst() is because the 
    		//LinkedList also implemented the Deque<E> class
	    	res.add(0,s);
    	}    	
    	
    	return res;    	
    	

    }
}
