import java.util.Scanner;

public class QuanLyDiem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int soHocVien = 0;
        double tongDiem = 0;
        double diemCaoNhat = -1;
        double diemThapNhat = 11;
        int luaChon;

        do {
            System.out.println("\n===== MENU QUẢN LÝ ĐIỂM =====");
            System.out.println("1. Nhập điểm học viên");
            System.out.println("2. Hiển thị thống kê");
            System.out.println("3. Thoát chương trình");
            System.out.print("Mời bạn chọn chức năng (1-3): ");
            luaChon = scanner.nextInt();

            switch (luaChon) {
                case 1:
                    System.out.println("\n--- Bắt đầu nhập điểm ---");
                    while (true) {
                        System.out.print("Nhập điểm học viên (0-10) hoặc nhập -1 để thoát: ");
                        double diem = scanner.nextDouble();

                        if (diem == -1) {
                            System.out.println("Đã kết thúc quá trình nhập điểm.");
                            break; 
                        }

                        if (diem < 0 || diem > 10) {
                            System.out.println("Cảnh báo: Điểm không hợp lệ! Vui lòng nhập lại.");
                            continue; 
                        }

                        String xepLoai;
                        if (diem < 5) {
                            xepLoai = "Yếu";
                        } else if (diem < 7) {
                            xepLoai = "Trung Bình";
                        } else if (diem < 8) {
                            xepLoai = "Khá";
                        } else if (diem < 9) {
                            xepLoai = "Giỏi";
                        } else {
                            xepLoai = "Xuất sắc";
                        }
                        System.out.println("=> Xếp loại: " + xepLoai);

                        soHocVien++;
                        tongDiem += diem;

                        if (diemCaoNhat == -1 || diem > diemCaoNhat) {
                            diemCaoNhat = diem;
                        }
                        if (diemThapNhat == 11 || diem < diemThapNhat) {
                            diemThapNhat = diem;
                        }
                    }
                    break;

                case 2:
                    System.out.println("\n--- Bảng Thống Kê ---");
                    if (soHocVien == 0) {
                        System.out.println("Chưa có dữ liệu");
                    } else {
                        double diemTrungBinh = tongDiem / soHocVien;
                        System.out.println("Số học viên đã nhập: " + soHocVien);
                        System.out.printf("Điểm trung bình: %.2f\n", diemTrungBinh);
                        System.out.println("Điểm cao nhất: " + diemCaoNhat);
                        System.out.println("Điểm thấp nhất: " + diemThapNhat);
                    }
                    break;

                case 3:
                    System.out.println("Kết thúc chương trình. Tạm biệt!");
                    scanner.close();
                    System.exit(0); 

                default:
                    System.out.println("Lựa chọn không hợp lệ! Vui lòng chọn từ 1 đến 3.");
            }
        } while (true);
    }
}
