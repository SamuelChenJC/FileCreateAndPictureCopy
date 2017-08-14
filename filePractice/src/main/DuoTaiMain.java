package main;

/**
 * Created by Chenpi on 2017/8/14.
 *
 * 多态理解：http://www.cnblogs.com/chenssy/p/3372798.html
 *
 */
public class DuoTaiMain {

    public static void main(String[] args){

        A a1 = new A();
        A a2 = new B();
        B b = new B();
        C c = new C();
        D d = new D();

        /**
         * 当超类对象引用变量(A a2)引用子类对象(new B())时，被引用对象(B)的类型而不是引用变量(A)的类型决定了调用谁的成员方法，注意第4条(类头的连接有解释)
         * 但是这个被调用的方法必须是在超类中定义过的，也就是说被子类覆盖的方法
         */
        // output:A and A
        System.out.println("1:"+a1.show(b));   // ①在A中没有含有B类参数的方法，但是含有A类参数的方法，根据子类对象父类可用的原则，所以调用方法
        // output:A and A
        System.out.println("2:"+a1.show(c));   //②C类是B类的子类，而B类又是A类的子类，所以C类对象可以当制作A类对象使用
        // output:A and D
        System.out.println("3:"+a1.show(d));   //③A中有D做参数的方法，所以根据参数类型直接调用A中的方法
        // output:B and A
        System.out.println("4:"+a2.show(b));   //④a2本来是一个B对象，但是将其赋给了A类变量，所以a2只保留了与父类A同名的属性和方法，a2.show(b)调用B类中的保留的与父类同名同参方法
        // output:B and A
        System.out.println("5:"+a2.show(c));   //⑤a2本来是类B的一个对象，但是又将值赋给了类A，C是B的子类，B是A的子类，因此a2保留了类B中与A同名的属性和方法
        // output:A and D
        System.out.println("6:"+a2.show(d));   //⑥调用的是A类中的D为参数的方法
        // output:B and B
        System.out.println("7:"+b.show(b));    //⑦调用B类中的方法
        // output:B and B
        System.out.println("8:"+b.show(c));    //⑧B类中没有C类参数的方法，但是有B类参数的方法,B又是C的父类
        // output:A and D
        System.out.println("9:"+b.show(d));    //⑨同8
    }
}


class A {
    public String show(D obj) {
        return ("A and D");
    }
    public String show(A obj) {
        return ("A and A");
    }
}
class B extends A {
    public String show(B obj) {
        return ("B and B");
    }
    public String show(A obj) {
        return ("B and A");
    }
}
class C extends B {
}
class D extends B {
}