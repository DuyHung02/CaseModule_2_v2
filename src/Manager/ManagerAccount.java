package Manager;

import Account.Account;
import Account.CreateAccount;
import ReadWriteFile.ReadWriteAccount;


import java.util.List;
import java.util.Scanner;

public class ManagerAccount {
    static Scanner scanner = new Scanner(System.in);
    static CreateAccount createAccount = new CreateAccount();
    public static List<Account> accounts = ReadWriteAccount.readFile();

    public static Account createAccount() {
        return new Account(createAccount.id(), createAccount.name(), createAccount.username(), createAccount.password(), createAccount.phoneNumber(), createAccount.money(), createAccount.role());
    }

    public static void show() {
        System.out.println("--------[ Danh sách tài khoản ]--------");
        System.out.println("Tổng số tài khoản hiện có: " + "<" + accounts.size() + ">");
        System.out.println("------------------------------------------------");
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println(accounts.get(i).toString());
        }
    }

    public static void register(Account account) {
        accounts.add(account);
        ReadWriteAccount.writeFile(accounts);
        System.out.println("Tạo thành công!" + "\n");
    }

    public static int checkLogin(String username, String password) {
        while (true) {
            if (checkAccount(username, password) == 1) {
                System.out.println("    [ Hello Admin " + checkName(username) + " ! ]" + "\n");
                return 1;
            } else {
                System.out.println("    [ Hello " + checkName(username) + " ! ]" + "\n");
                return -1;
            }
        }
    }

    public static boolean backOrNext() {
        String menu = """
                1. Quay lại Menu\s
                2. Nhập lại\s
                """;
        System.out.println(menu);
        while (true) {
            try {
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        return true;
                    case 2:
                        return false;
                    default:
                        System.err.println("Vui lòng chọn (1) hoặc (2)" + '\n');
                        break;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
            }
        }
    }

    public static void editPassword() {
        while (true) {
            System.out.println("[Nhập tài khoản]: ");
            String username = scanner.nextLine();
            System.out.println("[Nhập mật khẩu cũ]: ");
            String password = scanner.nextLine();
            while (true) {
                if (checkAccount(username, password) == 1 || checkAccount(username, password) == -1) {
                    System.out.println("(Lưu ý: Mật khẩu ít nhất 8 kí tự, viết hoa chữ cái đầu)");
                    System.out.println("[Nhập mật khẩu mới]: ");
                    String newpassword = scanner.nextLine();
                    if (newpassword.matches("^[A-Z].{7,}$")) {
                        for (int i = 0; i < accounts.size(); i++) {
                            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                                Account newAccount = new Account(accounts.get(i).getId(), accounts.get(i).getName(), username, newpassword, accounts.get(i).getPhone(), accounts.get(i).getMoney(), accounts.get(i).getRole());
                                accounts.set(i, newAccount);
                                ReadWriteAccount.writeFile(accounts);
                                System.out.println("Đổi thành công!" + "\n");
                                return;
                            }
                        }
                    } else {
                        System.err.println("Mật khẩu không hợp lệ!!!");
                        System.err.println("Đổi thất bại!!!" + "\n");
                        if (backOrNext()) {
                            return;
                        }
                    }
                } else {
                    System.err.println("Sai thông tin!!!" + "\n");
                    if (backOrNext()) {
                        return;
                    }
                    break;
                }
            }
        }
    }

    public static void searchAccount() {
        System.out.println("[Nhập tên người dùng]: ");
        String name = scanner.nextLine();
        if (findIndexAccountByName(name) >= 0) {
            System.out.println(accounts.get(findIndexAccountByName(name)).toString());
        } else {
            System.err.println("Không tìm thấy tài khoản!!!" + "\n");
        }
    }

    //    {\__/}
    //    ( . .)
    //    | v  > <==3 cak

    public static int findIndexAccountByUser(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return i;
            }
        }
        return -1;
    }

    public static int findIndexAccountByName(String name) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public static int checkAccount(String username, String password) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username) && accounts.get(i).getPassword().equals(password)) {
                if (accounts.get(i).getRole() == 1) {
                    return 1;
                } else {
                    return -1;
                }
            }
        }
        return 0;
    }

    public static boolean checkId(int id) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getId() == id) {
                return true;
            }
        }
        return false;
    }

    public static String checkName(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return accounts.get(i).getName();
            }
        }
        return null;
    }

    public static String checkMainAdmin(String username) {
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getUsername().equals(username)) {
                return username;
            }
        }
        return username;
    }
}