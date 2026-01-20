package Session6;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Bai2S6 {

    public static void main(String[] args) {




Scanner in = new Scanner(System.in);
         boolean check = true;

         String name = "", email= "", pass= "" ,phone = "";
        while (check) {
            System.out.println("""
              ******  Quản lí Người dùng ******
               1. Nhập thông tin người dùng
               2. Chuẩn hóa họ tên
               3. Kiểm tra email hợp lệ
               4. kiểm tra số điện thoại hợp lệ
               5. Kiểm tra mật khẩu hợp lệ
               6. Thoát.""");
                int pick = in.nextInt();
                in.nextLine();
                switch (pick) {
                    case 1:
                        System.out.println("Nhập tên :");

                         name = in.nextLine();
                        System.out.println("Nhập email :");
                         email = in.nextLine();

                        System.out.println("Nhập số điện thoại :");
                         phone = in.nextLine();


                        System.out.println("Nhập Mật khẩu :");
                         pass = in.nextLine();

                    break;
                    case 2:

                        Pattern pattern = Pattern.compile("^[ ]+|[0-9]+|[ ]+$");

                        Matcher matcher = pattern.matcher(name);

                       name =  matcher.replaceAll("");
                        System.out.println(name);
                        break;
                    case 3:
                        Pattern pattern3 = Pattern.compile("^[\\w]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{2,})+$");
                        Matcher matcher3 = pattern3.matcher(email);


                        if (matcher3.matches()) {
                            System.out.println("đúng là email");
                        }else {
                            System.out.println("không phải email");
                        }
                        break;
                    case 4:
                        Pattern pattern4 = Pattern.compile("^0[0-9]{9}$");


                        Matcher matcher4 = pattern4.matcher(phone);


                        if (matcher4.matches()) {
                            System.out.println("đúng là số vn");
                        }else {
                            System.out.println("không phải số vn");
                        }
                        break;
                    case 5:

                        Pattern pattern5 = Pattern.compile("^(?=.*[0-9])(?=.*[A-Z])(?=.*[\\W]).{8,}$");
                        Matcher matcher5 = pattern5.matcher(pass);

                        if (matcher5.matches()) {
                            System.out.println("đúng là pass");
                        }else {
                            System.out.println("không phải pass");
                        }
                        break;
                    case 6:
                        check = false;
                        break;
                        default:
                            System.out.println("Điền đúng 1-6");
                            break;
                }

        }
    }

}
