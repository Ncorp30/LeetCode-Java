import java.util.Scanner;

public class Subtraction {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Input two numbers
        System.out.print("Enter the first number: ");
        int num1 = scanner.nextInt();

        System.out.print("Enter the second number: ");
        int num2 = scanner.nextInt();

        // Perform subtraction
        int result = num1 - num2;

        // Display the result
        System.out.println("The subtraction is: " + result);

        scanner.close();
    }
}
