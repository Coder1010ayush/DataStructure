package BinarySearch;

public class negative {

    public static int count(int[][] grid){
        int count =0;
        int row = grid.length;
       
        for(int i=0;i<row;i++){
            int col = grid[i].length;
             boolean flag = false;
            for(int j=0;j<col;j++){
                if(grid[i][j]<0 && flag == false) {
                    count = count+grid[i].length-j;
                    flag = true;
                }
            }
            
        }
        return count;
    }
    public static void main(String[] args) {
        int[][] grid = {
            {4,3,2,-1},
            {3,2,1,-1},
            {1,1,-1,-2},
            {-1,-1,-2,-3}

        };
        System.out.println(count(grid));
    }
}
