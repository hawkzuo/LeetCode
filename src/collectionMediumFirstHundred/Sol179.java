package collectionMediumFirstHundred;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Amos on 2017/8/11.
 * Largest Number
 */
public class Sol179 {
    public String largestNumber(int[] nums) {
        StringBuilder res= new StringBuilder();
        List<Integer> newList = new ArrayList<>();
        for (int num : nums) {
            newList.add(num);
        }
        Collections.sort(newList,new Comparator<Integer>(){
            @Override
            public int compare(Integer o1, Integer o2) {
                int l = o1;	int r= o2;
                // Minimum is zero
                if(l == 0){	return 1;}	if(r == 0){	return -1;}

                int lbits = 1;	int rbits=1;
                while(l/10 !=0){	lbits++; l/=10;	}
                while(r/10 != 0){	rbits++; r/=10;	}

                // Since the case is plenty, just compare two possible combinations among these two numbers
                l = o1;r= o2;
                long r1 = (long)l*pow(rbits)+r;
                long r2 = (long)r*pow(lbits)+l;
//                if(r1 < r2){
//                    return 1;
//                }else if(r1 > r2){
//                    return -1;
//                }else{
//                    return 0;
//                }
                return Long.compare(r2, r1);
            }
        });
        // Corner case
        if(newList.get(0) == 0){	res.append("0");	return res.toString();}
        for (Integer aNewList : newList) {
            res.append(aNewList);
        }
        return res.toString();
    }
    private int pow(int times){
        int res = 1;
        for(int i=0;i<times;i++){
            res *=10;
        }
        return res;
    }
}
