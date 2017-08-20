//270. Closest Binary Search Tree Value

package tags.breadth_first_search;

public class Solution270 {    
    public int closestValue(TreeNode root, double target) {
        int bigger = root.val;
        int smaller = root.val;
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
        return (bigger - target)>(target - smaller) ? smaller:bigger;               
    }

}
