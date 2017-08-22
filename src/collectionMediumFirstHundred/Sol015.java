package collectionMediumFirstHundred;

import java.util.*;

/**
 * Created by Amos on 2017/7/13.
 * 3Sum
 */
public class Sol015 {
    public List<List<Integer>> threeSum(int[] numbers) {

        int target = 0;
        List<List<Integer>> res = new LinkedList<>();
        if(numbers.length < 3){	return res;}
        if(numbers.length == 3){
            if( numbers[0]+numbers[1]+numbers[2] == target){
                List<Integer> l= new LinkedList<Integer>();
                l.add(numbers[0]);l.add(numbers[1]);l.add(numbers[2]);
                res.add(l);
            }
            return res;
        }

        Arrays.sort(numbers);
        //Begin with the greatest
        for(int k=numbers.length-1;k>=2;k--){
            if(k != numbers.length-1 && numbers[k] == numbers[k+1]){
                continue;
            }
            if(numbers[k] < 0){
                // reason is 'target == 0'
                break;
            }
            int sum = target - numbers[k];
            int i=0; int j = k-1;

            while(i<j){
                if(numbers[i] + numbers[j] > sum){
                    j--;
                }else if(numbers[i] + numbers[j] == sum){
                    List<Integer> l= new LinkedList<>();
                    l.add(numbers[i]);l.add(numbers[j]);l.add(numbers[k]);
                    res.add(l);
                    // Remove duplicates
                    while(i<j && numbers[j-1] == numbers[j]){ j--;    }
                    while(i<j && numbers[i+1] == numbers[i]){ i++;	}
                    j--;i++;
                }else{
                    i++;
                }
            }
        }
        return res;
    }
}
