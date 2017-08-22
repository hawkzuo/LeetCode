package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/8/10.
 * Reverse Words in a String
 */
public class Sol151 {
    public String reverseWords(String s) {
        // Idea: 3-way-reversing method
        // Pb:  empty whitespaces

        if(s == null || s.length() == 0){return "";}
        StringBuilder sb = new StringBuilder(s);
        sb.reverse();

        //Remove leading/trailing spaces first
        int i=0;
        while(i<sb.length() && sb.charAt(i) == ' '){
            i++;
        }
        sb.delete(0, i);
        if(sb.length() == 0){return "";}

        int olen=sb.length();
        int j=olen-1;
        while(j>=0 && sb.charAt(j) == ' '){
            j--;
        }
        sb.delete(j+1, olen);


        //Reverse words
        char[] chs =sb.toString().toCharArray();
        StringBuilder sb2 = new StringBuilder();

        int beginIndex = 0;
        int len= chs.length;
        i = 0;
        while(i<chs.length){
            // Reverse words one by one by performing reversing when encountering ' '
            if(chs[i] == ' '){
                rotateWord(chs,beginIndex,i-1);
                sb2.append(chs, beginIndex, i-beginIndex+1);
                i++;
                // Remove redundant whitespaces
                while(i<chs.length && chs[i] == ' '){
                    i++;
                }
                beginIndex = i;
            }else{
                i++;
            }

        }
        // Take care of leftovers (i.e. beginIndex)
        if (beginIndex <= len) {
            rotateWord(chs, beginIndex, len-1);
            sb2.append(chs,beginIndex,len-beginIndex);
        }

        return sb2.toString();
    }
    private void rotateWord(char[] chs, int begin, int end){

        int i=begin; int j=end;
        if(j <= i){	return;}

        while(i<(end+begin+1)/2){
            char t = chs[i];
            chs[i]=chs[j];
            chs[j]=t;
            i++;	j--;
        }
    }
}
