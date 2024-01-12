package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.TreeMap;
import java.util.List;
import java.util.Queue;

/**
 * day27
 */
public class day27 {

    // 1704. Determine if String Halves Are Alike
    private boolean check(char ch){
        if(ch=='a' || ch=='e' || ch =='i' || ch=='o' || ch=='u') return true;
        return false;

    }
    public boolean halvesAreAlike(String s) {
        s = s.toLowerCase();
        boolean ans = false;
        int count1 = 0;
        int count2 = 0;

        for(int i = 0;i<s.length();i++){
            if(i<s.length()/2) {
                if(check(s.charAt(i))) count1++;
            }

            else if(i>=s.length()/2){
                if(check(s.charAt(i))) count2++;
            }

        }

        if(count1==count2) return true;
        return ans;

    }

    public boolean halvesAreAlike1(String s) {
        
        boolean ans = false;
        int count1 = 0;
        int count2 = 0;
        s = s.toLowerCase();
        for(int i = 0;i<s.length()/2;i++){
            
            if(check(s.charAt(i))) count1++;

            if(check(s.charAt(s.length()-1-i))) count2++;

        }
        
        if(count1==count2) return true;
        return ans;

    }

    
    // 2856. Minimum Array Length After Pair Removals
    public int minLengthAfterRemovals(List<Integer> nums) {
        int cnt = 0;
        int n = nums.size();
        int i = 0;
        int j = n/2;
        while(i<n/2 && j<n){
            if((long)nums.get(i)==(long)nums.get(j)) {
                j++;
            }
            else if((long)nums.get(i)<(long)nums.get(j)){
                i++;
                j++;
                cnt++;
            }
        }
        return n-(2*cnt);
     }


    public Queue<Integer> modifyQueue(Queue<Integer> q, int k) {
        // add code here.
        return null;
    }

    public static void main(String[] args) {
        System.out.println("let us start!");
        Queue<Integer> que = new LinkedList<>();
        que.offer(2);
        que.offer(3);
        que.offer(4);
        que.offer(5);
        int[] arr = new int[2];
        arr[0] = que.poll();
        arr[1] = que.poll();
        System.out.println(que); 
        que.offer(arr[1]);
        que.offer(arr[0]); 
        System.out.println(que);
    }
}