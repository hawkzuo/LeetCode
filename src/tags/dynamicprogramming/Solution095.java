//95. Unique Binary Search Trees II

package tags.dynamicprogramming;

import collectionUtils.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution095 {

    public List<TreeNode> generateTrees(int n) {
        if(n<=0){   return new ArrayList<TreeNode>();}  
        
        List<TreeNode>[] dp = new ArrayList[n+1];
        for(int i=0;i<=n;i++){
            dp[i] = new ArrayList<TreeNode>();
        }        
        dp[0].add(new TreeNode(-1)); 
        dp[1].add(new TreeNode(1));
        
        return gTree(n,dp);       
    }
    
    private List<TreeNode> gTree(int i,List<TreeNode>[] dp){
    	if(dp[i].size() > 0){	return dp[i];}    	
    	
        for(int k=0;k<i;k++){            
            List<TreeNode> lhalf = gTree(k,dp);
            List<TreeNode> rhalf = gTree(i-k-1,dp);            
            for(TreeNode l:lhalf){
            	for(TreeNode r:rhalf){
            		//Construct Tree
            		TreeNode root = new TreeNode(k+1);
            		int offset = k+1;
            		if(k == 0){
            			root.left = null;
            		}else{
            			root.left = clone(l,0);
            		}
            		if(k == i-1){
            			root.right = null;
            		}else{
            			root.right = clone(r,offset);
            		}            		
            		dp[i].add(root);
            	}
            }
        }  	
    	
        return dp[i];
    }
    
    private static TreeNode clone(TreeNode n, int offset) {
        //This function make a deep copy of the given root n with offset 
	    // via recursive call.
    	
    	if (n == null) {
            return null;
        }
        TreeNode node = new TreeNode(n.val + offset);
        node.left = clone(n.left, offset);
        node.right = clone(n.right, offset);
        return node;
    }
    
    
    
}
