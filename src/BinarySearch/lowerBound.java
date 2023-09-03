package BinarySearch;

public class lowerBound {
    // iterative way time complexity O(logN)
    public static int lower(int[] nums,int target){
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


    // recursive way to do the same problem  time complexity O(logN)
    public static int lowerRecursive(int[] nums,int target,int s,int e,int ans){
        if(s>e) return ans;
        int mid = (s+e)/2;
        if(target==nums[mid]){
            ans = mid;
            e = mid-1;
            return lowerRecursive(nums, target, s, e, ans);
        }
        if(target>nums[mid]){
            s = mid+1;
            return lowerRecursive(nums, target, s, e, ans);
        }else{
            e = mid-1;
            return lowerRecursive(nums, target, s, e, ans);
        }
    }
    public static void main(String[] args) {
        int[] nums = {1,6,23,23,23,23,23,45,50,100};
        System.out.println(lower(nums, 23));
        System.out.println(lowerRecursive(nums, 23,0,nums.length-1,-1));
    }
}
