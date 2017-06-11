package divideandconquer;

import java.util.Arrays;

public class Solution327 {

    int lbound;
    int ubound;
    int total;
    
    
    public int countRangeSum(int[] nums, int lower, int upper) {
        
        lbound = lower;
        ubound = upper;
        total = 0;
        if(nums == null || nums.length == 0){   return 0;}
        if(nums.length == 1){  
            if(Check(nums[0]))	return 1;
            else	return 0;
        }        
        countDC(nums,0,nums.length);
        return total;
    }
    
    //Format [left,right)
    private void countDC(int[] nums, int left, int right){
        //Base
        if(right - left == 2){
            if(Check(nums[left]))							total ++;
            if(Check(nums[left+1]))							total ++;  
            if(Check(nums[left]+nums[left+1]))				total ++;       
        }else if(right - left == 3){
            if(Check(nums[left]))							total ++;
            if(Check(nums[left+1]))							total ++;            
            if(Check(nums[left+2]))							total ++;
            if(Check(nums[left]+nums[left+1]))				total ++;                         
            if(Check(nums[left+1]+nums[left+2]))			total ++;                                      
            if(Check(nums[left]+nums[left+1]+nums[left+2]))	total ++;                        
        }else{
            //Divide
            int mid = left+(right-left)/2;
            countDC(nums,left,mid);
            countDC(nums,mid,right);
            
            //Combine is tricky
            int[] lhalf = new int[mid-left];
            int[] rhalf = new int[right-mid];
            int counter=0;
            for(int i=0;i<mid-left;i++){
                counter+=nums[mid-1-i];
                lhalf[i]=counter;
            }
            counter=0;
            for(int i=0;i<right-mid;i++){
                counter+=nums[mid+i];
                rhalf[i]=counter;
            }
            Arrays.sort(rhalf);
            
            //Now perform binary search on rhalf foreach element in lhalf
            for(int dummy: lhalf){
                int mintarget = lbound-dummy;
                int maxtarget = ubound-dummy;
                int small = -1;
              // Binary Search  
              //Find smallest index that is greater or equal to given number  inclusive
                int low =0;	int high = rhalf.length;
                while(low!=high){
                	int middle = (low+high)/2;
                	if(rhalf[middle] < mintarget){
                		low = middle+1;
                	}else{
                		high = middle;
                	}
                }
                small = low;
                
                int big = -1;
                low=0;high = rhalf.length;
              //Find greatest index that is less or equal to given number
                while(low!=high){
                	int middle = (low+high)/2;
                	if(rhalf[middle] < maxtarget){
                		low = middle+1;
                	}else{
                		high = middle;
                	}
                }
                if(low < rhalf.length && rhalf[low] == maxtarget){
                	big = low-1;
                	while(low <rhalf.length){
                		if(rhalf[low] == maxtarget){
                			big++;
                			low++;
                		}else{
                			break;
                		}
                	}
                }else{
                	big = low-1;
                }
                
                // Add up
                if(small == rhalf.length || big == -1){
                	continue;
                }else if(small == big){
                	total ++;
                }else if(small < big){
                	total += (big - small)+1;
                }else{
                	continue;
                }
  
            }
        }
    }

    private boolean Check(int input){
        if(input >= lbound && input <= ubound)	return true;
        else	return false;
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution327 s = new Solution327();
		int[] input = {-2,5,-1,232,151,2135,234,134,135,1234,1324,11,23,125,111};
		System.out.println(s.countRangeSum(input, -2111, 2111));
	}

}
