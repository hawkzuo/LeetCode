//285. Inorder Successor in BST

package tags.breadth_first_search;

public class Solution285 {


    private TreeNode prev=null;
    private TreeNode ref = null;
    private TreeNode res = null;
    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null){  return null;}
        
        if(p.right != null){
            //Find min in right sub tree.
            p=p.right;
            while(p.left != null){
                p = p.left;
            }
            return p;
        }else{
            ref = p;
            inorderVisit(root);
            return res;
        }
    }

	private void inorderVisit(TreeNode root){
	    if(root == null){
	        return;
	    }
	    inorderVisit(root.left);
	    if(prev == null){
	        prev = root;
	    }
	    else if(prev == ref){
	        res = root;
	        prev = root;
	    }else{
	        prev = root;
	    }
	    inorderVisit(root.right);
	} 
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode n2 = new TreeNode(2);
		TreeNode n1 = new TreeNode(1);
		TreeNode n3 = new TreeNode(3);
		n2.left = n1; n2.right = n3;
		Solution285 s = new Solution285();
		TreeNode r = s.inorderSuccessor(n2, n1);
		System.out.println(r);
	}	
	
	
	
}
