package other;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chenpi on 2017/7/13.
 */
public class FileUtil {


    /**
     * 查询一个目录下的文件
     * @param dirFile       文件目录
     * @param isNeedSonFolder   是否需要子文件夹的文件
     */
    public static List<File> findFiles(File dirFile, boolean isNeedSonFolder) {

        File[] files = dirFile.listFiles();

        List<File> fileList = new ArrayList<>();

        if (files != null) {
            for (File file : files) {
                if (file.isFile()) {
                    fileList.add(file);
                    System.out.println("路径：" + file.getParent() + " 文件名：" + file.getName());
                } else {
                    if (isNeedSonFolder) {
                        List<File> sonList = findFiles(file, false);
                        fileList.addAll(sonList);
                    }
                }
            }
        }
        return fileList;
    }


    /**
     * 读出文件里的文本
     * @param file
     * @return
     */
    public static String readFile(File file) {

        String content = null;

        try {
//            FileReader fileReader = new FileReader(file);     //直接用这两行注释的 会中文乱码
//            BufferedReader bufferedReader = new BufferedReader(fileReader);//用这个是因为可以readLine()一行行读。不用也可以

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file),"GB2312"));

            StringBuffer stringBuffer = new StringBuffer();

            while (bufferedReader.ready()) {
                stringBuffer.append("\t");
                stringBuffer.append(bufferedReader.readLine());
                stringBuffer.append("\n"); //append 会在紧靠末尾拼接，丢失文本的换行等格式,所以每读一行就换行
//                System.out.println("读取一行："+bufferedReader.readLine());
            }
//            System.out.println("拼接的文本："+stringBuffer);
//            System.out.println(stringBuffer.toString());

            content =  stringBuffer.toString();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("fileReader出错：" + file);
        }



        return content;
    }

    /**
     * 向文件中写入文本
     * @param targetFile    要写入的目标文件
     * @param content       写入的内容
     */
    public static void writeFile(File targetFile, String content) {

        try {
//            FileWriter fileWriter = new FileWriter(targetFile);

            /**此处FileOutputStream 加true是在原文件末尾追加文本，不加则原文件内容被覆盖    */
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(targetFile,true),"utf-8"));

            bufferedWriter.write(content);
            bufferedWriter.flush();
            bufferedWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("写文件出错：");
        }

        System.out.println("写入成功！");
    }




    /**
     * 复制图片
     * @param oldDir
     * @param newDir
     */
    public static void copyPic(String oldDir, String newDir) {
        File old = new File(oldDir);
        File newFile = new File(newDir);
        try {

            if (!newFile.exists()) {
                System.out.println("not exist");
                if (!newFile.getParentFile().exists()) {
                    if (newFile.getParentFile().exists()) {
                        System.out.println("dir is maked");
                    }
                }
                //// TODO: 2017/7/12 jige
                if (newFile.createNewFile()) {
                    System.out.println("file was created!");
                }
                streamWorking(old, newFile);
            } else {
                String path = newFile.getPath();

                System.out.println("file is exists,filename:"+path);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }



    }
    public static void streamWorking (File old,File newFile){

        //创建字节  图片只有使用字节流的形式来进行拷贝
        byte data[] = new byte[1024];//1024字节则是1K
        int n = 0;
        int k = 0;

        FileInputStream fint = null;
        FileOutputStream fout = null;
        try {

            fint = new FileInputStream(old);

            fout = new FileOutputStream(newFile);

            while ((n = fint.read(data)) != -1) {
                fout.write(data, 0, n);

//                System.out.println(++k);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                if (fint != null) {
                    fint.close();
                }
                if (fout != null) {
                    fout.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        System.out.println("finish");
    }


    /**
     * 创建文件
     * @param destFileName  文件名
     * @return
     */
    public static boolean createFile(String destFileName) {

        File file = new File(destFileName);//根据路径和文件名 创建文件
        if(file.exists()) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件已存在！");
//            file.delete();
            return false;
        }
        if (destFileName.endsWith(File.separator)) {
            System.out.println("创建单个文件" + destFileName + "失败，目标文件不能为目录！");
            return false;
        }
        //判断目标文件所在的目录是否存在
        /**getParentFile返回文件型的路径能用exists()判断路径是否存在，getParent 返回的是路径字符串没有exists()*/
        if(!file.getParentFile().exists()) {

            //如果目标文件所在的目录不存在，则创建父目录
            System.out.println("目标文件所在目录不存在，准备创建它！");

            /**
             mkdir()
             只能在已经存在的目录中创建创建文件夹。
             mkdirs()
             可以在不存在的目录中创建文件夹。
             */
            if(!file.getParentFile().mkdirs()) {
                System.out.println("创建目标文件所在目录失败！");
                return false;
            }
        }
        //创建目标文件
        try {
            if (file.createNewFile()) {
                System.out.println("创建单个文件" + destFileName + "成功！");
                return true;
            } else {
                System.out.println("创建单个文件" + destFileName + "失败！");
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("创建单个文件" + destFileName + "失败！" + e.getMessage());
            return false;
        }
    }


    /**
     *  创建文件目录
     * @param destDirName 目录路径字符串
     * @return
     */
    public static boolean createDir(String destDirName) {
        File dir = new File(destDirName);
        if (dir.exists()) {
            System.out.println("创建目录" + destDirName + "失败，目标目录已经存在");
            return false;
        }
        if (!destDirName.endsWith(File.separator)) {
            destDirName = destDirName + File.separator;
        }
        //创建目录
        if (dir.mkdirs()) {
            System.out.println("创建目录" + destDirName + "成功！");
            return true;
        } else {
            System.out.println("创建目录" + destDirName + "失败！");
            return false;
        }
    }

    public static String createTempFile(String prefix, String suffix, String dirName) {
        File tempFile = null;
        if (dirName == null) {
            try{
                //在默认文件夹下创建临时文件
                tempFile = File.createTempFile(prefix, suffix);
                //返回临时文件的路径
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建临时文件失败！" + e.getMessage());
                return null;
            }
        } else {
            File dir = new File(dirName);
            //如果临时文件所在目录不存在，首先创建
            if (!dir.exists()) {
                if (!FileUtil.createDir(dirName)) {
                    System.out.println("创建临时文件失败，不能创建临时文件所在的目录！");
                    return null;
                }
            }
            try {
                //在指定目录下创建临时文件
                tempFile = File.createTempFile(prefix, suffix, dir);
                return tempFile.getCanonicalPath();
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("创建临时文件失败！" + e.getMessage());
                return null;
            }
        }
    }
}
