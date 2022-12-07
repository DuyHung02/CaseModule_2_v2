package Manager;

public class ManagerGuest extends ManagerAccount {

    public static void info(int index) {
        System.out.println(accounts.get(index).inFoGuest());
    }

    public static void naptien(int index) {
        int choice;
        String menu = """
                Mệnh giá: 
                1. 20000.đ
                2. 50000.đ
                3. 100000.đ
                4. 200000.đ
                5. 500000.đ
                0. Quay lại
                """;
        while (true) {
            try {
                System.out.println(menu);
                System.out.println("[Chọn mệnh giá]: ");
                choice = Integer.parseInt(scanner.nextLine());
                switch (choice) {
                    case 1:
                        accounts.get(index).setMoney(accounts.get(index).getMoney() + 20000);
                        System.out.println("Nạp thành công!" + '\n');
                        return;
                    case 2:
                        accounts.get(index).setMoney(accounts.get(index).getMoney() + 50000);
                        System.out.println("Nạp thành công!" + '\n');

                        return;
                    case 3:
                        accounts.get(index).setMoney(accounts.get(index).getMoney() + 100000);
                        System.out.println("Nạp thành công!" + '\n');
                        return;
                    case 4:
                        accounts.get(index).setMoney(accounts.get(index).getMoney() + 200000);
                        System.out.println("Nạp thành công!" + '\n');
                        return;
                    case 5:
                        accounts.get(index).setMoney(accounts.get(index).getMoney() + 500000);
                        System.out.println("Nạp thành công!" + '\n');
                        return;
                    case 0:
                        return;
                }
            } catch (NumberFormatException e) {
                System.err.println("Nhập số!!" + '\n');
            }
        }
    }
}


//    {\__/}
//    ( . .)
//    | v  > <==3 cak


