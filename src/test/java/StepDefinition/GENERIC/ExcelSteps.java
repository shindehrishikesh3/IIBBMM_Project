package StepDefinition.GENERIC;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.util.List;
import java.util.Map;
import org.openqa.selenium.WebDriver;

public class ExcelSteps extends WebDriverConfig {

    WebDriver driver = getDriver();
    private ContextStore context;
    String FilePath =
        System.getProperty("user.dir") +
        "//src//test//resources//TestData//" +
        getEnv().toUpperCase() +
        "//";

    String store = getStore();
    String env = getEnv();
    String region = getRegionName();

    public ExcelSteps(ContextStore context) {
        this.context = context;
    }

    @And(
        "^user enters \"([^\"]*)\" for store \"([^\"]*)\" from given file \"([^\"]*)\" at row \"([^\"]*)\" number for \"([^\"]*)\"$"
    )
    public void enterTextFromExcelFile(
        String columnName,
        String sheetName,
        String FileName,
        int row,
        String locator
    ) throws Exception {
        String path = FilePath + FileName;

        List<Map<String, String>> testData = ExcelUtil.getData(path, sheetName);

        String value = testData.get(row).get(columnName);
        actionMethods.enterText(value, locator.trim());
    }

    @And("^.*enters value of \"([^\"]*)\" in.*\"([^\"]*)\" from file \"([^\"]*)\"$")
    public void enterTextFromExcelFile(
        String columnName,
        String locator,
        String FileName
    ) throws Exception {
        String path = FilePath + FileName;
        System.out.println(path);
        List<Map<String, String>> testData = ExcelUtil.getData(path, store);
        String value = testData.get(0).get(columnName);
        System.out.println(value);
        actionMethods.enterText(value, locator);
    }
}
