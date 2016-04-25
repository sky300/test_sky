package sky.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

public class TestZipInputStream {

    /**
     * 解压ZIP文件
     */
    public static void readZipFile() throws Exception {
        File readF = new File("c://test.zip");
        File writeF = null;
        ZipFile zipFile = new ZipFile(readF);

        OutputStream out = null; // 定义输出流，用于输出每一个实体内容
        InputStream input = null; // 定义输入流，读取每一个ZipEntry
        // 读入zip文件
        ZipInputStream zis = new ZipInputStream(new FileInputStream(readF));
        ZipEntry entry;
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println("解压缩的文件名为：" + entry.getName());
            writeF = new File("c:" + File.separator + entry.getName());
            input = zipFile.getInputStream(entry);
            out = new FileOutputStream(writeF); // 实例化文件输出流
            int temp = 0;
            while ((temp = input.read()) != -1) {
                out.write(temp);
            }
            input.close(); // 关闭输入流
            out.close(); // 关闭输出流
        }
        input.close();
    }

    /**
     * 生成ZIP文件
     */
    public static void writeZipFile() throws Exception {
        File readF = new File("c://123");// 要压缩的文件
        File zipFile = new File("c://write.zip");// 生成的压缩文件
        InputStream input = null;// 定义输入流
        ZipOutputStream zos = null;// 输出zip文件流
        zos = new ZipOutputStream(new FileOutputStream(zipFile));
        // zos.setComment("sky的压缩文件"); // 设置注释
        int temp = 0;
        if (readF.isDirectory()) {// 判断是否为文件夹
            File list[] = readF.listFiles();// 列出文件夹下所有文件
            for (File file : list) {
                input = new FileInputStream(file);
                // 设置zip文件的每个实体名字
                zos.putNextEntry(new ZipEntry(readF.getName() + File.separator + file.getName()));
                while ((temp = input.read()) != -1) {
                    zos.write(temp);
                }
                input.close();
            }
        }
        zos.close();
    }

    public static void main(String[] args) {
        try {
            // readZipFile();
            writeZipFile();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
