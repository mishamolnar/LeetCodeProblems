package LeetCode.heap;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

//https://leetcode.com/problems/design-a-leaderboard/
// this solution - O(log(n)) update and remove and O(K) top() method
//for hashMap or hashmap with heap - top() method will be O(n*log) and other constant
class Leaderboard {
    private TreeMap<Integer, Integer> sortedMap; //key - score, number of players with this score value
    private HashMap<Integer, Integer> map; //key -player id and score as a value

    public Leaderboard() {
        this.sortedMap = new TreeMap<>(Collections.reverseOrder());
        this.map = new HashMap<>();
    }

    //can be update or new player
    public void addScore(int playerId, int score) {
        if (map.containsKey(playerId)) {
            int prevScore = map.get(playerId);
            int playersWithPrevScore = sortedMap.get(prevScore);
            if (playersWithPrevScore == 1) sortedMap.remove(prevScore);
            else sortedMap.put(prevScore, playersWithPrevScore - 1);

            sortedMap.put(score, sortedMap.getOrDefault(score, 0) + 1);
            map.put(playerId, score);
        } else {
            map.put(playerId, score);
            sortedMap.put(score, sortedMap.getOrDefault(score, 0) + 1);
        }
    }

    public int top(int K) {
        int sum = 0;
        int count = 0; //in the end must be same as key

        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            int playerCount = entry.getValue();
            int score = entry.getKey();

            for (int i = 0; i < playerCount; i++) {
                sum += score;
                count++;

                if (count == K) break;
            }

            if (count == K) break;
        }

        return sum;
    }

    public void reset(int playerId) {
        int prevScore = map.get(playerId);
        int playersWithPrevScore = sortedMap.get(prevScore);
        if (playersWithPrevScore == 1) sortedMap.remove(prevScore);
        else sortedMap.put(prevScore, playersWithPrevScore - 1);

        map.remove(playerId);
    }
}


//get top k elements without sorting, using heaps:
//        for (Map.Entry<Integer, Integer> entry : this.scores.entrySet()) {
//            heap.offer(entry);
//            if (heap.size() > K) {
//                heap.poll();
//            }
//        }
// with this we are getting complexity not nlog(n), but nlog(k)
