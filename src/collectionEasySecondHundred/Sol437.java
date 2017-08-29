package collectionEasySecondHundred;

import collectionUtils.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/8/28.
 * Path Sum III
 */
public class Sol437 {
    // Idea: Brute-force matching each path sum
    // Time: O(n^2)
    private int counter = 0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null) {  return 0; }
        generateSum(root, 0, sum, new HashSet<>());
        return counter;
    }

    private void generateSum(TreeNode current, int curSum, int target, Set<TreeNode> visited) {

        int stepVal = curSum + current.val;
        if(stepVal == target) {
            counter ++;
        }

        if(current.left != null) {
            generateSum(current.left, stepVal, target, visited);
            if(!visited.contains(current.left)) {
                generateSum(current.left, 0, target, visited);
                visited.add(current.left);
            }
        }
        if(current.right != null) {
            generateSum(current.right, stepVal, target, visited);
            if(!visited.contains(current.right)) {
                generateSum(current.right, 0, target, visited);
                visited.add(current.right);
            }
        }
    }

    // Original method via recursive DFS calls
    private int total;
    private void countPathSum(TreeNode root,int sum,int currentSum){
        if(root==null)
            return ;
        //'now'
        int stepSum = currentSum + root.val;
        // Count
        if(sum==stepSum){
            total ++;
        }
        countPathSum(root.left, sum, stepSum);
        countPathSum(root.right, sum, stepSum);
    }

    // Recursively choose root to start countPath
    private void recur(TreeNode root, int sum){
        if(root == null){	return;}

        if(root.left != null){
            countPathSum(root.left, sum,0);
        }
        if(root.right != null){
            countPathSum(root.right, sum,0);
        }
        recur(root.left, sum);
        recur(root.right, sum);
    }

    public int pathSumViaRecursiveCalls(TreeNode root, int sum) {
        this.total = 0;
        if(root==null)
            return this.total;
        countPathSum(root,sum,0);
        recur(root,sum);
        return this.total;
    }

    public static void main(String[] args) {
        Sol437 s = new Sol437();
        int[] A = {};
        int[] B = {};
        StringBuilder sb = new StringBuilder();
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        t1.right=t2;    t2.right=t3;    t3.right=t4;    t4.right=t5;
        System.out.println(s.pathSumViaRecursiveCalls(t1, 3));
    }
}
