import java.util.Scanner;

public class Problem1{
    public static void main(String[] args){

    Scanner sc = new Scanner(System.in);
    System.out.println("Enter the number of Toaster:");
    int Toast = sc.nextInt();
    System.out.println("Enter the number of Hair Dryer:");
    int Hair = sc.nextInt();
    System.out.println("Enter the number of Car Vacuum:");
    int Vac = sc.nextInt();
    ///////////////////////////////////////////////////////////////
    double toastPrice = 29.95;
    double hairPrice = 24.95;
    double vacPrice = 19.99;
    ///////////////////////////////////////////////////////////////
    double tTotal = toastPrice*Toast;
    double hTotal = hairPrice*Hair;
    double cTotal = vacPrice*Vac;
    ////////////////////////////////////////////////////////////
        double fTotal = tTotal +hTotal + cTotal;





        ////////////////////////////////////
        System.out.println("");
    System.out.println("Invoice");
    System.out.println("");
    System.out.printf("%-15s%-10s%-10s%-10s\n","Item","Qty","Price","Total");
    System.out.printf("%-15s%-10s%-10s%-10s\n","Toaster",Toast,toastPrice,tTotal);
    System.out.printf("%-15s%-10s%-10s%-10s\n","Hair Dryer",Hair,hairPrice,hTotal);
    System.out.printf("%-15s%-10s%-10s%-10s\n","Car Vacuum",Vac,vacPrice,cTotal);
    System.out.println("-------------------------------------------");
    System.out.println("Amount Due: $"+fTotal);

    }
}
