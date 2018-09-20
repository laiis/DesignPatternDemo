package oo.cc.patterns.creations.factories.factory;

import oo.cc.patterns.creations.factories.factory.demo2.*;
import oo.cc.patterns.creations.factories.factory.demo1.*;
import oo.cc.patterns.creations.factories.factory.demo1.OperationFactory;
import oo.cc.patterns.creations.factories.factory.demo3.*;
import oo.cc.patterns.creations.factories.factory.demo4.*;

/**
 * Created by laiis on 2018/9/18.
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        // DEMO 1
        MathOperator<Integer> plus = OperationFactory.createOperate("+");
        showOperation(5, 10, plus);
        MathOperator<Integer> minus = OperationFactory.createOperate("-");
        showOperation(5, 10, minus);

        System.out.println("~~~~~~~~");

        operating(5, 10, new PlusFactory());
        operating(5, 10, new MinusFactory());

        System.out.println("~~~~~~~~");

        operating(5, 10, PlusFactory.class.getName());
        operating(5, 10, MinusFactory.class.getName());

        // DEMO 2
        BadProduct badProduct = new BadProduct();
        badProduct.complete();

        Product uselessProduct = new UselessProduct();
        uselessProduct.complete();

        Creator creator = new ConcreteCreator();
        Product product = creator.makeProduct();
        product.complete();

        // DEMO 3
        LeiFengStyle one = new Undergraduate("學雷鋒的大學生one");
        LeiFengStyle two = new Undergraduate("學雷鋒的大學生two");
        LeiFengStyle three = new Undergraduate("學雷鋒的大學生three");

        one.buyRice();
        two.sweep();
        three.wash();

        LeiFengStyle leiFengStyle = null;

        IFactory undergraduteFactory = new UndergraduteFactory();
        leiFengStyle = undergraduteFactory.createLeiFeng();
        leiFengStyle.buyRice();
        leiFengStyle.sweep();
        leiFengStyle.wash();

        IFactory volunteerFactory = new VolunteerFactory();
        leiFengStyle = volunteerFactory.createLeiFeng();
        leiFengStyle.buyRice();
        leiFengStyle.sweep();
        leiFengStyle.wash();

        // DEMO 4
        /*
         * 需求：
         * 1. app 更新資料
         * 2. 資料需要做儲存處理
         * 3. 資料可以放在遠端或是本地端
         * 4. 儲存方式可以是寫入檔案/DB/Git/etc...,
         */
        ConfigHelper.initial(AppConfig.CONFIG_PROPERTIES);

        // type 1
        Repo repo = getRepoByAppConfig(AppConfig.REPO_TYPE);
        WareHouse wareHouse = repo.getWareHouse();
        wareHouse.update();

        // type 2
        Repo localRepo = getRepoByAppConfig(AppConfig.LOCAL_REPO);
        wareHouse = localRepo.getWareHouse();
        wareHouse.update();

        Repo remoteRepo = getRepoByAppConfig(AppConfig.REMOTE_REPO);
        wareHouse = remoteRepo.getWareHouse();
        wareHouse.update();

        // type 3
        /*
         * 延伸需求:
         * 1. 儲存處要做例行性維護作業
         * 2. 例行性維護作業有 SOP 流程
         */
        UnionRepo unionRepo = getRepoByAppConfig(AppConfig.UNION_REPO);
        unionRepo.save();
        unionRepo.update();
        unionRepo.maintance();

    }

    private static void showOperation(int m, int n, MathOperator mathOperator) {
        System.out.format("%d %s %d = %d\n", m, mathOperator.getOperator(), n, mathOperator.getResult(m, n));
    }

    private static void operating(int m, int n, MathFactory mathFactory) {
        showOperation(m, n, mathFactory.createOperation());
    }

    private static void operating(int m, int n, String operation) {
        try {
            Class<?> cls = Class.forName(operation);
            MathFactory mathFactory = (MathFactory) cls.newInstance();
            MathOperator mathOperator = mathFactory.createOperation();
            showOperation(m, n, mathOperator);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static <T extends Repo> T getRepoByAppConfig(String repoType) {
        try {
            Class<?> clz = Class.forName(ConfigHelper.newInstance().getValue(repoType));
            T repo = (T) clz.newInstance();
            return repo;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }


}
