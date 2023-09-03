package LinkedList;

public class SingleLL {
    private Node head;
    private Node tail;
    private static int size;
    public SingleLL(){
        this.size = 0;
        this.head = null;
        this.tail = null;

    }
    public void insertFirst(int val){
        Node node = new Node(val);
        if(tail==null){
            head = tail = node;
            size++;
            return ;
        }
        node.next = head;
        head = node;
        size++;
    }
    public void insertLast(int dta){
        if(size==0){
            insertFirst(dta);
            return;
        }
        Node node = new Node(dta);
        tail.next = node;
        tail = node;
        size++;
    }
    public int size(){
        return size;
    }
    public void inserrtFromStart(int val,int pos){
        Node node = new Node(val);
        Node temp = nthNode(pos-1);
        node.next = temp.next;
        temp.next = node;
        size++;

    }
    public void insertFromLast(int val,int pos){
        Node node = new Node(val);
        Node temp = nthNodeFromLast(pos);
        node.next = temp.next;
        temp.next = node;
        size++;

    }
    private Node nthNode(int pos){
        Node temp = head;
        for(int i=1;i<pos;i++){
            temp = temp.next;
        }
        return temp;
    }
    private Node nthNodeFromLast(int pos){
        Node temp = head;
        for (int i = 1; i <size-pos+1 ; i++) {
            temp= temp.next;
        }
        return temp;
    }
    public void display(){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.data+" ");
            temp = temp.next;
        }
        System.out.println();
    }
    public void reverseDisplay(){
        for (int i = 1; i <= size; i++) {
            System.out.print(nthNode(i).data+" ");
        }
        System.out.println();
    }
    public int deleteFirst(){
        if(size==0) return -1;
        int dta = head.data;
        head = head.next;
        size--;
        return dta;
    }
    public int deleteLast(){
        if(size==0) return -1;
        int dta = tail.data;
        Node temp = nthNode(size-1);
        tail = temp;
        tail.next = null;
        size--;
        return dta;
    }
    public int delete(int position){
        Node temp = nthNode(position-1);
        int dta = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return dta;
    }
    public int deleteFromLast(int position){
        Node temp = nthNodeFromLast(position+1);
        int dta = temp.next.data;
        temp.next = temp.next.next;
        size--;
        return dta;
    }
    private class Node{
        private int data;
        private Node next;
        public Node(int val){
            this.data = val;
            this.next = null;
        }
        public Node(int dta,Node next){
            this.next = next;
            this.data = dta;

        }
    }

}
