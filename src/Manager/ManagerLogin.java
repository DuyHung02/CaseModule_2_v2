package Manager;

import java.util.Scanner;

public class ManagerLogin {
    static Scanner scanner = new Scanner(System.in);

    public static void login() {
        int count = 3;
        while (true) {
            System.out.println("[Nhập tài khoản]: ");
            String username = scanner.nextLine();
            System.out.println("[Nhập mật khẩu]: ");
            String password = scanner.nextLine();
            if (ManagerAccount.checkAccount(username, password) == 1 || ManagerAccount.checkAccount(username, password) == -1) {
                System.out.println("Đăng nhập thành công! \n");
                switch (ManagerAccount.checkLogin(username, password)) {
                    case 1:
                        ManagerAdmin.managerAdmin(username);
                        break;
                    case -1:
                        ManagerMenuGuest.managerMenuGuest(username);
                        break;
                    case 0:
                        break;
                }
                return;
            } else {
                count--;
                System.err.println("Sai thông tin!!!");
                System.err.println("Nhập sai 3 lần sẽ tự động thoát");
                System.out.println("Số lần còn lại: " + "(" + count + ")\n");
            }
            System.out.println("Nhập lại?");
            System.out.println("1. Đồng ý");
            System.out.println("2. Thoát");
            while (true) {
                try {
                    int choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            return;
                        default:
                            System.err.println("Nhập (1) hoặc (2) !!" + '\n');
                    }
                    break;
                } catch (NumberFormatException e) {
                    System.err.println("Nhập số!!");
                }
            }
            if (count == 0) {
                return;
            }
        }
    }
}
