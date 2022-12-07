package Cart;

import Manager.ManagerProduct;
import Product.Product;
import ReadWriteFile.ReadWriteCart;

import java.util.List;

public class Cart extends ManagerProduct {

    public static int checkProductByName(String name) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNameproduct().equals(name))
                return i;
        }
        return -1;
    }

    public static void cartUser(String username) {
        List<Product> carts = ReadWriteCart.readFileCart(username);
        while (true) {
            ManagerProduct.show();
            System.out.println("Nhập tên món muốn thêm: ");
            String choiceName = scanner.nextLine();
            if (checkProductByName(choiceName) >= 0) {
                for (int i = 0; i < products.size(); i++) {
                    if (products.get(i).getNameproduct().equals(choiceName)) {
                        Product product = new Product(products.get(i).getNameproduct(), products.get(i).getPriceproduct(), products.get(i).getClassify());
                        carts.add(product);
                        ReadWriteCart.writeFileCart(carts, username);
                        System.out.println("ok!!" + '\n');
                    }
                }
                System.out.println("1. Chọn tiếp");
                System.out.println("2. Lưu và thoát");
                int choice = 0;
                try {
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            break;
                        case 2:
                            return;
                        default:
                            System.err.println("Nhập (1) hoặc (2) !!" + '\n');
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Nhập số!!" + '\n');
                }
            } else {
                System.err.println("Không tìm thấy món!!");
                System.out.println("Tìm lại?");
                System.out.println("1. Đồng ý");
                System.out.println("2. Thoát");
                int choice3 = Integer.parseInt(scanner.nextLine());
                switch (choice3) {
                    case 1:
                        break;
                    case 2:
                        return;
                    default:
                        System.err.println("Nhập (1) hoặc (2) !!" + '\n');
                }
                break;
            }
        }
    }

    public static int choiceMenu(String username) {
        while (true) {
            int choice;
            String menu = """
                    1. Xem giỏ hàng
                    2. Chọn tiếp
                    0. Quay lại
                    """;
            System.out.println(menu);
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    List<Product> carts = ReadWriteCart.readFileCart(username);
                    for (int i = 0; i < carts.size(); i++) {
                        System.out.println(carts.get(i).displayCart());
                    }
                    break;
                case 2:
                    return 2;
                case 0:
                    return 0;
                default:
                    System.err.println("Nhập (1) hoặc (2) !!" + '\n');
            }
        }
    }

    public static void buyProduct(String username) {
        do {
            cartUser(username);
        } while (choiceMenu(username) == 2);
    }
}
