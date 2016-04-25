package sky.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

public class TestFile {

	/**
	 * @param args
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		String str ="aa.txt";
		File file = new File(str);
		System.out.println("文件路径：" + file.getPath());
		System.out.println("文件绝对路径：" + file.getAbsolutePath());
		System.out.println("文件是否存在：" + file.exists());
		System.out.println("文件名：" + file.getName());
//		System.out.println("重命名：" + file.renameTo(new File("helloWorld.txt")));
		System.out.println("是否存在:" + file.exists());
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		System.out.println("最后修改日期:" + sdf.format(file.lastModified()));
		
		File f = new File("d:\\aa6a.txt");
		f.createNewFile();
//		//创建文件
//		File ff = new File("d:\\hello\\hlll");
//		ff.mkdirs();
//		System.out.println(File.createTempFile("mail", ".txt", ff));
		
		
		
	}
	
}
