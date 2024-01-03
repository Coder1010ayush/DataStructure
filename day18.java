import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

class day18 {

    // 78. Subsets
    private static void subseq(int[] nums, int index, int n, ArrayList<Integer> temp, List<List<Integer>> ans) {
        if (index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }

        // 1 condition dont take the number
        subseq(nums, index + 1, n, temp, ans);

        // 2 condition take the number
        temp.add(nums[index]);
        subseq(nums, index + 1, n, temp, ans);
        temp.removeLast();

    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> temp = new ArrayList<>();
        subseq(nums, 0, nums.length, temp, ans);
        return ans;
    }

    // 90. Subsets II

    private void subseq1(int[] nums, int index, int n, ArrayList<Integer> temp, HashSet<List<Integer>> set,
            List<List<Integer>> ans) {

        if (index == n) {
            if (set.contains(new ArrayList(temp))) {
                return;
            } else {
                set.add(new ArrayList<>(temp));
                ans.add(new ArrayList<>(temp));
                return;
            }

        }

        // condition 1 dont take element
        subseq1(nums, index + 1, n, temp, set, ans);

        // condition2 take that element
        temp.add(nums[index]);
        subseq1(nums, index + 1, n, temp, set, ans);
        temp.removeLast();

        return;
    }

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        HashSet<List<Integer>> set = new HashSet<>();
        List<List<Integer>> ans = new ArrayList<>();

        subseq1(nums, 0, nums.length, new ArrayList<>(), set, ans);

        return ans;
    }

    // 2125. Number of Laser Beams in a Bank
    public int numberOfBeams(String[] bank) {
        int ans = 0;
        int prev = 0;
        for (int i = 0; i < bank.length; i++) {
            String str = bank[i];
            int count = 0;
            for (int j = 0; j < str.length(); j++) {
                if (str.charAt(j) == '1')
                    count++;
            }

            ans += prev * count;
            if (count == 0) {
                continue;
            } else {
                prev = count;
            }
        }
        return ans;
    }

    // 784. Letter Case Permutation

    private void helper(int index, int n, List<String> ans, StringBuilder s) {

        while (index < n && !Character.isAlphabetic(s.charAt(index)))
            index++;

        if (index < s.length()) {
            s.setCharAt(index, Character.toUpperCase(s.charAt(index)));
            helper(index + 1, n, ans, s);

            s.setCharAt(index, Character.toLowerCase(s.charAt(index)));
            helper(index + 1, n, ans, s);
        } else
            ans.add(s.toString());

    }

    public List<String> letterCasePermutation(String s) {
        List<String> ans = new ArrayList<String>();
        int n = s.length();
        helper(0, n, ans, new StringBuilder(s));
        return ans;
    }

    // 1609. Even Odd Tree

    private boolean dfs(TreeNode root) {

        if (root == null)
            return false;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int level_count = 0;
        while (!que.isEmpty()) {
            TreeNode prev = null;
            int length = que.size();
            for (int i = 0; i < length; i++) {
                if (level_count % 2 == 0) {
                    if (que.peek().val % 2 == 0)
                        return false;
                    if (prev != null && prev.val >= que.peek().val)
                        return false;
                } else {
                    if (que.peek().val % 2 == 1)
                        return false;
                    if (prev != null && prev.val <= que.peek().val)
                        return false;
                }
                prev = que.peek();
                if (que.peek().left != null)
                    que.offer(que.peek().left);
                if (que.peek().right != null)
                    que.offer(que.peek().right);
                que.poll();
            }

            level_count++;

        }
        return true;

    }

    public boolean isEvenOddTree(TreeNode root) {
        return dfs(root);
    }

    public static void main(String[] args) {
        Queue<Integer> que = new LinkedList<>();
        que.add(23);
        StringBuilder s = new StringBuilder();
        s.append("a");
        s.deleteCharAt(s.length() - 1);
        System.out.println("Hello");
    }
}