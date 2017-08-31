package collectionACompanies.microsoft;

import collectionUtils.TreeNode;

public class Solution437 {
	private int total;
	public Solution437() {
		// TODO Auto-generated constructor stub
	}
	
//Hardcore method	
//I knew there should be a better method to solve this, as when you go down from the root, you actually view all the 
//possible combinations
	
    private void countPathSum(TreeNode root, int sum, int now){
        if(root==null)
            return ;
        //'now' 
        now += root.val;
        //leaf node
        
           if(sum==now){
               total ++;
           } 
        
        countPathSum(root.left,sum,now);
        countPathSum(root.right,sum,now);

    }
    private void recur(TreeNode root, int sum){
        if(root == null){	return;}   	   	
    	if(root.left != null){
        	countPathSum(root.left,sum,0);        	        	
        }
        if(root.right != null){
        	countPathSum(root.right,sum,0);        	
        }     	
    	recur(root.left,sum);
    	recur(root.right,sum);    	    	
    }
    
    
    
    public int pathSum(TreeNode root, int sum) {
        this.total = 0;
        if(root==null)
            return this.total;        
        countPathSum(root,sum,0);
        //Since it can start with non-root, add recursion.
        recur(root,sum);
         
        return this.total;
        
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution437 s = new Solution437();
		
		TreeNode n1 = new TreeNode(10);
		TreeNode n2 = new TreeNode(5);
		TreeNode n3 = new TreeNode(-3);
		TreeNode n4 = new TreeNode(3);
		TreeNode n5 = new TreeNode(2);
		TreeNode n6 = new TreeNode(11);
		TreeNode n7 = new TreeNode(3);
		TreeNode n8 = new TreeNode(-2);
		TreeNode n9 = new TreeNode(1);
		
		n1.left = n2; n1.right = n3;
		n2.left = n4; n2.right = n5;  n3.right = n6;
		n4.left = n7; n4.right = n8; n5.right = n9;
		
		int k= s.pathSum(n1, 8);
		
		TreeNode k1 = new TreeNode(1);
		TreeNode k2 = new TreeNode(2);
		TreeNode k3 = new TreeNode(3);
		TreeNode k4 = new TreeNode(4);
		TreeNode k5 = new TreeNode(5);		
		k1.right=k2; k2.right=k3; k3.right=k4; k4.right=k5;
		
		int kk= s.pathSum(k1, 3);
		
		
		System.out.print(k);
	}

}
