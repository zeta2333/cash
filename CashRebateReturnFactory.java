package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-03 5:42 PM
 * 先打折再满减
 */
public class CashRebateReturnFactory implements IFactory {
    private double moneyRebate;//打折
    private double moneyCondition;//满减条件
    private double moneyReturn;//满减金额

    public CashRebateReturnFactory(double moneyRebate, double moneyCondition, double moneyReturn) {
        this.moneyRebate = moneyRebate;
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public ISale createSaleModel() {
        CashNormal cn = new CashNormal();
        CashRebate cr1 = new CashRebate(moneyRebate);
        CashReturn cr2 = new CashReturn(moneyCondition, moneyReturn);
        cr1.decorate(cn);
        cr2.decorate(cr1);
        return cr2;
    }
}
