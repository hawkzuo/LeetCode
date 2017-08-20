package collectionMedium;

/**
 * Created by Amos on 2017/8/11.
 * Reverse Words in a String II
 */
public class Sol186 {
    public void reverseWords(char[] s) {
        int len = s.length;
        rotatechar(s,0,len-1);
        int bindex = 0;
        for(int i=0;i<len;i++){
            if(s[i] == ' '){
                rotatechar(s,bindex,i-1);
                bindex = i+1;
            }
        }
        if (bindex <= len) {
            rotatechar(s,bindex,len-1);
        }
    }

    private void rotatechar(char[] chs, int begin, int end){
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
