package LeetCode.stack;

import java.util.*;
import java.util.prefs.PreferenceChangeEvent;

//https://leetcode.com/problems/maximum-frequency-stack/
class FreqStack {
    Map<Integer, Integer> elementFrequency;
    Map<Integer, ArrayDeque<Integer>> freqToElements;
    int maxFreq;

    public FreqStack() {
        elementFrequency = new HashMap<>();
        freqToElements = new HashMap<>();
        maxFreq = 0;
    }
    
    public void push(int val) {
        int freq = elementFrequency.getOrDefault(val, 0) + 1;
        elementFrequency.put(val, freq);
        freqToElements.putIfAbsent(freq, new ArrayDeque<>());
        freqToElements.get(freq).push(val);
        maxFreq = Math.max(maxFreq, freq);
    }
    
    public int pop() {
        while (freqToElements.get(maxFreq).isEmpty()) maxFreq--;
        int val = freqToElements.get(maxFreq).pop();
        elementFrequency.put(val, elementFrequency.get(val) - 1);
        return val;
    }


    public static void main(String[] args) {
        FreqStack freqStack = new FreqStack();
        freqStack.push(1);
        freqStack.push(1);
        freqStack.push(1);
        freqStack.push(2);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        freqStack.push(2);
        freqStack.push(2);
        freqStack.push(1);
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
        System.out.println(freqStack.pop());
    }
}