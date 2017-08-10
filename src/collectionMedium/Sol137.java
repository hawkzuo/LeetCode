package collectionMedium;

/**
 * Created by Amos on 2017/8/10.
 * Single Number II
 */
public class Sol137 {
    public int singleNumber(int[] nums) {
        //we need to implement a three-time counter(base 3) that if a bit appears three time ,it will be zero.

        // a=~abc+a~b~c;
        // b=~a~bc+~ab~c;
//        a b c     a b
//        0 0 1  -> 0 1
//        0 0 0  -> 0 0
//        0 1 1  -> 1 0
//        0 1 0  -> 0 1
//        1 0 1  -> 0 0
//        1 0 0  -> 1 0

        int A=0;
        int B=0;
        for(int C:nums){
            int newA=(~A&B&C)|(A&~B&~C);
            B=(~A&~B&C)|(~A&B&~C);
            A=newA;
        }
        // Bit Operation has nothing to do with order. Suppose last element is the single number
        // At this time, A==0, B==0, truth table only remains 2 rows:
        // 0 0 1  -> 0 1
        // 0 0 0  -> 0 0
        return B;
    }

}
