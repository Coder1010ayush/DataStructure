class day11 {

    // LeetCode 1155. Number of Dice Rolls With Target Sum
    static int[][] dp = new int[31][1001];
    static long M = 1000000007;

    private static int helper(int n, int k, int target) {
        if (target < 0)
            return 0;

        if (target == 0) {
            if (n == 0)
                return 1;
        }
        if (dp[n][target] != -1)
            return dp[n][target];

        int ways = 0;
        for (int face = 1; face <= k; face++) {
            ways = (ways + helper(n - 1, k, target - face)) % (int) M;
        }

        return dp[n][target] = ways;
    }

    public static int numRollsToTarget(int n, int k, int target) {
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[i].length; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = helper(n, k, target);

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Starting");

    }
}