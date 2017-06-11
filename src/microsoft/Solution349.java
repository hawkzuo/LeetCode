//349. Intersection of Two Arrays
package microsoft;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution349 {

	public Solution349() {
		// TODO Auto-generated constructor stub
	}
	
    public int[] intersection3(int[] nums1, int[] nums2) {
            	
//map is the fastest	
    	Map<Integer,Integer> m1 = new HashMap<Integer,Integer>();
    	Map<Integer,Integer> m2 = new HashMap<Integer,Integer>();
  	   	
    	for(int i=0;i<nums1.length;i++){
    		m1.put(nums1[i], 1);
    	}
    	for(int i=0;i<nums2.length;i++){
    		if(m1.containsKey(nums2[i])){
    			m2.put(nums2[i], 1);
    		}
    	}    	
    	
    	int[] result = new int[m2.size()];
    	int i1 = 0;
    	for(Integer num : m2.keySet()){
    		result[i1++] = num;
    	}   	
    	return result;    	
    }

	
    public int[] intersection(int[] nums1, int[] nums2) {
            	
//set will work    	
        Set<Integer> set = new HashSet<>();
        Set<Integer> intersect = new HashSet<>();
        for (int i = 0; i < nums1.length; i++) {
            set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++) {
            if (set.contains(nums2[i])) {
                intersect.add(nums2[i]);
            }
        }
        int[] result = new int[intersect.size()];
        int i = 0;
        for (Integer num : intersect) {
            result[i++] = num;
        }
        return result;
    	
    	
    }
    public int[] intersection2(int[] nums1, int[] nums2) {       
    	Arrays.sort(nums1);
    	Arrays.sort(nums2);    	
    	List<Integer> res = new LinkedList<Integer>();    	
    	int i=0;	int j=0;    	
    	while(i<nums1.length && j<nums2.length){
    		
    		if(nums1[i] == nums2[j]){
    			
    			res.add(nums1[i]);
    			while(j<nums2.length-1 && nums2[j+1] == nums2[j]){ j++;    }
    			while(i<nums1.length-1 && nums1[i+1] == nums1[i]){ i++;	}    				
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

    public static String convertstr(int [] input){
    	
    	StringBuilder sb = new StringBuilder();
    	for(Integer num : input){
    		sb.append(num);   		
    	}    	
    	return sb.toString();        	
    }
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution349 s = new Solution349();
		int [] n1 = {1,2,3,4,5,6,7};
		int [] n2 = {5,6,6,7,7,8,9,10};
		
		
		System.out.println(convertstr(s.intersection(n1, n2)));
		System.out.println(convertstr(s.intersection2(n1, n2)));
		System.out.println(convertstr(s.intersection3(n1, n2)));

		
		
	}    
    
    
    
}
