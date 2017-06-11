package scatter;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;


public class Solution179 {

    public String largestNumber(int[] nums) {
        StringBuilder res= new StringBuilder();
        List<Integer> nlist = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){	nlist.add(nums[i]);}
    	Collections.sort(nlist,new Comparator<Integer>(){
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				int l = o1.intValue();	int r=o2.intValue();
				if(l == 0){	return 1;}	if(r == 0){	return -1;}
				int lbits = 1;	int rbits=1;
				while(l/10 !=0){	lbits++; l/=10;	}
				while(r/10 != 0){	rbits++; r/=10;	}
				l = o1.intValue();r=o2.intValue();
				long r1 = (long)l*pow(rbits)+r;
				long r2 = (long)r*pow(lbits)+l;
                //BigDecimal r1 = new BigDecimal(l*pow(rbits)+r);
                //BigDecimal r2 = new BigDecimal(r*pow(lbits)+l);				
				
				if(r1 < r2){
					return 1;
				}else if(r1 > r2){
					return -1;
				}else{
					return 0;
				}				
			}
    	});
    	if(nlist.get(0) == 0){	res.append("0");	return res.toString();}
    	for(int i=0;i<nlist.size();i++){
    		res.append(nlist.get(i));
    	}    	
    	return res.toString();    	
    }
    private int pow(int times){
    	int res = 1;
    	for(int i=0;i<times;i++){
    		res *=10;
    	}
    	return res;
    }
    public String largestNumberRef(int[] num) {
		if(num == null || num.length == 0)
		    return "";
		
		// Convert int array to String array, so we can sort later on
		String[] s_num = new String[num.length];
		for(int i = 0; i < num.length; i++)
		    s_num[i] = String.valueOf(num[i]);
			
		// Comparator to decide which string should come first in concatenation
		Comparator<String> comp = new Comparator<String>(){
		    @Override
		    public int compare(String str1, String str2){
		        String s1 = str1 + str2;
			String s2 = str2 + str1;
			return s2.compareTo(s1); // reverse order here, so we can do append() later
		    }
	    };
		
		Arrays.sort(s_num, comp);
               // An extreme edge case by lc, say you have only a bunch of 0 in your int array
               if(s_num[0].charAt(0) == '0')
                   return "0";
           
		StringBuilder sb = new StringBuilder();
		for(String s: s_num)
	            sb.append(s);
		
		return sb.toString();
		
	}
    
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution179 s = new Solution179();
		int[] test = {999999998,999999997,999999999};
		System.out.println(s.largestNumber(test));
		System.out.println(s.largestNumberRef(test));
	}

}
