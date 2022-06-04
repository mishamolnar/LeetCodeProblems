package LeetCode.myImpls;

import java.util.HashMap;

//https://leetcode.com/problems/logger-rate-limiter/
//O(n) space and constant time
public class Logger {
    HashMap<String, Integer> map;

    public Logger() {
        map = new HashMap<>();
    }

    public boolean shouldPrintMessage(int timestamp, String message) {
        if (map.getOrDefault(message, Integer.MIN_VALUE) + 10 > timestamp) return false;
        else {
            map.put(message, timestamp);
            return true;
        }
    }
}
