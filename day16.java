import java.util.*;

public class day16 {

    // LeetCode 455. Assign Cookies
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int i = 0;
        int j = 0;
        int count = 0;
        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                count++;
                i++;
                j++;
            } else if (s[j] < g[i])
                j++;
        }
        return count;
    }

    // 1732. Find the Highest Altitude
    public int largestAltitude(int[] gain) {
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < gain.length; i++) {
            max = Math.max(max, sum);
            sum = sum + gain[i];
        }
        max = Math.max(sum, max);
        return max;
    }

    // 605. Can Place Flowers

    public boolean canPlaceFlowers(int[] flowerbed, int n) {
        int p = flowerbed.length;
        int count = 0;
        if (p == 0) {
            return false;
        } else if (p == 1) {
            if (flowerbed[0] == 0 && n <= 1) {
                return true;
            } else if (flowerbed[0] == 1 && n == 0) {
                return true;
            } else {
                return false;
            }
        } else {
            for (int i = 0; i < flowerbed.length; i++) {
                if (i == 0) {
                    if (flowerbed[i] == 0 && flowerbed[i + 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else if (i == flowerbed.length - 1) {
                    if (flowerbed[i] == 0 && flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                } else {
                    if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i - 1] == 0) {
                        flowerbed[i] = 1;
                        count++;
                    }
                }
            }
        }
        if (count >= n)
            return true;
        else
            return false;
    }

    // 394. Decode String
    public String decodeString(String s) {
        String ans = "";
        return ans;
    }

    // 1431. Kids With the Greatest Number of Candies

    public static ArrayList<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        ArrayList<Boolean> ans = new ArrayList<Boolean>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < candies.length; i++) {
            max = Math.max(max, candies[i]);
        }
        for (int i = 0; i < candies.length; i++) {
            int x = candies[i] + extraCandies;
            if (x >= max)
                ans.add(true);
            else
                ans.add(false);
        }
        return ans;
    }

    // 2300. Successful Pairs of Spells and Potions
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int[] arr = new int[spells.length];
        Arrays.sort(potions);
        for (int i = 0; i < spells.length; i++) {
            int x = spells[i];
            int s = 0;
            int e = potions.length - 1;
            while (s <= e) {
                int mid = s + (e - s) / 2;
                long multi = (long) x * potions[mid];
                if (multi >= success)
                    e = mid - 1;
                else
                    s = mid + 1;
            }
            arr[i] = potions.length - s;
            ;
        }
        return arr;
    }

    // 1448. Count Good Nodes in Binary Tree
    private int dfs(TreeNode root, int val) {
        int total = 0;
        if (root == null)
            return 0;
        if (val <= root.val) {
            total += 1;
            val = root.val;
        }
        total += dfs(root.left, val);
        total += dfs(root.right, val);
        return total;
    }

    public int goodNodes(TreeNode root) {
        int ans = 0;
        ans += dfs(root, Integer.MIN_VALUE);
        return ans;
    }

    public static void main(String[] args) {

    }
}
