public class day10 {

    // LeetCode 91 Decode Ways
    private static int[] dp = new int[100];

    private static int helper(String s, int idx, int n) {
        if (dp[idx] != -1)
            return dp[idx];
        if (idx == n)
            return dp[idx] = 1;
        if (s.charAt(idx) == '0')
            return dp[idx] = 0;
        int ans = helper(s, idx + 1, n);
        if (i + 1 < n) {
            if (s.charAt(idx) == '1' || (s.charAt(idx) == '2' && s.charAt(idx + 1) <= '6'))
                ans += helper(s, idx + 2, n);
        }
        return dp[idx] = ans;
    }

    private static int numDecodings(String s) {
        int n = s.length();
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        return helper(s, 0, n);
    }

    public static void main(String[] args) {

    }
}
