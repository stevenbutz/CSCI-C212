import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the temperature value");
        double temp = sc.nextDouble();
        sc.nextLine();
        System.out.println("Please enter 'C' for Celsius or 'F' for Fahrenheit");
        String cORf = sc.nextLine();
        String start = "The state of water is: ";
        if ("C".equals(cORf)||"c".equals(cORf)){
            if (temp<=0){
                System.out.println(start+"solid");
            }
            else if(temp<=100){
                System.out.println(start+"liquid");
            }
            else{
                System.out.println(start+"Gaseous");
            }
        }
        else if("F".equals(cORf)||"f".equals(cORf)){
            if (temp<=32){
                System.out.println(start+"solid");
            }
            else if(temp<=212){
                System.out.println(start+"liquid");
            }
            else{
                System.out.println(start+"Gaseous");
            }
        }
        else{
            System.out.println("PLEASE ENTER A VALID INPUT ERROR ERROR ERROR");
            }
        }
    }

