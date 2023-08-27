import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter value for Relative humidity:");
        double RH = sc.nextDouble();
        System.out.println("Enter value for Temperature:");
        double T = sc.nextDouble();
        //////////////////////////////////
        double fTRH = ((17.27*T)/(237.7+T))+Math.log(RH);
        double Td = (237.7*fTRH)/(17.27-fTRH);
        System.out.printf("The dew point value is: %.2f",Td);
    }
}
