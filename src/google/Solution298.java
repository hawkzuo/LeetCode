package google;

/**
 * Created by Amos on 2017/6/10.
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
