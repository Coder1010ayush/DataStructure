package Sorting;
import java.util.Arrays;

public class Bubble {

    // iterative approach to sorting 
    public static void swap(int[] nums,int first,int second){
        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

    }
    public static void sort(int[] nums){
        for (int i = 0; i < nums.length-1; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i]>nums[j]){
                    swap(nums,i,j);
                }
            }
        }
    }

    // recursive approach to sorting
  
    public static void main(String[] args) {
        int[] nums = {1,3,2,2,10,45,24,32,9};
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }
    
}
