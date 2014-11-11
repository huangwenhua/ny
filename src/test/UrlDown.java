package test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class UrlDown {

	public static void rec() {
		URL url = null;
		String urlStr = "http://124.133.239.162:9898/api/baseinfo/list_baseinfo";
		HttpURLConnection httpurlconnection = null;
		try {
			url = new URL(urlStr);

			// 以post方式请求
			httpurlconnection = (HttpURLConnection) url.openConnection();
			httpurlconnection.setDoOutput(true);
			httpurlconnection.setRequestMethod("POST");
			String username = "data={\"id\":\"1105\"}&dataMode=0&format=json&merId=100041&openId=ph003309&sign=BB888E241AD7D2FDB4FA6A6B3EA1BBF3";
			httpurlconnection.getOutputStream().write(username.getBytes());
			httpurlconnection.getOutputStream().flush();
			httpurlconnection.getOutputStream().close();

			// 获取响应代码
			int code = httpurlconnection.getResponseCode();
			System.out.println("code   " + code);

			// 获取页面内容
			InputStream in = httpurlconnection.getInputStream();
			BufferedReader breader = new BufferedReader(new InputStreamReader(
					in, "utf-8"));
			String str = breader.readLine();
			while (str != null) {
				System.out.println(str);
				str = breader.readLine();
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (httpurlconnection != null)
				httpurlconnection.disconnect();
		}
	}

	public static void main(String[] args) {
		UrlDown.rec();
	}

}
