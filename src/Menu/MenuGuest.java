package Menu;

import java.util.Scanner;

public class MenuGuest {

    public static void menuGuest() {
        String menu = """
                (Guest) Chọn chức năng: \s
                1. Thông tin tài khoản
                2. Đổi mật khẩu
                3. Mua hàng
                4. Nạp tiền
                0. Đăng xuất
                """;
        System.out.println(menu);
    }
}
