package Menu;

import java.util.Scanner;

public class MenuAdmin {
    static Scanner scanner = new Scanner(System.in);

    public static int menuAdmin() {
        int choice;
        String menu = "(Admin) Chọn chức năng: \n" +
                "1. Quản lý tài khoản\n" +
                "2. Quản lý sản phẩm\n" +
                "3. Đăng xuất";
        while (true) {
            try {
                System.out.println(menu);
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 3:
                        return 0;
                    default:
                        System.err.println("Không có chức năng này!!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!" + '\n');
            }
        }
    }

    public static void menuAdminAccount() {
        String menu = "Chọn chức năng\n" +
                "1. Hiển thị danh sách tài khoản\n" +
                "2. Tìm kiếm tài khoản\n" +
                "3. Sửa tài khoản\n" +
                "4. Xóa tài khoản\n" +
                "5. Thoát\n";
        System.out.println(menu);
    }
}
