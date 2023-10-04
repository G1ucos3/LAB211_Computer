package repository;

import dataAccess.ComputerDao;

/**
 *
 * @author ASUS
 */
public class ComputerRepository implements IComputer {

    @Override
    public void calculate() {
        ComputerDao.Instance().calculate();
    }

    @Override
    public void calculateBMI() {
        ComputerDao.Instance().calculateBMI();
    }

}
