import java.util.HashMap;
import java.util.Stack;
import java.util.Set;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.List;;

public class day14 {

    // LeetCode 1897. Redistribute Characters to Make All Strings Equal
    public static boolean makeEqual(String[] words) {

        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < words.length; i++) {
            String st = words[i];
            for (char ch : st.toCharArray()) {
                if (map.containsKey(ch)) {
                    int a = map.get(ch);
                    map.put(ch, a + 1);
                } else {
                    map.put(ch, 1);
                }
            }
        }
        int n = words.length;
        for (int x : map.values()) {
            if (x % n != 0)
                return false;
        }
        return true;
    }

    // 1417. Reformat The String
    public static String reformat(String s) {
        StringBuilder ans = new StringBuilder();
        Stack<Character> character = new Stack<>();
        Stack<Character> number = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                number.push(ch);
            } else {
                character.push(ch);
            }
        }
        if (character.size() - number.size() > 1)
            return ans.toString();
        while (!character.isEmpty() && !number.isEmpty()) {
            ans.append(character.pop()).append(number.pop());
        }
        if (!character.isEmpty()) {
            ans.append(character.pop());
        } else if (!number.isEmpty()) {
            ans.insert(0, number.pop());
        }

        return ans.toString();
    }

    // 1331. Rank Transform of an Array
    public static int[] arrayRankTransform(int[] arr) {
        Set<Integer> set1 = new TreeSet<Integer>();
        for (int i = 0; i < arr.length; i++) {
            set1.add(arr[i]);
        }
        HashMap<Integer, Integer> map = new HashMap<>();
        int rank = 1;
        for (int num : set1) {
            map.put(num, rank++);
        }
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = map.get(arr[i]);
        }
        return result;
    }

    // 54. Spiral Matrix
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ans = new ArrayList<Integer>();
        int m = matrix[0].length;
        int n = matrix.length;
        int left = 0;
        int right = m - 1;
        int top = 0;
        int bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans.add(matrix[top][i]);
            }
            top++;

            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }

            right--;
            if (top <= bottom) {

                for (int i = right; i >= left; i--) {
                    ans.add(matrix[bottom][i]);
                }
                bottom--;

            }
            if (left <= right) {
                for (int i = bottom; i >= top; i--) {
                    ans.add(matrix[i][left]);
                }
                left++;
            }
        }
        return ans;
    }

    // 59. Spiral Matrix II
    public static int[][] generateMatrix(int n) {
        int count = 1;
        int[][] ans = new int[n][n];
        int left = 0;
        int top = 0;
        int bottom = n - 1;
        int right = n - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                ans[top][i] = count;
                count++;
            }
            top++;
            for (int i = top; i <= bottom; i++) {
                ans[i][right] = count;
                count++;
            }
            right--;
            if (top <= bottom) {
                for (int i = right; i >= left; i--) {
                    ans[bottom][i] = count;
                    count++;
                }
                bottom--;
            }
            if (left <= right) {

                for (int i = bottom; i >= top; i--) {
                    ans[i][left] = count;
                    count++;
                }
                left++;
            }
        }
        return ans;
    }

    public static void main(String[] args) {

    }

}
