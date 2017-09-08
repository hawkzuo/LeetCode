package collectionMediumSecondHundred;

import collectionUtils.NestedInteger;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Amos on 2017/9/10.
 * Flatten Nested List Iterator
 */
public class Sol341NestedIterator implements Iterator<Integer> {
    // Idea: Use DFS traverse and then save the Iterator of the List
    private Iterator<Integer> iterator;
    public Sol341NestedIterator(List<NestedInteger> nestedList) {
        List<Integer> stored = new ArrayList<>();
        if (nestedList != null && nestedList.size() != 0) {
            recursivelyTraverse(nestedList, stored);
        }
        iterator = stored.iterator();
    }

    private void recursivelyTraverse(List<NestedInteger> nestedList, List<Integer> list) {
        for(NestedInteger item: nestedList) {
            if(item.isInteger()) {
                list.add(item.getInteger());
            } else {
                recursivelyTraverse(item.getList(), list);
            }
        }
    }

    @Override
    public boolean hasNext() {
        return iterator.hasNext();
    }

    @Override
    public Integer next() {
        return iterator.next();
    }
}
