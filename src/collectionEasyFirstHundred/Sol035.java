package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Search Insert Position
 */
public class Sol035 {
    // Idea: Binary Search
    // Invariant: target is not equal to boundary points
    // Array is sorted
    public int searchInsert(int[] nums, int target) {

        if(nums == null){return -1;}
        if(nums.length == 0){return 0;}
        if(target <= nums[0]){	return 0;}

        if(target > nums[nums.length-1]){	return nums.length;}
        if(target == nums[nums.length-1]){	return nums.length-1;}

        int len=nums.length;
        int left=0;	int right=len-1;
        return performSearch(left,right,target,nums);
    }

    private int performSearch(int l,int r,int t,int[] a){

        if(r-l == 1){	return r;}

        int m=(r-l)/2;
        if(t == a[l+m]){
            return (l+m);
        }else if(t > a[l+m]){
            l=l+m;
            return performSearch(l,r,t,a);
        }else{
            r=l+m;
            return performSearch(l,r,t,a);
        }
    }
}
