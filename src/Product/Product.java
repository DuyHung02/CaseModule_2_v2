package Product;

import java.io.Serial;
import java.io.Serializable;

public class Product implements Serializable {
    @Serial
    private static final long serialVersionUID = -356273567659072509L;
    private int id;
    private String nameproduct;
    private double priceproduct;
    private String classify;
    private int amount;

    public Product(int id, String nameproduct, double priceproduct, String classify, int amount) {
        this.id = id;
        this.nameproduct = nameproduct;
        this.priceproduct = priceproduct;
        this.classify = classify;
        this.amount = amount;
    }

    public Product(String nameproduct, double priceproduct, String classify) {
        this.nameproduct = nameproduct;
        this.priceproduct = priceproduct;
        this.classify = classify;
    }

    public Product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameproduct() {
        return nameproduct;
    }

    public void setNameproduct(String nameproduct) {
        this.nameproduct = nameproduct;
    }

    public double getPriceproduct() {
        return priceproduct;
    }

    public void setPriceproduct(double priceproduct) {
        this.priceproduct = priceproduct;
    }

    public String getClassify() {
        return classify;
    }

    public void setClassify(String classify) {
        this.classify = classify;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "ID sản phẩm: " + id +
                "  Món: " + nameproduct + "\n" +
                "  Giá: " + priceproduct + "\n" +
                "  Loại: " + classify + "\n" +
                "  Số lượng: " + amount + "\n" +
                "--------------------------------------------------" + '\n';
    }


    public String displayCart() {
        return  "Món: " + nameproduct + '\n' +
                "Giá: " + priceproduct + '\n' +
                "Loại: " + classify + '\n' +
                "--------------------------------------------------" + '\n';
    }
}
