package google;

import java.util.List;

/**
 * Created by Amos on 2017/6/11.
 */
public class Solution281ZigZagIterator{
    boolean isFirst=true;
    boolean lock=false;
    int cursor=0;
    List<Integer> v1;
    List<Integer> v2;
    public Solution281ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        this.v1 = v1;   this.v2 = v2;
    }

    public int next() {
        int res;
        if(isFirst){    res = v1.get(cursor);   }
        else{  res = v2.get(cursor);   }
        if(!lock){
            if(!isFirst){   cursor ++;}
            isFirst = !isFirst;
        }else{cursor++; }
        return res;
    }

    public boolean hasNext() {
        if(lock){   return cursor < v1.size() || cursor < v2.size();    }

        if(cursor < v1.size() && cursor < v2.size() ){
            return true;
        }else if(cursor >= v1.size()){
            if(cursor < v2.size()){
                lock = true;
                isFirst = false;
                return true;
            }else{
                return false;
            }
        }else{
            if(cursor < v1.size()){
                lock = true;
                isFirst = true;
                return true;
            }else{
                return false;
            }
        }
    }
}
