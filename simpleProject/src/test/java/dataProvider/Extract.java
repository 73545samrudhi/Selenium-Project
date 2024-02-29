package dataProvider;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Extract {
	
	public Object[][] getdatafromexcel() throws EncryptedDocumentException, IOException{
		FileInputStream file = new FileInputStream("C:\\sts-4.21.0.RELEASE\\simpleProject\\src\\main\\resources\\exelsheet1.xlsx");
		
		Workbook book = WorkbookFactory.create(file); //method to connect file
		
		 Sheet sheet = book.getSheet("Sheet1"); // name of exel sheet
		
		short cellsize = sheet.getRow(0).getLastCellNum(); //finding col
		
		int rowcount = sheet.getLastRowNum(); //find row
		
		Object[][] obje = new Object[rowcount][cellsize]; //2D
		
		//loop
		for(int i=0; i<rowcount; i++) {
			for(int j=0; j<cellsize; j++) {
				obje[i][j] = sheet.getRow(i).getCell(j).getStringCellValue();//find cell size
				
			}
		}
		return obje; //variable name return type
		
	}

}
