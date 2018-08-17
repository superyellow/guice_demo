package com.huang;

import com.google.inject.*;

@Singleton
public class Sample3 {
    @Inject
    private IPrinter3 printer3;

    public void say() {
        printer3.print();
    }

    public void speak() {
        System.out.println("1");
    }

    public static void main(String[] args) {
        Injector injector3 = Guice.createInjector();
        Sample3 sample3 = injector3.getInstance(Sample3.class);
        sample3.say();
    }
}

@ImplementedBy(HelloPrinter3.class)
interface IPrinter3 {
    void print();
}

@Singleton
class HelloPrinter3 implements IPrinter3 {
    @Inject
    private Sample3 sample3;

    public HelloPrinter3() {
        System.out.println("HelloPrinter building");
    }

    @Override
    public void print() {
        sample3.speak();
    }
}

@Singleton
class HeyPrinter3 implements IPrinter3 {
    public HeyPrinter3() {
        System.out.println("HeyPrinter building");
    }

    @Override
    public void print() {
        System.out.println("hey");
    }
}
