package Manager;

public class ManagerLogin {
    public static void login() {
        switch (ManagerAccount.checkLogin()) {
            case 1:
                ManagerAdmin.managerAdmin();
                break;
            case -1:
                ManagerGuest.managerGuest();
                break;
            case 0:
                break;
        }
    }
}
