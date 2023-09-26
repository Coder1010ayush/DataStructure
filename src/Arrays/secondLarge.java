package Arrays;
import java.util.Arrays;
import java.util.ArrayList;

public class secondLarge {

    public static int second(int[] nums){
        int large = nums[0];
        for (int i = 0; i < nums.length; i++) {
            if(nums[i]>large){
                large = nums[i];
            }
        }
        //System.out.println(large);

        int slarge = -1;
        for (int i = 0; i < nums.length; i++) {
            if(slarge<nums[i] && nums[i]<large){
                slarge = nums[i];
            }
        }
        return slarge;
    }
   
    public static void main(String[] args) {
        int[] nums = {-58, 62, -53, -61, -21, 17};
        System.out.println(second(nums));
        ArrayList<Integer> arr = new ArrayList<>();
        arr.add(12);
        arr.add(13);
        arr.add(12);
        arr.add(10);
        arr.add(10);
       // ArrayList<Integer> ans = removeDuplicates(arr);
        System.out.println(arr);
    }
}
