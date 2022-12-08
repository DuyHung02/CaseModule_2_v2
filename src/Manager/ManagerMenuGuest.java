package Manager;

import Cart.Cart;
import Menu.MenuGuest;


public class ManagerMenuGuest extends ManagerGuest {

    public static void managerMenuGuest(String username) {
        int choice;
        int index = findIndexAccountByUser(username);
        while (true) {
            try {
                MenuGuest.menuGuest();
                System.out.println("Chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        info(index);
                        break;
                    case 2:
                        editPassword();
                        break;
                    case 3:
                        Cart.buyProduct(username);
                        break;
                    case 4:
                        naptien(index);
                        break;
                    case 0:
                        return;
                    default:
                        System.err.println("Không có chức năng này!!");
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
            }
        }
    }
}
