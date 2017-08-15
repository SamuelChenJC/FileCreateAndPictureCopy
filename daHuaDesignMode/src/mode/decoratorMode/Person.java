package mode.decoratorMode;

/**
 * Created by Chenpi on 2017/8/14.
 *
 * 等于装饰模式的 ConcreteComponent
 */
public class Person {
    private String name;
    public Person() {

    }

    public Person(String name) {
        this.name = name;
    }

    public void show() {
        System.out.println("装扮的 "+name);
    }
}
