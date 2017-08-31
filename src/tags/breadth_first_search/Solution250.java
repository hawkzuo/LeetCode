//250. Count Univalue Subtrees

package tags.breadth_first_search;

import collectionUtils.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution250 {

	
	public Solution250() {
		// TODO Auto-generated constructor stub
	}	
	
	private int sum = 0;

    public int countUnivalSubtrees(TreeNode root) {
        int[] count = new int[1];
        helper(root, count);
        return count[0];
    }
    
    private boolean helper(TreeNode node, int[] count) {
        if (node == null) {
            return true;
        }
        boolean left = helper(node.left, count);
        boolean right = helper(node.right, count);
        if (left && right) {
            if (node.left != null && node.val != node.left.val) {
                return false;
            }
            if (node.right != null && node.val != node.right.val) {
                return false;
            }
            count[0]++;
            return true;
        }
        return false;
    }
    public int countUnivalSubtreesOld(TreeNode root) {
        
    	sum=0;
    	helperOld(root);
    	return sum;
    }	
	
    private long helperOld(TreeNode root){    	
    	if(root == null){	return Integer.MAX_VALUE+1;}
    	
    	long l =helperOld(root.left);
    	long r =helperOld(root.right);
    	
    	if(l == (Integer.MAX_VALUE+1) && r == (Integer.MAX_VALUE+1)){
    		sum++;
    		return root.val;
    	}else if(l == (Integer.MAX_VALUE+1) && r != (Integer.MAX_VALUE+1)){
    		if(r == root.val){
    			sum++;
    			return r;
    		}else{
    			return Integer.MIN_VALUE-1;
    		}
    		
    	}else if(l != (Integer.MAX_VALUE+1) && r == (Integer.MAX_VALUE+1)){
    		if(l == root.val){
    			sum++;
    			return l;
    		}else{
    			return Integer.MIN_VALUE-1;
    		}    		
    		
    	}else{
    		if(l == root.val && r == root.val){
    			sum+=2;
    			return l;
    		}else if(l != root.val && r == root.val){
    			if(l != Integer.MIN_VALUE-1){
    			sum++;}
    			return Integer.MIN_VALUE-1;
    		}else if(l == root.val && r != root.val){
    			if(r != Integer.MIN_VALUE-1){
    			sum++;}
    			return Integer.MIN_VALUE-1;
    		}else{
    			return Integer.MIN_VALUE-1;
    		}    		
    	}
    	    	
    	
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
