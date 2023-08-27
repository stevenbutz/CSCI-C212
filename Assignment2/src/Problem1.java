import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the first number: ");
        double first = sc.nextDouble();
        System.out.println("Enter the second number: ");
        double second = sc.nextDouble();
        System.out.println("Enter the third number: ");
        double third = sc.nextDouble();

        if (third > second && second > first) {
            System.out.println("The numbers are increasing");
        } else if (first > second && second > third) {
            System.out.println("The numbers are decreasing");
        }
        else{
            System.out.print("The numbers are neither increasing or decreasing");
        }
    }
}
