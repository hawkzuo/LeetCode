//298. Binary Tree Longest Consecutive Sequence

package tags.breadth_first_search;

import collectionUtils.TreeNode;

/*
public class Solution298 {

    private int largest = -1;   
    public int longestConsecutive(TreeNode root) {
        if(root == null){   return 0;}
        DC(root,1);
        return largest;
    }
    private void DC(TreeNode root, int csum){
        if(root.left == null && root.right == null){
            largest = Math.max(largest,csum);
        }else if(root.left != null && root.right == null){
            if(root.left.val -1 == root.val){
                DC(root.left,csum+1);
            }else{
                largest = Math.max(largest,csum);
                DC(root.left,1);
            }            
        }else if(root.left == null && root.right != null){
            if(root.right.val -1 == root.val){
                DC(root.right,csum+1);
            }else{
                largest = Math.max(largest,csum);
                DC(root.right,1);
            }
        }else{
            if(root.left.val -1 == root.val){
                DC(root.left,csum+1);
            }else{
                largest = Math.max(largest,csum);
                DC(root.left,1);
            }             
            if(root.right.val -1 == root.val){
                DC(root.right,csum+1);
            }else{
                largest = Math.max(largest,csum);
                DC(root.right,1);
            }            
        }
    }
}
*/
public class Solution298 {

    int globalMax;
    public int longestConsecutive(TreeNode root) {
        if(root == null){   return 0;}
        globalMax = 1;
        helper(root,1);
        return globalMax;
    }

    public void helper(TreeNode root, int curLength){

        if(root.left != null){
            if(root.val +1 == root.left.val){
                helper(root.left,curLength+1);
            }else{
                globalMax = Math.max(globalMax,curLength);
                helper(root.left,1);
            }
        }else{
            globalMax = Math.max(globalMax,curLength);
        }

        if(root.right != null ){
            if(root.val +1 == root.right.val){
                helper(root.right,curLength+1);
            }else{
                globalMax = Math.max(globalMax,curLength);
                helper(root.right,1);
            }
        }else{
            globalMax = Math.max(globalMax,curLength);
        }
    }

}