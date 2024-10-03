package StepDefinition.Analytics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.UtilitySteps;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

public class DigitalDataSteps extends WebDriverConfig {
	
	ReadContext readContext;
    private static final Logger logger = LogManager.getLogger(UtilitySteps.class);

    private ContextStore context;
    String currentPage;

    public DigitalDataSteps(ContextStore context) {
        this.context = context;
    }
	
	
	@SuppressWarnings("unchecked")
	@And("^I Execute digitaldata command for \"([^\"]*)\"$")
	public void digitaldataqueryparameter(String keyword) {
		JavascriptExecutor jse = (JavascriptExecutor) getDriver();
		Map<String, Object> results = (Map<String, Object>) (jse.executeScript("return digitalData"));
		this.readContext = JsonPath.parse(results);
		System.out.println(readContext.jsonString());
		currentPage = keyword;
		this.context.scenario.log("==========" + keyword + "=============");
	}
	
	 @Then("^verify below key values are exact match in \"([^\"]*)\" node$")
	    public void digitaldataCommand(String nodename,DataTable table){

	    	Map<String, String> expectedMap = new HashMap<String, String>(
	                table.asMap(String.class, String.class)
	            );

	        if(expectedMap.get("pageName") != null &&expectedMap.get("pageName").equalsIgnoreCase("{getPageTitle}")){
	        	expectedMap.put("pageName", getDriver().findElement(By.tagName("title")).getAttribute("textContent")
	                    .replaceAll("[-,\\s+]", "").trim());
	        }

	         for(String key: expectedMap.keySet()){
	            String actualValue = this.readContext.read("$."+nodename+"." + key).toString();
	            if(key.equals("pageName")){
	                actualValue = actualValue.replaceAll("[-,\\s+]", "").trim();
	            }
	            this.context.softAssertions.assertThat(actualValue)
	            .overridingErrorMessage("page: %s Key:%s Expected:%s Actual:%s",
	                     currentPage,
	                     key,
	                     expectedMap.get(key),
	                     actualValue)
	                .isEqualTo(expectedMap.get(key));
	         }
	    }
	    
	    @And("^verify below key string values are not empty for \"([^\"]*)\" node$")
	    public void digitaldata_keyvalues_notnull(String nodename, DataTable table) {
	    	List<String> expectedList = new ArrayList<String>(table.asList(String.class));
	    	for (String key : expectedList) {
	    		String actualValue = this.readContext.read("$.."+ nodename + "." + key).toString().trim();
	    		 this.context.softAssertions.assertThat(actualValue)
	    		 .overridingErrorMessage("page: %s  key: %s Expected: not empty Actual:%s", currentPage, key, actualValue)
	             .isNotEmpty();
	    	}
	    }

	    @And("^verify breadcrumbs \"([^\"]*)\" keys are not empty for \"([^\"]*)\" node$")
	    public void digitaldata_productcategory_notempty(String classcodeKey, String nodename) throws Exception {
	    	 List<WebElement> expectedBreadCrumbs = actionMethods.getMutipleLocators("PDP.breadcrumbs_link");
	         for (int i=1;i<expectedBreadCrumbs.size();i++) {
	             String actualValue = this.readContext.read("$." + nodename + "."+classcodeKey+i).toString().trim();
	             this.context.scenario.log("Actual values - "+classcodeKey+i+" : "+actualValue);
	             this.context.softAssertions.assertThat(actualValue)
	                     .overridingErrorMessage("page: %s Expected: not empty Actual:%s", currentPage, actualValue)
	                     .isNotEmpty()
	                     .doesNotContainOnlyWhitespaces();
	         }
	    }

		@Then("^verify bloomreach digitaldata values are exact match in page node from \"([^\"]*)\" file for \"([^\"]*)\"$")
		public void validate_BloomreachDigitalData(String FileName, String Store) throws Exception {
			String FilePath = System.getProperty("user.dir") + "//src//test//resources//TestData//"
					+ getEnv().toUpperCase() + "//";
			String path = FilePath + FileName;
			ReadContext rx = JsonUtil.getJsonDocument(path);
			String store = Store;
			String expectedViewID = "";
			String expectedDomainKey = "";
			String actualViewID = "";
			String actualDomainKey = "";

			expectedViewID = JsonUtil.getKeyValueFromCommonJson(rx, store + ".viewId");
			System.out.println("viewIDRead:" + expectedViewID);
			expectedDomainKey = JsonUtil.getKeyValueFromCommonJson(rx, store + ".domain");
			System.out.println("domainKeyRead:" + expectedDomainKey);
			logger.info("Entry found in file: " + store);

			actualViewID = this.readContext.read("$." + "page" + ".bloomreach.viewId").toString();
			actualDomainKey = this.readContext.read("$." + "page" + ".bloomreach.domain").toString();
			this.context.scenario.log("Bloomreach data in page- viewID: " + actualViewID + " , domainKey: "
					+ actualDomainKey);

			this.context.softAssertions.assertThat(actualViewID)
					.overridingErrorMessage("page: %s Key:%s Expected:%s Actual:%s", currentPage, "viewID",
							expectedViewID, actualViewID)
					.isEqualTo(expectedViewID);

			this.context.softAssertions.assertThat(actualDomainKey)
					.overridingErrorMessage("page: %s Key:%s Expected:%s Actual:%s", currentPage,
							"domainKey",
							expectedDomainKey, actualDomainKey)
					.isEqualTo(expectedDomainKey);

		}
		@Then("^verify digitaldata values- role and usage in user node from \"([^\"]*)\" file$")
		public void validate_UserJobRoleandUsageDigitalData(String FileName) throws Exception {
			String FilePath = System.getProperty("user.dir") + "//src//test//resources//TestData//" + getEnv().toUpperCase()
					+ "//";
			String path = FilePath + FileName;
			List<Map<String, String>> testData = ExcelUtil.getData(path, getStore());
			
			
			String expectedprimaryJob = testData.get(0).get("primaryJob");
			if(expectedprimaryJob.equalsIgnoreCase("skip"))
				expectedprimaryJob="PF_PRIMARY_JOB_ROLE_OTHER";				
			String expectedprimaryUse = testData.get(0).get("primaryUse");
			if(expectedprimaryUse.equalsIgnoreCase("skip"))
				expectedprimaryUse="PF_PRIMARY_USE_OTHER";
			String actualprimaryJob = "";
			String actualprimaryUse = "";

			actualprimaryJob = this.readContext.read("$." + "user" + ".role").toString();
			actualprimaryUse = this.readContext.read("$." + "user" + ".usage").toString();
			this.context.scenario
					.log("DigitalData in page- JobRole: " + actualprimaryJob + " , ProductUsage: " + actualprimaryUse);

			this.context.softAssertions.assertThat(actualprimaryJob)
					.overridingErrorMessage("page: %s Key:%s Expected:%s Actual:%s", currentPage, "JobRole",
							expectedprimaryJob, actualprimaryJob)
					.isEqualTo(expectedprimaryJob);

			this.context.softAssertions
					.assertThat(actualprimaryUse).overridingErrorMessage("page: %s Key:%s Expected:%s Actual:%s",
							currentPage, "ProductUsage", expectedprimaryUse, actualprimaryUse)
					.isEqualTo(expectedprimaryUse);
			
			
			
		}
		 @Then("^verify below array key values are exact match in  node$")
		    public void digitaldataCommand(DataTable table){

		    	Map<String, String> expectedMap = new HashMap<String, String>(
		                table.asMap(String.class, String.class)
		            );

		       
		         for(String key: expectedMap.keySet()){
		            String actualValue = this.readContext.read("$."+ "userAddErrorMsgs" + key).toString();
		            if(key.equals("pageName")){
		                actualValue = actualValue.replaceAll("[-,\\s+]", "").trim();
		            }
		            this.context.softAssertions.assertThat(actualValue)
		            .overridingErrorMessage("page: %s Key:%s Expected:%s Actual:%s",
		                     currentPage,
		                     key,
		                     expectedMap.get(key),
		                     actualValue)
		                .isEqualTo(expectedMap.get(key));
		         }
		    }
 
}
