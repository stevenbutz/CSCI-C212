import java.util.Scanner;

public class Problem3 {
    public static void main(String[] args) {
        String str = "LVII" ;
        System.out.println("This year is Super Bowl LVII, which is number: " + convertRomanToDecimal(str));
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter you own roman numeral string: ");
        String thebigone = sc.nextLine();
        System.out.println("Your roman input in base 10 is: " + convertRomanToDecimal(thebigone));
    }
    public static int convertRomanToDecimal(String roman){
        int total = 0;
        String str = "LVII" ;
        int i = 0;
        while (roman.length()!=0){
            if (roman.length() == 1 || getRomanLetterValue(roman.substring(i,i+1)) >= getRomanLetterValue(roman.substring(i+1,i+2))){
                total += getRomanLetterValue(roman.substring(i,i+1));
                roman = roman.substring(i+1);
            }
            else{
                int difference = getRomanLetterValue(roman.substring(1,2))-getRomanLetterValue(roman.substring(0,1));
                total += difference;
                roman = roman.substring(2);
            }
        }
        return total;
    }
    public static int getRomanLetterValue(String romanLetter){
        return switch (romanLetter) {
            case "I" -> 1;
            case "V" -> 5;
            case "X" -> 10;
            case "L" -> 50;
            case "C" -> 100;
            default -> 1000;
        };
    }
}
