package com.huang;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.Singleton;


@Singleton //@Service
public class Sample {
    @Inject //@Autowire
    private Printer printer;

    public void say() {
        printer.printer();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector();
        Sample sample = injector.getInstance(Sample.class);
        sample.say();
    }

}

@Singleton
class Printer {
    public void printer() {
        System.out.println("hello");
    }
}
