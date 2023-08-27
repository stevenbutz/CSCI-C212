import java.util.Scanner;

public class Problem1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value for x: ");
        int x = sc.nextInt();
        System.out.println("Enter the value for y: ");
        int y = sc.nextInt();
        System.out.println("Enter the value for z: ");
        int z = sc.nextInt();
        System.out.println(allTheSame(x,y,z));
        System.out.println(allDifferent(x,y,z));
        System.out.println(sorted(x,y,z));
    }
    public static boolean allTheSame(int x, int y, int z){
        return (y == x && x == z);
    }
    public static boolean allDifferent(int x, int y, int z){
        return y != x && y != z;
    }
    public static boolean sorted(int x, int y, int z){
        return x <=y && y<=z;
    }
}
