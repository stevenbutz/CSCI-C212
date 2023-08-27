import java.util.Scanner;

public class Problem4 {
    public static void main(String[] args) {
        System.out.println("Choose a new password. It should be at least \n" +
                "eight characters long, have both an uppercase \n" +
                "and lowercase letter, and have a digit.");
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your new password: ");
        String password1 = sc.nextLine();
        System.out.print("Enter your new password again: ");
        String password2 = sc.nextLine();
        String[] firstArray = {password1,password2};
        if (areEqual(firstArray) && greaterthan8(firstArray) && haveUpperCase(firstArray) && haveLowerCase(firstArray)
        && haveDigit(firstArray)){
            System.out.println("Your password is set. Thank you.");
        }
        else{
            boolean big = (areEqual(firstArray) && greaterthan8(firstArray) && haveUpperCase(firstArray) && haveLowerCase(firstArray)
                    && haveDigit(firstArray));
            while (!big){
                String[] reset = youFailed();
                big = (areEqual(reset) && greaterthan8(reset) && haveUpperCase(reset) && haveLowerCase(reset)
                        && haveDigit(reset));
            }
            System.out.println("Your password is set. Thank you.");
        }



        //////////////////////////////////////////
        //////////////NEED TO TEST TO MAKE SURE THEY ARE EQUAL
    }
    public static String[] youFailed(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Password is invalid, please try again.");
        System.out.print("Enter your new password: ");
        String tryagain1 = sc.nextLine();
        System.out.print("Enter your new password again: ");
        String tryagain2 = sc.nextLine();
        return new String[]{tryagain1,tryagain2};
    }


    public static boolean haveUpperCase(String[] bothpasswords) {
        boolean legit = false;
        String var = bothpasswords[0];
        for (int i = 0; i < var.length(); i++) {
            if (Character.isUpperCase(var.charAt(i))) {
                legit = true;
                break;
            }
        }
        return  legit;
    }

    public static boolean haveDigit(String[] bothpasswords) {
        boolean legit = false;
        String var = bothpasswords[0];
        for (int i = 0; i < var.length(); i++) {
            if (Character.isDigit(var.charAt(i))) {
                legit = true;
                break;
            }
        }
        return  legit;
    }


    public static boolean haveLowerCase(String[] bothpasswords) {
        boolean legit = false;
        String var = bothpasswords[0];
        for (int i = 0; i < var.length(); i++) {
            if (Character.isLowerCase(var.charAt(i))) {
                legit = true;
                break;
            }
        }
        return  legit;
    }

    public static boolean areEqual(String[] bothpasswords) {
        return bothpasswords[0].equals(bothpasswords[1]);
    }


    public static boolean greaterthan8(String[] bothpasswords) {
        return bothpasswords[0].length() >= 8;
    }
}
