package Cart;

import Manager.ManagerAccount;
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

    public static void removeCart(String username) {
        if (removeProductByName(username) >= 0) {
            System.out.println("Xóa thành công!!" + '\n');
        } else {
            System.err.println("Không thấy sản phẩm!!" + '\n');
        }
    }
    public static int removeProductByName(String username) {
        List<Product> carts = ReadWriteCart.readFileCart(username);
        System.out.println("Nhập tên hàng muốn xóa: ");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getNameproduct().equals(nameProduct)) {
                carts.remove(i);
                ReadWriteCart.writeFileCart(carts, username);
                return i;
            }
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
                int choice;
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

    public static void menuCheckCart(String username) {
        List<Product> carts = ReadWriteCart.readFileCart(username);
        System.out.println("        -----[ Giỏ hàng của " + ManagerAccount.checkName(username) + " ]-----");
        for (int i = 0; i < carts.size(); i++) {
            System.out.println(carts.get(i).displayCart());
        }
        while (true) {
            try {
                System.out.println("1. Xóa khỏi giỏ hàng");
                System.out.println("2. Quay lại");
                int choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        removeCart(username);
                        break;
                    case 2:
                        return;
                    default:
                        System.err.println("Không có chức năng này!!" + '\n');
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
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
                    menuCheckCart(username);
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
