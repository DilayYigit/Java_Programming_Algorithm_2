import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        //part a
        System.out.print("Enter a String: ");
        String str1 = scan.nextLine();
        System.out.println("Part A: "+removeChar(str1));

        System.out.println();
        //part b
        System.out.print("Enter a decimal number: ");
        int num = scan.nextInt();
        System.out.println("Part B: "+ decToHex(num));

        System.out.println();
        //part c
        System.out.print("Part C: ");
        ArrayList<String> list = new ArrayList<>();
        list.add("Ali");
        list.add("Burak");
        list.add("Ceyda");
        list.add("Dilay");
        list.add("Ebru");
        System.out.print(arraySorted(list) + " ");
        list.add("Ahmet");
        System.out.println(arraySorted(list));

        System.out.println();
        //part d
        System.out.print("Enter a String: ");
        String str2 = scan.next();
        System.out.print("Part D: ");
        reverseString(str2);

        System.out.println();
        //part e
        System.out.print("Part E: ");
        order(1," ",3);
    }

    //part a
    public static String removeChar (String str) {
        if (str.length() == 0) {
            return str;
        }
        else {
            if (str.charAt(0) == 'r')
                return removeChar(str.substring(1));
        }
        return str.charAt(0) + removeChar(str.substring(1));
    }

    //part b
    public static String decToHex (int num) {
        int remainder;
        String str = "";
        char hexa[]= {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if (num>0) {
            String hex = decToHex(num/16);
            remainder = num%16;
            str =str + hex + hexa[remainder];
        }
        return str;
    }

    //part c
    public static boolean arraySorted (ArrayList<String> list) {
        boolean sorted = false;
        if (list.size() == 0 || list.size() == 1) {
            sorted  = true;
        }
        else
        {
            if (list.get(list.size()-2).compareTo(list.get(list.size()-1)) > 0) {
                list.remove(list.size()-1);
                return arraySorted(list) && sorted;
            }
        }
        sorted = false;
        return sorted;
    }


    //part d
    public static void reverseString (String str) {
        if ((str==null) || (str.length() <= 1))
            System.out.println(str);
        else
        {
            System.out.print(str.charAt(str.length() - 1));
            reverseString(str.substring(0, str.length() - 1));
        }
    }

    //part e
    private static void order (int start, String result, int n)
    {
        if (n == 0)
        {
            System.out.print(result + " ");
            return;
        }
        for (int i = start; i < 10; i++) {
            String str = result + Integer.toString(i);
            order(i+1, str, n-1);
        }
    }
}
