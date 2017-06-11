package divideandconquer;

//Later details analysis
public class Solution004 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int totalLen = nums1.length + nums2.length;
        if(totalLen % 2 == 1){
        	return findKth(nums1,0,nums2,0,totalLen/2+1);
        }else{
        	return findKth(nums1,0,nums2,0,totalLen/2)+findKth(nums1,0,nums2,0,totalLen/2+1);
        }
    }
    
    private int findKth(int[] A, int A_start, int[] B, int B_start, int k){
    	return 0;
    }

}
