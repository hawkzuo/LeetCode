package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/27.
 * Two Sum II - Input array is sorted
 */
public class Sol167 {
    // Idea: Two Pointers
    public int[] twoSum(int[] nums, int target) {
        int [] res=new int[2];
        int len=nums.length;
        int i=0; int j=len-1;
        while(i<j){
            if(nums[i]+nums[j] < target){
                i++;
            }else if(nums[i]+nums[j] > target){
                j--;
            }else{
                res[0]=i+1;
                res[1]=j+1;
                return res;
            }
        }
        return res;
    }
}
