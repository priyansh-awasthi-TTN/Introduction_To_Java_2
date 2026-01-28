import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class User {

    private String firstName;
    private String lastName;
    private int age;
    private String phoneNumber;

    public User(String firstName, String lastName, int age, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.phoneNumber = phoneNumber;
    }

    public String toFileString() {
        return firstName + "," + lastName + "," + age + "," + phoneNumber;
    }
}


public class UserDetails {

    private static final String FILE_NAME = "users.txt";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {

            System.out.print("Enter First Name: ");
            String firstName = scanner.nextLine();

            System.out.print("Enter Last Name: ");
            String lastName = scanner.nextLine();

            System.out.print("Enter Age: ");
            int age = Integer.parseInt(scanner.nextLine());

            System.out.print("Enter Phone Number: ");
            String phoneNumber = scanner.nextLine();

            User user = new User(firstName, lastName, age, phoneNumber);

            appendUserToFile(user);

            System.out.println("User saved successfully.");

            System.out.print("Do you want to continue creating users? (Type QUIT to exit): ");
            String choice = scanner.nextLine();

            if ("QUIT".equalsIgnoreCase(choice)) {
                System.out.println("Exiting program.");
                break;
            }
        }

        scanner.close();
    }

    private static void appendUserToFile(User user) {
        try (FileWriter writer = new FileWriter(FILE_NAME, true)) {
            writer.write(user.toFileString());
            writer.write(System.lineSeparator());
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }
}
