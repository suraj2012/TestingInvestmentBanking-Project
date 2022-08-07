package Utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utils {
	
	
	public static String fetchData(String sheet,int row,int col) throws EncryptedDocumentException, IOException {
		String path = "C:\\Users\\Suraj\\Desktop\\credentials.xlsx";
		FileInputStream file = new FileInputStream(path);
		
		String data = WorkbookFactory.create(file).getSheet(sheet).getRow(row).getCell(col).getStringCellValue();
		return data;
	}
	public static void screenshot(WebDriver driver, int testId) throws IOException {
		Date d = new Date();
		System.out.println(d);
		String fileName=d.toString().replace(":", "_").replace(" " , "_");
		File sourse = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("test-output\\Screenshot\\"+fileName+"_"+testId+""+".jpg");
		FileHandler.copy(sourse, dest);
	}

}
