package code._2单例模式;

public class Singleton1 {

    private static class SingletonHoler {
        private static final Singleton1 INSTANCE = new Singleton1();
    }

    public static Singleton1 getInstance(){
        return SingletonHoler.INSTANCE;
    }
}
