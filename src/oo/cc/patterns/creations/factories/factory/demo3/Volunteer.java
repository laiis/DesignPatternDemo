package oo.cc.patterns.creations.factories.factory.demo3;

/**
 * Created by laiis on 2018/9/19.
 */
public class Volunteer implements LeiFengStyle {

    private String name = "";

    public Volunteer(String name) {
        this.name = name;
    }

    @Override
    public void sweep() {
        System.out.println(name + "掃地");
    }

    @Override
    public void wash() {
        System.out.println(name + "洗衣");
    }

    @Override
    public void buyRice() {
        System.out.println(name + "買米");
    }
}
