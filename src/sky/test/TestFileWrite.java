package sky.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class TestFileWrite {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		BufferedReader br = null;
		InputStreamReader isr = new InputStreamReader(System.in);
		br = new BufferedReader(isr);
		String buff = null;
		try {
			while ((buff = br.readLine()) != null) {
				if(buff.equals("小强是猪吗？")){
					System.out.println("答对了，你太聪明了！");
				}else{
					System.out.println(buff);
				}
				
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			try {
				isr.close();
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}
	}

}
