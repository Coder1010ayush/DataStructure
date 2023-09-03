package BinarySearch;

public class upperBound {
    // iterative way to do it
    public static int upper(int [] nums,int target){
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



    // recursive way to do the same problem

    public static int upperRecursive(int[] nums,int target,int s,int e,int ans){
        if(s>e) return ans;
        int mid = (s+e)/2;
        if(nums[mid]==target){
            s = mid+1;
            ans = mid;
            return upperRecursive(nums, target, s, e, ans);
        }

        if(nums[mid]<target){
            s = mid+1;
            return upperRecursive(nums, target, s, e, ans);
        }
        if(nums[mid]>target){
            e = mid-1;
            return upperRecursive(nums, target, s, e, ans);
        }

        return ans;
    }
    public static void main(String[] args) {
        int[] nums = {1,12,13,23,23,23,23,23,54,66,100};
        System.out.println(upperRecursive(nums, 23,0,nums.length-1,-1));
    }
}
