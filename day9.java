import java.util.HashSet;

public class day9 {
    // LeetCode 1758
    public static int minOperations(String s) {
        int ans = 0;
        int count1 = 0;
        int count2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0) {
                if (s.charAt(i) == '0')
                    count1++;
                else
                    count2++;
            } else {
                if (s.charAt(i) == '1')
                    count1++;
                else
                    count2++;
            }
        }
        ans = Math.min(count1, count2);
        return ans;
    }

    // LeetCode 1496 Path Crossing
    private static boolean isPathCrossing(String path) {
        HashSet<String> set = new HashSet<>();
        int x = 0;
        int y = 0;
        String st = x + "%" + y;
        for (int i = 0; i < path.length(); i++) {
            char ch = path.charAt(i);
            if (ch == 'N')
                y++;
            else if (ch == 'S')
                y--;
            else if (ch == 'E')
                x++;
            else
                x--;
            st = x + "%" + y;
            if (set.contains(st))
                return true;
            set.add(st);
        }
        return false;
    }

    public static void main(String[] args) {

    }
}
