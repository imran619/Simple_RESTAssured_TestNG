package test;

import java.io.IOException;

import org.json.simple.parser.ParseException;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import requests.POSTRequest;
import utilities.BeforeAndAfter;
import utilities.ExcelRead;

public class TestPOSTRequest extends BeforeAndAfter {

	ExcelRead excel = new ExcelRead();
	POSTRequest _postRequest = new POSTRequest();

	@Test
	public void testPOSTRequestDetails() throws IOException, ParseException {

		System.out.println("Response body is => " + _postRequest.postRequestDetails().getBody().asString());

		String statusCode = Integer.toString(_postRequest.postRequestDetails().getStatusCode());
		String statusLine = _postRequest.postRequestDetails().getStatusLine();

		Headers allHeaders = _postRequest.postRequestDetails().headers();

		System.out.println(statusLine);
		System.out.println("The status code is: " + statusCode);
		
		String name = _postRequest.postRequestDetails().jsonPath().getString("name");
		
		// Iterate over all the Headers
		for (Header header : allHeaders) {
			System.out.println("Key: " + header.getName() + "   Value: " + header.getValue());
		}

		// Assert that correct status code is returned.
		Assert.assertEquals(statusCode /* actual value */,
				excel.readExcel(1, 2, ".\\Data\\WSData.xlsx", "CREATE_Respose") /* expected value */,
				"Status code does not match");
		// Assert that correct Name is returned.
		Assert.assertEquals(name /* actual value */,
				excel.readExcel(1, 1, ".\\Data\\WSData.xlsx", "CREATE_Respose") /* expected value */,
				"Name does not match");
	}
}
