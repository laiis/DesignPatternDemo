package oo.cc.patterns.creations.factories.factory.demo1;

/**
 * Created by laiis on 2018/9/18.
 */
public interface MathOperator<T> {

    T getResult(T m, T n);

    String getOperator();
}
