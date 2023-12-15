package Leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;


public class day5 {

    // LeetCode 1436. Destination City
    private static String destCity(List<List<String>> paths) {
        String ans = "";
        HashSet<String> set = new HashSet<>();
        for(List<String> str : paths){
            String st = str.get(0);
            set.add(st);
        }
        for (List<String> str : paths) {
            if(!set.contains(str.get(1))){
                return str.get(1);
            }
        }
        return ans;
    }

    // 443. String Compression
    private static int compress(char[] chars) {

        StringBuilder build = new StringBuilder();
        int count = 1;
        for(int i=0;i<chars.length;i++){
            char ch = chars[i];
            while(i< chars.length-1 && chars[i]==chars[i+1]){
                count++;
                i++;
            }
            build.append(ch);
            if(count>1){
                build.append(count);
            }
            count = 1;
            
        }
        String ans = build.toString();
        char[] arr = ans.toCharArray();
        for(int i=0;i<chars.length;i++){
            if(i<arr.length){
                chars[i] = arr[i];
            }
            
        }
        return build.length();
        
    }

    // LeetCode 690. Employee Importance //Partial Correct
    private static int getImportance(List<Employee> employees, int id) {
        int sum = 0;
        for(Employee emp : employees){
            if(emp.id == id){
                sum += emp.importance;
                List<Integer> ls = emp.subordinates;
                int n = ls.size();
                for(Employee x : ls){
                    sum += x.importance;
                }
            }
        }
        return sum;
    }

    // 1313. Decompress Run-Length Encoded List
    private static int[] decompressRLElist(int[] nums) {

        int n = nums.length;
        int count = 0;
        for(int i=0;i<n;i+=2){
            int freq = nums[i];
            count += freq;
        }
        int[] ans = new int[count];
        int idx = 0;
        for(int i=0;i<nums.length;i+=2){
            Arrays.fill(ans,idx,idx+nums[i],nums[i+1]);
            idx += nums[i];
        }
        return ans;

    }

    // LeetCode 1980. Find Unique Binary String
    private static String findDifferentBinaryString(String[] nums) {
        StringBuilder ans = new StringBuilder();
        for(int i=0;i<nums.length;i++){
            if(nums[i].charAt(i)=='0'){
                ans.append("1");
            }else{
                ans.append("0");
            }

        }
        return ans.toString();
    }

    // LeetCode 1909. Remove One Element to Make the Array Strictly Increasing
    private static boolean canBeIncreasing(int[] nums) {
        int last = nums[0];
        int count = 0;
        for(int i=1;i<nums.length;i++){
            if(last>=nums[i]){
                if(++count == 2) return false;
                if(i==1 || nums[i]>nums[i-2]){
                    last = nums[i];
                }
            }else{
                    last = nums[i];
            }
        }
        return true;
    }
    public static void main(String[] args) {
        
    }
}
