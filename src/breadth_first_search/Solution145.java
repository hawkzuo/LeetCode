//145. Binary Tree Postorder Traversal

package breadth_first_search;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

public class Solution145 {

	public Solution145() {
		// TODO Auto-generated constructor stub
	}
    public List<Integer> postorderTraversal2s(TreeNode root) {
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
    public List<Integer> postorderTraversal(TreeNode root) {
    	List<Integer> res = new ArrayList<Integer>();
    	if(root == null){	return res;}
    	
    	Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
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
    				//This line is redunant and it causes problems
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
	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
		Solution145 s = new Solution145();
		res = s.postorderTraversal2s(n6);
		System.out.println(res);
		String str="";
		for(Integer num:res){
			str+="["+Integer.toString(num)+"]";
		}
		System.out.println(str);
	}

}
