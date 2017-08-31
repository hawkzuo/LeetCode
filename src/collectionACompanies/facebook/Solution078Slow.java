package collectionACompanies.facebook;
import java.util.*;
class pNode{
    int count;
    Set<Integer> vals;
    public pNode(int c, Set<Integer> input){
        count = c;
        vals = new HashSet<Integer>();
        for(Integer it: input){
            vals.add(it);
        }
    }
    public boolean equals( pNode other){
		if(other == null || count != other.count){
			return false;
		}
    	for(Integer it: vals){
    		if(!other.vals.contains(it)){
    			return false;
    		}
    	}   	
    	return true;   	
    }
}
public class Solution078Slow {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();   res.add(new ArrayList<Integer>());
        if(nums == null || nums.length == 0){   return res;}
        
        int tLen = nums.length;
        Set<Set<Integer>> resSet = new HashSet<Set<Integer>>();
        Deque<pNode> queue = new ArrayDeque<pNode>();
        
        Set<Integer> root = new HashSet<Integer>();
        for(int i=0;i<tLen;i++){    root.add(nums[i]);  }
        
        pNode proot = new pNode(tLen,root); queue.offer(proot);
        
        while(!queue.isEmpty()){
            int ops = queue.size();
            Set<pNode> helper = new HashSet<pNode>();
            
            for(int i=0;i<ops;i++){
                pNode par = queue.remove();
                resSet.add(par.vals);
                if(par.count == 1){
                    continue;
                }
                Set [] steps = new HashSet[par.count];
                for(int di=0;di<steps.length;di++){
                    steps[di] = new HashSet<Integer>();
                }
                for(Integer dummy: par.vals){
                    for(int di=0;di<steps.length;di++){
                        steps[di].add(dummy);
                    }
                }
                int cursor = 0;
                for(Integer dummy: par.vals){
                    steps[cursor].remove(dummy);
                    cursor++;
                }
                
                pNode[] newNodes = new pNode[par.count];
                for(int di=0;di<steps.length;di++){
                    newNodes[di] = new pNode(par.count-1,steps[di]);
                    helper.add(newNodes[di]);
                }
                
            }
            
            for(pNode dmy: helper){
                queue.offer(dmy);
            }
        }       
        for(Set<Integer> dm: resSet){
        	List<Integer> toAdd = new ArrayList<Integer>(dm);
        	res.add(toAdd);
        }
        return res;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution078Slow s = new Solution078Slow();
		int[] nums = {1,2,3,4,5,6,7,8,10,0};
		System.out.println(s.subsets(nums).size());
		
	}

}
