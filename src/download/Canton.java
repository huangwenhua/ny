package download;

import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import util.URLUtil;

public class Canton extends API{
	private static Log logger = LogFactory.getLog(Canton.class);
	
	private String _id = "";
	private String _type = "";

	public Canton(){
		//url = "http://124.133.239.162:9898/api/canton/get_canton";//��������--���Ե�ַ
		//url = "http://119.188.126.39:8080/api/canton/get_canton";//��������
	}
	
	@Override
	public void papreData(int pageIndex) {	
		data = "<canton><id>" + _id + "</id><type>" + _type + "</type></canton>";
	}

	@Override
	public boolean finish(String xml) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void parser(String xml) {
		// TODO Auto-generated method stub
	}
	
	public String getCode(String user,String id,String type){
		_id = id;
		_type = type;
		String code = "";
		String paramStr = userGet(1,user,startDate,enDate);
		String result = URLUtil.getResult("http://119.188.126.39:8080/api/canton/get_canton", paramStr);
		logger.debug(result);
		Document docment = null;
		try {
			docment = DocumentHelper.parseText(result); // ���ַ���תΪXML
			Element rootElt = docment.getRootElement(); // ��ȡ���ڵ�
			
			Iterator iter = rootElt.elementIterator("canton"); // ��ȡ���ڵ��µ��ӽڵ�
			// ����response�ڵ�
			while (iter.hasNext()) {
				Element cantonE = (Element) iter.next();
				Element codeE = cantonE.element("code");
				code = codeE!=null?codeE.getText():"";
				logger.debug(cantonE.element("name").getText());
			}
		}catch (Exception e) {
			logger.error("parse xml is error :" + e.getMessage());
			e.printStackTrace();
		}
		return code;
	}
	
	public static void main(String[] args) {
		Canton api = new Canton();
		//System.out.println(api.getCode("ph010652", "16", "province"));
		
		System.out.println(api.getCode("ph008605", "1105", "district"));
		//data=<canton><id>8040</id><type>village</type></canton>&dataMode=0&format=xml&merId=100006&openId=ph010642&sign=7F1C6B9FD1854EC2DFCD01A43EC605A8
	}
}
