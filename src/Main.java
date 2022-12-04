import java.util.Scanner;
import Account.ManagerAccount;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    static ManagerAccount managerAccount = new ManagerAccount();

    public static void main(String[] args) {
        String menu = """
                1. Danh sách tài khoản
                2. Đăng kí
                3. Đăng nhập
                4. Đổi mật khẩu
                5. Tìm tài khoản
                6. Thoát
                Chọn chức năng:\s""";
        int choice = 0;
        while (choice != 6) {
            System.out.println(menu);
            try {
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        managerAccount.show();
                        break;
                    case 2:
                        managerAccount.register();
                        break;
                    case 3:
                        managerAccount.login();
                        break;
                    case 4:
                        managerAccount.editPassword();
                        break;
                    case 5:
                        managerAccount.searchAccount();
                        break;
                    case 6:
                        break;
                    default:
                        System.out.println("Không có chức năng này");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!! \n");
            }
        }
    }
}
