package collectionMedium;

/**
 * Created by Amos on 2017/7/30.
 * Flatten Binary Tree to Linked List
 * Right Middle Left Visit Order
 */
public class Sol114 {
    private TreeNode prev=null;
    
    public void flatten(TreeNode root) {
        rlmV(root);
    }

    private void rlmV(TreeNode root){
        // right-left-middle visiting
        if(root == null){   return;}

        rlmV(root.right);
        rlmV(root.left);

        if(prev == null){
            prev = root;
        }else{
            root.left=null;
            root.right=prev;
            prev = root;
        }
    }
}
