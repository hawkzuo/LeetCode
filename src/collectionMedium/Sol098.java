package collectionMedium;

/**
 * Created by Amos on 2017/7/30.
 * Validate Binary Search Tree
 */
public class Sol098 {
    private TreeNode prev=null;
    public boolean isValidBST(TreeNode root) {

        return inorderVisit(root);
    }
    private boolean inorderVisit(TreeNode root){
        // In-order = left mid right
        // Traversal = Increasing sequences
        if(root == null){
            return true;
        }
        boolean leftTree = inorderVisit(root.left);
        if(!leftTree) {    return false; }
        if(prev == null){
            prev = root;

        }else if(root.val <= prev.val){
            return false;
        }else{
            prev = root;
        }
        boolean rightTree = inorderVisit(root.right);
        return leftTree && rightTree;
    }
}
