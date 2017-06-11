package scatter;
import java.util.Arrays;

public class Solution324 {

    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length <= 1 ){  return;}
        if(nums.length == 2 && nums[0] > nums[1]){ 
        	int temp = nums[0]; nums[0] = nums[1]; nums[1]=temp;
        	return; 
        } 
        
        int[] dummy = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            dummy[i] = nums[i];
        }
        Arrays.sort(dummy); int rIndex = nums.length / 2 + nums.length % 2;
        for(int i=0;i<nums.length;i++){
            if(i % 2 == 0){
                nums[i] = dummy[rIndex-1-i / 2];
            }else{
                nums[i] = dummy[nums.length-1-i / 2 ];
            }
        }
 
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] test = {4,5,5,6};
		Solution324 s = new Solution324();
		s.wiggleSort(test);
		System.out.println();
		
	}

}
