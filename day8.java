import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class day8 {

    // LeetCode 1913. Maximum Product Difference Between Two Pairs
    public static int maxProductDifference(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[1];

        int c = nums[nums.length - 1];
        int d = nums[nums.length - 2];
        int ans = Math.abs((a * b) - (c * d));
        return ans;
    }

    // LeetCode 2840. Check if Strings Can be Made Equal With Operations II
    private static boolean checkStrings(String s1, String s2) {
        int[] even_s1 = new int[26];
        int[] even_s2 = new int[26];
        int[] odd_s1 = new int[26];
        int[] odd_s2 = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            if (i % 2 == 0) {
                even_s1[ch1 - 'a'] += 1;
                even_s2[ch2 - 'a'] += 1;
            } else {
                odd_s1[ch1 - 'a'] += 1;
                odd_s2[ch2 - 'a'] += 1;
            }
        }
        for (int i = 0; i < 26; i++) {
            if (even_s1[i] != even_s2[i] || odd_s1[i] != odd_s2[i])
                return false;
        }
        return true;
    }

    // another way to do it
    private static boolean checkStrings1(String s1, String s2) {
        int[] store = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            store[s1.charAt(i - 'a')]++;
            store[s2.charAt(i) - 'a']--;
        }
        for (int i = 0; i < store.length; i++) {
            if (store[i] != 0)
                return false;
        }
        return true;
    }

    // LeetCode 648 Replace String
    public static String replaceWords(List<String> dictionary, String sentence) {
        String[] arr = sentence.split(" ");
        String ans = "";
        Collections.sort(dictionary);
        for (int i = 0; i < arr.length; i++) {
            String toupdate = arr[i];
            for (String str : dictionary) {
                if (toupdate.startsWith(str)) {
                    arr[i] = str;
                    break;
                } else
                    continue;
            }
        }
        System.out.println(Arrays.toString(arr));
        for (String st : arr) {
            ans = ans.concat(st + " ");
        }
        return ans.substring(0, ans.length() - 1);
    }

    public static void main(String[] args) {
        List<String> dictionary = new ArrayList<>();
        dictionary.add("answer");
        dictionary.add("vedic");
        String sentence = "this is a dog";

        replaceWords(dictionary, sentence);
    }
}
