//226. Invert Binary Tree

package breadth_first_search;

public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        if(root == null){   return null;}
        reverseLR(root);
        return root;
    }
    
    
    private void reverseLR(TreeNode root){
        
        if(root.left!=null){
            reverseLR(root.left);
        }
        if(root.right!=null){
            reverseLR(root.right);
        }
        TreeNode temp=root.left;
        root.left=root.right;
        root.right=temp;
        
        
    }

}
