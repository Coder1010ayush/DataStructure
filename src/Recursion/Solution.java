package Recursion;

import java.util.* ;
import java.util.ArrayList;

public class Solution {
    public static int sum(int n){
        int temp =n;
        int sum=0;
        while(temp>0){
           sum += temp%10;
           temp = temp/10;
        }
        if(sum>=10) return sum(sum);
        return sum;
    }
    public static ArrayList<ArrayList<Integer>> numberPattern(int n) {

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int count =1;
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> loc = new ArrayList<>();

            for (int j = 1; j <=i ; j++) {
                if(count>=10){
                    int data = sum(count);
                    loc.add(data);
                }
               else loc.add(count);
               count++;
            }
            ans.add(loc);
        }
       return ans;
    }

    public static  List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList());

        for(int i=0;i<nums.length;i++){

            int n = ans.size();

            for(int j=0;j<n;j++){
                ArrayList<Integer> local = new ArrayList(ans.get(j));
                local.add(nums[i]);
                ans.add(local);
            }
        }
        return ans;
    }
    public static void main(String[] args) {
       //ArrayList<ArrayList<Integer>> ans = new ArrayList<>();

     //  ans = numberPattern(11);
      //  System.out.println(ans);
        //System.out.println(sum(294));
        int[] nums = {1,2,3,1,2,4,5,5};
       // System.out.println(subsets(nums));
        int[] ans = new int[8];
        for (int i = 0; i < ans.length; i++) {
            ans[nums[i]-1]++;
        }
        System.out.println(Arrays.toString(ans));
    }
}