package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/25.
 * Valid Palindrome
 */
public class Sol125 {
    // Idea: Use StringBuilder is trivial, use indices will be faster

    public boolean isPalindrome(String s) {
        //65-90: A-Z
        //97-122: a-z
        //delta = 32.
        //d+c
        char [] str = s.toCharArray();
        int i=0; int j=str.length-1;

        while(i<j){
            // Parse left character, let go unsupported chars
            char c1 = toLowercase(str[i]);
            while(c1 == 0 && i<=str.length-2){
                i++;
                c1 = toLowercase(str[i]);
            }

            // Parse right character, let go unsupported chars
            char c2 = toLowercase(str[j]);
            while(c2 == 0 && j>=1){
                j--;
                c2 = toLowercase(str[j]);
            }

            // Compare these two characters
            if(c1 == c2){
                i++;
                j--;
            }else{
                return false;
            }
        }
        return true;
    }
    private char toLowercase(char ch){
        if(ch >= 65 && ch <= 90){
            return (char) (ch+'a'-'A');
        }else if(ch >= 97 && ch <= 122){
            return ch;
        }else if(ch >= 48 && ch <= 57){
            return ch;
        }else{
            return 0;
        }
    }
}
