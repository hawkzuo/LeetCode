package collectionEasyFirstHundred;

import collectionUtils.TreeNode;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Amos on 2017/8/25.
 * Minimum Depth of Binary Tree
 */
public class Sol111 {
    // Idea: Either BFS or DFS, BFS by nature is easy to come up with
    public int minDepth(TreeNode root) {
        if(root == null){   return 0;}
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        int counter = 1;
        while(!queue.isEmpty()){
            int times = queue.size();
            for(int i=0;i<times;i++){
                TreeNode cur = queue.remove();
                if(cur.left == null && cur.right == null){
                    return counter;
                }
                if(cur.right != null){
                    queue.add(cur.right);
                }
                if(cur.left != null){
                    queue.add(cur.left);
                }
            }
            counter++;
        }
        return counter;
    }

}
