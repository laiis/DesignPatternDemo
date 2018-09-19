package oo.cc.patterns.creations.factories.factory.demo2;

/**
 * Created by laiis on 2018/9/19.
 */
public class MinusFactory implements MathFactory {

    @Override
    public MathOperator createOperation() {
        return new MinusOperator();
    }
}
