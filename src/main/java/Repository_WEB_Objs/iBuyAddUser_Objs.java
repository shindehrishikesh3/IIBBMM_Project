package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class iBuyAddUser_Objs {
	// Creation of HashMap
    private static final Map<String, String> iBuyAddUser;

    static {
    	iBuyAddUser = new HashMap<String, String>();
    	iBuyAddUser.put("users_text", "//h1[contains(text(),'Users')]");
    	iBuyAddUser.put("tierName_dropdown","//select[@id='selectedOrg']");
    	iBuyAddUser.put("addNewUser_button","(//a[@class='btn btnPrimary'])[2]");
    	iBuyAddUser.put("addNewUser_text","//h1[text()='Add New User']");
    	iBuyAddUser.put("title_dropdown", "//*[@id='personTitle']");
    	iBuyAddUser.put("firstName_textbox", "//input[@id='firstName']");
        iBuyAddUser.put("lastName_textbox", "//input[@id='lastName']");
        iBuyAddUser.put("fullName_textbox", "//input[@id='firstName']");
        iBuyAddUser.put("emailAddress_textbox", "//input[@id='email1']");
        iBuyAddUser.put("phoneNumber_textbox", "//input[@id='phone1']");
        iBuyAddUser.put("username_textbox", "//*[@id='logonId']");
        iBuyAddUser.put("password_textbox", "//*[@id='logonPassword']");
        iBuyAddUser.put("confirmPassword_textbox","//*[@id='logonPasswordVerify']");
        iBuyAddUser.put("primaryRole_dropdown", "//select[@id='primaryRole']");
        iBuyAddUser.put("primaryUse_dropdown", "//select[@id='primaryUse']");
        iBuyAddUser.put("assignedRole_dropdown","//select[@id='assignedRole']");
        iBuyAddUser.put("approver_radio","(//*[@class='radioField']//input)");
        iBuyAddUser.put("add_button","(//*[@class='btn btnPrimary'])[2]");
        iBuyAddUser.put("userSearch_textbox", "//*[@id='userName']");
        iBuyAddUser.put("userSearch_button","//input[@class='btn btnPrimary']");
        iBuyAddUser.put("userSearch_link","//*[@class='infoTable standard']//tr[1]/td[1]/a");
        iBuyAddUser.put("editUser_label","//*[@id='article']/div/h1");
        iBuyAddUser.put("username_text","//div[@class='editUserName']");
        iBuyAddUser.put("editUserCancel_button","//a[@class='btn btnTertiary']");
        iBuyAddUser.put("deliveryAddress_link","//*[@class='infoTable standard restricted']//tr[3]/td[1]/a");
        iBuyAddUser.put("accounts&Payment_link","//*[@class='infoTable standard restricted']//tr[2]/td[1]/a");
        iBuyAddUser.put("limitsBudgets_link","//*[@class='infoTable standard restricted']//tr[1]/td[1]/a");
        iBuyAddUser.put("cancel_button","//*[@class='actionBox actionFullWidth']/a[@class='btn btnTertiary']");
        iBuyAddUser.put("editusertable_link","(//*[@class='infoTable standard']/tbody/tr/td[1]/a)[2]");
    	
    }

    public String findLocator(String elementName) {
        if (iBuyAddUser.containsKey(elementName)) {
            return (iBuyAddUser.get(elementName.trim()));
        }

        return null;
    }

}
