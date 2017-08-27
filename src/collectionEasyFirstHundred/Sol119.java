package collectionEasyFirstHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/8/25.
 * Pascal's Triangle II
 */
public class Sol119 {
    // Idea: Brute-force, mind the corresponding row of rowIndex

    public List<Integer> getRow(int rowIndex) {
        List<Integer> prevList = new ArrayList<>();
        if(rowIndex < 0 ) {    return prevList;}
        prevList.add(1);
        if(rowIndex == 0) {    return  prevList;}

        for(int i=0; i<rowIndex; i++) {
            List<Integer> currentStep = new ArrayList<>();

            currentStep.add(1);
            for(int j=1; j<prevList.size(); j++) {
                currentStep.add(prevList.get(j-1) + prevList.get(j));
            }
            currentStep.add(1);

            prevList = currentStep;
        }
        return  prevList;
    }
}
