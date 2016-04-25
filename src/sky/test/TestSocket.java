package sky.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestSocket {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			Socket s =  new Socket("195.204.72.216", 9999);
			BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));
			System.out.println("-------->" + br.readLine());
			br.close();
			s.close();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
