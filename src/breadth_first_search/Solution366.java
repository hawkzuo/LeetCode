//366. Find Leaves of Binary Tree

package breadth_first_search;

import java.util.ArrayList;
import java.util.List;

public class Solution366 {

	public Solution366() {
		// TODO Auto-generated constructor stub
	}
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root == null){   return result;}
        pos_V(root,result);
        return result;
    }
    
    private int pos_V(TreeNode root, List<List<Integer>> res){
        if(root == null){   return -1;}
        
        int lh = pos_V(root.left,res);
        int rh = pos_V(root.right,res);
        
        int height = Math.max(lh,rh)+1;
        
        if(res.size() < 1+height ){
            
            List<Integer> l = new ArrayList<Integer>();
            l.add(root.val);
            res.add(l);
            return height;
        }else{
            res.get(height).add(root.val);
            return height;
        }

    }
}
