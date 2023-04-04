package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-02 13:00
 */
public class CashReturn extends CashDiscount {
    private double moneyCondition;
    private double moneyReturn;

    //初始化时设置返利条件和返利的金额
    public CashReturn(double moneyCondition, double moneyReturn) {
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    //达到返利条件，就减去返利金额
    public double acceptCash(double price, int num) {
        double result = super.acceptCash(price, num);
        if (moneyCondition > 0 && result >= moneyCondition) {
            result -= Math.floor(result / moneyCondition) * moneyReturn;
        }
        return result;
    }
}
