package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/9/7.
 * Closest Binary Search Tree Value
 */
public class Sol270 {
    // Idea: BST => Going down to the leaf and store two values 'bigger' and 'smaller'
    public int closestValue(TreeNode root, double target) {
        int bigger = root.val;
        int smaller = root.val;
        // One pass
        while(root!=null){
            if(root.val == target){
                return root.val;
            }else if(root.val > target){
                bigger = root.val;
                root = root.left;
            }else{
                smaller = root.val;
                root = root.right;
            }
        }
        if(bigger < target){    return smaller;}
        if(smaller > target){   return bigger;}
        return (bigger - target) > (target - smaller) ? smaller : bigger;
    }
}
