package code._2单例模式;

public class Singleton {

    private static volatile Singleton instance = null;


    /**
     * 懒汉式，线程不安全
     * @return
     */
    private static Singleton getInstance1(){
        if (null == instance){
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 懒汉式，线程安全
     * @return
     */
    private static synchronized Singleton getInstance2(){
        if (null == instance){
            instance = new Singleton();
        }
        return instance;
    }

    /**
     * 双重检查锁
     * @return
     */
    private static Singleton getInstance3(){
        if (instance == null){
            synchronized (Singleton.class){
                if (instance == null){
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
}
