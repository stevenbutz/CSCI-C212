import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        double toFind = sc.nextDouble();
        int sum = 2;
        boolean check = true;
        int startingPoint = 3;
        if (toFind == 0){
            System.out.println(0);
        }
        else if(toFind == 1){
            System.out.println(2);
        }
        else{
            while(toFind!=1) {
                for (int i = startingPoint - 1; i >= 2; i--) {
                    if (startingPoint % i != 0) {

                        check = true;
                    }
                    if (startingPoint % i == 0) {
                        check = false;
                        break;
                    }
                }
                if (check){
                    sum += startingPoint;
                    toFind--;
                }
                startingPoint++;
            }
            System.out.println(sum);
        }

    }
}
