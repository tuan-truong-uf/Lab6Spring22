// Lab 04, Feb 22, 2022
// Nathan Truong

import java.util.Scanner;
public class NumericConversion {
    // this method translates a binary string to a hex string
    public static String binaryToHex(String binary) {
        String binaryToHex = "";
        int index = binary.length() % 4;
        int holdNum = 0;

        // if the binary string's length is not divisible by 4, then the remainder will be dealt with first, aka 1st char in the hex string
        if (index != 0) { // check if binary length % 4 is not 0
            for (int i = 0; i < index; ++i) {
                if (binary.charAt(i) == '1') {
                    holdNum += (int) Math.pow(2, index - i - 1);  // holdNum will hold a value from 0 to 15
                }
            }
            binaryToHex += hexCharReturn(holdNum);  // turns holdNum into a hex char
        }

        // loops once every 4 indices
        for (int i = index; i < binary.length(); i += 4) {
            holdNum = 0;  // resets the holdNum to 0 to count again
            // loop through the 4 indices in a group to translate to a hex char
            for (int j = 0; j < 4; ++j) {
                if (binary.charAt(i + j) == '1') {
                    holdNum += (int) Math.pow(2, 3 - j);
                }
            }
            binaryToHex += hexCharReturn(holdNum);  // same as above, turns holdNum into a hex char
        }

        return binaryToHex;  // return the string
    }

    // this method decodes a binary string and returns a decimal one
    public static short binaryStringDecode(String binary) {
        short biToDec = 0;
        int holdNum;

        // this loop adds up every value of the binary string
        for (int i = 0; i < binary.length(); ++i) {
            if (binary.charAt(i) == '1') { // checks if that index should be multiplied by 2
                holdNum = 2;
                biToDec += Math.pow(holdNum, binary.length() - i - 1);  // multiply 2 by a certain number, based on the index that occurred
            }
        }

        return biToDec;  // return decimal number
    }

    // this method decodes a hex string and return decimal number
    public static long hexStringDecode(String hex) {
        hex = hex.toUpperCase(); // to avoid complication
        long hexToDec = 0;
        int firstDigit;

        // this loop goes through each index and add multiplication at the end
        for (int i = 0; i < hex.length(); ++i) {
            if (hex.charAt(0) == '0' && (hex.charAt(1) == 'x' || hex.charAt(1) == 'b')) { // check for 0x and 0b
                continue;
            }
            firstDigit = hexCharDecode(hex.charAt(i));
            hexToDec += firstDigit * Math.pow(16, (hex.length() - i - 1));  // multiply by a certain number, then add to the total
        }
        return hexToDec;
    }

    // turns hex digit characters into normal decimal digit integers
    public static short hexCharDecode(char digit) {
        short realNum;
        char newDigit = Character.toUpperCase(digit);
        switch (newDigit) {
            case '1':
                realNum = 1;
                break;
            case '2':
                realNum = 2;
                break;
            case '3':
                realNum = 3;
                break;
            case '4':
                realNum = 4;
                break;
            case '5':
                realNum = 5;
                break;
            case '6':
                realNum = 6;
                break;
            case '7':
                realNum = 7;
                break;
            case '8':
                realNum = 8;
                break;
            case '9':
                realNum = 9;
                break;
            case 'A':
                realNum = 10;
                break;
            case 'B':
                realNum = 11;
                break;
            case 'C':
                realNum = 12;
                break;
            case 'D':
                realNum = 13;
                break;
            case 'E':
                realNum = 14;
                break;
            case 'F':
                realNum = 15;
                break;
            default:
                realNum = 0;
                break;
        }

        return realNum;
    }

    // turn a digit into a hex character
    public static char hexCharReturn(int digit) {
        char realNum;

        switch (digit) {
            case 1:
                realNum = '1';
                break;
            case 2:
                realNum = '2';
                break;
            case 3:
                realNum = '3';
                break;
            case 4:
                realNum = '4';
                break;
            case 5:
                realNum = '5';
                break;
            case 6:
                realNum = '6';
                break;
            case 7:
                realNum = '7';
                break;
            case 8:
                realNum = '8';
                break;
            case 9:
                realNum = '9';
                break;
            case 10:
                realNum = 'A';
                break;
            case 11:
                realNum = 'B';
                break;
            case 12:
                realNum = 'C';
                break;
            case 13:
                realNum = 'D';
                break;
            case 14:
                realNum = 'E';
                break;
            case 15:
                realNum = 'F';
                break;
            default:
                realNum = '0';
                break;
        }

        return realNum;
    }

    // main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int menuChoice;
        String enterString;
        boolean menu = true;

        // setting up the menu
        while (menu) {
            System.out.println("Decoding Menu");
            System.out.println("-------------");
            System.out.println("1. Decode hexadecimal");
            System.out.println("2. Decode binary");
            System.out.println("3. Convert binary to hexadecimal");
            System.out.println("4. Quit");
            System.out.println();
            System.out.print  ("Please enter an option: ");
            menuChoice = scanner.nextInt();

            if (menuChoice == 1) {  // 1st option
                System.out.print("Please enter the numeric string to convert: ");
                enterString = scanner.next();
                System.out.print("Result: " + hexStringDecode(enterString) + "\n");  // return a decimal number from the hex string
                System.out.println();
            }
            else if (menuChoice == 2) {  // 2nd option
                System.out.print("Please enter the numeric string to convert: ");
                enterString = scanner.next();
                System.out.println("Result: " + binaryStringDecode(enterString) + "\n");  // return a decimal number from the binary string
                System.out.println();
            }
            else if (menuChoice == 3) {  // 3rd option
                System.out.print("Please enter the numeric string to convert: ");
                enterString = scanner.next();
                System.out.println("Result: " + binaryToHex(enterString) + "\n");  // return a hex string from the binary string
                System.out.println();
            }
            else if (menuChoice == 4) {  // 4th option
                System.out.println("Goodbye!");
                menu = false;  // log off from humanity
            }
        }
    }
}
