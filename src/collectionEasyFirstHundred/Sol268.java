package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/6.
 * Missing Number
 */
public class Sol268 {
    // Idea: Bit
    public int missingNumber(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
    // This method I cannot understand now
    // TODO: Find why doing this
    public int missingNumberViaPlus2N(int[] nums) {
        //0 1 3 => 2
        // 0 1 2 =3
        // 123 =0
        int len = nums.length;
        if(len <1){	return -1;}

        for(int i=0;i<len;i++){
            //*-1 is not quite good
            int index;
            if(nums[i] <= len){
                index = nums[i];
            }else{
                index = nums[i] - 2*len;

            }
            if(index == len){
                continue;
            }

            if(nums[index] <= len){
                nums[index] += 2*len;
            }else{
                return -1;
            }
        }

        for(int i=0;i<len;i++){
            if (nums[i] <= len) {
                return i;
            }
        }
        return len;

    }
    public static void main(String[] args) {
        Sol268 s = new Sol268();
        int[] A = {1,2,3};
        int[] B = {};

        StringBuilder sb = new StringBuilder();
        System.out.println(s.missingNumber(A));
    }
}
