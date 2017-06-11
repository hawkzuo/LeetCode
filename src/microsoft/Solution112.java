package microsoft;

public class Solution112 {

	public Solution112() {
		// TODO Auto-generated constructor stub
	}

//DFS Easy
	
    private boolean checkPathSum(TreeNode root,int sum,int now){
        if(root==null)
            return false;
        //'now' 
        now += root.val;
        //leaf node
        if(root.left==null && root.right==null){
            return sum==now;
        }

        return checkPathSum(root.left,sum,now) || checkPathSum(root.right,sum,now);
    }
    public boolean hasPathSum(TreeNode root, int sum) {
        if(root==null)
            return false;
        return checkPathSum(root,sum,0);
    } 	
	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
