//106. Construct Binary Tree from Inorder and Postorder Traversal

package tags.breadth_first_search;

public class Solution106 {

	public Solution106() {
		// TODO Auto-generated constructor stub
	}
    public TreeNode buildTree(int[] inorder, int[] postorder) {
    	int len = postorder.length;
    	if(len < 1){ return null;}
    	TreeNode root = new TreeNode(postorder[postorder.length-1]);
    	if(len == 1){ return root;}
    	//TreeNode root= 
    	buildT(root,postorder,inorder,0,len,0,len);	    
    	return root;
    }
    
    private void buildT(TreeNode root, int[] po, int[] in, int ib, int ie, int pb, int pe){
    	    	
    	//root.val = po[pe-1];
    	int pos_i = checkValue(ib,ie,po[pe-1],in);
    	int pos_p = pos_i + pb - ib;
    	
    	if(pos_p - pb ==1){
    		//Only 1 node left at left
    		//Create this node and return
    		root.left = new TreeNode(po[pos_p-1]);
    	}else if(pos_p - pb <= 0){ 
    		//The left is null set it to null and return
    		root.left = null;
    	}else{
    		//The left subtree has >=2 elements recursively call this func.
    		root.left = new TreeNode(po[pos_p-1]);
    		buildT(root.left,po,in,ib,pos_i,pb,pos_p);
    	}
    	
    	if(pe -1 - pos_p == 1){
    		//Only 1 node left at right
    		//Create this node and return
    		root.right = new TreeNode(po[pe-2]);
    	}else if(pe -1 - pos_p <=0){
    		//The right is null set it to null and return
    		root.right = null;
    	}else{
    		//The right subtree has >=2 elements recursively call this func.
    		root.right = new TreeNode(po[pe-2]);
    		buildT(root.right,po,in,pos_i+1,ie,pos_p,pe-1);
    	}    	   	
    	
    }
    
    private int checkValue(int lower, int upper, int tar,int [] arr){
    	if(lower <0 || upper > arr.length)    	{return -10;}
    	for(int i=lower;i<upper;i++){
    		if(tar == arr[i]){
    			return i;
    		}
    	}    	
    	return -10;
    }    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution106 s = new Solution106();
		int[] inorder = {1,2,3,4,5,6,7,8,9};
		int[] postorder = {1,3,5,4,2,9,8,7,6};
		
		s.buildTree(inorder, postorder);
	}    
    
}
