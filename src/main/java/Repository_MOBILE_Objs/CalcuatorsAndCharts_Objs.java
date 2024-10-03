package Repository_MOBILE_Objs;

import java.util.HashMap;
import java.util.Map;

public class CalcuatorsAndCharts_Objs {

	private static final Map<String, String> CalcuatorsAndCharts;

	static {
		CalcuatorsAndCharts = new HashMap<String, String>();
		CalcuatorsAndCharts.put("header_element",
				"//div[contains(@class,'grey-very-dark')]//h1[contains(@class,'header-text-large')]");
		CalcuatorsAndCharts.put("calcAndConversionTools_list", "//*[@class='calcContainer']/div/h3");
		CalcuatorsAndCharts.put("cnCalcAndConversionTools_list", "//*[@class='bg-full-width-inner larger-padding-bottom']/div/div[contains(@class,'col-sm-6')]/h3");
		CalcuatorsAndCharts.put("mainMenu_button", "//div[contains(@class,'-12')]//a[@class='btn btn-secondary']");
		CalcuatorsAndCharts.put("mainMenutwo_button",
				"(//div[contains(@class,'-12')]//a[@class='btn btn-secondary'])[2]");
		CalcuatorsAndCharts.put("calMenuTool_button", "(//a[@class='btn btn-tertiary'])[2]");
		CalcuatorsAndCharts.put("menuHeader_element",
				"//div[contains(@class,'grey-dark2')]//h1[contains(@class,'header-text-large')]");
		CalcuatorsAndCharts.put("calFooter_button", "(//footer//div//a//li)[5]");
		CalcuatorsAndCharts.put("calChartsMenu_button",
				"//div[contains(@class,'col-sm-12')]//a[contains(@class,'btn btn-')]");

		CalcuatorsAndCharts.put("calculatorContainer_element", "//*[@class='calcContainer']");
		CalcuatorsAndCharts.put("calculatorHeading_text", "//h1");
		CalcuatorsAndCharts.put("CalcuatorsAndChartsHeading_element", "(//*[@class='mkt'])[1]/div[1]");
		CalcuatorsAndCharts.put("metaDescription_text", "//meta[@name = 'description']");
		CalcuatorsAndCharts.put("description_text", "//p[@class = 'text-reverse']");
		CalcuatorsAndCharts.put("enterValue_text", "(//div[@class='container'])[2]//h3");
		CalcuatorsAndCharts.put("formulaHeading_text", "(//div[@class='container'])[3]//h3");
		CalcuatorsAndCharts.put("diagramHeading_text", "(//div[@class='container'])[4]//h3");
		CalcuatorsAndCharts.put("formula_image", "(//div[@class='container'])[3]//picture/img");
		CalcuatorsAndCharts.put("diagram_image", "(//div[@class='container'])[4]//picture/img");
		CalcuatorsAndCharts.put("formulaDesc_text", "(//div[@class='container'])[3]//div[@class='row']//span");
		CalcuatorsAndCharts.put("calcConvMenu_button", "(//div[@class='container'])[5]//a");
		CalcuatorsAndCharts.put("parallelResistance_input", "//*[@id='parallelResistanceForm']");
		CalcuatorsAndCharts.put("PRdefaultResistor_input", "//*[@id='parallelResistanceForm']/div[1]/div[1]//label");
		CalcuatorsAndCharts.put("addResistor_button", "//*[@id='addResistorBtn']");
		CalcuatorsAndCharts.put("removeResistor_button", "//*[@id='removeResistorBtn']");
		CalcuatorsAndCharts.put("resistorNumber_text", "//label[@for='resistor4']/sub");
		CalcuatorsAndCharts.put("PRoutput_text", "//*[@for='totalParallelResistance']");
		CalcuatorsAndCharts.put("PRoutput_element", "//*[@id='totalParallelResistance']");
		CalcuatorsAndCharts.put("calculatorReference_image", "//*[@class='calcWrapper large-padding-bottom']//img");
		CalcuatorsAndCharts.put("calculatorTitle_text", "//*[@class='calcWrapper large-padding-bottom']/h3");
		CalcuatorsAndCharts.put("calculator_button", "//*[@class='calcContainer']/div/a[2]");
		CalcuatorsAndCharts.put("cnCalculator_link", "//*[@class='bg-full-width-inner larger-padding-bottom']/div/div[contains(@class,'col-sm-6')]/a[2]");
		CalcuatorsAndCharts.put("calcAndConvChartsMenu_button", "//*[@class='btn btn-secondary' and contains(@href,'calculators-conversion-tools')]");
		CalcuatorsAndCharts.put("calculatorAndCharts_link", "//*[@id='pf_footer_espot_01']//*[contains(@href,'calculators-conversion-tools')]/li");
	}

	public String findLocator(String elementName) {
		if (CalcuatorsAndCharts.containsKey(elementName)) {
			return (CalcuatorsAndCharts.get(elementName.trim()));
		}

		return null;
	}
}
