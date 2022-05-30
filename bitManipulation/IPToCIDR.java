package LeetCode.bitManipulation;

import java.util.ArrayList;
import java.util.List;

//
public class IPToCIDR {

    public List<String> ipToCIDR(String ip, int n) {
        long x = 0;
        String[] strArr = ip.split("\\."); // we need \\ here because '.' is a keyword in regex.
        for (int i = 0; i < 4; i++) {
            x = x * 256 + Long.parseLong(strArr[i]);
        }

        List<String> ans = new ArrayList<>();

        while (n > 0) {
            long count = x & -x;
            // this count value here means if we don't change the current start ip, how many
            // more ips we can represent with CIDR
            // 7  in binary              :  00000111
            // one’s complement of 7     :  11111000
            // two's complement of 7     :  11111001
            // x & (-x) of 7             :  00000001
            //8 in binary - 00001000
            //8 & (-8) = 00000111 -> 7 more numbers
            if (count == 0) {
                count = maxLowNum(n); //for specific case "0.0.0.0"
            }
            while (count > n) {
                count /= 2; // increase the count(mask) is too large. For example count is 7 but we only need 2 more ips
            }
            ans.add(oneCIDR(x, count));
            n -= (int) count;
            x += count;
        }

        return ans;
    }

    private String oneCIDR(long x, long count) {
        int d, c, b, a;
        d = (int) x & 255;// Compute right-most part of ip
        x >>= 8;// throw away the right-most part of ip
        c = (int) x & 255;
        x >>= 8;
        b = (int) x & 255;
        x >>= 8;
        a = (int) x & 255;
        x >>= 8;

        int len = 0;
        // this while loop to know how many digits of count is in binary
        // for example, 00001000 here the len will be 4.
        while (count > 0) {
            count /= 2;
            len++;
        }

        int mask = 32 - (len - 1);
        // Think about 255.0.0.7 -> 11111111 00000000 00000000 00000111
        // x & -x of it is 00000001, the mask is 32. (which is 32 - (1 - 1))

        return new StringBuilder()
                .append(a)
                .append(".")
                .append(b)
                .append(".")
                .append(c)
                .append(".")
                .append(d)
                .append("/")
                .append(mask)
                .toString();
    }

    private int maxLowNum(int x) {
        int len = 0;
        while (x > 1) {
            x >>= 1;
            len++;
        }
        return 1 << len;
    }
}
