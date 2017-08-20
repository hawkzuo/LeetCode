package companies.microsoft;


public class Solution129 {
	
	private int total;
	
	public Solution129() {
		// TODO Auto-generated constructor stub
	}

/* Adapted from Q113	
    public int sumNumbers(TreeNode root) {
        total = 0;
        LinkedList<Integer> path = new LinkedList<Integer> ();
        if(root==null){	return 0;}
        addPathSum(root,0,path);
    	return total;
    }	
		
	
    private void addPathSum(TreeNode root,int now, LinkedList<Integer> path){
        //'now' is basic type, don't need to change like list.
        now += root.val;
        path.add(root.val);
        //Control the leaf node's return list 'path' is size reduced
        if(root.left==null && root.right==null){
//                List<Integer> list = new LinkedList<>();
                int tempresult=0;
                for (Integer i : path) {
                	tempresult = tempresult * 10 + i;                	
//                    list.add(i);
                }
                total += tempresult;                          	
                path.removeLast();
        }else{
        	if(root.left != null){
        		addPathSum(root.left,now,path);
        	}
        	if(root.right != null){
        		addPathSum(root.right,now,path);
        	}  
        		path.removeLast();
        }
    } 	
*/	

    public int sumNumbers(TreeNode root) {
        total = 0;
        int tempsum = 0;
        if(root==null){	return 0;}
        addPathSum(root,tempsum);
    	return total;
    }	
		
	
    private void addPathSum(TreeNode root, int tempsum){
        //'tempsum' is basic type, don't need to change like list.
        tempsum = tempsum * 10 + root.val;
        //Control the leaf node's return list 'path' is size reduced
        if(root.left==null && root.right==null){
                total += tempsum; 
        }else{
        	if(root.left != null){
        		addPathSum(root.left,tempsum);
        	}
        	if(root.right != null){
        		addPathSum(root.right,tempsum);
        	}  
        }
    }	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
