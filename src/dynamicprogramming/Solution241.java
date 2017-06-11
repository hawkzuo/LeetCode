package dynamicprogramming;

import java.util.ArrayList;
import java.util.List;

public class Solution241 {
	List<Integer>[][] table;
	public Solution241() {
		// TODO Auto-generated constructor stub
	}
    public List<Integer> diffWaysToCompute(String input) {
        if(input == null || input.length() == 0){
            return new ArrayList<Integer>();
        }  
        String[] dummys = input.split("(?<=[-+*])");
    
        int iLen = dummys.length;
        int [] nums = new int[iLen];
        char[] ops = new char[iLen-1];
        
        table = new ArrayList[iLen+1][iLen+1];
        for(int i=0;i<table.length;i++){
        	for(int j=0;j<table[0].length;j++){
        		table[i][j] = new ArrayList<Integer>();
        	}
        }
        
        
        
        for(int i=0;i<iLen-1;i++){
                nums[i] = Integer.valueOf(dummys[i].substring(0, dummys[i].length()-1));
                ops[i] = dummys[i].charAt(dummys[i].length()-1);

        }
        nums[iLen-1] = Integer.valueOf(dummys[iLen-1]);
        return construct(0,iLen-1,nums,ops);
    }
    
    private List<Integer> construct(int from, int to, int[] nums, char[] ops){
        List<Integer> res = new ArrayList<Integer>();
        if(from == to){
            res.add(nums[from]);
        }else if(from +1 == to){
            
            res.add(perform(nums[from],nums[to],ops[from]));
            table[from][to] = res;
        }else{
        	if(table[from][to].size() >0){
        		res = table[from][to];
        		
        	}else{      	
	            int innerindex = from ;
	            while(innerindex < to){
	                List<Integer> lhalf = construct(from,innerindex,nums,ops);
	                List<Integer> rhalf = construct(innerindex+1,to,nums,ops);
	                for(Integer l:lhalf){
	                    for(Integer r:rhalf){
	                        res.add(perform(l,r,ops[innerindex]));
	                    }
	                }
	                innerindex++;
	            }
	            table[from][to] = res;
	            
        	}
        }
        return res;
        
        
    }
    
    private int perform(int l, int r, char op){
        if(op == '+'){
            return l+r;
        }else if(op == '-'){
            return l-r;
        }else if(op == '*'){
            return l*r;
        }else{
            return Integer.MAX_VALUE;   
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution241 s = new Solution241();
		System.out.println(s.diffWaysToCompute("111+123-789*523"));
		double p = 85.0/(85.0+890.0);
		double q = 0.85;
		System.out.println(2*p*q/(p+q));
	}

}
