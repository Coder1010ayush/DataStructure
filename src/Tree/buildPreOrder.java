package Tree;

public class buildPreOrder {
    private static int index =-1;

    public class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int val){
            this.data = val;
            this.right = null;
            this.left = null;

        }
        public Node(int val,Node left,Node right){
            this.data= val;
            this.left = left;
            this.right = right;
        }
    }

    // building tree in preorder 

    public Node buildTree(int[] nodes){
        index++;
        if(nodes[index]==-1){
            return null;
        }

        Node node = new Node(nodes[index]);
        node.left = buildTree(nodes);
        node.right = buildTree(nodes);
        return node;
    }

    // height of the tree
    public int height(Node root){
        if(root ==null) return 0;
        if(root.left==null && root.right ==null) return 0;
        int a = height(root.left);
        int b = height(root.right);

        return 1+Math.max(a,b);
    }

    // diameter of the tree --> time complexity would be O(n2)
    public int diameter(Node root){
        int a = 1+height(root.left)+height(root.right);
        int b = height(root.left);
        int c = height(root.right);
        return Math.max(a,Math.max(b,c));
    }

    // diameter of the tree --> time complexity would be o(n)
    public int diameterLinear(Node root){
        if(root == null) return 0;
        if(root.right == null && root.left == null) return 0;
        int left = diameterLinear(root.left);
        int right = diameterLinear(root.right);
        int ans = height(root.left)+height(root.right);
        if(root.left != null) ans++;
        if(root.right != null) ans++;
        return Math.max(ans, Math.max(left, right));
    }

    public boolean isSameTree(Node root1,Node root2){

        if(root1==null && root2==null) return false;
        if(root1 == null || root2 == null) return false;
        if(root1.data == root2.data) return true; 

        return isSameTree(root1.left, root2.left) && isSameTree(root1.right, root2.right);
    }

    public Node invertTree(Node root){

        if(root==null) return root;
        Node local = root.left;
        root.left = root.right;
        root.right = local;
        return root;


    }


    public boolean symmetricTree(Node root){
        if(root == null) return true;
        if(root.left == null && root.right != null) return false;
        if(root.left != null && root.right == null) return false; 

        Node left = root.left;
        left = invertTree(left);
        Node rigth = root.right;
        return isSameTree(left, rigth);
    }


    public int multiply(Node root){
        if(root == null) return 1;
        int a = root.data;
        return a*multiply(root.left)*multiply(root.right);

    }

    public int sum(Node root){
        if(root == null) return 0;
        int a = root.data;
        return a+sum(root.left)+sum(root.right);
    }

    public int numberOfLevel(Node root){
        return height(root)-1;
    }

    

    
}
