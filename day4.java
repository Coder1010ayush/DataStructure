package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;
import java.util.Stack;

public class day4 {
    // LeetCode 56. Merge Intervals
    private static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> Integer.compare(a[0],b[0]));
        LinkedList<int[]> list = new LinkedList<>();
        for (int[] is : intervals) {
            if(list.isEmpty() || list.getLast()[1]<is[0]){
                list.add(is);
            }
            else{
                list.getLast()[1] = Math.max(is[1], list.getLast()[1]);
            }
        }
        return list.toArray(new int[list.size()][]);
        
    }

    // LeetCode 496. Next Greater Element I
    private static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        int cnt = 0;
        for (int i : nums1) {
            int maxi = -1;
            boolean flag = false;
            for (int j : nums2) {
                if(i==j || flag){
                    if(j>i){
                        maxi = j;
                        break;
                    }
                    flag = true;
                }
                
            }
            ans[cnt] = maxi;
            cnt++;
        }
        return ans;
    }

    //LeetCode 739. Daily Temperatures
    private static int[] dailyTemperatures(int[] temperatures) {
        int[] arr = new int[temperatures.length];
        for(int i=0;i<temperatures.length-1;i++){
            boolean flag = false;
            int count = 0;
            for(int j=i+1;j<temperatures.length;j++){
                if(temperatures[i]<temperatures[j]){
                    count = j-i;
                    break;
                }
            }
            arr[i] = count;
        } 
        return arr;
        
    }

    // another way to doing it using stack
    private static int[] temperatureFinding(int[] temperatures){
        int[] ans = new int[temperatures.length];
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && temperatures[i]>= temperatures[st.peek()]){
                st.pop();
            }
            if(!st.empty()){
                ans[i] = st.peek()-i;
            }
            st.push(i);
        }
        return ans;
    }

    // LeetCode 593. Valid Square
     private static int find(int[] arr1,int[] arr2){
        int x1 = arr1[0];
        int x2 = arr2[0];

        int y1 = arr1[1];
        int y2 = arr2[1];
        int ans =  ((x2-x1)*(x2-x1) + (y2-y1)*(y2-y1));
        return ans;
    }
    public static boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Integer> set = new HashSet<>();
        set.add(find(p1,p2));
        set.add(find(p1,p3));
        set.add(find(p1,p4));
        set.add(find(p2,p3));
        set.add(find(p2,p4));
        set.add(find(p3,p4));
        return !set.contains(0) && set.size()==2;
    }
    
    public static void main(String[] args) {
        System.out.println("in day3 class");
        int[][] arr = {{1,1,1},{1,1,1}};

    }
}
