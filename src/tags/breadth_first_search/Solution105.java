//105. Construct Binary Tree from Preorder and Inorder Traversal

package tags.breadth_first_search;

public class Solution105 {

	public Solution105() {
		// TODO Auto-generated constructor stub
	}
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        
    	int len = preorder.length;
    	int[] pindex = new int[1];	pindex[0] = 0;    	
    	//TreeNode root= 
    			return buildT(pindex,preorder,inorder,0,len-1);	
    	//return root;   	
    }
    private TreeNode buildT(int[] pi, int[] pre, int[] in, int begin, int end){
    	if(begin > end){	return null;}
    	int val = pre[pi[0]++];    	
    	TreeNode root = new TreeNode(val);    	
    	int pos = checkValue(begin,end,val,in);    	
    	root.left = buildT(pi,pre,in,begin,pos-1);
    	root.right = buildT(pi,pre,in,pos+1,end);    	
    	return root;
    }
     
    private int checkValue(int lower, int upper, int tar,int [] arr){
    	if(lower <0 || upper >= arr.length)    	{return -1;}
    	for(int i=lower;i<=upper;i++){
    		if(tar == arr[i]){
    			return i;
    		}
    	}    	
    	return -1;
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
