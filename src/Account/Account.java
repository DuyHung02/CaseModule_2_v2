package Account;

public class Account {
    static int genid = 0;
    private int id;
    private String username;
    private String password;
    private String phone;

    public Account(String username, String passwork, String phone, String birthday) {
    }

    public Account(int id, String username, String password, String phone) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.phone = phone;
    }

    public Account(String username, String password, String phone) {
        this.id = ++genid;
        this.username = username;
        this.password = password;
        this.phone = phone;
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

    @Override
    public String toString() {
        return  "Account ID : " + id + "\n" +
                "Username   : " + username + '\n' +
                "Phone      : " + phone + '\n' +
                "---------------------------------------";
    }
}
