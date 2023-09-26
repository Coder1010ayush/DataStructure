package Recursion;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class workingWithArray {
    public static void subset(int[] arr,int n,int idx,ArrayList<Integer>ans){
        if(idx==n){
            System.out.print(ans+" ");
            return;
        }
        int x = arr[idx];
        ans.add(x);
        subset(arr,n,idx+1,ans);
        ans.remove(ans.size()-1);
        subset(arr,n,idx+1,ans);

    }
    public static void subset1(int[] arr, int n, int idx, ArrayList<Integer>ans, List<List<Integer>>result){
        if(idx==n){
            result.add(new ArrayList<>(ans));
            return ;
        }
        int x = arr[idx];
        ans.add(x);
        subset1(arr,n,idx+1,ans,result);
        ans.remove(ans.size()-1);
        subset1(arr,n,idx+1,ans,result);

    }

    public static void permutation(int[] arr,int n,int idx,ArrayList<Integer>ans){
        if(idx==n){
            System.out.print(ans+" ");
            return;
        }

        int x = arr[idx];
        ArrayList<Integer> loc = new ArrayList<>();
        for (int i = 0; i <= idx; i++) {
            ans.add(i,x);
            permutation(arr,n,idx+1,ans);
            ans.remove(i);
        }

    }

    public static void permutation_1(int[] arr,int n,int idx,ArrayList<Integer>ans,List<List<Integer>>result){
        if(idx==n){
            result.add(new ArrayList<>(ans));
            return;
        }

        int x = arr[idx];
        ArrayList<Integer> loc = new ArrayList<>();
        for (int i = 0; i <= idx; i++) {
            ans.add(i,x);
            permutation_1(arr,n,idx+1,ans,result);
            ans.remove(i);
        }

    }
    public static void main( String[] args) {
        int[] arr = {1,1,3};
        int n = arr.length;
        ArrayList<Integer> ans = new ArrayList<>();
        List<List<Integer>>result = new ArrayList<>();
         //subset1(arr,n,0,ans,result);
       // System.out.println(result);
        permutation(arr,n,0,ans);
//        permutation_1(arr,n,0,ans,result);
//
//        Collections.reverse(result);
//        System.out.println(result);
        //[1,2,3], [1,3,2], [2, 1, 3], [2, 3, 1], [3,1,2], [3,2,1]
    }
}
