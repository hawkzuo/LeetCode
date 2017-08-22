package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/8/10.
 * Find Peak Element
 */
public class Sol162 {
    public int findPeakElement(int[] nums) {
        // 6006
        if(nums.length == 1){   return 0; }
        else if(nums.length == 2){
            if(nums[0] > nums[1]) {
                return 0;
            }else {
                return 1;
            }
        }
        return bSearch(nums, 0, nums.length-1);
    }

    private int bSearch(int[] A, int left, int right) {
        if(left == right ){ return left; }
        else if(left + 1 == right) {
            if(A[left] > A[right]) {
                return left;
            }else{
                return right;
            }
        }
        int mid = left + (right -left)/2;
        if(A[mid] < A[mid-1]) {
            // left > mid   => Peek in left
            return bSearch(A, left, mid-1);
        }else if(A[mid] < A[mid+1]) {
            // right > mid  => Peek in right
            return bSearch(A, mid+1, right);
        }else {
            // Peek is found
            return mid;
        }
    }
}
