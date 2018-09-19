package oo.cc.patterns.creations.factories.factory;

import oo.cc.patterns.creations.factories.factory.demo1.ConcreteCreator;
import oo.cc.patterns.creations.factories.factory.demo1.Creator;
import oo.cc.patterns.creations.factories.factory.demo1.Product;
import oo.cc.patterns.creations.factories.factory.demo2.*;
import oo.cc.patterns.creations.factories.factory.demo3.AppConfig;
import oo.cc.patterns.creations.factories.factory.demo3.ConfigHelper;
import oo.cc.patterns.creations.factories.factory.demo3.Repo;
import oo.cc.patterns.creations.factories.factory.demo3.WareHouse;

/**
 * Created by laiis on 2018/9/18.
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        // DEMO 1
        Creator creator = new ConcreteCreator();
        Product product = creator.makeProduct();
        product.complete();

        // DEMO 2
        operating(5, 10, PlusFactory.class.getName());
        operating(5, 10, MinusFactory.class.getName());

        // DMOE 3
        ConfigHelper.initial(AppConfig.CONFIG_PROPERTIES);
        Repo repo = getRepoByAppConfig(AppConfig.REPO_TYPE);
        WareHouse wareHouse = repo.getWareHouse();
        wareHouse.update();

        repo = getRepoByAppConfig(AppConfig.LOCAL_REPO);
        wareHouse = repo.getWareHouse();
        wareHouse.update();

        repo = getRepoByAppConfig(AppConfig.REMOTE_REPO);
        wareHouse = repo.getWareHouse();
        wareHouse.update();

    }


    private static void operating(int m, int n, String operation) {
        try {
            Class<?> cls = Class.forName(operation);
            MathFactory mathFactory = (MathFactory) cls.newInstance();
            MathOperator mathOperator = mathFactory.createOperation();
            System.out.format("%d %s %d = %d\n", m, mathOperator.getOperator(), n, mathOperator.getResult(m, n));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Repo getRepoByAppConfig(String repoType) {
        try {
            Class<?> clz = Class.forName(ConfigHelper.newInstance().getValue(repoType));
            Repo repo = (Repo) clz.newInstance();
            return repo;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
