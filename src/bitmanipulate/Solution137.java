//137. Single Number II
//And Or Not

package bitmanipulate;

public class Solution137 {

	public Solution137() {
		// TODO Auto-generated constructor stub
	}
    public int singleNumber(int[] nums) {
        //we need to implement a tree-time counter(base 3) that if a bit appears three time ,it will be zero.
        //#curent  income  ouput
        //# ab      c/c       ab/ab
        //# 00      1/0       01/00
        //# 01      1/0       10/01
        //# 10      1/0       00/10
        // a=~abc+a~b~c;
        // b=~a~bc+~ab~c;
        int a=0;
        int b=0;
        for(int c:nums){
            int newa=(~a&b&c)|(a&~b&~c);
            b=(~a&~b&c)|(~a&b&~c);
            a=newa;
        }
        //we need find the number that is 01,10 => 1, 00 => 0.
        return a|b;
        
    }
    
    
}
