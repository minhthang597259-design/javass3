package btvnss1;
import java.util.Scanner;
public class b2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b;
        a=sc.nextInt();
        b=sc.nextInt();
        System.out.println("first : "+a);
        System.out.println("second : "+b);
        System.out.println("tong : "+ (a+b));
        System.out.println("hieu : "+ (a-b));
        System.out.println("tich : "+ (a*b));
        System.out.println("thuong : "+ (a/b));
        System.out.println("phan du : "+ (a%b));
    }
}
