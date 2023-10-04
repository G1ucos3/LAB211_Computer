package common;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author ASUS
 */
public class Validate {

    private static final String op = "[+\\-*/^=]";

    public double checkNum(String s) {
        double num;
        while (true) {
            try {
                Scanner sc = new Scanner(System.in);
                System.out.print(s + ": ");
                num = sc.nextDouble();
                return num;
            } catch (InputMismatchException E) {
                System.err.println("Please input number.");
            }
        }
    }

    public String checkOperator() {
        String s = "";
        while (s.isBlank() || s.isEmpty()) {
            Scanner sc = new Scanner(System.in);
            System.out.print("Enter operator: ");
            s = sc.nextLine();
            if (s.matches(op)) {
                return s;
            }
            System.err.println("Please input (+, -, *, /, ^).");
        }
        return "";
    }
}
