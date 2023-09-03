package LinkedList;

public class CircularLL {
    private int size;
    private Node head;
    private  Node tail;
    public CircularLL(){
        this.size =0;
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
        node.next = head;
        head = node;
        tail.next = head;
        size++;

    }
    public void insertLast(int val){
        Node node = new Node(val);
        if(size==0){
            insertFirst(val);
            return;
        }
        node.next = tail.next;
        tail.next = node;
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
    public int deleteFirst(){
        if(size==0) return -1;
        if(size==1){
            int dta = head.data;
            head = tail = null;
            size--;
            return dta;
        }
        int dta = head.data;
        head = head.next;
        tail.next = head;
        size--;
        return dta;
    }
    public int deleteLast(){

        if(size==1){
            int dta = head.data;
            head = tail = null;
            size--;
            return dta;
        }
        int dta = tail.data;
        Node temp = head;
        for (int i=1;i<size-1;i++){
            temp =temp.next;
        }
        temp.next = tail.next;
        tail.next = null;
        size--;
        return dta;
    }
    private  class Node{
        private int data;
        private  Node next;
        public Node(){

        }
        public Node(int val){
            this.data = val;
            this.next = null;
        }
        public Node(int val,Node next){
            this.next = next;
            this.data = val;
        }
    }
}
