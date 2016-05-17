package sky.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
/**
 * @author jieyue
 * 1、如果需要序列化的对象的变量不是基本数据类型，而是其它对象，则该对象也必须要继承Serializable接口
 * 2、变量前加入transient关键字则不序列化该变量
 */
public class 序列化 {
	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		序列化 a = new 序列化();
//		a.outputSerializable();
		a.inputSerializable();
	}
	
	/**
	 * 序列化
	 */
	public void outputSerializable()throws FileNotFoundException, IOException {
		ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("d:/aaa.txt"));
		Student stu = new Student();
		stu.setName("sky");
		stu.setAge(20);
		stu.setSex("male");
		oos.writeObject(stu);//将student对象写入文本文件
	}
	/**
	 * 反序列化
	 * @throws IOException 
	 * @throws FileNotFoundException 
	 * @throws ClassNotFoundException 
	 */
	public void inputSerializable() throws FileNotFoundException, IOException, ClassNotFoundException{
		ObjectInputStream ios = new ObjectInputStream(new FileInputStream("d:/aaa.txt"));
		Student stu = (Student)ios.readObject();//强制转换成Student对象
		System.out.println(stu.getName());
		System.out.println(stu.getSex());
		System.out.println(stu.getAge());
	}
	
}
