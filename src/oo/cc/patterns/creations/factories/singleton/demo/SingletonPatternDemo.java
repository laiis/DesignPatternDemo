package oo.cc.patterns.creations.factories.singleton.demo;

import java.lang.reflect.Method;

public class SingletonPatternDemo {

    public static void main(String[] args) {
        LazySingleton.getInstance().show();
        SynchronizedLazySingleton.getInstance().show();
        HungrySingleton.getInstance().show();
        AnotherHungrySingleton.getInstance().show();
        InnerClassSingleton.getInstance().show();
        EnumSingleton.SINGLETON.show();
        DoubleCheckSynchronizedSingleton.getInstance().show();

        changeClassLoader();

    }

    private static void changeClassLoader() {
        try {

            ClassLoader nowClassloader = SingletonPatternDemo.class.getClassLoader();
            System.out.println("current classloader ---> " + nowClassloader.getClass().getName() + "\n");

            CClassLoader cClassloader = new CClassLoader();
            DClassLoader dClassLoader = new DClassLoader();

            Class<?> cClz = cClassloader.loadClass("oo.cc.patterns.creations.factories.singleton.demo.SingletonPatternDemo$HungrySingleton");
            Class<?> dClz = dClassLoader.loadClass("oo.cc.patterns.creations.factories.singleton.demo.SingletonPatternDemo$HungrySingleton");

            System.out.println(cClz.getClassLoader().getClass().getName());
            Method cMethod = cClz.getMethod("getInstance", null);
            Object objC = cMethod.invoke(null, null);
            System.out.println("load by CClassLoader ---> " + objC.toString());

            System.out.println(dClz.getClassLoader().getClass().getName());
            Method dMethod = dClz.getMethod("getInstance", null);
            Object objD = dMethod.invoke(null, null);
            System.out.println("load by DClassLoader --->" + objD.toString());

            Class<?> reAClz = findClass(cClz.getName(), HungrySingleton.class.getClassLoader());
            Method reMethod = reAClz.getMethod("getInstance", null);
            Object objreA = reMethod.invoke(null, null);
            System.out.println("load by current classloader --->" + objreA.toString());
            System.out.println("load by current classloader --->" + HungrySingleton.getInstance().toString());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static Class findClass(String classname, ClassLoader clzLoader) throws ClassNotFoundException {
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        System.out.println("current getClassloader: " + classLoader.getClass().getName());

        if (classLoader == null) {
            classLoader = clzLoader;
        }

        return (classLoader.loadClass(classname));
    }

    /**
     * lazy singleton, not trhead-safe
     */
    public static class LazySingleton {

        private static LazySingleton sLazySingleton;

        static {
            System.out.println("Loading class 'LazySingleton' , sLazySingleton is null? " + (sLazySingleton == null));
        }


        private LazySingleton() {
            System.out.println("execute LazySingleton's constructor");
        }

        public static LazySingleton getInstance() {
            if (sLazySingleton == null) {
                System.out.println("execute getInstance() ");
                sLazySingleton = new LazySingleton();
            }

            return sLazySingleton;
        }

        public void show() {
            System.out.println(getClass().getSimpleName());
        }
    }

    /**
     * lazy singleton, thread-safe
     */
    public static class SynchronizedLazySingleton {

        private static SynchronizedLazySingleton sSynchronizedLazySingleton;

        static {
            System.out.println("Loading class 'SynchronizedLazySingleton'");
        }

        private SynchronizedLazySingleton() {
            System.out.println("execute SynchronizedLazySingleton's constructor");
        }

        public static synchronized SynchronizedLazySingleton getInstance() {
            System.out.println("execute getInstance");
            if (sSynchronizedLazySingleton == null) {
                sSynchronizedLazySingleton = new SynchronizedLazySingleton();
            }

            return sSynchronizedLazySingleton;
        }

        public void show() {
            System.out.println(getClass().getSimpleName());
        }
    }

    /**
     * hungry singleton, thread-safe by classloader
     */
    public static class HungrySingleton {

        private static HungrySingleton sHungrySingleton = new HungrySingleton();

        static {
            System.out.println("Loading class 'HungrySingleton' , sHungrySingleton is null? " + (sHungrySingleton == null));
        }

        private HungrySingleton() {
            System.out.println("execute HungrySingleton's constructor");
        }


        public static HungrySingleton getInstance() {
            System.out.println("execute getInstance()");
            return sHungrySingleton;
        }

        public void show() {
            System.out.println(getClass().getSimpleName());
        }
    }

    /**
     * another hungry singleton, initial at static section
     */
    public static class AnotherHungrySingleton {

        private static AnotherHungrySingleton sAnotherHungrySingleton;

        static {
            System.out.println("--- start inital ---");
            sAnotherHungrySingleton = new AnotherHungrySingleton();
            System.out.println("--- inital completed ----");
        }

        private AnotherHungrySingleton() {
            System.out.println("new AnotherHungrySingleton");
        }

        public static AnotherHungrySingleton getInstance() {
            System.out.println("execute getInstance()");
            return sAnotherHungrySingleton;
        }

        public void show() {
            System.out.println(getClass().getSimpleName());
        }
    }

    /**
     * inner-static-class singleton
     */
    public static class InnerClassSingleton {

        static {
            System.out.println("Loading class 'InnerClassSingleton'");
        }

        private static class InnerSingleton {
            private static final InnerClassSingleton sInnerClassSingleton;

            static {
                System.out.println("Loading class 'InnerSingleton'");
                sInnerClassSingleton = new InnerClassSingleton();
            }
        }

        private InnerClassSingleton() {
            System.out.println("execute InnerClassSingleton's constructor");
        }

        public static InnerClassSingleton getInstance() {
            System.out.println("execute getInstance");
            return InnerSingleton.sInnerClassSingleton;
        }

        public void show() {
            System.out.println(getClass().getSimpleName());
        }
    }

    /**
     * enum, It's singleton too.
     */
    public enum EnumSingleton {
        SINGLETON;

        static {
            System.out.println("Loading class 'EnumSingleton' , SINGLETON is null? " + (SINGLETON == null));
        }

        public void show() {
            System.out.println(SINGLETON.name());
        }

    }

    /**
     * double-check synchronized singleton
     */
    public static class DoubleCheckSynchronizedSingleton {

        private static DoubleCheckSynchronizedSingleton sSingleton;

        static {
            System.out.println("Loading class 'DoubleCheckSynchronizedSingleton' , sSingleton is null? " + (sSingleton == null));
        }

        private DoubleCheckSynchronizedSingleton() {
            System.out.println("execute DoubleCheckSynchronizedSingleton's constructor");
        }

        public static DoubleCheckSynchronizedSingleton getInstance() {
            System.out.println("execute getInstance");
            if (sSingleton == null) {
                synchronized (DoubleCheckSynchronizedSingleton.class) {
                    if (sSingleton == null) {
                        sSingleton = new DoubleCheckSynchronizedSingleton();
                    }
                }
            }

            return sSingleton;
        }

        public void show() {
            System.out.println(getClass().getSimpleName());
        }
    }

}
