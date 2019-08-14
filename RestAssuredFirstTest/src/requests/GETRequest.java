package requests;

import java.io.IOException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.parsing.Parser;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.ExcelRead;

public class GETRequest {

	ExcelRead excel = new ExcelRead();
	
	public Response getRequestDetails() throws IOException {		

		RestAssured.defaultParser = Parser.JSON;

		RequestSpecification httprequest = RestAssured.given();

		Response response = httprequest.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON).
                when().get(excel.readExcel(1, 1, ".\\Data\\WSData.xlsx", "URI")).
                then().contentType(ContentType.JSON).extract().response(); 
		
		return response;
	}
}
