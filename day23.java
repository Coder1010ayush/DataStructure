package Leetcode;

import Leetcode.TreeNode;

public class day23 {

    // 938. Range Sum of BST
    private int helper(TreeNode node,int low,int high){

        if(node == null) return 0;
        int ans = 0;
        

        if(node.val<=high && node.val>=low) ans = node.val;
        int a = helper(node.left,low,high);
        int b = helper(node.right,low,high);

        return ans+a+b;

    }


    // alter way to solve it
    private int helper1(TreeNode node ,int low, int high){

        if(node==null) return 0;

        int ans = 0;
        if(node.val <= high && node.val>= low) ans += node.val;
        if(node.val>low){
            ans += helper1(node.left, low, high);
        }

        if(node.val<high){
            ans += helper1(node.right, low, high);
        }

        return ans;

    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root==null) return 0;

        int ans = helper(root,low,high);
        return ans;


    }

    

    public static void main(String[] args) {
        System.out.println("let us start");
    }

}
