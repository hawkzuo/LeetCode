//257. Binary Tree Paths

package tags.breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class Solution257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if(root==null){	return ans;}
        StringBuilder s = new StringBuilder();
        constructPath(root,ans,s);
        return ans;
    }
    
    
    
    private void constructPath(TreeNode root, List<String> res, StringBuilder sb){
        int len = sb.length();
        if(root.left == null && root.right == null){
           sb.append(Integer.toString(root.val));
           res.add(sb.toString());
           sb.setLength(len);
        }else if(root.left != null && root.right == null){
        	sb.append(Integer.toString(root.val));
        	sb.append("->");
        	constructPath(root.left,res,sb);
        	sb.setLength(len);
        }else if(root.left == null && root.right != null){
        	sb.append(Integer.toString(root.val));
        	sb.append("->");
        	constructPath(root.right,res,sb);
        	sb.setLength(len);
        }else{
        	sb.append(Integer.toString(root.val));
        	sb.append("->");
        	constructPath(root.left,res,sb);
        	constructPath(root.right,res,sb);
        	sb.setLength(len);
        }                
    }
    public static void main(String[] args) {
    	Solution257 s = new Solution257();
		TreeNode n1 = new TreeNode(1);
		TreeNode n2 = new TreeNode(-2);
		TreeNode n3 = new TreeNode(-3);
		TreeNode n4 = new TreeNode(4);
		TreeNode n5 = new TreeNode(5);
		TreeNode n6 = new TreeNode(-6);
		TreeNode n7 = new TreeNode(7);
		TreeNode n8 = new TreeNode(8);
		
		n1.left=n2;	n1.right=n3;n2.left=n4;n2.right=n6;n3.right=n5;n4.left=n7;
		
    	List<String> res = s.binaryTreePaths(n1);
    	
    	System.out.println(res);
    	
    }
}
