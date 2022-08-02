package LeetCode.dynamic;

import java.util.HashMap;
import java.util.Map;

//https://leetcode.com/problems/student-attendance-record-ii/submissions/
public class StudentAttendanceRecordII {
    public int checkRecord(int n) {
        int m = 1000000007;

        if(n == 1) return 3;

        int[] A = new int[n];
        int[] P = new int[n];
        int[] L = new int[n];

        P[0] = 1;
        L[0] = 1;
        L[1] = 3;
        A[0] = 1;
        A[1] = 2;
        A[2] = 4;


        for (int i = 1; i < n; i++) {
            A[i - 1] %= m;
            P[i - 1] %= m;
            L[i - 1] %= m;

            P[i] = ((A[i - 1] + P[i - 1]) % m + L[i - 1]) % m;
            if(i > 1) L[i] = ((A[i - 1] + P[i - 1]) % m + (A[i - 2] + P[i - 2]) % m) % m;
            if(i > 2) A[i] = ((A[i - 1] + A[i - 2]) % m + A[i - 3]) % m;
        }

        return ((A[n - 1] % m + P[n - 1] % m) % m + L[n - 1] % m) % m;
    }


    //tle
    private int helper(int l, boolean abs, int n, Map<String, Integer> memo) {
        if (n == 0) return 0;
        if (n == 1)
            return (l > 0 ? 1 : 0) + (abs ? 1 : 0) + 1;
        String curr = new StringBuilder(abs ? "A" : "")
                .append(l)
                .append("L")
                .append(n)
                .toString();
        if (memo.containsKey(curr)) return memo.get(curr);
        long res = (long) (l > 0 ? helper(l - 1, abs, n - 1, memo) : 1)
                + helper(2, abs, n - 1, memo)
                + (abs ? helper(2, false, n - 1, memo) : 1);
        int out =  (int) (res % (Math.pow(10, 9) + 7));
        memo.put(curr, out);
        return out;
    }

    public static void main(String[] args) {
        StudentAttendanceRecordII studentAttendanceRecordII = new StudentAttendanceRecordII();
        System.out.println(studentAttendanceRecordII.checkRecord(2));
    }
}
