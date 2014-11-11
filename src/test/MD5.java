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
			// ���MD5ժҪ�㷨�� MessageDigest ����
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// ʹ��ָ�����ֽڸ���ժҪ
			mdInst.update(btInput);
			// �������
			byte[] md = mdInst.digest();
			// ������ת����ʮ�����Ƶ��ַ�����ʽ
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
			// ����һ��MD5���ܼ���ժҪ
			md = MessageDigest.getInstance("MD5");
			// ����md5����
			md.update(password.getBytes());
			// digest()���ȷ������md5 hashֵ������ֵΪ8Ϊ�ַ�������Ϊmd5 hashֵ��16λ��hexֵ��ʵ���Ͼ���8λ���ַ�
			// BigInteger������8λ���ַ���ת����16λhexֵ�����ַ�������ʾ���õ��ַ�����ʽ��hashֵ
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
//		System.out.println(MD5.md5("��"));
//		System.out.println(MD5.makeMD5("��"));
		
//		System.out.println(MD5.md5("{��id��:�� 3711��}"));
//		System.out.println(MD5.makeMD5("{��id��:�� 3711��}"));
		
		System.out.println(MD5.md5("{\"id\":\"1303\"}"));
		System.out.println(MD5.md5("{}1000410260679099974928990734395726233124883296152635423759928527339834811292941534459868827552432"));
	}

}
