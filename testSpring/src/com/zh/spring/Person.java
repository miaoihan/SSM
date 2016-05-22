package com.zh.spring;


/**
 * @author han
 * @date 16-5-22.
 */
public class Person {
    private HelloWorld helloWorld ;

//    /**  spring 通过构造器的方式实现注入   */
//    public Person(HelloWorld helloWorld) {
//        this.helloWorld = helloWorld;
//    }

    public void sayHello(){
        this.helloWorld.sayHello();
    }

    /**  通过setter方法实现注入  */
    public HelloWorld getHelloWorld() {
        return helloWorld;
    }

    public void setHelloWorld(HelloWorld helloWorld) {
        this.helloWorld = helloWorld;
    }

}
