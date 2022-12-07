package Menu;

import java.util.Scanner;

public class MenuGuest {

    public static void menuGuest() {
        String menu = """
                o _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ o
                |                                     |
                |   (Guest) Chọn chức năng:           |
                |   1. Thông tin tài khoản            |
                |   2. Đổi mật khẩu                   |
                |   3. Mua hàng                       |
                |   4. Nạp tiền                       |
                |   0. Đăng xuất                      |
                                                      |
                o _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ o
                """;
        System.out.println(menu);
    }
}
