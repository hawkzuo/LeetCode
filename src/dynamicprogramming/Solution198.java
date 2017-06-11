//198. House Robber

package dynamicprogramming;

import java.util.HashMap;
import java.util.Map;

public class Solution198 {

    public int rob(int[] nums) {
        Map<Integer,Integer> hash = new HashMap<Integer,Integer>();
        return getSum(nums,0,hash);
    }
    
    public int robfast(int[] num) {
        int prevMax = 0;
        int currMax = 0;
        for (int x : num) {
            int temp = currMax;
            currMax = Math.max(prevMax + x, currMax);
            prevMax = temp;
        }
        return currMax;
    }    
    
    private int getSum(int[] a, int begin, Map<Integer,Integer> m){
        int end = a.length;
    	if(end - begin <=0){
            return 0;
        }
        if(end - begin == 1){
            m.put(begin,a[begin]);
            return a[begin];
        }
        if(end - begin == 2){
            int cur = Math.max(a[begin],a[begin+1]);
            m.put(begin,cur);
            return cur;
        }   
        
        int s1;
      
        if(m.containsKey(begin+2)){
            s1 = m.get(begin+2);
        }else{
            s1 = getSum(a,begin+2,m);
        }
        int s2;
        if(m.containsKey(begin+3)){
            s2 = m.get(begin+3);
        }else{
            s2 = getSum(a,begin+3,m);
        }
        
        int cur = Math.max(a[begin]+s1,a[begin+1]+s2);
        m.put(begin,cur);
        return cur;
    }
    
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution198 s = new Solution198();    
		int[] room = {3,2,1,4,105,6,7,8};
		int[] rooms = {1,2,3,4};
		System.out.println(s.rob(rooms));
    
    }
    

}
