public class day12 {

    // LeetCode 1578. Minimum Time to Make Rope Colorful
    public static int minCost(String colors, int[] neededTime) {
        int ans = 0;
        int n = colors.length();
        for (int i = 1; i < colors.length(); i++) {
            if (i != 0 && colors.charAt(i) == colors.charAt(i - 1)) {
                char ch = colors.charAt(i);
                int max = neededTime[i - 1];
                int total = neededTime[i - 1];
                while (i < n && colors.charAt(i) == ch) {
                    max = Math.max(max, neededTime[i]);
                    total += neededTime[i];
                    i++;
                }
                ans += total - max;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }
}
