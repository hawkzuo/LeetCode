package collectionMediumSecondHundred;

import collectionUtils.NestedInteger;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Amos on 2017/9/10.
 * Dirty version for NestedInteger Iterator
 */
public class Sol341NestedIteratorDirty implements Iterator<Integer> {

    private Deque<NestedInteger> stack;
    private boolean emptySign;

    public Sol341NestedIteratorDirty(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<>();
        emptySign = nestedList == null || nestedList.size() == 0;

        if(!emptySign){
            for(int i=nestedList.size()-1;i>=0;i--){
                stack.push(nestedList.get(i));
            }
        }
    }

    @Override
    public Integer next() {
        NestedInteger cur = stack.pop();
        return cur.getInteger();
    }

    @Override
    public boolean hasNext() {
        if(emptySign){  return false;}
        if(stack.isEmpty()){    return false;}

        NestedInteger cur = stack.peek();
        if(cur.isInteger()){
            return true;
        }else{

            while(!cur.isInteger()){
                cur = stack.pop();
                decode(cur,stack);
                //Note this sp. case is annoying, but very much required.
                if(stack.isEmpty()){    return false;}
                else{
                    cur = stack.peek();
                }
            }
            return true;
        }
    }
    //helper
    private void decode(NestedInteger input, Deque<NestedInteger> stack){
        List<NestedInteger> toAdd = input.getList();
        for(int i=toAdd.size()-1;i>=0;i--){
            stack.push(toAdd.get(i));
        }
    }
}
