package collectionMedium;

/**
 * Created by Amos on 2017/7/23.
 * Jump Game
 */
public class Sol055 {
    public boolean canJump(int[] nums) {
        if(nums.length == 1){   return true;}

        int maximumDistance = 0;
        int currentIndex = 0;
        while(currentIndex < nums.length){
            if(currentIndex > maximumDistance){ return false;}
            maximumDistance = Math.max(maximumDistance, currentIndex+nums[currentIndex]);
            currentIndex++;
        }
        return true;
    }
}
