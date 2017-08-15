package mode.decoratorMode;

/**
 * Created by Chenpi on 2017/8/14.
 *
 * 等于装饰模式的：Decorator
 */
public class Finery extends Person {
    private Person component;

    public void decorate(Person component) {
        this.component = component;
    }

    public void show() {
        if (null != component) {
            component.show();
        }
    }
}
