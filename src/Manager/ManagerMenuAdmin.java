package Manager;

import Menu.MenuAdmin;

public class ManagerMenuAdmin extends ManagerAdmin {
    public static void managerMenuAdmin() {
        int choice;
        while (true) {
            try {
                MenuAdmin.menuAdminAccount();
                System.out.println("Chọn: ");
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
                        choiceRole();
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Không có chức năng này" + '\n');
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
            }
        }
    }
}
