package Leetcode;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

class day1 {
    // Leetcode 1287
    private static int findSpecialInteger(int[] arr){
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<arr.length;i++){
            if(map.containsKey(arr[i])){
                int x = map.get(arr[i]);
                map.remove(arr[i]);
                map.put(arr[i], x+1);
            }else{
                map.put(arr[i], 1);
            }
        }
        Integer[] val = map.values().toArray(new Integer[0]);
        Integer[] key = map.keySet().toArray(new Integer[0]);
        int n = arr.length;
        int ax = -1;
        for(int i=0;i<val.length;i++){
            if(val[i] > n/4){
                ax = val[i];
            }
        }
        int ans = 0;
        for(int i=0;i<key.length;i++){
            if(map.get(key[i])==ax){
                ans = key[i];
                return ans;
            }
        }

        return ans;
    }

    private static void swap(int[]arr,int x,int idx){
        int y = arr[arr.length-1];
        arr[1] = y;
        arr[arr.length-1] = x;
    }

    private static int getWinner(int[] arr, int k) {
        int ans = arr[0];
        int win_count = 0;
        for(int i=1;i<arr.length && win_count<k;i++){
            if(arr[i]>ans){
                ans = arr[i];
                win_count = 1;
            }else{
                win_count++;
            }
        }
       return ans;
    }
     // Leetcode 118 and 119 one line change only
    private static List<List<Integer>> pascal(int numRows){
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ls1 = new ArrayList<>();
        ls1.add(1);
        List<Integer> ls2 = new ArrayList<>();
        ls2.add(1);
        ls2.add(1);
        ans.add(ls1);
        ans.add(ls2);
        for(int i=2;i<numRows;i++){
            List<Integer> ls = new ArrayList<>(i+1);
            ls.add(1);
            List<Integer> local = ans.get(i-1);
            for(int j=1;j<i;j++){
                int x = local.get(j);
                int y = local.get(j-1);
                
                ls.add(x+y);

            }
            ls.add(1);
            ans.add(ls);
        }
        return ans;
    }

    // Leetcode 2221
    private static int[] sum(int[] arr){
        int[] ans = new int[arr.length-1];
        for(int i=0;i<ans.length;i++){
            ans[i] = arr[i]+arr[i+1];
            if(ans[i]>=10){
                ans[i] = ans[i]-10;
            }
        }
        return ans;
    }
    private static int triangularSum(int[] nums) {
        int ans = 0;
        int s = nums.length;
        int[] arr = nums;
        for(int i=0;i<s-1;i++){
            arr = sum(arr);
        }
        ans = arr[0];
        return ans;
    }

    //Leetcode 2225
    private static List<List<Integer>> findWinners(int[][] matches) {
        List<List<Integer>> ans = new ArrayList<>();
        int row = matches.length;
        int col = 2;
        HashMap<Integer,Integer> mapp1 = new HashMap<>();
        HashMap<Integer,Integer> mapp2 = new HashMap<>();
        for(int[] arr : matches ){
            int a = arr[0];
            int b = arr[1];
         //   System.out.println(Arrays.toString(arr));
            if(!mapp2.containsKey(b)){
                mapp2.put(b, 1);
            }else if(mapp2.containsKey(b)){
                int re = mapp2.get(b);
                mapp2.remove(b);
                mapp2.put(b, re+1);
            }


            if(!mapp1.containsKey(a)){
                mapp1.put(a, 1);
            }else if(mapp1.containsKey(a)){
                int re = mapp1.get(a);
                mapp1.remove(a);
                mapp1.put(a, re+1);
            }
            
        }

        List<Integer> ans1 = new ArrayList<>();
        List<Integer> ans2 = new ArrayList<>();
        for(int a : mapp2.keySet()){
            if(mapp2.get(a)==1){
                ans2.add(a);
            }
        }
        for(int a: mapp1.keySet()){
            if(!mapp2.containsKey(a)){
                ans1.add(a);
            }
        }
        Collections.sort(ans1);
        Collections.sort(ans2);
        ans.add(ans1);
        ans.add(ans2);
        return ans;
    }


    // optimised approach to solve the above problem without hashmap and sorting
    private static List<List<Integer>> findWinner1(int[][] nums){
        List<List<Integer>> ans = new ArrayList<>();
        int[] arr = new int[100001];
        for(int[] match : nums){
            int win = match[0];
            int loss = match[1];
            if(arr[win]==0){
                arr[win] = -1;
            }
            if(arr[win] ==-1){
                arr[win] = 1;
            }else{
                arr[win]++;
            }
        }

        List<Integer> winner = new ArrayList<>();
        List<Integer> losser = new ArrayList<>();
        for(int i=0;i<arr.length;i++){
            if(arr[i]==-1){
                winner.add(arr[i]);
            }
            else if(arr[i]==1){
                losser.add(arr[i]);
            }
        }
        ans.add(winner);
        ans.add(losser);
        return ans;
    }

    // LeetCode 10389
    // This is based on a famous recurrance relation used in matrix chain multiplication
    private static int iterator(int[] values,int i,int j){
        int ans = Integer.MAX_VALUE;
        for(int k=i+1;k<j;k++){
            ans = Math.min(ans,values[i]*values[j]*values[k]+iterator(values, i, k)+iterator(values, k, j));
        }
        if(ans == Integer.MAX_VALUE) return 0;
        return ans;
    }

   

    public static void main(String[] args){
        int[] arr = {2,3,5,1,3,2};
       // System.out.println(findScore(arr));
       sum(arr);
    }
    
}