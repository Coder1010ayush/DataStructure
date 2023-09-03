package Tree;


import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class methods {
    Scanner scanner = new Scanner(System.in);
   public methods(){

   }
   private TreeNode root;
   public void buildTree(){
       System.out.println("Enter the root Node: ");
       int value = scanner.nextInt();
       root = new TreeNode(value);
       buildTree(root);
   }
    public void buildTree(TreeNode node){
        System.out.println("press true to proceed or false to proceed in the left tree : ");
        Boolean left = scanner.nextBoolean();
        if(left){
            System.out.println("Enter the Node value : ");
            int val = scanner.nextInt();
            TreeNode tempLeft = new TreeNode(val);
            node.left = tempLeft;
            buildTree(root.left);
        }
        System.out.println("press true to proceed or false to proceed in the right tree : ");
        Boolean right = scanner.nextBoolean();
        if (right) {

            System.out.println("Enter the node value : ");
            int value = scanner.nextInt();
            TreeNode tempRight = new TreeNode(value);
            node.right = tempRight;
            buildTree(node.right);
        }
    }
    public void display(){

       preOrder(root);

    }
    public void preOrder(TreeNode root){
        if(root==null) return;
        System.out.print(root.val+" ");
        preOrder(root.left);
        preOrder(root.right);
    }
    public void postOrder(TreeNode root){
       if(root == null) return;

       postOrder(root.left);
       postOrder(root.right);
       System.out.println(root.val+" ");

    }
    public void inOrder(TreeNode root){
       if(root == null) return;
       inOrder(root.left);
        System.out.println(root.val+" ");
        inOrder(root.right);
    }
    public int size(TreeNode root){
       if(root==null) return 0;
       return 1+size(root.left)+size(root.right);
    }
    public int maxValue(TreeNode root){
       if(root == null) return 0;
       int a=0,b=0;
       if(root.right!=null ) {
           a = root.left.val;
       }
       if(root.left!=null){
           b = root.right.val;
       }
       return Math.max(root.val,Math.max(a,b));
    }
    public int minValue(TreeNode root){
        if(root == null) return 0;
        int a=0,b=0;
        if(root.right!=null ) {
            a = root.left.val;
        }
        if(root.left!=null){
            b = root.right.val;
        }
        return Math.min(root.val,Math.min(a,b));
    }
    public int sum(TreeNode root){
        if(root == null) return 0;
        int a=0,b=0;
        if(root.right!=null ) {
            a = root.left.val;
        }
        if(root.left!=null){
            b = root.right.val;
        }
        return root.val+sum(root.left)+sum(root.right);
    }
    public int product(TreeNode root){
        if(root == null) return 0;
        if(root.left==null) return 1;
        if(root.right==null) return 1;
        int a=1,b=1;
        if(root.right!=null ) {
            a = root.left.val;
        }
        if(root.left!=null){
            b = root.right.val;
        }
        return root.val*sum(root.left)*sum(root.right);
    }
    public int height(TreeNode root){

       if(root==null) return 0;
       return 2+height(root.left)+height(root.right);

    }
    public int diameter(TreeNode root){
       if(root==null) return 0;
       if(root.left==null && root.right == null) return 0;
       int leftAns = diameter(root.left);
       int rightAns = diameter(root.right);

       int mode = height(root.left)+height(root.right);
       if(root.left!=null) mode++;
       if(root.right!= null) mode++;
        return Math.max(leftAns,Math.max(rightAns,mode));
    }
    public void levelOrder(TreeNode root){

        if(root == null) return;
        System.out.print(root.val+" ");
        if(root.left!=null && root.right!= null){
            System.out.print(root.left.val+" ");
            System.out.print(root.right.val+" ");
        }
        else return;

    }
    public void depthFirstSearch(){
            return;
    }
    public void breadthFirstSearch(){
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);
        while(queue.size()>0){
            TreeNode temp = queue.peek();
            if(temp.left != null) queue.add(temp.left);
            if(temp.right != null) queue.add(temp.right);
            System.out.print(temp.val+" ");
            queue.remove();
        }
    }
    public TreeNode commonAncestor(TreeNode root){
       return null;
    }
   public static class TreeNode{
       int val;
       TreeNode left;
       TreeNode right;
       public TreeNode(int val){

           this.val = val;
       }
   }

}
