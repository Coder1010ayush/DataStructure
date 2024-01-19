import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

class day32{
    // LeetCode 70 : Climbing Stairs
    int[] dp = new int[46];
    private int helper(int n){
        if(dp[n] != -1) return dp[n];
        if(n==1) return 1;
        if(n==2) return 2;

        return dp[n] = helper(n-1)+helper(n-2);
    }


    public int climbStairs(int n) {
        Arrays.fill(dp,-1);
        return helper(n);
    }


    // gfg : sum of two large number 
    String findSum(String x, String y) {
        // code here
        StringBuilder ans = new StringBuilder();
        int i = x.length()-1;
        int j = y.length()-1;
        int  carry = 0;
        while(i>=0 && j>=0){
            int a = x.charAt(i)-'0';
            int b = y.charAt(j)-'0';
            if(a+b+carry>=10) {
                int sum = (a+b)+carry-10;
                carry = 1;
                ans.append(sum);
            }else{
                int sum = a+b+carry;
                ans.append(sum);
                carry = 0;
            }
            i--;
            j--;
        }
        while(i>=0){
            int a = x.charAt(i)-'0';
            if(a+carry>=10){
                int sum = a+carry-10;
                carry = 1;
                ans.append(sum);
            }else{
                int sum = a+carry;
                carry = 0;
                ans.append(sum);
            }
            i--;
        }
        while(j>=0){
            int a = y.charAt(j)-'0';
            if(a+carry>=10){
                int sum = a+carry-10;
                carry = 1;
                ans.append(sum);
            }else{
                int sum = a+carry;
                carry = 0;
                ans.append(sum);
            }
            j--;
        }
        if(carry==1) ans.append(1);
        ans = ans.reverse();
        String res = ans.toString();
        res = res.replaceFirst ("^0*", "");
        if (res.isEmpty()) res = "0";
        return res;
    }

    // find missing in the second array
    ArrayList<Long> findMissing(long A[], long B[], int N, int M)
    {
        HashMap<Long,Long> map = new HashMap<Long,Long>();
        for(long x : B){
                
            if(map.containsKey(x)){
                continue;
            }else{
                
                map.put(x,(long)1);
            }
            
        }
        ArrayList<Long> ans = new ArrayList<Long>();
        for(int i = 0;i<A.length;i++){
            if(!map.containsKey(A[i])){
                ans.add(A[i]);
            }
        }
        return ans;
    }

    // 160. Intersection of Two Linked Lists

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null ) return null;
        ListNode first = headA;
        ListNode second = headB;

        while(first != second){
            if(first == null) first = headB;
            else first = first.next;
             
            if(second == null) second = headA;
            else second = second.next;

        }
        return first;
 
    }

    // 598. Range Addition II
    public int maxCount(int m, int n, int[][] ops) {
        for(int[] ans : ops){
            m = Math.min(m,ans[0]);
            n = Math.min(n,ans[1]);

        }
        return m*n;
    }

    // 2718. Sum of Matrix After Queries
    public long matrixSumQueries(int n, int[][] queries) {
        long ans = 0;
        int[][] mat = new int[n][n];
        for(int[] arr : queries){
            int type = arr[0];
            int idx = arr[1];
            int val = arr[2];
            if(type==0){
               for(int row=0;row<n;row++){
                   if(row==idx){
                       for(int col = 0;col<n;col++){
                           mat[row][col] = val;
                       }
                   }
               } 
            }
            else if(type==1){
                for(int row = 0;row<n;row++){
                    if(row==idx){
                        for(int col = 0;col<n;col++){
                            mat[col][row] = val;
                        }
                    }
                }
            }

        }
        for(int row = 0;row<n; row++){
            for(int col = 0;col<n;col++){
                ans += mat[row][col];
            }
        }
        return ans;
    }

    // obstacle part - 1
    private static int helper(int s , int e , int m , int n,int[][] dp){
        if(s==m)  return 1;
        if(e == n) return 1;
        if(dp[s][e] != -1) return dp[s][e];
        int bottom = helper(s+1,e,m,n,dp);
        int right = helper(s, e+1, m , n,dp);
        return dp[s][e] = bottom+right;
    }


    public int uniquePaths(int m, int n) {
        public static int[][] dp = new int[101][101];
        for(int i = 0;i<101;i++){
            Arrays.fill(dp[i],-1);
        }
        return helper(0,0,m-1,n-1,dp);
    }


    // 63. Unique Paths II    
    private int helper(int[][] obstacleGrid,int m,int n,int[][] dp){
        if(m>=0 && n>= 0 && obstacleGrid[m][n] == 1) return 0;
        if(m==0 && n==0) return 1;
        if(m<0 || n<0) return 0;
        if(dp[m][n] != -1) return dp[m][n];

        int a = helper(obstacleGrid,m-1,n,dp);
        int b = helper(obstacleGrid,m,n-1,dp);

        return dp[m][n] = a+b;

    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[101][101];
        for(int i = 0;i<101;i++){
            Arrays.fill(dp[i],-1);
        }
        int m = obstacleGrid.length-1;
        int n = obstacleGrid[0].length-1;
        return helper(obstacleGrid,m,n,dp);
    }
    public static void main(String[] args) {
        System.out.println("hello");
    }

}