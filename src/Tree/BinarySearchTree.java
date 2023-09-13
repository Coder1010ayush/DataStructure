package Tree;

import java.util.ArrayList;

public class BinarySearchTree {
    private static int size =0;
    private TreeNode root;
    public BinarySearchTree(int val){
        root = new TreeNode(val);
        root.left = null;
        root.right = null;
    }
    public void insert(int val){
        size++;
        insertion(root,val);
    }
    private void insertion(TreeNode root,int val){
        if(root==null){
            root.data = val;
            root.left = null;
            root.right = null;
            return;
        }
        if(val<root.data) {
            if(root.left == null) {
                TreeNode left = new TreeNode(val);
                root.left = left;

            }else{
                insertion(root.left,val);
            }
        }else{
            if(root.right==null){
                TreeNode right = new TreeNode(val);
                root.right = right;
            }else{
                insertion(root.right,val);
            }
        }

    }
    public void preOrder(TreeNode root){
        if(root ==null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void inOrder(TreeNode root){
        if(root ==null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }
    public ArrayList<Integer> inAscendingOrder(){
        ArrayList<Integer> arr = new ArrayList<Integer>();
        return help(root,arr);
    }

    private ArrayList<Integer> help(TreeNode root, ArrayList<Integer> arr) {
        if(root==null) return arr;
        help(root.left,arr);
        arr.add(root.data);
        help(root.right,arr);
        return arr;
    }

    public void postOrder(TreeNode root){
        if(root ==null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data+" ");
    }
    public void search(int target){
        boolean ans = helper(root,target);
        System.out.println(ans);
    }
    private boolean helper(TreeNode root,int target){
        if(root==null) return false;
        if(target> root.data){
            helper(root.right,target);

        }else if(target< root.data){
            helper(root.left,target);
        }
        if(root.data == target) return true;
        else return false;
    }
    public int size(){
        return size+1;
    }
    public int successorTreeNode(int target){
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> newArr = help(root, arr);
        for (int ele:arr) {
            if(ele>target){
                return ele;
            }
        }
        return -1;
    }
    public int predessesorTreeNode(int target){
        ArrayList<Integer> arr = new ArrayList<>();
        ArrayList<Integer> newArr = help(root, arr);
        int count =0;
        for (int i = 0; i < arr.size(); i++) {
            if(arr.get(i)>target){
                break;
            }
            count++;
        }
        return arr.get(count);
    }
    public void levelOrder(){

        if(root == null) return;
        System.out.print(root.data+" ");
        if(root.left!=null && root.right!= null){
            System.out.print(root.left.data+" ");
            System.out.print(root.right+" ");
        }
        else return;

    }

    public void display(){
      preOrder(root);
    }
    public static  class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int val){
            this.data = val;
        }
    }

    public int nodesINTree(){
        return countNodes(root);
    }

    public int countNodes(TreeNode root){
        if(root ==null) return 0;
        return 1+countNodes(root.left)+countNodes(root.right);
    }
    
}
