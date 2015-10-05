package ru.kpfu.itis;

/**
 * Created by root on 05.10.15.
 */
public class Singleton {

    private static Singleton INSTANCE;


    private Singleton() {

    }

    public static Singleton getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Singleton();
        }
        return INSTANCE;
    }


}
