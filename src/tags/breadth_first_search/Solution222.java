//222. Count Complete Tree Nodes

//158ms
package tags.breadth_first_search;

public class Solution222 {

    public int countNodes(TreeNode root) {
        //Divide and Conquer
        if(root == null){   return 0;}
	    int maxh = findL(root);     
        if(maxh == findR(root)){
            return (1<<(maxh+1)) - 1;
        }else if(maxh == findL(root.right)+1){
            return (1<<(maxh))+countNodes(root.right);
        }else if(maxh == findR(root.left)+1){
            return (1<<(maxh))-1+(1<<(maxh-1));
        }else{
            return (1<<(maxh-1))+countNodes(root.left);
        }
    }
    private int findL(TreeNode root){
        if(root == null){
            return -1;
        }
        return findL(root.left)+1;  
    }   
    private int findR(TreeNode root){
        if(root == null){
            return -1;
        }
        return findR(root.right)+1;
    
        
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n2 = new TreeNode(1);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(1);
		TreeNode n4 = new TreeNode(1);
		TreeNode n5 = new TreeNode(1);
		TreeNode n6 = new TreeNode(1);
		TreeNode n7 = new TreeNode(1);
		TreeNode n8 = new TreeNode(1);
		TreeNode n9 = new TreeNode(1);
		TreeNode n10= new TreeNode(1);
		n2.left = n1; n2.right = n3;
		n1.left = n4; n1.right = n5; n3.left = n6; n3.right=n7;
		n4.left=n8;n4.right=n9;n5.left=n10;
		
		
		Solution222 s = new Solution222();
		int res = s.countNodes(n2);
		System.out.println(res);
	}

}
