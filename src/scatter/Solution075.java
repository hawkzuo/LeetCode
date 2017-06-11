package scatter;

public class Solution075 {

    public void sortColors(int[] nums) {
        //Divide into two parts
        //First move all zeros to front
        //Next move the rest ones to front	is slower
    	
        if(nums == null){   return;}
        int left = 0;   int right = nums.length-1;
        
        while(left < right){
            while(left < nums.length && nums[left] == 0){ left ++;}
            while(right >= 0 && nums[right] == 2){ right --;}
            if(left >= nums.length || right <=0 || left >= right){   return;}
            
            int dml = nums[left];   int dmr = nums[right];
            if(dml == 2 && dmr == 0){   swap(nums,left,right);}
            else if(dml == 2 && dmr == 1){swap(nums,left,right);}
            else if(dml == 1 && dmr == 0){swap(nums,left,right);}
            else{
                //Both l/r are '1' , keep invariant and proceed next
                break;
            }
        }
        if(right - left <= 1){  return;}
        
        int cur = left+1;
        while(cur < right){
            if(nums[cur] == 0){ swap(nums,left,cur); left++; }
            else if(nums[cur] == 1){  ;  }
            else{
                swap(nums,cur,right);
                while(nums[right] == 2){    right --;}
                if(nums[right] == 0){
                    swap(nums,left,right);
                    left ++;
                }
                
            }
            cur++;
        }


    }
    
    private void swap(int [] a, int l, int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

}
