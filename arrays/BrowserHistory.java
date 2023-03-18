package LeetCode.arrays;

import java.util.ArrayList;
import java.util.List;

class BrowserHistory {
    private List<String> history;
    private int last;
    private int curr;

    public BrowserHistory(String homepage) {
        history = new ArrayList<>();
        history.add(homepage);
        last = 0;
        curr = 0;
    }
    
    public void visit(String url) {
        curr++;
        last = curr;
        if (history.size() == curr) {
            history.add(url);
        } else history.set(curr, url);
    }
    
    public String back(int steps) {
        curr = Math.max(curr - steps, 0);
        return history.get(curr);
    }
    
    public String forward(int steps) {
        curr = Math.min(curr + steps, last);
        return history.get(curr);
    }
}