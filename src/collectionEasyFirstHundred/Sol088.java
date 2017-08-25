package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Merge Sorted Array
 */
public class Sol088 {
    // Idea: Two Pointers

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1=m-1;
        int p2=n-1;
        // Common part
        while(p1>=0 && p2 >= 0){
            if(nums1[p1] > nums2[p2]){
                nums1[p1+p2+1]=nums1[p1];
                p1--;
            }else{
                nums1[p1+p2+1]=nums2[p2];
                p2--;
            }
        }
        // Only there are leftovers in the second array will require extra copying
        if(p2 >=0){
            while(p2 >=0){
                nums1[p2]=nums2[p2];
                p2--;
            }
        }
    }
}
