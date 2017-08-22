package collectionMediumFirstHundred;

/**
 * Created by Amos on 2017/7/13.
 * ZigZag Conversion
 */
public class Sol006 {
    public String convert(String s, int numRows) {
        // Dengcha shulie
        if(s==null || s.length()==0 || numRows<=1 || s.length()<=numRows){ return s;}
        StringBuilder p=new StringBuilder();
        char [] values=s.toCharArray();
        int len=s.length();

        int j=0;
        for(int i=0;i<numRows;i++){
            j=i;
            while(j<len){
                p.append(values[j]);
                if(i != 0 && i!= numRows-1){
                    int delta=2*numRows-2*i-2;
                    if((j+delta) < len){
                        p.append(values[j+delta]);
                    }
                }
                j+=2*numRows-2;
            }
        }
        return p.toString();
    }
}
