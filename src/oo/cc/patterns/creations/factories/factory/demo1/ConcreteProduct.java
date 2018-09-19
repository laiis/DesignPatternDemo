package oo.cc.patterns.creations.factories.factory.demo1;

/**
 * Created by laiis on 2018/9/18.
 */
public class ConcreteProduct implements Product {

    @Override
    public void complete() {
        System.out.println("Nice to meet you!");
    }
}
