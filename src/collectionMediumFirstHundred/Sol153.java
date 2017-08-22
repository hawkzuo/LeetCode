package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/8/10.
 * Find Minimum in Rotated Sorted Array
 */
public class Sol153 {
    public int findMin(int[] nums) {
        // Idea: Brute is O(n) obviously
        // => BinarySearch
        // Notice that init left is greater than right
        // 4567 012

        if(nums.length == 1){	return nums[0];}

        int len = nums.length;
        int res;
        res = rotateSearch(nums,0,len-1);
        return res;
    }
    private int rotateSearch(int[] nums, int left, int right){

        if(nums[left] < nums[right]){
            return nums[left];
        }

        int mid = left + (right - left)/2 ;
        if(mid == left){
            // Base case: size = 0/1
            return Math.min(nums[left], nums[right]);
        }else{
            if(nums[mid] > nums[left]){
                return rotateSearch(nums,mid,right);
            }else if(nums[mid] < nums[right]){
                return rotateSearch(nums,left,mid);
            }else{
                return -1;
            }
        }
    }
}
