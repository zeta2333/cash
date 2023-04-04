package cash;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-02 12:29
 */
public interface ISale {
    //定义抽象的收款方法
    double acceptCash(double price, int num);
}
