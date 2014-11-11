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
		// office2007工作区
		XSSFWorkbook wb = new XSSFWorkbook(new FileInputStream("C:/a.xlsx"));
		// 获得该工作区的第一个sheet
		XSSFSheet sheet = wb.getSheetAt(0);
		// 总共有多少行,从0开始
		int totalRows = sheet.getLastRowNum();
		for (int i = 0; i <= totalRows; i++) {
			// 取得该行
			XSSFRow row = sheet.getRow(i);
			// 注释的代码，是为了防止excel文件有空行
			// if(row == null) {
			// continue;
			// }
			// System.out.println(row.getCell(1).toString());

			
			String disname = row.getCell(6).toString(); //县级
			String towncode = row.getCell(7).toString();//乡级编码
			String townname = row.getCell(8).toString(); //乡镇
			
			//System.out.println(towncode + ":" + JDBCQuery.towncode( disname, townname));
//			FileUtil.writefile("D:/1.txt", towncode + "	" +  JDBCQuery.towncode( disname, townname) + "\n", true);
			
			String vilcode = row.getCell(9).toString();//村级编码
			String vilname = row.getCell(10).toString(); //村
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
