package ReadWriteFile;

import Account.Account;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadWriteAccount {
    public static List<Account> readFile() {
        try {
            FileInputStream fis = new FileInputStream("listaccount.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            return (List<Account>) ois.readObject();
        } catch (Exception e){
            e.printStackTrace();
            return new ArrayList<>();
        }
    }

        public static void writeFile(List<Account> accounts) {
            try {
                FileOutputStream fos = new FileOutputStream("listaccount.txt");
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(accounts);
                oos.close();
                fos.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
