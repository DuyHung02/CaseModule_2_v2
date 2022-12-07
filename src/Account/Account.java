package Account;

import java.io.Serial;
import java.io.Serializable;

public class Account implements Serializable {
    @Serial
    private static final long serialVersionUID = -2306144997897254504L;

    private int id = 0;
    private String name;
    private String username;
    private String password;
    private String phone;
    private double money = 0;
    private int role;



    public Account(int id, String name, String username, String password, String phone, double money, int role) {
        this.id = id;
        this.name = name;
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.money = money;
        this.role = role;
    }

    public Account(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public double getMoney() {
        return money;
    }

    public double setMoney(double money) {
        this.money = money;
        return money;
    }

    public int getRole() {
        return role;
    }

    public void setRole(int role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return  "Account ID : " + id + "\n" +
                "Người sử dụng: " + name + '\n' +
                "Username   : " + username + '\n' +
                "Phone      : " + phone + '\n' +
                "---------------------------------------";
    }

    public String inFoGuest() {
        return  "Account ID    : " + id + "\n" +
                "Người sử dụng : " + name + '\n' +
                "Username      : " + username + '\n' +
                "Password      : " + password + '\n' +
                "Phone         : " + phone + '\n' +
                "Số dư         : " + money + '\n' +
                "---------------------------------------";
    }
}
