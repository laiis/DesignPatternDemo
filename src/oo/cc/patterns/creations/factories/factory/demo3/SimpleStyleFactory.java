package oo.cc.patterns.creations.factories.factory.demo3;

/**
 * Created by laiis on 2018/9/19.
 */
public class SimpleStyleFactory {

    public enum StypeType {
        UNDERGRADUTE,
        LEIFENG
    }

    public static LeiFengStyle createLeiFengStyle(StypeType styleType) {

        switch (styleType) {
            case UNDERGRADUTE:
                return new Undergraduate("學雷鋒的大學生");
            case LEIFENG:
                return new Volunteer("學雷鋒的志願者");
            default:
                return null;
        }
    }
}
