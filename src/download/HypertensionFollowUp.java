package download;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import bean.HBPCheckRecord;
import util.FileUtil;
import util.URLUtil;

public class HypertensionFollowUp extends API{
	
	private static Log logger = LogFactory.getLog(HypertensionFollowUp.class);
	
	public HypertensionFollowUp(){
		url = "http://124.133.239.162:9898/api/hypertension_followup/list";//高血压随访--测试地址
		url = "http://119.188.126.39:8080/api/hypertension_followup/list";//正式地址
		
		sourceDir = "D:/ny/HypertensionFollowUp/sourceFile/";
		destDir = "D:/ny/HypertensionFollowUp/destFile/";
	}

	@Override
	public void papreData(int pageIndex) {
//		data = "{\"pagePara\":{\"pageSize\":2,\"pageIndex\":" + pageIndex + "}}";	
		data="<queryHypertensionReqVO><containLowerLevel>1</containLowerLevel><startCreateDate>" + startDate + "</startCreateDate><endCreateDate>" + enDate +"</endCreateDate><pagePara><pageIndex>" + pageIndex + "</pageIndex><pageSize>20</pageSize></pagePara></queryHypertensionReqVO>";
	}
	
	@Override
	public boolean finish(String xml) {
		Document docment = null;
		try {
			docment = DocumentHelper.parseText(xml); // 将字符串转为XML
			Element rootElt = docment.getRootElement(); // 获取根节点
			Iterator iter = rootElt.elementIterator("hypertensionFollowUpRecords"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next();
				Iterator it = recordEle.elementIterator("hypertensionFollowUpRecord");
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
			
			Iterator iter = rootElt.elementIterator("hypertensionFollowUpRecords"); // 获取根节点下的子节点
			// 遍历response节点
			while (iter.hasNext()) {
				Element recordEle = (Element) iter.next(); //hypertensionFollowUpRecords
				Iterator it = recordEle.elementIterator("hypertensionFollowUpRecord");
				while(it.hasNext()){
					Element hypertensionFollowUpRecord = (Element)it.next(); //hypertensionFollowUpRecord
					HBPCheckRecord hr = new HBPCheckRecord();
					hr.setDateOfUpdate(new SimpleDateFormat("yyyy-MM-dd").format(new Date()));
					
					Element idE = hypertensionFollowUpRecord.element("id");
					String id = idE!=null?idE.getText():"";
					
					Element archiveidE = hypertensionFollowUpRecord.element("archiveid");
					String archiveid = archiveidE!=null?archiveidE.getText():"";
					hr.setPersonRowIdParref(archiveid);
					
					Element customernameE = hypertensionFollowUpRecord.element("customername");
					String customername = customernameE!=null?customernameE.getText():"";
					
					Element idcardE = hypertensionFollowUpRecord.element("idcard");
					String idcard = idcardE!=null?idcardE.getText():"";
					
					Element orgProvinceCodeE = hypertensionFollowUpRecord.element("orgProvinceCode");
					String orgProvinceCode = orgProvinceCodeE!=null?orgProvinceCodeE.getText():"";
					
					Element orgCityCodeE = hypertensionFollowUpRecord.element("orgCityCode");
					String orgCityCode = orgCityCodeE!=null?orgCityCodeE.getText():"";
					
					Element orgDistrictCodeE = hypertensionFollowUpRecord.element("orgDistrictCode");
					String orgDistrictCode = orgDistrictCodeE!=null?orgDistrictCodeE.getText():"";
					
					Element orgTownCodeE = hypertensionFollowUpRecord.element("orgTownCode");
					String orgTownCode = orgTownCodeE!=null?orgTownCodeE.getText():"";
					
					Element orgVillageCodeE = hypertensionFollowUpRecord.element("orgVillageCode");
					String orgVillageCode = orgVillageCodeE!=null?orgVillageCodeE.getText():"";
					
					Element provinceCodeE = hypertensionFollowUpRecord.element("provinceCode");
					String provinceCode = provinceCodeE!=null?provinceCodeE.getText():"";
					
					Element cityCodeE = hypertensionFollowUpRecord.element("cityCode");
					String cityCode = cityCodeE!=null?cityCodeE.getText():"";
					
					Element districtCodeE = hypertensionFollowUpRecord.element("districtCode");
					String districtCode = districtCodeE!=null?districtCodeE.getText():"";
					
					Element townCodeE = hypertensionFollowUpRecord.element("townCode");
					String townCode = townCodeE!=null?townCodeE.getText():"";
					
					Element villageCodeE = hypertensionFollowUpRecord.element("villageCode");
					String villageCode = villageCodeE!=null?villageCodeE.getText():"";
					
					Element fyArchiveidE = hypertensionFollowUpRecord.element("fyArchiveid");
					String fyArchiveid = fyArchiveidE!=null?fyArchiveidE.getText():"";
					
					Element followupdateE = hypertensionFollowUpRecord.element("followupdate");
					String followupdate = followupdateE!=null?followupdateE.getText():"";
					hr.setDateCheck(followupdate);
					
					Element followupdoctorE = hypertensionFollowUpRecord.element("followupdoctor");
					String followupdoctor = followupdoctorE!=null?followupdoctorE.getText():"";
					hr.setCheckDoctor(followupdoctor);
					
					Element nextfollowupdateE = hypertensionFollowUpRecord.element("nextfollowupdate");
					String nextfollowupdate = nextfollowupdateE!=null?nextfollowupdateE.getText():"";
					hr.setBookingDate(nextfollowupdate);
			
					Element symptomE = hypertensionFollowUpRecord.element("symptom");
					String symptom = symptomE!=null?symptomE.getText():"";
					hr.setSymptom(symptom);
	
					Element symptomotherE = hypertensionFollowUpRecord.element("symptomother");
					String symptomother = symptomotherE!=null?symptomotherE.getText():"";
					hr.setOtherSymptom(symptomother);
					
					Element hypertensionE = hypertensionFollowUpRecord.element("hypertension");
					String hypertension = hypertensionE!=null?hypertensionE.getText():"";
					
					Element hypotensionE = hypertensionFollowUpRecord.element("hypotension");
					String hypotension = hypotensionE!=null?hypotensionE.getText():"";
					
					Element weightE = hypertensionFollowUpRecord.element("weight");
					String weight = weightE!=null?weightE.getText():"";
					hr.setWeight(weight);
					
					Element bmiE = hypertensionFollowUpRecord.element("bmi");
					String bmi = bmiE!=null?bmiE.getText():"";
					hr.setBMI(bmi);
					
					Element heartrateE = hypertensionFollowUpRecord.element("heartrate");
					String heartrate = heartrateE!=null?heartrateE.getText():"";
					hr.setHeartRate(heartrate);
					
					Element physicalsymptomotherE = hypertensionFollowUpRecord.element("physicalsymptomother");
					String physicalsymptomother = physicalsymptomotherE!=null?physicalsymptomotherE.getText():"";
					
					Element dailysmokenumE = hypertensionFollowUpRecord.element("dailysmokenum");
					String dailysmokenum = dailysmokenumE!=null?dailysmokenumE.getText():"";
					hr.setSmokeNum(dailysmokenum);
					
					Element dailydrinknumE = hypertensionFollowUpRecord.element("dailydrinknum");
					String dailydrinknum = dailydrinknumE!=null?dailydrinknumE.getText():"";
					hr.setDrinkQuentity(dailydrinknum);
					
					Element sporttimeperweekE = hypertensionFollowUpRecord.element("sporttimeperweek");
					String sporttimeperweek = sporttimeperweekE!=null?sporttimeperweekE.getText():"";
					hr.setExercise(sporttimeperweek);
					
					Element sportperminutetimeE = hypertensionFollowUpRecord.element("sportperminutetime");
					String sportperminutetime = sportperminutetimeE!=null?sportperminutetimeE.getText():"";
					hr.setExerciseMin(sportperminutetime);
				
					Element eatsalttypeE = hypertensionFollowUpRecord.element("eatsalttype");
					String eatsalttype = eatsalttypeE!=null?eatsalttypeE.getText():"";
					
					Element eatsalttargetE = hypertensionFollowUpRecord.element("eatsalttarget");
					String eatsalttarget = eatsalttargetE!=null?eatsalttargetE.getText():"";
				
					Element psychoadjustmentE = hypertensionFollowUpRecord.element("psychoadjustment");
					String psychoadjustment = psychoadjustmentE!=null?psychoadjustmentE.getText():"";
					hr.setMentalityAdjust(psychoadjustment);
				
					Element obeydoctorbehaviorE = hypertensionFollowUpRecord.element("obeydoctorbehavior");
					String obeydoctorbehavior = obeydoctorbehaviorE!=null?obeydoctorbehaviorE.getText():"";
					hr.setComplyDoctor(obeydoctorbehavior);
					
					Element assistantexamE = hypertensionFollowUpRecord.element("assistantexam");
					String assistantexam = assistantexamE!=null?assistantexamE.getText():"";
					hr.setOtherCheck(assistantexam);
					
					Element medicationcomplianceE = hypertensionFollowUpRecord.element("medicationcompliance");
					String medicationcompliance = medicationcomplianceE!=null?medicationcomplianceE.getText():"";
					hr.setDrugRegularityRate(medicationcompliance);
					
					Element adrE = hypertensionFollowUpRecord.element("adr");
					String adr = adrE!=null?adrE.getText():"";
					
					Element adrExE = hypertensionFollowUpRecord.element("adrEx");
					String adrEx = adrExE!=null?adrExE.getText():"";
					hr.setDrugOfAdverseEffects(adrEx);
					
					Element followuptypeE = hypertensionFollowUpRecord.element("followuptype");
					String followuptype = followuptypeE!=null?followuptypeE.getText():"";
					hr.setCheckResult(followuptype);
					
					Element referralreasonE = hypertensionFollowUpRecord.element("referralreason");
					String referralreason = referralreasonE!=null?referralreasonE.getText():"";
					hr.setTransferReason(referralreason);
					
					Element referralorgE = hypertensionFollowUpRecord.element("referralorg");
					String referralorg = referralorgE!=null?referralorgE.getText():"";
					
					Element followupwayE = hypertensionFollowUpRecord.element("followupway");
					String followupway = followupwayE!=null?followupwayE.getText():"";
					hr.setCheckType(followupway);
					
					Element weighttargetE = hypertensionFollowUpRecord.element("weighttarget");
					String weighttarget = weighttargetE!=null?weighttargetE.getText():"";
					
					Element bmitargetE = hypertensionFollowUpRecord.element("bmitarget");
					String bmitarget = bmitargetE!=null?bmitargetE.getText():"";
					
					Element dailysmokenumtargetE = hypertensionFollowUpRecord.element("dailysmokenumtarget");
					String dailysmokenumtarget = dailysmokenumtargetE!=null?dailysmokenumtargetE.getText():"";
					
					Element dailydrinknumtargetE = hypertensionFollowUpRecord.element("dailydrinknumtarget");
					String dailydrinknumtarget = dailydrinknumtargetE!=null?dailydrinknumtargetE.getText():"";
					
					Element sporttimesperweektargetE = hypertensionFollowUpRecord.element("sporttimesperweektarget");
					String sporttimesperweektarget = sporttimesperweektargetE!=null?sporttimesperweektargetE.getText():"";
				
					Element sportperminutestimetargetE = hypertensionFollowUpRecord.element("sportperminutestimetarget");
					String sportperminutestimetarget = sportperminutestimetargetE!=null?sportperminutestimetargetE.getText():"";
					
					Element createdByE = hypertensionFollowUpRecord.element("createdBy");
					String createdBy = createdByE!=null?createdByE.getText():"";
					hr.setStaffInput(createdBy);
					
					Element createdDateE = hypertensionFollowUpRecord.element("createdDate");
					String createdDate = createdDateE!=null?createdDateE.getText():"";
					hr.setDateOfInput(createdDate);
					
					Element isDelE = hypertensionFollowUpRecord.element("isDel");
					String isDel = isDelE!=null?isDelE.getText():"";
					
					Element doctorSuggestionE = hypertensionFollowUpRecord.element("doctorSuggestion");
					String doctorSuggestion = doctorSuggestionE!=null?doctorSuggestionE.getText():"";
					
					Element drugCondition = hypertensionFollowUpRecord.element("drugCondition");
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
						
						Element followupType1E = drugCondition.element("followupType");
						String followupType1 = followupType1E!=null?followupType1E.getText():"";
					}
					
					Element drugCondition2 = hypertensionFollowUpRecord.element("drugCondition2");
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
						
						Element followupType2E = drugCondition.element("followupType");
						String followupType2 = followupType2E!=null?followupType2E.getText():"";
					}
					
					Element drugCondition3 = hypertensionFollowUpRecord.element("drugCondition3");
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
						
						Element followupType3E = drugCondition.element("followupType");
						String followupType3 = followupType3E!=null?followupType3E.getText():"";
					}
					
					Element drugConditionOther = hypertensionFollowUpRecord.element("drugConditionOther");
					if(drugConditionOther!=null){
						Element drugid4E = drugConditionOther.element("id");
						String drugid4 = drugid4E!=null?drugid4E.getText():"";
						
						Element followupid4E = drugConditionOther.element("followupid");
						String followupid4 = followupid4E!=null?followupid4E.getText():"";
						
						Element name4E = drugConditionOther.element("name");
						String name4 = name4E!=null?name4E.getText():"";
						
						Element dailytime4E = drugConditionOther.element("dailytime");
						String dailytime4 = dailytime4E!=null?dailytime4E.getText():"";
						
						Element everytimemg4E = drugConditionOther.element("everytimemg");
						String everytimemg4 = everytimemg4E!=null?everytimemg4E.getText():"";
						
						Element followupType4E = drugCondition.element("followupType");
						String followupType4 = followupType4E!=null?followupType4E.getText():"";
					}
					
					writeTxt(hr);
					
				}
			}
		}catch (Exception e) {
			logger.error("parse xml is error :" + e.getMessage());
			e.printStackTrace();
		}
		
		//FileUtil.writefile(sourceDir +  openId + "_" +pageIndex + ".txt", xml, false);
		FileUtil.writefile(sourceDir + openId + "_" + startDate.substring(0, 10) + "_" + enDate.substring(0, 10) + "_" +pageIndex + ".txt", xml, false);
	}
	
	private void writeTxt(HBPCheckRecord hr){
		String str = 
				hr.getRowId() + "\t" +
				hr.getBMI() + "\t" +
				hr.getBloodAfterDining() + "\t" +
				hr.getBloodAfterDiningOfTwo() + "\t" +
				hr.getBloodSurgeLimosis() + "\t" +
				hr.getBookingDate() + "\t" +
				hr.getCheckAdd() + "\t" +
				hr.getCheckDoctor() + "\t" +
				hr.getCheckResult() + "\t" +
				hr.getCheckType() + "\t" +
				hr.getChecker() + "\t" +
				hr.getCholesterin() + "\t" +
				hr.getComplyDoctor() + "\t" +
				hr.getDangerousFactor() + "\t" +
				hr.getDateCheck() + "\t" +
				hr.getDateOfCheck() + "\t" +
				hr.getDateOfInput() + "\t" +
				hr.getDateOfStopDrink() + "\t" +
				hr.getDateOfStopSmoke() + "\t" +
				hr.getDateOfUpdate() + "\t" +
				hr.getDeal() + "\t" +
				hr.getDirection() + "\t" +
				hr.getDoseComplier() + "\t" +
				hr.getDrink() + "\t" +
				hr.getDrinkQuentity() + "\t" +
				hr.getDrugOfAdverseEffects() + "\t" +
				hr.getDrugRegularityRate() + "\t" +
				hr.getDrugSideEffect() + "\t" +
				hr.getEatDrug() + "\t" +
				hr.getExercise() + "\t" +
				hr.getExerciseMin() + "\t" +
				hr.getExerciseNum() + "\t" +
				hr.getFood() + "\t" +
				hr.getFootArteryThrob() + "\t" +
				hr.getHb() + "\t" +
				hr.getHbAlC() + "\t" +
				hr.getHeartRate() + "\t" +
				hr.getHeight() + "\t" +
				hr.getIsExcel() + "\t" +
				hr.getMentalityAdjust() + "\t" +
				hr.getNAlbumen() + "\t" +
				hr.getNOther() + "\t" +
				hr.getNonDrugTherapy() + "\t" +
				hr.getOther() + "\t" +
				hr.getOtherCheck() + "\t" +
				hr.getOtherOfBlood() + "\t" +
				hr.getOtherSymptom() + "\t" +
				hr.getPersonRowIdParref() + "\t" +
				hr.getRemark() + "\t" +
				hr.getSmoke() + "\t" +
				hr.getSmokeNum() + "\t" +
				hr.getStaffInput() + "\t" +
				hr.getSugarInDay() + "\t" +
				hr.getSymptom() + "\t" +
				hr.getTransferDept() + "\t" +
				hr.getTransferReason() + "\t" +
				hr.getUniteIll() + "\t" +
				hr.getWaistlineStern() + "\t" +
				hr.getWeight() + "\t" +
				hr.getbAdverseEffects() + "\t" +
				hr.getbBooking() + "\t" +
				hr.getbDrink() + "\t" +
				hr.getbSmoke() + "\t" +
				hr.getbTranfer() + "\t" +
				hr.getnHighPressure() + "\t" +
				hr.getnLowPressure() + "\n" 
				;
		FileUtil.writefile(destDir + openId + "_" +"1.txt",str,true);
	}
	
	
	public static void main(String[] args) {
		API api = new HypertensionFollowUp();
//		String paramStr = api.userGet(1);
//		String result = URLUtil.getResult(url, paramStr);
//		System.out.println(result);
//		System.out.println(api.finish(result));
//		api.parser(result);
		
		//api.userdown("2010-01-01 01:00:00","2014-10-31 23:59:59");
		api.userdown("2014-10-30 00:00:00","2014-11-04 23:59:59");
	}

}
