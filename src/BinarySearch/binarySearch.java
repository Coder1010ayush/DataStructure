package BinarySearch;
public class binarySearch {
    // via iterative way

    public static int search(int[] nums,int target){
        int s=0;
        int e=nums.length-1;
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


    // via recursion way

    public static int searchRecursive(int[] nums,int target,int s,int e){
       int mid = (s+e)/2;
       if(s>e){
        return -1;
       }
       if(nums[mid]==target) {
        return mid;
       } 
       if(target>nums[mid]){
            return searchRecursive(nums, target, mid+1, e);
       }else{
        return searchRecursive(nums, target, s, mid-1);
       }
    }
    public static void main(String[] args) {
        int[] nums = {1,2,4,5,6,78,99,100};
       // System.out.println(search(nums, 11));
       System.out.println(searchRecursive(nums, 100, 0, nums.length-1));
    }
}
