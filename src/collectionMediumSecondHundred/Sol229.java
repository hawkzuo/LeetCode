package collectionMediumSecondHundred;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Amos on 2017/9/11.
 * Majority Element II
 */
public class Sol229 {
    // Idea: Majority Vote might help
    // At most 2 numbers might be the answer
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();

        Integer n1=null, n2=null;
        int c1=0, c2=0;

        // This special loop in this special situation can find out the top 2 most frequent element.
        // Very tricky method, if the majority element exists, then it must be either n1 or n2.
        // Reversely, if it does not exist, then n1 or n2 can be various choices.
        for(int i: nums){
            if(n1!=null && i== n1){
                c1++;
            }else if(n2!=null && i== n2){
                c2++;
            }else if(c1==0){
                c1=1;
                n1=i;
            }else if(c2==0){
                c2=1;
                n2=i;
            }else{
                c1--;
                c2--;
            }
        }

        c1=c2=0;
        // This extra loop ensures n1/n2 is the majority element
        for(int i: nums){
            if(i== n1){
                c1++;
            }else if(n2 != null && i == n2){
                c2++;
            }
        }

        if(c1>nums.length/3)
            result.add(n1);
        if(c2>nums.length/3)
            result.add(n2);

        return result;
    }
}
