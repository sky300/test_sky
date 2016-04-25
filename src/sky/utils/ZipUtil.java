package sky.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/** 20120104    xianghuan	修改打包程序使其支持中文文件压缩**/
import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipOutputStream;


public class ZipUtil {
	/**
	 * 文件压缩
	 * 
	 * @param fileName
	 *            待压缩文件名
	 * @param zipFileName
	 *            压缩后文件名
	 * @param path
	 *            文件路径
	 */
	public static void genZipFile(String fileName, String zipFileName,
			String path) {
		List list = new ArrayList();
		list.add(fileName);
		genZipFile(list, zipFileName, path);
	}

	/**
	 * 将文件列表中指定的文件打包成zip文件
	 * 
	 * @param fileList
	 * @param zipFileName
	 */
	public static void genZipFile(List fileList, String zipFileName, String path) {

		byte[] buf = new byte[8192];
		ZipOutputStream out=null;
		try {

			String outFilename = null;

			if (path.endsWith("/") || path.endsWith("\\")) {
				int index = path.lastIndexOf("/");
				if (index != -1) {
					path = path.substring(0, index);
				} else {
					index = path.lastIndexOf("\\");
					path = path.substring(0, index);
				}

			}
			outFilename = path + "/" + zipFileName;
			out = new ZipOutputStream(new FileOutputStream(
					outFilename));
			for (int i = 0; i < fileList.size(); i++) {
				FileInputStream in=null;
				try{
				in = new FileInputStream(path + "/" + fileList.get(i));
					out.putNextEntry(new ZipEntry((String) fileList.get(i)));
					/** 20120104    xianghuan	修改打包程序使其支持中文文件压缩**/
					out.setEncoding("GBK");
					int len;
					while ((len = in.read(buf)) > 0) {
						out.write(buf, 0, len);
					}
					out.closeEntry();
				}finally{
				   if(in!=null){
					in.close();
				   }
				   in=null;
				}
			}
		} catch (IOException e) {
		}finally{
			if(out!=null){
			    try {
					out.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			out=null;
		}

	}
	

	public static void CreateZipFile(String filePath, String zipFilePath) {
		FileOutputStream fos = null;
		ZipOutputStream zos = null;
		try {
			fos = new FileOutputStream(zipFilePath);
			zos = new ZipOutputStream(fos);
			writeZipFile(new File(filePath), zos, "");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (zos != null)
					zos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			try {
				if (fos != null)
					fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

	}

	private static void writeZipFile(File f, ZipOutputStream zos, String hiberarchy) {
		if (f.exists()) {
			if (f.isDirectory()) {
				hiberarchy += f.getName() + "/";
				File[] fif = f.listFiles();
				for (int i = 0; i < fif.length; i++) {
					writeZipFile(fif[i], zos, hiberarchy);
				}

			} else {
				FileInputStream fis = null;
				try {
					fis = new FileInputStream(f);
					ZipEntry ze = new ZipEntry(hiberarchy + f.getName());
					zos.putNextEntry(ze);
					byte[] b = new byte[1024];
					while (fis.read(b) != -1) {
						zos.write(b);
						b = new byte[1024];
					}
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				} finally {
					try {
						if (fis != null)
							fis.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}

			}
		}

	}
	
	public static void main(String[] args) {
		ZipUtil.genZipFile("新建文件夹.txt", "tttttt.zip", "f:/zip");
	}


}
