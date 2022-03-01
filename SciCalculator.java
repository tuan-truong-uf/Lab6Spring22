// Nathan Truong, Scientific Calculator
import java.util.Scanner;

public class SciCalculator {
    static Scanner scanner = new Scanner(System.in);

    public static double firstNum(double curNum) {
        // picking up first user-inputted operand
        System.out.print  ("Enter first operand: " );
        String num1 = scanner.next();
        if (!num1.equals("RESULT")) {
            curNum = Double.parseDouble(num1);
        }
        return curNum;
    }

    public static double secNum(double curNum) {
        // picking up second user-inputted operand
        System.out.print  ("Enter second operand: " );
        String num2 = scanner.next();
        if (!num2.equals("RESULT")) {
            curNum = Double.parseDouble(num2);
        }
        return curNum;
    }

    public static void main(String[] args) {
        // declaring new variables
        int numCalc = 0;
        double num1;
        double num2;
        double num3;
        double   newResult = 0.0;
        double totalResult = 0.0;
        boolean calculatorMenu = true;
        boolean      printMenu = true;

        System.out.println("Current Result: " + totalResult);

        while (calculatorMenu) {

            // printing out the menu
            if (printMenu) {
                System.out.println("Calculator Menu"   );
                System.out.println("---------------"   );
                System.out.println("0. Exit Program"   );
                System.out.println("1. Addition"       );
                System.out.println("2. Subtraction"    );
                System.out.println("3. Multiplication" );
                System.out.println("4. Division"       );
                System.out.println("5. Exponentiation" );
                System.out.println("6. Logarithm"      );
                System.out.println("7. Display Average");
            }
            System.out.print("\nEnter Menu Selection: ");
            int operation = scanner.nextInt();

            // checking what operation to perform, then print out the answer
            switch (operation) {
                case 0:
                    System.out.println("Thanks for using this calculator. Goodbye!");
                    calculatorMenu = false;
                    break;
                case 1:
                    // picking up two user-inputted operands
                    num1 = firstNum(newResult);
                    num2 =   secNum(newResult);

                    num3 = num1 + num2;  // adding 2 numbers
                    System.out.println("\nCurrent Result: " + num3);
                    totalResult += num3;
                    newResult = num3;
                    ++numCalc;
                    break;
                case 2:
                    // picking up two user-inputted operands
                    num1 = firstNum(newResult);
                    num2 =   secNum(newResult);

                    num3 = num1 - num2;  // subtracting 2 numbers
                    System.out.println("\nCurrent Result: " + num3);
                    totalResult += num3;
                    newResult = num3;
                    ++numCalc;
                    break;
                case 3:
                    // picking up two user-inputted operands
                    num1 = firstNum(newResult);
                    num2 =   secNum(newResult);

                    num3 = num1 * num2;  // times 2 numbers
                    System.out.println("\nCurrent Result: " + num3);
                    totalResult += num3;
                    newResult = num3;
                    ++numCalc;
                    break;
                case 4:
                    // picking up two user-inputted operands
                    num1 = firstNum(newResult);
                    num2 =   secNum(newResult);

                    num3 = num1 / num2;  // divide 2 numbers
                    System.out.println("\nCurrent Result: " + num3);
                    totalResult += num3;
                    newResult = num3;
                    ++numCalc;
                    break;
                case 5:
                    // picking up two user-inputted operands
                    num1 = firstNum(newResult);
                    num2 =   secNum(newResult);

                    num3 = Math.pow(num1, num2);  // num1 ^ num2
                    System.out.println("\nCurrent Result: " + num3);
                    totalResult += num3;
                    newResult = num3;
                    ++numCalc;
                    break;
                case 6:
                    // picking up two user-inputted operands
                    num1 = firstNum(newResult);
                    num2 =   secNum(newResult);

                    num3 = Math.log10(num2) / Math.log10(num1);  // log num1 (num2)
                    System.out.println("\nCurrent Result: " + num3);
                    totalResult += num3;
                    newResult = num3;
                    ++numCalc;
                    break;
                case 7:
                    if (numCalc == 0) {
                        System.out.println("Error: No calculations yet to average!");  // when there is no calculation before
                    }
                    else{
                        System.out.println("Sum of calculations: " + totalResult);  // normal result
                        System.out.println("Number of calculations: " + numCalc);
                        System.out.print  ("Average of calculations: ");
                        System.out.printf ("%.2f", totalResult / numCalc);
                    }
                    printMenu = false;
                    break;
                default:
                    System.out.println("Error: Invalid selection!");  // error message
                    printMenu = false;
                    break;
            }
        }
    }
}
