import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int input = sc.nextInt();
        int f0 = 0;
        int f1 = 1;
        int sum = 0;


        if (input == 0){
            System.out.println("0");
        }
        else if (input == 1){
            System.out.println("1");
        }
        else{
            for (int i = 0; i<input-1;i++){
                sum = f0 + f1;
                f0 = f1;
                f1 = sum;
            }
            System.out.println(sum);
        }
    }
}
