import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class day19 {

    // 2870. Minimum Number of Operations to Make Array Empty
    private int find(int num) {
        int ans = 0;
        if (num % 3 == 0) {
            ans = num / 3;
            return ans;
        }
        if (num % 3 == 1) {
            ans = num / 3 + 1;
            return ans;
        }
        if (num % 3 == 2) {
            ans = num / 3 + 1;
            return ans;
        }
        return 0;
    }

    public int minOperations(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                int a = map.get(nums[i]);
                map.put(nums[i], a + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int ans = 0;
        for (int x : map.values()) {
            if (x == 1)
                return -1;
            ans += find(x);
        }
        return ans;
    }

    // 962. Maximum Width Ramp
    public int maxWidthRamp(int[] nums) {
        int ans = -1;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] >= nums[i]) {
                    ans = Math.max(ans, j - i);
                }
            }
        }
        if (ans == -1)
            return 0;
        return ans;
    }

    // another way to solve it

    public static int maxWidthRamp1(int[] nums) {
        Stack<Integer> st = new Stack<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                st.push(i);
            } else {
                if (nums[st.peek()] > nums[i])
                    st.push(i);
                else
                    continue;
            }
        }
        int ans = -1;
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[st.peek()] <= nums[i]) {
                ans = Math.max(ans, i - st.peek());
                st.pop();
            }
        }
        return ans;
    }

    // 513. Find Bottom Left Tree Value
    private int dfs(TreeNode root) {

        if (root.left == null && root.right == null)
            return root.val;
        Queue<TreeNode> que = new LinkedList<TreeNode>();
        que.offer(root);
        int ans = 0;
        while (!que.isEmpty()) {
            int size = que.size();
            boolean fl = false;
            for (int i = 0; i < size; i++) {
                TreeNode node = que.peek();

                if (node.left != null) {
                    que.offer(node.left);
                    if (!fl) {
                        ans = node.left.val;
                        fl = true;
                    }
                }
                if (node.right != null) {
                    que.offer(node.right);
                    if (!fl) {
                        ans = node.right.val;
                        fl = true;
                    }
                }
                que.poll();
            }

        }

        return ans;

    }

    public int findBottomLeftValue(TreeNode root) {
        return dfs(root);
    }

    // another way to solve this problem
    private int h = -1;
    private int ans = -1;

    private void bfs(TreeNode root, int height) {

        if (root == null)
            return;

        if (height > h) {
            h = height;
            ans = root.val;
        }

        bfs(root.left, height + 1);
        bfs(root.right, height + 1);

    }

    public int findBottomLeftValue1(TreeNode root) {
        bfs(root, 0);
        return ans;
    }

    // 865. Smallest Subtree with all the Deepest Nodes

    public static void main(String[] args) {
        System.out.println("hello");
    }
}
