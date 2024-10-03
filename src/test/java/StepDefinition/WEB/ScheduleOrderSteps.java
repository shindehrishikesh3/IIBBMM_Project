package StepDefinition.WEB;

import static org.hamcrest.CoreMatchers.containsString;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import java.text.DateFormatSymbols;
import java.text.SimpleDateFormat;
import java.time.Month;
import java.util.Calendar;
import java.util.Date;
import org.junit.Assert;
import org.openqa.selenium.By;

public class ScheduleOrderSteps extends WebDriverConfig {

    private ContextStore context;
    int currentYear;
    String nextMonth;
    int currentDate;
    int currentMonth;
    int nextDate;

    public ScheduleOrderSteps(ContextStore context) {
        this.context = context;
    }

    // Selecting Future Date (i.e) one month ahead of current date

    @And("^I select date to Schedule Order")
    public void selectDate() throws Exception {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("MM");
        currentDate = cal.get(Calendar.DAY_OF_MONTH);
        System.out.println("The Current Date is :" +currentDate);
        currentMonth = cal.get(Calendar.MONTH) + 1;
        System.out.println("The Current Month is :" +currentMonth);
        cal.add(Calendar.MONTH, 1);
        nextMonth = df.format(cal.getTime());
        System.out.println("The Next Month is :" +nextMonth);
        currentYear = cal.get(Calendar.YEAR);
        System.out.println("The Current Year is :" +currentYear);
        //clicking on increment icon in calendar pop-up to move to next month
        actionMethods.clickUsingJSExecutor("ScheduleOrder.incrementArrow_button");
        /*Setting cal instance to next Month's date to check if date falls in Weekend (Weekend Dates cannot be selected to schedule the order)
		if it falls in Weekend then adding 2 days to move to next clickable date		
		*/
        Date date1 = new SimpleDateFormat("dd/MM/yyyy")
            .parse(currentDate + "/" + nextMonth + "/" + currentYear);
        cal.setTime(date1);
        if (
            (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY) ||
            (cal.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)
        ) {
            System.out.println(cal.get(Calendar.DAY_OF_MONTH));
            //Checking if dates are month end dates to reduce 2 days to select dates within that month
            if (
                cal.get(Calendar.DAY_OF_MONTH) == 30 ||
                cal.get(Calendar.DAY_OF_MONTH) == 31
            ) {
                cal.add(Calendar.DATE, -2);
                currentDate = cal.get(Calendar.DAY_OF_MONTH);
            } else {
                cal.add(Calendar.DATE, 2);
                currentDate = cal.get(Calendar.DAY_OF_MONTH);
            }
        }
        //Getting the name of the Month by passing the index
        String monthname = getMonthName(currentMonth);
        System.out.println("The Month Name is :" +monthname);
        //Handling for the assert case when date is between 1-10
        //String curDate = getCurrDate(currentDate);

        //Dynamic xpath to click on date (added Month Name and Next Month's date)
        String newpath =
            actionMethods.getLocatorString("ScheduleOrder.calendarDatePartial_element") +
            monthname +
            " " +
            currentDate +
            "')]";
        actionMethods.getDriver().findElement(By.xpath(newpath)).click();
        this.context.scenario.log(
                "Date selected:" + currentYear + "-" + nextMonth + "-" + currentDate
            );
    }

    @And("^I verify Scheduled Date in Order Confirmation page")
    public void scheduledDate() throws Exception {
        String date;
        Date date1;
        String ExpectedScheduledDate;
        String ActualScheduledDate = actionMethods.getValueUsingAttribute(
            "Checkout.scheduleConfirmationdate_message",
            "value"
        );
        date = currentYear + "-" + nextMonth + "-" + currentDate;
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        date1 = format.parse(date);
        ExpectedScheduledDate = format.format(date1);

        System.out.println(
            "ActualScheduledDate is " +
            ActualScheduledDate +
            " and ExpectedScheduledDate is " +
            ExpectedScheduledDate
        );
        Assert.assertEquals(
            "Scheduled Date mismatched",
            ActualScheduledDate,
            ExpectedScheduledDate
        );
    }

    public static String getMonthName(int monthIndex) {
        if (monthIndex < 1 || monthIndex > 12) {
            throw new IllegalArgumentException(
                monthIndex + " is not a valid month index."
            );
        }
        return new DateFormatSymbols().getMonths()[monthIndex].toString();
    }

    public static String getCurrDate(int date) {
        if (date < 10) return "0" + date; else return String.valueOf(date);
    }
}
