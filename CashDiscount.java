package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-02 12:31
 */
public abstract class CashDiscount implements ISale {
    //目标装饰对象component
    protected ISale component;

    //setter：装饰一个目标对象
    public void decorate(ISale component) {
        this.component = component;
    }

    @Override
    public double acceptCash(double price, int num) {
        double result = 0;
        if (component != null) {
            //如果装饰对象存在，则执行装饰的算法运算
            result = component.acceptCash(price, num);
        }
        return result;
    }
}
