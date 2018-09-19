package oo.cc.patterns.creations.factories.factory.demo2;

/**
 * Created by laiis on 2018/9/19.
 */
public class UselessProduct implements Product {

    @Override
    public void complete() {
        System.out.println("UselessProduct");
    }
}
