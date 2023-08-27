import com.sun.source.tree.ReturnTree;

public class Problem2 {
    public static void main(String[] args) {
        System.out.println(numCompare("file7","file11"));
    }
    public static int numCompare(String str1, String str2){
        String one = str1.substring(0,findNumberPosition(str1));
        String two = str2.substring(0,findNumberPosition(str2));
        if (one.equals(two)){
            return Integer.parseInt(str1.substring(findNumberPosition(str1))) - Integer.parseInt(str2.substring(findNumberPosition(str2)));
        }
        else{
            return str1.compareTo(str2);
        }
    }
    public static int findNumberPosition(String str){
        for (int i = 0; i<str.length();i++) {
            char ch = str.charAt(i);
            if (Character.isDigit(ch)){
                return i;
            }
        }
        return -1;
    }
}
