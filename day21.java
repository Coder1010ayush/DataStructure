import java.util.Arrays;;

class day21 {

    private static int n;
    private int[] dp = new int[50001];

    private int find(int[][] arr, int s, int end) {

        int ans = n + 1;
        int e = n - 1;

        while (s <= e) {

            int mid = s + (e - s) / 2;
            if (arr[mid][0] >= end) {

                ans = mid;
                e = mid - 1;

            } else {
                s = mid + 1;

            }

        }

        return ans;
    }

    private int solve(int[][] arr, int idx) {

        if (idx >= n)
            return 0;
        if (dp[idx] != -1)
            return dp[idx];

        // Take condition
        int index = find(arr, idx + 1, arr[idx][1]);
        int include = arr[idx][2] + solve(arr, index);

        // Not take condition
        int skip = solve(arr, idx + 1);

        return dp[idx] = Math.max(skip, include);
    }

    public int jobScheduling(int[] startTime, int[] endTime, int[] profit) {

        Arrays.fill(dp, -1);

        n = startTime.length;
        int[][] arr = new int[n][3];

        for (int i = 0; i < n; i++) {
            arr[i][0] = startTime[i];
            arr[i][1] = endTime[i];
            arr[i][2] = profit[i];
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        return solve(arr, 0);
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }

}