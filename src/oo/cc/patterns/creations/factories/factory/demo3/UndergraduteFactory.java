package oo.cc.patterns.creations.factories.factory.demo3;

/**
 * Created by laiis on 2018/9/19.
 */
public class UndergraduteFactory implements IFactory {

    @Override
    public LeiFengStyle createLeiFeng() {
        return new Undergraduate("來自工廠的學雷鋒的大學生");
    }
}
