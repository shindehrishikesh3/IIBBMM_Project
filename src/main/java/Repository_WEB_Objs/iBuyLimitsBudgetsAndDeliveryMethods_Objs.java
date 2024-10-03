package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class iBuyLimitsBudgetsAndDeliveryMethods_Objs {
    // Creation of HashMap
    private static final Map<String, String> iBuyLimitsBudgetsAndDeliveryMethods;

    static {
    	iBuyLimitsBudgetsAndDeliveryMethods = new HashMap<String, String>();

    	iBuyLimitsBudgetsAndDeliveryMethods.put(
            "limitsBudgetsDeliveryMetods_text",
            ".//*[@id='article']/div/h1"
        );
    	iBuyLimitsBudgetsAndDeliveryMethods.put(
            "addAddBudget_button",
            ".//*[@id='budgets']/div/a[1]"
        );
    	iBuyLimitsBudgetsAndDeliveryMethods.put("budgetSavedConformation_text", "//*[@id='limBud']/strong");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("perOrderLimitValue_textbox", ".//*[@id='perOrderLimit']");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("save_button", "//input[@class='btn btnPrimary']");
    	//AddBudget page elements
    	iBuyLimitsBudgetsAndDeliveryMethods.put("budgets_checkbox", "//*[@for='removeBudgets_1']/span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("deleteBudget_button", "//*[@id='removeBudget']");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("confirmRemoveBudget_button", "//*[@id='confConfirm']");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("addBudgets_text", ".//*[@id='article']/div/h1");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("addBudgetName_textbox", ".//*[@id='budgetName']");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("addBudgetValue_textbox", ".//*[@id='budgetValue']");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("addBudgetsSave_button", ".//*[@id='updateBudget']/div[5]/input");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("addBudgetsPeriod_dropdown", "//*[@id='budgetPeriodName']");
    	
    	//Approvers
    	iBuyLimitsBudgetsAndDeliveryMethods.put("saApprover_text","//*[@id='approverUserIds']//following-sibling::td[1]");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("allowUsers_checkbox", "//label[@for='allowUsers']/span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("emailAllSecondaryapprovers_checkbox","//*[@id='approvers']/div[2]/span[1]/label/span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("emailAllBudgetOwners_checkbox","//*[@id='approvers']/div[3]/span[1]/label/span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("approvaltime_textbox","//*[@id='approvalTimeThreshold']");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("spendThreshold_textbox","//*[@id='spendThreshold']");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("orderApprover_checkbox","//*[@id='orderApprover1']//following-sibling::span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("orderApprover2_checkbox", "//label[@for='orderApprover2']/span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("budgetApprover1_checkbox", "//label[@for='budgetApprover1']/span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("budgetApprover2_checkbox", "//label[@for='budgetApprover2']/span");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("changesHavebeenSaved_text","//*[@id='limBud']//strong");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("taApprover_text", "//*[@id='approverUserIds']//following-sibling::td[1]");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("allocateMoreApprover_button","//*[@id='approvers']/div[4]/a[1]");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("ta_approver", "//*[@id='approvers']/table/tbody/tr/td[1]");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("sa_approver", "//*[@id='approvers']/table/tbody/tr[2]/td[1]");
    	
    	//ADD Approvers page
    	iBuyLimitsBudgetsAndDeliveryMethods.put("saUser_checkbox","//*[@class='select']//label//span[1]");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("taUser_checkbox", "(//*[@class='checkbox']/span)[3]");
    	iBuyLimitsBudgetsAndDeliveryMethods.put("allocateApprovers_button","//*[@class='actionBox actionFullWidth']//input");
    }

    public String findLocator(String elementName) {
        if (iBuyLimitsBudgetsAndDeliveryMethods.containsKey(elementName)) {
            return (iBuyLimitsBudgetsAndDeliveryMethods.get(elementName.trim()));
        }

        return null;
    }
}
