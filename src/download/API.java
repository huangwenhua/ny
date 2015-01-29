package download;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import util.URLUtil;

public abstract class API {
	
	private static Log logger = LogFactory.getLog(API.class);
	
//	// ɳ�价�����õ�ַ
//	protected static String url = "";
//	// ǩ������key()
//	protected static String key = "260679099974928990734395726233124883296152635423759928527339834811292941534459868827552432";
//	// �������list
//	protected static String data = "{}";
//	// ������Ӧ��ʽ
//	protected static String format = "xml";
//	// ������ID
//	protected static String merId = "100041";
//	// ����ģʽ
//	protected static String dataMode = "0";
//   // openid
//	protected static String openId = "ph003309";
	
	// ��ʽ�������õ�ַ
	protected static String url = "";
	// ǩ������key()
	protected static String key = "342487333761623214081645951336491902410482030736129151391884908431974922840350248917341743";
	// �������list
	protected static String data = "{}";
	// ������Ӧ��ʽ
	protected static String format = "xml";
	// ������ID
	protected static String merId = "100006";
	// ����ģʽ
	protected static String dataMode = "0";
   // openid
	protected static String openId = "";
	
	protected static String startDate = "";
	protected static String enDate = "";
	
	protected String sourceDir;
	protected String destDir;

	// ƴ�ӹ�����������ǩ��
	protected String userGet(int pageIndex,String user,String startTime,String enDTime) {
		openId = user;
		startDate = startTime;
		enDate = enDTime;
		if(pageIndex < 1)
			throw new RuntimeException("pageIndex��must bigger than 0");
		if(user.equals(""))
			throw new RuntimeException("user must have");
		papreData(pageIndex);
		
		TreeMap<String, String> apiparamsMap = new TreeMap<String, String>();
		apiparamsMap.put("format", format);
		apiparamsMap.put("merId", merId);
		apiparamsMap.put("openId", openId);
		apiparamsMap.put("dataMode", dataMode);
		apiparamsMap.put("data", data);
		// ����ǩ��
		String sign = URLUtil.md5Signature(data + merId + dataMode + key);
		apiparamsMap.put("sign", sign);
		StringBuilder param = new StringBuilder();
		for (Iterator<Map.Entry<String, String>> it = apiparamsMap.entrySet()
				.iterator(); it.hasNext();) {
			Map.Entry<String, String> e = it.next();
			param.append("&").append(e.getKey()).append("=").append(e.getValue());
		}
		return param.toString().substring(1);
	}
	
	private boolean succ(String xml){
		Document docment = null;
		try {
			docment = DocumentHelper.parseText(xml); // ���ַ���תΪXML
			Element rootElt = docment.getRootElement(); // ��ȡ���ڵ�
			Iterator it = rootElt.elementIterator("respCode");
			Element el = (Element)  it.next();
			if(el.getText().trim().equals("0"))
				return true;
			else 
				logger.error("������Ϣʧ��" + ((Element)(rootElt.elementIterator("respMsg").next())).getText() );
		} catch (Exception e) {
			logger.error("parse xml is error :" + e.getMessage());
			e.printStackTrace();
		}
		return false;
	}
	
	protected void down(String user,String startDate,String enDate) {
		boolean flag = false;
		int i = 1;
		while(!flag){
			String paramStr = userGet(i,user,startDate,enDate);
			String result = URLUtil.getResult(url, paramStr);
			logger.debug(result);
			flag = finish(result);
			if(!flag)
				parser(result);
			i++;
		}	
		logger.info( "[" + user + "]" + "[" + startDate + "_" + enDate + "]" + " down data done ...");
	}

	public void userdown(String startDate,String enDate) {
		List<String> userlist = new ArrayList<String>();
//		userlist.add("ph008777");
//		userlist.add("ph008605");
//		userlist.add("ph010653");
//		userlist.add("ph010652");
//		userlist.add("ph010651");
//		userlist.add("ph010650");
//		userlist.add("ph010649");
//		userlist.add("ph010648");
//		userlist.add("ph010647");
//		userlist.add("ph010646");
//		userlist.add("ph010645");
//		userlist.add("ph010644");
//		userlist.add("ph010643");
		
//		userlist.add("ph011495");//[����������Ժ]
		
		//�����سǹ���
//		userlist.add("ph010582");//ɳƺ��������
//		userlist.add("ph010581");//��������������
//		userlist.add("ph010580");//��������������
//		userlist.add("ph010579");//��������������
//		userlist.add("ph010578");//�л�����������
//		userlist.add("ph010575");//��������������
		userlist.add("ph005768");//��������������
		
		//userlist.add("ph010642");	//������
		
		for(String user:userlist){
			downbydate(user,startDate,enDate);
			logger.info( "[" + user + "]" + "[" + startDate + "_" + enDate + "]" + " down data done ... ...");
		}
	}
	
	private void downbydate(String user,String startTime,String endTime){
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    	java.util.Date startDD = null;
    	java.util.Date endDD = null;
		try {
			startDD = sdf.parse((String)startTime);
			endDD = sdf.parse((String)endTime);  
			
	        Calendar cal = Calendar.getInstance();   
	        while(startDD.before(endDD)){
	            cal.setTime(startDD);   
	            String _startTime = sdf.format(cal.getTime());
	            
	            //cal.add(Calendar.DAY_OF_MONTH, 1); 
	            cal.add(Calendar.MONTH, 1); 
	            startDD = cal.getTime();
	            String _endTime;
	            if(startDD.before(endDD))
	            	_endTime = sdf.format(startDD);
	            else 
	            	_endTime = sdf.format(endDD);
	            
	            logger.debug("==================startTime = " + _startTime + ", endTime = " + _endTime + "==========start==========");
				down(user,_startTime,_endTime);
				logger.debug("==================startTime = " + _startTime + ", endTime = " + _endTime + "==========end==========");
	        }
		} catch (ParseException e) {
			e.printStackTrace();
			logger.error("execute error:" + e.getMessage());
		}  
	}
	
	public abstract void papreData(int pageIndex);
	public abstract boolean finish(String xml);
	public abstract void parser(String xml);

}



