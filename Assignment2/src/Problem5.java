import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter two pairs of numbers (4numbers):");
        int one = sc.nextInt();
        int two = sc.nextInt();
        int three = sc.nextInt();
        int four = sc.nextInt();
        if (one == two && three == four) {
            System.out.println("two pairs");
        } else if (one == three && two == four) {
            System.out.println("two pairs");
        } else if (one == four && two == three) {
            System.out.println("two pairs");
        } else {
            System.out.println("not two pairs");
        }


    }
}


