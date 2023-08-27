import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter values for point (x1,y1):");
        int x1 = sc.nextInt();
        int y1 = sc.nextInt();
        System.out.println("Enter values for point (x2,y2):");
        int x2 = sc.nextInt();
        int y2 = sc.nextInt();
        System.out.println("Enter values for point (x3,y3):");
        int x3 = sc.nextInt();
        int y3 = sc.nextInt();
        //////////////////////////////////////////
        double a = Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
        double b = Math.sqrt(Math.pow(x3-x2,2)+Math.pow(y3-y2,2));
        double c = Math.sqrt(Math.pow(x3-x1,2)+Math.pow(y3-y1,2));
        double Perimeter = a+b+c;
        double s = Perimeter/2;
        double Area = Math.sqrt((s*(s-a)*(s-b)*(s-c)));
        double A = Math.acos(((c*c)+(a*a)-(b*b))/(2*c*a))*(180/Math.PI);
        double B = Math.acos(((a*a)+(b*b)-(c*c))/(2*a*b))*(180/Math.PI);
        double C = Math.acos(((b*b)+(c*c)-(a*a))/(2*b*c))*(180/Math.PI);


        /////////////////////////////////To be printed in the table
        System.out.println("Property Value");
        System.out.println("----------------------------");
        System.out.printf("%-20s%.2f\n","Side 1:",a);
        System.out.printf("%-20s%.2f\n","Side 2:",b);
        System.out.printf("%-20s%.2f\n","Side 3:",c);
        System.out.printf("%-20s%.2f\n","Perimeter:",Perimeter);
        System.out.printf("%-20s%.2f\n","Area:",Area);
        System.out.printf("%-20s%.2f\n","Angle1:",A);
        System.out.printf("%-20s%.2f\n","Angle2:",B);
        System.out.printf("%-20s%.2f\n","Angle3:",C);
    }
}
