package oo.cc.patterns.creations.factories.factory.demo2;

/**
 * Created by laiis on 2018/9/18.
 */
public class PlusFactory implements MathFactory {

    @Override
    public MathOperator<Integer> createOperation() {
        return new PlusOperator();
    }
}
