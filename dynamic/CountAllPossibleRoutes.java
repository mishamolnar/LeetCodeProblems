package LeetCode.dynamic;

public class CountAllPossibleRoutes {
    public int countRoutes(int[] locations, int start, int finish, int fuel) {
        int[][] dp = new int[fuel + 1][locations.length];
        dp[fuel][start] = 1;
        for (int fuelLeft = fuel; fuelLeft >= 0; fuelLeft--) {
            for (int location = 0; location < locations.length; location++) {
                if (dp[fuelLeft][location] != 0) {
                    for (int nextLocation = 0; nextLocation < locations.length; nextLocation++) {
                        if (fuelLeft >= Math.abs(locations[location] - locations[nextLocation]) && nextLocation != location) {
                            int nextFuel = fuelLeft - Math.abs(locations[location] - locations[nextLocation]);
                            dp[nextFuel][nextLocation] += dp[fuelLeft][location];
                            dp[nextFuel][nextLocation] %= 1_000_000_007;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i <= fuel; i++) {
            res += dp[i][finish];
            res %= 1_000_000_007;
        }
        return res;
    }
}
