package oo.cc.patterns.creations.factories.factory.demo4;

/**
 * Created by laiis on 2018/9/18.
 */
public class LocalRepo implements Repo {

    @Override
    public WareHouse getWareHouse() {
        try {
            Class<?> clz = Class.forName(ConfigHelper.newInstance().getValue(AppConfig.LOCAL_WAREHOUSE));
            WareHouse wareHouse = (WareHouse) clz.newInstance();
            return wareHouse;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
