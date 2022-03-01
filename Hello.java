// Lab 01, Hello
// Property of Nathan_Truong, COP3502C, Spring 2022
import java.util.Scanner;
public class Hello {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String name;
        String age;
        String place;
        // set up variables, as well as Scanner
        System.out.print("Hello. What is your name? ");
        name = scanner.next();  // enter name to continue
        System.out.print("It's nice to meet you, " + name + ". How old are you? ");
        age = scanner.next();  // enter age to continue
        System.out.println("I see that you are still quite young at only " + age + ".");
        System.out.print("Where do you live? ");
        place = scanner.next();  // enter place to continue
        System.out.println("Wow! I've always wanted to go to " + place + ". Thanks for chatting with me. Bye! ");
    }
}
