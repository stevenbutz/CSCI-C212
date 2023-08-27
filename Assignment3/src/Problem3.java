import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the number of years: ");
        double years = sc.nextDouble();
        double A = .1;
        double B = .01;
        double C = .01;
        double D = .00002;
        double preyi = 1000;
        double predi = 20;
        double preyf = 0;
        double predf = 0;
        while (years != 0){
            preyf = preyi * (1 + A - B * predi);
            predf = predi * (1 - C + D * preyi);
            preyi = preyf;
            predi = predf;
            years--;
        }
        System.out.printf("Prey population = %.2f\n",preyi);
        System.out.printf("Predator population = %.2f",predf);
    }
}
