package oo.cc.patterns.creations.factories.factory.demo3;

/**
 * Created by laiis on 2018/9/19.
 */
public class VolunteerFactory implements IFactory {

    @Override
    public LeiFengStyle createLeiFeng() {
        return new Volunteer("來自工廠的學雷鋒的志願者");
    }
}
