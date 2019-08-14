package requests;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelRead;

public class DELETERequest {
	
	ExcelRead readExcelReader = new ExcelRead();
	
	public Response deleteRequestDetails() throws IOException {
		
		RequestSpecification httprequest = RestAssured.given();

		return httprequest.contentType(ContentType.JSON).delete(readExcelReader.readExcel(4, 1, ".\\Data\\WSData.xlsx", "URI"));
	}

}
