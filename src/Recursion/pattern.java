package Recursion;

public class pattern {
    public static void upper_triangle(int a,int b){
        if(a==1){
            System.out.println("*");
            return;
        }
        if(b<a){
            System.out.print("*"+" ");
            upper_triangle(a,b+1);
        }else{
            System.out.println();
            upper_triangle(a-1,0);
        }
    }
    public static void lower_triangle(int a,int b){
        if(a==1){
            System.out.print("*");
            return;
        }
        if(b<a){
            lower_triangle(a,b+1);
            System.out.print("*"+" ");
        }else{
            lower_triangle(a-1,0);
            System.out.println();

        }
    }
    public static void square(int a,int b){
        if(a==1){
            return;
        }
        for(int i=0;i<b;i++){
            System.out.print("*"+" ");
        }
        System.out.println();
        square(a-1,b);
    }


    public static void main(String[] args) {

//        upper_triangle(5,0);
//        lower_triangle(5,0);
//        System.out.println();
//        square(4,4);

    }
}
