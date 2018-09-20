package oo.cc.patterns.creations.factories.factory.demo4;

/**
 * Created by laiis on 2018/9/20.
 */
public abstract class UnionRepo implements Repo, DataAction {

    @Override
    public void save() {

    }

    @Override
    public void update() {
        WareHouse wareHouse = getWareHouse();
        wareHouse.update();
    }

    public final void maintance() {
        System.out.println("maintain start");
        System.out.println("ba ba la ba ba~ ");
        update();
        System.out.println("maintain end");
    }

}
