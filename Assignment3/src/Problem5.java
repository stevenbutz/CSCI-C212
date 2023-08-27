import java.util.Scanner;

public class Problem5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number: ");
        int yaga = sc.nextInt();
        String forReal = String.valueOf(yaga);
        String reverse = "";
        for (int i = forReal.length(); i>0;i--){
            reverse= reverse.concat(String.valueOf(forReal.charAt(i-1)));
        }
        if(reverse.equals(forReal)){
            System.out.println(forReal + " is a palindrome");
        }
        else{
            System.out.println(forReal+ " is not a palindrome");
        }
    }
}
