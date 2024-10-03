package StepDefinition.WEB;

import Common.UTILS.ContextStore;
import Common.UTILS.ScreenshotUtil;
import Common.UTILS.WebDriverConfig;
import StepDefinition.GENERIC.BaseSteps;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;

@SuppressWarnings("unused")
public class FilterToolTabSteps extends WebDriverConfig {

    private ContextStore context;
    String region = getRegionName();

    public FilterToolTabSteps(ContextStore context) {
        this.context = context;
    }

    @And("^.*get the Products found count before applying filters in Filter Tool tab$")
    public void preFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Filters.filtersCountFilterTab_text"
        );
        this.context.scenario.log(
                actionMethods.getValue("Filters.filtersCountFilterTab_text")
            );
        this.context.PRE_FILTER_COUNT =
            actionMethods
                .getValue("Filters.filtersCountFilterTab_text")
                .replaceAll("[,.' ]", "");
        System.out.println("Pre count filter:"+this.context.PRE_FILTER_COUNT);
    }

    @And("^.*verify the Products found count after applying filters in Filter Tool tab$")
    public void postFilterCount() throws Exception {
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Filters.filtersCountFilterTab_text"
        );
        this.context.scenario.log(
                actionMethods.getValue("Filters.filtersCountFilterTab_text")
            );
        this.context.POST_FILTER_COUNT =
            actionMethods
                .getValue("Filters.filtersCountFilterTab_text")
                .replaceAll("[,.' ]", "");
        System.out.println("Post count filter:"+this.context.POST_FILTER_COUNT);
        Assert.assertTrue(
            "Filter is not selected",
            Integer.parseInt(this.context.POST_FILTER_COUNT) <
            Integer.parseInt(this.context.PRE_FILTER_COUNT)
        );
    }

    @And(
        "^.*verify the Products found count after clearing all the filters in Filter Tool tab$"
    )
    public void matchFilterCount() throws Exception {
        this.context.POST_FILTERCLEAR_COUNT =
            actionMethods
                .getValue("Filters.filtersCountFilterTab_text")
                .replaceAll("[,. ]", "");
        Assert.assertTrue(
            "Clear all filters is not giving right product count",
            this.context.POST_FILTERCLEAR_COUNT.equalsIgnoreCase(
                    this.context.PRE_FILTER_COUNT
                )
        );
    }

    @And("^.*apply filters in Filter Tool tab .* \"([^\"]*)\"$")
    public void applyFilters(String locator) throws Exception {
        actionMethods.click(locator);
    }

    @And("^.*verify the Products found count after applying all the filters in PDP page$")
    public void matchFilterCountinPDPpage() throws Exception {
        this.context.POST_FILTER_COUNT_PDP =
            actionMethods
                .getValueUsingAttribute("Filters.filtersCount_text", "innerHTML")
                .replaceAll("[,. ]", "");
        if (!region.equalsIgnoreCase("NEWARK")) {
            Assert.assertTrue(
                "filter count doesn't match. Actual count:" +
                this.context.POST_FILTER_COUNT_PDP +
                "expected count:" +
                this.context.POST_FILTER_COUNT,
                this.context.POST_FILTER_COUNT_PDP.equalsIgnoreCase(
                        this.context.POST_FILTER_COUNT
                    )
            );
        } else {
            Assert.assertTrue(
                "filter count doesn't match. Actual count:" +
                this.context.POST_FILTER_COUNT_PDP +
                "expected count:" +
                this.context.POST_FILTER_COUNT,
                Integer.parseInt(this.context.POST_FILTER_COUNT_PDP) <=
                Integer.parseInt(this.context.POST_FILTER_COUNT)
            );
        }
    }
}
