import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter first name, last name and year");
        String one = sc.nextLine();
        String last2 = one.substring(one.indexOf(" ")+1);
        String first = one.substring(0,one.indexOf(" "));
        String middle = last2.substring(0,last2.indexOf(" "));
        String last = last2.substring(last2.indexOf(" ")+1);

        System.out.println("first: "+first);
        System.out.println("mid: "+middle);
        System.out.println("last: "+last);
        System.out.println("last length");

        if (middle.length()<5){
            System.out.println("Your login name: "+middle+first.charAt(0)+last.substring(last.length()-2));
        }
        else{
            System.out.println("Your login name: "+middle.substring(0,5)+first.charAt(0)+last.substring(last.length()-2));
        }
    }
}
