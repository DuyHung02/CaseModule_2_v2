package ReadWriteFile;

import Account.Account;
import Product.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;


public class ReadWriteProduct {
    public static List<Product> readFileSp() {
        try {
            FileInputStream fis = new FileInputStream("listproduct.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (List<Product>) ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

        public static void writeFileSp(List<Product> products) {
            try {
                FileOutputStream fos = new FileOutputStream("listproduct.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(products);
                oos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
