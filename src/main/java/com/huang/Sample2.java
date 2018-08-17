package com.huang;


import com.google.inject.*;

@Singleton
public class Sample2 {
    @Inject
    private IPrinter printer;

    public void say() {
        printer.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Sample2 sample2 = injector.getInstance(Sample2.class);
        sample2.say();
        injector.getInstance(HeyPrinter.class);
    }
}

@ImplementedBy(HelloPrinter.class)
interface IPrinter {
    void print();
}

@Singleton
class HelloPrinter implements IPrinter {
//    public HelloPrinter() {
//        System.out.println("HelloPrinter building");
//    }

    @Override
    public void print() {
        System.out.println("hello");
    }
}

@Singleton
class HeyPrinter implements IPrinter {
//    public HeyPrinter() {
//        System.out.println("HeyPrinter building");
//    }

    @Override
    public void print() {
        System.out.println("hey");
    }
}