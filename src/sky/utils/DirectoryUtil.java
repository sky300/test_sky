package sky.utils;

import java.io.File;
import java.util.StringTokenizer;

/**
 * 目录管理工具类
 * 
 * @author Administrator
 * 
 */
public class DirectoryUtil {

	/**
	 * 检查文件路径，如果不存在则自动创建
	 * 
	 * @param filePath
	 */
	public static void mkDir(String filePath) {
		File f = new File(filePath);
		try {
			if (!f.exists()) { // 此处需要循环查询
				StringTokenizer st = new StringTokenizer(filePath, "/");
				String path = "";
				while (st.hasMoreTokens()) {
					path += "/" + st.nextToken();
					File tmpPath = new File(path);
					if (!tmpPath.exists())
						tmpPath.mkdirs();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件，可以是文件或文件夹
	 * 
	 * @param fileName
	 *            要删除的文件名
	 * @return 删除成功返回true，否则返回false
	 */
	public static boolean delete(String fileName) {
		File file = new File(fileName);
		if (!file.exists()) {
			return false;
		} else {
			if (file.isFile())
				return FileUtil.deleteFile(fileName);
			else
				return rmDir(fileName);
		}
	}



	/**
	 * 删除目录及目录下的文件
	 * 
	 * @param dir
	 *            要删除的目录的文件路径
	 * @return 目录删除成功返回true，否则返回false
	 */
	public static boolean rmDir(String dir) {
		// 如果dir不以文件分隔符结尾，自动添加文件分隔符
		if (!dir.endsWith(File.separator))
			dir = dir + File.separator;
		File dirFile = new File(dir);
		// 如果dir对应的文件不存在，或者不是一个目录，则退出
		if ((!dirFile.exists()) || (!dirFile.isDirectory())) {
			return false;
		}
		boolean flag = true;
		// 删除文件夹中的所有文件包括子目录
		File[] files = dirFile.listFiles();
		for (int i = 0; i < files.length; i++) {
			// 删除子文件
			if (files[i].isFile()) {
				flag = FileUtil.deleteFile(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
			// 删除子目录
			else if (files[i].isDirectory()) {
				flag = DirectoryUtil
						.rmDir(files[i].getAbsolutePath());
				if (!flag)
					break;
			}
		}
		if (!flag) {
			return false;
		}
		// 删除当前目录
		if (dirFile.delete()) {
			return true;
		} else {
			return false;
		}
	}

}
