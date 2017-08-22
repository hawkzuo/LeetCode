package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/30.
 * Binary Tree Zigzag Level Order Traversal
 * DFS is faster than BFS
 */
public class Sol103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        levelHelper(res, root, 0);
        return res;
    }
    public List<List<Integer>> zigzagLevelOrderBFS(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null){	return res;}

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        boolean rightToLeft = true;

        while(!queue.isEmpty()){
            List<Integer> s = new ArrayList<>();
            int len = queue.size();
            //Must use a local variable
            for(int i=0;i<len;i++){
                TreeNode op = queue.remove();
                if(rightToLeft){
                    s.add(op.val);
                } else{	s.add(0,op.val);}

                if(op.left != null){
                    queue.add(op.left);
                }
                if(op.right != null){
                    queue.add(op.right);
                }
            }
            res.add(s);
            rightToLeft = !rightToLeft;
        }
        return res;
    }
    private void levelHelper(List<List<Integer>> res, TreeNode root, int height) {
        if (root == null) return;
        if (height >= res.size()) {
            res.add(new LinkedList<>());
        }
        if(height % 2 == 0){
            res.get(height).add(root.val);
        }else{
            res.get(height).add(0,root.val);
        }
        levelHelper(res, root.left, height+1);
        levelHelper(res, root.right, height+1);
    }
}
