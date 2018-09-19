package oo.cc.patterns.creations.factories.factory.demo3;

/**
 * Created by laiis on 2018/9/18.
 */
public class RemoteRepo implements Repo {

    @Override
    public WareHouse getWareHouse() {
        try {
            Class<?> clz = Class.forName(ConfigHelper.newInstance().getValue(AppConfig.REMOTE_WAREHOUSE));
            WareHouse wareHouse = (WareHouse) clz.newInstance();
            return wareHouse;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
