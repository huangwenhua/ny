package download;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import bean.DiabetesCheckRecord;
import util.FileUtil;

public class DiabetesFollowup extends API{
	
	private static Log logger = LogFactory.getLog(DiabetesFollowup.class);
	
	public DiabetesFollowup(){
		//url = "http://124.133.239.162:9898/api/diabetes_followup/list";//糖尿病随访--测试地址
		url = "http://119.188.126.39:8080/api/diabetes_followup/list";//正式地址
		
		sourceDir = "D:/ny/DiabetesFollowup/sourceFile/";
		destDir = "D:/ny/DiabetesFollowup/destFile/";
	}

	@Override
	public void papreData(int pageIndex) {
//		data = "{\"pagePara\":{\"pageSize\":2,\"pageIndex\":" + pageIndex + "}}";	
		data="<queryDiabetesReqVO><containLowerLevel>1</containLowerLevel><startCreateDate>" + startDate + "</startCreateDate><endCreateDate>" + enDate +"</endCreateDate><pagePara><pageIndex>" + pageIndex + "</pageIndex><pageSize>20</pageSize></pagePara></queryDiabetesReqVO>";
	}
	
	@Override
	public boolean finish(String xml) {
		Document docment = null;
		try {
			docment = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = docment.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator("records"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator it = recordEle.elementIterator("diabetesFollowUpRecord");
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
			
			Iterator iter = rootElt.elementIterator("records"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next(); //records
				Iterator it = recordEle.elementIterator("diabetesFollowUpRecord");
				while(it.hasNext()){
					Element diabetesFollowUpRecord = (Element)it.next(); //diabetesFollowUpRecord
					DiabetesCheckRecord dr = new DiabetesCheckRecord();
					dr.setDateOfUpdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					
					Element idE = diabetesFollowUpRecord.element("id");
					String id = idE!=null?idE.getText():"";
					//dr.setRowId(id);
					
					Element archiveidE = diabetesFollowUpRecord.element("archiveid");
					String archiveid = archiveidE!=null?archiveidE.getText():"";
					dr.setPersonRowIdParref(archiveid);
					
					Element customernameE = diabetesFollowUpRecord.element("customername");
					String customername = customernameE!=null?customernameE.getText():"";
					
					Element followupDateE = diabetesFollowUpRecord.element("followupDate");
					String followupDate = followupDateE!=null?followupDateE.getText():"";
					dr.setDateCheck(followupDate);
					
					Element followupdoctorE = diabetesFollowUpRecord.element("followupdoctor");
					String followupdoctor = followupdoctorE!=null?followupdoctorE.getText():"";
					dr.setCheckDoctor(followupdoctor);
					
					Element nextfollowupDateE = diabetesFollowUpRecord.element("nextfollowupDate");
					String nextfollowupDate = nextfollowupDateE!=null?nextfollowupDateE.getText():"";
					
					Element symptomE = diabetesFollowUpRecord.element("symptom");
					String symptom = symptomE!=null?symptomE.getText():"";
					dr.setSymptom(symptom);
					
					Element symptomotherE = diabetesFollowUpRecord.element("symptomother");
					String symptomother = symptomotherE!=null?symptomotherE.getText():"";
					dr.setOtherSymptom(symptomother);
					
					Element bmiE = diabetesFollowUpRecord.element("bmi");
					String bmi = bmiE!=null?bmiE.getText():"";
					dr.setBMI(bmi);
					
					Element dorsalispedispulseE = diabetesFollowUpRecord.element("dorsalispedispulse");
					String dorsalispedispulse = dorsalispedispulseE!=null?dorsalispedispulseE.getText():"";
					dr.setFootArteryThrob(dorsalispedispulse);
					
					Element physicalsymptomotherE = diabetesFollowUpRecord.element("physicalsymptomother");
					String physicalsymptomother = physicalsymptomotherE!=null?physicalsymptomotherE.getText():"";
					
					Element dailysmokenumE = diabetesFollowUpRecord.element("dailysmokenum");
					String dailysmokenum = dailysmokenumE!=null?dailysmokenumE.getText():"";
					dr.setSmokeNum(dailysmokenum);
					
					Element dailydrinknumE = diabetesFollowUpRecord.element("dailydrinknum");
					String dailydrinknum = dailydrinknumE!=null?dailydrinknumE.getText():"";
					
					Element sporttimeperweekE = diabetesFollowUpRecord.element("sporttimeperweek");
					String sporttimeperweek = sporttimeperweekE!=null?sporttimeperweekE.getText():"";
					dr.setExercise(sporttimeperweek);
					
					Element sportperminutetimeE = diabetesFollowUpRecord.element("sportperminutetime");
					String sportperminutetime = sportperminutetimeE!=null?sportperminutetimeE.getText():"";
					dr.setExerciseMin(sportperminutetime);
					
					Element staplefooddailygE = diabetesFollowUpRecord.element("staplefooddailyg");
					String staplefooddailyg = staplefooddailygE!=null?staplefooddailygE.getText():"";
					
					Element psychoadjustmentE = diabetesFollowUpRecord.element("psychoadjustment");
					String psychoadjustment = psychoadjustmentE!=null?psychoadjustmentE.getText():"";
					dr.setMentalityAdjust(psychoadjustment);
					
					Element obeydoctorbehaviorE = diabetesFollowUpRecord.element("obeydoctorbehavior");
					String obeydoctorbehavior = obeydoctorbehaviorE!=null?obeydoctorbehaviorE.getText():"";
					dr.setComplyDoctor(obeydoctorbehavior);
					
					Element heartrateE = diabetesFollowUpRecord.element("heartrate");
					String heartrate = heartrateE!=null?heartrateE.getText():"";
					dr.setHeartRate(heartrate);
					
					Element hbalcE = diabetesFollowUpRecord.element("hbalc");
					String hbalc = hbalcE!=null?hbalcE.getText():"";
					dr.setHbAlC(hbalc);
					
					Element fpgE =  diabetesFollowUpRecord.element("fpg");
					String fpg = fpgE!=null?fpgE.getText():"";
					dr.setBloodSurgeLimosis(fpg);
					
					Element examdateE = diabetesFollowUpRecord.element("examdate");
					String examdate = examdateE!=null?examdateE.getText():"";
					
					Element assistantexamE = diabetesFollowUpRecord.element("assistantexam");
					String assistantexam = assistantexamE!=null?assistantexamE.getText():"";
					dr.setOtherCheck(assistantexam);
					
					Element medicationcomplianceE = diabetesFollowUpRecord.element("medicationcompliance");
					String medicationcompliance = medicationcomplianceE!=null?medicationcomplianceE.getText():"";
					dr.setBloodSurgeRate(medicationcompliance);
					
					Element adrE = diabetesFollowUpRecord.element("adr");
					String adr = adrE!=null?adrE.getText():"";
					
					Element adrExE = diabetesFollowUpRecord.element("adrEx");
					String adrEx = adrExE!=null?adrExE.getText():"";
					dr.setDrugOfAdverseEffects(adrEx);
					
					Element followuptypeE = diabetesFollowUpRecord.element("followuptype");
					String followuptype = followuptypeE!=null?followuptypeE.getText():"";
					dr.setCheckResult(followuptype);
					
					Element insulintypeE = diabetesFollowUpRecord.element("insulintype");
					String insulintype = insulintypeE!=null?insulintypeE.getText():"";
					
					Element insulinusageE = diabetesFollowUpRecord.element("insulinusage");
					String insulinusage = insulinusageE!=null?insulinusageE.getText():"";
					
					Element followupwayE = diabetesFollowUpRecord.element("followupway");
					String followupway = followupwayE!=null?followupwayE.getText():"";
					dr.setCheckType(followupway);
					
					Element referralreasonE = diabetesFollowUpRecord.element("referralreason");
					String referralreason = referralreasonE!=null?referralreasonE.getText():"";
					dr.setTransferReason(referralreason);
					
					Element referralorgE = diabetesFollowUpRecord.element("referralorg");
					String referralorg = referralorgE!=null?referralorgE.getText():"";
					
					Element weighttargetE = diabetesFollowUpRecord.element("weighttarget");
					String weighttarget = weighttargetE!=null?weighttargetE.getText():"";
					
					Element weightE = diabetesFollowUpRecord.element("weight");
					String weight = weightE!=null?weightE.getText():"";
					dr.setWeight(weight);
					
					Element bmitargetE = diabetesFollowUpRecord.element("bmitarget");
					String bmitarget = bmitargetE!=null?bmitargetE.getText():"";
					
					Element dailysmokenumtargetE = diabetesFollowUpRecord.element("dailysmokenumtarget");
					String dailysmokenumtarget = dailysmokenumtargetE!=null?dailysmokenumtargetE.getText():"";
					
					Element dailydrinknumtargetE = diabetesFollowUpRecord.element("dailydrinknumtarget");
					String dailydrinknumtarget = dailydrinknumtargetE!=null?dailydrinknumtargetE.getText():"";
					dr.setDrinkQuentity(dailydrinknumtarget);
					
					Element sporttimesperweektargetE = diabetesFollowUpRecord.element("sporttimesperweektarget");
					String sporttimesperweektarget = sporttimesperweektargetE!=null?sporttimesperweektargetE.getText():"";
					
					Element sportperminutestimetargetE = diabetesFollowUpRecord.element("sportperminutestimetarget");
					String sportperminutestimetarget = sportperminutestimetargetE!=null?sportperminutestimetargetE.getText():"";
					
					Element createdByE = diabetesFollowUpRecord.element("createdBy");
					String createdBy = createdByE!=null?createdByE.getText():"";
					dr.setStaffInput(createdBy);
					
					Element createdDateE = diabetesFollowUpRecord.element("createdDate");
					String createdDate = createdDateE!=null?createdDateE.getText():"";
					
					Element isDelE = diabetesFollowUpRecord.element("isDel");
					String isDel = isDelE!=null?isDelE.getText():"";
					
					Element staplefooddailygtargetE = diabetesFollowUpRecord.element("staplefooddailygtarget");
					String staplefooddailygtarget = staplefooddailygtargetE!=null?staplefooddailygtargetE.getText():"";
					
					Element hypoglycemiarreactionE = diabetesFollowUpRecord.element("hypoglycemiarreaction");
					String hypoglycemiarreaction = hypoglycemiarreactionE!=null?hypoglycemiarreactionE.getText():"";
					
					Element idcardE = diabetesFollowUpRecord.element("idcard");
					String idcard = idcardE!=null?idcardE.getText():"";
					
					Element orgProvinceCodeE = diabetesFollowUpRecord.element("orgProvinceCode");
					String orgProvinceCode = orgProvinceCodeE!=null?orgProvinceCodeE.getText():"";
					
					Element orgCityCodeE = diabetesFollowUpRecord.element("orgCityCode");
					String orgCityCode = orgCityCodeE!=null?orgCityCodeE.getText():"";
					
					Element orgDistrictCodeE = diabetesFollowUpRecord.element("orgDistrictCode");
					String orgDistrictCode = orgDistrictCodeE!=null?orgDistrictCodeE.getText():"";
					
					Element orgTownCodeE = diabetesFollowUpRecord.element("orgTownCode");
					String orgTownCode = orgTownCodeE!=null?orgTownCodeE.getText():"";
					
					Element orgVillageCodeE = diabetesFollowUpRecord.element("orgVillageCode");
					String orgVillageCode = orgVillageCodeE!=null?orgVillageCodeE.getText():"";
					
					Element drugCondition = diabetesFollowUpRecord.element("drugCondition");
					if(drugCondition!=null){
						Element drugid1E = drugCondition.element("id");
						String drugid1 = drugid1E!=null?drugid1E.getText():"";
						
						Element followupid1E = drugCondition.element("followupid");
						String followupid1 = followupid1E!=null?followupid1E.getText():"";
						
						Element name1E = drugCondition.element("name");
						String name1 = name1E!=null?name1E.getText():"";
						
						Element dailytime1E = drugCondition.element("dailytime");
						String dailytime1 = dailytime1E!=null?dailytime1E.getText():"";
						
						Element everytimemg1E = drugCondition.element("everytimemg");
						String everytimemg1 = everytimemg1E!=null?everytimemg1E.getText():"";
					}
					
					Element drugCondition2 = diabetesFollowUpRecord.element("drugCondition2");
					if(drugCondition2!=null){
						Element drugid2E = drugCondition2.element("id");
						String drugid2 = drugid2E!=null?drugid2E.getText():"";
						
						Element followupid2E = drugCondition2.element("followupid");
						String followupid2 = followupid2E!=null?followupid2E.getText():"";
						
						Element name2E = drugCondition2.element("name");
						String name2 = name2E!=null?name2E.getText():"";
						
						Element dailytime2E = drugCondition2.element("dailytime");
						String dailytime2 = dailytime2E!=null?dailytime2E.getText():"";
						
						Element everytimemg2E = drugCondition2.element("everytimemg");
						String everytimemg2 = everytimemg2E!=null?everytimemg2E.getText():"";
					}
					
					Element drugCondition3 = diabetesFollowUpRecord.element("drugCondition3");
					if(drugCondition3!=null){
						Element drugid3E = drugCondition3.element("id");
						String drugid3 = drugid3E!=null?drugid3E.getText():"";
						
						Element followupid3E = drugCondition3.element("followupid");
						String followupid3 = followupid3E!=null?followupid3E.getText():"";
						
						Element name3E = drugCondition3.element("name");
						String name3 = name3E!=null?name3E.getText():"";
						
						Element dailytime3E = drugCondition3.element("dailytime");
						String dailytime3 = dailytime3E!=null?dailytime3E.getText():"";
						
						Element everytimemg3E = drugCondition3.element("everytimemg");
						String everytimemg3 = everytimemg3E!=null?everytimemg3E.getText():"";
					}
					
					writeTxt(dr);
					
				}
			}
		} catch (Exception e) {
			logger.error("parse xml is error :" + e.getMessage());
			e.printStackTrace();
		}
		FileUtil.writefile(sourceDir + openId + "_" + startDate.substring(0, 10) + "_" + enDate.substring(0, 10) + "_" + pageIndex + ".txt", xml, false);
	}

	
//	@Override
//	public void down() {
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
//		
//	}
	
	private void writeTxt(DiabetesCheckRecord dr){
		String str = 
				dr.getRowId() + "\t" +
				dr.getBMI() + "\t" +
				dr.getBloodAfterDining() + "\t" +
				dr.getBloodAfterDiningOfTwo() + "\t" +
				dr.getBloodSurgeLimosis() + "\t" +
				dr.getBloodSurgeRate() + "\t" +
				dr.getBookingDate() + "\t" +
				dr.getCaseType() + "\t" +
				dr.getCheckAdd() + "\t" +
				dr.getCheckDoctor() + "\t" +
				dr.getCheckResult() + "\t" +
				dr.getCheckType() + "\t" +
				dr.getCholesterin() + "\t" +
				dr.getComplyDoctor() + "\t" +
				dr.getDateCheck() + "\t" +
				dr.getDateOfInput() + "\t" +
				dr.getDateOfStopDrink() + "\t" +
				dr.getDateOfStopSmoke() + "\t" +
				dr.getDateOfUpdate() + "\t" +
				dr.getDeal() + "\t" +
				dr.getDirection() + "\t" +
				dr.getDoseComplier() + "\t" +
				dr.getDrink() + "\t" +
				dr.getDrinkQuentity() + "\t" +
				dr.getDrugOfAdverseEffects() + "\t" +
				dr.getDrugRegularityRate() + "\t" +
				dr.getDrugSideEffect() + "\t" +
				dr.getEatDrug() + "\t" +
				dr.getExercise() + "\t" +
				dr.getExerciseMin() + "\t" +
				dr.getExerciseNum() + "\t" +
				dr.getEyeground() + "\t" +
				dr.getFood() + "\t" +
				dr.getFootArteryThrob() + "\t" +
				dr.getHb() + "\t" +
				dr.getHbAlC() + "\t" +
				dr.getHeartRate() + "\t" +
				dr.getHeight() + "\t" +
				dr.getIsExcel() + "\t" +
				dr.getLowSurgeReflection() + "\t" +
				dr.getMentalStatus() + "\t" +
				dr.getMentalityAdjust() + "\t" +
				dr.getNAlbumen() + "\t" +
				dr.getNOther() + "\t" +
				dr.getOther() + "\t" +
				dr.getOtherCheck() + "\t" +
				dr.getOtherOfBlood() + "\t" +
				dr.getOtherSymptom() + "\t" +
				dr.getPersonRowIdParref() + "\t" +
				dr.getRemark() + "\t" +
				dr.getSmoke() + "\t" +
				dr.getSmokeNum() + "\t" +
				dr.getStaffInput() + "\t" +
				dr.getStern() + "\t" +
				dr.getSugarInDay() + "\t" +
				dr.getSymptom() + "\t" +
				dr.getTransferDept() + "\t" +
				dr.getTransferReason() + "\t" +
				dr.getUniteIll() + "\t" +
				dr.getWaistline() + "\t" +
				dr.getWaistlineStern() + "\t" +
				dr.getWeight() + "\t" +
				dr.getbAdverseEffects() + "\t" +
				dr.getbBooking() + "\t" +
				dr.getbCaseTrans() + "\t" +
				dr.getbDrink() + "\t" +
				dr.getbSmoke() + "\t" +
				dr.getbTranfer() + "\t" +
				dr.getnHighPressure() + "\t" +
				dr.getnLowPressure() + "\n"
				;
		
		FileUtil.writefile(destDir + openId + "_" + "1.txt",str,true);
	}

	public static void main(String[] args) {
		API api = new DiabetesFollowup();
//		String paramStr = api.userGet(1);
//		String result = URLUtil.getResult(url, paramStr);
//		System.out.println(result);
//		System.out.println(api.finish(result));
//		api.parser(result);
//		api.down();
		
		//api.userdown("2010-01-01 01:00:00","2014-10-31 23:59:59");
		api.userdown("2014-10-30 00:00:00","2014-11-04 23:59:59");
	}
	
}
