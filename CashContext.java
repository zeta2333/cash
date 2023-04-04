package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-02 13:09
 */
public class CashContext {
    private ISale cs;//声明一个ISale接口对象

    public CashContext(int cashType) {
        IFactory fs = null;
        switch (cashType) {
            case 1 -> fs = new CashRebateReturnFactory(1, 0, 0);//正常收费
            case 2 -> fs = new CashRebateReturnFactory(0.8, 0, 0);//打8折
            case 3 -> fs = new CashRebateReturnFactory(0.7, 0, 0);//打7折
            case 4 -> fs = new CashRebateReturnFactory(1, 300, 100);//满300减100
            case 5 -> fs = new CashRebateReturnFactory(0.8, 300, 100);//先打八折，再满300返100
            case 6 -> fs = new CashReturnRebateFactory(0.7, 200, 50);//先满200返50，再打7折
        }
        cs = fs.createSaleModel();
    }

    public double getResult(double price, int num) {
        //根据收费策略不同，获得计算结果
        return cs.acceptCash(price, num);
    }
}
