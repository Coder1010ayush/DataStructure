import Tree.BinarySearchTree;

public class Main {
    public static void main(String[] args) {
       BinarySearchTree Tree = new BinarySearchTree(5);
       Tree.insert(4);
       Tree.insert(6);
       Tree.insert(2);
       Tree.insert(10);
       Tree.insert(9);
       Tree.insert(12);
       Tree.display();

       int a =Tree.nodesINTree();
       System.out.println(a);

    }
}