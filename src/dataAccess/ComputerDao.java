package dataAccess;

import common.Validate;

/**
 *
 * @author ASUS
 */
public class ComputerDao {

    private static ComputerDao instance = null;
    private Validate validate = new Validate();

    public static ComputerDao Instance() {
        if (instance == null) {
            synchronized (ComputerDao.class) {
                if (instance == null) {
                    instance = new ComputerDao();
                }
            }
        }
        return instance;
    }

    public void calculate() {
        double memo = validate.checkNum("Enter number");
        while (true) {
            String operator = validate.checkOperator();
            if (operator.equalsIgnoreCase("+")) {
                memo += validate.checkNum("Enter number");
                System.out.printf("Memory:%.1f\n" ,memo);
            }
            if (operator.equalsIgnoreCase("-")) {
                memo -= validate.checkNum("Enter number");
                System.out.printf("Memory:%.1f\n" ,memo);
            }
            if (operator.equalsIgnoreCase("*")) {
                memo *= validate.checkNum("Enter number");
                System.out.printf("Memory:%.1f\n" ,memo);
            }
            if (operator.equalsIgnoreCase("/")) {
                memo /= validate.checkNum("Enter number");
                System.out.printf("Memory:%.1f\n" ,memo);
            }
            if (operator.equalsIgnoreCase("^")) {
                memo = Math.pow(memo, validate.checkNum("Enter number"));
                System.out.printf("Memory:%.1f\n" ,memo);
            }
            if (operator.equalsIgnoreCase("=")) {
                System.out.printf("Result:%.1f\n" ,memo);
                return;

            }
        }
    }

    public void calculateBMI() {
        double weight = validate.checkNum("Enter Weight(kg)");
        double height = validate.checkNum("Enter Height(m)");
        double bmi = weight / (height * height);
        System.out.printf("BMI number: %.2f\n", bmi);
        System.out.println("BMI Status: " + bmiStatus(bmi));
    }

    public String bmiStatus(double bmi) {
        if (bmi < 19) {
            return "Under-standard.";
        } else if (bmi >= 19 && bmi < 25) {
            return "Standard.";
        } else if (bmi >= 25 && bmi < 30) {
            return "Overweight.";
        } else if (bmi >= 30 && bmi < 40) {
            return "Fat - should lose weight";
        } else {
            return "Very fat - should lose weight immediately";
        }
    }
}
