//144. Binary Tree Preorder Traversal

package tags.breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution144 {

	public Solution144() {
		// TODO Auto-generated constructor stub
	}
    public List<Integer> preorderTraversal(TreeNode root) {
        
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null){	return res;}
    	
    	Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    	stack.push(root);	res.add(root.val);
    	boolean down = true;
    	
    	while(!stack.isEmpty()){
    		
    		TreeNode cur = stack.peek();
    		if(down){
    			if(cur.left != null){
    				stack.push(cur.left);
    				res.add(cur.left.val);
    				down = true;
    			}else{
    				down=false;
    				//This line is redunant and it causes problems
    				//stack.pop();
    			}   			
    			
    		}else{
    			if(cur.right == null){
    				stack.pop();
    				down = false;
    			}else{
    				stack.pop();
    				stack.push(cur.right);res.add(cur.right.val);
    				down = true;
    			}    			
    			
    		}    		
    		
    	}
    	return res;
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
