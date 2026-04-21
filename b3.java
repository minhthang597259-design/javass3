import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class QuanLyLuong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Double> danhSachLuong = new ArrayList<>();
        int luaChon;
        DecimalFormatSymbols symbols = new DecimalFormatSymbols(Locale.getDefault());
        symbols.setGroupingSeparator('.');
        symbols.setDecimalSeparator(',');
        DecimalFormat formatTien = new DecimalFormat("#,###", symbols);
        do {
            System.out.println("\n===== QUẢN LÝ LƯƠNG NHÂN VIÊN =====");
            System.out.println("1. Nhập lương nhân viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Tính tổng số tiền thưởng");
            System.out.println("4. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (1-4): ");
            luaChon = scanner.nextInt();
            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Nhập lương nhân viên ---");
                    while (true) {
                        System.out.print("Nhập lương (VNĐ) hoặc -1 để thoát: ");
                        double luong = scanner.nextDouble();
                        if (luong == -1) {
                            System.out.println("Đã kết thúc nhập lương.");
                            break;
                        }
                        if (luong < 0 || luong > 500_000_000) {
                            System.out.println("Cảnh báo: Lương phải từ 0 đến 500.000.000 VNĐ. Vui lòng nhập lại.");
                            continue;
                        }
                   danhSachLuong.add(luong);
                        String phanLoai;
                        if (luong < 5_000_000) {
                            phanLoai = "Thu nhập thấp";
                        } else if (luong < 15_000_000) {
                            phanLoai = "Thu nhập trung bình";
                        } else if (luong < 50_000_000) {
                            phanLoai = "Thu nhập khá";
                        } else {
                            phanLoai = "Thu nhập cao";
                        }
                        System.out.println("=> Phân loại: " + phanLoai);
                    }
                    break;
                case 2:
                    System.out.println("\n--- Bảng Thống Kê ---");
                    if (danhSachLuong.isEmpty()) {
                        System.out.println("Chưa có dữ liệu!");
                    } else {
                        double tongLuong = 0;
                        double luongCaoNhat = danhSachLuong.get(0);
                        double luongThapNhat = danhSachLuong.get(0);
                        int soNhanVien = danhSachLuong.size();

                        // Sử dụng foreach theo yêu cầu
                        for (double l : danhSachLuong) {
                            tongLuong += l;
                            if (l > luongCaoNhat) luongCaoNhat = l;
                            if (l < luongThapNhat) luongThapNhat = l;
                        }

                        double luongTrungBinh = tongLuong / soNhanVien;

                        System.out.println("Số nhân viên đã nhập: " + soNhanVien);
                        System.out.println("Tổng tiền lương: " + formatTien.format(tongLuong) + " VNĐ");
                        System.out.println("Lương trung bình: " + formatTien.format(luongTrungBinh) + " VNĐ");
                        System.out.println("Lương cao nhất: " + formatTien.format(luongCaoNhat) + " VNĐ");
                        System.out.println("Lương thấp nhất: " + formatTien.format(luongThapNhat) + " VNĐ");
                    }
                    break;

                case 3:
                    System.out.println("\n--- Tính Tiền Thưởng ---");
                    if (danhSachLuong.isEmpty()) {
                        System.out.println("Chưa có dữ liệu để tính thưởng!");
                    } else {
                        double tongTienThuong = 0;
                        for (double l : danhSachLuong) {
                            double thuongNV = 0;
                            if (l < 5_000_000) {
                                thuongNV = l * 0.05;
                            } else if (l < 15_000_000) {
                                thuongNV = l * 0.10;
                            } else if (l < 50_000_000) {
                                thuongNV = l * 0.15;
                            } else if (l <= 100_000_000) {
                                thuongNV = l * 0.20;
                            } else {
                                thuongNV = l * 0.25;
                            }
                            tongTienThuong += thuongNV;
                        }
                        System.out.println("Tổng số tiền thưởng cho nhân viên là: " + formatTien.format(tongTienThuong) + " VNĐ");
                    }
                    break;

                case 4:
                    System.out.println("Kết thúc chương trình. Chúc bạn một ngày làm việc hiệu quả!");
                    scanner.close();
                    System.exit(0); 
                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng nhập số từ 1 đến 4.");
            }
        } while (true);
    }
}
