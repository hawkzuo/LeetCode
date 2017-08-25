package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

import java.util.*;

/**
 * Created by Amos on 2017/8/25.
 * Binary Tree Level Order Traversal II
 */
public class Sol107 {
    // Idea: Either DFS or BFS

    // BFS: Use queue
    public List<List<Integer>> levelOrderBottomBFS(TreeNode root) {

        List<List<Integer>> res = new LinkedList<>();
        if(root == null){	return res;}

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        while(!queue.isEmpty()){
            List<Integer> levelList = new ArrayList<>();
            int len = queue.size();
            //Must use a local variable
            for(int i=0;i<len;i++){
                TreeNode step = queue.remove();
                levelList.add(step.val);
                if(step.left != null){
                    queue.add(step.left);
                }
                if(step.right != null){
                    queue.add(step.right);
                }
            }
            res.add(0, levelList);
        }
        return res;
    }

    // DFS: LinkedList -> 2ms   ArrayList -> 2ms
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new LinkedList<>();
        if(root == null) {  return result;}
        dfsGenerate(result, root, 1);
        return result;
    }

    private void dfsGenerate(List<List<Integer>> result, TreeNode current, int curLevel) {
        if(current == null) {   return;}
        List<Integer> listToAdd;
        if(result.size() < curLevel) {
            // First time come into this level
            List<Integer> levelList = new LinkedList<>();
            result.add(0, levelList);
            listToAdd = levelList;
        } else {
            listToAdd = result.get(result.size()-curLevel);
        }

        listToAdd.add(current.val);
        dfsGenerate(result, current.left, curLevel+1);
        dfsGenerate(result, current.right, curLevel+1);
    }

}
