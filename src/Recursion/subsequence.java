package Recursion;
import java.util.ArrayList;

public class subsequence {

    public static void main(String[] args) {
        ArrayList<Integer> ans = new ArrayList<>();
        int[] arr = {1,2,3};
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();
        list = sub(0,arr,ans,list,3);
        System.out.println(list);
    }

    private static void subsequences(int i, int[] arr, ArrayList<Integer> ans,int n) {
            if(i==n){
                if(ans.size()==0){
                    System.out.print("{}");
                }
                for (Integer integer : ans) {
                    System.out.print(integer+" ");
                }
                System.out.println();
                return;
            }
            ans.add(arr[i]);
            subsequences(i+1, arr, ans, n);
            

            ans.remove(ans.size()-1);
            subsequences(i+1, arr, ans, n);
            
            

     }

    private static ArrayList<ArrayList<Integer>> sub(int i,int[] nums,ArrayList<Integer> ans,ArrayList<ArrayList<Integer>> list,int n){
        if(i==n){
            list.add(ans); 
            return list;
        }

        ans.add(nums[i]);  
        sub(i+1, nums, new ArrayList<>(ans),list, n);
        ans.remove(ans.size()-1);
        sub(i+1, nums, new ArrayList<>(ans),list, n);
        return list;
       
    }


    

}
