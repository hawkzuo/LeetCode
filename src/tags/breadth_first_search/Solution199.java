//199. Binary Tree Right Side View

package tags.breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class Solution199 {

	public Solution199() {
		// TODO Auto-generated constructor stub
	}
	
	//Divide and Conquer DFS
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root == null){   return result;}
        result.add(root.val);
        int level=1;
        rightMost(root,result,level+1);
        return result;
    }
    
    private void rightMost(TreeNode root,List<Integer> res, int level ){
        if(root == null){   return;}
        if(res.size() < level){
            if(root.right!=null){
                res.add(root.right.val);
            }else if(root.left!=null){
                res.add(root.left.val);
            }
        }
        rightMost(root.right,res,level+1);
        rightMost(root.left,res,level+1);
        
    }
}
