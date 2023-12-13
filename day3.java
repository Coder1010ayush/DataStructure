package Leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import javax.swing.tree.TreeNode;
import javax.xml.stream.events.Characters;

import org.w3c.dom.Node;

public class day3 {

    // 1582. Special Positions in a Binary Matrix
    private static int numSpecial(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int ans = 0;
        int[] rows = new int[m];
        int[] cols = new int[n];
        for(int row = 0;row<m;row++){
            for(int col = 0;col<n;col++){
                if(mat[row][col]==0) continue;
                rows[row]++;
                cols[col]++;
            }
        }
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(mat[row][col]==1){
                    if(rows[row]==1 && cols[col]==1 ) ans++;
                }else continue;
            }
        }
        return ans;
    }

    // another way to do it brute force approach O(n3) time complexity
    private static int numSpecialAlter(int[][] mat){
        int ans = 0;
        int m = mat.length;
        int n = mat[0].length;
        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                boolean flag_row = true;
                boolean flag_col = true;
                if(mat[row][col]==1){
                    for(int i=0;i<m;i++){
                        if(i != row && mat[i][col] == 1){
                            flag_row = false;
                            break;
                        }
                    }
                    for(int i=0;i<n;i++){
                         if(i != col && mat[row][i] == 1){
                            flag_col = false;
                            break;
                        }
                    }

                    if(flag_col==true && flag_row==true) ans++;
                }else continue;
            }
        }
        return ans;
    }

    // 2482. Difference Between Ones and Zeros in Row and Column
    private static int[][] onesMinusZeros(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] rowszeros = new int[m];
        int[] colzeros = new int[n];
        int[] rowones = new int[m];
        int[] colones = new int[n];

        for(int row=0;row<m;row++){
            for(int col=0;col<n;col++){
                if(grid[row][col]==1){
                    rowones[row]++;
                    colones[col]++;
                }else{
                    rowszeros[row]++;
                    colzeros[col]++;
                }
            }
        }
        int[][] ans = new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                // diff[i][j] = onesRowi + onesColj - zerosRowi - zerosColj
                int a = rowones[i]+colones[j];
                int b = rowszeros[i]+colzeros[j];
                ans[i][j] = a-b;           
            }

        }
       
        return ans;
        
    }

    // LeetCode : 2487. Remove Nodes From Linked List
    private static ListNode removeNodes(ListNode head) {
        if(head==null) return null;
        head.next = removeNodes(head.next);
        return head.next != null && head.val<head.next.val ? head.next : head;
    }

    // LeetCode : 2485. Find the Pivot Integer
    private static int findNum(int n){
       int ans = -1;
       int total = (n*(n+1))/2;
       int s = 1;
       int e = n;
       while(s<=e){
        int mid = (s+e)/2;
        int prev_sum = (mid*(mid+1))/2;
        int next_sum = total - (prev_sum) + mid;
        if(prev_sum==next_sum) return mid;
        if(next_sum>prev_sum) s = mid+1;
        if(next_sum<prev_sum) e = mid-1;
       }
       return ans;
    } 
    private static int pivotInteger(int n) {
        int ans = findNum(n);
        return ans;
    }

    // LeetCode 319. Bulb Switcher
    private static int bulbSwitch(int n) {
        return (int) Math.sqrt(n);
    }

    // LeetCode 671. Second Minimum Node In a Binary Tree
    // LeetCode 1374. Generate a String With Characters That Have Odd Counts
    private static String generateTheString(int n) {
       String str = "";
       if(n%2==0){
        for(int i=0;i<n-1;i++){
            str = str.concat("a");
        }
        str = str.concat("b");
        return str;
       }else{
        for(int i=0;i<n;i++){
            str =str.concat("a");
        }
        return str;
       }
      
   }
// 671. Second Minimum Node In a Binary Tree

   private static int findMin(TreeNode root){
    if(root==null) return Integer.MAX_VALUE;
    int ans = Math.min(findMin(root.left), findMin(root.right));
    return ans;
   }

   private static int first = Integer.MAX_VALUE;
   private static int second = Integer.MAX_VALUE;
   private static boolean fs = false;


   private static void secondMax(TreeNode root){
    if(root == null) return;
    if(root.val<first){
        first = root.val;
    }
    else if(root.val>first && root.val <= second){
        second = root.val;
        fs = true;
    }
    secondMax(root.left);
    secondMax(root.right);

   }

   private static int findSecondMinimumValue(TreeNode root) {
        if(root==null) return -1;
        if(fs){
            return second;
        }
        return -1;
   }

   // LeetCode 2331. Evaluate Boolean Binary Tree
   private static boolean evaluate(TreeNode root){
    //2 represents or
    //3 represents and
    if(root.left == null && root.right == null){
        int a = root.val;
        if(a==0) return false;
        else return true;
    }
    if(root.val==2){
        return evaluate(root.left) || evaluate(root.right);
    }
    return evaluate(root.left) && evaluate(root.right);


   }
   public boolean evaluateTree(TreeNode root) {
    if(root == null) return false;
    return evaluate(root);  
   }

   // LeetCode 2452. Words Within Two Edits of Dictionary
   private static int findDiff(String string,String string2){
    int diff = 0;
    int count = 0;
    for(char ch : string.toCharArray()){
        for (char ch1 : string2.toCharArray()) {
            if(ch==ch1) {
                count++;
                break;
            }
        }
    }
    diff = string.length()-count;
    return diff;
   }

   private static List<String> twoEditWords(String[] queries, String[] dictionary) {
    List<String>list = new ArrayList<>();
    for (String string : queries) {
     for (String string2 : dictionary) {
        if(string.equals(string2)){
            list.add(string);
            break;
        } else{
            int diff = findDiff(string,string2);
            if(diff<=2) list.add(string);
            else break;
        }

     }   
    }
    return list;
    }

    public static void main(String[] args) {
        System.out.println("in day3 class");
        int[][] arr = {{1,1,1},{1,1,1}};
       // onesMinusZeros(arr);
       // System.out.println(a);
       //System.out.println(pivotInteger(8));
    //    for (int i = 0; i <5; i++) {
    //     for (int j = 0; j < 3; j++) {
    //         if(i==3) break;
    //        // System.out.print(j+" ");
    //     }
    //    }
      String st = "ayush";
      String st1 = "ayupk";
      System.out.println(findDiff(st, st1));
    }
}
