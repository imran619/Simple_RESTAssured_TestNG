package utilities;

import java.io.IOException;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BeforeAndAfter {

	@BeforeClass
	public void setup() {
		System.out.println("RestAssured test started......");
	}

	@AfterClass
	public void tearDown() throws IOException {
		System.out.println("RestAssured test finished......");
	}

}
