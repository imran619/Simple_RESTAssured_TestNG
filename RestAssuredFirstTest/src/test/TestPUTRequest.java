package test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import requests.PUTRequest;
import utilities.ExcelRead;

public class TestPUTRequest {
	
	ExcelRead excel = new ExcelRead();
	PUTRequest _putRequest = new PUTRequest();
	
	@Test
	public void testPUTRequestDetails() throws IOException, ParseException {
		
		System.out.println("Response body is => " + _putRequest.putRequestDetails().getBody().asString());
		
		String statusCode = Integer.toString(_putRequest.putRequestDetails().getStatusCode());
		String statusLine = _putRequest.putRequestDetails().getStatusLine();

		Headers allHeaders = _putRequest.putRequestDetails().headers();

		System.out.println(statusLine);
		System.out.println("The status code is: " + statusCode);
		
		String name = _putRequest.putRequestDetails().jsonPath().getString("name");
		
		// Iterate over all the Headers
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + "   Value: " + header.getValue());
		}

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /* actual value */,
				excel.readExcel(1, 2, ".\\Data\\WSData.xlsx", "PUT_Response") /* expected value */,
				"Status code does not match");
		// Assert that correct Name is returned.
		Assert.assertEquals(name /* actual value */,
				excel.readExcel(1, 1, ".\\Data\\WSData.xlsx", "PUT_Response") /* expected value */,
				"Name does not match");
		
	}
}
