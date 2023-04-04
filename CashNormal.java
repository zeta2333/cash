package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-02 12:30
 */
public class CashNormal implements ISale {
    @Override
    //正常收款
    public double acceptCash(double price, int num) {
        return price * num;
    }
}
