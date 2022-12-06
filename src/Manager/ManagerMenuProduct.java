package Manager;

import Menu.MenuProduct;
import Product.Product;

public class ManagerMenuProduct extends ManagerProduct {
    public static void managerMenuProduct() {
        int choice;
        while (true) {
            MenuProduct.menuProduct();
            System.out.println("Chọn chức năng");
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
                case 5:
                    return;
                default:
                    System.err.println("Không có chức năng này!!\n");
            }
        }
    }
}
