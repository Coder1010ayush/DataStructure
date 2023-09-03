package Arrays;

import java.util.ArrayList;
public class duplicate {
    public static void remove(int[]nums){
        int count=0;
        for (int i = 0; i < nums.length; i++) {
            if(i<nums.length-1 && nums[i]==nums[i+1]){
                continue;
            }
            nums[count] = nums[i];
            count++;
        }
    }
    public static int detect(ArrayList<Integer>arr){
        int n=arr.size();
        for (int i = 0; i < n-1; i++) {
           int a= arr.get(i);
           int b= arr.get(i+1);
           if(a==b){
            return a;
           }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] arr = {1,1,2,3,4,4,5};
        //remove(arr);
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(2);
        ans.add(3);
        ans.add(4);
        ans.add(4);
        // System.out.println(Arrays.toString(arr));
        System.out.println(detect(ans));
    }
    
}
