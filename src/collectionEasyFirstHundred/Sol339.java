package collectionEasyFirstHundred;

import collectionUtils.NestedInteger;

import java.util.List;

/**
 * Created by Amos on 2017/9/10.
 * Nested List Weight Sum
 */
public class Sol339 {
    // Idea: Recursively calculate sum at each level
    public int depthSum(List<NestedInteger> nestedList) {
        if(nestedList == null || nestedList.size() == 0) {  return 0;}
        return recursivelyCalculateSum(nestedList, 1);
    }

    private int recursivelyCalculateSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for(NestedInteger item: nestedList) {
            if(item.isInteger()) {
                sum += item.getInteger() * depth;
            } else {
                sum += recursivelyCalculateSum(item.getList(), depth+1);
            }
        }
        return sum;
    }
}
