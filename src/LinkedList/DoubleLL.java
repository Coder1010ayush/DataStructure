package LinkedList;

import javax.security.auth.login.CredentialException;

public class DoubleLL {
    private int size;
    private Node head;
    private Node tail;
    public DoubleLL(){
        this.size = 0;
        this.head = null;
        this.tail = null;
    }
    public void insertFirst(int val){
        Node temp = new Node(val);
        if(tail == null){
            head = tail = temp;
            size++;
            return ;
        }
        head.prev = temp;
        temp.next = head;
        head = temp;
        head.prev = null;
        size++;
    }
    public int size(){
        return size;
    }
    public void insertLast(int dta){
        Node node = new Node(dta);
        if(size==0){
            insertFirst(dta);
            return;
        }
        tail.next = node;
        node.prev = tail;
        tail = node;
        tail.next = null;
        size++;
    }
    public Node nthNode(int pos){
        Node temp = head;
        if(size==0){
            return null;
        }
        if(pos==1){
            return head;
        }
        if(pos == size){
            return tail;
        }
        for(int i=1;i<pos;i++){
            temp = temp.next;

        }
        return temp;
    }
    public Node nthNodeFromLast(int pos){
        Node temp = tail;
        if(size==0){
            return null;
        }
        if(pos ==1){
            return tail;
        }
        if(pos == size){
            return head;
        }
        for (int i = 1; i < pos; i++) {
            temp = temp.prev;
        }
        return  temp;
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
        Node temp = tail;
        while(temp !=null){
            System.out.print(temp.data+" ");
            temp = temp.prev;
        }
        System.out.println();
    }
    public void insert(int val,int position){
        Node node = new Node(val);
        if(position==1){
            head.prev = node;
            node.next = head;
            head = node;
            head.prev = null;
            size++;
            return;
        }
        if(position == size){
            tail.next = node;
            node.prev = tail;
            tail = node;
            size++;
            tail.next = null;
            return;
        }
        Node temp = nthNode(position-1);
        node.next = temp.next;
        temp.next.prev= node;
        temp.next = node;
        node.prev = temp;
        size++;

    }
    public int deleteFirst(){
        if(size==0) return -1;
        if(size==1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        int dta = head.data;
        head = head.next;
        head.prev = null;
        size--;
        return dta;
    }
    public int deleteLast(){
        if(size==0) return  -1;
        if(size==1){
            int val = head.data;
            head = tail = null;
            return val;
        }
        Node temp = tail.prev;
        int dta = tail.data;
        tail.prev = null;
        temp.next = null;
        size--;
        return  dta;
    }
    public int delete(int pos){
        if(pos==1){
            return deleteFirst();
        }
        if(pos==size){
            return deleteLast();
        }
        Node temp = nthNode(pos-1);
        Node node = temp.next;
        int dta = node.data;
        temp.next = node.next;
        node.next.prev = temp;
        node.next = null;
        node.prev = null;
        size--;
        return dta;
    }
    public int nthElement(int pos){
        if(pos==1) return head.data;
        if(pos==size) return tail.data;
        Node temp = nthNode(pos);
        int dta = temp.data;
        return  dta;
    }
    public int nthElementFromLast(int pos){
        if(pos==1) return tail.data;
        if(pos==size) return head.data;
        Node temp = nthNodeFromLast(pos);
        int dta = temp.data;
        return dta;
    }
            private class  Node{
                protected int data;
                private Node next;
                private Node prev;
                public Node(){

                }
                public Node(int val){
                    this.data = val;
                    this.next = null;
                    this.prev = null;

                }
            }

}
