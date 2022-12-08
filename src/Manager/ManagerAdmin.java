package Manager;

import Menu.MenuAdmin;


public class ManagerAdmin extends ManagerAccount {

    public static void managerAdmin(String username) {
        int index = findIndexAccountByUser(username);
        while (true) {
            try {
                switch (MenuAdmin.menuAdmin()) {
                    case 1:
                        ManagerMenuAdmin.managerMenuAdmin();
                        break;
                    case 2:
                        ManagerMenuProduct.managerMenuProduct();
                        break;
                    case 0:
                        return;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
            }
        }
    }

    public static void removeAccountById() {
        show();
        System.out.println("Nhập ID Account: ");
        int id = Integer.parseInt(scanner.nextLine());
        if (checkId(id)) {
            for (int i = 0; i < accounts.size(); i++) {
                if (accounts.get(i).getId() == id) {
                    accounts.remove(i);
                    System.out.println("Xóa thành công!");
                }
            }
        } else {
            System.err.println("Không có tài khoản ID: " + id);
        }
    }

    public static void choiceRole() {
        int choice;
        while (true) {
            try {
                System.out.println("1. Cấp quyền Admin");
                System.out.println("2. Gỡ quyền Admin");
                System.out.println("0. Quay lại");
                System.out.println("Chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        roleAdmin();
                        break;
                    case 2:
                        roleGuest();
                        break;
                    case 0:
                        return;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
            }
        }
    }

    public static void roleAdmin() {
        int choice;
        int choice2;
        String menu2 = """
                1. Yes
                2. No
                """;
        while (true) {
            System.out.println("Nhập tên tài khoản muốn cấp quyền: ");
            String userName = scanner.nextLine();
            if (findIndexAccountByUser(userName) >= 0) {
                String menu =
                        "Cung cấp tài khoản " + userName + " quyền Admin?" + '\n' +
                                "1. Xác nhận" + '\n' +
                                "2. Hủy" + '\n';
                while (true) {
                    try {
                        System.out.println(menu);
                        System.out.println("Chọn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                if (accounts.get(findIndexAccountByUser(userName)).getRole() == 1) {
                                    System.out.println("Tài khoản đang là Admin!!");
                                } else {
                                    accounts.get(findIndexAccountByUser(userName)).setRole(1);
                                    System.out.println("Thêm Admin thành công!!");
                                }
                                return;
                            case 2:
                                return;
                            default:
                                System.err.println("Nhập (1) hoặc (2) !!" + '\n');
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Nhập số!!" + '\n');
                    }
                }
            } else {
                System.err.println("Không tìm thấy tài khoản!!" + '\n');
            }
            while (true) {
                try {
                    System.out.println("Có muốn nhập lại?");
                    System.out.println(menu2);
                    choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
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
        }
    }

    public static void roleGuest() {
        int choice;
        int choice2;
        String menu2 = """
                1. Yes
                2. No
                """;
        while (true) {
            System.out.println("Nhập tên tài khoản muốn gỡ quyền Admin: ");
            String userName = scanner.nextLine();
            if (findIndexAccountByUser(userName) >= 0) {
                String menu =
                        "Gỡ quyền Admin cho tài khoản " + userName + " ?" + '\n' +
                                "1. Xác nhận" + '\n' +
                                "2. Hủy" + '\n';
                while (true) {
                    try {
                        System.out.println(menu);
                        System.out.println("Chọn: ");
                        choice = Integer.parseInt(scanner.nextLine());
                        switch (choice) {
                            case 1:
                                if (accounts.get(findIndexAccountByUser(userName)).getRole() == -1) {
                                    System.out.println("Tài khoản không phải Admin!!");
                                } else {
                                    accounts.get(findIndexAccountByUser(userName)).setRole(-1);
                                    System.out.println("Gỡ Admin thành công!!");
                                }
                                return;
                            case 2:
                                return;
                            default:
                                System.err.println("Nhập (1) hoặc (2) !!" + '\n');
                        }
                    } catch (NumberFormatException e) {
                        System.err.println("Nhập số!!" + '\n');
                    }
                }
            } else {
                System.err.println("Không tìm thấy tài khoản!!" + '\n');
            }
            while (true) {
                try {
                    System.out.println("Có muốn nhập lại?");
                    System.out.println(menu2);
                    choice2 = Integer.parseInt(scanner.nextLine());
                    switch (choice2) {
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
        }
    }
}
