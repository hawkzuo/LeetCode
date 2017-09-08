package collectionACompanies.facebook;

import collectionUtils.NestedInteger;

import java.util.*;
/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer, rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds, if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds, if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class NestedIterator implements Iterator<Integer> {
    List<NestedInteger> givenList;
    Deque<NestedInteger> stack;
    boolean emptySign;


    public NestedIterator(List<NestedInteger> nestedList) {
        stack = new ArrayDeque<NestedInteger>();
        if(nestedList == null || nestedList.size() == 0){
            emptySign = true;
        }else{
            emptySign = false;
        }

        givenList = nestedList;
        if(!emptySign){
            for(int i=nestedList.size()-1;i>=0;i--){
                stack.push(givenList.get(i));
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
        List<NestedInteger> toadd = input.getList();
        for(int i=toadd.size()-1;i>=0;i--){
            stack.push(toadd.get(i));
        }
    }    
    
    
}

/**
 * Your Sol341NestedIterator object will be instantiated and called as such:
 * Sol341NestedIterator i = new Sol341NestedIterator(nestedList);
 * while (i.hasNext()) v[f()] = i.next();
 */
