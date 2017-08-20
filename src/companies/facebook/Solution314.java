package companies.facebook;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Solution314 {
    
    private int max;
    private int min;
    
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        
        if(root == null){   return res;}
        
        Map<TreeNode,Integer> deg = new HashMap<TreeNode,Integer>();
        
        deg.put(root,0);
        max = 0;    min = 0;
        
        Map<Integer,List<Integer>> hres = new HashMap<Integer,List<Integer>>();
        
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.offer(root);
        
        while(! queue.isEmpty()){
            TreeNode curnode = queue.remove();
            int curdegree = deg.get(curnode);
            if(!hres.containsKey(curdegree)){
               List<Integer> lis = new ArrayList<Integer>(); 
               lis.add(curnode.val);
               hres.put(curdegree,lis);
            }else{
                hres.get(curdegree).add(curnode.val);
            }
            max = Math.max(max,curdegree);
            min = Math.min(min,curdegree);  
            
            if(curnode.left != null){
                deg.put(curnode.left,curdegree+1);
                queue.offer(curnode.left);
            }
            
            if(curnode.right != null){
                deg.put(curnode.right,curdegree-1);
                queue.offer(curnode.right);
            }
        }
        
        int i = max;
        while(i>=min){
            res.add(hres.get(i));
            i--;
        }
        return res;
        
        
    }

    
    
    
    
}