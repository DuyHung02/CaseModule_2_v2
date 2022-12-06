package Product;

import Manager.ManagerProduct;

import java.util.Scanner;

public class CreateProduct {
    static Scanner scanner = new Scanner(System.in);
    static ManagerProduct managerProduct = new ManagerProduct();

    public int idProduct() {
        int id = 0;
        while (true) {
            if (managerProduct.checkIdSp(id)) {
                ++id;
            } else {
                return id;
            }
        }
    }

    public String nameProduct() {
        while (true) {
            System.out.println("[Nhập tên sản phẩm]: ");
            String nameproduct = scanner.nextLine();
            if (!managerProduct.checkNameSp(nameproduct)) {
                System.out.print("ok!\n");
                return nameproduct;
            } else {
                System.err.println("Không đặt trùng tên món!!\n");
            }
        }
    }

    public double priceProduct() {
        while (true) {
            try {
                System.out.println("[Nhập giá sản phẩm]: ");
                double priceproduct = Double.parseDouble(scanner.nextLine());
                if (priceproduct >= 0) {
                    return priceproduct;
                } else {
                    System.err.println("Giá không thể âm!!\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!\n");
            }
        }
    }

    public String classifyProduct() {
        int choice;
        String classify = null;
        String menuchoice = """
                Phân loại món:\s
                1. Tanh\s
                2. Không tanh\s
                """;
        while (true) {
            System.out.println(menuchoice);
            System.out.println("Chọn: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1:
                    classify = "Món tanh";
                    return classify;
                case 2:
                    classify = "Món không tanh";
                    return classify;
                default:
                    System.err.println("Chọn (1) hoặc (2)!!");
            }
        }
    }

    public int amountProduct() {
        while (true) {
            try {
                System.out.println("[Nhập số lượng món]: ");
                int amount = Integer.parseInt(scanner.nextLine());
                if (amount >= 0) {
                    return amount;
                } else {
                    System.err.println("Nhập số dương!!\n");
                }
            } catch (NumberFormatException e) {
                System.err.println("Vui lòng nhập số!!\n");
            }
        }
    }
}
