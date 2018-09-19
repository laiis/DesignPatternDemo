package oo.cc.patterns.creations.factories.factory.demo1;

/**
 * Created by laiis on 2018/9/19.
 */
public class OperationFactory {

    public static MathOperator<Integer> createOperate(String type) {
        switch (type) {
            case "+":
                return new PlusOperator();
            case "-":
                return new MinusOperator();
            default:
                return null;
        }

    }
}
