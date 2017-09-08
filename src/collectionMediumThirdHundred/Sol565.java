package collectionMediumThirdHundred;

/**
 * Created by Amos on 2017/9/10.
 * Array Nesting
 */
public class Sol565 {
    // Idea: First Version use Set, but overflow
    // Refactor that Set is not necessary, but why I use it?
    // Because the statements for the question use Set, but in reality, Set components are not valuable for this problem
    public int arrayNesting(int[] nums) {

        boolean[] flags = new boolean[nums.length];
        int globalMax = -1;

        for(int i=0; i<nums.length; i++) {
            if(!flags[i]) {
                int count = recursivelyConstructSet(i, flags, nums);
                globalMax = Math.max(globalMax, count);
            }
        }
        return globalMax;
    }

    private int recursivelyConstructSet(int index, boolean[] flags, int[] nums) {
        if(flags[index]) {  return 0;}
        int newIndex = nums[index];
        flags[index] = true;
        return 1 + recursivelyConstructSet(newIndex, flags, nums);
    }
}
