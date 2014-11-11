package test;

import java.math.BigInteger;
import java.security.MessageDigest;

public class MD5 {

	//byte[] btInput = s.getBytes("utf-8");
	public final static String md5(String s) {
		char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
				'A', 'B', 'C', 'D', 'E', 'F' };
		try {
			byte[] btInput = s.getBytes();
			// 获得MD5摘要算法的 MessageDigest 对象
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 使用指定的字节更新摘要
			mdInst.update(btInput);
			// 获得密文
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String makeMD5(String password) {
		MessageDigest md;
		try {
			// 生成一个MD5加密计算摘要
			md = MessageDigest.getInstance("MD5");
			// 计算md5函数
			md.update(password.getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			String pwd = new BigInteger(1, md.digest()).toString(16);
			// System.err.println(pwd);
			return pwd;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}

	public static void main(String[] args) {
//		System.out.println(MD5.md5("20121221"));
//		System.out.println(MD5.makeMD5("20121221"));

//		System.out.println(MD5.md5("1"));
//		System.out.println(MD5.makeMD5("1"));
//		
//		System.out.println(MD5.md5("我"));
//		System.out.println(MD5.makeMD5("我"));
		
//		System.out.println(MD5.md5("{“id”:” 3711”}"));
//		System.out.println(MD5.makeMD5("{“id”:” 3711”}"));
		
		System.out.println(MD5.md5("{\"id\":\"1303\"}"));
		System.out.println(MD5.md5("{}1000410260679099974928990734395726233124883296152635423759928527339834811292941534459868827552432"));
	}

}
