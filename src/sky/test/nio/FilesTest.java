package sky.test.nio;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.FileStore;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * files工具类测试
 * @author sky
 *
 */
public class FilesTest {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		//复制文件
		Files.copy(Paths.get("d:/MyEclipse2015Stable2.0补丁+注册机+步骤.rar"), new FileOutputStream("d:/aaa.rar"));
		List<String> list = new ArrayList<String>();
		list.add("枯藤老树昏鸦");
		list.add("小桥流水人家");
		//把文字按指定字符集存储
		Files.write(Paths.get("d:/write.txt"), list,Charset.forName("UTF-8"));
		//读取文件
		List<String> read = Files.readAllLines(Paths.get("d:/write.txt"), Charset.forName("UTF-8"));
		System.out.println(read);
		//JAVA8新增接口 列出当前目录下所有文件和目录
		Files.list(Paths.get("d:/")).forEach(path -> System.out.println(path));
		//Stream API读取文件内容
		Files.lines(Paths.get("d:/write.txt"), Charset.forName("UTF-8")).forEach(str -> System.out.println(str));
		FileStore fileStore = Files.getFileStore(Paths.get("d:"));
		System.out.println("总空间"+fileStore.getTotalSpace()/1024/1024/1024);//总空间 GB
		System.out.println("已用空间"+fileStore.getUsableSpace());//已用空间
		
		
		
	}

}
