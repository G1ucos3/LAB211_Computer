package view;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author ASUS
 */
public abstract class Menu<T> {

    protected String title;
    protected ArrayList<T> mChoice;

    public Menu() {
        mChoice = new ArrayList<>();
    }

    public Menu(String tl, String[] mc) {
        title = tl;
        mChoice = new ArrayList<>();
        for (String s : mc) {
            mChoice.add((T) s);
        }
    }

    public void display() {
        System.out.println("========= " + title + " =========");
        for (int i = 0; i < mChoice.size(); i++) {
            System.out.println((i + 1) + ". " + mChoice.get(i));
        }
    }

    public int getChoice() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Please choose one option: ");
        int choice = sc.nextInt();
        return choice;
    }

    public abstract void execute(int choice);

    public void run() {
        int choice = mChoice.size() + 1;
        while (choice != mChoice.size()) {
            try {
                display();
                choice = getChoice();
            } catch (InputMismatchException E) {
                choice = mChoice.size() + 1;
            }
            execute(choice);
        }
    }
}
