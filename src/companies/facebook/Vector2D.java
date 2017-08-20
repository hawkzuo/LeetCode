package companies.facebook;

import java.util.Iterator;
import java.util.List;

public class Vector2D implements Iterator<Integer> {

    int curIndex;
    int vecLen;
    Iterator<Integer> curIterator;
    List<List<Integer>> givenVec;

    public Vector2D(List<List<Integer>> vec2d) {
        vecLen = vec2d.size();
        curIndex = 0;
        curIterator = null;
        givenVec=vec2d;
    }

    @Override
    public Integer next() {
        return curIterator.next();
    }

    @Override
    public boolean hasNext() {
        if(curIterator == null || !curIterator.hasNext() ){
            //try to find a new list
            curIterator = null;
            while(curIndex < vecLen){
                if(givenVec.get(curIndex) == null || givenVec.get(curIndex).size() == 0){
                    curIndex++;
                }else{
                    curIterator = givenVec.get(curIndex).iterator();
                    curIndex++;
                    break;
                }
            }
            if(curIterator == null){    return false;}
            else{   return true;}

        }else{
            return true;
        }
        
        
    }
}
