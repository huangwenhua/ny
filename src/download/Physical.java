package download;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import bean.physical.PersonHealthAppraise;
import bean.physical.PersonHealthDiagnose;
import bean.physical.PersonInHosRecord;
import bean.physical.PersonLifeStyle;
import bean.physical.PersonLongTermDrug;
import bean.physical.PersonYearCheckAccessory;
import bean.physical.Personyearcheckrecord;
import util.FileUtil;

public class Physical extends API{
	
	private static Log logger = LogFactory.getLog(Physical.class);
	
	public Physical(){
		url = "http://124.133.239.162:9898/api/physical/list_physical";//健康体检--测试地址
		url = "http://119.188.126.39:8080/api/physical/list_physical";//正式地址
		
		sourceDir = "D:/ny/Physical/sourceFile/";
		destDir = "D:/ny/Physical/destFile/";
	}

	@Override
	public void papreData(int pageIndex) {
//		data = "{\"pagePara\":{\"pageSize\":2,\"pageIndex\":" + pageIndex + "}}";	
		data="<queryPhysicalReqVO><containLowerLevel>1</containLowerLevel><createdDateStart>" + startDate + "</createdDateStart><createdDateEnd>" + enDate +"</createdDateEnd><pagePara><pageIndex>" + pageIndex + "</pageIndex><pageSize>20</pageSize></pagePara></queryPhysicalReqVO>";
	}
	
	@Override
	public boolean finish(String xml) {
		Document docment = null;
		try {
			docment = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = docment.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator("customerBaseInfos"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator it = recordEle.elementIterator("customerBaseInfo");
				if(it.hasNext())
					return false;
				else 
					return true;
			}
		} catch (Exception e) {
			logger.error("parse xml is error :" + e.getMessage());
			e.printStackTrace();
		}
		return true;
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
			
			Iterator iter = rootElt.elementIterator("customerBaseInfos"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next(); //customerBaseInfos
				Iterator it = recordEle.elementIterator("customerBaseInfo");
				while(it.hasNext()){
					Element customerBaseInfo = (Element)it.next(); //customerBaseInfo
					Personyearcheckrecord pr = new Personyearcheckrecord();
					PersonLifeStyle ps = new PersonLifeStyle();
					PersonYearCheckAccessory pa = new PersonYearCheckAccessory();
					PersonHealthAppraise pha = new PersonHealthAppraise();
					
					Element idE = customerBaseInfo.element("id");
					String id = idE!=null?idE.getText():"";
					pr.setOldYearCheckRowId(id);
					ps.setYearCheckRowIdParref(id);
					pa.setYearCheckRowIdParref(id);
					pha.setYearCheckRowId(id);
					
					pr.setModifyDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					ps.setDateOfUpdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					
					Element checkdateE = customerBaseInfo.element("checkdate");
					String checkdate = checkdateE!=null?checkdateE.getText():"";
					pr.setDateCheck(checkdate);
					
					Element doctorE = customerBaseInfo.element("doctor");
					String doctor = doctorE!=null?doctorE.getText():"";
					pr.setCheckDoctor(doctor);;
					
					Element symptomE = customerBaseInfo.element("symptom");
					String symptom = symptomE!=null?symptomE.getText():"";
					pr.setSymptom(symptom(symptom));
					
					Element otherE = customerBaseInfo.element("other");
					String other = otherE!=null?otherE.getText():"";
					pr.setSymptomOhter(other);
					
					Element idcardE = customerBaseInfo.element("idcard");
					String idcard = idcardE!=null?idcardE.getText():"";
					
					Element physicalidE = customerBaseInfo.element("physicalid");
					String physicalid = physicalidE!=null?physicalidE.getText():"";
					
					Element createdByE = customerBaseInfo.element("createdBy");
					String createdBy = createdByE!=null?createdByE.getText():"";
					
					Element createdDateE = customerBaseInfo.element("createdDate");
					String createdDate = createdDateE!=null?createdDateE.getText():"";
					
					Element isDelE = customerBaseInfo.element("isDel");
					String isDel = isDelE!=null?isDelE.getText():"";
					
					Element archiveidE = customerBaseInfo.element("archiveid");
					String archiveid = archiveidE!=null?archiveidE.getText():"";
					pr.setPersonRowIdParref(archiveid);
					ps.setPersonRowIdParref(archiveid);
					pha.setPersonRowIdParref(archiveid);
					
					Element mediPhysDistE = customerBaseInfo.element("mediPhysDist");
					if(mediPhysDistE!=null){
						Element mpidE = mediPhysDistE.element("id");
						String mpid = mpidE!=null?mpidE.getText():"";
						
						Element mpphysicalidE = mediPhysDistE.element("physicalid");
						String mpphysicalid = mpphysicalidE!=null?mpphysicalidE.getText():"";
						
						Element mpmildE = mediPhysDistE.element("mild");
						String mpmild = mpmildE!=null?mpmildE.getText():"";
						
						Element mpfaintE = mediPhysDistE.element("faint");
						String mpfaint = mpfaintE!=null?mpfaintE.getText():"";
						
						Element mpyangE = mediPhysDistE.element("yang");
						String mpyang = mpyangE!=null?mpyangE.getText():"";
						
						Element mpyinE = mediPhysDistE.element("yin");
						String mpyin = mpyinE!=null?mpyinE.getText():"";
						
						Element mpphlegmdampE = mediPhysDistE.element("phlegmdamp");
						String mpphlegmdamp = mpphlegmdampE!=null?mpphlegmdampE.getText():"";
						
						Element mpmuggyE = mediPhysDistE.element("muggy");
						String mpmuggy = mpmuggyE!=null?mpmuggyE.getText():"";
						
						Element mpbloodstasisE = mediPhysDistE.element("bloodstasis");
						String mpbloodstasis = mpbloodstasisE!=null?mpbloodstasisE.getText():"";
					
						Element mpqiconstraintE = mediPhysDistE.element("qiconstraint");
						String mpqiconstraint = mpqiconstraintE!=null?mpqiconstraintE.getText():"";
					
						Element mpcharacteristicE = mediPhysDistE.element("characteristic");
						String mpcharacteristic = mpcharacteristicE!=null?mpcharacteristicE.getText():"";
					}
					
					Element generalConditionE = customerBaseInfo.element("generalCondition");
					if(generalConditionE!=null){
						Element gcidE =  generalConditionE.element("id");
						String gcid = gcidE!=null?gcidE.getText():"";
						
						Element gcphysicalidE =  generalConditionE.element("physicalid");
						String gcphysicalid = gcphysicalidE!=null?gcphysicalidE.getText():"";
						
						Element gctemE =  generalConditionE.element("tem");
						String gctem = gctemE!=null?gctemE.getText():"";
						pr.setTemperature(gctem);
						
						Element gcbreathRateE =  generalConditionE.element("breathRate");
						String gcbreathRate = gcbreathRateE!=null?gcbreathRateE.getText():"";
						pr.setBreath(gcbreathRate);
						
						Element gcwaistlineE =  generalConditionE.element("waistline");
						String gcwaistline = gcwaistlineE!=null?gcwaistlineE.getText():"";
						pr.setWaist(gcwaistline);
						
						Element gcheightE =  generalConditionE.element("height");
						String gcheight = gcheightE!=null?gcheightE.getText():"";
						pr.setHeight(gcheight);
						
						Element gcpulserateE =  generalConditionE.element("pulserate");
						String gcpulserate = gcpulserateE!=null?gcpulserateE.getText():"";
						pr.setPulse(gcpulserate);
						
						Element gcweightE =  generalConditionE.element("weight");
						String gcweight = gcweightE!=null?gcweightE.getText():"";
						pr.setWeight(gcweight);
						
						Element gcbmiE =  generalConditionE.element("bmi");
						String gcbmi = gcbmiE!=null?gcbmiE.getText():"";
						pr.setBMI(gcbmi);
						
						Element gcleftpreE =  generalConditionE.element("leftpre");
						String gcleftpre = gcleftpreE!=null?gcleftpreE.getText():"";
						pr.setnLowPressure(gcleftpre); //右侧血压
						
						Element gcrightpreE =  generalConditionE.element("rightpre");
						String gcrightpre = gcrightpreE!=null?gcrightpreE.getText():"";
						
						Element gcleftheightE =  generalConditionE.element("leftheight");
						String gcleftheight = gcleftheightE!=null?gcleftheightE.getText():"";
						pr.setnHighPressure(gcleftheight);
						
						Element gcrightheightE =  generalConditionE.element("rightheight");
						String gcrightheight = gcrightheightE!=null?gcrightheightE.getText():"";
						
						Element oldSelfcareabilityE = generalConditionE.element("oldSelfcareability");
						String gcoldSelfcareability = oldSelfcareabilityE!=null?oldSelfcareabilityE.getText():"";
						pr.setElderSelfAssessment(gcoldSelfcareability);
						
					}
					
					Element lifeStyleE = customerBaseInfo.element("lifeStyle");
					if(lifeStyleE!=null){
						Element lsidE =  lifeStyleE.element("id");
						String lsid = lsidE!=null?lsidE.getText():"";
						
						Element lssmokedaynumE =  lifeStyleE.element("smokedaynum");
						String lssmokedaynum = lssmokedaynumE!=null?lssmokedaynumE.getText():"";
						ps.setNumOfSmoke(lssmokedaynum);
						
						Element lssmokeagestartE =  lifeStyleE.element("smokeagestart");
						String lssmokeagestart = lssmokeagestartE!=null?lssmokeagestartE.getText():"";
						ps.setDateOfStartSmoke(lssmokeagestart);
						
						Element lssmokeageforbiddonE =  lifeStyleE.element("smokeageforbiddon");
						String lssmokeageforbiddon = lssmokeageforbiddonE!=null?lssmokeageforbiddonE.getText():"";
						ps.setDateOfEndSmoke(lssmokeageforbiddon);
						
						Element lsexerciserateE =  lifeStyleE.element("exerciserate");
						String lsexerciserate = lsexerciserateE!=null?lsexerciserateE.getText():"";
						ps.setExerciseInfoDR(lsexerciserate);
						
						Element lsexercisetimeE =  lifeStyleE.element("exercisetime");
						String lsexercisetime = lsexercisetimeE!=null?lsexercisetimeE.getText():"";
						ps.setDateOfExercisePer(lsexercisetime);
						
						Element lseathobbyE =  lifeStyleE.element("eathobby");
						String lseathobby = lseathobbyE!=null?lseathobbyE.getText():"";
						ps.setExerciseTypeDR(lseathobby);
						
						Element lsexerciseexistenseE =  lifeStyleE.element("exerciseexistense");
						String lsexerciseexistense = lsexerciseexistenseE!=null?lsexerciseexistenseE.getText():"";
						ps.setDietHabit(lsexerciseexistense);
						
						Element lsexcisepersisttimeE =  lifeStyleE.element("excisepersisttime");
						String lsexcisepersisttime = lsexcisepersisttimeE!=null?lsexcisepersisttimeE.getText():"";
						ps.setYearOfExercise(lsexcisepersisttime);
						
						Element lssmokeconditionE =  lifeStyleE.element("smokecondition");
						String lssmokecondition = lssmokeconditionE!=null?lssmokeconditionE.getText():"";
						ps.setSmoke(lssmokecondition);
						
						Element lsdrinkrateE =  lifeStyleE.element("drinkrate");
						String lsdrinkrate = lsdrinkrateE!=null?lsdrinkrateE.getText():"";
						ps.setDrinkFrequencyDR(lsdrinkrate);
						
						Element lsdaydrinkvolumeE =  lifeStyleE.element("daydrinkvolume");
						String lsdaydrinkvolume = lsdaydrinkvolumeE!=null?lsdaydrinkvolumeE.getText():"";
						ps.setDPAC(lsdaydrinkvolume);
						
						Element lsisdrinkforbiddonE =  lifeStyleE.element("isdrinkforbiddon");
						String lsisdrinkforbiddon = lsisdrinkforbiddonE!=null?lsisdrinkforbiddonE.getText():"";
						ps.setbDryOut(isdrinkforbiddon(lsisdrinkforbiddon));
						
						Element lsforbiddonageE =  lifeStyleE.element("forbiddonage");
						String lsforbiddonage = lsforbiddonageE!=null?lsforbiddonageE.getText():"";
						ps.setAgeOfEndDrink(lsforbiddonage);
						
						Element lsdrinkstartageE =  lifeStyleE.element("drinkstartage");
						String lsdrinkstartage = lsdrinkstartageE!=null?lsdrinkstartageE.getText():"";
						ps.setAgeOfStartDrink(lsdrinkstartage);
						
						Element lsdrinkthisyearE =  lifeStyleE.element("drinkthisyear");
						String lsdrinkthisyear = lsdrinkthisyearE!=null?lsdrinkthisyearE.getText():"";
						ps.setAlcohol(lsdrinkthisyear);
						
						Element lsdrinktypeE =  lifeStyleE.element("drinktype");
						String lsdrinktype = lsdrinktypeE!=null?lsdrinktypeE.getText():"";
						ps.setDrinkType(drinktype(lsdrinktype));
						
						Element lscareerharmfactorhistoryE =  lifeStyleE.element("careerharmfactorhistory");
						String lscareerharmfactorhistory = lscareerharmfactorhistoryE!=null?lscareerharmfactorhistoryE.getText():"";
						ps.setHaveContact(lscareerharmfactorhistory);
						
						Element lsphysicalidE =  lifeStyleE.element("physicalid");
						String lsphysicalid = lsphysicalidE!=null?lsphysicalidE.getText():"";
						
						Element lsdustE =  lifeStyleE.element("dust");
						String lsdust = lsdustE!=null?lsdustE.getText():"";
						
						Element lsdustprotectE =  lifeStyleE.element("dustprotect");
						String lsdustprotect = lsdustprotectE!=null?lsdustprotectE.getText():"";
						
						Element lsfangsheE =  lifeStyleE.element("fangshe");
						String lsfangshe = lsfangsheE!=null?lsfangsheE.getText():"";
						
						Element lsfangsheprotectE =  lifeStyleE.element("fangsheprotect");
						String lsfangsheprotect = lsfangsheprotectE!=null?lsfangsheprotectE.getText():"";
						
						Element lsphysicalE =  lifeStyleE.element("physical");
						String lsphysical = lsphysicalE!=null?lsphysicalE.getText():"";
						
						Element lsphysicalprotectE =  lifeStyleE.element("physicalprotect");
						String lsphysicalprotect = lsphysicalprotectE!=null?lsphysicalprotectE.getText():"";
						
						Element lschemE =  lifeStyleE.element("chem");
						String lschem = lschemE!=null?lschemE.getText():"";
						
						Element lschemprotectE =  lifeStyleE.element("chemprotect");
						String lschemprotect = lschemprotectE!=null?lschemprotectE.getText():"";
						
						Element lsotherE =  lifeStyleE.element("other");
						String lsother = lsotherE!=null?lsotherE.getText():"";
						
						Element lsotherprotectE =  lifeStyleE.element("otherprotect");
						String lsotherprotect = lsotherprotectE!=null?lsotherprotectE.getText():"";
						
						Element lsworktypeE =  lifeStyleE.element("worktype");
						String lsworktype = lsworktypeE!=null?lsworktypeE.getText():"";
						ps.setOccupation(lsworktype);
						
						Element lsworktimeE =  lifeStyleE.element("worktime");
						String lsworktime = lsworktimeE!=null?lsworktimeE.getText():"";
						ps.setYears(lsworktime);
						
						Element lsdustprotectExE =  lifeStyleE.element("dustprotectEx");
						String lsdustprotectEx = lsdustprotectExE!=null?lsdustprotectExE.getText():"";
						
						Element fangsheprotectExE =  lifeStyleE.element("fangsheprotectEx");
						String fangsheprotectEx = fangsheprotectExE!=null?fangsheprotectExE.getText():"";
						
						Element lsphysicalprotectExE =  lifeStyleE.element("physicalprotectEx");
						String lsphysicalprotectEx = lsphysicalprotectExE!=null?lsphysicalprotectExE.getText():"";
					
						Element lschemprotectExE =  lifeStyleE.element("chemprotectEx");
						String lschemprotectEx = lschemprotectExE!=null?lschemprotectExE.getText():"";
						
						Element lsotherprotectExE =  lifeStyleE.element("otherprotectEx");
						String lsotherprotectEx = lsotherprotectExE!=null?lsotherprotectExE.getText():"";
						
						Element lsdrinktypeOtherE =  lifeStyleE.element("drinktypeOther");
						String lsdrinktypeOther = lsdrinktypeOtherE!=null?lsdrinktypeOtherE.getText():"";
					}
					
					Element visceraFunctionE =  customerBaseInfo.element("visceraFunction");
					if(visceraFunctionE!=null){
						Element vfidE = visceraFunctionE.element("id");
						String vfid = vfidE!=null?vfidE.getText():"";
						
						Element vfphysicalidE = visceraFunctionE.element("physicalid");
						String vfphysicalid = vfphysicalidE!=null?vfphysicalidE.getText():"";
						
						Element vflipsE = visceraFunctionE.element("lips");
						String vflips = vflipsE!=null?vflipsE.getText():"";
						
						Element vftoothresidesE = visceraFunctionE.element("toothresides");
						String vftoothresides = vftoothresidesE!=null?vftoothresidesE.getText():"";
						
						Element vfpharyngealE = visceraFunctionE.element("pharyngeal");
						String vfpharyngeal = vfpharyngealE!=null?vfpharyngealE.getText():"";
						
						Element vfleftviewE = visceraFunctionE.element("leftview");
						String vfleftview = vfleftviewE!=null?vfleftviewE.getText():"";
						
						Element vflistenE = visceraFunctionE.element("listen");
						String vflisten = vflistenE!=null?vflistenE.getText():"";
						
						Element vfrightviewE = visceraFunctionE.element("rightview");
						String vfrightview = vfrightviewE!=null?vfrightviewE.getText():"";
						
						Element vfsportfunctionE = visceraFunctionE.element("sportfunction");
						String vfsportfunction = vfsportfunctionE!=null?vfsportfunctionE.getText():"";
						
						Element vflefteyecorrectE = visceraFunctionE.element("lefteyecorrect");
						String vflefteyecorrect = vflefteyecorrectE!=null?vflefteyecorrectE.getText():"";
						
						Element vfrighteyecorrectE = visceraFunctionE.element("righteyecorrect");
						String vfrighteyecorrect = vfrighteyecorrectE!=null?vfrighteyecorrectE.getText():"";
					}
					
					Element assistCheckE =  customerBaseInfo.element("assistCheck");
					if(assistCheckE!=null){
						Element acidE = assistCheckE.element("id");
						String acid = acidE!=null?acidE.getText():"";
						
						Element achbE = assistCheckE.element("hb");
						String achb = achbE!=null?achbE.getText():"";
						pa.setHB(achb);
						
						Element acwbcE = assistCheckE.element("wbc");
						String acwbc = acwbcE!=null?acwbcE.getText():"";
						pa.setWBC(acwbc);
						
						Element acpltE = assistCheckE.element("plt");
						String acplt = acpltE!=null?acpltE.getText():"";
						pa.setPLT(acplt);
						
						Element acproE = assistCheckE.element("pro");
						String acpro = acproE!=null?acproE.getText():"";
						pa.setUrineProtein(acpro);
						
						Element acgluE = assistCheckE.element("glu");
						String acglu = acgluE!=null?acgluE.getText():"";
						pa.setUrineSugar(acglu);
						
						Element acketE = assistCheckE.element("ket");
						String acket = acketE!=null?acketE.getText():"";
						pa.setKET(acket);
						
						Element acbldE = assistCheckE.element("bld");
						String acbld = acbldE!=null?acbldE.getText():"";
						pa.setOccultBlood(acbld);
						
						Element acfpglE = assistCheckE.element("fpgl");
						String acfpgl = acfpglE!=null?acfpglE.getText():"";
						pa.setFPG(acfpgl);
						
						Element acecgE = assistCheckE.element("ecg");
						String acecg = acecgE!=null?acecgE.getText():"";
						pa.setFecalOccultBlood(acecg);
						
						Element acalbuminE = assistCheckE.element("albumin");
						String acalbumin = acalbuminE!=null?acalbuminE.getText():"";
						pa.setGlobulin(acalbumin);
						
						Element acfobE = assistCheckE.element("fob");
						String acfob = acfobE!=null?acfobE.getText():"";
						pa.setHBsAg(acfob);
						
						Element achbalcE = assistCheckE.element("hbalc");
						String achbalc = achbalcE!=null?achbalcE.getText():"";
						pa.setHbAlc(achbalc);
						
						Element achbsagE = assistCheckE.element("hbsag");
						String achbsag = achbsagE!=null?achbsagE.getText():"";
						pa.setHbsAb(achbsag);
						
						Element acsgptE = assistCheckE.element("sgpt");
						String acsgpt = acsgptE!=null?acsgptE.getText():"";
						pa.setALT(acsgpt);
						
						Element acgotE = assistCheckE.element("got");
						String acgot = acgotE!=null?acgotE.getText():"";
						pa.setAST(acgot);
						
						Element acbpE = assistCheckE.element("bp");
						String acbp = acbpE!=null?acbpE.getText():"";
						pa.setALB(acbp);
						
						Element actbilE = assistCheckE.element("tbil");
						String actbil = actbilE!=null?actbilE.getText():"";
						pa.setTBIL(actbil);
						
						Element accbE = assistCheckE.element("cb");
						String accb = accbE!=null?accbE.getText():"";
						pa.setDBIL(accb);
						
						Element acscrE = assistCheckE.element("scr");
						String acscr = acscrE!=null?acscrE.getText():"";
						pa.setScr(acscr);
						
						Element acbunE = assistCheckE.element("bun");
						String acbun = acbunE!=null?acbunE.getText():"";
						pa.setBUN(acbun);
						
						Element acpcE = assistCheckE.element("pc");
						String acpc = acpcE!=null?acpcE.getText():"";
						pa.setARP(acpc);
						
						Element achypeE = assistCheckE.element("hype");
						String achype = achypeE!=null?achypeE.getText():"";
						
						Element actcE = assistCheckE.element("tc");
						String actc = actcE!=null?actcE.getText():"";
						pa.setCHO(actc);
						
						Element actgE = assistCheckE.element("tg");
						String actg = actgE!=null?actgE.getText():"";
						pa.setTG(actg);
						
						Element aclowChoE = assistCheckE.element("lowCho");
						String aclowCho = aclowChoE!=null?aclowChoE.getText():"";
						pa.setLDLC(aclowCho);
						
						Element acheiChoE = assistCheckE.element("heiCho");
						String acheiCho = acheiChoE!=null?acheiChoE.getText():"";
						pa.setHDLC(acheiCho);
						
						Element acchestxE = assistCheckE.element("chestx");
						String acchestx = acchestxE!=null?acchestxE.getText():"";
						pa.setEyegroundInfo(chestx(acchestx));
						
						Element acbchaoE = assistCheckE.element("bchao");
						String acbchao = acbchaoE!=null?acbchaoE.getText():"";
						pa.setCardiogram(bchao(acbchao));
						
						Element acbloodOtherE = assistCheckE.element("bloodOther");
						String acbloodOther = acbloodOtherE!=null?acbloodOtherE.getText():"";
						pa.setCBCOther(acbloodOther);
						
						Element acurineOtherE = assistCheckE.element("urineOther");
						String acurineOther = acurineOtherE!=null?acurineOtherE.getText():"";
						pa.setUrineRoutineOther(acurineOther);
						
						Element acotherE = assistCheckE.element("other");
						String acother = acotherE!=null?acotherE.getText():"";
						pa.setOtherCheck(acother);
						
						Element accervixE = assistCheckE.element("cervix");
						String accervix = accervixE!=null?accervixE.getText():"";
						pa.setSternum(cervix(accervix));
						
						Element acecgExE = assistCheckE.element("ecgEx");
						String acecgEx = acecgExE!=null?acecgExE.getText():"";
						
						Element acchestxExE = assistCheckE.element("chestxEx");
						String acchestxEx = acchestxExE!=null?acchestxExE.getText():"";
						
						Element acbchaoExE = assistCheckE.element("bchaoEx");
						String acbchaoEx = acbchaoExE!=null?acbchaoExE.getText():"";
						pa.setCardiogramInfo(acbchaoEx);
						
						Element accervixExE = assistCheckE.element("cervixEx");
						String accervixEx = accervixExE!=null?accervixExE.getText():"";
						pa.setSternumInfo(accervixEx);
						
						Element acphysicalidE = assistCheckE.element("physicalid");
						String acphysicalid = acphysicalidE!=null?acphysicalidE.getText():"";
					}
					
					Element healthQuestion = customerBaseInfo.element("healthQuestion");
					if(healthQuestion!=null){
						Element hqidE = healthQuestion.element("id");
						String hqid = hqidE!=null?hqidE.getText():"";
						
						Element hqphysicalidE = healthQuestion.element("physicalid");
						String hqphysicalid = hqphysicalidE!=null?hqphysicalidE.getText():"";
						
						Element hqbrainDisE = healthQuestion.element("brainDis");
						String hqbrainDis = hqbrainDisE!=null?hqbrainDisE.getText():"";
						
						Element hqrenalDisE = healthQuestion.element("renalDis");
						String hqrenalDis = hqrenalDisE!=null?hqrenalDisE.getText():"";
						
						Element hqheartDisE = healthQuestion.element("heartDis");
						String hqheartDis = hqheartDisE!=null?hqheartDisE.getText():"";
						
						Element hqvesselDisE = healthQuestion.element("vesselDis");
						String hqvesselDis = hqvesselDisE!=null?hqvesselDisE.getText():"";
						
						Element hqeyeDisE = healthQuestion.element("eyeDis");
						String hqeyeDis = hqeyeDisE!=null?hqeyeDisE.getText():"";
						
						Element hqnerveDisE = healthQuestion.element("nerveDis");
						String hqnerveDis = hqnerveDisE!=null?hqnerveDisE.getText():"";
						
						Element hqelseDisE = healthQuestion.element("elseDis");
						String hqelseDis = hqelseDisE!=null?hqelseDisE.getText():"";
						
						Element hqbrainOtherE = healthQuestion.element("brainOther");
						String hqbrainOther = hqbrainOtherE!=null?hqbrainOtherE.getText():"";
						
						Element hqrenalOtherE = healthQuestion.element("renalOther");
						String hqrenalOther = hqrenalOtherE!=null?hqrenalOtherE.getText():"";
						
						Element hqheartOtherE = healthQuestion.element("heartOther");
						String hqheartOther = hqheartOtherE!=null?hqheartOtherE.getText():"";
						
						Element hqvesselOtherE = healthQuestion.element("vesselOther");
						String hqvesselOther = hqvesselOtherE!=null?hqvesselOtherE.getText():"";
						
						Element hqeyeOtherE = healthQuestion.element("eyeOther");
						String hqeyeOther = hqeyeOtherE!=null?hqeyeOtherE.getText():"";
						
						Element hqnerveDisOtherE = healthQuestion.element("nerveDisOther");
						String hqnerveDisOther = hqnerveDisOtherE!=null?hqnerveDisOtherE.getText():"";
						
						Element hqelseDisOtherE = healthQuestion.element("elseDisOther");
						String hqelseDisOther = hqelseDisOtherE!=null?hqelseDisOtherE.getText():"";
					}
					
					Element hospitalHistorys = customerBaseInfo.element("hospitalHistorys");
					if(hospitalHistorys!=null){
						List<Element> hospitalHistoryE = hospitalHistorys.elements("hospitalHistory");
						if(hospitalHistoryE!=null){
							for(Element hospitalHistory:hospitalHistoryE){
								PersonInHosRecord pir = new PersonInHosRecord();
								pir.setPersonRowId(archiveid);
								pir.setYearCheckRowId(id);
								
								Element hhidE = hospitalHistory.element("id");
								String hhid = hhidE!=null?hhidE.getText():"";
								
								Element hhinhospitaldateE = hospitalHistory.element("inhospitaldate");
								String hhinhospitaldate = hhinhospitaldateE!=null?hhinhospitaldateE.getText():"";
								pir.setDateInHos(hhinhospitaldate);
								
								Element hhreasonE = hospitalHistory.element("reason");
								String hhreason = hhreasonE!=null?hhreasonE.getText():"";
								pir.setDiagnose(hhreason);
								
								Element hhillcasenumE = hospitalHistory.element("illcasenum");
								String hhillcasenum = hhillcasenumE!=null?hhillcasenumE.getText():"";
								pir.setInHosCode(hhillcasenum);
								
								Element hhhospitalnameE = hospitalHistory.element("hospitalname");
								String hhhospitalname = hhhospitalnameE!=null?hhhospitalnameE.getText():"";
								pir.setHospitalName(hhhospitalname);
								
								Element hhphysicalidE = hospitalHistory.element("physicalid");
								String hhphysicalid = hhphysicalidE!=null?hhphysicalidE.getText():"";
								
								Element hhouthospitaldateE = hospitalHistory.element("outhospitaldate");
								String hhouthospitaldate = hhouthospitaldateE!=null?hhouthospitaldateE.getText():"";
								pir.setDateOutHos(hhouthospitaldate);
								
								writePersonInHosRecord(pir);
							}
						}
					}
					
					Element familyBEDHistorys = customerBaseInfo.element("familyBEDHistorys");
					if(familyBEDHistorys!=null){
						List<Element> familyBEDHistoryE = familyBEDHistorys.elements("familyBEDHistory");
						if(familyBEDHistoryE!=null){
							for(Element familyBEDHistory:familyBEDHistoryE){
								Element fbidE = familyBEDHistory.element("id");
								String fbid = fbidE!=null?fbidE.getText():"";
								
								Element fbhospitalnameE = familyBEDHistory.element("hospitalname");
								String fbhospitalname = fbhospitalnameE!=null?fbhospitalnameE.getText():"";
								
								Element fbinhospitaldateE = familyBEDHistory.element("inhospitaldate");
								String fbinhospitaldate = fbinhospitaldateE!=null?fbinhospitaldateE.getText():"";
								
								Element fbillcasenumsE = familyBEDHistory.element("illcasenums");
								String fbillcasenums = fbillcasenumsE!=null?fbillcasenumsE.getText():"";
								
								Element fbreasonsE = familyBEDHistory.element("reasons");
								String fbreasons = fbreasonsE!=null?fbreasonsE.getText():"";
								
								Element fbphysicalidE = familyBEDHistory.element("physicalid");
								String fbphysicalid = fbphysicalidE!=null?fbphysicalidE.getText():"";
								
								Element fbouthospitaldateE = familyBEDHistory.element("outhospitaldate");
								String fbouthospitaldate = fbouthospitaldateE!=null?fbouthospitaldateE.getText():"";
							}
						}
					}
					
					Element medications =  customerBaseInfo.element("medications");
					if(medications!=null){
						List<Element> medicationE = medications.elements("medication");
						if(medicationE!=null){
							for(Element medication:medicationE){
								PersonLongTermDrug pld = new PersonLongTermDrug();
								pld.setTableType("PersonYearCheckRecord");
								pld.setRecordId(id);
								pld.setPersonRowId(archiveid);	
								
								Element mcidE = medication.element("id");
								String mcid = mcidE!=null?mcidE.getText():"";
								
								Element mcphysicalidE = medication.element("physicalid");
								String mcphysicalid = mcphysicalidE!=null?mcphysicalidE.getText():"";
								
								Element mcuseageE = medication.element("useage");
								String mcuseage = mcuseageE!=null?mcuseageE.getText():"";
								pld.setUseage(mcuseage);
								
								Element mcusenumE = medication.element("usenum");
								String mcusenum = mcusenumE!=null?mcusenumE.getText():"";
								pld.setDosage(mcusenum);
								
								Element mcstarttimeE = medication.element("starttime");
								String mcstarttime = mcstarttimeE!=null?mcstarttimeE.getText():"";
								pld.setDateOfStart(mcstarttime);
								
								Element mcpilldependenceE = medication.element("pilldependence");
								String mcpilldependence = mcpilldependenceE!=null?mcpilldependenceE.getText():"";
								
								Element mcmedicinalnameE = medication.element("medicinalname");
								String mcmedicinalname = mcmedicinalnameE!=null?mcmedicinalnameE.getText():"";
								pld.setDrugName(mcmedicinalname);
								
								writePersonLongTermDrug(pld);
							}
							
						}
					}
					
					Element inoculationHistorys = customerBaseInfo.element("inoculationHistorys");
					if(inoculationHistorys!=null){
						List<Element> inoculationHistoryE = inoculationHistorys.elements("inoculationHistory");
						if(inoculationHistoryE!=null){
							for(Element inoculationHistory:inoculationHistoryE){
								PersonHealthDiagnose pd = new PersonHealthDiagnose();
								pd.setPersonRowIdParref(archiveid);
								pd.setRecordRowIdDR(id);
								pd.setItemdCode("15");
								
								Element ihidE = inoculationHistory.element("id");
								String ihid = ihidE!=null?ihidE.getText():"";
								
								Element ihpillnameE = inoculationHistory.element("pillname");
								String ihpillname = ihpillnameE!=null?ihpillnameE.getText():"";
								pd.setItemAssortName(ihpillname);
								
								Element ihinoculationdateE = inoculationHistory.element("inoculationdate");
								String ihinoculationdate = ihinoculationdateE!=null?ihinoculationdateE.getText():"";
								pd.setDateOfStart(ihinoculationdate);
								
								Element ihinoculationhistoryE = inoculationHistory.element("inoculationhistory");
								String ihinoculationhistory = ihinoculationhistoryE!=null?ihinoculationhistoryE.getText():"";
								pd.setDiagnoseResult(ihinoculationhistory);
								
								Element ihphysicalidE = inoculationHistory.element("physicalid");
								String ihphysicalid = ihphysicalidE!=null?ihphysicalidE.getText():"";
								
								writePersonHealthDiagnose(pd);
							}
						}
					}
					
					Element assessmentGuideE = customerBaseInfo.element("assessmentGuide");
					if(assessmentGuideE!=null){
						Element agidE = assessmentGuideE.element("id");
						String agid = agidE!=null?agidE.getText():"";
						
						Element agisnormalE = assessmentGuideE.element("isnormal");
						String agisnormal = agisnormalE!=null?agisnormalE.getText():"";
						pha.setCheckResult(isnormal(agisnormal));
						
						Element aghealthzhidaoE = assessmentGuideE.element("healthzhidao");
						String aghealthzhidao = aghealthzhidaoE!=null?aghealthzhidaoE.getText():"";
						pha.setHealthSuggest(healthSuggest(aghealthzhidao));
						
						Element agdangercontrolE = assessmentGuideE.element("dangercontrol");
						String agdangercontrol = agdangercontrolE!=null?agdangercontrolE.getText():"";
						pha.setDangerInfo(dangercontrol(agdangercontrol));
						
						Element agphysicalidE = assessmentGuideE.element("physicalid");
						String agphysicalid = agphysicalidE!=null?agphysicalidE.getText():"";
						
						Element agexception1E = assessmentGuideE.element("exception1");
						String agexception1 = agexception1E!=null?agexception1E.getText():"";
						
						Element agexception2E = assessmentGuideE.element("exception2");
						String agexception2 = agexception2E!=null?agexception2E.getText():"";
						
						Element agexception3E = assessmentGuideE.element("exception3");
						String agexception3 = agexception3E!=null?agexception3E.getText():"";
						
						Element agexception4E = assessmentGuideE.element("exception4");
						String agexception4 = agexception4E!=null?agexception4E.getText():"";
						pha.setCheckResultInfo(checkResultInfo(agexception1,agexception2,agexception3,agexception4));
						
						Element agaimE = assessmentGuideE.element("aim");
						String agaim = agaimE!=null?agaimE.getText():"";
						
						Element agadviceE = assessmentGuideE.element("advice");
						String agadvice = agadviceE!=null?agadviceE.getText():"";
						
						Element agotherE = assessmentGuideE.element("other");
						String agother = agotherE!=null?agotherE.getText():"";
						pha.setDangerControl(agother);
					}
					
					Element physicalExamE = customerBaseInfo.element("physicalExam");
					if(physicalExamE!=null){
						Element peidE = physicalExamE.element("id");
						String peid = peidE!=null?peidE.getText():"";
						
						Element pephysicalidE = physicalExamE.element("physicalid");
						String pephysicalid = pephysicalidE!=null?pephysicalidE.getText():"";
						
						Element peskinE = physicalExamE.element("skin");
						String peskin = peskinE!=null?peskinE.getText():"";
						pr.setSkin(skin(peskin));
						
						Element pescleraE = physicalExamE.element("sclera");
						String pesclera = pescleraE!=null?pescleraE.getText():"";
						pr.setSclera(sclera(pesclera));
						
						Element pelymphE = physicalExamE.element("lymph");
						String pelymph = pelymphE!=null?pelymphE.getText():"";
						pr.setScrofula(lymph(pelymph));
						
						Element pebarrelchestE = physicalExamE.element("barrelchest");
						String pebarrelchest = pebarrelchestE!=null?pebarrelchestE.getText():"";
						pr.setbBarrelChest(pebarrelchest);
						
						Element pebreathsoundsE = physicalExamE.element("breathsounds");
						String pebreathsounds = pebreathsoundsE!=null?pebreathsoundsE.getText():"";
						pr.setBreathSounds(breathsounds(pebreathsounds));
						
						Element peraleE = physicalExamE.element("rale");
						String perale = peraleE!=null?peraleE.getText():"";
						pr.setRale(perale);
						
						Element peheartrateE = physicalExamE.element("heartrate");
						String peheartrate = peheartrateE!=null?peheartrateE.getText():"";
						
						Element peheartrhythmE = physicalExamE.element("heartrhythm");
						String peheartrhythm = peheartrhythmE!=null?peheartrhythmE.getText():"";
						
						Element penoiseE = physicalExamE.element("noise");
						String penoise = penoiseE!=null?penoiseE.getText():"";
						pr.setSouffle(noise(penoise));
						
						Element peenclosedmassE = physicalExamE.element("enclosedmass");
						String peenclosedmass = peenclosedmassE!=null?peenclosedmassE.getText():"";
						pr.setEnclosedMass(enclosedmass(peenclosedmass));
						
						Element peedemaE = physicalExamE.element("edema");
						String peedema = peedemaE!=null?peedemaE.getText():"";
						pr.setEdemaOfLimbs(peedema);
						
						Element pefootbackE = physicalExamE.element("footback");
						String pefootback = pefootbackE!=null?pefootbackE.getText():"";
						pr.setProstate(pefootback);
						
						Element peanusE = physicalExamE.element("anus");
						String peanus = peanusE!=null?peanusE.getText():"";
						pr.setAnus(peanus);
						
						Element pebreastE = physicalExamE.element("breast");
						String pebreast = pebreastE!=null?pebreastE.getText():"";
						pr.setGalactophore(breast(pebreast));
						
						Element pevulvaE = physicalExamE.element("vulva");
						String pevulva = pevulvaE!=null?pevulvaE.getText():"";
						pr.setVaginaInflammation(pevulva);
						
						Element pevaginaE = physicalExamE.element("vagina");
						String pevagina = pevaginaE!=null?pevaginaE.getText():"";
						pr.setDoubleWombs(pevagina);
						
						Element pecervixuteriE = physicalExamE.element("cervixuteri");
						String pecervixuteri = pecervixuteriE!=null?pecervixuteriE.getText():"";
						pr.setCervicitis(pecervixuteri);
						
						Element pecorpusE = physicalExamE.element("corpus");
						String pecorpus = pecorpusE!=null?pecorpusE.getText():"";
						pr.setUterineFibroids(pecorpus);
						
						Element peattachE = physicalExamE.element("attach");
						String peattach = peattachE!=null?peattachE.getText():"";
						pr.setAccessaryTumour(peattach);
						
						Element peotherE = physicalExamE.element("other");
						String peother = peotherE!=null?peotherE.getText():"";
						
						Element pepresspainE = physicalExamE.element("presspain");
						String pepresspain = pepresspainE!=null?pepresspainE.getText():"";
						pr.setTenderness(presspain(pepresspain));
						
						Element peliverE = physicalExamE.element("liver");
						String peliver = peliverE!=null?peliverE.getText():"";
						pr.setHepatauxe(liver(peliver));
						
						Element pespleenE = physicalExamE.element("spleen");
						String pespleen = pespleenE!=null?pespleenE.getText():"";
						pr.setSplenomegaly(spleen(pespleen));
						
						Element pevoicedE = physicalExamE.element("voiced");
						String pevoiced = pevoicedE!=null?pevoicedE.getText():"";
						pr.setShiftingDullness(voiced(pevoiced));
						
						Element peskinExE = physicalExamE.element("skinEx");
						String peskinEx = peskinExE!=null?peskinExE.getText():"";
						
						Element pesclereExE = physicalExamE.element("sclereEx");
						String pesclereEx = pesclereExE!=null?pesclereExE.getText():"";
						
						Element pelymphExE = physicalExamE.element("lymphEx");
						String pelymphEx = pelymphExE!=null?pelymphExE.getText():"";
						pr.setScrofulaOther(pelymphEx);
						
						Element pebreastExE = physicalExamE.element("breastEx");
						String pebreastEx = pebreastExE!=null?pebreastExE.getText():"";
						
						Element peanusExE = physicalExamE.element("anusEx");
						String peanusEx = peanusExE!=null?peanusExE.getText():"";
						pr.setAnusOther(peanusEx);
						
						Element pebreathsoundsExE = physicalExamE.element("breathsoundsEx");
						String pebreathsoundsEx = pebreathsoundsExE!=null?pebreathsoundsExE.getText():"";
						pr.setBreathSoundsInfo(pebreathsoundsEx);
						
						Element peraleExE = physicalExamE.element("raleEx");
						String peraleEx = peraleExE!=null?peraleExE.getText():"";
						pr.setRaleInfo(peraleEx);
						
						Element penoiseExE = physicalExamE.element("noiseEx");
						String penoiseEx = penoiseExE!=null?penoiseExE.getText():"";
						pr.setSouffleInfo(penoiseEx);
						
						Element pecervixuteriExE = physicalExamE.element("cervixuteriEx");
						String pecervixuteriEx = pecervixuteriExE!=null?pecervixuteriExE.getText():"";
						pr.setCervicitisDes(pecervixuteriEx);
						
						Element pecorpusExE = physicalExamE.element("corpusEx");
						String pecorpusEx = pecorpusExE!=null?pecorpusExE.getText():"";
						pr.setUterineFibroidsDes(pecorpusEx);
						
						Element peattachExE = physicalExamE.element("attachEx");
						String peattachEx = peattachExE!=null?peattachExE.getText():"";
						pr.setAccessaryTumourDes(peattachEx);
						
						Element pevulvaExE = physicalExamE.element("vulvaEx");
						String pevulvaEx = pevulvaExE!=null?pevulvaExE.getText():"";
						pr.setVaginaInflammationDes(pevulvaEx);
						
						Element pevaginaExE = physicalExamE.element("vaginaEx");
						String pevaginaEx = pevaginaExE!=null?pevaginaExE.getText():"";
						pr.setDoubleWombsDes(pevaginaEx);
						
						Element pepresspainExE = physicalExamE.element("presspainEx");
						String pepresspainEx = pepresspainExE!=null?pepresspainExE.getText():"";
						pr.setTendernessInfo(pepresspainEx);
						
						Element peliverExE = physicalExamE.element("liverEx");
						String peliverEx = peliverExE!=null?peliverExE.getText():"";
						pr.setHepatauxeInfo(peliverEx);
						
						Element pespleenExE = physicalExamE.element("spleenEx");
						String pespleenEx = pespleenExE!=null?pespleenExE.getText():"";
						pr.setSplenomegalyInfo(pespleenEx);
						
						Element pevoicedExE = physicalExamE.element("voicedEx");
						String pevoicedEx = pevoicedExE!=null?pevoicedExE.getText():"";
						pr.setShiftingDullnessInfo(pevoicedEx);
						
						Element peenclosedmassExE = physicalExamE.element("enclosedmassEx");
						String peenclosedmassEx = peenclosedmassExE!=null?peenclosedmassExE.getText():"";
						pr.setEnclosedMassInfo(peenclosedmassEx);
						
						Element peeyeroundE = physicalExamE.element("eyeround");
						String peeyeround = peeyeroundE!=null?peeyeroundE.getText():"";
						pr.setFundus(peeyeround);
						
						pr.setFillDate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
						
						Element peeyeroundExE = physicalExamE.element("eyeroundEx");
						String peeyeroundEx = peeyeroundExE!=null?peeyeroundExE.getText():"";
					}
					
					writePersonyearcheckrecord(pr);
					writePersonLifeStyle(ps);
					writePersonYearCheckAccessory(pa);
					writePersonHealthAppraise(pha);
				}
			}		
		} catch (Exception e) {
				logger.error("parse xml is error :" + e.getMessage());
				e.printStackTrace();
		}
		//FileUtil.writefile(sourceDir + openId + "_" + pageIndex + ".txt", xml, false);
		FileUtil.writefile(sourceDir + openId + "_" + startDate.substring(0, 10) + "_" + enDate.substring(0, 10) + "_" +pageIndex + ".txt", xml, false);
	}
	
	private void writePersonyearcheckrecord(Personyearcheckrecord pr){
		String str = 
				pr.getOldYearCheckRowId() + "\t" +
				pr.getDateCheck() + "\t" +
				pr.getCheckAdd() + "\t" +
				pr.getCheckDoctor() + "\t" +
				pr.getTemperature() + "\t" +
				pr.getPulse() + "\t" +
				pr.getnHighPressure() + "\t" +
				pr.getnLowPressure() + "\t" +
				pr.getWeight() + "\t" +
				pr.getHeight() + "\t" +
				pr.getBMI() + "\t" +
				pr.getOlderCongnize() + "\t" +
				pr.getOlderCongnizeScore() + "\t" +
				pr.getOlderSensibility() + "\t" +
				pr.getOlderSensibilityScore() + "\t" +
				pr.getLeftEyesight() + "\t" +
				pr.getRightEyesight() + "\t" +
				pr.getLeftCorrectEyesight() + "\t" +
				pr.getRightCorrectEyesight() + "\t" +
				pr.getHearing() + "\t" +
				pr.getMovement() + "\t" +
				pr.getSkin() + "\t" +
				pr.getScrofulaOther() + "\t" +
				pr.getbBarrelChest() + "\t" +
				pr.getBreathSounds() + "\t" +
				pr.getBreathSoundsInfo() + "\t" +
				pr.getRale() + "\t" +
				pr.getRaleInfo() + "\t" +
				pr.getHeartRate() + "\t" +
				pr.getCardiacRhythm() + "\t" +
				pr.getSouffle() + "\t" +
				pr.getSouffleInfo() + "\t" +
				pr.getTenderness() + "\t" +
				pr.getTendernessInfo() + "\t" +
				pr.getEnclosedMass() + "\t" +
				pr.getEnclosedMassInfo() + "\t" +
				pr.getHepatauxe() + "\t" +
				pr.getHepatauxeInfo() + "\t" +
				pr.getSplenomegaly() + "\t" +
				pr.getSplenomegalyInfo() + "\t" +
				pr.getShiftingDullness() + "\t" +
				pr.getShiftingDullnessInfo() + "\t" +
				pr.getEdemaOfLimbs() + "\t" +
				pr.getAnus() + "\t" +
				pr.getAnusOther() + "\t" +
				pr.getProstate() + "\t" +
				pr.getBookingDate() + "\t" +
				pr.getbBooking() + "\t" +
				pr.getBloodSurgeLimosis() + "\t" +
				pr.getCholesterin() + "\t" +
				pr.getMentalityAdjust() + "\t" +
				pr.getCheckResult() + "\t" +
				pr.getDeal() + "\t" +
				pr.getVaginaInflammation() + "\t" +
				pr.getVaginaInflammationDes() + "\t" +
				pr.getCervicitis() + "\t" +
				pr.getCervicitisDes() + "\t" +
				pr.getDoubleWombs() + "\t" +
				pr.getDoubleWombsDes() + "\t" +
				pr.getUterineFibroids() + "\t" +
				pr.getUterineFibroidsDes() + "\t" +
				pr.getAccessaryTumour() + "\t" +
				pr.getAccessaryTumourDes() + "\t" +
				pr.getOralLips() + "\t" +
				pr.getSclera() + "\t" +
				pr.getPharyngealCheck() + "\t" +
				pr.getBiologyExemplar() + "\t" +
				pr.getBreath() + "\t" +
				pr.getCheckHospital() + "\t" +
				pr.getCollectStandard() + "\t" +
				pr.getCommunityCode() + "\t" +
				pr.getDNAExemplar() + "\t" +
				pr.getDentition() + "\t" +
				pr.getDictElderLiveSelfAssessment() + "\t" +
				pr.getDiseaseHistory() + "\t" +
				pr.getDiseaseHistoryOther() + "\t" +
				pr.getDoctor1() + "\t" +
				pr.getDoctor2() + "\t" +
				pr.getDoctor3() + "\t" +
				pr.getDoctor4() + "\t" +
				pr.getDoctor5() + "\t" +
				pr.getDoctor6() + "\t" +
				pr.getElderSelfAssessment() + "\t" +
				pr.getEpidemiologyData() + "\t" +
				pr.getExcel() + "\t" +
				pr.getExpected() + "\t" +
				pr.getFertility() + "\t" +
				pr.getFeverReason() + "\t" +
				pr.getFeverhours() + "\t" +
				pr.getFillDate() + "\t" +
				pr.getFillTime() + "\t" +
				pr.getFundus() + "\t" +
				pr.getGalactophore() + "\t" +
				pr.getGestation() + "\t" +
				pr.getIsPrint() + "\t" +
				pr.getLatestYearOut() + "\t" +
				pr.getLatestYearOutPlace() + "\t" +
				pr.getMark() + "\t" +
				pr.getModifyDate() + "\t" +
				pr.getModifyTime() + "\t" +
				pr.getOldPersonRowId() + "\t" +
				pr.getOldYearCheckRowId() + "\t" +
				pr.getOperation() + "\t" +
				pr.getOther() + "\t" +
				pr.getPersonRowIdParref() + "\t" +
				pr.getPlasmaExemplar() + "\t" +
				pr.getResortDays() + "\t" +
				pr.getScrofula() + "\t" +
				pr.getSymptom() + "\t" +
				pr.getSymptomOhter() + "\t" +
				pr.getWaist() + "\n"
				;
		FileUtil.writefile(destDir+ "Personyearcheckrecord/" + openId + "_" +  "1.txt",str,true);
	}
	
	private void writePersonLifeStyle(PersonLifeStyle ps){
		String str = 
			ps.getRelateROWID () + "\t" +
			ps.getAgeOfEndDrink () + "\t" +
			ps.getAgeOfStartDrink () + "\t" +
			ps.getAlcohol () + "\t" +
			ps.getCereOther () + "\t" +
			ps.getCerebrovascularName () + "\t" +
			ps.getDPAC () + "\t" +
			ps.getDateOfEndSmoke () + "\t" +
			ps.getDateOfExercisePer () + "\t" +
			ps.getDateOfStartSmoke () + "\t" +
			ps.getDateOfUpdate () + "\t" +
			ps.getDateOfYearCheck () + "\t" +
			ps.getDietHabit () + "\t" +
			ps.getDoctorRegister () + "\t" +
			ps.getDrinkFrequencyDR () + "\t" +
			ps.getDrinkType () + "\t" +
			ps.getDrinkTypeName () + "\t" +
			ps.getExerciseInfoDR () + "\t" +
			ps.getExerciseTypeDR () + "\t" +
			ps.getEyeDiseaseName () + "\t" +
			ps.getEyeOther () + "\t" +
			ps.getHaveContact () + "\t" +
			ps.getHeartName () + "\t" +
			ps.getHeartOther () + "\t" +
			ps.getKidneyName () + "\t" +
			ps.getKidneyOther () + "\t" +
			ps.getNervousOther () + "\t" +
			ps.getNervousOtherSelect () + "\t" +
			ps.getNumOfSmoke () + "\t" +
			ps.getOccupation () + "\t" +
			ps.getOthersystems () + "\t" +
			ps.getOthersystemsSelect () + "\t" +
			ps.getPersonRowIdParref () + "\t" +
			ps.getSmoke () + "\t" +
			ps.getStaffOfUpdate () + "\t" +
			ps.getVascularName () + "\t" +
			ps.getVascularOther () + "\t" +
			ps.getYearCheckRowIdParref () + "\t" +
			ps.getYearOfExercise () + "\t" +
			ps.getYears () + "\t" +
			ps.getbDryOut () + "\n" 
			;
		FileUtil.writefile(destDir+"PersonLifeStyle/" + openId + "_" +  "1.txt",str,true);
	}
	
	private void writePersonYearCheckAccessory(PersonYearCheckAccessory pa){
		String str = 
				pa.getAccessoryRowId() + "\t" +
				pa.getHB() + "\t" +
				pa.getWBC() + "\t" +
				pa.getPLT() + "\t" +
				pa.getCBCOther() + "\t" +
				pa.getUrineProtein() + "\t" +
				pa.getUrineSugar() + "\t" +
				pa.getKET() + "\t" +
				pa.getOccultBlood() + "\t" +
				pa.getUrineRoutineOther() + "\t" +
				pa.getFecalOccultBlood() + "\t" +
				pa.getALT() + "\t" +
				pa.getAST() + "\t" +
				pa.getALB() + "\t" +
				pa.getTBIL() + "\t" +
				pa.getDBIL() + "\t" +
				pa.getScr() + "\t" +
				pa.getBUN() + "\t" +
				pa.getCHO() + "\t" +
				pa.getTG() + "\t" +
				pa.getLDLC() + "\t" +
				pa.getHDLC() + "\t" +
				pa.getFPG() + "\t" +
				pa.getPBG() + "\t" +
				pa.getEyeground() + "\t" +
				pa.getHBsAg() + "\t" +
				pa.getHbAlc() + "\t" +
				pa.getEyegroundInfo() + "\t" +
				pa.getCardiogram() + "\t" +
				pa.getCardiogramInfo() + "\t" +
				pa.getSternum() + "\t" +
				pa.getSternumInfo() + "\t" +
				pa.getXRays() + "\t" +
				pa.getXRaysInfo() + "\t" +
				pa.getImageCheck() + "\t" +
				pa.getCholesterin() + "\t" +
				pa.getOtherCheck() + "\t" +
				pa.getPH() + "\t" +
				pa.getCEA() + "\t" +
				pa.getAFP() + "\t" +
				pa.getARP() + "\t" +
				pa.getGGT() + "\t" +
				pa.getGlobulin() + "\t" +
				pa.getHbsAb() + "\t" +
				pa.getSternumSource() + "\t" +
				pa.getYearCheckRowIdParref() + "\n"
				;
		FileUtil.writefile(destDir+"PersonYearCheckAccessory/" + openId + "_" +  "1.txt",str,true);
	}
	
	private void writePersonHealthAppraise(PersonHealthAppraise pha){
		String str = 
				pha.getHealthAppraiseRowId() + "\t" +
				pha.getCheckAdd() + "\t" +
				pha.getCheckDoctor() + "\t" +
				pha.getCheckResult() + "\t" +
				pha.getCheckResultInfo() + "\t" +
				pha.getChronicControl() + "\t" +
				pha.getDangerControl() + "\t" +
				pha.getDangerInfo() + "\t" +
				pha.getDateCheck() + "\t" +
				pha.getDateOfUpdate() + "\t" +
				pha.getDeal() + "\t" +
				pha.getEvaluationScore() + "\t" +
				pha.getHealthSuggest() + "\t" +
				pha.getLiveQualityScore() + "\t" +
				pha.getMentality() + "\t" +
				pha.getMentalityCure() + "\t" +
				pha.getPeriodicalCheck() + "\t" +
				pha.getPersonRowIdParref() + "\t" +
				pha.getPhysiology() + "\t" +
				pha.getPhysiologyCure() + "\t" +
				pha.getPhysiologyInfo() + "\t" +
				pha.getRelateROWIDDR() + "\t" +
				pha.getStaffOfUpdate() + "\t" +
				pha.getYearCheckRowId() + "\n"
				;
		FileUtil.writefile(destDir+"PersonHealthAppraise/" + openId + "_" +  "1.txt",str,true);
	}
	
	private void writePersonInHosRecord(PersonInHosRecord pir){
		String str = 
				pir.getInHosRowId() + "\t" +
				pir.getDateInHos() + "\t" +
				pir.getDateOutHos() + "\t" +
				pir.getDateRegister() + "\t" +
				pir.getDeptName() + "\t" +
				pir.getDiagnose() + "\t" +
				pir.getHospitalName() + "\t" +
				pir.getInHosCode() + "\t" +
				pir.getPersonRowId() + "\t" +
				pir.getRegister() + "\t" +
				pir.getRemark() + "\t" +
				pir.getResult() + "\t" +
				pir.getYearCheckRowId() + "\n"
				;
		FileUtil.writefile(destDir+"PersonInHosRecord/" + openId + "_" +  "1.txt",str,true);
	}
	
	private void writePersonHealthDiagnose(PersonHealthDiagnose pd){
		String str = 
				pd.getDiagnoseRowId() + "\t" +
				pd.getDateOfEnd() + "\t" +
				pd.getDateOfStart() + "\t" +
				pd.getDetailRowId() + "\t" +
				pd.getDiagnoseResult() + "\t" +
				pd.getDiagnoseType() + "\t" +
				pd.getEstimate() + "\t" +
				pd.getHospitalName() + "\t" +
				pd.getICDCode() + "\t" +
				pd.getItemAssortCode() + "\t" +
				pd.getItemAssortName() + "\t" +
				pd.getItemName() + "\t" +
				pd.getItemdCode() + "\t" +
				pd.getMainDiagnose() + "\t" +
				pd.getMainPart() + "\t" +
				pd.getMainReason() + "\t" +
				pd.getMainSuit() + "\t" +
				pd.getPersonRowIdParref() + "\t" +
				pd.getRecordRowIdDR() + "\t" +
				pd.getRecordType() + "\t" +
				pd.getResult() + "\t" +
				pd.getSequenceCode() + "\t" +
				pd.getTableName() + "\t" +
				pd.getTableType() + "\n"
				;
		FileUtil.writefile(destDir+"PersonHealthDiagnose/" + openId + "_" +  "1.txt",str,true);
	}
	
	private void writePersonLongTermDrug(PersonLongTermDrug pld){
		String str = 
				pld.getDrugRowId() + "\t" +
				pld.getADR() + "\t" +
				pld.getDateOfEnd() + "\t" +
				pld.getDateOfStart() + "\t" +
				pld.getDosage() + "\t" +
				pld.getDrugCode() + "\t" +
				pld.getDrugName() + "\t" +
				pld.getPersonRowId() + "\t" +
				pld.getRecordId() + "\t" +
				pld.getRecordType() + "\t" +
				pld.getRemark() + "\t" +
				pld.getTableName() + "\t" +
				pld.getTableType() + "\t" +
				pld.getUseage() + "\n" 
				;
		FileUtil.writefile(destDir+"PersonLongTermDrug/" + openId + "_" +  "1.txt",str,true);
	}

	
	private String symptom(String str){
		String ret = "";
		String[] lsit = str.split(",");
		for(String code:lsit){
			if(code.equals("1"))
				return "";
			else if(code.equals("2"))
				code = "70";//"1";
			else if(code.equals("3"))
				code = "71";//2";
			else if(code.equals("4"))
				code = "72";//"3";
			else if(code.equals("5"))
				code = "73";//"4";
			else if(code.equals("6"))
				code = "74";//"5";
			else if(code.equals("7"))
				code = "75";//"6";
			else if(code.equals("8"))
				code = "76";//"7";
			else if(code.equals("9"))
				code = "77";//"8";
			else if(code.equals("10"))
				code = "78";//"9";
			else if(code.equals("11"))
				code = "79";//"10";
			else if(code.equals("12"))
				code = "80";//"11";
			else if(code.equals("13"))
				code = "81";// "12";
			else if(code.equals("14"))
				code = "82";//  "13";
			else if(code.equals("15"))
				code = "83";// "14";
			else if(code.equals("16"))
				code = "84";// "15";
			else if(code.equals("17"))
				code = "85";// "16";
			else if(code.equals("18"))
				code = "86";// "17";
			else if(code.equals("19"))
				code = "87";// "18";
			else if(code.equals("20"))
				code = "88";// "19";
			else if(code.equals("21"))
				code = "89";// "20";
			else if(code.equals("22"))
				code = "90";// "21";
			else if(code.equals("23"))
				code = "91";//"22";
			else if(code.equals("24"))
				code = "93";//"99";
			else if(code.equals("25"))
				code = "93";//"99";
			ret = ret + code + ",";
		}
		ret = ret.substring(0, ret.length()-1);
		return ret;
	}
	
	private String sclera(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "1";
		else if(str.equals("2")){
			ret = "2";
		}
		else if(str.equals("3")){
			ret = "3";
		}
		else if(str.equals("4")){
			ret = "9";
		}
		return ret;
	}
	
	private String skin(String str){
		String ret = "";
		if(str.equals("7"))
			ret = "99";
		else 
			ret = "0" + str;
		return ret;
	}
	
	private String lymph(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "1";
		else if(str.equals("2")){
			ret = "2";
		}
		else if(str.equals("3")){
			ret = "3";
		}
		else if(str.equals("4")){
			ret = "9";
		}
		return ret;
	}
	
	private String breathsounds(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;
	}
	
	private String noise(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;
	}
	
	private String enclosedmass(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;		
	}
	
	private String presspain(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;			
	}
	
	private String liver(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;			
	}
	
	private String spleen(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;			
	}
	
	private String voiced(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;			
	}
	
	private String breast(String str){
		String ret = "";
		if(str.equals("5"))
			ret = "9";
		else 
			ret = str;
		return ret;			
	}
	
	private String isdrinkforbiddon(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "false";
		else if(str.equals("2")){
			ret = "true";
		}
		return ret;
	}
	
	private String drinktype(String str){
		String ret = "";
		String[] lsit = str.split(",");
		for(String code:lsit){
			if(code.equals("1"))
				code = "1";
			else if(code.equals("2"))
				code = "2";
			else if(code.equals("3"))
				code = "3";
			else if(code.equals("4"))
				code = "4";
			else if(code.equals("5"))
				code = "9";
			ret = ret + code + ",";
		}
		ret = ret.substring(0, ret.length()-1);
		return ret;
	}
	
	private String chestx(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "true";
		else if(str.equals("2")){
			ret = "false";
		}
		return ret;
	}
	
	
	private String bchao(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "true";
		else if(str.equals("2")){
			ret = "false";
		}
		return ret;
	}
	
	private String cervix(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "true";
		else if(str.equals("2")){
			ret = "false";
		}
		return ret;
	}
	
	private String isnormal(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "体检无异常";
		else if(str.equals("2")){
			ret = "有异常";
		}
		return ret;
	}
	
	private String checkResultInfo(String exception1,String exception2,String exception3,String exception4){
		String ret = "";
		if(!exception1.trim().equals("")){
			ret = ret + exception1 + ",";
		}
		if(!exception2.trim().equals("")){
			ret = ret + exception2 + ",";
		}
		if(!exception3.trim().equals("")){
			ret = ret + exception3 + ",";
		}
		if(!exception4.trim().equals("")){
			ret = ret + exception4 + ",";
		}
		return ret;
	}
	
	private String healthSuggest(String str){
		String ret = "";
		if(str.equals("1"))
			ret = "纳入慢性病患者健康管理";
		else if(str.equals("2")){
			ret = "建议复查";
		}
		else if(str.equals("3")){
			ret = "建议转诊";
		}
		return ret;
	}
	
	private String dangercontrol(String str){
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
		API api = new Physical();
//		String paramStr = api.userGet(2);
//		String result = URLUtil.getResult(url, paramStr);
//		System.out.println(result);
//		System.out.println(api.finish(result));
//		api.parser(result);
//		api.down();
		
		//api.userdown("2010-01-01 01:00:00","2014-10-31 23:59:59");
		//api.userdown("2014-10-30 00:00:00","2014-11-04 23:59:59");
		//api.userdown("2014-11-05 00:00:00","2014-11-06 23:59:59");
		
		//api.userdown("2010-01-01 01:00:00","2014-11-06 23:59:59"); //重新下一次，因为血压没赋值
		api.userdown("2014-11-07 01:00:00","2014-12-15 23:59:59");
		
	}
	
}
