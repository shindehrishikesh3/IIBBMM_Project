package Repository_WEB_Objs;

import java.util.*;

public class ScheduleOrder_Objs {

    // Creation of HashMap
    private static final Map<String, String> ScheduleOrder;

    static {
        ScheduleOrder = new HashMap<String, String>();
        ScheduleOrder.put(
            "scheduleOrderPageTitle_text",
            ".//*[@class='scheduleHeading']"
        );
        ScheduleOrder.put(
            "addSchedule_link",
            "//a[@class='addDate schAddDate hideForwardDateActive']"
        );
        ScheduleOrder.put(
            "calender_icon",
            "(//span[contains(@class,'icon icon-calendar')])[3]"
        );
        ScheduleOrder.put("enterDatefield_text", "//*[@aria-label='March 31, 2022']");
        ScheduleOrder.put(
            "incrementArrow_button",
            "//div[contains(@class,'CalendarIncrement')]//img"
        );
        ScheduleOrder.put(
            "scheduledQuantity_text",
            "(//input[contains(@class,'dateQtyInput')])[2]"
        );
        ScheduleOrder.put("saveSchedule_button", "(//input[@type='submit'])[1]");
        ScheduleOrder.put("continueToBasket_button", "//*[@id='savencontinueTop']");
        ScheduleOrder.put("deleteSchedule_button", "//*[@id='deletescheduleBtn']");
        ScheduleOrder.put(
            "confirmDeleteSchedule_button",
            "(//button[@type='submit'])[2]"
        );
        ScheduleOrder.put("delete_icon", "(//span[@id='delSchCloseBtn'])[2]");
        ScheduleOrder.put(
            "nonSchedule_text",
            "//strong[contains(text(),'Non-schedulable item')]"
        );
        ScheduleOrder.put(
            "calendarDatePartial_element",
            "//*[@class='dijitReset dijitCalendarMonthContainer']//following-sibling::table//tbody//tr//td[contains(@aria-label,'"
        );
        
        //For US payPal Schedule order after next 10 month
        ScheduleOrder.put("nextYear_element", "//*[@class='dijitInline dijitCalendarNextYear']");
        ScheduleOrder.put("dateNextYear_element", "//*[@class='dijitReset dijitCalendarMonthContainer']//following-sibling::table//tbody//tr//td[contains(@aria-label,'October 31')]");
    }

    public String findLocator(String elementName) {
        if (ScheduleOrder.containsKey(elementName)) {
            return (ScheduleOrder.get(elementName.trim()));
        }

        return null;
    }
}
