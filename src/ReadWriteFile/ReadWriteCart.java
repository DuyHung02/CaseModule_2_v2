package ReadWriteFile;

import Product.Product;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteCart {
    public static List<Product> readFileCart(String username) {
        try {
            FileInputStream fis = new FileInputStream("D:\\CODEGYM\\modul 2\\Case modul 2\\CaseModule2_v2\\CaseModule2_v2\\src\\Cart\\CartUser\\" + username + ".txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (List<Product>) ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

    public static void writeFileCart(List<Product> carts, String username) {
        try {
            FileOutputStream fos = new FileOutputStream( "D:\\CODEGYM\\modul 2\\Case modul 2\\CaseModule2_v2\\CaseModule2_v2\\src\\Cart\\CartUser\\" + username + ".txt");
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(carts);
            oos.close();
            fos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
