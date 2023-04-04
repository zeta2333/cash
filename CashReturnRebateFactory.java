package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-03 5:38 PM
 * 先满减再打折
 */
public class CashReturnRebateFactory implements IFactory {
    private double moneyRebate;//打折
    private double moneyCondition;//满减条件
    private double moneyReturn;//满减金额

    public CashReturnRebateFactory(double moneyRebate, double moneyCondition, double moneyReturn) {
        this.moneyRebate = moneyRebate;
        this.moneyCondition = moneyCondition;
        this.moneyReturn = moneyReturn;
    }

    @Override
    public ISale createSaleModel() {
        CashNormal cn = new CashNormal();
        CashReturn cr1 = new CashReturn(moneyCondition, moneyReturn);
        CashRebate cr2 = new CashRebate(moneyRebate);
        cr1.decorate(cn);
        cr2.decorate(cr1);
        return cr2;
    }
}
