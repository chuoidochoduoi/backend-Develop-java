package Session17.Bai1s1;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        MovieManagement manager = new MovieManagement();

        while (true) {
            System.out.println("\n===== MOVIE MANAGEMENT =====");
            System.out.println("1. Add Movie");
            System.out.println("2. List Movies");
            System.out.println("3. Update Movie");
            System.out.println("4. Delete Movie");
            System.out.println("0. Exit");
            System.out.print("Choose: ");

            try {
                int choice = Integer.parseInt(sc.nextLine());

                switch (choice) {

                    case 1:
                        System.out.print("Title: ");
                        String title = sc.nextLine();

                        System.out.print("Director: ");
                        String director = sc.nextLine();

                        System.out.print("Year: ");
                        int year = Integer.parseInt(sc.nextLine());

                        if (title.isEmpty() || director.isEmpty()) {
                            throw new IllegalArgumentException("Không được để trống!");
                        }

                        manager.addMovie(title, director, year);
                        break;

                    case 2:
                        manager.listMovies();
                        break;

                    case 3:
                        System.out.print("ID: ");
                        int id = Integer.parseInt(sc.nextLine());

                        System.out.print("Title: ");
                        title = sc.nextLine();

                        System.out.print("Director: ");
                        director = sc.nextLine();

                        System.out.print("Year: ");
                        year = Integer.parseInt(sc.nextLine());

                        manager.updateMovie(id, title, director, year);
                        break;

                    case 4:
                        System.out.print("ID: ");
                        id = Integer.parseInt(sc.nextLine());

                        manager.deleteMovie(id);
                        break;

                    case 0:
                        System.out.println("Thoát chương trình.");
                        return;

                    default:
                        System.out.println("Lựa chọn không hợp lệ!");
                }

            } catch (NumberFormatException e) {
                System.out.println("Lỗi: Vui lòng nhập đúng kiểu số!");
            } catch (IllegalArgumentException e) {
                System.out.println("Lỗi: " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Lỗi hệ thống: " + e.getMessage());
            }
        }
    }
}
