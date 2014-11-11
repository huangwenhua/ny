package test;

import java.util.HashMap;
import java.util.Map;

public class Test {
	
	public static  String symptom(String str){
		String ret = "";
		String[] lsit = str.split(",");
		for(String code:lsit){
			if(code.equals("1"))
				return "";
			else if(code.equals("2"))
				code = "1";
			else if(code.equals("3"))
				code = "2";
			else if(code.equals("4"))
				code = "3";
			else if(code.equals("5"))
				code = "4";
			else if(code.equals("6"))
				code = "5";
			else if(code.equals("7"))
				code = "6";
			else if(code.equals("8"))
				code = "7";
			else if(code.equals("9"))
				code = "8";
			else if(code.equals("10"))
				code = "9";
			else if(code.equals("11"))
				code = "10";
			else if(code.equals("12"))
				code = "11";
			else if(code.equals("13"))
				code = "12";
			else if(code.equals("14"))
				code = "13";
			else if(code.equals("15"))
				code = "14";
			else if(code.equals("16"))
				code = "15";
			else if(code.equals("17"))
				code = "16";
			else if(code.equals("18"))
				code = "17";
			else if(code.equals("19"))
				code = "18";
			else if(code.equals("20"))
				code = "19";
			else if(code.equals("21"))
				code = "20";
			else if(code.equals("22"))
				code = "21";
			else if(code.equals("23"))
				code = "22";
			else if(code.equals("24"))
				code = "99";
			else if(code.equals("25"))
				code = "99";
			ret = ret + code + ",";
		}
		ret = ret.substring(0, ret.length()-1);
		return ret;
	}
	
	public static String dangercontrol(String str){
		String ret = "";
		String[] lsit = str.split(",");
		for(String code:lsit){
			if(code.equals("1"))
				code = "戒烟";
			else if(code.equals("2"))
				code = "健康饮酒";
			else if(code.equals("3"))
				code = "饮食";
			else if(code.equals("4"))
				code = "锻炼";
			else if(code.equals("5"))
				code = "减体重";
			else if(code.equals("6"))
				code = "建议疫苗接种";
			else if(code.equals("7"))
				code = "其他";
			ret = ret + code + ",";
		}
		ret = ret.substring(0, ret.length()-1);
		return ret;
	}

	public static void main(String[] args) {
//		System.out.println(Test.symptom("2,3,4,77,83,84,90"));
//		System.out.println(Test.dangercontrol("1,3,2"));
//		String a = "疫苗接种aaa卫生室 ";
//		if(a.contains("卫生室"))
//			System.out.println(a.split("卫生室")[0]);
		
//		String s = "s'{ssaaa";
//		System.out.println(s.replace("'","''"));
		
		Map map = new HashMap();
		map.put("b", "");
		System.out.println(map.get("s"));
		System.out.println(map.get("b"));
		System.out.println(map.get("b")==null);
	}

}
