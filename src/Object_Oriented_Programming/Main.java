package Object_Oriented_Programming;
public class Main {
    public static void main(String[] args) {
        queue s = new queue(4);
        s.push(12);
        s.push(100);
        s.push(120);
        s.push(200);
       // System.out.println(s.pop());
       s.pop();
      System.out.println(s.size());
    }
}
