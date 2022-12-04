package Account;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ManagerAccount {
    Scanner scanner = new Scanner(System.in);
    static CreateAccount createAccount = new CreateAccount();
    static List<Account> accounts = new ArrayList<>();


    public Account createAccount() {
        return new Account(createAccount.username(), createAccount.password(), createAccount.phoneNumber());
    }

    public void show() {
        System.out.println("Tổng số tài khoản hiện có: " + "<" + accounts.size() + ">");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).toString());
        }
    }

    public void register() {
        accounts.add(createAccount());
        System.out.println("Tạo thành công! \n");
    }

    public void login() {
        int count = 3;
        while (true) {
            System.out.println("[Nhập tài khoản]: ");
            String username = scanner.nextLine();
            System.out.println("[Nhập mật khẩu]: ");
            String password = scanner.nextLine();
            if (checkAccount(username, password)) {
                System.out.println("Đăng nhập thành công! \n");
                return;
            } else {
                count--;
                System.err.println("Sai thông tin!!!");
                System.err.println("Nhập sai 3 lần sẽ tự động thoát");
                System.out.println("Số lần còn lại: " + "(" + count + ")\n");
                if (count == 0) {
                    return;
                }
            }
        }
    }

    public boolean backOrNext() {
        String menu = """
                1. Quay lại Menu\s
                2. Nhập lại\s
                """;
        System.out.println(menu);
        while (true) {
            int choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    return true;
                case 2:
                    return false;
                default:
                    System.err.println("Vui lòng chọn (1) hoặc (2)");
                    break;
            }
        }
    }

    public void editPassword() {
        while (true) {
            System.out.println("[Nhập tài khoản]: ");
            String username = scanner.nextLine();
            System.out.println("[Nhập mật khẩu]: ");
            String password = scanner.nextLine();
            while (true) {
                if (checkAccount(username, password)) {
                    System.out.println("(Lưu ý: Mật khẩu ít nhất 8 kí tự, viết hoa chữ cái đầu)");
                    System.out.println("[Nhập mật khẩu mới]: ");
                    String newpassword = scanner.nextLine();
                    if (newpassword.matches("^[A-Z].{7,}$")) {
                        for (int i = 0; i < accounts.size(); i++) {
                            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                                Account newAccount = new Account(accounts.get(i).getId(), username, newpassword, accounts.get(i).getPhone());
                                accounts.set(i, newAccount);
                                System.out.println("Đổi thành công! \n");
                                return;
                            }
                        }
                    } else {
                        System.err.println("Mật khẩu không hợp lệ!!!");
                        System.err.println("Đổi thất bại!!! \n");
                        if (backOrNext()) {
                            return;
                        }
                    }
                } else {
                    System.err.println("Sai thông tin!!! \n");
                    if (backOrNext()) {
                        return;
                    }
                    break;
                }
            }
        }
    }

    public void searchAccount() {
        System.out.println("[Nhập tên tài khoản]: ");
        String username = scanner.nextLine();
        if (findAccountByUser(username) >= 0) {
            System.out.println(accounts.get(findAccountByUser(username)).toString());
        } else {
            System.out.println("Không tìm thấy tài khoản!!! \n");
        }
    }

    //    {\__/}
    //    ( . .)
    //    | v  > <==3 cak

    public int findAccountByUser(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public boolean checkAccount(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}