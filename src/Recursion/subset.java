package Recursion;

import java.util.ArrayList;
import java.util.Arrays;

public class subset {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int n = nums.length;
        subset(nums, 0, new ArrayList<Integer>(),n);
        String str = "abc";
      //  subsetString(str, "");
    //  System.out.println(issubsetString(str, "", "abc"));
    String[] result = new String[10];

    System.out.println(Arrays.toString(sub(str,"",result,0)));
    }

    public static void subset(int[] nums,int index,ArrayList<Integer>ans,int n){
        if(index >= n) {
            System.out.println(ans);
            return;
        }
        
        ans.add(nums[index]);
        subset(nums, index+1, ans,n);

        ans.remove(ans.size()-1);
        subset(nums, index+1, ans,n);
    }

    public static void subsetString(String str,String ans){
        if(str.isEmpty()){
          if(ans.isEmpty()) System.out.println("{}");
            System.out.println(ans);
            return;
        }
        String st = str.charAt(0)+"";
        subsetString(str.substring(1), ans+st);
        subsetString(str.substring(1), ans);
    }

     public static boolean issubsetString(String str,String ans,String tar){
        if(str.isEmpty()){
         // if(ans.isEmpty()) System.out.println("{}");
         //   System.out.println(ans);
         if(ans.equals(tar)) return true;
         return false;
        }
        String st = str.charAt(0)+"";
        
        return issubsetString(str.substring(1), ans,tar) || issubsetString(str.substring(1), ans+st,tar);
        

    }

    public static String[] sub(String str,String ans,String[] result,int n){
        if(str.isEmpty()){
            result[n] = ans;
            return result;
        }
        String st = str.charAt(0)+"";
        sub(str.substring(1), ans, result, n+1);
        
        sub(str.substring(1), ans+st, result, n+1);
        result[n] = ans;
        return result;

    }
}
