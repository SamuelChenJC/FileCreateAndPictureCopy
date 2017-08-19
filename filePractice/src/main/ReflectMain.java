package main;

import object.ReflectBo;
import object.ReflectVo;
import object.Student;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.*;

/**
 * Created by Chenpi on 2017/8/1.
 *
 * 测试反射的主函数类
 *
 */
public class ReflectMain {
    /**
     * 反射
     * http://www.cnblogs.com/lzq198754/p/5780331.html
     * @param args
     */
    public static void main(String[] args) {

        System.out.println("正在使用："+ReflectMain.class);

        try {

            //获取类信息以及类实例化
            getClassAndInstance();
            //获取类的属性
            getFields();
            //获取类的方法
            getMethods();


            ReflectBo bo = new ReflectBo();
            bo.setName("陈金才");
            bo.setShopentityId("991810");
            bo.setSpell("cjc");
            bo.setUsername("某某人");
            bo.setUsertype((short) 1);
            System.out.println(bo.toString());

            ReflectVo vo = convertBo2Vo(new ReflectVo(), bo);
            System.out.println(vo);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void getClassAndInstance() throws Exception {
        /**
         * 1 反射机制获取类三种方法 获取一个类的类型
         * */
        // 1 类名或类 限定名 object.Student
        Class c1 = Class.forName("object.Student");
        System.out.println("c1: " + c1.getName());//输出 object.Student

        // 2 java中每个类型都有class 属性.
        Class c2 = Student.class;
        System.out.println("c2: " + c2.getName());//输出 object.Student

        // 3 java语言中任何一个java对象都有getClass 方法
        Student student = new Student();
        Class c3 = student.getClass();
        System.out.println("c3: " + c3);//输出 object.Student



        /**
         * 2 创建对象：获取类以后创建它的对象，利用newInstance
         * */
        Object o1 = c1.newInstance();////调用了无参数构造方法.
        System.out.println("newInstance 后："+o1);//输出对象地址 下同
        Object o2 = c2.newInstance();////调用了无参数构造方法.
        System.out.println("newInstance 后："+o2);
        Object o3 = c3.newInstance();////调用了无参数构造方法.
        System.out.println(o3);

    }

    public static void getFields() throws Exception {
        Class c = Student.class;
        /**
         * 3,获取属性：分为所有的属性和指定的属性
         * */
        Field[] fields1 = c.getDeclaredFields();// 获取全部属性(公有&私有)
        Field   field1   = c.getDeclaredField("birthDay");//获取指定属性 (私有也可，单仅限于该类，不包含父类)
        System.out.println(field1);//output : private java.lang.String object.Student.birthDay

        StringBuilder sb = new StringBuilder();//StringBuilder 非线程安全 但速度最快
        sb.append("类反射实验开始：");
        sb.append(Modifier.toString(c.getModifiers()));//获取类的修饰符 public private 等
        sb.append(" class ");
        sb.append(c.getSimpleName());//类名
        sb.append("{\n");
        // 循环每一个属性
        for (Field field : fields1) {
            sb.append("\t");
            sb.append(Modifier.toString(field.getModifiers()) + " ");//获得属性的修饰符，例如public，static等等
            sb.append(field.getType().getSimpleName() + " ");//属性的类型的名字 field.getType():java.lang.String,再getSimpleName 才能得到类型
            sb.append(field.getName()+";\n");//属性的名字
        }
        sb.append("}");
        System.out.println(sb);
        // 输出为：
        // 类反射实验开始：public class Student{
        //     public String name;
        //     public String id;
        //     private String sex;
        //     private String birthDay;
        // }
    }

    public static void getMethods() {
        Class c = Student.class;

        Method[] methods = c.getDeclaredMethods();//获取所有自定义方法 不包含父类的方法

        StringBuilder sb = new StringBuilder();
        sb.append(c.getName() + " 的方法：" + "\n");

        for (Method method : methods) {
            sb.append("\t");
            sb.append(Modifier.toString(method.getModifiers()) + " ");//类修饰符
            sb.append(method.getReturnType().getSimpleName() + " ");//返回值类型
            sb.append(method.getName() + " (");
            if (method.getParameterCount() > 0) {//参数个数

                Parameter[] parameters = method.getParameters();//参数类型列表
                int length = parameters.length;
                for (int i = 0; i < length; i++) {
                    sb.append(parameters[i].getType().getSimpleName());
                    if (!parameters[i].equals(parameters[length-1])) {//最后一个参数后不加逗号
                        sb.append(",");
                    }
                }
            }
            sb.append(")\n");
        }
        System.out.println(sb);
    }


    public static ReflectVo convertBo2Vo(ReflectVo vo, ReflectBo bo) {


        try {
            /**
             * 两者都是“后赋前”，功能基本相同，但PropertyUtils发现同名属性为不同类型时，会在支持的数据类型范围内进行转换 Date型不支持
             * ※ 两者都是同名属性才赋值（名字相同，大小写敏感）
             * BeanUtils比PropertyUtils速度快
             * ※ BeanUtils所花费的时间要超过取数 据、将其复制到对应的 value对象（通过手动调用get和set方法），以及通过串行化将其返回到远程的客户机的时间总和
             */

            // PropertyUtils.copyProperties(vo, bo);
            BeanUtils.copyProperties(vo, bo);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


        return vo;
    }

}
