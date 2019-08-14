package requests;

import java.io.IOException;

import org.json.simple.parser.ParseException;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import utilities.*;

public class PUTRequest {

	JSONConverter _jsonConverter = new JSONConverter(); // Use this only if you passing values from an excel file 
	JSONReader _jsonReader = new JSONReader(); // Use if if you passing values from a json file
	ExcelRead readExcelReader = new ExcelRead();

	public Response putRequestDetails() throws IOException, ParseException {
		
		RequestSpecification httprequest = RestAssured.given();

		return httprequest.headers("Content-Type", ContentType.JSON, "Accept", ContentType.JSON)
				.body(_jsonReader.readJSONFileforPutRequest())
				.put(readExcelReader.readExcel(3, 1, ".\\Data\\WSData.xlsx", "URI")).then()
				.contentType(ContentType.JSON).extract().response();
	}

}
