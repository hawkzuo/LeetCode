package collectionEasySecondHundred;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Amos on 2017/8/28.
 * Third Maximum Number
 */
public class Sol414 {
    // Idea: Store the distinct first three largest numbers
    // Corner case is very plenty, thus had to use boxing type and checking
    public int thirdMax(int[] nums) {
        if(nums == null || nums.length == 0){   return -1;  }
        Integer m1 = nums[0];
        Integer m2 = null;
        Integer m3 = null;

        for (int num : nums) {
            if(m2 == null) {
                if (num != m1) {
                    if(num > m1) {
                        m2 = m1;
                        m1 = num;
                    } else {
                        m2 = num;
                    }
                }
            } else if (m3 == null) {
                if(num != m1 && num != m2) {
                    if(num > m1) {
                        m3 = m2;
                        m2 = m1;
                        m1 = num;
                    }else if(num > m2) {
                        m3 = m2;
                        m2 = num;
                    } else {
                        m3 = num;
                    }
                }
            } else {
                if(num != m1 && num != m2 && num != m3) {
                    if(num > m1) {
                        m3 = m2;
                        m2 = m1;
                        m1 = num;
                    }else if(num > m2) {
                        m3 = m2;
                        m2 = num;
                    } else if(num > m3) {
                        m3 = num;
                    }
                }
            }
        }
        return m3 != null ? m3 : m1;
    }

    // Set version
    public int thirdMaxViaSet(int[] nums) {
        if(nums == null || nums.length == 0){   return -1;  }
        int m1 = Integer.MIN_VALUE;
        int m2 = Integer.MIN_VALUE;
        int m3 = Integer.MIN_VALUE;
        Set<Integer> refer = new HashSet<Integer>();
        for (int num : nums) {
            if (refer.contains(num)) {
                continue;
            }
            if (num > m1) {
                m3 = m2;
                m2 = m1;
                m1 = num;
            } else if (num > m2) {
                m3 = m2;
                m2 = num;
            } else if (num > m3) {
                m3 = num;
            }
            refer.add(num);
        }
        if(refer.contains(m3) && refer.size() >= 3){ return m3;  }
        return m1;
    }

    public static void main(String[] args) {
        Sol414 s = new Sol414();
        int[] A = {3,2,1};
        int[] B = {};
        StringBuilder sb = new StringBuilder();
        System.out.println(s.thirdMax(A));
    }
}
