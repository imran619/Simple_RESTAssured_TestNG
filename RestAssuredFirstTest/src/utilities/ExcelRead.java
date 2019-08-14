package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {
	XSSFWorkbook ExcelWBook;
	public String readExcel(int row, int col, String fileName, String sheetName) throws IOException {
		
		File file = new File(fileName);
		FileInputStream inputStream = new FileInputStream(file);

		ExcelWBook = new XSSFWorkbook(inputStream);
		XSSFSheet excelSheet = ExcelWBook.getSheet(sheetName);
		DataFormatter formatter = new DataFormatter();
		//return excelSheet.getRow(row).getCell(col).getStringCellValue().toString();
		
		return formatter.formatCellValue(excelSheet.getRow(row).getCell(col)).toString();
	}
	
	public void closeExcel() throws IOException {
		ExcelWBook.close();
	}
	
}
