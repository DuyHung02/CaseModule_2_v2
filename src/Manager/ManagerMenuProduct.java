package Manager;

import Menu.MenuProduct;
import Product.Product;

public class ManagerMenuProduct extends ManagerProduct {
    public static void managerMenuProduct() {
        int choice;
        while (true) {
            try {
                MenuProduct.menuProduct();
                System.out.println("Chọn: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        ManagerProduct.show();
                        break;
                    case 2:
                        Product product = ManagerProduct.createProduct();
                        ManagerProduct.add(product);
                        break;
                    case 3:
                        ManagerProduct.edit();
                        break;
                    case 4:
                        ManagerProduct.deleteByName();
                        break;
                    case 0:
                        return;
                    default:
                        System.err.println("Không có chức năng này!!\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
            }
        }
    }
}
