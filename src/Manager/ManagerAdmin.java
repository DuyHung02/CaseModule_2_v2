package Manager;

import Menu.MenuAdmin;


public class ManagerAdmin extends ManagerAccount {

    public static void managerAdmin() {
        while (true) {
            //        String menu = "Chọn chức năng: \n" +
//                "1. Quản lý tài khoản\n" +
//                "2. Quản lý sản phẩm\n" +
//                "3. Quay lại";
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
        }
    }

    public static void removeAccountById() {
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
}
