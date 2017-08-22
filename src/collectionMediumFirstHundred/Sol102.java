package collectionMediumFirstHundred;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Created by Amos on 2017/7/30.1
 * Binary Tree Level Order Traversal
 */
public class Sol102 {
    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> res = new ArrayList<>();
        if(root == null){	return res;}

        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);

        // Notice variable 'len'
        while(!queue.isEmpty()){
            List<Integer> s = new ArrayList<>();
            int len = queue.size();
            //Must use a local variable
            for(int i=0;i<len;i++){
                TreeNode op = queue.remove();
                s.add(op.val);
                if(op.left != null){
                    queue.add(op.left);
                }
                if(op.right != null){
                    queue.add(op.right);
                }
            }
            res.add(s);
        }
        return res;
    }
}
