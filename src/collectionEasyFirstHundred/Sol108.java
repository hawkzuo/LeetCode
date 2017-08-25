package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

/**
 * Created by Amos on 2017/8/25.
 * Convert Sorted Array to Binary Search Tree
 */
public class Sol108 {
    // Idea: Mimic In-order Traversal   <- Not Needed
    // Just brute-force construct from middle element to form tree

    public TreeNode sortedArrayToBST(int[] nums) {
        return constructNode(nums,0, nums.length);
    }

    private TreeNode constructNode(int[] a, int begin, int end){
        if(begin >= end){   return null;}
        int index = (begin+end)/2;

        TreeNode newElement = new TreeNode(a[index]);
        newElement.left = constructNode(a, begin, index);
        newElement.right = constructNode(a,index+1, end);
        return newElement;
    }
}
