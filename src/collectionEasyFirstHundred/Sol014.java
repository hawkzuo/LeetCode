package collectionEasyFirstHundred;

/**
 * Created by Amos on 2017/8/24.
 * Longest Common Prefix
 */
public class Sol014 {
    public String longestCommonPrefix(String[] strs) {

        if(strs == null || strs.length==0){return "";}
        if(strs.length == 1){return strs[0];}

        int numberOfStrings=strs.length;

        char [][]	arrayOfStrings=new char[numberOfStrings][];

        int minimalLength=10000000;

        for(int i=0;i<numberOfStrings;i++){
            if(strs[i] == null || strs[i].length()==0){return "";}
            arrayOfStrings[i]=strs[i].toCharArray();
            minimalLength = Math.min(minimalLength, arrayOfStrings[i].length);
        }

        StringBuilder sb=new StringBuilder();
        mainLoop:
        for(int j=0;j<minimalLength;j++){
            int k=0;
            char value=arrayOfStrings[k][j];
            while(k<numberOfStrings){
                if(value != arrayOfStrings[k][j]){
                    break mainLoop;
                }else{
                    k++;
                }
            }
            sb.append(value);
        }
        return sb.toString();
    }
}
