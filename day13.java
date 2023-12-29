public class day13 {

    // LeetCode 1335. Minimum Difficulty of a Job Schedule
    int[][] dp = new int[301][11];

    private int helper(int[] job, int index, int n, int d) {
        if (d == 1) {
            int maxima = Integer.MIN_VALUE;
            for (int i = index; i < n; i++) {
                maxima = Math.max(maxima, job[i]);
            }
            return maxima;
        }
        if (dp[index][d] != -1)
            return dp[index][d];

        int final_complexity = Integer.MAX_VALUE;
        int maxi = Integer.MIN_VALUE;
        for (int i = index; i <= n - d; i++) {
            maxi = Math.max(maxi, job[i]);
            int result = maxi + helper(job, i + 1, n, d - 1);
            final_complexity = Math.min(final_complexity, result);
        }
        return dp[index][d] = final_complexity;
    }

    public int minDifficulty(int[] jobDifficulty, int d) {
        int n = jobDifficulty.length;
        for (int i = 0; i < 301; i++) {
            for (int j = 0; j < 101; j++) {
                dp[i][j] = -1;
            }
        }
        int ans = helper(jobDifficulty, 0, n, d);
        return ans;
    }

    public static void main(String[] args) {

    }
}