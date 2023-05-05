package LeetCode.string;

public class Dota2Senate {
    public String predictPartyVictory(String senate) {
        //RRRDDDD
        //brute force - simulation, k * n, where k - number of rounds
        char[] arr = senate.toCharArray();
        int rSkip = 0, dSkip = 0, r = 0, d = 0;
        do {
            r = 0;
            d = 0;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] == 'R') {
                    r++;
                    if (rSkip > 0) {
                        arr[i] = '.';
                        rSkip--;
                    } else dSkip++;
                } else if (arr[i] == 'D') {
                    d++;
                    if (dSkip > 0) {
                        arr[i] = '.';
                        dSkip--;
                    } rSkip++;
                }
            }
        } while (r != 0 && d != 0);
        return r == 0 ? "Dire" : "Radiant";
    }
}
