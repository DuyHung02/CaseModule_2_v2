package Manager;

import Product.CreateProduct;
import Product.Product;
import ReadWriteFile.ReadWriteProduct;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManagerProduct {
    static Scanner scanner = new Scanner(System.in);
    static CreateProduct createProduct = new CreateProduct();
    static List<Product> products = ReadWriteProduct.readFileSp();

    public static Product createProduct() {
        return new Product(createProduct.idProduct(), createProduct.nameProduct(), createProduct.priceProduct(), createProduct.classifyProduct(), createProduct.amountProduct());
    }

    public static void add(Product product) {
        products.add(product);
        ReadWriteProduct.writeFileSp(products);
        System.out.println("Thêm thành công!\n");
    }

    public static void show() {
        System.out.println("Tổng số món hiện có: " + "(" + products.size() + ")");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).toString());
        }
    }

    public static void edit() {
        System.out.println("Nhập tên sản phẩm muốn sửa: ");
        String nameProduct = scanner.nextLine();
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNameproduct().equals(nameProduct)) {
                int choice;
                String menu = "Chọn chức năng\n" +
                        "1. Thay đổi tên\n" +
                        "2. Thay đổi giá\n" +
                        "3. Thay đổi phân loại\n" +
                        "4. Thay đổi số lượng\n" +
                        "5. Quay lại";
                while (true) {
                    System.out.println(menu);
                    System.out.println("Chọn: ");
                    choice = Integer.parseInt(scanner.nextLine());
                    switch (choice) {
                        case 1:
                            String newNameProduct = ManagerProduct.createProduct.nameProduct();
                            Product productName = new Product(products.get(i).getId(), newNameProduct, products.get(i).getPriceproduct(), products.get(i).getClassify(), products.get(i).getAmount());
                            products.set(i, productName);
                            ReadWriteProduct.writeFileSp(products);
                            System.out.println("OK!!\n");
                            break;
                        case 2:
                            double newPriceProduct = ManagerProduct.createProduct.priceProduct();
                            Product productPrice = new Product(products.get(i).getId(), products.get(i).getNameproduct(), newPriceProduct, products.get(i).getClassify(), products.get(i).getAmount());
                            products.set(i, productPrice);
                            ReadWriteProduct.writeFileSp(products);
                            System.out.println("OK!!\n");
                            break;
                        case 3:
                            String newClassifyProduct = ManagerProduct.createProduct.classifyProduct();
                            Product productClassify = new Product(products.get(i).getId(), products.get(i).getNameproduct(), products.get(i).getPriceproduct(), newClassifyProduct, products.get(i).getAmount());
                            products.set(i, productClassify);
                            ReadWriteProduct.writeFileSp(products);
                            System.out.println("OK!!\n");
                            break;
                        case 4:
                            int newAmountProduct = ManagerProduct.createProduct.amountProduct();
                            Product productAmount = new Product(products.get(i).getId(), products.get(i).getNameproduct(), products.get(i).getPriceproduct(), products.get(i).getClassify(), newAmountProduct);
                            products.set(i, productAmount);
                            ReadWriteProduct.writeFileSp(products);
                            System.out.println("OK!!\n");
                            break;
                        case 5:
                            return;
                        default:
                            System.err.println("Không có chức năng này!!\n");
                    }
                }
            }
        }
    }

    public static void deleteByName() {
        System.out.println("[Nhập tên sản phẩm]: ");
        String nameProduct = scanner.nextLine();
        if (checkNameSp(nameProduct)) {
            for (int i = 0; i < products.size(); i++) {
                if (products.get(i).getNameproduct().equals(nameProduct)) {
                    products.remove(i);
                    System.out.println("Xóa thành công!\n");
                }
            }
        } else {
            System.err.println("Không thấy sản phẩm!!\n");
        }
    }


    //    {\__/}
    //    ( . .)
    //    | v  > <==3 cak


    public boolean checkIdSp(int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == id)
                return true;
        }
        return false;
    }

    public static boolean checkNameSp(String nameProduct) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getNameproduct().equals(nameProduct))
                return true;
        }
        return false;
    }
}
