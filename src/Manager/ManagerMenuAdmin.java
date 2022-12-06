package Manager;

import Menu.MenuAdmin;

public class ManagerMenuAdmin extends ManagerAdmin {
    public static void managerMenuAdmin() {
        int choice;
        while (true) {
//                        String menu = "Chọn chức năng\n" +
//                                "1. Hiển thị danh sách tài khoản\n" +
//                                "2. Sửa tài khoản\n" +
//                                "3. Xóa tài khoản\n" +
//                                "4. Thoát\n";
            MenuAdmin.menuAdminAccount();
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    show();
                    break;
                case 2:
                    searchAccount();
                    break;
                case 3:
                    editPassword();
                    break;
                case 4:
                    removeAccountById();
                    break;
                case 5:
                    return;
                default:
                    System.out.println("Không có chức năng này");
            }
        }
    }
}
