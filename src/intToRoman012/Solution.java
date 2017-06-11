//59.10% --98ms
//88%	 --90ms

package intToRoman012;

public class Solution {

	public Solution() {
		// TODO Auto-generated constructor stub
	}

	
	//num is between 1-3999
	public String intToRoman(int num) {
/*
        int d1=num % 10;
        int d2=0; int d3=0; int d4=0;
        if((num / 10) > 0){
        	d2 = (num / 10) % 10;
        	if((num / 100) > 0){
        		d3 = (num / 100) % 10;
        		if((num / 1000) > 0){
        			d4 = (num / 1000) % 10;
        		}
        	}
        }
        String [] ones={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String [] tens={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String [] hundreds={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String [] thousands={"","M","MM","MMM","MMMM","MMMMM"};
        String result=thousands[d4]+hundreds[d3]+tens[d2]+ones[d1];
        return result;      
 */

		int d1=num % 10;
        int d2=0; int d3=0; int d4=0;
        if((num / 10) > 0){
        	d2 = (num / 10) % 10;
        	if((num / 100) > 0){
        		d3 = (num / 100) % 10;
        		if((num / 1000) > 0){
        			d4 = (num / 1000) % 10;
        		}
        	}
        }
        String [] ones={"","I","II","III","IV","V","VI","VII","VIII","IX"};
        String [] tens={"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String [] hundreds={"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String thousand="MMMMM";
        String result="";
        if(d4>0){
        	//Runs in O(1) time each looking up
        	result=thousand.substring(0, d4)+hundreds[d3]+tens[d2]+ones[d1];
        }else {
        	if(d3>0){
            	result=hundreds[d3]+tens[d2]+ones[d1];
        	}else{
        		if(d2>0){
        			result=tens[d2]+ones[d1];
        		}else{
        			result=ones[d1];
        		}        		
        	}
        }        
        return result;


    }
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution s=new Solution();
		String r1=s.intToRoman(1051);						
		System.out.println(r1);
		String r2=s.intToRoman(1084);						
		System.out.println(r2);	
		
		
	}

}
