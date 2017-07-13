package other;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by Chenpi on 2017/7/13.
 */
public class FileUtil {


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
