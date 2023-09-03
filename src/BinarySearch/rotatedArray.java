package BinarySearch;

public class rotatedArray {

    // iterative way  and recursive way both to solve it 
    public static int binary_search(int[] nums,int s,int e,int target){
        while(s<=e){
            int mid = (s+e)/2;
            if(nums[mid]==target) {
                return mid;

            }
            if(target>nums[mid]){
                s = mid+1;
            }else{
                e = mid-1;
            }

        }
        return -1;
    }

    public static int search(int[] nums,int s,int e,int target,int ans){
       
        int mid = (s+e)/2;
        if(nums[mid]==target) {
            ans = mid;
            return ans;
        }
        if(nums[mid]>=nums[s]){
            // left portion is sorted we can apply binary search
            if(target>=nums[s] && target<=nums[mid]){
                ans = binary_search(nums,s,mid-1,target);
                return ans;
            }else{
                return search(nums,mid+1,nums.length-1,target,ans);
            }

        }else{
            // right portion is sorted we can apply binary search in the right portion
            if(target>=nums[mid+1] && target<=nums[e]){
                ans = binary_search(nums, mid+1, nums.length-1, target);
                return ans;
            }else{
                return search(nums, s, mid-1, target, ans);
            }
        }
        
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(search(nums, 0, nums.length-1, 3, -1));
    }
    
}
