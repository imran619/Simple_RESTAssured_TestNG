package utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.JSONString;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class JSONReader {
	
	JSONParser jsonParser = new JSONParser();
	JSONString createDataList = null;
	JSONString updateDataList = null;

	public String readJSONFileforCreateRequest() throws IOException, ParseException {
		
		try (FileReader reader = new FileReader(".\\Data\\create.json")){

		// Read JSON file
		Object obj = jsonParser.parse(reader);

		createDataList = new JSONString() {

			@Override
			public String toJSONString() {
				
				return obj.toString();
			}
		};
		
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }
		return createDataList.toJSONString();
	}
	
	public String readJSONFileforPutRequest() throws IOException, ParseException {

		try(FileReader reader = new FileReader(".\\Data\\put.json")){

		// Read JSON file
		Object obj = jsonParser.parse(reader);

		updateDataList = new JSONString() {

			@Override
			public String toJSONString() {
				
				return obj.toString();
			}
		};
		} catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }		
		return updateDataList.toJSONString();
	}
}
