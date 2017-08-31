package collectionACompanies.facebook;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class Solution080Slow {

    public int removeDuplicates(int[] nums) {
        if(nums == null || nums.length == 0){   return 0;}
        else if(nums.length <= 2){  return nums.length;}
        
        List<Integer> rls = new LinkedList<Integer>();
        rls.add(nums[0]);
        
        int counter = 1;    int saved = nums[0];    boolean tFlag = false;
        for(int i=1;i<nums.length;i++){
            if(nums[i] == saved){
                if(tFlag){  ;}
                else{
                    rls.add(nums[i]);   counter++;  tFlag=true;
                }
            }else{
                rls.add(nums[i]);
                saved = nums[i];
                tFlag = false;
                counter++;
            }
        }
        Iterator<Integer> it = rls.iterator();  int i=0;
        while(it.hasNext()){
            nums[i++] = it.next();
        }
        
        return counter;
    }

}
