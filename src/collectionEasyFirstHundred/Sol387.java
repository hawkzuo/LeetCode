package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/9/10.
 * First Unique Character in a String
 */
public class Sol387 {
    // Idea: Another Bucket Sort example
    public int firstUniqChar(String s) {
        int [] buckets = new int[26];
        char [] str = s.toCharArray();

        for (char step : str) {
            buckets[step - 'a']++;
        }
        for(int i=0;i<str.length;i++){
            if(buckets[str[i]-'a'] == 1){
                return i;
            }
        }
        return -1;
    }
}
