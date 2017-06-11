//298. Binary Tree Longest Consecutive Sequence

package breadth_first_search;

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
