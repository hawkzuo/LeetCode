//170. Two Sum III - Data structure design
package threesums;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	
	Map<Integer, Integer> map = new HashMap<Integer,Integer>()	;	
	int size;
	
	

    // Add the number to an internal data structure.
	public void add(int number) {
	    
		//Key = number, Value = counts
		
		if(!map.containsKey(number)){
			map.put(number, 1);
			
		}else{
			map.put(number, 2);
		}
		size ++;
		
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	public boolean find(int value) {
		if(size <= 1){
			return false;
		}			
		for( Map.Entry<Integer, Integer> entry : map.entrySet() ){
			int k = entry.getKey();
			int v = entry.getValue();
			
			if(value - 2*k == 0 && v == 2){
				return true;
			}
			if(value - 2*k != 0 && map.containsKey(value-k)){
				return true;
			}			
		}
/*		
		for(Integer num : map.keySet()){			
			if(map.get(num) == 2){
				//Num has 2 or more instances in the table
				if(value-2*num == 0){
					return true;
				}else{
					if(map.containsKey(value-num)){
						return true;
					}
				}				
				
			}else{				
				if(value - num == num){
					;
				}else{
					if(map.containsKey(value-num)){
						return true;
					}
				}
			}
					
		}
*/		
		return false;		
	}
	public String toString(){
		
		String res = "";
		
		for(Integer num : map.keySet()){
			
			res += "[ "+num+","+map.get(num)+" ]";
		}
		
		
		return res;
		
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TwoSum twoSum = new TwoSum();
		System.out.println(twoSum.find(1));		
		twoSum.add(0);
		System.out.println(twoSum.find(0));
		twoSum.add(0);
		System.out.println(twoSum.find(0));
		twoSum.add(1);
		twoSum.add(1);
		twoSum.add(3);
		System.out.println(twoSum);
		System.out.println(twoSum.find(2));
		System.out.println(twoSum.find(3));
		System.out.println(twoSum.find(4));
		System.out.println(twoSum.find(5));
		System.out.println(twoSum.find(6));
	}

}
