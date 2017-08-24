package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/24.
 * Roman to Integer
 */
public class Sol013 {
    // Idea: Add each bit when first encountering
    // If previous is smaller than current, deduct twice the previous value will do
    public int romanToInt(String s) {
        char [] str = s.toCharArray();

        int prev = 0;
        int sum = 0;

        for (char stepChar : str) {
            int now = convertBit(stepChar);
            if (prev < now) {
                sum = sum + now - 2 * prev;
            } else {
                //<=
                sum += now;
            }
            prev = now;
        }
        return sum;
    }
    private int convertBit(char ch){

        if(ch >= 'a' && ch <= 'z'){
            ch -= 32;
        }

        switch(ch){
            case 'I': return 1;
            case 'V': return 5;
            case 'X': return 10;
            case 'L': return 50;
            case 'C': return 100;
            case 'D': return 500;
            case 'M': return 1000;
            default: return -1;
        }
    }
}
