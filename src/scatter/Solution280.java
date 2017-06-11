package scatter;

public class Solution280 {

    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1 ){  return;}
        if(nums.length == 2){  if(nums[0] > nums[1]){ swap(nums,0,1);} return; } 
        int cur = 1;
        while(cur < nums.length){
            if(cur % 2 ==1){
                if(nums[cur-1] > nums[cur]){  swap(nums,cur-1,cur);}
            }else{
                if(nums[cur] > nums[cur-1]){  swap(nums,cur-1,cur);}
            }
            cur++;
        }
    }
    private void swap(int[] A, int l, int r){
        int t = A[l];
        A[l] = A[r];
        A[r] = t;
    }

}
