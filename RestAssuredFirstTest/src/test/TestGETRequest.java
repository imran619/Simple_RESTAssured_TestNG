package test;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import requests.GETRequest;
import utilities.BeforeAndAfter;
import utilities.ExcelRead;
import utilities.JSONConverter;
import utilities.JSONReader;

public class TestGETRequest extends BeforeAndAfter {
	
	ExcelRead excel = new ExcelRead();
	GETRequest _getRequest = new GETRequest();
	JSONConverter _jsonConverter = new JSONConverter();
	JSONReader _jsonReader = new JSONReader();

	@Test
	public void testGETUserDetails() throws IOException, ParseException {

		System.out.println("Response body is => " + _getRequest.getRequestDetails().getBody().asString());
		
		String statusCode = Integer.toString(_getRequest.getRequestDetails().getStatusCode());
		String statusLine = _getRequest.getRequestDetails().getStatusLine();
		//String expectedStatusCode = excel.readExcel(1, 4, ".\\Data\\WSData.xlsx", "GETResponse");
		
		Headers allHeaders = _getRequest.getRequestDetails().headers();

		List<Map<String, String>> names = _getRequest.getRequestDetails().jsonPath().getList("data");
		
		System.out.println(statusLine);
		System.out.println("The first name is: " + names.get(0).get("first_name"));
		System.out.println("The status code is: " + statusCode);
		
		// Iterate over all the Headers
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + "   Value: " + header.getValue());
		}

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /* actual value */, excel.readExcel(1, 4, ".\\Data\\WSData.xlsx", "GETResponse") /* expected value */, "Status code does not match");
		// Assert that correct Name is returned.
		Assert.assertEquals(names.get(0).get("first_name") /* actual value */, excel.readExcel(2, 1, ".\\Data\\WSData.xlsx", "GETResponse") /* expected value */,
				"Name does not match");

	}

}
