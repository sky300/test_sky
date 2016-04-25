package sky.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

/**
 * 日志类
 * 
 */
public final class LogUtil {
private static final String ENCODE = "GBK";
	public LogUtil() {

	}

	/**
	 * 以UTF-8编码格式创建日志
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 */
	public LogUtil(String path, String fileName) {
		this(path, fileName, ENCODE);
	}

	/**
	 * 以自定义编码格式创建日志
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param encodeName
	 *            编码名
	 */
	public LogUtil(String path, String fileName, String encodeName) {
		this.setPath(path);
		this.setFileName(fileName);
		this.setEncodeName(encodeName);
	}

	private StringBuilder builder;

	private static String lineSeparator = System.getProperty("line.separator");

	// 文件路径
	private String path;
	// 编码
	private String encodeName;
	// 文件名
	private String fileName;

	/**
	 * 获取日志编码名称
	 * 
	 * @return
	 */
	public String getEncodeName() {
		return encodeName;
	}

	/**
	 * 设置日志编码名称
	 * 
	 * @param encodeName
	 */
	public void setEncodeName(String encodeName) {
		this.encodeName = this.reSetEncodeName(encodeName);
	}

	/**
	 * 获取日志文件名
	 * 
	 * @return
	 */
	public String getFileName() {
		return fileName;
	}

	/**
	 * 设置日志文件名
	 * 
	 * @param fileName
	 */
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	/**
	 * 获取日志路径
	 * 
	 * @return
	 */
	public String getPath() {
		return path;
	}

	/**
	 * 设置日志路径
	 * 
	 * @param path
	 */
	public void setPath(String path) {
		this.path = this.rePath(path);
	}

	/**
	 * 打印日志
	 * 
	 * @param content
	 *            日志内容
	 * @param serviceName
	 *            服务名
	 * @param append
	 *            是否追加
	 */
	public void printLog(String content, String serviceName, boolean append) {
		String info = createLogString(content, serviceName);
		try {
			writeLog(this.path, this.fileName, info, this.encodeName, append);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 打印日志(追加)
	 * 
	 * @param content
	 *            日志内容
	 * @param serviceName
	 *            服务名
	 */
	public void printLog(String content, String serviceName) {
		this.printLog(content, serviceName, true);
	}

	/**
	 * 打印日志
	 * 
	 * @param content
	 *            日志内容
	 * @param append
	 *            是否追加
	 */
	private void printLog(String content, boolean append) {
		this.printLog(content, null, append);
	}

	/**
	 * 打印日志(追加)
	 * 
	 * @param content
	 *            日志内容
	 */
	public void printLog(String content) {
		this.printLog(content, true);
	}

	/**
	 * 打印日志设置路径和编码
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param serviceName
	 *            服务名
	 * @param encodeName
	 *            编码名
	 * @param append
	 *            是否追加
	 */
	public void printLogWithEncode(String path, String fileName, String content, String serviceName, String encodeName, boolean append) {
		this.setPath(path);
		this.setEncodeName(encodeName);
		this.setFileName(fileName);
		this.printLog(content, serviceName, append);
	}

	/**
	 * 打印日志设置路径和编码(追加)
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param serviceName
	 *            服务名
	 * @param encodeName
	 *            编码名
	 */
	public void printLogWithEncode(String path, String fileName, String content, String serviceName, String encodeName) {
		this.printLogWithEncode(path, fileName, content, serviceName, encodeName, true);
	}

	/**
	 * 打印日志设置路径和编码
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param encodeName
	 *            编码名
	 * @param append
	 *            是否追加
	 */
	public void printLogWithEncode(String path, String fileName, String content, String encodeName, boolean append) {
		this.printLogWithEncode(path, fileName, content, null, encodeName, append);
	}

	/**
	 * 打印日志设置路径和编码(追加)
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param encodeName
	 *            编码名
	 */
	public void printLogWithEncode(String path, String fileName, String content, String encodeName) {
		this.printLogWithEncode(path, fileName, content, encodeName, true);
	}

	/**
	 * 打印日志设置路径
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param serviceName
	 *            服务名
	 * @param append
	 *            是否追加
	 */
	public void printLogWithPath(String path, String fileName, String content, String serviceName, boolean append) {
		this.printLogWithEncode(path, fileName, content, serviceName, null, append);
	}

	/**
	 * 打印日志设置路径(追加)
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param serviceName
	 *            服务名
	 */
	public void printLogWithPath(String path, String fileName, String content, String serviceName) {
		this.printLogWithPath(path, fileName, content, serviceName, true);
	}

	/**
	 * 打印日志设置路径
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param append
	 *            是否追加
	 */
	public void printLogWithPath(String path, String fileName, String content, boolean append) {
		this.printLogWithPath(path, fileName, content, null, append);
	}

	/**
	 * 打印日志设置路径
	 * 
	 * @param path
	 *            路径名
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 */
	public void printLogWithPath(String path, String fileName, String content) {
		this.printLogWithPath(path, fileName, content, true);
	}

	/**
	 * 生成一条日志记录
	 * 
	 * @param content
	 *            日志内容
	 * @param serviceName
	 *            服务名称
	 * @return 一条日志记录
	 */
	private String createLogString(String content, String serviceName) {
		serviceName = serviceName == null ? "" : serviceName;
		//String date = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss,SSS").format(new Date());
		builder = new StringBuilder();
//		builder.append(" [");
		builder.append(serviceName);
//		builder.append(": ");
		builder.append(content);
		return builder.toString();
	}

	/**
	 * 写日志
	 * 
	 * @param path
	 *            路径
	 * @param fileName
	 *            文件名
	 * @param content
	 *            日志内容
	 * @param encodeName
	 *            编码
	 * @param append
	 *            是否追加
	 * @throws IOException
	 *             抛出IO异常
	 */
	private void writeLog(String path, String fileName, String content, String encodeName, boolean append) throws IOException {
		this.createPath(path);
		builder = new StringBuilder(path);
		builder.append(fileName);
		File logFile = new File(builder.toString());
		Writer ow = new OutputStreamWriter(new FileOutputStream(logFile, append), encodeName);
		ow.write(content + lineSeparator);
		ow.flush();
		ow.close();
		System.out.println(content);
	}

	/**
	 * 重构路径
	 * 
	 * @param path
	 *            路径名称
	 * @return
	 */
	private String rePath(String path) {
		builder = new StringBuilder(path);
		if (path.lastIndexOf("/") != path.length() - 1) {
			builder.append(File.separator);
		}
		return builder.toString();
	}

	/**
	 * 创建路径
	 * 
	 * @param path
	 *            路径名称
	 */
	private void createPath(String path) {
		File dirsFile = new File(path);
		if (!dirsFile.exists()) {
			dirsFile.mkdirs();
		}
	}

	/**
	 * 重设编码名称 如果为空则设置默认为UTF-8
	 * 
	 * @param encodeName
	 *            编码名称
	 * @return
	 */
	private String reSetEncodeName(String encodeName) {
		return encodeName == null ? ENCODE : encodeName;
	}
}