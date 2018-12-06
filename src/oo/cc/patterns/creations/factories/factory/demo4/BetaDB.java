package oo.cc.patterns.creations.factories.factory.demo4;

public class BetaDB implements WareHouse {

    @Override
    public void save() {

    }

    @Override
    public void update() {
        System.out.println("update data by BetaDB.");
    }
}
