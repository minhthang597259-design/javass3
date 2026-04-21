package btvnss1;
import java.util.Scanner;
public class b1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("nhap ban kinh : ");
        double r = sc.nextDouble();
        System.out.printf("dien tich : %.2f\n", Math.PI * r * r);
    }
}
