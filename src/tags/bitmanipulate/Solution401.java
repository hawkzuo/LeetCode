//401. Binary Watch

package tags.bitmanipulate;

import java.util.ArrayList;
import java.util.List;

public class Solution401 {

	public Solution401() {
		// TODO Auto-generated constructor stub
		
		
		
		
		
	}
    public List<String> readBinaryWatch(int num) {
    	
    	int[] mins = {1,2,4,8,16,32};    	
    	int[] hrs = {1,2,4,8}; 

    	List<String> res =  new ArrayList<String>();
    	if(num < 0 || num >= 9){	return res;}
    	
    	for(int i=0;i<=num;i++){
    		if(i>6 || i<num-3){
    			continue;
    		}
    		
    		
        	List<Integer> minres = new ArrayList<Integer>();
        	List<Integer> hrsres = new ArrayList<Integer>();
    		generateMinute(-1,i,0,mins,minres);
    		generateHour(-1,num-i,0,hrs,hrsres);
    		
    		
            for(int num1: hrsres) {
//                if(num1 >= 12) continue;
                for(int num2: minres) {
//                    if(num2 >= 60) continue;
                    res.add(num1 + ":" + (num2 < 10 ? "0" + num2 : num2));
                }
            } 
/*             
   		for(int hr:hrsres){
    			for(int min:minres){
    				res.add(String.format("%d", hr)+String.format(":%02d", min));
    			}
    		}
    		//minres.clear();	
    		//hrsres.clear();
*/ 
    	}
   	
            
    	return res;		
    	
    	
    }
//generate Minutes
	private void generateMinute(int current, int steps, int sum, int[] refs, List<Integer> res){
		//-1
		if(steps == 0){
			if(current==-1){	;}
			else{sum+=refs[current];}
			if(sum<60){
				res.add(sum);
			}
			//return res;
			
		}
		if(current==-1){	;}
		else{sum+=refs[current];}
			
		for(int i=current+1;i<=5;i++){		
			generateMinute(i,steps-1,sum,refs,res);			
		}		
		//return res;		
	}
//generate Hours	
	private void generateHour(int current, int steps, int sum, int[] refs, List<Integer> res){
		//-1
		if(steps == 0){
			if(current==-1){	;}
			else{sum+=refs[current];}
			if(sum < 12){
				res.add(sum);
			}
			//return res;
			
		}
		if(current==-1){	;}
		else{sum+=refs[current];}
			
		for(int i=current+1;i<=3;i++){		
			generateHour(i,steps-1,sum,refs,res);			
		}		
		//return res;		
	}	
	
	
	
    public static void main(String[] args) {
    	
    	Solution401 s = new Solution401();
    	
    	//int res = s.reverseBits(43261596);
    	System.out.println(s.readBinaryWatch(4).size());
    	System.out.println(s.readBinaryWatch1(4).size());
    }	
	
	
	
	
//Bit Manipulation		--no extra space needed 4ms
    public List<String> readBinaryWatch1(int num) {
    List<String> times = new ArrayList<>();
    for (int h=0; h<12; h++)
        for (int m=0; m<60; m++)
            if (Integer.bitCount(h * 64 + m) == num)
                times.add(h + ":" + (m < 10 ? "0" + m : m));
    return times;           
    }	
	
}
