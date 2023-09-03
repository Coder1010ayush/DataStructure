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


    
}
