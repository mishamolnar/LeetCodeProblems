package LeetCode.arrays;

import java.util.*;

public class NestedIterator implements Iterator<Integer> {
    private Deque<ListIterator<NestedInteger>> lists = new LinkedList<>();

    public NestedIterator(List<NestedInteger> nestedList) {
        lists.push(nestedList.listIterator());
    }

    @Override
    public Integer next() {
        hasNext();
        return lists.peek().next().getInteger();
    }

    @Override
    public boolean hasNext() {
        while (!lists.isEmpty()) {
            if (!lists.peek().hasNext()) {
                lists.pop();
            } else {
                NestedInteger x = lists.peek().next();
                if (x.isInteger()) {
                    lists.peek().previous();
                    return true;
                }
                lists.push(x.getList().listIterator());
            }
        }
        return false;
    }

    
    
      public interface NestedInteger {
 
              // @return true if this NestedInteger holds a single integer, rather than a nested list.
              public boolean isInteger();
 
              // @return the single integer that this NestedInteger holds, if it holds a single integer
              // Return null if this NestedInteger holds a nested list
              public Integer getInteger();
 
              // @return the nested list that this NestedInteger holds, if it holds a nested list
              // Return empty list if this NestedInteger holds a single integer
              public List<NestedInteger> getList();
  }
}
