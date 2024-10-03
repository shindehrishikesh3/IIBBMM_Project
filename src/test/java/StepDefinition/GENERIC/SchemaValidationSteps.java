package StepDefinition.GENERIC;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import org.everit.json.schema.Schema;
import org.everit.json.schema.ValidationException;
import org.everit.json.schema.loader.SchemaLoader;
import org.json.JSONObject;
import org.json.JSONTokener;
import org.openqa.selenium.JavascriptExecutor;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;

public class SchemaValidationSteps extends WebDriverConfig {

	private ContextStore context;

	public SchemaValidationSteps(ContextStore context) {
		this.context = context;
	}
	
	String jsonValue;

	@And("^.*should be present and it should be as per the schema structure in \"(.*?)\" file$")
	public void validate_schema_structure(String fileName) throws IOException {
		String path = fileOperations.getEnvFolderPath() + fileName;
		System.out.println("File path: "+path);

		JavascriptExecutor je = (JavascriptExecutor) driver;
		long allJsonValues = (long) je
				.executeScript("return document.querySelectorAll('script[type=\"application/ld+json\"]').length");
		System.out.println("allJsonValues: "+allJsonValues);
		if(allJsonValues > 1) {
			long index = allJsonValues - 1;
			System.out.println("index: " +index);
			jsonValue = (String) je
					.executeScript("return document.querySelectorAll('script[type=\"application/ld+json\"]')["+index+"].textContent");
		}else {			
			jsonValue = (String) je
					.executeScript("return document.querySelector('script[type=\"application/ld+json\"]').textContent");
		}
		this.context.scenario.log("****Schema obtained after applying filters: " + jsonValue + "****");
		
		try(InputStream inputStream = new FileInputStream(path)) {
			System.out.println("inputStream: "+inputStream);
			JSONObject rawSchema = new JSONObject(new JSONTokener(inputStream));
			Schema schema = SchemaLoader.load(rawSchema);
			schema.validate(new JSONObject(jsonValue));
			this.context.scenario.log("Validating json with Schema as: "+schema);
			this.context.scenario.log("Schema validaion PASSED!!");
		}
	}
	
	@And ("^validate value of \"(.*?)\" is present as \"(.*?)\"$")
	public void validate_json_parameter(String parameter, String expectedValue) {
		DocumentContext jsonContext = JsonPath.parse(jsonValue);
		String actualValue = jsonContext.read("$."+parameter);
		this.context.scenario.log("Value of "+parameter+" obtained: "+actualValue);
		this.context.softAssertions.assertThat(actualValue).isEqualTo(expectedValue);
	}

}
