package oo.cc.patterns.creations.factories.factory.demo4;

/**
 * Created by laiis on 2018/9/19.
 */
public class Volunteer implements LeiFengStyle {

    @Override
    public void sweep() {
        System.out.println("掃地");
    }

    @Override
    public void wash() {
        System.out.println("洗衣");
    }

    @Override
    public void buyRice() {
        System.out.println("買米");
    }
}
