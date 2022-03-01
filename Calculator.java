import java.util.Scanner;
public class Calculator {
    public static void main(String[] args) {
        // declaring new variables
        Scanner scanner = new Scanner(System.in);
        double num1;
        double num2;
        double num3;

        // picking up two user-inputted operands
        System.out.println("Enter first operand: " );
        num1 = scanner.nextDouble();
        System.out.println("Enter second operand: ");
        num2 = scanner.nextDouble();

        // printing out the menu
        System.out.println("Calculator Menu"  );
        System.out.println("---------------"  );
        System.out.println("1. Addition"      );
        System.out.println("2. Subtraction"   );
        System.out.println("3. Multiplication");
        System.out.println("4. Division"      );
        System.out.print  ("Which operation do you want to perform? ");
        int operation = scanner.nextInt();

        // checking what operation to perform, then print out the answer
        switch (operation) {
            case 1:
                num3 = num1 + num2;  // adding 2 numbers
                System.out.println("The result of the operation is " + num3 + ". Goodbye!");
                break;
            case 2:
                num3 = num1 - num2;  // subtracting 2 numbers
                System.out.println("The result of the operation is " + num3 + ". Goodbye!");
                break;
            case 3:
                num3 = num1 * num2;  // times 2 numbers
                System.out.println("The result of the operation is " + num3 + ". Goodbye!");
                break;
            case 4:
                num3 = num1 / num2;  // divide 2 numbers
                System.out.println("The result of the operation is " + num3 + ". Goodbye!");
                break;
            default:
                System.out.println("Error: Invalid selection! Terminating program."       );
                break;
        }
    }
}
