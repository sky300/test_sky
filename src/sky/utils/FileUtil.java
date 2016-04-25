package sky.utils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
public class FileUtil {
	/**
	 * 文件移动
	 * 
	 * @param fromFile -
	 *            要被移的文件名
	 * @param toFile -
	 *            目标文件名
	 * @return void
	 */
	public static void moveFile(String fromFile, String toFile) {
		try {
			DataInputStream in =null;
			DataOutputStream out =null;
			try{
			    in = new DataInputStream(new BufferedInputStream(
						new FileInputStream(fromFile)));
				out = new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(toFile, false)));
				// 开始拷贝文件内容
				while (in.available() != 0) {
					out.writeByte(in.readByte());
				}
			}finally{
			    if(in!=null){
				    in.close();
			    }
			    if(out!=null){
			        out.close();
			    }
			}
			deleteFile(fromFile);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 文件移动
	 * 
	 * @param fromFile -
	 *            要拷贝的文件名
	 * @param toFile -
	 *            目标文件名
	 * @return void
	 */
	public static void copyFile(String fromFile, String toFile)  {
		try {
			DataInputStream in =null;
			DataOutputStream out =null;
			try{
			    in = new DataInputStream(new BufferedInputStream(
						new FileInputStream(fromFile)));
				out = new DataOutputStream(new BufferedOutputStream(
						new FileOutputStream(toFile, false)));

				// 开始拷贝文件内容
				while (in.available() != 0) {
					out.writeByte(in.readByte());
				}
			
			}finally{
               if(in!=null){			
			       in.close();
               }
               if(out!=null){
			       out.close();
               }
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 删除文件
	 * 
	 * @param fileName -
	 *            要删除的文件名
	 * @return void
	 */
	public static boolean deleteFile(String fileName) {
		try {
			File file = new File(fileName);
			// 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
			if (file.exists() && file.isFile()) {
				if (file.delete()) {
					return true;
				} else {
					return false;
				}
			} else {
				return false;
			}

		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	
	
	/**
	 * 写文件
	 * @param filePath 文件所在全路径
	 * @param fileName 文件名称
	 * @param message  文件内容
	 */
	public static void writeFile(String filePath, String fileName,
			String message) {
		String tmpPath = filePath;
		if (!filePath.endsWith("/")) {
			tmpPath = tmpPath + "/";
		}
		DataOutputStream out = null;
		try {
			DirectoryUtil.mkDir(tmpPath);
			out = new DataOutputStream(new BufferedOutputStream(
					new FileOutputStream(tmpPath + fileName, true)));
			out.write(message.getBytes());
			out.writeBytes("\n");
		} catch (Exception e) {
			e.printStackTrace();
	
		} finally {
			if (out != null) {
				try {
					out.close();
					out = null;
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	/**
	 * 解压缩文件到同目录下
	 * @param filename
	 * @return
	 */
    public static boolean isPics(String filename)  
    {  
        boolean flag = false;  
          
        if(filename.endsWith(".jpg") || filename.endsWith(".gif")  || filename.endsWith(".bmp") || filename.endsWith(".png"))  
            flag = true;  
          
        return flag;  
    }  
    public static void unZip(String path) {
        int count = -1;  
        int index = -1;  
        String savepath = "";  
        boolean flag = false;  
          
        File file = null;   
        InputStream is = null;    
        FileOutputStream fos = null;    
        BufferedOutputStream bos = null;  
        if(path.lastIndexOf("\\")!=-1){
        	savepath = path.substring(0, path.lastIndexOf("\\")) + "\\";  
        }else if (path.lastIndexOf("/")!=-1) {
        	savepath = path.substring(0, path.lastIndexOf("/")) + "/";  
		}
        try  
        {   
            ZipFile zipFile = new ZipFile(path);   
  
            Enumeration<?> entries = zipFile.getEntries();  
              
            while(entries.hasMoreElements())  
            {   
                byte buf[] = new byte[2048];   
                  
                ZipEntry entry = (ZipEntry)entries.nextElement();   
                  
                String filename = entry.getName();  
                index = filename.lastIndexOf("/");  
                if(index > -1)  
                    filename = filename.substring(index+1);  
                  
                filename = savepath + filename;  
               
                /**	不加判断解压	注释掉解压部分的判断**/
                /**flag = isPics(filename);  
                if(!flag)  
                    continue;  
                **/  
                file = new File(filename);   
                file.createNewFile();  
                  
                is = zipFile.getInputStream(entry);   
                  
                fos = new FileOutputStream(file);   
                bos = new BufferedOutputStream(fos, 2048);  
                  
                while((count = is.read(buf)) > -1)  
                {   
                    bos.write(buf, 0, count );   
                }   
                /**xianghuan 20110803 增加BufferedOutputStream的关闭，否则无法输出文件流到文件**/
                bos.close();
                fos.close();   
  
                is.close();   
            }   
              
            zipFile.close();   
              
        }catch(IOException ioe){   
            ioe.printStackTrace();   
//			throw new BizBussinessException(IErrMsg.ERR_FILENOTFOUND,"文件"+path+"未找到");
        }   
    }   
  
	
}
