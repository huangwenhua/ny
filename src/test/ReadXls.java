package test;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import util.FileUtil;

public class ReadXls {

	public static void read() throws FileNotFoundException, IOException {
		// office2007������
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:/a.xlsx"));
		// ��øù������ĵ�һ��sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		// �ܹ��ж�����,��0��ʼ
		int totalRows = sheet.getLastRowNum();
		for (int i = 0; i <= totalRows; i++) {
			// ȡ�ø���
			XSSFRow row = sheet.getRow(i);
			// ע�͵Ĵ��룬��Ϊ�˷�ֹexcel�ļ��п���
			// if(row == null) {
			// continue;
			// }
			// System.out.println(row.getCell(1).toString());

			
			String disname = row.getCell(6).toString(); //�ؼ�
			String towncode = row.getCell(7).toString();//�缶����
			String townname = row.getCell(8).toString(); //����
			
			//System.out.println(towncode + ":" + JDBCQuery.towncode( disname, townname));
//			FileUtil.writefile("D:/1.txt", towncode + "	" +  JDBCQuery.towncode( disname, townname) + "\n", true);
			
			String vilcode = row.getCell(9).toString();//�弶����
			String vilname = row.getCell(10).toString(); //��
			//System.out.println(vilcode + ":" + JDBCQuery.vilcode( disname, townname,vilname));
			FileUtil.writefile("D:/2.txt", vilcode + "	" + JDBCQuery.vilcode( disname, townname,vilname) + "\n", true);
		}
	}

	public static void main(String[] args) {
		try {
			ReadXls.read();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
