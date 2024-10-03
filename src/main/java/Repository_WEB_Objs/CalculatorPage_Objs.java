package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class CalculatorPage_Objs {
	
	 private static final Map<String, String> CalculatorPage;
	 
	 static {
		 CalculatorPage = new HashMap<String, String>();
		 CalculatorPage.put("calculatorContainer_element", "//*[@class='calcContainer']");
		 CalculatorPage.put("calculatorHeading_text", "//h1");
		 CalculatorPage.put("calculatorPageHeading_element", "(//*[@class='mkt'])[1]/div[1]");
		 CalculatorPage.put("metaDescription_text", "//meta[@name = 'description']");
		 CalculatorPage.put("description_text", "//p[@class = 'text-reverse']");
		 CalculatorPage.put("enterValue_text", "(//div[@class='container'])[3]//h3");
		 CalculatorPage.put("formulaHeading_text", "(//div[@class='container'])[4]//h3");
		 CalculatorPage.put("diagramHeading_text", "(//div[@class='container'])[5]//h3");
		 CalculatorPage.put("formula_image", "(//div[@class='container'])[4]//picture/img");
		 CalculatorPage.put("diagram_image", "(//div[@class='container'])[5]//picture/img");
		 CalculatorPage.put("formulaDesc_text", "(//div[@class='container'])[4]//div[@class='row']//span");
		 CalculatorPage.put("calcConvMenu_button", "(//div[@class='container'])[6]//a");
		 CalculatorPage.put("parallelResistance_input", "//*[@id='parallelResistanceForm']");
		 CalculatorPage.put("PRdefaultResistor_input", "//*[@id='parallelResistanceForm']/div[1]/div[1]//label");
		 CalculatorPage.put("addResistor_button", "//*[@id='addResistorBtn']");
		 CalculatorPage.put("removeResistor_button", "//*[@id='removeResistorBtn']");
		 CalculatorPage.put("resistorNumber_text", "//label[@for='resistor4']/sub");
		 CalculatorPage.put("PRoutput_text", "//*[@for='totalParallelResistance']");
		 CalculatorPage.put("PRoutput_element", "//*[@id='totalParallelResistance']");
	 }
	 
	 public String findLocator(String elementName) {
	        if (CalculatorPage.containsKey(elementName)) {
	            return (CalculatorPage.get(elementName.trim()));
	        }

	        return null;
	    }

}
