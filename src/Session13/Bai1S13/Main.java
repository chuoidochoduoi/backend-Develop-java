package Session13.Bai1S13;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean input = true;


        LinkedList<User> list = new LinkedList<>();
        while (true){

            System.out.println("""
                1.Them nguoi dung
                2.xoa nguoi dung
                3. hien thi ds nguoi dung
                4 thoat
               
                """);

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("dien ten:");
                    String user = scanner.nextLine();
                    System.out.println("dien email:");

                    String email = scanner.nextLine();
                    System.out.println("dien dienthoai:");

                    String phone = scanner.nextLine();

                    list.add(new User(user,email,phone));
                    break;
                    case 2:
                        String email1 = scanner.nextLine();

                        for (int i = 0; i < list.size(); i++) {
                            if (list.get(i).email.equals(email1)){
                                list.remove(i);
                            }
                        }
                        break;
                        case 3:

                            for (int i = 0; i < list.size(); i++) {
                               list.get(i).print();
                            }
                            break;
                            case 4:
                                return ;

            }



        }

    }


}
