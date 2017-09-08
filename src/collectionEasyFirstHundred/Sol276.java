package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/6.
 * Paint Fence
 */
public class Sol276 {
    // Idea: I think it's more like a middle problem
    //  First realize it's the same for either (1...k) to be the first element
    //  Then use two tables to store the information, one for the choices ending with this color,
    //  Another stores among these choices, what amount of choices already have 2 consequent colors
    //  And bottom-up generate the answer
    // This version has already optimized space cost to O(n) from O(nk)
    public int numWays(int n, int k) {
        int[] dp = new int[n+1];
        if(n == 0 || k == 0) {
            return 0;
        } else if(n == 1) {
            return k;
        } else if(n == 2) {
            return k*k;
        }

        // Now n>=3
        // choices for each color and end-color
        int choices = k;
        // choices that already duplicate with this end-color
        int duplicate = 1;
        // Now cursor is at position 3
        int cursor = 3;
        while(cursor <= n) {
            int newChoices = k * choices - duplicate;
            int newDuplicate = choices - duplicate;

            choices = newChoices;
            duplicate = newDuplicate;
            cursor ++;
        }
        return k*choices;
    }
}
