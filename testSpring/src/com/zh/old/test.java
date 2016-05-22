package com.zh.old;

/**
 * @author han
 * @date 16-5-22.
 */
public class test {
    public static void main(String[] args) {
        /**  传统的方法调用必须要new新的对象
         *   在spring中 这些方法调用就交给IoC容器了
         *   通过配置文件来配对
         **/
        HellowWorld hw = new HelloChina();
        HellowWorld hw2 = new HelloEng();

        hw.sayHello();
        hw2.sayHello();
    }
}
