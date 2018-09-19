package oo.cc.patterns.creations.factories.factory.demo1;

/**
 * Created by laiis on 2018/9/18.
 */
public class ConcreteCreator implements Creator {

    @Override
    public Product makeProduct() {
        return new ConcreteProduct();
    }
}
