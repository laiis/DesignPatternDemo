package oo.cc.patterns.creations.factories.factory.demo4;

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
                return new Undergraduate();
            case LEIFENG:
                return new Volunteer();
            default:
                return null;
        }
    }
}
