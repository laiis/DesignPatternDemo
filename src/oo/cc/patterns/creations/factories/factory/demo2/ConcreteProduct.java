package oo.cc.patterns.creations.factories.factory.demo2;

/**
 * Created by laiis on 2018/9/18.
 */
public class ConcreteProduct implements Product {

    @Override
    public void complete() {
        System.out.println("ConcreteProduct! Nice to meet you!");
    }
}
