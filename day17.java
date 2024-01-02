import java.util.ArrayList;
import java.util.List;

class day17 {

    // LeetCode 2610. Convert an Array Into a 2D Array With Conditions
    public List<List<Integer>> findMatrix(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        int[] map = new int[n + 1];
        for (int x : nums) {
            int frequency = map[x];
            if (frequency == ans.size()) {
                ans.add(new ArrayList<>());

            }
            ans.get(frequency).add(x);

            map[x]++;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println("HELL0");
    }

}