package LinkedList;

public class DoubleCLL {
    private int size;
    private Node head;
    private Node tail;
    private int val;

    public DoubleCLL() {
        this.size = 0;
        this.head = null;
        this.tail = null;

    }
    public void insertFirst(int val){
        Node node = new Node(val);
        if(tail==null){
            head = tail = node;
            size++;
            return;
        }
        head.prev = node;
        node.next = head;
        head = node;
        head.prev = tail;
        tail.next = head;
        size++;
    }
    public void insertLast(int val){
        Node node = new Node(val);
        node.next = head;
        head.prev = node;
        tail.next = node;
        node.prev = tail;
        tail = node;
        size++;
    }
    public void display(){
        Node temp = head;
        while(temp!=tail){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void reverseDisplay(){
        Node temp = tail;
        while(temp!=head){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }
 public int deleteFirst(){
        int data = head.data;
        head = head.next;
        head.prev = tail;
        tail.next = head;
        size--;
        return data;
 }
 public int deleteLast(){
        int data = tail.data;
        Node temp = tail.prev;
        temp.next = tail.next;
        head.prev = temp;
        tail = temp;
        size--;
        return data;
 }
    public class Node {
        private int data;
        private Node next;
        private Node prev;

        public Node() {

        }

        public Node(int val) {
            this.data = val;
            this.next = null;
            this.prev = null;
        }

        public Node(int val, Node next, Node prev) {
            this.data = val;
            this.next = next;
            this.prev = prev;

        }
    }
}
