import java.util.Scanner;

public class Problem2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please enter the word: ");
        String word = sc.nextLine();
        double countdown = word.length();
        int counter = 1;
        while (countdown != 0) {
            for (int i = 0; i < countdown; i++){
                System.out.println(word.substring(i,i+counter));
            }
            countdown--;counter++;
        }
    }
}
