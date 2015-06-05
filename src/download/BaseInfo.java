package download;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import bean.PersonHealthRecordMain;
import util.FileUtil;

public class BaseInfo extends API{
	
	private static Log logger = LogFactory.getLog(BaseInfo.class);
	
	public  Map<String,String> communityCodeMap = new HashMap<String,String>();
	private Canton canton = new Canton();
	
	public BaseInfo(){
//		url = "http://124.133.239.162:9898/api/baseinfo/list_baseinfo";//居民档案信息列表--测试地址
//		url = "http://119.188.126.39:8080/api/baseinfo/list_baseinfo";//正式地址
		url = "http://119.188.126.39:8080/nbphsc-backend/api/baseinfo/list_baseinfo";
		
		sourceDir = "D:/ny/BaseInfo/sourceFile/";
		destDir = "D:/ny/BaseInfo/destFile/";
		
		communityCodeMap.put("41", "410000162769");
		
		communityCodeMap.put("4113",	"410000162769");
		
		communityCodeMap.put("411381","410000162782");
		communityCodeMap.put("411322","410000162773");
		communityCodeMap.put("411321","410000162777");
		communityCodeMap.put("411325","410000162778");
		communityCodeMap.put("411327","410000162780");
		communityCodeMap.put("411328","410000162776");
		communityCodeMap.put("411330","410000162772");
		communityCodeMap.put("411302","410000162770");
		communityCodeMap.put("411303","410000162771");
		communityCodeMap.put("411323","410000162781");
		communityCodeMap.put("411329","410000162868");
		communityCodeMap.put("411324","410000162775");
		communityCodeMap.put("411326","410000162774");
		
		communityCodeMap.put("411381109","");
		communityCodeMap.put("411381318","410000006170");
		communityCodeMap.put("411381319","410000006182");
		communityCodeMap.put("411381102","");
		communityCodeMap.put("411381106","");
		communityCodeMap.put("411381301","410000006174");
		communityCodeMap.put("411381320","410000006206");
		communityCodeMap.put("411381108","410000006198");
		communityCodeMap.put("411381112","");
		communityCodeMap.put("411381304","410000006190");
		communityCodeMap.put("411381310","");
		communityCodeMap.put("411381311","410000006158");
		communityCodeMap.put("411381002","");
		communityCodeMap.put("411381104","");
		communityCodeMap.put("411381105","410000006178");
		communityCodeMap.put("411381107","");
		communityCodeMap.put("411381114","410000006204");
		communityCodeMap.put("411381302","410000006186");
		communityCodeMap.put("411381313","410000006176");
		communityCodeMap.put("411381001","");
		communityCodeMap.put("411381003","");
		communityCodeMap.put("411381103","410000006180");
		communityCodeMap.put("411381110","410000006162");
		communityCodeMap.put("411381111","");
		communityCodeMap.put("411381305","410000006192");
		communityCodeMap.put("411381316","410000006172");
		communityCodeMap.put("411381113","410000006168");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322106","410000005866");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322101","410000005864");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322103","410000005854");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322300","410000005848");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322303","");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322304","410000005852");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322310","410000005856");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322102","410000005860");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322104","410000005858");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322309","410000005872");
		communityCodeMap.put("411322311","410000005876");
		communityCodeMap.put("411322306","410000005846");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322301","410000005862");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322105","410000005874");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411322302","410000005870");
		communityCodeMap.put("411321302","410000005834");
		communityCodeMap.put("411321102","410000005840");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321103","410000005820");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321103","410000005820");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321103","410000005820");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411321100","410000005814");
		communityCodeMap.put("411321106","410000005830");
		communityCodeMap.put("411321310","410000005836");
		communityCodeMap.put("411321105","410000005832");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321107","410000005842");
		communityCodeMap.put("411321304","410000005822");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321103","410000005820");
		communityCodeMap.put("411321104","410000005826");
		communityCodeMap.put("411321300","410000005844");
		communityCodeMap.put("411321301","410000005818");
		communityCodeMap.put("411321302","410000005834");
		communityCodeMap.put("411321308","410000005838");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321305","410000005816");
		communityCodeMap.put("411321101","");
		communityCodeMap.put("411321303","410000005824");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325108","");
		communityCodeMap.put("411325308","");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325102","");
		communityCodeMap.put("411325106","410000005968");
		communityCodeMap.put("411325306","410000005976");
		communityCodeMap.put("411325309","");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411325101","");
		communityCodeMap.put("411325105","");
		communityCodeMap.put("411325300","410000005970");
		communityCodeMap.put("411325301","410000005958");
		communityCodeMap.put("411325100","410000005986");
		communityCodeMap.put("411325103","");
		communityCodeMap.put("411325104","410000005982");
		communityCodeMap.put("411325107","410000005962");
		communityCodeMap.put("411325302","410000005972");
		communityCodeMap.put("411325307","410000005966");
		communityCodeMap.put("411327103","410000006048");
		communityCodeMap.put("411327101","410000006044");
		communityCodeMap.put("411327107","410000006030");
		communityCodeMap.put("411327313","410000006052");
		communityCodeMap.put("411327106","410000006055");
		communityCodeMap.put("411327108","410000006026");
		communityCodeMap.put("411327308","410000006054");
		communityCodeMap.put("411327104","410000006036");
		communityCodeMap.put("411327300","410000006050");
		communityCodeMap.put("411327304","");
		communityCodeMap.put("411327301","");
		communityCodeMap.put("411327311","");
		communityCodeMap.put("411327312","410000006038");
		communityCodeMap.put("411327100","410000006032");
		communityCodeMap.put("411327105","410000006028");
		communityCodeMap.put("411328100","");
		communityCodeMap.put("411328307","410000006090");
		communityCodeMap.put("411328108","410000006082");
		communityCodeMap.put("411328311","410000006056");
		communityCodeMap.put("411328107","410000006074");
		communityCodeMap.put("411328308","");
		communityCodeMap.put("411328309","410000006060");
		communityCodeMap.put("411328104","410000006072");
		communityCodeMap.put("411328105","410000006094");
		communityCodeMap.put("411328109","410000006080");
		communityCodeMap.put("411328111","410000006088");
		communityCodeMap.put("411328300","410000006084");
		communityCodeMap.put("411328103","410000006076");
		communityCodeMap.put("411328301","410000006086");
		communityCodeMap.put("411328102","410000006070");
		communityCodeMap.put("411328110","410000006068");
		communityCodeMap.put("411328101","410000006064");
		communityCodeMap.put("411328106","410000006078");
		communityCodeMap.put("411328112","410000006058");
		communityCodeMap.put("411328306","410000006092");
		communityCodeMap.put("411328001","");
		communityCodeMap.put("411330105","410000006130");
		communityCodeMap.put("411330305","410000006148");
		communityCodeMap.put("411330103","410000006146");
		communityCodeMap.put("411330104","410000006152");
		communityCodeMap.put("411330303","410000006124");
		communityCodeMap.put("411330100","410000151329");
		communityCodeMap.put("411330101","410000006142");
		communityCodeMap.put("411330108","410000006144");
		communityCodeMap.put("411330300","410000006136");
		communityCodeMap.put("411330302","410000006150");
		communityCodeMap.put("411330304","410000006138");
		communityCodeMap.put("411330306","410000006140");
		communityCodeMap.put("411330102","410000006134");
		communityCodeMap.put("411330106","410000006128");
		communityCodeMap.put("411330301","410000006132");
		communityCodeMap.put("411330107","410000006126");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302305","410000005774");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302001","");
		communityCodeMap.put("411302304","410000005766");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302399","");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302103","411302103");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302105","410000005778");
		communityCodeMap.put("411302302","410000005776");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302003","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302104","411302104");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302301","411302301");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302306","410000005782");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302303","410000005764");
		communityCodeMap.put("411302005","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302002","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302004","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302006","");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411302102","410000005780");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303006","");
		communityCodeMap.put("411303006","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303006","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303060","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303006","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303060","");
		communityCodeMap.put("411303060","");
		communityCodeMap.put("411303060","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303005","");
		communityCodeMap.put("411303005","");
		communityCodeMap.put("411303005","");
		communityCodeMap.put("411303005","");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303008","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303102","");
		communityCodeMap.put("411303060","");
		communityCodeMap.put("411303060","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303004","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303007","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303006","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303006","");
		communityCodeMap.put("411303006","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303103","");
		communityCodeMap.put("411303061","");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303005","");
		communityCodeMap.put("411303005","");
		communityCodeMap.put("411303005","");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303107","410000005800");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303305","410000005794");
		communityCodeMap.put("411303002","");
		communityCodeMap.put("411303101","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303105","");
		communityCodeMap.put("411303300","410000005790");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303306","410000005802");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303003","");
		communityCodeMap.put("411303307","410000005806");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303104","");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411303106","410000005796");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323002","410000009999");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323003","410000005878");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323002","410000009999");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323002","410000009999");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323003","410000005878");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323106","410000005890");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323001","410000005991");
		communityCodeMap.put("411323002","410000009999");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323309","410000005886");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323101","410000005900");
		communityCodeMap.put("411323306","410000005906");
		communityCodeMap.put("411323314","410000005880");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323313","410000005882");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323300","410000005898");
		communityCodeMap.put("411323001","410000005991");
		communityCodeMap.put("411323001","410000005991");
		communityCodeMap.put("411323001","410000005991");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323303","410000005896");
		communityCodeMap.put("411323311","410000005884");
		communityCodeMap.put("411323107","410000005888");
		communityCodeMap.put("411323307","410000005892");
		communityCodeMap.put("411323104","");
		communityCodeMap.put("411323105","410000005902");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323103","410000005908");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323301","410000005910");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411323102","410000005894");
		communityCodeMap.put("411329107","410000006100");
		communityCodeMap.put("411329309","410000006106");
		communityCodeMap.put("411329307","410000006118");
		communityCodeMap.put("411329102","410000006112");
		communityCodeMap.put("411329103","410000006122");
		communityCodeMap.put("411329105","410000006104");
		communityCodeMap.put("411329303","410000006108");
		communityCodeMap.put("411329100","");
		communityCodeMap.put("411329001","");
		communityCodeMap.put("411329101","410000006110");
		communityCodeMap.put("411329104","410000006114");
		communityCodeMap.put("411329106","410000006116");
		communityCodeMap.put("411329108","410000006102");
		communityCodeMap.put("411329300","410000006120");
		communityCodeMap.put("411329305","410000006098");
		communityCodeMap.put("411324306","410000005916");
		communityCodeMap.put("411324315","");
		communityCodeMap.put("411324111","");
		communityCodeMap.put("411324314","");
		communityCodeMap.put("411324003","");
		communityCodeMap.put("411324104","");
		communityCodeMap.put("411324107","410000005912");
		communityCodeMap.put("411324110","410000005922");
		communityCodeMap.put("411324309","410000005948");
		communityCodeMap.put("411324001","411324001000");
		communityCodeMap.put("411324101","");
		communityCodeMap.put("411324106","");
		communityCodeMap.put("411324102","");
		communityCodeMap.put("411324108","");
		communityCodeMap.put("411324310","410000005926");
		communityCodeMap.put("411324002","");
		communityCodeMap.put("411324103","");
		communityCodeMap.put("411324109","");
		communityCodeMap.put("411324301","410000005950");
		communityCodeMap.put("411324303","410000005952");
		communityCodeMap.put("411324313","");
		communityCodeMap.put("411324105","410000005940");
		communityCodeMap.put("411326002","");
		communityCodeMap.put("411326304","410000006006");
		communityCodeMap.put("411326111","410000005990");
		communityCodeMap.put("411326301","410000005998");
		communityCodeMap.put("411326302","410000005992");
		communityCodeMap.put("411326110","410000006010");
		communityCodeMap.put("411326001","");
		communityCodeMap.put("411326101","");
		communityCodeMap.put("411326102","410000006004");
		communityCodeMap.put("411326103","410000006000");
		communityCodeMap.put("411326105","410000005988");
		communityCodeMap.put("411326106","410000006014");
		communityCodeMap.put("411326108","410000006016");
		communityCodeMap.put("411326109","410000006018");
		communityCodeMap.put("411326303","410000006008");
		communityCodeMap.put("411326104","410000005994");
		communityCodeMap.put("411326107","410000006012");
		
		
		communityCodeMap.put("411381109001","");
		communityCodeMap.put("411381318001","410000006170");
		communityCodeMap.put("411381319001","410000006182");
		communityCodeMap.put("411381102001","");
		communityCodeMap.put("411381106001","");
		communityCodeMap.put("411381301001","410000006174");
		communityCodeMap.put("411381320001","410000006206");
		communityCodeMap.put("411381108001","410000006198");
		communityCodeMap.put("411381112001","");
		communityCodeMap.put("411381304001","410000006190");
		communityCodeMap.put("411381310001","");
		communityCodeMap.put("411381311001","410000006158");
		communityCodeMap.put("411381002001","");
		communityCodeMap.put("411381104001","");
		communityCodeMap.put("411381105001","410000006178");
		communityCodeMap.put("411381107001","");
		communityCodeMap.put("411381114001","410000006204");
		communityCodeMap.put("411381302001","410000006186");
		communityCodeMap.put("411381313001","410000006176");
		communityCodeMap.put("411381001001","");
		communityCodeMap.put("411381003001","");
		communityCodeMap.put("411381103001","410000006180");
		communityCodeMap.put("411381110001","410000006162");
		communityCodeMap.put("411381111001","");
		communityCodeMap.put("411381305001","410000006192");
		communityCodeMap.put("411381316001","410000006172");
		communityCodeMap.put("411381113001","410000006168");
		communityCodeMap.put("411322101200","");
		communityCodeMap.put("411322300001","410000101004");
		communityCodeMap.put("411322106200","410000174034");
		communityCodeMap.put("411322106205","410000100952");
		communityCodeMap.put("411322106206","410000100930");
		communityCodeMap.put("411322106222","410000174030");
		communityCodeMap.put("411322106224","410000101304");
		communityCodeMap.put("411322106237","411322106237");
		communityCodeMap.put("411322106238","410000174032");
		communityCodeMap.put("411322101201","410000173936");
		communityCodeMap.put("411322101205","410000101166");
		communityCodeMap.put("411322101210","");
		communityCodeMap.put("411322101243","410000173880");
		communityCodeMap.put("411322101241","410000101156");
		communityCodeMap.put("411322101230","410000173908");
		communityCodeMap.put("411322101226","410000173904");
		communityCodeMap.put("411322101225","410000173906");
		communityCodeMap.put("411322103200","");
		communityCodeMap.put("411322103208","410000100888");
		communityCodeMap.put("411322103210","");
		communityCodeMap.put("411322103231","410000173750");
		communityCodeMap.put("411322103230","");
		communityCodeMap.put("411322103228","410000173788");
		communityCodeMap.put("411322103215","410000173784");
		communityCodeMap.put("411322300203","410000101003");
		communityCodeMap.put("411322300206","410000173808");
		communityCodeMap.put("411322300217","410000173814");
		communityCodeMap.put("411322300219","410000100982");
		communityCodeMap.put("411322300220","410000101000");
		communityCodeMap.put("411322300221","410000100996");
		communityCodeMap.put("411322300226","");
		communityCodeMap.put("411322300232","");
		communityCodeMap.put("411322105223","");
		communityCodeMap.put("411322105224","410000174020");
		communityCodeMap.put("411322302211","410000173620");
		communityCodeMap.put("411322302214","410000173614");
		communityCodeMap.put("411322106207","410000100936");
		communityCodeMap.put("411322106212","411322106212");
		communityCodeMap.put("411322106216","410000100944");
		communityCodeMap.put("411322106217","410000100904");
		communityCodeMap.put("411322106218","410000100924");
		communityCodeMap.put("411322106220","410000100920");
		communityCodeMap.put("411322106223","410000100946");
		communityCodeMap.put("411322106226","");
		communityCodeMap.put("411322106229","411322106229");
		communityCodeMap.put("411322106239","410000100918");
		communityCodeMap.put("411322303210","410000101214");
		communityCodeMap.put("411322303236","410000101220");
		communityCodeMap.put("411322303241","410000101296");
		communityCodeMap.put("411322303242","410000173708");
		communityCodeMap.put("411322304208","");
		communityCodeMap.put("411322304211","410000100764");
		communityCodeMap.put("411322304216","410000173940");
		communityCodeMap.put("411322304226","410000173964");
		communityCodeMap.put("411322304235","410000173948");
		communityCodeMap.put("411322310202","310002");
		communityCodeMap.put("411322310205","");
		communityCodeMap.put("411322310206","310005");
		communityCodeMap.put("411322310207","");
		communityCodeMap.put("411322310214","");
		communityCodeMap.put("411322310222","");
		communityCodeMap.put("411322310224","");
		communityCodeMap.put("411322310230","");
		communityCodeMap.put("411322310234","");
		communityCodeMap.put("411322102200","410000100858");
		communityCodeMap.put("411322102206","411322100000");
		communityCodeMap.put("411322102215","410000100816");
		communityCodeMap.put("411322102216","410000173846");
		communityCodeMap.put("411322102235","410000100868");
		communityCodeMap.put("411322102237","");
		communityCodeMap.put("411322102238","411322100001");
		communityCodeMap.put("411322102239","410000173856");
		communityCodeMap.put("411322102249","");
		communityCodeMap.put("411322104203","410000173634");
		communityCodeMap.put("411322104214","410000173688");
		communityCodeMap.put("411322104232","");
		communityCodeMap.put("411322104233","410000173678");
		communityCodeMap.put("411322104234","410000173638");
		communityCodeMap.put("411322104235","");
		communityCodeMap.put("411322105203","410000100798");
		communityCodeMap.put("411322105204","410000101274");
		communityCodeMap.put("411322105207","410000100778");
		communityCodeMap.put("411322105208","410000101294");
		communityCodeMap.put("411322306206","410000166086");
		communityCodeMap.put("411322306218","410000166118");
		communityCodeMap.put("411322306226","410000166052");
		communityCodeMap.put("411322301217","410000101124");
		communityCodeMap.put("411322301227","410000101126");
		communityCodeMap.put("411322301231","410000101318");
		communityCodeMap.put("411322309209","410000101022");
		communityCodeMap.put("411322309213","410000101036");
		communityCodeMap.put("411322311202","410000166696");
		communityCodeMap.put("411322311209","410000101210");
		communityCodeMap.put("411322106201","410000100906");
		communityCodeMap.put("411322106204","410000100938");
		communityCodeMap.put("411322106208","");
		communityCodeMap.put("411322106211","410000100926");
		communityCodeMap.put("411322106213","411322106213");
		communityCodeMap.put("411322106219","");
		communityCodeMap.put("411322106233","410000100912");
		communityCodeMap.put("411322106234","411322106234");
		communityCodeMap.put("411322106236","410000100922");
		communityCodeMap.put("411322101209","410000173926");
		communityCodeMap.put("411322101232","410000173886");
		communityCodeMap.put("411322101227","410000173910");
		communityCodeMap.put("411322103205","410000100878");
		communityCodeMap.put("411322103226","410000100894");
		communityCodeMap.put("411322103224","410000100902");
		communityCodeMap.put("411322103214","410000100884");
		communityCodeMap.put("411322103211","410000173782");
		communityCodeMap.put("411322300212","410000173822");
		communityCodeMap.put("411322300218","");
		communityCodeMap.put("411322104200","410000173632");
		communityCodeMap.put("411322104204","");
		communityCodeMap.put("411322104206","");
		communityCodeMap.put("411322104215","410000173666");
		communityCodeMap.put("411322104216","410000173662");
		communityCodeMap.put("411322104217","410000100978");
		communityCodeMap.put("411322104218","410000173690");
		communityCodeMap.put("411322104224","410000173660");
		communityCodeMap.put("411322104225","");
		communityCodeMap.put("411322104226","");
		communityCodeMap.put("411322104227","410000173654");
		communityCodeMap.put("411322104228","410000100966");
		communityCodeMap.put("411322104229","");
		communityCodeMap.put("411322104230","410000100954");
		communityCodeMap.put("411322105201","410000100776");
		communityCodeMap.put("411322105226","410000101292");
		communityCodeMap.put("411322105230","410000100786");
		communityCodeMap.put("411322105233","410000101266");
		communityCodeMap.put("411322105235","");
		communityCodeMap.put("411322105238","410000100788");
		communityCodeMap.put("411322105239","410000101342");
		communityCodeMap.put("411322105243","");
		communityCodeMap.put("411322105244","410000101280");
		communityCodeMap.put("411322302209","");
		communityCodeMap.put("411322302216","410000101078");
		communityCodeMap.put("411322302220","410000101086");
		communityCodeMap.put("411322302225","410000101072");
		communityCodeMap.put("411322302226","410000101098");
		communityCodeMap.put("411322306233","");
		communityCodeMap.put("411322306235","410000166110");
		communityCodeMap.put("411322301203","410000101118");
		communityCodeMap.put("411322301204","410000101128");
		communityCodeMap.put("411322301206","410000101094");
		communityCodeMap.put("411322301208","410000101116");
		communityCodeMap.put("411322301221","410000101104");
		communityCodeMap.put("411322101202","410000173930");
		communityCodeMap.put("411322101207","410000101164");
		communityCodeMap.put("411322101213","410000173890");
		communityCodeMap.put("411322101235","");
		communityCodeMap.put("411322101234","410000173874");
		communityCodeMap.put("411322101233","410000173876");
		communityCodeMap.put("411322101224","410000173902");
		communityCodeMap.put("411322101223","411322101223");
		communityCodeMap.put("411322101222","410000173898");
		communityCodeMap.put("411322101221","410000173896");
		communityCodeMap.put("411322101220","410000173894");
		communityCodeMap.put("411322101219","410000173920");
		communityCodeMap.put("411322101218","410000173918");
		communityCodeMap.put("411322103203","410000173764");
		communityCodeMap.put("411322103232","410000100900");
		communityCodeMap.put("411322103222","410000100880");
		communityCodeMap.put("411322300211","410000173834");
		communityCodeMap.put("411322300214","410000100972");
		communityCodeMap.put("411322300223","410000173824");
		communityCodeMap.put("411322300228","");
		communityCodeMap.put("411322300230","");
		communityCodeMap.put("411322303203","410000173722");
		communityCodeMap.put("411322303207","410000101228");
		communityCodeMap.put("411322303211","410000173706");
		communityCodeMap.put("411322303212","410000173722");
		communityCodeMap.put("411322303216","410000101254");
		communityCodeMap.put("411322303218","410000101328");
		communityCodeMap.put("411322303232","410000173718");
		communityCodeMap.put("411322303233","410000101216");
		communityCodeMap.put("411322303234","410000101252");
		communityCodeMap.put("411322303235","410000173702");
		communityCodeMap.put("411322303237","");
		communityCodeMap.put("411322303239","410000101334");
		communityCodeMap.put("411322303240","410000101368");
		communityCodeMap.put("411322304201","410000174000");
		communityCodeMap.put("411322304203","");
		communityCodeMap.put("411322304205","410000173980");
		communityCodeMap.put("411322304212","410000101358");
		communityCodeMap.put("411322304219","");
		communityCodeMap.put("411322304220","410000173974");
		communityCodeMap.put("411322304222","410000173970");
		communityCodeMap.put("411322304225","410000100754");
		communityCodeMap.put("411322304227","410000173976");
		communityCodeMap.put("411322304230","410000173960");
		communityCodeMap.put("411322304232","410000100756");
		communityCodeMap.put("411322304237","410000173950");
		communityCodeMap.put("411322304238","");
		communityCodeMap.put("411322304239","410000173946");
		communityCodeMap.put("411322310201","310001");
		communityCodeMap.put("411322310208","310004");
		communityCodeMap.put("411322310209","");
		communityCodeMap.put("411322310211","310008");
		communityCodeMap.put("411322310213","310011");
		communityCodeMap.put("411322310216","");
		communityCodeMap.put("411322310219","");
		communityCodeMap.put("411322310221","");
		communityCodeMap.put("411322310225","310016");
		communityCodeMap.put("411322310228","");
		communityCodeMap.put("411322310231","410000101186");
		communityCodeMap.put("411322310236","310020");
		communityCodeMap.put("411322310238","");
		communityCodeMap.put("411322102204","410000100822");
		communityCodeMap.put("411322102211","410000173740");
		communityCodeMap.put("411322102212","410000100832");
		communityCodeMap.put("411322102213","410000100828");
		communityCodeMap.put("411322102214","");
		communityCodeMap.put("411322102219","410000100854");
		communityCodeMap.put("411322102222","410000100860");
		communityCodeMap.put("411322102226","410000100836");
		communityCodeMap.put("411322102227","410000100842");
		communityCodeMap.put("411322102231","");
		communityCodeMap.put("411322102233","410000100866");
		communityCodeMap.put("411322102236","");
		communityCodeMap.put("411322102241","");
		communityCodeMap.put("411322102244","410000100844");
		communityCodeMap.put("411322102250","");
		communityCodeMap.put("411322102248","410000173738");
		communityCodeMap.put("411322102246","410000100850");
		communityCodeMap.put("411322104201","");
		communityCodeMap.put("411322104207","410000173674");
		communityCodeMap.put("411322104208","410000173684");
		communityCodeMap.put("411322104210","410000173650");
		communityCodeMap.put("411322104212","410000100962");
		communityCodeMap.put("411322104219","410000173642");
		communityCodeMap.put("411322104221","");
		communityCodeMap.put("411322104223","410000173686");
		communityCodeMap.put("411322104231","410000173644");
		communityCodeMap.put("411322104236","410000173646");
		communityCodeMap.put("411322104238","410000100984");
		communityCodeMap.put("411322104240","");
		communityCodeMap.put("411322104241","410000100960");
		communityCodeMap.put("411322105200","410000174012");
		communityCodeMap.put("411322105205","410000101264");
		communityCodeMap.put("411322105211","410000101282");
		communityCodeMap.put("411322105214","410000100790");
		communityCodeMap.put("411322105215","410000100802");
		communityCodeMap.put("411322105218","410000101290");
		communityCodeMap.put("411322105228","410000101346");
		communityCodeMap.put("411322105231","410000101288");
		communityCodeMap.put("411322105232","410000101272");
		communityCodeMap.put("411322105241","410000101270");
		communityCodeMap.put("411322105242","410000100792");
		communityCodeMap.put("411322105245","410000100794");
		communityCodeMap.put("411322105246","410000100796");
		communityCodeMap.put("411322105247","410000174010");
		communityCodeMap.put("411322302201","410000101088");
		communityCodeMap.put("411322302212","410000101108");
		communityCodeMap.put("411322302213","411322081317");
		communityCodeMap.put("411322302221","410000173604");
		communityCodeMap.put("411322302223","410000173608");
		communityCodeMap.put("411322106209","410000100940");
		communityCodeMap.put("411322106228","410000174036");
		communityCodeMap.put("411322106235","");
		communityCodeMap.put("411322101206","410000173934");
		communityCodeMap.put("411322101211","410000173892");
		communityCodeMap.put("411322101237","410000173882");
		communityCodeMap.put("411322101236","410000173868");
		communityCodeMap.put("411322101231","410000101158");
		communityCodeMap.put("411322103233","410000173770");
		communityCodeMap.put("411322103229","410000173748");
		communityCodeMap.put("411322103223","410000173768");
		communityCodeMap.put("411322103217","410000100890");
		communityCodeMap.put("411322103213","410000100896");
		communityCodeMap.put("411322300204","410000173840");
		communityCodeMap.put("411322300205","410000173804");
		communityCodeMap.put("411322300207","");
		communityCodeMap.put("411322300213","410000173802");
		communityCodeMap.put("411322300222","");
		communityCodeMap.put("411322300233","410000100998");
		communityCodeMap.put("411322300234","410000173806");
		communityCodeMap.put("411322303201","410000173710");
		communityCodeMap.put("411322303204","410000173720");
		communityCodeMap.put("411322303205","410000101238");
		communityCodeMap.put("411322303208","410000101218");
		communityCodeMap.put("411322303209","410000101240");
		communityCodeMap.put("411322303213","410000101246");
		communityCodeMap.put("411322303214","410000101236");
		communityCodeMap.put("411322303215","");
		communityCodeMap.put("411322303219","410000101258");
		communityCodeMap.put("411322303220","410000173724");
		communityCodeMap.put("411322303221","410000101340");
		communityCodeMap.put("411322303222","410000101298");
		communityCodeMap.put("411322304202","");
		communityCodeMap.put("411322304204","410000100758");
		communityCodeMap.put("411322304207","410000100768");
		communityCodeMap.put("411322304214","410000173938");
		communityCodeMap.put("411322304217","410000173942");
		communityCodeMap.put("411322304218","410000174006");
		communityCodeMap.put("411322304228","410000173962");
		communityCodeMap.put("411322304236","410000173952");
		communityCodeMap.put("411322304240","410000173944");
		communityCodeMap.put("411322310215","");
		communityCodeMap.put("411322310217","410000101194");
		communityCodeMap.put("411322310218","");
		communityCodeMap.put("411322310226","410000101174");
		communityCodeMap.put("411322310227","");
		communityCodeMap.put("411322102205","410000100824");
		communityCodeMap.put("411322102208","");
		communityCodeMap.put("411322102209","410000173850");
		communityCodeMap.put("411322102217","410000173798");
		communityCodeMap.put("411322102218","410000100826");
		communityCodeMap.put("411322102220","");
		communityCodeMap.put("411322102224","410000173736");
		communityCodeMap.put("411322102229","410000100820");
		communityCodeMap.put("411322102230","410000100838");
		communityCodeMap.put("411322102234","410000173858");
		communityCodeMap.put("411322102240","410000100870");
		communityCodeMap.put("411322102242","410000100852");
		communityCodeMap.put("411322102243","410000100856");
		communityCodeMap.put("411322102245","410000100846");
		communityCodeMap.put("411322105210","410000174018");
		communityCodeMap.put("411322105227","410000100800");
		communityCodeMap.put("411322106202","410000100942");
		communityCodeMap.put("411322106210","410000100932");
		communityCodeMap.put("411322106215","410000100916");
		communityCodeMap.put("411322106225","411322106225");
		communityCodeMap.put("411322106227","");
		communityCodeMap.put("411322106230","410000101360");
		communityCodeMap.put("411322106232","411322106232");
		communityCodeMap.put("411322101238","410000173866");
		communityCodeMap.put("411322101229","410000173914");
		communityCodeMap.put("411322103201","410000173776");
		communityCodeMap.put("411322103207","410000173760");
		communityCodeMap.put("411322103209","");
		communityCodeMap.put("411322103218","410000173780");
		communityCodeMap.put("411322103216","410000173786");
		communityCodeMap.put("411322103212","410000173766");
		communityCodeMap.put("411322300210","410000173838");
		communityCodeMap.put("411322300227","410000100994");
		communityCodeMap.put("411322300236","");
		communityCodeMap.put("411322303206","");
		communityCodeMap.put("411322303217","410000101330");
		communityCodeMap.put("411322303238","410000101224");
		communityCodeMap.put("411322304206","410000173982");
		communityCodeMap.put("411322304210","410000100750");
		communityCodeMap.put("411322304213","410000173978");
		communityCodeMap.put("411322304215","410000100762");
		communityCodeMap.put("411322304223","410000173968");
		communityCodeMap.put("411322304224","");
		communityCodeMap.put("411322304229","410000173956");
		communityCodeMap.put("411322304231","410000173958");
		communityCodeMap.put("411322304233","410000100766");
		communityCodeMap.put("411322304234","410000173954");
		communityCodeMap.put("411322310203","");
		communityCodeMap.put("411322310204","");
		communityCodeMap.put("411322310210","411322310210");
		communityCodeMap.put("411322310220","410000101182");
		communityCodeMap.put("411322310232","310021");
		communityCodeMap.put("411322310235","");
		communityCodeMap.put("411322310237","");
		communityCodeMap.put("411322102202","410000100872");
		communityCodeMap.put("411322102210","410000173860");
		communityCodeMap.put("411322102221","410000100818");
		communityCodeMap.put("411322102228","410000100840");
		communityCodeMap.put("411322102232","410000173800");
		communityCodeMap.put("411322102247","");
		communityCodeMap.put("411322105234","410000100808");
		communityCodeMap.put("411322105237","410000101262");
		communityCodeMap.put("411322105240","410000174024");
		communityCodeMap.put("411322302203","410000101084");
		communityCodeMap.put("411322302204","");
		communityCodeMap.put("411322302207","410000173624");
		communityCodeMap.put("411322302208","410000173622");
		communityCodeMap.put("411322302215","410000101082");
		communityCodeMap.put("411322302217","410000101076");
		communityCodeMap.put("411322302224","410000173600");
		communityCodeMap.put("411322302227","410000101074");
		communityCodeMap.put("411322306201","410000165860");
		communityCodeMap.put("411322306208","410000166070");
		communityCodeMap.put("411322306210","410000166004");
		communityCodeMap.put("411322306214","410000101058");
		communityCodeMap.put("411322306215","410000165694");
		communityCodeMap.put("411322306232","410000101066");
		communityCodeMap.put("411322306236","410000166114");
		communityCodeMap.put("411322301201","410000101106");
		communityCodeMap.put("411322301207","410000101140");
		communityCodeMap.put("411322301218","");
		communityCodeMap.put("411322301219","410000101142");
		communityCodeMap.put("411322301223","410000101152");
		communityCodeMap.put("411322301224","410000101132");
		communityCodeMap.put("411322309203","410000101046");
		communityCodeMap.put("411322309210","411322309210");
		communityCodeMap.put("411322309215","410000101020");
		communityCodeMap.put("411322311205","410000166708");
		communityCodeMap.put("411322311206","410000101354");
		communityCodeMap.put("411322102223","410000100864");
		communityCodeMap.put("411322105202","");
		communityCodeMap.put("411322105206","410000101350");
		communityCodeMap.put("411322105209","410000101344");
		communityCodeMap.put("411322105212","410000100804");
		communityCodeMap.put("411322105213","410000174016");
		communityCodeMap.put("411322105217","410000100782");
		communityCodeMap.put("411322105220","410000100784");
		communityCodeMap.put("411322105222","410000174022");
		communityCodeMap.put("411322302202","410000101090");
		communityCodeMap.put("411322306216","410000166048");
		communityCodeMap.put("411322306217","");
		communityCodeMap.put("411322306227","410000166062");
		communityCodeMap.put("411322306228","410000166058");
		communityCodeMap.put("411322301229","410000101320");
		communityCodeMap.put("411322301233","410000101112");
		communityCodeMap.put("411322309206","410000101016");
		communityCodeMap.put("411322311201","410000166692");
		communityCodeMap.put("411322311208","410000166702");
		communityCodeMap.put("411322106203","410000100934");
		communityCodeMap.put("411322106214","410000100948");
		communityCodeMap.put("411322106221","410000100908");
		communityCodeMap.put("411322106231","410000174038");
		communityCodeMap.put("411322101203","411322101203");
		communityCodeMap.put("411322101204","410000173932");
		communityCodeMap.put("411322101208","410000173924");
		communityCodeMap.put("411322101212","410000101168");
		communityCodeMap.put("411322101242","410000173870");
		communityCodeMap.put("411322101240","410000173878");
		communityCodeMap.put("411322101239","410000173864");
		communityCodeMap.put("411322101228","410000173912");
		communityCodeMap.put("411322101217","410000173900");
		communityCodeMap.put("411322101216","410000173916");
		communityCodeMap.put("411322101215","410000101154");
		communityCodeMap.put("411322101214","410000173888");
		communityCodeMap.put("411322103202","410000173774");
		communityCodeMap.put("411322103204","");
		communityCodeMap.put("411322103206","410000173754");
		communityCodeMap.put("411322103234","410000173772");
		communityCodeMap.put("411322103227","410000100898");
		communityCodeMap.put("411322103225","411322103225");
		communityCodeMap.put("411322103221","");
		communityCodeMap.put("411322103220","410000100886");
		communityCodeMap.put("411322103219","410000173756");
		communityCodeMap.put("411322300202","410000101002");
		communityCodeMap.put("411322300208","410000101008");
		communityCodeMap.put("411322300209","");
		communityCodeMap.put("411322300215","410000173818");
		communityCodeMap.put("411322300216","410000173830");
		communityCodeMap.put("411322300224","410000100980");
		communityCodeMap.put("411322300225","410000173826");
		communityCodeMap.put("411322300229","");
		communityCodeMap.put("411322300231","410000101010");
		communityCodeMap.put("411322300235","410000100976");
		communityCodeMap.put("411322303202","410000173716");
		communityCodeMap.put("411322303223","");
		communityCodeMap.put("411322303224","410000101234");
		communityCodeMap.put("411322303225","410000101338");
		communityCodeMap.put("411322303226","410000101332");
		communityCodeMap.put("411322303227","410000101242");
		communityCodeMap.put("411322303228","410000101226");
		communityCodeMap.put("411322303229","");
		communityCodeMap.put("411322303230","410000101230");
		communityCodeMap.put("411322303231","410000101232");
		communityCodeMap.put("411322304209","410000100760");
		communityCodeMap.put("411322304221","410000173972");
		communityCodeMap.put("411322310212","310009");
		communityCodeMap.put("411322310223","");
		communityCodeMap.put("411322310229","410000101180");
		communityCodeMap.put("411322310233","410000101206");
		communityCodeMap.put("411322102201","410000100874");
		communityCodeMap.put("411322102203","410000173848");
		communityCodeMap.put("411322102207","410000101312");
		communityCodeMap.put("411322104202","410000173682");
		communityCodeMap.put("411322104205","410000100956");
		communityCodeMap.put("411322104209","410000173636");
		communityCodeMap.put("411322104211","410000173670");
		communityCodeMap.put("411322104213","410000173676");
		communityCodeMap.put("411322104220","");
		communityCodeMap.put("411322104222","410000173648");
		communityCodeMap.put("411322104237","410000173640");
		communityCodeMap.put("411322104239","410000173664");
		communityCodeMap.put("411322306222","410000166066");
		communityCodeMap.put("411322306224","410000101064");
		communityCodeMap.put("411322306230","410000101054");
		communityCodeMap.put("411322306231","410000101070");
		communityCodeMap.put("411322301228","410000101110");
		communityCodeMap.put("411322301232","410000101138");
		communityCodeMap.put("411322309205","410000101012");
		communityCodeMap.put("411322309208","410000101308");
		communityCodeMap.put("411322309212","411322309228");
		communityCodeMap.put("411322311207","");
		communityCodeMap.put("411322301214","410000101130");
		communityCodeMap.put("411322309202","411322309202");
		communityCodeMap.put("411322309204","410000101040");
		communityCodeMap.put("411322309222","410000101032");
		communityCodeMap.put("411322301226","410000173594");
		communityCodeMap.put("411322301230","410000101136");
		communityCodeMap.put("411322301234","410000101096");
		communityCodeMap.put("411322301236","410000101134");
		communityCodeMap.put("411322309207","411322309207");
		communityCodeMap.put("411322309211","410000101050");
		communityCodeMap.put("411322309214","");
		communityCodeMap.put("411322311203","410000101212");
		communityCodeMap.put("411322302210","410000173618");
		communityCodeMap.put("411322302228","");
		communityCodeMap.put("411322306202","");
		communityCodeMap.put("411322306203","410000166064");
		communityCodeMap.put("411322306204","410000166088");
		communityCodeMap.put("411322306205","410000165862");
		communityCodeMap.put("411322306207","410000166112");
		communityCodeMap.put("411322306209","410000101052");
		communityCodeMap.put("411322306211","410000166076");
		communityCodeMap.put("411322306212","410000166106");
		communityCodeMap.put("411322306213","410000166118");
		communityCodeMap.put("411322306219","410000166092");
		communityCodeMap.put("411322306220","");
		communityCodeMap.put("411322306221","410000101062");
		communityCodeMap.put("411322306223","410000166094");
		communityCodeMap.put("411322306225","410000166046");
		communityCodeMap.put("411322306229","410000101060");
		communityCodeMap.put("411322301213","410000101100");
		communityCodeMap.put("411322301215","");
		communityCodeMap.put("411322301220","410000101150");
		communityCodeMap.put("411322301225","410000101324");
		communityCodeMap.put("411322301235","410000101144");
		communityCodeMap.put("411322309201","410000101014");
		communityCodeMap.put("411322309217","411322309217");
		communityCodeMap.put("411322309219","410000101024");
		communityCodeMap.put("411322309220","410000101018");
		communityCodeMap.put("411322309224","");
		communityCodeMap.put("411322309225","411322309225");
		communityCodeMap.put("411322105216","410000174008");
		communityCodeMap.put("411322105219","410000101268");
		communityCodeMap.put("411322301211","");
		communityCodeMap.put("411322301212","410000101148");
		communityCodeMap.put("411322301216","");
		communityCodeMap.put("411322309216","410000101028");
		communityCodeMap.put("411322309218","410000101034");
		communityCodeMap.put("411322309221","411322309227");
		communityCodeMap.put("411322309223","410000173696");
		communityCodeMap.put("411322311204","410000101208");
		communityCodeMap.put("411322306234","");
		communityCodeMap.put("411322301202","410000101102");
		communityCodeMap.put("411322301205","410000101326");
		communityCodeMap.put("411322301209","410000101146");
		communityCodeMap.put("411322301210","");
		communityCodeMap.put("411322301222","410000173592");
		communityCodeMap.put("411322105221","410000101276");
		communityCodeMap.put("411322105225","410000174014");
		communityCodeMap.put("411322105229","410000100810");
		communityCodeMap.put("411322105236","");
		communityCodeMap.put("411322302205","410000173598");
		communityCodeMap.put("411322302206","410000173626");
		communityCodeMap.put("411322302218","410000173613");
		communityCodeMap.put("411322302219","410000173610");
		communityCodeMap.put("411322302222","410000173606");
		communityCodeMap.put("411321302201","");
		communityCodeMap.put("411321102001","410000005840");
		communityCodeMap.put("411321303213","");
		communityCodeMap.put("411321303216","");
		communityCodeMap.put("411321103212","");
		communityCodeMap.put("411321303206","");
		communityCodeMap.put("411321303214","");
		communityCodeMap.put("411321303208","");
		communityCodeMap.put("411321103202","");
		communityCodeMap.put("411321303204","");
		communityCodeMap.put("411321303209","");
		communityCodeMap.put("411321303218","");
		communityCodeMap.put("411321103211","");
		communityCodeMap.put("411321303212","");
		communityCodeMap.put("411321303215","");
		communityCodeMap.put("411321303203","");
		communityCodeMap.put("411321303202","");
		communityCodeMap.put("411321303205","");
		communityCodeMap.put("411321303210","");
		communityCodeMap.put("411321303211","");
		communityCodeMap.put("411321303217","");
		communityCodeMap.put("411321303219","");
		communityCodeMap.put("411321305001","410000005816");
		communityCodeMap.put("411321303201","");
		communityCodeMap.put("411321100001","411321100001");//南召县城关镇北外社区卫生室
		//communityCodeMap.put();//南召县城关镇西北社区卫生室
		communityCodeMap.put("411321100004","411321100004");//南召县城关镇中华社区卫生室
		communityCodeMap.put("411321100003","411321100003");//南召县城关镇东北社区卫生室
		communityCodeMap.put("411321100005","411321100005");//南召县城关镇民主社区卫生室
		communityCodeMap.put("411321100006","410000100654");//南召县城关镇南外社区卫生室
		communityCodeMap.put("411321100200","410000100036");//南召县城关镇沙坪村卫生室
		communityCodeMap.put("411321106001","410000005830");
		communityCodeMap.put("411321310001","410000005836");
		communityCodeMap.put("411321105001","410000005832");
		communityCodeMap.put("411321305207","410000100364");//四棵树乡白草垛村卫生室	
		communityCodeMap.put("411321305211","410000100390");
		communityCodeMap.put("411321305212","410000100380");//四棵树乡大柳树村卫生室
		communityCodeMap.put("411321305213","410000100382");
		communityCodeMap.put("411321305215","410000100386");
		communityCodeMap.put("411321305216","");
		communityCodeMap.put("411321305219","410000100388");
		communityCodeMap.put("411321305220","410000100346");
		communityCodeMap.put("411321305223","410000100376");
		communityCodeMap.put("411321305225","410000100384");
		communityCodeMap.put("411321107001","410000005842");
		communityCodeMap.put("411321304001","410000005822");
		communityCodeMap.put("411321305205","410000100362");//四棵树乡三岔口村卫生室
		communityCodeMap.put("411321305206","410000100374");
		communityCodeMap.put("411321305209","410000100348");
		communityCodeMap.put("411321305214","410000100686");
		communityCodeMap.put("411321305221","410000100356");
		communityCodeMap.put("411321103001","410000005820");
		communityCodeMap.put("411321104001","410000005826");//南河店杨湾村;南河店龙王庙村
		communityCodeMap.put("411321300001","410000005844");
		communityCodeMap.put("411321301001","410000005818");
		communityCodeMap.put("411321302001","");
		communityCodeMap.put("411321308001","410000005838");
		communityCodeMap.put("411321305201","410000100372");
		communityCodeMap.put("411321305202","410000100368");//四棵树乡华庄村卫生室
		communityCodeMap.put("411321305203","410000100392");
		communityCodeMap.put("411321305204","410000100350");
		communityCodeMap.put("411321305208","");
		communityCodeMap.put("411321305210","410000100352");
		communityCodeMap.put("411321305217","410000100370");
		communityCodeMap.put("411321305218","410000100354");
		communityCodeMap.put("411321305222","410000100378");
		communityCodeMap.put("411321305224","410000100710");
		communityCodeMap.put("411321101001","");
		communityCodeMap.put("411321303207","");
		communityCodeMap.put("411325100205","411325100205");
		communityCodeMap.put("411325108204","411325108KAT");
		communityCodeMap.put("411325108206","411325108KAJ");
		communityCodeMap.put("411325108207","410000178312");
		communityCodeMap.put("411325108221","411325108KAO");
		communityCodeMap.put("411325108212","411325108KAP");//前马村
		communityCodeMap.put("411325308001","");
		communityCodeMap.put("411325108202","411325108KB4");
		communityCodeMap.put("411325108223","411325108KAK");
		communityCodeMap.put("411325108210","410000178320");
		communityCodeMap.put("411325108220","411325108KB0");
		communityCodeMap.put("411325108218","411325108KB2");
		communityCodeMap.put("411325100004","411325100001");//县衙居委会卫生所
		communityCodeMap.put("411325100005","411325100004");//西城居委会
		communityCodeMap.put("411325100200","411325100KAC");//东风居委会
		communityCodeMap.put("411325100201","411325100KAJ");//书院村
		communityCodeMap.put("411325100204","411325100204");
		communityCodeMap.put("411325307209","411325307KAR");
		communityCodeMap.put("411325108200","411325108KAR");
		communityCodeMap.put("411325108219","411325108219");
		communityCodeMap.put("411325307202","411325307KAL");//南阳内乡县余关乡王沟村卫生所
		communityCodeMap.put("411325108214","411325108KAD");
		communityCodeMap.put("411325108224","410000178306");
		communityCodeMap.put("411325108222","411325108KAW");
		communityCodeMap.put("411325108211","411325108KAI");
		communityCodeMap.put("411325307206","411325307KAF");//南阳内乡县余关乡李沟村卫生所
		communityCodeMap.put("411325108205","410000178304");
		communityCodeMap.put("411325108217","411325108KB5");//杨寨村
		communityCodeMap.put("411325307216","411325307KAB");
		communityCodeMap.put("411325108201","411325108KAS");
		communityCodeMap.put("411325108208","411325108KAL");
		communityCodeMap.put("411325108209","410000178316");
		communityCodeMap.put("411325307211","411325307KAA");
		communityCodeMap.put("411325108216","411325108KB6");
		communityCodeMap.put("411325307217","");
		communityCodeMap.put("411325100003","411325100002");//内乡县卫生局城关镇卫生院县衙居委会
		communityCodeMap.put("411325100007","411325100006");//商城居委会
		communityCodeMap.put("411325307210","411325307KAG");
		communityCodeMap.put("411325100006","411325100005");//北城居委会
		communityCodeMap.put("411325100202","411325100KAH");//清真寺村
		communityCodeMap.put("411325307204","");
		communityCodeMap.put("411325307207","411325307KAM");//余关乡谢寨村
		communityCodeMap.put("411325307212","411325307KAI");
		communityCodeMap.put("411325307215","411325307KAC");
		communityCodeMap.put("411325307201","411325307KAN");
		communityCodeMap.put("411325307213","411325307KAJ");
		communityCodeMap.put("411325100203","411325100KAM");//黉学村
		communityCodeMap.put("411325102001","");
		communityCodeMap.put("411325106011","410000005968");
		communityCodeMap.put("411325306001","410000005976");
		communityCodeMap.put("411325309001","");
		communityCodeMap.put("411325108203","411325108KAG");
		communityCodeMap.put("411325108213","411325108KAA");
		communityCodeMap.put("411325108215","411325108KAV");
		communityCodeMap.put("411325307203","411325307203");//余关乡大桦岭村
		communityCodeMap.put("411325307205","411325307KAQ");
		communityCodeMap.put("411325307214","410000177044");
		communityCodeMap.put("411325307218","410000177050");
		communityCodeMap.put("411325307208","411325307KAD");
		communityCodeMap.put("411325101001","");
		communityCodeMap.put("411325105001","");
		communityCodeMap.put("411325300001","410000005970");
		communityCodeMap.put("411325301001","410000005958");
		communityCodeMap.put("411325100001","410000005986");
		communityCodeMap.put("411325103001","");
		communityCodeMap.put("411325104001","410000005982");
		communityCodeMap.put("411325107001","410000005962");
		communityCodeMap.put("411325108001","");
		communityCodeMap.put("411325302001","410000005972");
		communityCodeMap.put("411325307001","410000005966");
		communityCodeMap.put("411327103001","410000006048");
		communityCodeMap.put("411327101001","410000006044");
		communityCodeMap.put("411327107001","410000006030");
		communityCodeMap.put("411327313001","410000006052");
		communityCodeMap.put("411327106001","410000006055");
		communityCodeMap.put("411327108001","410000006026");
		communityCodeMap.put("411327308001","410000006054");
		communityCodeMap.put("411327104001","410000006036");
		communityCodeMap.put("411327300001","410000006050");
		communityCodeMap.put("411327304001","");
		communityCodeMap.put("411327301001","");
		communityCodeMap.put("411327311001","");
		communityCodeMap.put("411327312001","410000006038");
		communityCodeMap.put("411327100001","410000006032");
		communityCodeMap.put("411327105001","410000006028");
		communityCodeMap.put("411328100001","");
		communityCodeMap.put("411328307001","410000006090");
		communityCodeMap.put("411328108001","410000006082");
		communityCodeMap.put("411328311001","410000006056");
		communityCodeMap.put("411328107001","410000006074");
		communityCodeMap.put("411328308001","");
		communityCodeMap.put("411328309001","410000006060");
		communityCodeMap.put("411328104001","410000006072");
		communityCodeMap.put("411328105001","410000006094");
		communityCodeMap.put("411328109001","410000006080");
		communityCodeMap.put("411328111001","410000006088");
		communityCodeMap.put("411328300001","410000006084");
		communityCodeMap.put("411328103001","410000006076");
		communityCodeMap.put("411328301001","410000006086");
		communityCodeMap.put("411328102001","410000006070");
		communityCodeMap.put("411328110001","410000006068");
		communityCodeMap.put("411328101001","410000006064");
		communityCodeMap.put("411328106001","410000006078");
		communityCodeMap.put("411328112001","410000006058");
		communityCodeMap.put("411328306001","410000006092");
		communityCodeMap.put("411328001001","");
		communityCodeMap.put("411330105001","410000006130");
		communityCodeMap.put("411330305001","410000006148");
		communityCodeMap.put("411330103001","410000006146");
		communityCodeMap.put("411330104001","410000006152");
		communityCodeMap.put("411330303001","410000006124");
		communityCodeMap.put("411330100001","410000151329");
		communityCodeMap.put("411330101001","410000006142");
		communityCodeMap.put("411330108001","410000006144");
		communityCodeMap.put("411330300001","410000006136");
		communityCodeMap.put("411330302001","410000006150");
		communityCodeMap.put("411330304001","410000006138");
		communityCodeMap.put("411330306001","410000006140");
		communityCodeMap.put("411330102001","410000006134");
		communityCodeMap.put("411330106001","410000006128");
		communityCodeMap.put("411330301001","410000006132");
		communityCodeMap.put("411330107001","410000006126");
		communityCodeMap.put("411302305211","411302305211");
		communityCodeMap.put("411302305215","411302305KAQ");
		communityCodeMap.put("411302305219","411302305KAH");
		communityCodeMap.put("411302305223","");
		communityCodeMap.put("411302102204","");
		communityCodeMap.put("411302102207","411302102KAQ");
		communityCodeMap.put("411302303220","411302303KAI");
		communityCodeMap.put("411302005203","");
		communityCodeMap.put("411302004003","");
		communityCodeMap.put("411302104205","411302104KAW");
		communityCodeMap.put("411302104207","411302104KB8");
		communityCodeMap.put("411302104214","411302104KB7");
		communityCodeMap.put("411302301204","411302301KAX");
		communityCodeMap.put("411302105203","411302105KAL");
		communityCodeMap.put("411302105217","411302105KAX");
		communityCodeMap.put("411302105219","411302105KAT");
		communityCodeMap.put("411302302207","411302302KAM");
		communityCodeMap.put("411302302208","411302302KAN");
		communityCodeMap.put("411302001004","");
		communityCodeMap.put("411302001015","");
		communityCodeMap.put("411302304206","411302304KAA");
		communityCodeMap.put("411302304208","411302304KAH");
		communityCodeMap.put("411302304217","");
		communityCodeMap.put("411302305202","411302305KAM");
		communityCodeMap.put("411302305203","411302305KAT");
		communityCodeMap.put("411302305207","411302305207");
		communityCodeMap.put("411302305210","411302305KAC");
		communityCodeMap.put("411302305214","411302305228");
		communityCodeMap.put("411302305216","411302305216");
		communityCodeMap.put("411302305220","411302305KAB");
		communityCodeMap.put("411302104001","411302104KBG");
		communityCodeMap.put("411302104210","411302104KBF");
		communityCodeMap.put("411302104221","411302104KB1");
		communityCodeMap.put("411302301207","411302301KAN");
		communityCodeMap.put("411302306215","411302306KBO");
		communityCodeMap.put("411302399397","");
		communityCodeMap.put("411302399390","");
		communityCodeMap.put("411302399382","");
		communityCodeMap.put("411302399377","");
		communityCodeMap.put("411302399369","");
		communityCodeMap.put("411302103002","");
		communityCodeMap.put("411302103203","411302103KBF");
		communityCodeMap.put("411302103204","");
		communityCodeMap.put("411302103214","411302103KBI");
		communityCodeMap.put("411302105202","");
		communityCodeMap.put("411302105206","411302105KB1");
		communityCodeMap.put("411302105209","411302105KAG");
		communityCodeMap.put("411302302204","411302302KAK");
		communityCodeMap.put("411302302205","411302302KAL");
		communityCodeMap.put("411302302214","411302302KAE");
		communityCodeMap.put("411302302215","411302302KAS");
		communityCodeMap.put("411302302216","411302302KAD");
		communityCodeMap.put("411302001020","");
		communityCodeMap.put("411302304201","411302304KAO");
		communityCodeMap.put("411302304202","411302304KAE");
		communityCodeMap.put("411302304203","411302304KAD");
		communityCodeMap.put("411302304204","411302304KAL");
		communityCodeMap.put("411302304205","411302304KAP");
		communityCodeMap.put("411302305201","411302305227");
		communityCodeMap.put("411302305204","411302305204");
		communityCodeMap.put("411302305205","411302305KAI");
		communityCodeMap.put("411302305209","411302305226");
		communityCodeMap.put("411302305212","411302305KAU");
		communityCodeMap.put("411302305213","411302305KAF");
		communityCodeMap.put("411302305218","411302305218");
		communityCodeMap.put("411302305221","411302305221");
		communityCodeMap.put("411302305222","411302305KAP");
		communityCodeMap.put("411302104200","411302104KAL");
		communityCodeMap.put("411302104202","411302104KBH");
		communityCodeMap.put("411302104212","411302104KAC");
		communityCodeMap.put("411302104220","411302104KB4");
		communityCodeMap.put("411302104224","");
		communityCodeMap.put("411302306219","411302306KBR");
		communityCodeMap.put("411302399399","");
		communityCodeMap.put("411302399393","");
		communityCodeMap.put("411302399392","");
		communityCodeMap.put("411302399373","");
		communityCodeMap.put("411302105204","411302105KAN");
		communityCodeMap.put("411302105218","411302105KAV");
		communityCodeMap.put("411302001006","");
		communityCodeMap.put("411302001014","");
		communityCodeMap.put("411302001016","");
		communityCodeMap.put("411302305206","411302305206");
		communityCodeMap.put("411302305208","411302305KAY");
		communityCodeMap.put("411302301218","411302301KAH");
		communityCodeMap.put("411302306205","411302306KAW");
		communityCodeMap.put("411302306207","411302306KHZC");
		communityCodeMap.put("411302306211","411302306KBT");
		communityCodeMap.put("411302306213","");
		communityCodeMap.put("411302306220","411302306KAR");
		communityCodeMap.put("411302306222","411302306KBG");
		communityCodeMap.put("411302399396","");
		communityCodeMap.put("411302399387","");
		communityCodeMap.put("411302399376","");
		communityCodeMap.put("411302399372","");
		communityCodeMap.put("411302399371","");
		communityCodeMap.put("411302103001","");
		communityCodeMap.put("411302103207","411302103207");
		communityCodeMap.put("411302103208","");
		communityCodeMap.put("411302103215","411302103KBJ");
		communityCodeMap.put("411302105216","411302105KAZ");
		communityCodeMap.put("411302302203","411302302KAA");
		communityCodeMap.put("411302001001","");
		communityCodeMap.put("411302001002","");
		communityCodeMap.put("411302001005","");
		communityCodeMap.put("411302001007","");
		communityCodeMap.put("411302001012","");
		communityCodeMap.put("411302001013","");
		communityCodeMap.put("411302001017","");
		communityCodeMap.put("411302304209","411302304KAM");
		communityCodeMap.put("411302304210","411302304KAB");
		communityCodeMap.put("411302304211","411302304KAQ");
		communityCodeMap.put("411302304212","411302304KAK");
		communityCodeMap.put("411302304213","411302304KAJ");
		communityCodeMap.put("411302304214","411302304KAF");
		communityCodeMap.put("411302304215","411302304KAN");
		communityCodeMap.put("411302304216","411302304KAG");
		communityCodeMap.put("411302305217","411302305KAV");
		communityCodeMap.put("411302104201","411302104KAR");
		communityCodeMap.put("411302104209","411302104KAF");
		communityCodeMap.put("411302104222","411302104KB6");
		communityCodeMap.put("411302104223","411302104KBI");
		communityCodeMap.put("411302301202","");
		communityCodeMap.put("411302301208","411302301KAI");
		communityCodeMap.put("411302301215","");
		communityCodeMap.put("411302301220","411302301KB3");
		communityCodeMap.put("411302306212","411302306KB7");
		communityCodeMap.put("411302306216","411302306KBV");
		communityCodeMap.put("411302399398","");
		communityCodeMap.put("411302399391","");
		communityCodeMap.put("411302399389","");
		communityCodeMap.put("411302399386","");
		communityCodeMap.put("411302399385","");
		communityCodeMap.put("411302399384","");
		communityCodeMap.put("411302399383","");
		communityCodeMap.put("411302399381","");
		communityCodeMap.put("411302399380","");
		communityCodeMap.put("411302399379","");
		communityCodeMap.put("411302399375","");
		communityCodeMap.put("411302399374","");
		communityCodeMap.put("411302103202","411302103KAX");
		communityCodeMap.put("411302103220","411302103KAF");
		communityCodeMap.put("411302105215","411302105KAY");
		communityCodeMap.put("411302302202","411302302KAO");
		communityCodeMap.put("411302001003","");
		communityCodeMap.put("411302001009","");
		communityCodeMap.put("411302001011","");
		communityCodeMap.put("411302001018","");
		communityCodeMap.put("411302306223","411302306KAV");
		communityCodeMap.put("411302399378","");
		communityCodeMap.put("411302399370","");
		communityCodeMap.put("411302103209","411302103KAN");
		communityCodeMap.put("411302103212","411302103KAD");
		communityCodeMap.put("411302105205","");
		communityCodeMap.put("411302105207","411302105KB0");
		communityCodeMap.put("411302105208","411302105KAW");
		communityCodeMap.put("411302302206","411302302KAR");
		communityCodeMap.put("411302302209","411302302KAI");
		communityCodeMap.put("411302302211","411302302KAB");
		communityCodeMap.put("411302302213","411302302KAQ");
		communityCodeMap.put("411302001008","");
		communityCodeMap.put("411302001010","");
		communityCodeMap.put("411302001019","");
		communityCodeMap.put("411302304207","");
		communityCodeMap.put("411302102206","411302102KAA");
		communityCodeMap.put("411302104208","411302104KB5");
		communityCodeMap.put("411302104215","");
		communityCodeMap.put("411302301206","");
		communityCodeMap.put("411302301219","411302301KB2");
		communityCodeMap.put("411302306202","");
		communityCodeMap.put("411302306206","411302306KAB");
		communityCodeMap.put("411302103205","411302103KAP");
		communityCodeMap.put("411302103216","411302103KAQ");
		communityCodeMap.put("411302103218","411302103KBC");
		communityCodeMap.put("411302105210","411302105KAB");
		communityCodeMap.put("411302105211","411302105KAD");
		communityCodeMap.put("411302105212","");
		communityCodeMap.put("411302105213","411302105KAI");
		communityCodeMap.put("411302302210","411302302KAP");
		communityCodeMap.put("411302302212","411302302KAF");
		communityCodeMap.put("411302006014","");
		communityCodeMap.put("411302104211","411302104KAD");
		communityCodeMap.put("411302104217","411302104KAS");
		communityCodeMap.put("411302104218","411302104KB3");
		communityCodeMap.put("411302301201","411302301KAJ");
		communityCodeMap.put("411302301203","411302301KAV");
		communityCodeMap.put("411302301211","411302301KAO");
		communityCodeMap.put("411302301212","411302301KB4");
		communityCodeMap.put("411302301213","411302301KAD");
		communityCodeMap.put("411302301214","411302301KAU");
		communityCodeMap.put("411302301216","411302301KAT");
		communityCodeMap.put("411302306208","411302306KBD");
		communityCodeMap.put("411302306209","411302306KBC");
		communityCodeMap.put("411302306210","411302306KB6");
		communityCodeMap.put("411302306217","411302306KB3");
		communityCodeMap.put("411302306221","411302306KBE");
		communityCodeMap.put("411302399395","");
		communityCodeMap.put("411302399394","");
		communityCodeMap.put("411302399388","");
		communityCodeMap.put("411302103206","411302103KAE");
		communityCodeMap.put("411302103210","411302103KAZ");
		communityCodeMap.put("411302103211","411302103GDM");
		communityCodeMap.put("411302103213","411302103KBA");
		communityCodeMap.put("411302103217","411302103LZC");
		communityCodeMap.put("411302103219","411302103KAA");
		communityCodeMap.put("411302105200","411302105KAF");
		communityCodeMap.put("411302105201","411302105KAC");
		communityCodeMap.put("411302105214","411302105KAJ");
		communityCodeMap.put("411302302201","411302302KAG");
		communityCodeMap.put("411302006013","");
		communityCodeMap.put("411302104206","411302104KB9");
		communityCodeMap.put("411302301209","411302301KB6");
		communityCodeMap.put("411302102202","411302102KAL");
		communityCodeMap.put("411302102213","411302102KAB");
		communityCodeMap.put("411302102214","411302102KAO");
		communityCodeMap.put("411302102218","411302102KS");
		communityCodeMap.put("411302102223","411302102KAV");
		communityCodeMap.put("411302102219","411302102KAT");
		communityCodeMap.put("411302303201","411302303KAA");
		communityCodeMap.put("411302303203","411302303KAO");
		communityCodeMap.put("411302303204","411302303KAP");
		communityCodeMap.put("411302303206","411302303KAG");
		communityCodeMap.put("411302303207","411302303KAJ");
		communityCodeMap.put("411302303208","411302303KAQ");
		communityCodeMap.put("411302303210","411302303KAR");
		communityCodeMap.put("411302303215","411302303KAK");
		communityCodeMap.put("411302303217","411302303KAU");
		communityCodeMap.put("411302303218","411302303KAC");
		communityCodeMap.put("411302102209","411302102KAM");
		communityCodeMap.put("411302102211","411302102KAN");
		communityCodeMap.put("411302102216","411302102KAF");
		communityCodeMap.put("411302303216","411302303KAM");
		communityCodeMap.put("411302303221","411302303KAV");
		communityCodeMap.put("411302303222","411302303KAF");
		communityCodeMap.put("411302303223","411302303KAW");
		communityCodeMap.put("411302003001","");
		communityCodeMap.put("411302003002","");
		communityCodeMap.put("411302003003","");
		communityCodeMap.put("411302003004","");
		communityCodeMap.put("411302003005","");
		communityCodeMap.put("411302003006","");
		communityCodeMap.put("411302003007","");
		communityCodeMap.put("411302003008","");
		communityCodeMap.put("411302003009","");
		communityCodeMap.put("411302005001","");
		communityCodeMap.put("411302005002","");
		communityCodeMap.put("411302005003","");
		communityCodeMap.put("411302005005","");
		communityCodeMap.put("411302005201","");
		communityCodeMap.put("411302005202","");
		communityCodeMap.put("411302005204","");
		communityCodeMap.put("411302005207","");
		communityCodeMap.put("411302005209","");
		communityCodeMap.put("411302002001","");
		communityCodeMap.put("411302002003","");
		communityCodeMap.put("411302002004","");
		communityCodeMap.put("411302002007","");
		communityCodeMap.put("411302002008","");
		communityCodeMap.put("411302102210","411302102KAI");
		communityCodeMap.put("411302303209","411302303KAD");
		communityCodeMap.put("411302005206","");
		communityCodeMap.put("411302006012","");
		communityCodeMap.put("411302104203","");
		communityCodeMap.put("411302104204","411302104KAH");
		communityCodeMap.put("411302104213","411302104KB2");
		communityCodeMap.put("411302104216","411302104KB0");
		communityCodeMap.put("411302104219","411302104KAG");
		communityCodeMap.put("411302104225","");
		communityCodeMap.put("411302301205","411302301KB0");
		communityCodeMap.put("411302301210","411302301KAM");
		communityCodeMap.put("411302301217","411302301KB1");
		communityCodeMap.put("411302306201","");
		communityCodeMap.put("411302306203","411302306KAA");
		communityCodeMap.put("411302306204","411302306KB4");
		communityCodeMap.put("411302306214","");
		communityCodeMap.put("411302306218","411302306KAD");
		communityCodeMap.put("411302102205","411302102KAE");
		communityCodeMap.put("411302102208","411302102KAR");
		communityCodeMap.put("411302102212","411302102KAH");
		communityCodeMap.put("411302102215","411302102KAK");
		communityCodeMap.put("411302102220","411302102KAU");
		communityCodeMap.put("411302303211","411302303KAS");
		communityCodeMap.put("411302303212","411302303KAH");
		communityCodeMap.put("411302303213","411302303KAT");
		communityCodeMap.put("411302303219","411302303KAB");
		communityCodeMap.put("411302005004","");
		communityCodeMap.put("411302005205","");
		communityCodeMap.put("411302002006","");
		communityCodeMap.put("411302002009","");
		communityCodeMap.put("411302002010","");
		communityCodeMap.put("411302102200","411302102KAY");
		communityCodeMap.put("411302102222","411302102KAW");
		communityCodeMap.put("411302102221","411302102KAX");
		communityCodeMap.put("411302303202","411302303KAN");
		communityCodeMap.put("411302303205","411302303KAE");
		communityCodeMap.put("411302303214","411302303KAL");
		communityCodeMap.put("411302005208","");
		communityCodeMap.put("411302002002","");
		communityCodeMap.put("411302002005","");
		communityCodeMap.put("411302002011","");
		communityCodeMap.put("411302002012","");
		communityCodeMap.put("411302002013","");
		communityCodeMap.put("411302004001","");
		communityCodeMap.put("411302004002","");
		communityCodeMap.put("411302004004","");
		communityCodeMap.put("411302004005","");
		communityCodeMap.put("411302004006","");
		communityCodeMap.put("411302004007","");
		communityCodeMap.put("411302004008","");
		communityCodeMap.put("411302006001","");
		communityCodeMap.put("411302006002","");
		communityCodeMap.put("411302006003","");
		communityCodeMap.put("411302006004","");
		communityCodeMap.put("411302006005","");
		communityCodeMap.put("411302006006","");
		communityCodeMap.put("411302006007","");
		communityCodeMap.put("411302006008","");
		communityCodeMap.put("411302006009","");
		communityCodeMap.put("411302006010","");
		communityCodeMap.put("411302006011","");
		communityCodeMap.put("411302102001","");
		communityCodeMap.put("411302102002","");
		communityCodeMap.put("411302102003","");
		communityCodeMap.put("411302102201","411302102KAP");
		communityCodeMap.put("411303102201","");
		communityCodeMap.put("411303102202","");
		communityCodeMap.put("411303007002","");
		communityCodeMap.put("411303101200","411303101KB3");
		communityCodeMap.put("411303101201","411303101KAT");
		communityCodeMap.put("411303101207","411303101KB8");
		communityCodeMap.put("411303105204","411303105KAJ");
		communityCodeMap.put("411303105207","411303105KBI");
		communityCodeMap.put("411303105209","");
		communityCodeMap.put("411303105210","411303105KAH");
		communityCodeMap.put("411303105214","411303105KAC");
		communityCodeMap.put("411303105216","411303105KBB");
		communityCodeMap.put("411303105218","");
		communityCodeMap.put("411303105221","");
		communityCodeMap.put("411303105223","411303105KAR");
		communityCodeMap.put("411303300206","");
		communityCodeMap.put("411303300207","411303300KAT");
		communityCodeMap.put("411303300211","");
		communityCodeMap.put("411303306205","");
		communityCodeMap.put("411303306208","");
		communityCodeMap.put("411303306209","");
		communityCodeMap.put("411303003001","");
		communityCodeMap.put("411303003005","");
		communityCodeMap.put("411303003010","");
		communityCodeMap.put("411303006001","");
		communityCodeMap.put("411303006003","");
		communityCodeMap.put("411303103209","");
		communityCodeMap.put("411303103210","");
		communityCodeMap.put("411303103213","");
		communityCodeMap.put("411303061001","");
		communityCodeMap.put("411303061004","");
		communityCodeMap.put("411303061006","");
		communityCodeMap.put("411303061007","");
		communityCodeMap.put("411303061009","");
		communityCodeMap.put("411303307200","");
		communityCodeMap.put("411303307203","");
		communityCodeMap.put("411303307213","");
		communityCodeMap.put("411303307214","");
		communityCodeMap.put("411303307216","");
		communityCodeMap.put("411303305203","411303305KAG");
		communityCodeMap.put("411303305210","");
		communityCodeMap.put("411303305213","");
		communityCodeMap.put("411303305218","");
		communityCodeMap.put("411303002001","");
		communityCodeMap.put("411303002002","");
		communityCodeMap.put("411303002006","");
		communityCodeMap.put("411303002008","");
		communityCodeMap.put("411303002011","");
		communityCodeMap.put("411303008001","");
		communityCodeMap.put("411303008201","");
		communityCodeMap.put("411303008202","");
		communityCodeMap.put("411303102204","");
		communityCodeMap.put("411303102208","");
		communityCodeMap.put("411303102215","");
		communityCodeMap.put("411303102216","");
		communityCodeMap.put("411303102218","");
		communityCodeMap.put("411303102221","");
		communityCodeMap.put("411303102225","");
		communityCodeMap.put("411303106203","");
		communityCodeMap.put("411303106205","");
		communityCodeMap.put("411303106221","");
		communityCodeMap.put("411303106224","");
		communityCodeMap.put("411303107202","");
		communityCodeMap.put("411303107204","");
		communityCodeMap.put("411303107216","");
		communityCodeMap.put("411303107217","");
		communityCodeMap.put("411303107218","");
		communityCodeMap.put("411303107220","");
		communityCodeMap.put("411303107222","411303107KAI");
		communityCodeMap.put("411303107225","");
		communityCodeMap.put("411303107227","411303107KBD");
		communityCodeMap.put("411303305209","");
		communityCodeMap.put("411303002003","");
		communityCodeMap.put("411303002007","");
		communityCodeMap.put("411303002010","");
		communityCodeMap.put("411303008002","");
		communityCodeMap.put("411303008204","");
		communityCodeMap.put("411303300203","411303300KAQ");
		communityCodeMap.put("411303306203","");
		communityCodeMap.put("411303003007","");
		communityCodeMap.put("411303003009","");
		communityCodeMap.put("411303003011","");
		communityCodeMap.put("411303006002","");
		communityCodeMap.put("411303103203","411303103KB5");
		communityCodeMap.put("411303103211","");
		communityCodeMap.put("411303103214","");
		communityCodeMap.put("411303061008","");
		communityCodeMap.put("411303307201","");
		communityCodeMap.put("411303307202","");
		communityCodeMap.put("411303307211","");
		communityCodeMap.put("411303307212","");
		communityCodeMap.put("411303307215","");
		communityCodeMap.put("411303102200","");
		communityCodeMap.put("411303102205","");
		communityCodeMap.put("411303102206","");
		communityCodeMap.put("411303102207","");
		communityCodeMap.put("411303102209","");
		communityCodeMap.put("411303102211","");
		communityCodeMap.put("411303102212","");
		communityCodeMap.put("411303305205","");
		communityCodeMap.put("411303305216","");
		communityCodeMap.put("411303002005","");
		communityCodeMap.put("411303008203","");
		communityCodeMap.put("411303104205","411303104KAO");
		communityCodeMap.put("411303104207","411303104004");
		communityCodeMap.put("411303104208","");
		communityCodeMap.put("411303104219","411303104008");
		communityCodeMap.put("411303104221","");
		communityCodeMap.put("411303104224","411303104KAB");
		communityCodeMap.put("411303305200","411303305KAK");
		communityCodeMap.put("411303305206","");
		communityCodeMap.put("411303305215","");
		communityCodeMap.put("411303102210","");
		communityCodeMap.put("411303102217","");
		communityCodeMap.put("411303102219","");
		communityCodeMap.put("411303102220","");
		communityCodeMap.put("411303060006","");
		communityCodeMap.put("411303004002","");
		communityCodeMap.put("411303300201","");
		communityCodeMap.put("411303300204","");
		communityCodeMap.put("411303003006","");
		communityCodeMap.put("411303006006","");
		communityCodeMap.put("411303103202","");
		communityCodeMap.put("411303307207","");
		communityCodeMap.put("411303102213","");
		communityCodeMap.put("411303102224","");
		communityCodeMap.put("411303060001","");
		communityCodeMap.put("411303060004","");
		communityCodeMap.put("411303060005","");
		communityCodeMap.put("411303004004","");
		communityCodeMap.put("411303007001","");
		communityCodeMap.put("411303101202","411303101KB1");
		communityCodeMap.put("411303101203","411303101KB2");
		communityCodeMap.put("411303105215","411303105KB9");
		communityCodeMap.put("411303307205","");
		communityCodeMap.put("411303104204","");
		communityCodeMap.put("411303104206","411303104KB0");
		communityCodeMap.put("411303104210","411303104KAR");
		communityCodeMap.put("411303104211","411303104KB9");
		communityCodeMap.put("411303104212","411303104KB1");
		communityCodeMap.put("411303104220","");
		communityCodeMap.put("411303104225","");
		communityCodeMap.put("411303305204","");
		communityCodeMap.put("411303305212","");
		communityCodeMap.put("411303305217","");
		communityCodeMap.put("411303008205","");
		communityCodeMap.put("411303102214","");
		communityCodeMap.put("411303004006","");
		communityCodeMap.put("411303007007","");
		communityCodeMap.put("411303007008","");
		communityCodeMap.put("411303300200","");
		communityCodeMap.put("411303300208","411303300KAP");
		communityCodeMap.put("411303306206","");
		communityCodeMap.put("411303003003","");
		communityCodeMap.put("411303103207","");
		communityCodeMap.put("411303103212","411303103KB3");
		communityCodeMap.put("411303061003","");
		communityCodeMap.put("411303106213","");
		communityCodeMap.put("411303106215","");
		communityCodeMap.put("411303106219","");
		communityCodeMap.put("411303005003","");
		communityCodeMap.put("411303005004","");
		communityCodeMap.put("411303005006","");
		communityCodeMap.put("411303005007","");
		communityCodeMap.put("411303107207","");
		communityCodeMap.put("411303107211","");
		communityCodeMap.put("411303107212","");
		communityCodeMap.put("411303106210","");
		communityCodeMap.put("411303106211","");
		communityCodeMap.put("411303106212","");
		communityCodeMap.put("411303106214","");
		communityCodeMap.put("411303106218","");
		communityCodeMap.put("411303107203","");
		communityCodeMap.put("411303107206","");
		communityCodeMap.put("411303107208","41130310709");
		communityCodeMap.put("411303107209","");
		communityCodeMap.put("411303107210","");
		communityCodeMap.put("411303107214","");
		communityCodeMap.put("411303107219","");
		communityCodeMap.put("411303107221","");
		communityCodeMap.put("411303107223","");
		communityCodeMap.put("411303107226","");
		communityCodeMap.put("411303305207","");
		communityCodeMap.put("411303002004","");
		communityCodeMap.put("411303008200","");
		communityCodeMap.put("411303102203","");
		communityCodeMap.put("411303007003","");
		communityCodeMap.put("411303007009","");
		communityCodeMap.put("411303102226","");
		communityCodeMap.put("411303102227","");
		communityCodeMap.put("411303060002","");
		communityCodeMap.put("411303060003","");
		communityCodeMap.put("411303004001","");
		communityCodeMap.put("411303004003","");
		communityCodeMap.put("411303004005","");
		communityCodeMap.put("411303004007","");
		communityCodeMap.put("411303004200","");
		communityCodeMap.put("411303004201","");
		communityCodeMap.put("411303007004","");
		communityCodeMap.put("411303007005","");
		communityCodeMap.put("411303007006","");
		communityCodeMap.put("411303101204","411303101KAW");
		communityCodeMap.put("411303101206","411303101KAS");
		communityCodeMap.put("411303101208","411303101KAV");
		communityCodeMap.put("411303101209","411303101KAU");
		communityCodeMap.put("411303101210","");
		communityCodeMap.put("411303101211","411303101KB0");
		communityCodeMap.put("411303105205","411303105KAW");
		communityCodeMap.put("411303105206","411303105KBF");
		communityCodeMap.put("411303105208","411303105KAK");
		communityCodeMap.put("411303105211","411303105KAZ");
		communityCodeMap.put("411303105213","411303105KB3");
		communityCodeMap.put("411303105217","411303105KB7");
		communityCodeMap.put("411303105219","");
		communityCodeMap.put("411303105220","411303105KAO");
		communityCodeMap.put("411303105222","411303105KBK");
		communityCodeMap.put("411303300202","");
		communityCodeMap.put("411303300205","");
		communityCodeMap.put("411303306202","");
		communityCodeMap.put("411303306207","");
		communityCodeMap.put("411303003008","");
		communityCodeMap.put("411303006004","");
		communityCodeMap.put("411303103201","");
		communityCodeMap.put("411303103206","");
		communityCodeMap.put("411303103208","");
		communityCodeMap.put("411303061005","");
		communityCodeMap.put("411303307206","");
		communityCodeMap.put("411303307208","");
		communityCodeMap.put("411303307209","");
		communityCodeMap.put("411303307217","");
		communityCodeMap.put("411303104203","411303104011");
		communityCodeMap.put("411303003013","");
		communityCodeMap.put("411303006005","");
		communityCodeMap.put("411303006007","");
		communityCodeMap.put("411303103200","");
		communityCodeMap.put("411303103204","");
		communityCodeMap.put("411303103215","411303103KB3");
		communityCodeMap.put("411303061002","");
		communityCodeMap.put("411303307204","");
		communityCodeMap.put("411303104001","");
		communityCodeMap.put("411303104202","411303104KCA");
		communityCodeMap.put("411303104213","411303104KBH");
		communityCodeMap.put("411303104216","411303104KBX");
		communityCodeMap.put("411303104222","411303104KAH");
		communityCodeMap.put("411303104226","411303104KC8");
		communityCodeMap.put("411303104227","411303104KAG");
		communityCodeMap.put("411303106204","");
		communityCodeMap.put("411303106206","");
		communityCodeMap.put("411303106217","");
		communityCodeMap.put("411303106220","");
		communityCodeMap.put("411303106222","");
		communityCodeMap.put("411303106223","");
		communityCodeMap.put("411303005001","");
		communityCodeMap.put("411303005002","");
		communityCodeMap.put("411303005005","");
		communityCodeMap.put("411303107200","");
		communityCodeMap.put("411303107201","");
		communityCodeMap.put("411303107213","411303107KB8");
		communityCodeMap.put("411303107215","");
		communityCodeMap.put("411303107224","");
		communityCodeMap.put("411303305201","411303305KAJ");
		communityCodeMap.put("411303305202","");
		communityCodeMap.put("411303305214","");
		communityCodeMap.put("411303305219","");
		communityCodeMap.put("411303002009","");
		communityCodeMap.put("411303101205","411303101KAY");
		communityCodeMap.put("411303105200","411303105KB6");
		communityCodeMap.put("411303105201","");
		communityCodeMap.put("411303105202","");
		communityCodeMap.put("411303105203","411303105KB1");
		communityCodeMap.put("411303300210","");
		communityCodeMap.put("411303306200","");
		communityCodeMap.put("411303306204","");
		communityCodeMap.put("411303306210","");
		communityCodeMap.put("411303306211","");
		communityCodeMap.put("411303306212","");
		communityCodeMap.put("411303003002","");
		communityCodeMap.put("411303003004","");
		communityCodeMap.put("411303003012","");
		communityCodeMap.put("411303307210","");
		communityCodeMap.put("411303104200","411303104010");
		communityCodeMap.put("411303104201","411303104006");
		communityCodeMap.put("411303104214","411303104KBI");
		communityCodeMap.put("411303104215","411303106KB3");
		communityCodeMap.put("411303104217","411303104KBF");
		communityCodeMap.put("411303104218","411303104KBK");
		communityCodeMap.put("411303104223","411303104KBR");
		communityCodeMap.put("411303104228","411303104005");
		communityCodeMap.put("411303104229","411303104KAK");
		communityCodeMap.put("411303106200","");
		communityCodeMap.put("411303106201","");
		communityCodeMap.put("411303106202","");
		communityCodeMap.put("411303106207","");
		communityCodeMap.put("411303106208","");
		communityCodeMap.put("411303106209","");
		communityCodeMap.put("411323300214","");
		communityCodeMap.put("411323301201","411323301KAR");
		communityCodeMap.put("411323301202","");
		communityCodeMap.put("411323301203","");
		communityCodeMap.put("411323301204","");
		communityCodeMap.put("411323301205","");
		communityCodeMap.put("411323301206","");
		communityCodeMap.put("411323301214","411323301KAM");
		communityCodeMap.put("411323301215","411323301KAL");
		communityCodeMap.put("411323301216","");
		communityCodeMap.put("411323301217","");
		communityCodeMap.put("411323102201","411323102KAL");
		communityCodeMap.put("411323102202","411323102KAV");
		communityCodeMap.put("411323002004","");
		communityCodeMap.put("411323101001","");
		communityCodeMap.put("411323101204","");
		communityCodeMap.put("411323101217","");
		communityCodeMap.put("411323101219","411323101KAI");
		communityCodeMap.put("411323306219","");
		communityCodeMap.put("411323313202","411323313KAI");
		communityCodeMap.put("411323003001","");
		communityCodeMap.put("411323106212","411323106KAH");
		communityCodeMap.put("411323300201","411323300KAQ");
		communityCodeMap.put("411323300213","");
		communityCodeMap.put("411323300215","411323300KAN");
		communityCodeMap.put("411323102001","");
		communityCodeMap.put("411323102217","");
		communityCodeMap.put("411323101215","");
		communityCodeMap.put("411323106206","411323106KAX");
		communityCodeMap.put("411323106208","411323106KAC");
		communityCodeMap.put("411323106211","411323106KB0");
		communityCodeMap.put("411323106213","411323106KAY");
		communityCodeMap.put("411323101202","");
		communityCodeMap.put("411323101207","");
		communityCodeMap.put("411323101212","");
		communityCodeMap.put("411323306206","");
		communityCodeMap.put("411323306208","");
		communityCodeMap.put("411323306210","");
		communityCodeMap.put("411323306213","");
		communityCodeMap.put("411323314201","");
		communityCodeMap.put("411323313211","411323313KAH");
		communityCodeMap.put("411323106202","411323106KAK");
		communityCodeMap.put("411323103200","411323103KAT");
		communityCodeMap.put("411323103211","411323103KAS");
		communityCodeMap.put("411323103212","411323103KAC");
		communityCodeMap.put("411323103214","411323103KAR");
		communityCodeMap.put("411323103219","411323103KAW");
		communityCodeMap.put("411323103220","411323103KAB");
		communityCodeMap.put("411323103221","");
		communityCodeMap.put("411323002002","");
		communityCodeMap.put("411323103218","411323103KAG");
		communityCodeMap.put("411323301209","");
		communityCodeMap.put("411323301211","");
		communityCodeMap.put("411323101218","411323101KAK");
		communityCodeMap.put("411323101220","411323101KAH");
		communityCodeMap.put("411323101227","");
		communityCodeMap.put("411323101226","");
		communityCodeMap.put("411323101221","");
		communityCodeMap.put("411323306212","");
		communityCodeMap.put("411323306214","");
		communityCodeMap.put("411323306216","");
		communityCodeMap.put("411323309201","411323309KAJ");
		communityCodeMap.put("411323309203","411323309KAB");
		communityCodeMap.put("411323309206","411323309KAG");
		communityCodeMap.put("411323309208","411323309KAI");
		communityCodeMap.put("411323314203","");
		communityCodeMap.put("411323314205","");
		communityCodeMap.put("411323314207","");
		communityCodeMap.put("411323313201","411323313KAJ");
		communityCodeMap.put("411323313210","411323313KAE");
		communityCodeMap.put("411323106200","411323106KAN");
		communityCodeMap.put("411323106205","411323106KAL");
		communityCodeMap.put("411323106209","411323106KB1");
		communityCodeMap.put("411323106219","411323106KAG");
		communityCodeMap.put("411323103201","411323103KAD");
		communityCodeMap.put("411323103204","411323103KAP");
		communityCodeMap.put("411323103207","411323103KAQ");
		communityCodeMap.put("411323103209","");
		communityCodeMap.put("411323103216","411323103KAU");
		communityCodeMap.put("411323102204","411323102KAM");
		communityCodeMap.put("411323102207","411323102KAH");
		communityCodeMap.put("411323102208","411323102KAA");
		communityCodeMap.put("411323102209","411323102KAQ");
		communityCodeMap.put("411323102215","411323102KAD");
		communityCodeMap.put("411323102218","411323102KAT");
		communityCodeMap.put("411323002001","");
		communityCodeMap.put("411323101206","411323101KAW");
		communityCodeMap.put("411323101210","");
		communityCodeMap.put("411323101214","");
		communityCodeMap.put("411323101222","411323101KAB");
		communityCodeMap.put("411323306204","");
		communityCodeMap.put("411323314210","");
		communityCodeMap.put("411323313207","");
		communityCodeMap.put("411323106210","411323106KAV");
		communityCodeMap.put("411323106217","411323106KAA");
		communityCodeMap.put("411323106215","411323106KAJ");
		communityCodeMap.put("411323106214","411323106KAB");
		communityCodeMap.put("411323300212","");
		communityCodeMap.put("411323314206","");
		communityCodeMap.put("411323314208","");
		communityCodeMap.put("411323314209","");
		communityCodeMap.put("411323313203","411323313KAK");
		communityCodeMap.put("411323313204","411323313KAB");
		communityCodeMap.put("411323313205","411323313KAA");
		communityCodeMap.put("411323313209","411323313209");
		communityCodeMap.put("411323313212","411323313KAF");
		communityCodeMap.put("411323003002","");
		communityCodeMap.put("411323106201","411323106KAW");
		communityCodeMap.put("411323106203","411323106KAM");
		communityCodeMap.put("411323106204","411323106KB2");
		communityCodeMap.put("411323106207","");
		communityCodeMap.put("411323106218","");
		communityCodeMap.put("411323106216","");
		communityCodeMap.put("411323300202","");
		communityCodeMap.put("411323300203","");
		communityCodeMap.put("411323300204","411323300KAP");
		communityCodeMap.put("411323300206","");
		communityCodeMap.put("411323300208","");
		communityCodeMap.put("411323300210","411323300KAO");
		communityCodeMap.put("411323300217","");
		communityCodeMap.put("411323300219","");
		communityCodeMap.put("411323001004","");
		communityCodeMap.put("411323002003","");
		communityCodeMap.put("411323101200","");
		communityCodeMap.put("411323101201","411323101KAG");
		communityCodeMap.put("411323101203","411323101KB3");
		communityCodeMap.put("411323101205","");
		communityCodeMap.put("411323101208","411323101KB4");
		communityCodeMap.put("411323101209","411323101KB2");
		communityCodeMap.put("411323101211","411323101KAY");
		communityCodeMap.put("411323101216","411323101KAX");
		communityCodeMap.put("411323101225","");
		communityCodeMap.put("411323306201","");
		communityCodeMap.put("411323306202","");
		communityCodeMap.put("411323306205","");
		communityCodeMap.put("411323306207","");
		communityCodeMap.put("411323306209","");
		communityCodeMap.put("411323306211","");
		communityCodeMap.put("411323306215","");
		communityCodeMap.put("411323306217","");
		communityCodeMap.put("411323306218","");
		communityCodeMap.put("411323306220","");
		communityCodeMap.put("411323309202","411323309KAE");
		communityCodeMap.put("411323309204","411323309KAH");
		communityCodeMap.put("411323309205","");
		communityCodeMap.put("411323309207","411323309KAD");
		communityCodeMap.put("411323309209","411323309KAA");
		communityCodeMap.put("411323314202","");
		communityCodeMap.put("411323314204","");
		communityCodeMap.put("411323300207","");
		communityCodeMap.put("411323300209","");
		communityCodeMap.put("411323102216","");
		communityCodeMap.put("411323101213","411323101KAD");
		communityCodeMap.put("411323101224","");
		communityCodeMap.put("411323101223","");
		communityCodeMap.put("411323306203","");
		communityCodeMap.put("411323314211","");
		communityCodeMap.put("411323313206","411323313KAG");
		communityCodeMap.put("411323313208","411323313KAD");
		communityCodeMap.put("411323300205","");
		communityCodeMap.put("411323300211","");
		communityCodeMap.put("411323300216","");
		communityCodeMap.put("411323300218","");
		communityCodeMap.put("411323001001","");
		communityCodeMap.put("411323001002","");
		communityCodeMap.put("411323001003","");
		communityCodeMap.put("411323103203","411323103KAK");
		communityCodeMap.put("411323103205","411323103KAL");
		communityCodeMap.put("411323103206","411323103KAA");
		communityCodeMap.put("411323103208","");
		communityCodeMap.put("411323103210","411323103KAO");
		communityCodeMap.put("411323103215","411323103KAN");
		communityCodeMap.put("411323103217","411323103KAH");
		communityCodeMap.put("411323102214","");
		communityCodeMap.put("411323303001","410000005896");
		communityCodeMap.put("411323311001","410000005884");
		communityCodeMap.put("411323107001","410000005888");
		communityCodeMap.put("411323307001","410000005892");
		communityCodeMap.put("411323104001","");
		communityCodeMap.put("411323105001","410000005902");
		communityCodeMap.put("411323103202","411323103KAV");
		communityCodeMap.put("411323103213","");
		communityCodeMap.put("411323301207","");
		communityCodeMap.put("411323301208","");
		communityCodeMap.put("411323301210","");
		communityCodeMap.put("411323301212","");
		communityCodeMap.put("411323301213","");
		communityCodeMap.put("411323102200","");
		communityCodeMap.put("411323102203","411323102KAJ");
		communityCodeMap.put("411323102205","411323102KAG");
		communityCodeMap.put("411323102206","");
		communityCodeMap.put("411323102210","");
		communityCodeMap.put("411323102211","411323102KAS");
		communityCodeMap.put("411323102212","411323102KAP");
		communityCodeMap.put("411323102213","411323102KAC");
		communityCodeMap.put("411329107001","410000006100");
		communityCodeMap.put("411329309001","410000006106");
		communityCodeMap.put("411329307001","410000006118");
		communityCodeMap.put("411329102001","410000006112");
		communityCodeMap.put("411329103001","410000006122");
		communityCodeMap.put("411329105001","410000006104");
		communityCodeMap.put("411329303001","410000006108");
		communityCodeMap.put("411329100001","");
		communityCodeMap.put("411329001001","");
		communityCodeMap.put("411329101001","410000006110");
		communityCodeMap.put("411329104001","410000006114");
		communityCodeMap.put("411329106001","410000006116");
		communityCodeMap.put("411329108001","410000006102");
		communityCodeMap.put("411329300001","410000006120");
		communityCodeMap.put("411329305001","410000006098");
		communityCodeMap.put("411324306001","410000005916");
		communityCodeMap.put("411324315001","");
		communityCodeMap.put("411324111001","");
		communityCodeMap.put("411324314001","");
		communityCodeMap.put("411324003001","");
		communityCodeMap.put("411324104001","");
		communityCodeMap.put("411324107001","410000005912");
		communityCodeMap.put("411324110001","410000005922");
		communityCodeMap.put("411324309001","410000005948");
		communityCodeMap.put("411324001001","411324001000");
		communityCodeMap.put("411324101001","");
		communityCodeMap.put("411324106001","");
		communityCodeMap.put("411324102001","");
		communityCodeMap.put("411324108001","");
		communityCodeMap.put("411324310001","410000005926");
		communityCodeMap.put("411324002001","");
		communityCodeMap.put("411324103001","");
		communityCodeMap.put("411324109001","");
		communityCodeMap.put("411324301001","410000005950");
		communityCodeMap.put("411324303001","410000005952");
		communityCodeMap.put("411324313001","");
		communityCodeMap.put("411324105001","410000005940");
		communityCodeMap.put("411326002001","");
		communityCodeMap.put("411326304001","410000006006");
		communityCodeMap.put("411326111001","410000005990");
		communityCodeMap.put("411326301001","410000005998");
		communityCodeMap.put("411326302001","410000005992");
		communityCodeMap.put("411326110001","410000006010");
		communityCodeMap.put("411326001001","");
		communityCodeMap.put("411326101001","");
		communityCodeMap.put("411326102001","410000006004");
		communityCodeMap.put("411326103001","410000006000");
		communityCodeMap.put("411326105001","410000005988");
		communityCodeMap.put("411326106001","410000006014");
		communityCodeMap.put("411326108001","410000006016");
		communityCodeMap.put("411326109001","410000006018");
		communityCodeMap.put("411326303001","410000006008");
		communityCodeMap.put("411326104001","410000005994");
		communityCodeMap.put("411326107001","410000006012");
		communityCodeMap.put("411381320214","411381320KAU");
		communityCodeMap.put("411381320201","411381320KAL");//南阳邓州市九龙乡九龙村卫生所
		communityCodeMap.put("411381320205","411381320KAF");//河南省邓州市九龙乡邓岗村
		communityCodeMap.put("411381320200","410000006206");//九龙乡卫生院
		communityCodeMap.put("411325104205","410000176894");//南阳内乡县湍东镇张岗村卫生室
		communityCodeMap.put("411325104204","411325104KAM");//南阳内乡县湍东镇龙园村卫生所
		communityCodeMap.put("411325104203","411325104KAC");//南阳内乡县湍东镇东符营村卫生所
		communityCodeMap.put("411381320212","411381320KAW");//河南省邓州市九龙乡王营寨村  九龙王营寨村
		communityCodeMap.put("411325104211","411325104KAR");//湍东庞营村卫生室
		communityCodeMap.put("411325104200","411325104KAI");//南阳内乡县湍东镇江元村卫生室
		communityCodeMap.put("411325104206","411325104KAD");//南阳内乡县湍东镇东王沟村卫生所
		communityCodeMap.put("411321105214","410000100498");//南阳南召县板山坪镇松河村卫生室
		communityCodeMap.put("411325104202","411325104KB0");//南阳内乡县湍东镇下河村卫生所
		communityCodeMap.put("411325104210","411325104KB8");//湍东董堂村卫生室
		communityCodeMap.put("411325104209","411325104KAF");//湍东红堰河村卫生室
		communityCodeMap.put("411321107225","410000100442");//白土岗碾坪村卫生室
		communityCodeMap.put("411321107219","410000100446"); //白土岗瓦房庄村卫生室
		communityCodeMap.put("411325104215","411325104KB1");//湍东下洼村卫生室
		communityCodeMap.put("411325104225","411325104KAO");//湍东罗岗村卫生室
		communityCodeMap.put("411325104214","411325104KAB");//湍东茶庵村卫生室
		communityCodeMap.put("411325104216","411325104KAU");//湍东屈庄村卫生室
		communityCodeMap.put("411325104213","411325104KAY");//湍东五里堡村卫生室
		communityCodeMap.put("411325104212","411325104KAA");//湍东北符营村卫生室	
		communityCodeMap.put("411381104010","411326103KAB");//穰东镇北王营村卫生室
		communityCodeMap.put("411325104224","411325104KAK");//湍东龙头村卫生室
		communityCodeMap.put("411325104218", "411325104KB7");//湍东周洼村卫生室
		communityCodeMap.put("411325104217","411325104KAP");//湍东庙岗村卫生室
		communityCodeMap.put("411325104220","411325104KB6");//湍东赵沟村卫生室
		communityCodeMap.put("411325104222","411325104KAT");//湍东清凉庙村卫生室	
		communityCodeMap.put("411325104221","411325104KAH");//湍东花园村卫生室
		communityCodeMap.put("411325104219","411325104KAZ");//湍东西王营村卫生室
		communityCodeMap.put("411321105212","410000100534");//板山坪镇瓦房村
		communityCodeMap.put("411321105216","410000100522");//板山坪镇华山村
		communityCodeMap.put("411321105217","410000100508");//板山坪镇华阳宫村
		communityCodeMap.put("411325104208","411325104KB4");//湍东谢楼村卫生室	
		communityCodeMap.put("411325104207","411325104KAE");//湍东东王营村卫生室
		communityCodeMap.put("411321012001","410000008888");//南召县第二人民医院
		communityCodeMap.put("411321310223","410000100622");//崔庄乡粮食川村; 崔庄乡仓房村
		communityCodeMap.put("411321310220","410000100632");//崔庄乡韩庄村
		communityCodeMap.put("411321310222","410000100616");//崔庄乡山坪村
		communityCodeMap.put("411321310214","410000100606");//崔庄乡回龙沟
		communityCodeMap.put("411321310210","410000100618");//崔庄乡程家庄村;崔庄乡鱼池村
		communityCodeMap.put("411321107222","410000100482");//白土岗姬村卫生室
		communityCodeMap.put("411321107224","410000100444");//白土岗东沟村卫生室
		communityCodeMap.put("411321107226","410000100490");//白土岗杜村卫生室
		
	}

	@Override
	public void papreData(int pageIndex) {
		//data = "{\"pagePara\":{\"pageSize\":2,\"pageIndex\":" + pageIndex + "}}";	
		//data="<queryBaseInfoReqVO><pagePara><pageIndex>" + pageIndex + "</pageIndex><pageSize>20</pageSize></pagePara></queryBaseInfoReqVO>";
		//data="<queryBaseInfoReqVO><containLowerLevel>1</containLowerLevel><pagePara><pageIndex>" + pageIndex + "</pageIndex><pageSize>20</pageSize></pagePara></queryBaseInfoReqVO>";
		
		data="<queryBaseInfoReqVO><containLowerLevel>1</containLowerLevel><createdDateStart>" + startDate + "</createdDateStart><createdDateEnd>" + enDate +"</createdDateEnd><pagePara><pageIndex>" + pageIndex + "</pageIndex><pageSize>100</pageSize></pagePara></queryBaseInfoReqVO>";

	}
	
	@Override
	public boolean finish(String xml){
		Document docment = null;
		try {
			docment = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = docment.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator("baseInfos"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator it = recordEle.elementIterator("baseInfo");
				if(it.hasNext())
					return false;
				else 
					return true;
			}
		} catch (Exception e) {
			logger.error("parse xml is error :" + e.getMessage());
			e.printStackTrace();
		}
        return false;
	}
	
	@Override
	public void parser(String xml){
		String pageIndex = "";
		
		Document docment = null;
		try {
			docment = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = docment.getRootElement(); // 获取根节点
			Element pageParaE = rootElt.element("pagePara");
			if(pageParaE!=null){
				Element pageIndexE = pageParaE.element("pageIndex");
				pageIndex = pageIndexE!=null?pageIndexE.getText():"";
				logger.debug(pageIndex);
			}
			
			Iterator iter = rootElt.elementIterator("baseInfos"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next(); //baseInfos
				Iterator it = recordEle.elementIterator("baseInfo");
				while(it.hasNext()){
					Element baseinfo = (Element)it.next(); //baseInfo
					PersonHealthRecordMain pr = new PersonHealthRecordMain();
					
					Iterator itIllnessHistoryInfos = baseinfo.elementIterator("illnessHistoryInfos");
					while(itIllnessHistoryInfos.hasNext()){
						Element illnessHistoryInfos = (Element)itIllnessHistoryInfos.next();//illnessHistoryInfos
						Iterator itIllnessHistoryInfo = illnessHistoryInfos.elementIterator("illnessHistoryInfo");
						while(itIllnessHistoryInfo.hasNext()){
							Element illnessHistoryInfo = (Element)itIllnessHistoryInfo.next();//illnessHistoryInfo
							Element idE = illnessHistoryInfo.element("id");
							String id = idE!=null?idE.getText():"";
							Element archiveidE = illnessHistoryInfo.element("archiveid");
							String archiveid = archiveidE!=null?archiveidE.getText():"";
							Element illnesstypeE = illnessHistoryInfo.element("illnesstype");
							String illnesstype = illnesstypeE!=null?illnesstypeE.getText():"";
							Element illnessnameE = illnessHistoryInfo.element("illnessname");
							String illnessnam = illnessnameE!=null?illnessnameE.getText():"";
							Element theriomaE = illnessHistoryInfo.element("therioma"); 
							String therioma = theriomaE!=null?theriomaE.getText():"";
							Element illnessOtherE = illnessHistoryInfo.element("illnessOther"); 
							String illnessOther = illnessOtherE!=null?illnessOtherE.getText():"";
							Element diagnosetimeE = illnessHistoryInfo.element("diagnosetime"); 
							String diagnosetime = diagnosetimeE!=null?diagnosetimeE.getText():"";
						}
					}
					
					Element lifeEnvironment = baseinfo.element("lifeEnvironment");
					if(lifeEnvironment!=null){
						Element idE = lifeEnvironment.element("id");
						String id = idE!=null?idE.getText():"";
						
						Element archiveidE = lifeEnvironment.element("archiveid");
						String archiveid = archiveidE!=null?archiveidE.getText():"";
						
						Element blowmeasureE = lifeEnvironment.element("blowmeasure");
						String blowmeasure = blowmeasureE!=null?blowmeasureE.getText():"";
						pr.setKitchenName(blowmeasure(blowmeasure));
						
						Element fueltypeE = lifeEnvironment.element("fueltype");
						String fueltype = fueltypeE!=null?fueltypeE.getText():"";
						pr.setFuelTypeName(fueltype);
						
						Element drinkwaterE =  lifeEnvironment.element("drinkwater");
						String drinkwater = drinkwaterE!=null?drinkwaterE.getText():"";
						pr.setPhrDrinkName(drinkwater(drinkwater));
						
						Element toiletE = lifeEnvironment.element("toilet");
						String toilet = toiletE!=null?toiletE.getText():"";
						pr.setToiletName(toilet);
						
						Element livestockrailE = lifeEnvironment.element("livestockrailE");
						String livestockrail = livestockrailE!=null?livestockrailE.getText():"";
						pr.setLivestockName(livestockrail);
					}
					
					Element familyHistoryE = baseinfo.element("familyHistory");
					if(familyHistoryE!=null){
						Element idE = familyHistoryE.element("id");
						String id = idE!=null?idE.getText():"";
						Element archiveidE = familyHistoryE.element("archiveid");
						String archiveid = archiveidE!=null?archiveidE.getText():"";
						Element familytypeE = familyHistoryE.element("familytype");
						String familytype = familytypeE!=null?familytypeE.getText():"";
						Element fatherhistoryE = familyHistoryE.element("fatherhistory");
						String fatherhistory = fatherhistoryE!=null?fatherhistoryE.getText():"";
						Element fatherhistoryOtherE = familyHistoryE.element("fatherhistoryOther");
						String fatherhistoryOther = fatherhistoryOtherE!=null?fatherhistoryOtherE.getText():"";
						Element motherhistoryE = familyHistoryE.element("motherhistory");
						String motherhistory = motherhistoryE!=null?motherhistoryE.getText():"";
						Element motherhistoryOtherE = familyHistoryE.element("motherhistoryOther");
						String motherhistoryOther = motherhistoryOtherE!=null?motherhistoryOtherE.getText():"";
						Element brothersisterhistoryE = familyHistoryE.element("brothersisterhistory");
						String brothersisterhistory = brothersisterhistoryE!=null?brothersisterhistoryE.getText():"";
						Element brothersisterhistoryOtherE = familyHistoryE.element("brothersisterhistoryOther");
						String brothersisterhistoryOther = brothersisterhistoryOtherE!=null?brothersisterhistoryOtherE.getText():"";
						Element childrenhistoryE = familyHistoryE.element("childrenhistory");
						String childrenhistory = childrenhistoryE!=null?childrenhistoryE.getText():"";
						Element childrenhistoryOtherE = familyHistoryE.element("childrenhistoryOther");
						String childrenhistoryOther = childrenhistoryOtherE!=null?childrenhistoryOtherE.getText():"";
					}
					
					Element orgProvinceCodeE = baseinfo.element("orgProvinceCode");
					String orgProvinceCode = orgProvinceCodeE!=null?orgProvinceCodeE.getText():"";
					
					Element orgCityCodeE = baseinfo.element("orgCityCode");
					String orgCityCode = orgCityCodeE!=null?orgCityCodeE.getText():"";
					
					Element orgDistinctCodeE = baseinfo.element("orgDistinctCode");
					String orgDistinctCode = orgDistinctCodeE!=null?orgDistinctCodeE.getText():"";
					
					Element orgTownCodeE = baseinfo.element("orgTownCode");
					String orgTownCode = orgTownCodeE!=null?orgTownCodeE.getText():"";
					
					Element orgVillageCodeE = baseinfo.element("orgVillageCode");
					String orgVillageCode = orgVillageCodeE!=null?orgVillageCodeE.getText():"";
					pr.setCommunityCode(communityCode(orgProvinceCode,orgCityCode,orgDistinctCode,orgTownCode,orgVillageCode));
					
					Element idE = baseinfo.element("id");
					String id = idE!=null?idE.getText():"";
					pr.setPersonRowId(id);
					
					Element archiveidE = baseinfo.element("archiveid");
					String archiveid = archiveidE!=null?archiveidE.getText():"";
					pr.setPersonCode(archiveid);
					
					Element fyArchiveidE = baseinfo.element("fyArchiveid");
					String fyArchiveid = fyArchiveidE!=null?fyArchiveidE.getText():"";
					pr.setFamilyRowId(fyArchiveid);
					
					Element workunitE = baseinfo.element("workunit");
					String workunit = workunitE!=null?workunitE.getText():"";
					pr.setWorkPlace(workunit);
					
					Element livetypeE = baseinfo.element("livetype");
					String livetype = livetypeE!=null?livetypeE.getText():"";
					
					Element nationE = baseinfo.element("nation");
					String nation = nationE!=null?nationE.getText():"";
					pr.setNationDR(nation(nation));
					
					Element rhE = baseinfo.element("rh");
					String rh = rhE!=null?rhE.getText():"";
					pr.setRHBloodType(rh);
					
					Element cultureE = baseinfo.element("culture");
					String culture = cultureE!=null?cultureE.getText():"";
					pr.setEducationDR(culture(culture));
					
					Element jobE = baseinfo.element("job");
					String job = jobE!=null?jobE.getText():"";
					pr.setProfessionDR(job(job));
					
					Element maritalstatusE = baseinfo.element("maritalstatus");
					String maritalstatus = maritalstatusE!=null?maritalstatusE.getText():"";
					pr.setMarriageDR(maritalstatus(maritalstatus));
					
					Element medicalpaytypeE = baseinfo.element("medicalpaytype");
					String medicalpaytype = medicalpaytypeE!=null?medicalpaytypeE.getText():"";
					pr.setMedicalInsuranceTypeDR(medicalpaytype);
					
					Element pillallergicE = baseinfo.element("pillallergic");
					String pillallergic = pillallergicE!=null?pillallergicE.getText():"";
					
					Element diseaseE = baseinfo.element("disease");
					String disease = diseaseE!=null?diseaseE.getText():"";
					
					Element diseasenditionE = baseinfo.element("diseasendition");
					String diseasendition = diseasenditionE!=null?diseasenditionE.getText():"";
					
					Element customernameE = baseinfo.element("customername");
					String customername = customernameE!=null?customernameE.getText():"";
					pr.setPersonName(customername);
					
					Element doctorE = baseinfo.element("doctor");
					String doctor = doctorE!=null?doctorE.getText():"";
					pr.setDoctorRegister(doctor);
					
					Element sexE = baseinfo.element("sex");
					String sex = sexE!=null?sexE.getText():"";
					pr.setSexDR(sex);
					
					Element birthdayE = baseinfo.element("birthday");
					String birthday = birthdayE!=null?birthdayE.getText():"";
					pr.setBirth(birthday);
					
					Element contactnameE = baseinfo.element("contactname");
					String contactname = contactnameE!=null?contactnameE.getText():"";
					pr.setLinkManName(contactname);
					
					Element contactphoneE = baseinfo.element("contactphone");
					String contactphone = contactphoneE!=null?contactphoneE.getText():"";
					pr.setLinkManPhone(contactphone);
					
					Element bloodtypeE = baseinfo.element("bloodtype");
					String bloodtype = bloodtypeE!=null?bloodtypeE.getText():"";
					pr.setBloodTypeDR(bloodtype);
					
					Element idcardE = baseinfo.element("idcard");
					String idcard = idcardE!=null?idcardE.getText():"";
					pr.setIDCard(idcard);
					
					Element phoneE = baseinfo.element("phone");
					String phone = phoneE!=null?phoneE.getText():"";
					pr.setWorkPlacePhone(phone);
					
					Element medicalpaytypeOtherE = baseinfo.element("medicalpaytypeOther");
					String medicalpaytypeOther = medicalpaytypeOtherE!=null?medicalpaytypeOtherE.getText():"";
					
					Element pillallergicOtherE = baseinfo.element("pillallergicOther");
					String pillallergicOther = pillallergicOtherE!=null?pillallergicOtherE.getText():"";
					
					Element diseaseExE = baseinfo.element("diseaseEx");
					String diseaseEx = diseaseExE!=null?diseaseExE.getText():"";
					
					Element diseasenditionExE = baseinfo.element("diseasenditionEx");
					String diseasenditionEx = diseasenditionExE!=null?diseasenditionExE.getText():"";
					
					Element addrE = baseinfo.element("addr");
					String addr = addrE!=null?addrE.getText():"";
					
					Element householdAddrE = baseinfo.element("householdAddr");
					String householdAddr = householdAddrE!=null?householdAddrE.getText():"";
					pr.setBirthPlace(householdAddr);
					
					Element createunitE = baseinfo.element("createunit");
					String createunit = createunitE!=null?createunitE.getText():"";
					pr.setCollectPerson(createunit);
					
					Element minorityE = baseinfo.element("minority");
					String minority = minorityE!=null?minorityE.getText():"";
					
					Element exposureE = baseinfo.element("exposure");
					String exposure = exposureE!=null?exposureE.getText():"";
					
					Element createdByE = baseinfo.element("createdBy");
					String createdBy = createdByE!=null?createdByE.getText():"";
					
					Element createdDateE = baseinfo.element("createdDate");
					String createdDate = createdDateE!=null?createdDateE.getText():"";
					pr.setDateRegister(createdDate);
					
					Element lastUpdateByE = baseinfo.element("lastUpdateBy");
					String lastUpdateBy = lastUpdateByE!=null?lastUpdateByE.getText():"";
					pr.setOperatorInput(lastUpdateBy);
					
					Element lastUpdateDateE = baseinfo.element("lastUpdateDate");
					String lastUpdateDate = lastUpdateDateE!=null?lastUpdateDateE.getText():"";
					pr.setDateInput(lastUpdateDate);

					Element populationTypeE = baseinfo.element("populationType");
					String populationType = populationTypeE!=null?populationTypeE.getText():"";
					
					Element isDelE = baseinfo.element("isDel");
					String isDel = isDelE!=null?isDelE.getText():"";
					
					Element houseRelationE = baseinfo.element("houseRelation");
					String houseRelation = houseRelationE!=null?houseRelationE.getText():"";
					pr.setRelationHourseHoldDR(relationHourseHoldDR(houseRelation));
					
					Element houseRealOtherE = baseinfo.element("houseRealOther");
					String houseRealOther = houseRealOtherE!=null?houseRealOtherE.getText():"";
					
					Element emailE = baseinfo.element("email");
					String email = emailE!=null?emailE.getText():"";
					pr.setPersonEmail(email);
					
					Element orgProvinceIdE = baseinfo.element("orgProvinceId");
					String orgProvinceId = orgProvinceIdE!=null?orgProvinceIdE.getText():"";
					
					Element orgCityIdE = baseinfo.element("orgCityId");
					String orgCityId = orgCityIdE!=null?orgCityIdE.getText():"";
					
					Element provinceIdE = baseinfo.element("provinceId");
					String provinceId = provinceIdE!=null?provinceIdE.getText():"";
					
					Element cityIdE = baseinfo.element("cityId");
					String cityId = cityIdE!=null?cityIdE.getText():"";
					
					Element districtIdE = baseinfo.element("districtId");
					String districtId = districtIdE!=null?districtIdE.getText():"";
					
					Element townIdE = baseinfo.element("townId");
					String townId = townIdE!=null?townIdE.getText():"";
					
					Element villageIdE = baseinfo.element("villageId");
					String villageId = villageIdE!=null?villageIdE.getText():"";
								
					Element provinceCodeE = baseinfo.element("provinceCode");
					String provinceCode = provinceCodeE!=null?provinceCodeE.getText():"";
					
					pr.setProvinceDR(provinceCode(provinceCode));	
					pr.setCityDR(cityCode(canton.getCode(openId, cityId, "city")));
					pr.setSectionDR(distinctCode( canton.getCode(openId, districtId, "district") ));
					pr.setStreetDR(townCode( canton.getCode(openId, townId, "town") ));
					pr.setVillageDR(villageCode( canton.getCode(openId, villageId, "village") ));
					
					/**
					Element cityCodeE = baseinfo.element("cityCode");
					String cityCode = cityCodeE!=null?cityCodeE.getText():"";
					pr.setCityDR(cityCode(cityCode));
					
					Element distinctCodeE = baseinfo.element("distinctCode");
					String distinctCode = distinctCodeE!=null?distinctCodeE.getText():"";
					pr.setSectionDR(distinctCode(distinctCode));
					
					Element townCodeE = baseinfo.element("townCode");
					String townCode = townCodeE!=null?townCodeE.getText():"";
					pr.setStreetDR(townCode(townCode));
					
					Element villageCodeE = baseinfo.element("villageCode");
					String villageCode = villageCodeE!=null?villageCodeE.getText():"";
					pr.setVillageDR(villageCode(villageCode));
					**/
					
					pr.setIDCardTypeDR("01");
					pr.setNationalityDR("CN");
					writeTxt(pr);
				}
					
			}
		} catch (Exception e) {
			logger.error("parse xml is error :" + e.getMessage());
			e.printStackTrace();
		}
		
		FileUtil.writefile(sourceDir + openId + "_" + startDate.substring(0, 10) + "_" + enDate.substring(0, 10) + "_" +pageIndex + ".txt", xml, false);
	}
	
//	@Override
//	public void down(){
//		boolean flag = false;
//		int i = 1;
//		while(!flag){
//			String paramStr = userGet(i);
//			String result = URLUtil.getResult(url, paramStr);
//			logger.debug(result);
//			flag = finish(result);
//			if(!flag)
//				parser(result);
//			i++;
//		}
//	}
	
//	//机构编码
//	private String communityCode(String orgProvinceCode,String orgCityCode,String orgDistinctCode,String orgTownCode,String orgVillageCode){
//		String str = "";
//		if(!orgTownCode.trim().equals("")){
//			//select * from CHSS.DictHospital where CommunityType='乡镇卫生院' and streetcode='411322106'
//			return "orgTownCode+" + orgTownCode;
//		}
//		else if(!orgDistinctCode.trim().equals("")){
//			//select * from CHSS.DictHospital where CommunityType='县（区）卫生局' and sectioncode='411325'
//			return "orgDistinctCode+" + orgDistinctCode;
//		}
//		else if(!orgCityCode.trim().equals("")){
//			return "orgCityCode+" + "410000162769";
//		}
//		else if(!orgProvinceCode.trim().equals("")){
//			return "orgProvinceCode+" + "410000162769";
//		}
//		return str;
//	}
	
	//机构编码
	private String communityCode(String orgProvinceCode,String orgCityCode,String orgDistinctCode,String orgTownCode,String orgVillageCode){
		String str = "";
		if(!orgVillageCode.trim().equals("")){
			String tmp = communityCodeMap.get(orgVillageCode);
			if(tmp!=null && !tmp.equals("")){
				return tmp;
			}
		}
		if(!orgTownCode.trim().equals("")){
			//select * from CHSS.DictHospital where CommunityType='乡镇卫生院' and streetcode='411322106'
			//return "orgTownCode+" + orgTownCode;
			return communityCodeMap.get(orgTownCode);
		}
		else if(!orgDistinctCode.trim().equals("")){
			//select * from CHSS.DictHospital where CommunityType='县（区）卫生局' and sectioncode='411325'
			//return "orgDistinctCode+" + orgDistinctCode;
			return communityCodeMap.get(orgDistinctCode);
		}
		else if(!orgCityCode.trim().equals("")){
			//return "orgCityCode+" + "410000162769";
			return communityCodeMap.get(orgCityCode);
		}
		else if(!orgProvinceCode.trim().equals("")){
			//return "orgProvinceCode+" + "410000162769";
			return communityCodeMap.get(orgProvinceCode);
		}
		return str;
	}
	
	//与户主关系
	private String relationHourseHoldDR(String houseRelation){
		String str = "";
		if(houseRelation.equals("1"))	
			str = "1";
		else if(houseRelation.equals("2")){
			str = "2";
		}
		else if(houseRelation.equals("3")){
			str = "24";
		}
		else if(houseRelation.equals("4")){
			str = "25";
		}
		else if(houseRelation.equals("5")){
			str = "44";
		}
		else if(houseRelation.equals("6")){
			str = "48";
		}
		else if(houseRelation.equals("7")){
			str = "5";
		}
		else if(houseRelation.equals("8")){
			str = "9";
		}
		else if(houseRelation.equals("9")){
			str = "11";
		}
		else if(houseRelation.equals("10")){
			str = "7";
		}
		else if(houseRelation.equals("11")){
			str = "13";
		}
		else if(houseRelation.equals("12")){
			str = "14";
		}
		else if(houseRelation.equals("13")){
			str = "15";
		}
		else if(houseRelation.equals("14")){
			str = "16";
		}
		else if(houseRelation.equals("15")){
			str = "53";
		}
			
		return str;
	}
	
	//婚姻状况
	private String maritalstatus(String maritalstatus){
		String str = "5";
		if(maritalstatus.equals("1"))
			str = "10";
		else if(maritalstatus.equals("2")){
			str = "20";
		}
		else if(maritalstatus.equals("3")){
			str = "20";
		}
		else if(maritalstatus.equals("4")){
			str = "40";
		}
		else if(maritalstatus.equals("5")){
			str = "90";
		}
		return str;
	}
	
	//文化程度
	private String culture(String culture){
		String str = "";
		if(culture.equals("1")){
			str = "90";
		}
		else if(culture.equals("2")){
			str = "80";
		}
		else if(culture.equals("3")){
			str = "70";
		}
		else if(culture.equals("4")){
			str = "60";
		}
		else if(culture.equals("5")){
			str = "30";
		}
	
		return str;
	}
	
	//民族
	private String nation(String nation){
		String str = "01";
		return str;
	}
	
	//职业
	private String job(String job){
		return job;
	}
	
	//省（自治区、直辖市）
	private String provinceCode(String provinceCode){
		return provinceCode + "0000000000";
	}
	
	//市
	private String cityCode(String cityCode){
		return cityCode + "00000000";
	}
	
	//县
	private String distinctCode(String distinctCode){
		return distinctCode + "000000";
	}
	
	//乡镇街道
	private String townCode(String townCode){
		return townCode + "000";
	}
	
	//村委会
	private String villageCode(String villageCode){
		return villageCode;
	}
	
	//厨房排风设施
	private String blowmeasure(String blowmeasure){
		String str = "";
		if(blowmeasure.equals("1"))
			str = "1";
		else if(blowmeasure.equals("2"))
			str = "2";
		else if(blowmeasure.equals("3"))
			str = "3";
		else if(blowmeasure.equals("4"))
			str = "4";
		return str;
	}
	
	//饮水
	private String drinkwater(String drinkwater){
		String str = drinkwater;

		return str;
	}
	
	private void writeTxt(PersonHealthRecordMain pg){
		String str = 
				pg.getPersonRowId() + "\t" +
				pg.getPersonCode() + "\t" +
				pg.getPersonName() + "\t" +
				pg.getSpellCode() + "\t" +
				pg.getCardNumber() + "\t" +
				pg.getIDCard() + "\t" +
				pg.getDateRegister() + "\t" +
				pg.getDateInput() + "\t" +
				pg.getBirth() + "\t" +
				pg.getBirthPlace() + "\t" +
				pg.getDateOfWork() + "\t" +
				pg.getWorkPlace() + "\t" +
				pg.getDateOFRetire() + "\t" +
				pg.getSpecialPopType() + "\t" +
				pg.getIsSingleChild() + "\t" +
				pg.getBirthParity() + "\t" +
				pg.getDiagnoseId() + "\t" +
				pg.getOtherRecordId() + "\t" +
				pg.getIsDead() + "\t" +
				pg.getDateOfDead() + "\t" +
				pg.getInformationSource() + "\t" +
				pg.getCommunityCode() + "\t" +
				pg.getLinkManName() + "\t" +
				pg.getLinkManPhone() + "\t" +
				pg.getDeformityCode() + "\t" +
				pg.getRelationHourseHoldDR() + "\t" +
				pg.getOperatorInput() + "\t" +
				pg.getNationalityDR() + "\t" +
				pg.getFamilyRowId() + "\t" +
				pg.getHouseHoldTypeDR() + "\t" +
				pg.getDocimialTypeDR() + "\t" +
				pg.getMedicalInsuranceTypeDR() + "\t" +
				pg.getPointHospitalRowIdDR() + "\t" +
				pg.getCommitteeDR() + "\t" +
				pg.getPoliceRowIdDR() + "\t" +
				pg.getStreetRowIdDR() + "\t" +
				pg.getHaveDeformityCertificate() + "\t" +
				pg.getDeformityType() + "\t" +
				pg.getStaffOfUpdate() + "\t" +
				pg.getDateOfUpdate() + "\t" +
				pg.getPersonStatus() + "\t" +
				pg.getPhoto() + "\t" +
				pg.getSexDR() + "\t" +
				pg.getNationDR() + "\t" +
				pg.getBloodTypeDR() + "\t" +
				pg.getMarriageDR() + "\t" +
				pg.getEducationDR() + "\t" +
				pg.getProfessionDR() + "\t" +
				pg.getIDCardTypeDR() + "\t" +
				pg.getDateOfIDStart() + "\t" +
				pg.getDateOfIDEnd() + "\t" +
				pg.getIDCardProvider() + "\t" +
				pg.getMedicalInsuranceID() + "\t" +
				pg.getHosDiagnoseId() + "\t" +
				pg.getProvinceDR() + "\t" +
				pg.getCityDR() + "\t" +
				pg.getSectionDR() + "\t" +
				pg.getStreetDR() + "\t" +
				pg.getVillageDR() + "\t" +
				pg.getVillageName() + "\t" +
				pg.getZu() + "\t" +
				pg.getDoorPlate() + "\t" +
				pg.getCollectPerson() + "\t" +
				pg.getDoctorRegister() + "\t" +
				pg.getRHBloodType() + "\t" +
				pg.getWorkPlacePhone() + "\t" +
				pg.getAddress() + "\t" +
				pg.getAddressTypeDR() + "\t" +
				pg.getDictRenshen() + "\t" +
				pg.getFuelTypeName() + "\t" +
				pg.getIsExcel() + "\t" +
				pg.getKitchenName() + "\t" +
				pg.getLivestockName() + "\t" +
				pg.getPaperNumber() + "\t" +
				pg.getPersonEmail() + "\t" +
				pg.getPhrDrinkName() + "\t" +
				pg.getRegisterType() + "\t" +
				pg.getToiletName() + "\n" 
				;
		if(!pg.getBirthPlace().startsWith("河南省邓州市"))
			FileUtil.writefile(destDir + openId + "_" + "1.txt",str,true);
	}
	

	public static void main(String[] args) {
		API api = new BaseInfo();
//		String paramStr = api.userGet(1);
//		String result = URLUtil.getResult(url, paramStr);
//		System.out.println(result);
//		System.out.println(api.finish(result));
//		api.parser(result);
		//api.down();
		
		//api.userdown("2010-01-01 01:00:00","2014-10-31 23:59:59");
		//api.userdown("2014-10-30 00:00:00","2014-11-04 23:59:59");
		//api.userdown("2014-11-05 00:00:00","2014-11-06 23:59:59");
		
		//api.userdown("2010-01-01 01:00:00","2014-11-06 23:59:59"); //重新下一次[灌涨镇卫生院]:国为机构没有匹配到
		
		//api.userdown("2014-11-07 01:00:00","2014-12-15 23:59:59");
		
		//api.userdown("2014-12-16 00:00:00","2015-02-08 23:59:59");
		
		//api.userdown("2015-02-09 00:00:00","2015-04-27 23:59:59");
		
		//api.userdown("2015-04-28 00:00:00","2015-05-24 23:59:59");
		
		api.userdown("2015-05-25 00:00:00","2015-06-01 23:59:59");
	}
	
}
