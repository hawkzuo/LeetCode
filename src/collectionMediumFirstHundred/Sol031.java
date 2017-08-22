package collectionMediumFirstHundred;

import java.util.Arrays;

/**
 * Created by Amos on 2017/8/9.
 * Next Permutation
 */
public class Sol031 {
    // Very hard to come up with this idea in the first round
    // But very easy to understand this process
    // Idea:
    //      Mimic the procedure of finding solution
    //  [1,5,8,1,7,6,5,3,1]
    //  [1,5,8,3,1,1,5,6,7]
    //   swap(1,3)
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        int prev = -1;
        int leftIndex = -1;
        int rightIndex = -1;
        for(int i=len-1;i>=0;i--) {
            if(i == len -1) {
                prev = nums[i];
            }else {
                if(nums[i] >= prev) {
                    prev = nums[i];
                }else {
                    leftIndex = i;
                    break;
                }
            }
        }
        if( leftIndex == -1) {
            reverse(nums, -1);
            return;
        }

        for(int i=leftIndex +1; i<len; i++) {
            if(nums[i] <= nums[leftIndex]) {
                rightIndex = i-1;
                break;
            }
        }

        if(rightIndex == -1) {  rightIndex = len-1;}

        swap(nums, leftIndex, rightIndex);
        reverse(nums, leftIndex+1);
    }

    private void swap(int[] a, int l, int r) {
        int tmp = a[l];
        a[l] = a[r];
        a[r] = tmp;
    }
    // StartIndex: inclusive
    private void reverse(int[] a, int startIndex) {
        if(startIndex == -1) {
            for(int i=0;i<a.length/2;i++) {
                int tmp = a[i];
                a[i] = a[a.length-i-1];
                a[a.length-i-1] = tmp;
            }
        }else {
            int left = startIndex;
            int right = a.length-1;
            while(left < right) {
                swap(a, left, right);
                left ++;
                right --;
            }
        }
    }

    public static void main(String[] args) {
        Sol031 s = new Sol031();
        int[] t = {5,4,7,5,3,2};
        s.nextPermutation(t);
        System.out.println(Arrays.toString(t));
    }

}
