//350. Intersection of Two Arrays II
package microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Solution350 {

	public Solution350() {
		// TODO Auto-generated constructor stub
	}
	
	
    public int[] intersect(int[] nums1, int[] nums2) {
//If sorted, use two-pointers will be significantly faster
//Total = O(nlogn)
//O(nlogn)    	
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);  
//O(n)    	
    	List<Integer> res = new LinkedList<Integer>();    	
    	int i=0;	int j=0;    	
    	while(i<nums1.length && j<nums2.length){    		
    		if(nums1[i] == nums2[j]){    			
    			res.add(nums1[i]);
				j++;i++;    			   			    			
    		}else if(nums1[i] < nums2[j]){
    			i++;
    			
    		}else{
    			j++;    			
    		}   		
    	}   	
    	int[] result = new int[res.size()];
    	int i1 = 0;
    	for(Integer num : res){
    		result[i1++] = num;
    	}   	
    	return result;    	
    }
    
    
    
    
    
    
    public int[] intersect2(int[] nums1, int[] nums2) {
//Not quite good    	
    	Map<Integer,Integer> m1 = new HashMap<Integer,Integer>();
    	Map<Integer,Integer> m2 = new HashMap<Integer,Integer>();
  	   	
    	for(int i=0;i<nums1.length;i++){
    		if(m1.containsKey(nums1[i])){
    			m1.put(nums1[i], m1.get(nums1[i])+1);
    		}else{
    			m1.put(nums1[i], 1);
    		}
    	}
    	for(int i=0;i<nums2.length;i++){
    		if(m1.containsKey(nums2[i]) && m1.get(nums2[i]) >0){
    			
    			if(m2.containsKey(nums2[i])){
    				m2.put(nums2[i], m2.get(nums2[i])+1);
    			}else{    			
    				m2.put(nums2[i], 1);
    			}
    			
    			m1.put(nums2[i], m1.get(nums2[i])-1);
    		}   		
    		
    	}    	
    	
    	int[] result = new int[m2.size()];
    	int i1 = 0;
    	for(Integer num : m2.keySet()){
    		for(int k=0;k<m2.get(num);k++){
    			result[i1++] = num;
    		}
    		
    	}   	
    	return result;    	
    }    
}
