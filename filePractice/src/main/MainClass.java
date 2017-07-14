package main;

import other.FileUtil;

import java.io.File;
import java.util.List;

/**
 * Created by Chenpi on 2017/7/13.
 */
public class MainClass {

    /***
     * 读取一个文件夹下所有文件，并内容拼接到一个文件里
     * https://zhidao.baidu.com/question/1368120362072340179.html
     * @param args
     */
    public static void main(String[] args) {

        File dir = new File("E:/allText");

        //查找文件
        List<File> fileList = FileUtil.findFiles(dir, false);

        File targetFile = new File("E:/allText/resultFile/人民的名义(全54章).txt");
        if (FileUtil.createFile(targetFile.getPath())) {
            System.out.println("成功生成目标文件：" + targetFile.getPath());
        }

        long startTime = System.currentTimeMillis();
        for (File file : fileList) {
            String content = FileUtil.readFile(file);

            FileUtil.writeFile(targetFile,content);
            System.out.println("处理完成："+file.getPath());
        }
        System.out.println("处理文件(个) " + fileList.size() + "，共用时 " + (System.currentTimeMillis() - startTime));
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
