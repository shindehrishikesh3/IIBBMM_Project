package StepDefinition.WEB;


import org.junit.Assert;

import Common.UTILS.ContextStore;
import Common.UTILS.WebDriverConfig;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class LoginSteps extends WebDriverConfig {

    private ContextStore context;

    public LoginSteps(ContextStore context) {
        this.context = context;
    }

    @Given("^last registered \"([^\"]*)\" user login.*$")
    public void login_lastRegistereduser(String loginUser) throws Exception {
        String username = "";
        String password = context.constants.getPassword();
        	
        if (loginUser.contains("sync")) {
            username = ContextStore.SYNCH_USER_NAME;
        } else if (loginUser.contains("iBuy user")) {
            username = ContextStore.iBuyUser;
        } else if (loginUser.contains("iBuy SA user")) {
            username = ContextStore.iBuySAUser;
        } else {
        	username = ContextStore.USER_NAME;           
        }
        if (loginUser.contains("Updated Pswd")) {
        	password = context.constants.getNewPassword();
        }

        actionMethods.click("Header.login_link");
        Thread.sleep(5000);
        actionMethods.waitForElementToAppear(
            this.context.constants.getShortWaitSeconds(),
            "Login.username_textbox"
        );
        actionMethods.enterText(username, "Login.username_textbox");
        context.scenario.log("Username: " + username);
        actionMethods.enterText(password, "Login.password_textbox");
        context.scenario.log("Password:" + password);
        Thread.sleep(5000);
        actionMethods.click("Login.login_button");
        Thread.sleep(9000);
    }

    @And("I reset password for newly registerd iBuy user")
    public void reset_password() throws Exception {
        String temproryPassword = context.constants.getPassword();
        String newPassword = context.constants.getNewPassword();
        if(uiMethods.isElementDisplayed("ResetPassword.resetYourPassword_text")) {
        actionMethods.enterText(
            temproryPassword,
            "ResetPassword.temporaryPassword_textbox"
        );
        context.scenario.log("Temporary Password: " + temproryPassword);
        actionMethods.enterText(newPassword, "ResetPassword.createNewPassword_textbox");
        context.scenario.log("New Password:" + newPassword);
        Thread.sleep(5000);
        actionMethods.click("ResetPassword.resetPassword_textbox");
        }
    }
    @And("^I verify the eye icon of password field in the page \"([^\"]*)\"$")
   	public void verifyEyeIconInPasswordField(String value) throws Exception {
   		if(appName.equalsIgnoreCase("web")) {
   		if(value.equalsIgnoreCase("loginpage")){
   		actionMethods.click("Login.visibilityOfEyeicon");
   		String passwordtype = actionMethods.getValueUsingAttribute("Login.passwordtype_login","type");
   		Assert.assertEquals("text",passwordtype);
   		String hideEyeIcon = actionMethods.getValueUsingAttribute("Login.invisibilityOfEyeicon","class");
   		actionMethods.click("Login.invisibilityOfEyeicon");
   		String passwordtype2 = actionMethods.getValueUsingAttribute("Login.passwordtype_login","type");
   		Assert.assertEquals("password",passwordtype2);
   		String unhideEyeicon = actionMethods.getValueUsingAttribute("Login.visibilityOfEyeicon","class");	    		    		    	
   		Assert.assertNotEquals("values are changed", unhideEyeicon, hideEyeIcon);
   		Assert.assertNotEquals("texttype is changed", passwordtype2, passwordtype);
   	}
   		else if(value.equalsIgnoreCase("guestloginmodel")){
   			actionMethods.click("Login.visibilityOfEyeicon");
   			String passwordtype = actionMethods.getValueUsingAttribute("Login.passwordtype_guestloginmodel","type");
   			Assert.assertEquals("text",passwordtype);
   			String hideEyeIcon = actionMethods.getValueUsingAttribute("Login.invisibilityOfEyeicon","class");
   			actionMethods.click("Login.invisibilityOfEyeicon");
   			String passwordtype2 = actionMethods.getValueUsingAttribute("Login.passwordtype_guestloginmodel","type");
   			Assert.assertEquals("password",passwordtype2);
   			String unhideEyeicon = actionMethods.getValueUsingAttribute("Login.visibilityOfEyeicon","class");	    		    		    	
   			Assert.assertNotEquals("values are changed", unhideEyeicon, hideEyeIcon);
   			Assert.assertNotEquals("texttype is changed", passwordtype2, passwordtype);
   		}
   		}
   		if(appName.equalsIgnoreCase("mobile"))
   		{
   			if(value.equalsIgnoreCase("loginpage")){
   				actionMethods.click("Login.showpassword_checkbox");
   				String passwordType = actionMethods.getValueUsingAttribute("Login.passwordtype_text","type");
   				Assert.assertEquals("text",passwordType);
   				actionMethods.click("Login.showpassword_checkbox");
   				String passwordType2 = actionMethods.getValueUsingAttribute("Login.passwordtype_text","type");
   				Assert.assertEquals("password",passwordType2);
   				Assert.assertNotEquals("texttype is changed", passwordType2, passwordType);
   				
   			}
   			
   		}
       }
}
