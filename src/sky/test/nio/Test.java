package sky.test.nio;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.CharBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Buffer三个概念: 容量（capacity）界限（limit）位置（position）
 * 0<=mark<=position<=limit<=capacity
 * 
 * @author sky
 */
public class Test {
	public static void main(String[] args) {
		// 通过paths获取文件路径
		Path path = Paths.get("D:/aaa.txt");
		try (
		// path.toFile()把path转换成file
		FileChannel inChannel = new FileInputStream(path.toFile()).getChannel();
		FileChannel outChannel = new FileOutputStream("d:/bbb.txt").getChannel();) {
			//把channel里的数据放到buffer里
			MappedByteBuffer buffer = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, Files.size(path));
			//将buffer里的数据全部输出
			outChannel.write(buffer);
			//复原limit和position的指针位置
			buffer.clear();
			//字节buffer转换成字符buffer
			CharsetDecoder cd = Charset.forName("UTF-8").newDecoder();
			CharBuffer charBuffer = cd.decode(buffer);
			System.out.println(charBuffer);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}
}
