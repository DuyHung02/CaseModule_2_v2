import java.util.Scanner;

import Account.Account;
import Manager.ManagerAccount;
import Manager.ManagerLogin;

public class Main {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String menu = """
                1. Đăng kí
                2. Đăng nhập
                0. Thoát
                Chọn chức năng:\s""";
        int choice = -1;
        while (choice != 0) {
            System.out.println(menu);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        Account account = ManagerAccount.createAccount();
                        ManagerAccount.register(account);
                        break;
                    case 2:
                        ManagerLogin.login();
                        break;
                    case 0:
                        break;
                    default:
                        System.err.println("Không có chức năng này!!\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!! \n");
            }
        }
    }
}
