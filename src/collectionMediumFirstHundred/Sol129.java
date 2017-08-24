package collectionMediumFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/7/31.
 * Sum Root to Leaf Numbers
 */
public class Sol129 {
    private int total;
    public int sumNumbers(TreeNode root) {
        total = 0;
        int value = 0;
        if(root==null){	return 0;}
        addPathSum(root,value);
        return total;
    }

    private void addPathSum(TreeNode root, int temp){
        // Every time goes deeper, previous values multiply by 10
        int newValue = temp * 10 + root.val;
        // Control the leaf node's return list 'path' is size reduced
        if(root.left==null && root.right==null){
            total += newValue;
        }else{
            if(root.left != null){
                addPathSum(root.left,newValue);
            }
            if(root.right != null){
                addPathSum(root.right,newValue);
            }
        }
    }
}
