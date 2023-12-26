import java.util.HashMap;
import java.util.HashSet;

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

    // 219. Contains Duplicate II
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0)
            return false;
        int i = 0;
        HashSet<Integer> set = new HashSet<Integer>();
        for (int j = 0; j < nums.length; j++) {
            if (!set.add(nums[j])) {
                return true;
            }

            if (set.size() >= k + 1) {
                set.remove(nums[i++]);
            }
        }
        return false;
    }

    // another ways
    private static boolean alterWays(int[] nums, int k) {
        if (nums == null || nums.length < 2 || k == 0)
            return false;
        HashMap<Integer, Integer> mapp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            if (mapp.containsKey(a)) {
                if (i < mapp.get(a))
                    return true;
            }
            mapp.put(nums[i], i);
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println("Starting");

    }
}