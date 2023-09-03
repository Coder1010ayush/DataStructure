package Object_Oriented_Programming;

public class circleArea {
    private static double radius;

    public circleArea(double radius){
        setter(radius);
    }

    public void setter(double radius) {
        this.radius = radius;
    } 


    public double area(){
        return radius*radius*Math.PI;
    }

    public int areaInteger(){
        return (int)(radius*radius*Math.PI);
    }

    public static double totalArea(circleArea[] c){
        int len = c.length;
        double sum =0;
        for (circleArea circleArea : c) {
            sum += circleArea.area();
        }
        return sum;
    }




    public static void main(String[] args) {

        circleArea[] c = new circleArea[2];
        c[0] = new circleArea(2.0);
        c[1] = new circleArea(3.0);
        System.out.println(circleArea.totalArea(c));
    }
}
