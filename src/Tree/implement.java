package Tree;

public class implement {
    public static class Node{
        int data;
        Node left;
        Node right;
        public Node(int dta){
            this.data  = dta;
            this.left = null;
            this.right = null;
        }
        public Node(int dta,Node left ,Node right){
            this.data  = dta;
            this.left = left;
            this.right = right;
        }
        public Node(int dta,Node left ){
            this.data  = dta;
            this.left = left;
            this.right = null;
        }

    }
    public static void preOrder(Node root){
        if(root == null) return;
        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }
    public static void postOrder(Node root){
        if(root == null) return;
        preOrder(root.left);
        preOrder(root.right);
        System.out.print(root.data+" ");
    }
    public static void inOrder(Node root){
        if(root == null) return;
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);

    }
    public static int size(Node root){
        if(root==null) return 0;
        return 1+size(root.left)+size(root.right);
    }
    public static int max(Node root){
        if(root==null) return 0;
        int a = max(root.left);
        int b = max(root.right);
        return  Math.max(root.data,Math.max(a,b));
    }
    public static int min(Node root){
        if(root==null) return 0;
        int a = max(root.left);
        int b = max(root.right);
        return  Math.min(root.data,Math.max(a,b));
    }
    public static int heigth(Node root){

        if(root==null ||(root.left==null && root.right==null)) return 0;
        int a = heigth(root.left);
        int b = heigth(root.right);
        return 1+Math.max(a,b);
    }
    public static int sum(Node root){
        if(root==null) return 0;

        return root.data+sum(root.left)+sum(root.right);
    }
    public static int multiply(Node root){
        if(root==null) return 1;
        int a = root.data;
        return a*multiply(root.left)*multiply(root.right);

    }
    public static void main(String[] args) {
        Node root = new Node(1);
        Node a = new Node(2);
        Node b = new Node(3);
        root.left = a;
        root.right = b;

        Node c = new Node(4);
        Node d = new Node(5);
        a.left = c;
        a.right = d;

        Node e = new Node(6);
        Node f = new Node(7);
        b.left = e;
        b.right = f;
//        preOrder(root);
//        System.out.println();
//        postOrder(root);
//        System.out.println();
//        inOrder(root);
//        System.out.println();
//        System.out.println(max(root));
//        System.out.println(min(root));
        System.out.println(multiply(root));
    }

}
