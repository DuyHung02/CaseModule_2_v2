package Account;

import Manager.ManagerAccount;

import java.util.Scanner;
import java.util.regex.Pattern;

public class CreateAccount {
    static Scanner scanner = new Scanner(System.in);

    public int id() {
        int id = 1;
        while (true) {
            if (ManagerAccount.checkId(id)) {
                ++id;
            } else {
                return id;
            }
        }
    }

    public String name() {
        System.out.println("[Tên người sử dụng]: ");
        return scanner.nextLine();
    }

    public String username() {
        while (true) {
            System.out.println("[Nhập tài khoản Gmail]: ");
            String username = scanner.nextLine();
            String regex = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
            if (ManagerAccount.findIndexAccountByUser(username) == -1) {
                if (username.matches(regex)) {
                    System.out.println("Tài khoản hợp lệ \n");
                    return username;
                } else {
                    System.err.println("Tài khoản phải có đuôi @gmail.com!!" + "\n");
                }
            } else {
                System.err.println("Tài khoản đã tồn tại" + "\n");
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
                System.out.println("Mật khẩu hợp lệ" + "\n");
                return password;
            } else {
                System.err.println("Mật khẩu không hợp lệ!!!" + "\n");
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

    public double money() {
        return 0;
    }

    public int role() {
        return -1;
    }
}
