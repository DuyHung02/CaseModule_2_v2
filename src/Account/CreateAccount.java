package Account;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateAccount {
    static Scanner scanner = new Scanner(System.in);
    static ManagerAccount managerAccount = new ManagerAccount();

    public String username() {
        while (true) {
            System.out.println("[Nhập tài khoản Gmail]: ");
            String username = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$");
            if (managerAccount.findAccountByUser(username) == -1) {
                if (pattern.matcher(username).find()) {
                    System.out.println("Tài khoản hợp lệ \n");
                    return username;
                } else {
                    System.err.println("Tài khoản không hợp lệ \n");
                }
            } else {
                System.err.println("Tài khoản đã tồn tại \n");
            }
        }
    }

    public String password() {
        while (true) {
            System.out.println("(Lưu ý: Mật khẩu ít nhất 8 kí tự, viết hoa chữ cái đầu)");
            System.out.println("[Nhập mật khẩu]: ");
            String password = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[A-Z].{7,}$");
            if (pattern.matcher(password).find()) {
                System.out.println("Mật khẩu hợp lệ \n");
                return password;
            } else {
                System.err.println("Mật khẩu không hợp lệ!!! \n");
            }
        }
    }

    public String phoneNumber() {
        while (true) {
            System.out.println("[Nhập số điện thoại]: ");
            String phone = scanner.nextLine();
            Pattern pattern = Pattern.compile("^[0-9]{9,11}$");
            if (pattern.matcher(phone).find()) {
                System.out.println("Số điện thoại hợp lệ! \n");
                return phone;
            } else {
                System.err.println("Số điện thoại không hợp lệ!!! \n");
            }
        }
    }
}
