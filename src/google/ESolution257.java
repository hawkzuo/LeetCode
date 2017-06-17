package google;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/6/18.
 * Binary Tree Paths
 */
public class ESolution257 {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> ans = new ArrayList<String>();
        if(root==null){	return ans;}
        StringBuilder s = new StringBuilder();
        constructPath(root,ans,s);
        return ans;
    }

    private void constructPath(TreeNode root, List<String> res, StringBuilder sb){
        int len = sb.length();
        if(root.left == null && root.right == null){
            sb.append(Integer.toString(root.val));
            res.add(sb.toString());
            sb.setLength(len);
        }else if(root.left != null && root.right == null){
            sb.append(Integer.toString(root.val));
            sb.append("->");
            constructPath(root.left,res,sb);
            sb.setLength(len);
        }else if(root.left == null && root.right != null){
            sb.append(Integer.toString(root.val));
            sb.append("->");
            constructPath(root.right,res,sb);
            sb.setLength(len);
        }else{
            sb.append(Integer.toString(root.val));
            sb.append("->");
            constructPath(root.left,res,sb);
            constructPath(root.right,res,sb);
            sb.setLength(len);
        }
    }
}
