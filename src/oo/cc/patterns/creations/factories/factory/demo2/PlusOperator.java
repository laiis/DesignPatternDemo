package oo.cc.patterns.creations.factories.factory.demo2;

/**
 * Created by laiis on 2018/9/18.
 */
public class PlusOperator implements MathOperator<Integer> {

    @Override
    public Integer getResult(Integer m, Integer n) {
        return m.intValue() + n.intValue();
    }

    @Override
    public String getOperator() {
        return "+";
    }
}
