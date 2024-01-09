package Leetcode;

import java.util.ArrayList;

/**
 * day24
 */
public class day24 {

     private void helper(TreeNode root,ArrayList<Integer>map){
        if(root==null) return;

        if(root.left == null && root.right == null) {
            map.add(root.val);
            return ;
        }

        helper(root.left,map);
        helper(root.right,map);

    }


    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        ArrayList<Integer> map = new ArrayList<Integer>();
        ArrayList<Integer> map1 = new ArrayList<Integer>();
        helper(root1,map);
        helper(root2,map1);
        if(map.equals(map1)) return true;
        return false;
    }


    public static void main(String[] args) {
        System.out.println("let us start !");
    }
    
}
