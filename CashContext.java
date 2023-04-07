package cash;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

/**
 * @author Pycro
 * @version 1.0
 * 2023-04-02 13:09
 */
public class CashContext {
    private ISale cs;//声明一个ISale接口对象

    //获取配置文件
    public String getConfig(int number) {
        String result = "";
        try {
            Properties properties = new Properties();
            BufferedReader bufferedReader = new BufferedReader(new FileReader("src/cash/data.properties"));
            properties.load(bufferedReader);
            result = properties.getProperty("strategy" + number);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }

    //根据配置文件获得相关的对象实例
    public IFactory getInstance(String className, double a, double b, double c) {
        IFactory result;
        try {
            result = (IFactory) Class.forName("cash." + className)
                    .getDeclaredConstructor(new Class[]{double.class, double.class, double.class})
                    .newInstance(new Object[]{a, b, c});
        } catch (ClassNotFoundException | InvocationTargetException | InstantiationException | IllegalAccessException |
                 NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    //通过构造方法，传入具体的收费策略
    public CashContext(int cashType) {
        String[] config = getConfig(cashType).split(",");
        IFactory fs = getInstance(
                config[0],
                Double.parseDouble(config[1]),
                Double.parseDouble(config[2]),
                Double.parseDouble(config[3])
        );
        //switch (cashType) {
        //    case 1 -> fs = new CashRebateReturnFactory(1, 0, 0);//正常收费
        //    case 2 -> fs = new CashRebateReturnFactory(0.8, 0, 0);//打8折
        //    case 3 -> fs = new CashRebateReturnFactory(0.7, 0, 0);//打7折
        //    case 4 -> fs = new CashRebateReturnFactory(1, 300, 100);//满300减100
        //    case 5 -> fs = new CashRebateReturnFactory(0.8, 300, 100);//先打八折，再满300返100
        //    case 6 -> fs = new CashReturnRebateFactory(0.7, 200, 50);//先满200返50，再打7折
        //}
        cs = fs.createSaleModel();
    }

    public double getResult(double price, int num) {
        //根据收费策略不同，获得计算结果
        return cs.acceptCash(price, num);
    }
}
