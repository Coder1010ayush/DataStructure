import java.util.Arrays;

public class day33 {

    // 931. Minimum Falling Path Sum
    int[][] dp = new int[101][101];
    private int helper(int[][] matrix,int row,int col,int n){

        if(row==n) {
            return matrix[row][col];
        }
        if(dp[row][col] != -1) return dp[row][col];
        int mini = Integer.MAX_VALUE;
        int sum = matrix[row][col];
        if(row+1<=n && col-1>=0) mini = Math.min(mini,sum+helper(matrix,row+1,col-1,n));
        if(row+1<=n) mini = Math.min(mini,sum+helper(matrix,row+1,col,n));
        if(row+1<=n && col+1<=n) {
            mini = Math.min(mini,sum+helper(matrix,row+1,col+1,n));
        }
        return dp[row][col] = mini;
    }


    public int minFallingPathSum(int[][] matrix) {
        for(int i = 0;i<101;i++){
            Arrays.fill(dp[i],-1);
        }
        int n = matrix.length;
        int ans = Integer.MAX_VALUE;
        int row = 0;
        for(int col = 0;col<n; col++){
            ans = Math.min(ans,helper(matrix,row,col,n-1));
        }
        return ans;
    }

    // 152. Maximum Product Subarray
    public int maxProduct(int[] nums) {
        int suffix = 1;
        int prefix = 1;
        int ans = Integer.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            if(prefix==0) prefix = 1;
            if(suffix == 0) suffix = 1;
            prefix = prefix*nums[i];
            suffix = suffix*nums[nums.length-i-1];
            ans = Math.max(ans,Math.max(prefix,suffix));
        }
        return ans;
    }

    // 390. Elimination Game
    public int lastRemaining(int n) {
        if(n==1) return 1;
        return 2*(n/2-lastRemaining(n/2)+1);
    }
    public static void main(String[] args) {
        System.out.println("let us start");
    }
}
