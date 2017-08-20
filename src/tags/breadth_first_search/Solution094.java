//94. Binary Tree Inorder Traversal

package tags.breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class Solution094 {

	public Solution094() {
		// TODO Auto-generated constructor stub
	}
    public List<Integer> inorderTraversal(TreeNode root) {
        
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null){	return res;}
    	
    	Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
    	stack.push(root);	
    	boolean down = true;
    	
    	while(!stack.isEmpty()){
    		
    		TreeNode cur = stack.peek();
    		if(down){
    			if(cur.left != null){
    				stack.push(cur.left);
    				
    				down = true;
    			}else{
					res.add(cur.val);
					stack.pop();    				   				
    				if(cur.right != null){
    					stack.push(cur.right);
    					down = true;
    				}else{
    					//This time this can be done inside the downward process
    					down = false;
    				}
    			}   			
    			
    		}else{
				res.add(cur.val);    				
				stack.pop();
    			if(cur.right == null){
    				down = false;
    			}else{
    				stack.push(cur.right);
    				down = true;
    			}    			    			
    		}    		    		
    	}
    	return res;    	
    	
    	
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(2);
		TreeNode n3 = new TreeNode(3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		TreeNode n9 = new TreeNode(9);
		TreeNode n19 = new TreeNode(19);
		
		n6.left=n2;	n6.right=n7;
		n2.left=n1; n2.right=n4; n7.right=n9;
		n1.right=n19; n4.left=n3;n4.right=n5;n9.left=n8;
		
		List<Integer> res = new ArrayList<Integer>();
		Solution094 s = new Solution094();
		res = s.inorderTraversal(n6);
		System.out.print(res);
		
		
	}    
    
    
    
    
}
