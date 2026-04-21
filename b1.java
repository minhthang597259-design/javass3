import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.Scanner;
public class HoaDonBanHang {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Tên khách hàng: ");
        String tenKhachHang = scanner.nextLine();
        System.out.print("Sản phẩm: ");
        String tenSanPham = scanner.nextLine();
        System.out.print("Giá: ");
        double gia = scanner.nextDouble();
        System.out.print("Số lượng: ");
        int soLuong = scanner.nextInt();
        System.out.print("Thẻ thành viên (true/false): ");
        boolean theThanhVien = scanner.nextBoolean();
        double thanhTien = gia * soLuong;
        double giamGia = theThanhVien ? (thanhTien * 0.10) : 0;
        double vat = thanhTien * 0.08;
        double tongTienThanhToan = thanhTien - giamGia + vat;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat formatTien = new DecimalFormat("#,###", symbols);
        System.out.println("\n--- KẾT QUẢ ---");
        System.out.println("Khách hàng: " + tenKhachHang);
        System.out.println("Sản phẩm: " + tenSanPham);
        System.out.println("Giá: " + formatTien.format(gia) + " VNĐ");
        System.out.println("Số lượng: " + soLuong);
        System.out.println("Thành tiền: " + formatTien.format(thanhTien) + " VNĐ");
        System.out.println("Giảm giá: " + formatTien.format(giamGia));
        System.out.println("Tiền VAT: " + formatTien.format(vat));
        System.out.println("Tổng tiền thanh toán: " + formatTien.format(tongTienThanhToan) + " VNĐ");
        scanner.close();
    }
}
