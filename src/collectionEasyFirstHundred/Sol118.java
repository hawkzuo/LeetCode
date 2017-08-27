package collectionEasyFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/25.
 * Pascal's Triangle
 */
public class Sol118 {
    // Idea: Generate row by row

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        if(numRows <= 0) {  return result;}
        List<Integer> first = new ArrayList<>();    first.add(1);
        result.add(first);
        List<Integer> prevList = first;
        for(int i=1; i<numRows; i++) {
            List<Integer> currentStep = new ArrayList<>();

            currentStep.add(1);
            for(int j=1; j<prevList.size(); j++) {
                currentStep.add(prevList.get(j-1) + prevList.get(j));
            }
            currentStep.add(1);

            result.add(currentStep);
            prevList = currentStep;
        }
        return  result;
    }
}
