package LeetCode.heap;

import java.util.HashSet;
import java.util.Set;

//https://leetcode.com/problems/design-phone-directory/
class PhoneDirectory {
    private Set<Integer> set = new HashSet<>();

    public PhoneDirectory(int maxNumbers) {
        for (int i = 0; i < maxNumbers; i++) {
            set.add(i);
        }
    }
    
    public int get() {
        if (set.isEmpty()) return -1;
        int buff = set.iterator().next();
        set.remove(buff);
        return buff;
    }
    
    public boolean check(int number) {
        return set.contains(number);
    }
    
    public void release(int number) {
        set.add(number);
    }
}

/*
*
*  Initialize your data structure here
   @param maxNumbers - The maximum numbers that can be stored in the phone directory.
int[] next;
    int pos;
    public PhoneDirectory(int maxNumbers) {
        next = new int[maxNumbers];
        for (int i=0; i<maxNumbers; ++i){
            next[i] = (i+1)%maxNumbers;
        }
        pos=0;
    }

    Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available.
    public int get() {
        if (next[pos]==-1) return -1;
        int ret = pos;
        pos = next[pos];
        next[ret]=-1;
        return ret;
    }

    Check if a number is available or not.
    public boolean check(int number) {
        return next[number]!=-1;
    }

    Recycle or release a number.
    public void release(int number) {
        if (next[number]!=-1) return;
        next[number] = pos;
        pos = number;
    } */