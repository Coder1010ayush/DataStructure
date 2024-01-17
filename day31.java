import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

class day31{


    // 1207. Unique Number of Occurrences
    public boolean uniqueOccurrences(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        HashMap<Integer,Integer> mapp = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if(mapp.containsKey(nums[i])){
                int a = mapp.get(nums[i]);
                mapp.replace(nums[i],a+1);
            }
            else{
                mapp.put(nums[i],1);
            }

         //   set.add(mapp.get(nums[i]));

        }
        mapp.forEach(
                (key,value)->{
                    set.add(value);
                }
        );

       
        if(set.size()==mapp.size()) return true;
        return false;
    }


    // 73. Set Matrix Zeroes
    public void setZeroes(int[][] matrix) {
        ArrayList<Integer> one = new ArrayList<Integer>();
        ArrayList<Integer> two = new ArrayList<Integer>();

        for(int row = 0;row < matrix.length; row++){

            for(int col = 0;col<matrix[row].length;col++){

                if(matrix[row][col]==0){

                    one.add(row);
                    two.add(col);
                }

            }
            

        }

        for(int row = 0;row < matrix.length; row++){

            for(int col = 0; col< matrix[row].length; col++){

                if(one.contains(row) || two.contains(col)) matrix[row][col] = 0;

            }

        }
        return ;
    }

    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        System.out.println(set.remove(40));
    }
}