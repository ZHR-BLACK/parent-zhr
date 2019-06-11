package structural_model.proxy.impl;

import structural_model.proxy.HelloWorld;

public class HelloWorldImpl implements HelloWorld {

    @Override
    public void sayHelloWorld() {
        System.out.println("Hello World!!!");
    }

    @Override
    public void sayHelloWorld(String name) {
        System.out.println("Hello World!!!" + name);
    }

}
