//108. Convert Sorted Array to Binary Search Tree

package tags.breadth_first_search;

public class Solution108 {

    public TreeNode sortedArrayToBST(int[] nums) {
        TreeNode root=constructNode(nums,0,nums.length);
        return root;
    }
    private TreeNode constructNode(int[] a, int begin,int end){
        if(begin >= end){   return null;}        
        int index = (begin+end)/2;        
        TreeNode ne = new TreeNode(a[index]);        
            ne.left = constructNode(a,begin,index);
            ne.right = constructNode(a,index+1,end);
        return ne;
        
    }

}
