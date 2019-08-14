package test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.Header;
import io.restassured.http.Headers;
import requests.DELETERequest;
import utilities.ExcelRead;

public class TestDELETERequest {
	
	ExcelRead excel = new ExcelRead();
	DELETERequest _deleteRequest = new DELETERequest();
	
	@Test
	public void testDELETERequestDetails() throws IOException {
		
		System.out.println("Response body is => " + _deleteRequest.deleteRequestDetails().getBody().asString());
		
		String statusCode = Integer.toString(_deleteRequest.deleteRequestDetails().getStatusCode());
		String statusLine = _deleteRequest.deleteRequestDetails().getStatusLine();

		Headers allHeaders = _deleteRequest.deleteRequestDetails().headers();

		System.out.println(statusLine);
		System.out.println("The status code is: " + statusCode);
		
		// Iterate over all the Headers
				for (Header header : allHeaders) {
					System.out.println("Key: " + header.getName() + "   Value: " + header.getValue());
				}

				// Assert that correct status code is returned.
				Assert.assertEquals(statusCode /* actual value */,
						excel.readExcel(1, 0, ".\\Data\\WSData.xlsx", "DELETE_Response") /* expected value */,
						"Status code does not match");
	}

}
