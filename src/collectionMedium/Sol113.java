package collectionMedium;

import java.util.*;

/**
 * Created by Amos on 2017/7/30.
 * Path Sum II
 * DFS + BT
 */
public class Sol113 {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<List<Integer>> ();
        LinkedList<Integer> path = new LinkedList<Integer> ();

        if(root==null) return res;
        addPathSum(root,sum,0,path,res);
        return res;
    }

    private void addPathSum(TreeNode root,int sum,int now, LinkedList<Integer> path , List<List<Integer>> res){
        //'now' is basic type, don't need to change like list.
        now += root.val;
        path.add(root.val);
        //Control the leaf node's return list 'path' is size reduced
        if(root.left==null && root.right==null){
            if(sum == now){
                List<Integer> list = new LinkedList<>();
                list.addAll(path);
                res.add(list);
            }
            path.removeLast();
        }else{
            if(root.left != null){
                addPathSum(root.left,sum,now,path,res);
            }
            if(root.right != null){
                addPathSum(root.right,sum,now,path,res);
            }
            //The reason why you cannot add the following line twice to the above two if-statements blocks
            //is that, root.left/right can be a leaf node, in this case, their 'path's have already been
            //taken care by the leaf block.
            //This line controls the non-leaf node's return list 'path' is size reduced
            //Thus, overall situations are size reduced
            //       		path.remove(path.size()-1);
            path.removeLast();
        }
    }
}
