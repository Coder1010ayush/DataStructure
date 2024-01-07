/**
 * day22
 */

import java.util.HashMap;
public class day22 {


    // LeetCode 446. Arithmetic Slices II - Subsequence

    public int numberOfArithmeticSlices(int[] nums) {
        int ans = 0;
        int n = nums.length;
        HashMap<Long,Integer> mp [] = new HashMap [n];
        
        for(int i=0;i<n;i++){
            mp[i] = new HashMap<Long,Integer>();
            for(int j=0;j<i;j++){

                long diff = (long) nums[i]-nums[j];
                int count = mp[j].getOrDefault(diff, 0);
                ans += count;
                mp[i].put(diff,mp[i].getOrDefault(diff, 0)+count+1);

            }

        }

        return ans;
    }

    public static void main(String[] args) {
        System.out.println("let us start");
    }
}