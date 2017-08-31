//337. House Robber III

package tags.breadth_first_search;

import collectionUtils.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution337 {

	
//Divide and Conquer	
	
	
    public int rob(TreeNode root) {
        Map<TreeNode,Integer> map = new HashMap<TreeNode,Integer>();
        return gB(root,map);
    }
    
    
    private int gB(TreeNode root, Map<TreeNode,Integer> m)
    {
        if(root == null){   return 0;}
        if(m.containsKey(root)){    return m.get(root); }
        int s2 = gB(root.right,m)+gB(root.left,m);
        
        int s1=root.val;
        if(root.left!=null){    s1+=gB(root.left.left,m)+ gB(root.left.right,m); }
        if(root.right!=null){   s1+=gB(root.right.left,m) + gB(root.right.right,m); }
        
        int cur = Math.max(s1,s2);
        m.put(root,cur);
        return cur;
        
        
    }

}
