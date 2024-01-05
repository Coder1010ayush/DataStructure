import java.util.ArrayList;
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

    // 203. Remove Linked List Elements
    private ListNode remove(ListNode root, int val) {

        if (root == null)
            return null;

        root.next = remove((ListNode) root.next, val);

        if (root.val == val) {
            return (ListNode) root.next;
        } else {
            return root;
        }

    }

    public ListNode removeElements(ListNode head, int val) {
        return remove(head, val);
    }

    // 1019. Next Greater Node In Linked List
    public int[] nextLargerNodes(ListNode head) {
        if (head == null)
            return new int[0];
        if (head.next == null)
            return new int[] { 0 };

        ListNode temp = head;
        ArrayList<Integer> lsi = new ArrayList<Integer>();
        while (temp != null) {
            if (temp.next == null)
                lsi.add(0);
            else {
                ListNode rec = (ListNode) temp.next;
                while (rec != null && rec.val <= temp.val)
                    rec = (ListNode) rec.next;
                if (rec == null)
                    lsi.add(0);
                else
                    lsi.add(rec.val);
            }
            temp = (ListNode) temp.next;
        }
        int[] ans = new int[lsi.size()];
        for (int i = 0; i < lsi.size(); i++) {
            ans[i] = lsi.get(i);
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("Hello World");
    }
}
