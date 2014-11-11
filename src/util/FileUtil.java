package util;

import java.io.File;
import java.io.FileWriter;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class FileUtil {
	
	private static Log logger = LogFactory.getLog(FileUtil.class);

	public static void writefile(String path, String content, boolean append) {
		File writefile;
		try {
			// ͨ������������ж��Ƿ����ı��ļ���׷������
			boolean addStr = append;

			writefile = new File(path);

			// ����ı��ļ��������򴴽���
			if (writefile.exists() == false) {
				writefile.createNewFile();
				writefile = new File(path); // ����ʵ����
			}
			FileWriter fw = new FileWriter(writefile, addStr);
			fw.write(content);
			fw.flush();
			fw.close();
		} catch (Exception d) {
			logger.error("write file errror:" + d.getMessage());
		}

	}
	
	public static void main(String[] args) {
		FileUtil.writefile("D:/1.txt", "222\r\n", true);
	}
	
}
