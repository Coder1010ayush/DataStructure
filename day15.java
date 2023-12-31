
import java.util.HashMap;;

public class day15 {

    // LeetCode 1624. Largest Substring Between Two Equal Characters
    public static int maxLengthBetweenEqualCharacters(String s) {
        int maxima = -1;
        for (int i = 0; i < s.length() - 1; i++) {
            char ch = s.charAt(i);
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(j) == ch)
                    maxima = Math.max(maxima, j - 1 - i);
            }

        }
        return maxima;
    }

    // Alter approach
    public static int alterApproach(String s) {
        int ans = -1;
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                ans = Math.max(ans, i - map.get(s.charAt(i)) - 1);
            } else {
                map.put(s.charAt(i), i);
            }
        }
        return ans;
    }

    // 896. Monotonic Array
    public static boolean isMonotonic(int[] nums) {
        boolean ans = true;
        boolean res = true;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] <= nums[i + 1])
                ans = true;
            else {
                ans = false;
                break;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] >= nums[i + 1])
                res = true;
            else {
                res = false;
                break;
            }
        }

        return ans || res;
    }

    // 2210. Count Hills and Valleys in an Array
    public int countHillValley(int[] nums) {
        int ans = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (nums[i] == nums[i - 1])
                continue;
            int x = nums[i];
            int f1 = i;
            int f2 = i;
            int j = i + 1;
            int k = i - 1;
            while (j < nums.length) {
                if (nums[j] != x) {
                    f1 = j;
                    break;
                }
                j++;
            }
            // System.out.println(f1);
            while (k >= 0) {
                if (nums[k] != x) {
                    f2 = k;
                    break;
                }
                k--;
            }
            if (f1 != i && f2 != i) {
                if (nums[f1] > x && nums[f2] > x)
                    ans++;
                if (nums[f1] < x && nums[f2] < x)
                    ans++;
            }
        }
        return ans;
    }

    // 2404. Most Frequent Even Element
    public int mostFrequentEven(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int count = 0;
        for (int num : nums) {
            if (map.containsKey(num)) {
                int a = map.get(num);
                map.put(num, a + 1);
            } else {
                map.put(num, 1);
            }
        }
        int ans = -1;
        int res = -1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x % 2 == 0) {
                int val = map.get(x);
                if (count == 0) {
                    ans = val;
                    res = x;
                    count++;
                } else {
                    if (val > ans) {
                        ans = val;
                        res = x;
                    } else if (val == ans) {
                        ans = val;
                        res = Math.min(res, x);
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
