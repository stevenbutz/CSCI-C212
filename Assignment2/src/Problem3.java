import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("How many hours did you work?");
        double hours = sc.nextDouble();
        System.out.println("What is your hourly wage?");
        double wage = sc.nextDouble();
        double earningLess = wage*hours;
        if (hours>40){
            double overEarnings = earningLess + (hours-40)*(.5*wage);
            System.out.printf("You earned $%.2f",overEarnings);
            System.out.print(" this week");
        }
        else{
            System.out.printf("You earned $%.2f",earningLess);
            System.out.print(" this week");
        }
    }
}