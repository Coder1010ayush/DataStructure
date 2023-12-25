import java.util.HashSet;

public class day9 {
    // LeetCode 1758
    public static int minOperations(String s) {
        int ans = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0')
                    count1++;
                else
                    count2++;
            } else {
                if (s.charAt(i) == '1')
                    count1++;
                else
                    count2++;
            }
        }
        ans = Math.min(count1, count2);
        return ans;
    }

    // LeetCode 1496 Path Crossing
    private static boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        String st = x + "%" + y;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N')
                y++;
            else if (ch == 'S')
                y--;
            else if (ch == 'E')
                x++;
            else
                x--;
            st = x + "%" + y;
            if (set.contains(st))
                return true;
            set.add(st);
        }
        return false;
    }

    // LeetCode 1422 Maximum score after splitting a string
    public static int maxScore(String s) {
        int ans = 0;
        int ones = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1')
                ones++;
        }
        int zeros = 0;
        int local_ones = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            if (ch == '0')
                zeros++;
            if (ch == '1')
                local_ones++;

            ans = Math.max(ans, zeros + (ones - local_ones));
        }
        return ans;
    }

    // LeetCode 2706 Buy two chocolates
    private static int buyChoco(int[] prices, int money) {
        int min_price = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < prices.length; j++) {
                if (i != j) {
                    min_price = Math.min(min_price, prices[i] + prices[j]);
                }
            }
            if (min_price >= 0)
                return min_price;
            else
                return money;
        }
    }

    public static void main(String[] args) {

    }
}
