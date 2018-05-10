import edu.princeton.cs.algs4.StdOut;

public class Exc_1_1 {
    public static void main(String[] args){
        System.out.println("Hellow World!!!!!!!!!!!!!");
        exc_1_1_1();
        exc_1_1_2();
        exc_1_1_3(2.0,2,2);
        exc_1_1_5(1,0.5);
        exc_1_1_6();

    }


    public static void exc_1_1_1(){
        System.out.println("1.1.1-a:");
        System.out.println((0+15)/2);

        System.out.println("1.1.1-b:");
        System.out.println(2.0e-6*100000000.1);

        System.out.println("1.1.1-c:");
        System.out.println(true && false || true && true);
    }

    public static void exc_1_1_2(){
        System.out.println("1.1.2-a:");
        System.out.println((1+2.236)/2);

        System.out.println("1.1.2-b:");
        System.out.println(1+2+3+4.0);

        System.out.println("1.1.2-c:");
        System.out.println(4.1>=4);

        System.out.println("1.1.2-d:");
        System.out.println(1+2+"3");
    }

    public static void exc_1_1_3(double a,double b,double c){
        System.out.println("1.1.3:");
        System.out.println(a==b && b==c);
    }

    public static void exc_1_1_5(double a,double b){
        System.out.println("1.1.5:");
        System.out.println(a >=0 && a <=1 && b >=0 && b <=1);
    }

    public static void exc_1_1_6(){
        System.out.println("1.1.6:");
        int f = 0;
        int g = 1;
        for (int i = 0;i<=15; i++){
            StdOut.println(f);
            f=f+g;
            g=f-g;
        }
    }







}
