package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-02 12:52
 */
public class CashRebate extends CashDiscount {

    private double moneyRebate;

    //初始化时设置折扣
    public CashRebate(double moneyRebate) {
        this.moneyRebate = moneyRebate;
    }

    @Override
    public double acceptCash(double price, int num) {
        return super.acceptCash(price, num) * moneyRebate;
    }
}
