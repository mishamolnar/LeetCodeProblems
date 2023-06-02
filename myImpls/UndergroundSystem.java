package LeetCode.myImpls;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class UndergroundSystem {
    private Map<Integer, Map<String, Integer>> idToTimeAndStartStation;
    private Map<String, Map.Entry<Double, Integer>> stats;


    public UndergroundSystem() {
        idToTimeAndStartStation = new HashMap<>();
        stats = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        idToTimeAndStartStation.getOrDefault(id, new HashMap<>())
                .put(stationName, t);
    }
    
    public void checkOut(int id, String stationName, int t) {
        int startTime = idToTimeAndStartStation.get(id).get(stationName);
    }
    
    public double getAverageTime(String startStation, String endStation) {
        return 1.0;
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */