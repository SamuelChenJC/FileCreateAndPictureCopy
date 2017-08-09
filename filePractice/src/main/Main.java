package main;

import java.util.*;

/**
 * Created by Chenpi on 2017/8/4.
 *
 * 如果你不能在1小时以内解决以下5个问题，那么你首先要做的是重新审视自己。
 *
 */


public class Main {
    public static void main(String args[]) {

        System.out.println("正在使用："+Main.class);

        loopLable();
        // there:
        // System.out.println("mark2 below there");
        // for (int i = 0;i<10;i++) {
        //     if (i%8==0) continue t;
        // }

        // int[] ints1 = {1, 3, 5, 7, 9};
        // problem1(ints1);
        //
        // String[] a = {"a", "B", "C","D","e"};
        // String[] b = {"1", "2", "3"};
        // problem2(b,a);

        // problem3();

        // int[] ints4 = {7,65,8,49,76,99,2};
        // problem4_1(ints4);
        // problem4_2(ints4);
        // //
        // String aa = "22";
        // String aa2 = "224";
        // System.out.println(aa.charAt(1)<aa2.charAt(2));

    }

    /** 问题1
     * 使用for循环、while循环和递归写出3个函数来计算给定数列的总和。
     * */
    private static void problem1(int[] series) {

        if (series == null || series.length < 0) {
            return;
        }

        int length = series.length;

        int sum = 0;
        for (int i = 0;i<length;i++) {
            sum += series[i];
        }
        System.out.println("for 循环计算数列总和为："+sum);


        sum = 0;
        while (length != 0) {
            length--;
            sum += series[length];
        }
        System.out.println("while 循环计算数列总和为："+sum);

        sum = recursion(series, 0);
        System.out.println("递归 循环计算数列总和为："+sum);

    }

    private static int recursion(int[] series,int i) {
        if (series == null || series.length < 1) {
            return 0;
        }

        int length = series.length;
        if (i < length) {

            System.out.println("series[i] "+i+" : "+series[i]);

            int re = series[i] + recursion(series, i + 1);
            //递归到最后一个，才第一次走到这一步
            System.out.println("series[i] + recursion(series, i + 1) "+i+" : "+re);
            return re;
        }

        return 0;
    }


    /**
     * 问题2
     * 编写一个交错合并列表元素的函数。例如：给定的两个列表为[a，B，C]和[1，2，3]，函数返回[a，1，B，2，C，3]。
     */
    private static void problem2(String[] first, String[] last) {
        if (first.length < 1 || last.length < 1) {
            return ;
        }

        String[] result = new String[first.length+last.length];
        int j = 0;
        for (int i = 0; i < first.length; i++) {
            j = 2 * i;
            if (j > 2 * last.length) {
                j = last.length + i;
            }
            result[j] = first[i];
        }

        for (int i = 0; i < last.length; i++) {
            j = 2*i+1;
            if (j > 2 * first.length) {
                j = first.length + i;
            }
            result[j] = last[i];
        }
        System.out.println(Arrays.toString(result));
    }

    /** 问题3
     * 编写一个计算前100位斐波那契数的函数。根据定义，斐波那契序列的前两位数字是0和1，
     * 随后的每个数字是前两个数字的和。
     * 例如，前10位斐波那契数为：0，1，1，2，3，5，8，13，21，34。
     * */
    private static void problem3() {

        System.out.println("前100位斐波那契数:");

        double[] ints = new double[100];

        ints[0] = 0;
        ints[1] = 1;

        System.out.print(ints[0]+"\t"+ints[1]+"\t");
        for (int i = 2;i<100;i++) {
            ints[i] = ints[i - 1] + ints[i - 2];
            System.out.print(ints[i] + "\t");
            if ((i+1) % 3 == 0) {
                System.out.println();
            }
        }
    }

    /**
     * 问题4
     * 编写一个能将给定非负整数列表中的数字排列成最大数字的函数。
     * 例如，给定[50，2，1,9]，最大数字为95021。
     */
    private static void problem4_1(int[] ints) {

        List<String> s1 = new ArrayList<>();

        for (Integer integer : ints) {
            System.out.println(integer);
            s1.add(integer.toString());
        }
        // List<String> s2 = new LinkedList<>();

        String result = "";
        // int n = 0;//n用于设置LinkedList的索引，
        for (int i = 0; i < s1.size();) {//每次都会移除，所以不需要自增。否则会跳过某些元素
            String tem = s1.get(i);
            for (int j = i+1;j<s1.size();j++) {//j自增，以循环剩下元素
                System.out.println("开始：" + s1.get(j));
                tem = compare2(tem, s1.get(j));
            }
            System.out.println("remove:" + tem);
            s1.remove(tem);
            result += tem;

            // System.out.println("set:" + tem);
            // s2.add(n++, tem);//每加一个自增1使链表指针移向下一个位置
        }
        System.out.println(result);
        // System.out.println(s2.toString());
    }
    private static void problem4_2(int[] ints) {

        List<String> s1 = new ArrayList<>();

        for (Integer integer : ints) {
            System.out.println(integer);
            s1.add(integer.toString());
        }

        String resultStr = "";
        String temp = "";
        for (int i = 0;i<s1.size();) {
            temp = s1.get(i);
            for (int j = i+1;j<s1.size();j++) {
                temp = compare3(temp, s1.get(j));
            }
            resultStr += temp;
            s1.remove(temp);
        }
        System.out.println(resultStr);
    }
    /**
     * compare1 方法1，自己写，比较麻烦
     * @param s1
     * @param s2
     * @param index 开始的索引
     * @return
     */
    private static String compare1(String s1, String s2,int index) {

        if (s1.length() - s2.length() == 0) {
            //长度相等直接比较大小
            return Integer.valueOf(s1).compareTo(Integer.valueOf(s2)) > 0 ? s1 : s2;

        } else {
            //位数不相等，从开头数字开始比较 对比不同位数上的大小，直至分出大小
            Integer a = Integer.valueOf(s1.substring(index,index+1));
            Integer b = Integer.valueOf(s2.substring(index,index+1));
            int res = a.compareTo(b);
            switch (res) {
                case 0:
                    /**
                     * 如果已经比较到某一个数的最后一位，则返回位数短的数，如果还不到最后一位继续递归
                     * 例如：有501,50这两个数能组成的大数是50501，比50150大
                     */
                    if (index + 1 == s1.length()){
                        return s1;
                    } else if ( index + 1 == s2.length()) {
                        return s2;
                    }
                    return  compare1(s1, s2, index + 1);
                case 1:
                    return s1;
                case -1:
                    return s2;
                default:
            }
        }
        return null;//理论上不会走到这一步
    }

    private static String compare2(String s1, String s2) {
        //位数相等 直接比较数值大小
        if (s1.length() == s2.length()) {
            return Integer.valueOf(s1).compareTo(Integer.valueOf(s2)) > 0 ? s1 : s2;
        }

        int lenth = 0;//位数不相等 取位数短的个数进行比较
        String target = s1;
        if (s1.length() > s2.length()) {
            lenth = s2.length();
            target = s2;
        } else {
            lenth = s1.length();
        }
        for (int i = 0;i<lenth;i++) {
            char a = s1.charAt(i);
            char b = s2.charAt(i);
            if (a != b) {
                if (a > b) {
                    return s1;
                } else {
                    return s2;
                }
            } else if(i == lenth - 1) {//已经比较到最后一位了，返回短的那个数
                return target;
            }
        }
        return null;
    }

    private static String compare3(String s1, String s2) {
        // 因为一个元素内的数字不能拆开，字符串拼接后转成整数比较最方便
        if (Integer.valueOf(s1 + s2).compareTo(Integer.valueOf(s2 + s1)) > 0) {
            return s1;
        } else {
            return s2;
        }
    }
    /** 问题4
     * 编写一个在1，2，…，9（顺序不能变）数字之间插入+或-或什么都不插入，
     * 使得计算结果总是100的程序，并输出所有的可能性。
     * 例如：1 + 2 + 34 – 5 + 67 – 8 + 9 = 100。
     * */
    private static void problem5() {

    }


    public static void loopLable() {

        here:   //java 用于代替goto语句的“标记”功能，也可写成here:for (int i = 0;i<3;i++)，项目中会写成loop:会造成困扰，所以这里写here
        for (int i = 0;i<3;i++) {
            System.out.println("第一重：" + i);
            for (int j = 0;j<3;j++) {
                System.out.println("第二重：" + j);
                for (int n = 0;n<3;n++) {
                    if ((n+j)  == 4) {
                        System.out.println("跳出多重循环！");
                        break here;
                    }
                    System.out.println("第三重：" + n);
                    System.out.println("=========================");
                }
            }
        }
        System.out.println("多重循环之后的代码");
    }

}
