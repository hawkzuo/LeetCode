package microsoft;

public class Solution101 {

	public Solution101() {
		// TODO Auto-generated constructor stub
	}

	
	public boolean isSymmetric(TreeNode root) {
        
		if(root == null){	return true;}
		if(root.left == null && root.right == null){	return true;}
		
		return checkSym(root.left,root.right);
    }
	//How to return bool value is the problem
	private boolean checkSym(TreeNode l, TreeNode r){		
		if(l == null && r != null){
			return false;
		}else if(r == null && l != null){
			return false;
		}else if(r == null && l == null){
			return true;
		}else{			
			if(l.val == r.val){				
				return (checkSym(l.left,r.right)) && (checkSym(l.right,r.left));				
			}else{
				return false;
			}						
		}		
	}
//Iteration	
	
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
