package Object_Oriented_Programming;
public class queue {


  private static final int default_size =10;
  protected int pointer=-1;
  protected int[] arr;
  protected int front=-1;
  protected int rear=-1;

  public queue(int size){
    this.arr = new int[size];

  }
  public queue(){
    this.arr = new int[default_size];
  }

  // we add new elements in the queue through front and 
  // delete and peek would done through rear end.
  // this works on the principle of fifo ---> first in and first out


  public boolean push(int val){
    if(rear==-1){
      front++;
      arr[front] = val;
      rear = front;
    }
    arr[rear] = val; 
    rear++;
    return true;
  }

  public void display(){
    for (int ele  : arr) {
      System.out.print(ele+" ");
    }
    System.out.println();
  }


  public int peek(){
    int num = arr[front];
    return num;
  }

  public int pop(){
    int num= arr[front];
    front++;
    rear--;
    return num;

  }

  public int size(){
    return rear;
  }


}
