package BinarySearch;
import java.util.Arrays;
// find the first and last occurance index of the target in the array

public class firstAndLast {

    // iterative way to do this 

    // finding the first occurance of the target
    public static int first_index(int[] nums,int target){

        int ans = -1;
        int s=0;
        int e = nums.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid]==target){
                ans = mid;
                e = mid-1;
            }
            if(target>nums[mid]){
                s = mid+1;
            }else{
                e = mid-1;
            }
        }
        return ans;
        
    }

    // finding last occurance of the target
    public static int last_index(int[] nums,int target){
        int ans = -1;
        int s=0;
        int e =nums.length-1;
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid]==target){
                ans = mid;
                s = mid+1;
            }
            if(target>nums[mid]){
                s = mid+1;
            }
           if(target<nums[mid]){
                e = mid-1;
            }
        }
        return ans;
    }


    public static int[] occurance(int[] nums,int target){
        int[] ans = {-1,-1};
        int first = first_index(nums, target);
        if(first==-1 || nums[first] != target){
            return ans;
        }
        int last = last_index(nums, target);
        ans[0] = first;
        ans[1] = last;
        return ans;
    }

    public static void main(String[] args) {
        int[] nums ={1,2,2,2,2,3,4,5,6,7,8};
        int[] ans = occurance(nums, 2);
        System.out.println(Arrays.toString(ans));

    }

}
