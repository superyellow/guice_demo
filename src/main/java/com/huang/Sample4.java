package com.huang;

import com.google.inject.*;

@Singleton
public class Sample4 {
    @Inject
    private IPrinter4 printer4;

    public void say() {
        printer4.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new Sample4Moudle());
        Sample4 sample4 = injector.getInstance(Sample4.class);
        sample4.say();
    }
}

class Sample4Moudle extends AbstractModule {

    @Override
    protected void configure() {
        bind(IPrinter4.class).to(HeyPrinter4.class);
    }
}

interface IPrinter4 {
    void print();
}

@Singleton
class HelloPrinter4 implements IPrinter4 {

    @Override
    public void print() {
        System.out.println("hello4");
    }
}

class HeyPrinter4 implements IPrinter4 {

    @Override
    public void print() {
        System.out.println("hey4");
    }
}
