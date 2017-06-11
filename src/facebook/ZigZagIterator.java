package facebook;
import java.util.*;
public class ZigZagIterator {

    Deque<Integer> q;
    int Type;
    List<Integer> sList;
    int counter;

    int comLen;
    boolean isEqual;
    
    public ZigZagIterator(List<Integer> v1, List<Integer> v2) {
        q = new ArrayDeque<Integer>();
        if((v1 == null && v2 == null) || (v1.size()==0 && v2.size()==0) ){
            Type = 0;
        }else if(v1 == null || v1.size() == 0){
            Type =1;
            counter=0;
            sList = v2;
        }else if(v2 == null || v2.size() == 0){
            Type = 1;
            counter=0;
            sList = v1;
        }else{
            Type = 2;
            if(v1.size() > v2.size()){
                isEqual = false;
                comLen = Math.min(v1.size(),v2.size());
                sList = v1;
                for(int i=0;i<comLen;i++){
                    q.offer(v1.get(i));
                    q.offer(v2.get(i));
                }
                for(int i=comLen;i<sList.size();i++){
                    q.offer(sList.get(i));
                }                                
            }else if(v1.size() < v2.size()){
                isEqual = false;
                comLen = Math.min(v1.size(),v2.size());
                sList = v2;
                for(int i=0;i<comLen;i++){
                    q.offer(v1.get(i));
                    q.offer(v2.get(i));
                }
                for(int i=comLen;i<sList.size();i++){
                    q.offer(sList.get(i));
                }
                
            }else{
                isEqual = true;
                comLen = v1.size();
                for(int i=0;i<comLen;i++){
                    q.offer(v1.get(i));
                    q.offer(v2.get(i));
                }                
            }
        }
    }

    public int next() {
        if(Type == 0){  return Integer.MAX_VALUE;}
        else if(Type == 1){
            counter++;
            return sList.get(counter-1);
            
        }
        
        return q.remove();
    }

    public boolean hasNext() {
        if(Type == 0){  return false;}
        else if(Type == 1){
            if(counter < sList.size()){
                return true;
            }else{
                return false;
            }
        }        
        return !q.isEmpty();
    }
}
