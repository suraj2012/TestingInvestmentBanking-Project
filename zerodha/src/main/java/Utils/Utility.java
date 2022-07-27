package Utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Utility {
	
	public static String fetchData(String sheet,int row,int col) throws EncryptedDocumentException, IOException {
		String path = "C:\\Users\\Suraj\\Desktop\\credentials.xlsx";
		FileInputStream file = new FileInputStream(path);
		
		String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		return data;
	}

}
