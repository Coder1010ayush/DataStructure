package Object_Oriented_Programming;

public class stack{
    protected int[] arr;
    private static final int default_size =10;
    public int pointer = -1;

    public stack(){
        this(default_size);
    }

    public stack(int size){
        this.arr = new int[size];
    }

    public boolean push(int value){
            if(isFull()) return false;
            ++pointer;
            arr[pointer] = value;
            return true;
      
    }


    public void peek(){
        System.out.println(arr[pointer]);
    }

    public void display(){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
        System.out.println();
    }

    public int pop(){
        if(pointer==-1) {
            System.out.println("stack underflow condition.");
            return -1;
        }
        int a = arr[pointer];
        pointer--;
        return a;
    }
    private boolean isFull(){
        if(pointer==default_size) {
            System.out.println("stack overflow condition.");
            return true;
        }
        else return false;
    }
}