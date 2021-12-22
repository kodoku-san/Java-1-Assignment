package assignment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Assignment {

    static Scanner scanner = new Scanner(System.in);
    static ArrayList<NhanVien> list = new ArrayList<NhanVien>();

    public static void main(String[] args) {
        int a = 0;
        while (a != 10) {
            showMenu();
            a = select();
            switch (a) {
                case 1 -> addDsNv();
                case 2 -> showDsNv();
                case 3 -> findByID();
                case 4 -> delNv();
                case 5 -> updateNv();
                case 6 -> findBySalary();
                case 7 -> sortByName();
                case 8 -> sortBSalary();
                case 9 -> showTop();
                case 10 -> System.out.println("Kết thúc chương trình!");
                default -> System.out.println("Vui lòng chọn từ 1->10");
            }
        }
    }

    public static int select() {
        int a = scanner.nextInt();
        return a;
    }

    public static void showMenu() {
        System.out.println("+-------------------------------------------------+");
        System.out.println("|_________CHƯƠNG TRÌNH QUẢN LÝ NHÂN VIÊN__________|");
        System.out.println("|                                                 |");
        System.out.println("| 1.  Nhập danh sách nhân viên.                   |");
        System.out.println("| 2.  Xuất danh sách nhân viên.                   |");
        System.out.println("| 3.  Tìm và hiển thị nhân viên theo mã.          |");
        System.out.println("| 4.  Xóa nhân viên theo mã.                      |");
        System.out.println("| 5.  Cập nhật thông tin nhân viên theo mã.       |");
        System.out.println("| 6.  Tìm các nhân viên theo khoảng lương.        |");
        System.out.println("| 7.  Sắp xếp nhân viên theo họ và tên.           |");
        System.out.println("| 8.  Sắp xếp nhân viên theo thu nhập.            |");
        System.out.println("| 9.  Xuất 5 nhân viên có thu nhập cao nhất.      |");
        System.out.println("| 10. Kết thúc chương trình.                      |");
        System.out.println("+-------------------------------------------------+");
        System.out.print("Chọn chức năng: ");
    }

    public static ArrayList<NhanVien> addDsNv() {
        System.out.println("NHẬP DANH SÁCH NHÂN VIÊN\n");
        String name, id;
        double salary;
        System.out.print("(0: hủy/-1: data example)\nNhập số lượng nhân viên: ");
        int n = scanner.nextInt(), loaiNV;
        switch (n) {
            case 0:
                return list;
            case -1:
                list.add(new TiepThi(0, "1", "Ho Hoang Phu", 9, 11, 2));
                list.add(new NhanVien(1, "2", "Ho Hoang Vjp2", 19));
                list.add(new NhanVien(1, "3", "Ho Vjp2Vjp2", 29));
                list.add(new TruongPhong(-1, "4", "Ho sdd2 Vjp2", 39, 9));
                list.add(new NhanVien(1, "5", "Ho Hoang Phu Vjp", 9));
                list.add(new NhanVien(1, "6", "Ho Vjp", 29));
                list.add(new NhanVien(1, "7", "Ho 2 Vjp", 2));
                break;
            default:
                scanner.nextLine();
                System.out.println("");
                for (int i = 0; i < n; i++) {
                    System.out.println("STT " + (i + 1) + ":");
                    System.out.println("(1) Nhân viên, (-1) Trưởng phòng, (0) Tiếp thị");
                    System.out.print("Loại NV: ");
                    loaiNV = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nhập họ và tên NV: ");
                    name = scanner.nextLine();
                    System.out.print("Nhập mã NV: ");
                    id = scanner.nextLine();
                    System.out.print("Nhập lương NV: ");
                    salary = scanner.nextDouble();
                    scanner.nextLine();
                    if(loaiNV == 1){
                        list.add(new NhanVien(loaiNV, id, name, salary));
                    } else if(loaiNV == -1){
                        System.out.print("Nhập lương trách nhiệm: ");
                        double salaryOnus = scanner.nextDouble();
                        list.add(new TruongPhong(loaiNV, id, name, salary, salaryOnus));
                    } else if(loaiNV == 0){
                        System.out.print("Nhập doanh số bán hàng: ");
                        double doanhSo = scanner.nextDouble();
                        System.out.print("Nhập huê hồng: ");
                        double hueHong = scanner.nextDouble();
                        list.add(new TiepThi(loaiNV, id, name, salary, doanhSo, hueHong));
                    } else{
                        System.out.println("\nĐã xảy ra lỗi! không thể thực hiện");
                    }
                            
                    System.out.println("");
                }
                break;
        }
        return list;
    }

    public static void showDsNv() {
        if (list.isEmpty()) {
            System.out.println("\nDanh sách nhân viên rỗng!\n");
        } else {
            System.out.println("DANH SÁCH NHÂN VIÊN\n");
            show(list);
        }

    }

    public static void findByID() {
        scanner.nextLine();
        System.out.println("TÌM VÀ HIỂN THỊ NHÂN VIÊN\n");

        if (list.isEmpty()) {
            System.out.println("Danh sách nhân viên rỗng!\n");
        } else {
            String id;
            System.out.print("Nhập mã nhân viên cần tìm: ");
            id = scanner.nextLine();
            int p = find(list, id);
            if (p == -1) {
                System.out.println("\nKhông tìm thấy nhân viên có mã số: " + id);
                System.out.println("");
            } else {
                showByID(list.get(p));
            }
        }
    }

    public static void showByID(NhanVien a) {
        System.out.println("\nThông tin nhân viên cần tìm: ");
        a.xuatThongTin();
        System.out.println("");
    }

    public static void delNv() {
        scanner.nextLine();
        System.out.println("XÓA NHÂN VIÊN\n");

        if (list.isEmpty()) {
            System.out.println("Danh sách nhân viên rỗng!\n");
        } else {
            String id;
            System.out.print("Nhập mã nhân viên cần xóa: ");
            id = scanner.nextLine();
            int p = find(list, id);
            if (p == -1) {
                System.out.println("\nKhông tìm thấy nhân viên có mã số: " + id);
                System.out.println("");
            } else {
                String rs = list.get(p).getNvID();
                list.remove(p);
                System.out.println("Đã xóa nhân viên mã số: \"" + rs + "\"");
            }
        }

    }

    public static void updateNv() {
        scanner.nextLine();
        System.out.println("CẬP NHẬT NHÂN VIÊN\n");
        if (list.isEmpty()) {
            System.out.println("Danh sách nhân viên rỗng!\n");
        } else {
            String id;
            System.out.print("\nNhập mã nhân viên cần cập nhật: ");
            id = scanner.nextLine();
            int p = find(list, id);
            if (p == -1) {
                System.out.println("\nKhông tìm thấy nhân viên có mã số: " + id);
                System.out.println("");
            } else {
                System.out.println("\nThông tin: ");
                list.get(p).xuatThongTin();
                System.out.println("\n(Nhập 0 vào thông tin không cần thay đổi)");
                
                System.out.print("  Nhập MSNV mới: ");
                String idNew = scanner.nextLine();
                System.out.print("  Nhập họ tên NV mới: ");
                String nameNew = scanner.nextLine();
                System.out.print("  Nhập lương mới: ");
                double salaryNew = scanner.nextDouble();
                
                if(list.get(p).getLevel() == 1){
                    updateNV(idNew, nameNew, salaryNew, p);
                } else if(list.get(p).getLevel() == -1){
                    updateTP(idNew, nameNew, salaryNew, p);
                } else if(list.get(p).getLevel() == 0){
                    updateTT(idNew, nameNew, salaryNew, p);
                } else {
                    System.out.println("Đã xảy ra lỗi! Không thể thực hiện");
                }
                        
                
            }
        }
    }
    
    public static void updateTP(String idNew, String nameNew, double salaryNew, int p){
        System.out.print("  Nhập lương trách nhiệm mới: ");
        double salaryOnusNew = scanner.nextDouble();

        list.get(p).setNvID((idNew.equals("0")) ? list.get(p).getNvID() : idNew);
        list.get(p).setNvName((nameNew.equals("0")) ? list.get(p).getNvName() : nameNew);
        list.get(p).setNvSalary((salaryNew == 0) ? list.get(p).getNvSalary() : salaryNew);
        ((TruongPhong) list.get(p)).setLuongTN((salaryOnusNew == 0) ? ((TruongPhong) list.get(p)).getLuongTN() : salaryOnusNew);

        System.out.println("Cập nhật thành công.");
    }

    public static void updateTT(String idNew, String nameNew, double salaryNew, int p){
        System.out.print("  Nhập danh số bán hàng mới: ");
        double doanhSo = scanner.nextDouble();
        System.out.print("  Nhập huê hồng mới: ");
        double hueHong = scanner.nextDouble();

        list.get(p).setNvID((idNew.equals("0")) ? list.get(p).getNvID() : idNew);
        list.get(p).setNvName((nameNew.equals("0")) ? list.get(p).getNvName() : nameNew);
        list.get(p).setNvSalary((salaryNew == 0) ? list.get(p).getNvSalary() : salaryNew);
        ((TiepThi) list.get(p)).setDoanhSo((doanhSo == 0) ? ((TiepThi) list.get(p)).getDoanhSo(): doanhSo);
        ((TiepThi) list.get(p)).setHueHong((hueHong == 0) ? ((TiepThi) list.get(p)).getHueHong(): hueHong);
        
        System.out.println("Cập nhật thành công.");
    }
    public static void updateNV(String idNew, String nameNew, double salaryNew, int p){
        list.get(p).setNvID((idNew.equals("0")) ? list.get(p).getNvID() : idNew);
        list.get(p).setNvName((nameNew.equals("0")) ? list.get(p).getNvName() : nameNew);
        list.get(p).setNvSalary((salaryNew == 0) ? list.get(p).getNvSalary() : salaryNew);

        System.out.println("Cập nhật thành công.");
    }
    public static void findBySalary() {
        scanner.nextLine();
        System.out.println("TÌM NHÂN VIÊN THEO KHOẢNG LƯƠNG\n");
        if (list.isEmpty()) {
            System.out.println("Danh sách nhân viên rỗng!\n");
        } else {
            double s, e;
            System.out.print("\nTìm nhân viên có lương\n  Từ: ");
            s = scanner.nextDouble();
            System.out.print("  Đến: ");
            e = scanner.nextDouble();

            ArrayList<NhanVien> listN = new ArrayList<>();

            for (NhanVien nhanVien : list) {
                if (nhanVien.getNvSalary() >= s && nhanVien.getNvSalary() <= e) {
                    listN.add(nhanVien);
                }
            }
            if (listN.isEmpty()) {
                System.out.println("Không tìm thấy NV nào có khoảng lương từ \"" + s + "\" đến \"" + e + "\"");
            } else {
                System.out.println("DANH SÁCH NHÂN VIÊN CÓ KHOẢNG LƯỜNG TỪ \"" + s + "\" ĐẾN \"" + e + "\"");
                show(listN);
            }

        }
    }

    public static void sortByName() {
        if (list.isEmpty()) {
            System.out.println("\nDanh sách nhân viên rỗng!\n");
        } else {
            System.out.println("SẮP XẾP THEO TÊN NHÂN VIÊN");
            Collections.sort(list, new sortByName());
            show(list);
        }
    }

    public static void sortBSalary() {
        if (list.isEmpty()) {
            System.out.println("\nDanh sách nhân viên rỗng!\n");
        } else {
            System.out.println("SẮP XẾP THEO LƯƠNG NHÂN VIÊN");
            Collections.sort(list, new sortBySalary());
            show(list);
        }
    }

    public static void showTop() {
        if (list.isEmpty()) {
            System.out.println("\nDanh sách nhân viên rỗng!\n");
        } else {
            Collections.sort(list, new sortBySalary());
            System.out.println("TOP 5 NHÂN VIÊN CÓ THU NHẬP CAO NHẤT\n");
            int a = (list.size() > 5) ? 5 : list.size();
            for (int i = 0; i < a; i++) {
                System.out.println("TOP " + (i + 1) + ": ");
                list.get(i).xuatThongTin();
            }
            for (int i = a - 5; i < 0; i++) {
                System.out.println("TOP " + (i + 6) + ": TRỐNG");
            }
            System.out.println("");
        }
    }

    public static int find(ArrayList<NhanVien> list, String idNV) {
        if (list.isEmpty()) {
            return -1;
        } else {
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).getNvID().equals(idNV)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public static void show(ArrayList<NhanVien> list) {
        int i = 0;
        for (NhanVien nhanVien : list) {
            System.out.println("STT " + (++i) + ": ");
            nhanVien.xuatThongTin();
            System.out.println("");
        }
    }
}
