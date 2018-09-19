package oo.cc.patterns.creations.factories.factory.demo3;

/**
 * Created by laiis on 2018/9/18.
 */
public class FakeGit implements WareHouse {

    @Override
    public void save() {

    }

    @Override
    public void update() {
        System.out.println("update date by Git");
    }

}
