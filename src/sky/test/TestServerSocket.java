package sky.test;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.Inet4Address;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestServerSocket {

	public static void main(String[] args) throws UnknownHostException {

		try {
			ServerSocket ss = new ServerSocket(9999);
			while (true) {
				Socket socket = ss.accept();
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
				bw.write("hello world");
				bw.close();
				socket.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
