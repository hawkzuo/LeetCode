package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/7.
 * Nim Game
 */
public class Sol292 {
    // Idea:    MinMax  1 -> P1 win  -1 -> P2 win   If nothing to remove => Current user will lose
    // This problem has a super easy pattern:
    public boolean canWinNim(int n) {
        return n % 4 != 0 ;
    }
    //  Trial-1: top-down DP    heap overflow
    //  Trial-2: bottom-up DP   heap overflow
    //  Trial-3: bottom-up with optimize    => TLE
    public boolean canWinNimSpaceOptimized(int n) {
        int[] dp1 = new int[3];
        int[] dp2 = new int[3];

            dp1[2] = 1;   dp2[2] = -1;
            dp1[1] = 1;   dp2[1] = -1;
            dp1[0] = 1;   dp2[0] = -1;
            for(int i=n-4; i>=0; i--) {
                // Calculate dp1
                int tmp1 = Math.max(dp2[0], Math.max(dp2[1], dp2[2]));
                dp1[2] = dp1[1];    dp1[1] = dp1[0];    dp1[0] = tmp1;

                int tmp2 = Math.min(dp1[0], Math.min(dp1[1], dp1[2]));
                dp2[2] = dp2[1];    dp2[1] = dp2[0];    dp2[0] = tmp2;
            }
            return dp1[0] > 0;
    }

    // Top down failed
    public boolean canWinNimTopDown(int n) {
        int[] dp1 = new int[n+1];
        int[] dp2 = new int[n+1];

        return calculateResult(0, dp1,dp2, n, true) > 0;
    }

    private int calculateResult(int removed, int[] dp1,int[] dp2, int total, boolean firstPlayer) {
        if(firstPlayer) {
            if(dp1[removed] != 0) { return dp1[removed]; }
            int result = -1;
            // Try them all
            for(int i=1; i<=3; i++) {
                if(removed + i > total) {
                    continue;
                }
                result = Math.max(result, calculateResult(removed+i, dp1, dp2, total, false));
            }
            dp1[removed] = result;
            return result;
        } else {
            if(dp2[removed] != 0) { return dp2[removed]; }
            int result = 1;
            for(int i=1; i<=3; i++) {
                if(removed + i > total) {
                    continue;
                }
                result = Math.min(result, calculateResult(removed+i, dp1, dp2, total, true));
            }
            dp2[removed] = result;
            return result;
        }
    }

    public static void main(String[] args) {
        Sol292 s = new Sol292();
        int[] A = {};
        int[] B = {};

        StringBuilder sb = new StringBuilder();
        System.out.println(s.canWinNimSpaceOptimized(1348820612));
    }
}
