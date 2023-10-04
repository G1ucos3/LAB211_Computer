package controller;

import model.Computer;
import repository.ComputerRepository;
import view.Menu;

/**
 *
 * @author ASUS
 */
public class ComputerController extends Menu<Computer> {
    
    static String[] mc = {"Normal Calculator", "BMI Calculator", "Exit"};
    ComputerRepository cr;
    
    public ComputerController(){
        super("Calculator Program", mc);
        cr = new ComputerRepository();
    }

    @Override
    public void execute(int choice) {
        switch(choice){
            case 1:
                System.out.println("----- Normal Calculator -----");
                cr.calculate();
                break;
            case 2: 
                System.out.println("----- BMI Calculator -----");
                cr.calculateBMI();
                break;
            case 3:
                System.out.println("Exit!");
                System.exit(0);
            default:
                System.out.println("Choose again.");
                break;
        }
    }
    
    
}
