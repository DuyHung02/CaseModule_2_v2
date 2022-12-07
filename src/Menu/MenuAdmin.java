package Menu;

import java.util.Scanner;

public class MenuAdmin {
    static Scanner scanner = new Scanner(System.in);

    public static int menuAdmin() {
        int choice;
        String menu = """
                o _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ o
                |                                     |
                |   (Admin) Chọn chức năng:           |
                |   1. Quản lý tài khoản              |
                |   2. Quản lý sản phẩm               |
                |   0. Đăng xuất                      |
                |                                     |
                o _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ o
                     """;
        while (true) {
            try {
                System.out.println(menu);
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return 1;
                    case 2:
                        return 2;
                    case 0:
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
        String menu = """
              o _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ o
              |                                     |
              |   Chọn chức năng:                   |
              |   1. Hiển thị danh sách tài khoản   |
              |   2. Tìm kiếm tài khoản             |
              |   3. Sửa tài khoản                  |
              |   4. Xóa tài khoản                  |
              |   5. Cấp quyền                      |
              |   0. Thoát                          |
              |                                     |
              o _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ o
                """;
        System.out.println(menu);
    }
}
