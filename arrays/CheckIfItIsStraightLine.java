package LeetCode.arrays;

public class CheckIfItIsStraightLine {
    public boolean checkStraightLine(int[][] coordinates) {
        double angel = ((double) coordinates[1][0] - coordinates[0][0])
                / ((double) coordinates[1][1] - coordinates[0][1]);
        angel = angel == Double.NEGATIVE_INFINITY ? Double.POSITIVE_INFINITY : angel;
        for (int i = 2; i < coordinates.length; i++) {
            double currentAngel = ((double) coordinates[i][0] - coordinates[0][0])
                    / ((double) coordinates[i][1] - coordinates[0][1]);
            currentAngel = currentAngel == Double.NEGATIVE_INFINITY ? Double.POSITIVE_INFINITY : currentAngel;
            if (currentAngel != angel) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        System.out.println(- 8.0 / 0.0 == 8.0 / 0.0);
    }
}
