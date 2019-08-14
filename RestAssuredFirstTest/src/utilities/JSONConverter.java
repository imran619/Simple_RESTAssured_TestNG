package utilities;

import java.io.IOException;

public class JSONConverter {

	public String  JSonConvertCreate() throws IOException 
    {
        ExcelRead readExcelReader = new ExcelRead();
        
        String jsonStrCreate = "{" + '"' + readExcelReader.readExcel(1, 0, ".\\Data\\WSData.xlsx", "CREATE_Request") + '"' + ":" + '"' + readExcelReader.readExcel(1, 1, ".\\Data\\WSData.xlsx", "CREATE_Request") + '"'  + "," + '"' + readExcelReader.readExcel(2, 0, ".\\Data\\WSData.xlsx", "CREATE_Request") + '"' + ":" + '"' + readExcelReader.readExcel(2, 1, ".\\Data\\WSData.xlsx", "CREATE_Request") + '"' + "}";
        
        return jsonStrCreate;
    }

	public String JSonConvertUpdate() throws IOException
    {
    	ExcelRead readExcelReader = new ExcelRead();
        String jsonStrUpdate = "{" + '"' + readExcelReader.readExcel(1,0, ".\\Data\\WSData.xlsx", "PUT_Request") + '"' + ":" + '"' + readExcelReader.readExcel(1, 1, ".\\Data\\WSData.xlsx", "PUT_Request") + '"' + "," + '"' + readExcelReader.readExcel(2, 0, ".\\Data\\WSData.xlsx", "PUT_Request") + '"' + ":" + '"' + readExcelReader.readExcel(2, 1, ".\\Data\\WSData.xlsx", "PUT_Request") + '"' + "}";
        return jsonStrUpdate;
    }

}
