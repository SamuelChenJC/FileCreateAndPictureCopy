package main;

import other.FileUtil;


/**
 * Created by Chenpi on 2017/7/13.
 */
public class MainClass {

    public static void main(String[] args) {

        System.out.println("正在使用："+MainClass.class);

        //    空白
    }

    /**
     * 用IO进行一个图片复制
     * http://blog.csdn.net/u011401496/article/details/38875349
     * @param args
     */
//    public static void main(String[] args) {
//
//        String old = "D:/old_pic/pic.png";
//        String newP = "D:/new_pic/pic_new.png";
//        FileUtil.copyPic(old,newP);//方法用了static修饰，可以类名打点调用
//    }


    /**
     * 博客的写法(文件创建)
     */
//    public static void main(String[] args) {
//
//        //创建目录
//        String dirName = "D:/work/temp/temp0/temp1";
//        FileUtil.createDir(dirName);
//        //创建文件
//        String fileName = dirName + "/temp2/tempFile.txt";
//        FileUtil.createFile(fileName);
//        //创建临时文件
//        String prefix = "temp";
//        String suffix = ".txt";
//        for (int i = 0; i < 10; i++) {
//            System.out.println("创建了临时文件："
//                    + FileUtil.createTempFile(prefix, suffix, dirName));
//        }
//        //在默认目录下创建临时文件
//        for (int i = 0; i < 10; i++) {
//            System.out.println("在默认目录下创建了临时文件："
//                    + FileUtil.createTempFile(prefix, suffix, null));
//        }
//    }
}
