package FizzBuzz;

import java.util.ArrayList;
import java.util.List;

public class Solution {

	public List<String> fizzBuzz(int n) {
       List<String> output= new ArrayList<String>();
       for(int i=1;i<=n;i++){
    	   if(i % 3== 0 && i % 5 ==0){
    		   output.add("FizzBuzz");    		   
    	   }
    	   else if(i % 5 ==0){
    		   output.add("Buzz");
    	   }
    	   else if(i % 3 ==0){
    		   output.add("Fizz");
    	   }
    	   else{
    		   output.add(Integer.toString(i));
    	   }
       }             
       return output;
    }
	public static void main(String[] args){
		Solution s = new Solution();
		List<String> result=s.fizzBuzz(15);
		System.out.println(result);
	}
}
