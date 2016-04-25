package sky.shibor;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
/**
 * 获取上海银行间同业拆放利率（Shibor）
 * @author skyow
 *
 */
public class GetShibor {
	/**
	 * 发起http get请求获取网页源代码
	 * 
	 * @param requestUrl
	 * @return
	 */
	private static String httpRequest(String requestUrl) {
		StringBuffer buffer = null;

		try {
			// 建立连接
			URL url = new URL(requestUrl);
			HttpURLConnection httpUrlConn = (HttpURLConnection) url.openConnection();
			httpUrlConn.setDoInput(true);
			httpUrlConn.setRequestMethod("GET");

			// 获取输入流
			InputStream inputStream = httpUrlConn.getInputStream();
			InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "gbk");
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

			// 读取返回结果
			buffer = new StringBuffer();
			String str = null;
			while ((str = bufferedReader.readLine()) != null) {
				buffer.append(str);
			}
			// 释放资源
			bufferedReader.close();
			inputStreamReader.close();
			inputStream.close();
			httpUrlConn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}
	
	public static void main(String[] args) {
		String str = httpRequest("http://www.shibor.org/shibor/web/html/shibor.html");
		Pattern p = Pattern.compile("<td width=\"35%\" align=\"center\">.*?</td>|<font color=blue>.*?</font>");
		Matcher m = p.matcher(str);
		while (m.find()) {
			String limitStr =m.group().replaceAll("<font color=blue>", "").replaceAll("</font>", "");//去标签获取期限名称
			String shiborStr = limitStr.replaceAll("<td width=\"35%\" align=\"center\">", "").replaceAll("</td>", "");//去标签获取Shibor利率
			System.out.println(shiborStr);
		}
	}
}
