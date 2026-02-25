package Session16.bai2s16;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Message> messages = new ArrayList<>();

        while (true) {
            System.out.println("\n===== CHAT APPLICATION =====");
            System.out.println("1. Send Message");
            System.out.println("2. View Chat History");
            System.out.println("3. Filter by Sender");
            System.out.println("4. Filter by Date");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");

            int choice;

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                System.out.println("Invalid input!");
                continue;
            }

            switch (choice) {

                case 1:
                    System.out.print("Enter sender: ");
                    String sender = sc.nextLine();

                    System.out.print("Enter content: ");
                    String content = sc.nextLine();

                    messages.add(new Message(sender, content));
                    System.out.println("Message sent successfully!");
                    break;

                case 2:
                    if (messages.isEmpty()) {
                        System.out.println("No messages.");
                    } else {
                        messages.forEach(System.out::println);
                    }
                    break;

                case 3:
                    System.out.print("Enter sender to filter: ");
                    String name = sc.nextLine();

                    messages.stream()
                            .filter(m -> m.getSender().equalsIgnoreCase(name))
                            .forEach(System.out::println);
                    break;

                case 4:
                    System.out.print("Enter date (dd/MM/yyyy): ");
                    String inputDate = sc.nextLine();

                    try {
                        DateTimeFormatter formatter =
                                DateTimeFormatter.ofPattern("dd/MM/yyyy");

                        LocalDate date = LocalDate.parse(inputDate, formatter);

                        messages.stream()
                                .filter(m -> m.getTimestamp()
                                        .toLocalDate()
                                        .equals(date))
                                .forEach(System.out::println);

                    } catch (Exception e) {
                        System.out.println("Invalid date format!");
                    }
                    break;

                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }

    }
}