package Manager;

import Menu.MenuGuest;

import java.util.Scanner;

public class ManagerGuest extends ManagerAccount {

    public static void managerGuest() {
        int choice;
        while (true) {
            MenuGuest.menuGuest();
            System.out.println("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    System.err.println("Đang bảo trì\n");
                    break;
                case 2:
                    ManagerAccount.editPassword();
                    break;
                case 3:
                    System.err.println("Đang bảo trì");
                    break;
                case 4:
                    return;
                default:
                    System.err.println("Không có chức năng này!!");
            }
        }
    }
}
