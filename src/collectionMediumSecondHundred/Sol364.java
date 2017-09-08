package collectionMediumSecondHundred;

import collectionUtils.NestedInteger;

import java.util.List;

/**
 * Created by Amos on 2017/9/10.
 * Nested List Weight Sum II
 */
public class Sol364 {
    // Idea: The weight is reversed and add some offset, so we can get the negative sum first, and then add some number
    // Each level weight = MaxDepth - CurDepth + 1
    // Assume 1st level has depth 1

    private int maxDepth = 0;
    private int totalSum = 0;

    public int depthSumInverse(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {  return 0;}
        return totalSum * (1 + maxDepth) +  recursivelyCalculateNegativeSum(nestedList, 1) ;
    }

    private int recursivelyCalculateNegativeSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        maxDepth = Math.max(maxDepth, depth);
        for(NestedInteger item: nestedList) {
            if(item.isInteger()) {
                sum += - item.getInteger() * depth;
                totalSum += item.getInteger();
            } else {
                sum += recursivelyCalculateNegativeSum(item.getList(), depth+1);
            }
        }
        return sum;
    }
}
