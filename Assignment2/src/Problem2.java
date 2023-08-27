import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the cost of your groceries: ");
        double spent = sc.nextDouble();

        if (spent<10) {
            System.out.println("You don't win a coupon");
        }
        else if(spent>=10&&spent<=60){
            System.out.printf("You win a discount coupon of $ %.2f",spent*.08); System.out.println(".  (8% of your purchase)");
        }
        else if (spent>60&&spent<=150){
            System.out.printf("You win a discount coupon of $ %.2f",spent*.1); System.out.println(".  (10% of your purchase)");
        }
        else if (spent>150&&spent<=210){
            System.out.printf("You win a discount coupon of $ %.2f",spent*.12); System.out.println(".  (12% of your purchase)");
        }
        else if (spent>210){
            System.out.printf("You win a discount coupon of $ %.2f",spent*.14); System.out.println(".  (14% of your purchase)");
        }

    }
}
