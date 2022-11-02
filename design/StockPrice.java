package LeetCode.design;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

class StockPrice {
    Map<Integer, Integer> timeToValue;
    TreeSet<Integer> values;
    int last;
    int newest;

    public StockPrice() {
        timeToValue = new HashMap<>();
        values = new TreeSet<>();
        newest = Integer.MIN_VALUE;
    }
    
    public void update(int timestamp, int price) {
        if (timeToValue.containsKey(timestamp)) {
            values.remove(timeToValue.get(timestamp));
        }
        timeToValue.put(timestamp, price);
        values.add(price);
        if (timestamp > newest) {
            last = price;
            newest = timestamp;
        }
    }
    
    public int current() {
        return last;
    }
    
    public int maximum() {
        return values.last();
    }
    
    public int minimum() {
        return values.first();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */