import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter r1: ");
        Double r1 = sc.nextDouble();
        System.out.println("Enter r2: ");
        Double r2 = sc.nextDouble();
        System.out.println("Enter h1: ");
        Double h1 = sc.nextDouble();
        System.out.println("Enter h2: ");
        Double h2 = sc.nextDouble();
        System.out.println("Enter h3: ");
        Double h3 = sc.nextDouble();
//        System.out.println(r1);
//        System.out.println(r2);
//        System.out.println(h1);
//        System.out.println(h2);
//        System.out.println(h3);
        double bigCylinder = Math.PI*Math.pow(r1,2)*h1;
        double smallCylinder = Math.PI*Math.pow(r2,2)*h2;
        double coneSection = Math.PI*(((Math.pow(r1,2)+r1*r2+Math.pow(r2,2))*h3)/3);
        double Total = coneSection+smallCylinder+bigCylinder;

        System.out.printf("The volume of the cylinder is %.2f",Total);
        System.out.print(" cubic cm.");
    }
}
