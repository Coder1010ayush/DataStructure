import java.util.Arrays;

public class day20 {

    private int dp[][] = new int[2501][2501];

    private int rec(int[] nums, int index, int prev) {
        if (index == nums.length)
            return 0;
        if (dp[index][prev + 1] != -1)
            return dp[index][prev + 1];
        int len = 0;
        // not take condition
        len += rec(nums, index + 1, prev);

        // teke condition
        int max = 0;
        if (prev == -1 || nums[index] > nums[prev]) {
            max = 1 + rec(nums, index + 1, index);
        }

        return dp[index][prev + 1] = Math.max(max, len);
    }

    public int lengthOfLIS(int[] nums) {
        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }
        return rec(nums, 0, -1);
    }

    // alter ways to solve this problem
    public int lengthOfLIS1(int[] nums) {

        // bottom up solution
        int ans = Integer.MIN_VALUE;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    ans = Math.max(ans, dp[i]);
                }
            }
        }

        if (ans == Integer.MIN_VALUE)
            return 1;
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
