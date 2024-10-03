package Common.UTILS;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigUtil extends WebDriverConfig {

    // ***********Environment File*************************
    public static final String FT_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/ft_environment.properties";

    public static final String FTSTG_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/ftstg_environment.properties";

    public static final String UAT_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/uat_environment.properties";

    public static final String LIVE_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/live_environment.properties";

    public static final String PREPROD_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/preprod_environment.properties";

    public static final String PRDSUPPORT_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/prodsupport_environment.properties";

    public static final String PSTG_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/pstg_environment.properties";

    public static final String PSSTG_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/psstg_environment.properties";

    public static final String PPSTG_ENV_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/ppstg_environment.properties";

    // ***********Login File*************************
    public static final String FT_Login_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/LoginUsers/ft_login_user.properties";

    public static final String FTSTG_Login_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/LoginUsers/ftstg_login_user.properties";

    public static final String UAT_Login_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/LoginUsers/uat_login_user.properties";

    public static final String LIVE_Login_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/LoginUsers/live_login_user.properties";

    public static final String PPSTG_Login_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/LoginUsers/ppst_login_user.properties";

    // ***********Contract File*************************
    public static final String FT_Contract_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/ContractUsers/ft_contract_user.properties";

    public static final String UAT_Contract_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/ContractUsers/uat_contract_user.properties";

    public static final String LIVE_Contract_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/ContractUsers/live_contract_user.properties";

    // ***********Ibuy File*************************
    public static final String FT_Ibuy_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/IbuyUsers/ft_ibuy_user.properties";

    public static final String UAT_Ibuy_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/IbuyUsers/uat_ibuy_user.properties";

    public static final String LIVE_Ibuy_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/IbuyUsers/live_ibuy_user.properties";
    
    public static final String PP_Ibuy_FILE =
            System.getProperty("user.dir") +
            "/src/main/java/IbuyUsers/pp_ibuy_user.properties";

    // ***********Ibuy PFSA Admin File*************************
    public static final String FT_IbuyPfsaAdmin_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/IbuyUsers/ft_ibuy_pfsa_user.properties";

    public static final String UAT_IbuyPfsaAdmin_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/IbuyUsers/uat_ibuy_pfsa_user.properties";

    public static final String LIVE_IbuyPfsaAdmin_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/IbuyUsers/live_ibuy_pfsa_user.properties";
    
    public static final String PP_IbuyPfsaAdmin_FILE =
            System.getProperty("user.dir") +
            "/src/main/java/IbuyUsers/pp_ibuy_pfsa_user.properties";

    // **************xcomreg File***************************/

    public static final String FT_xcomreg_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/xcomreg/ft_xcomreg.properties";

    public static final String UAT_xcomreg_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/xcomreg/uat_xcomreg.properties";

    public static final String PP_xcomreg_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/xcomreg/pp_xcomreg.properties";
    
    public static final String LIVE_xcomreg_FILE =
            System.getProperty("user.dir") +
            "/src/main/java/EnvironmentFile/xcomreg/live_xcomreg.properties";

    public static final String CICD_xcomreg_FILE =
        System.getProperty("user.dir") +
        "/src/main/java/EnvironmentFile/xcomreg/cicd_xcomreg.properties";

    public static final String APPLICATION_FILE =
        System.getProperty("user.dir") + "/src/main/java/Config/application.properties";

    // *************Forgot Password File********************/

    public static final String FT_ForgotPwd_File =
        System.getProperty("user.dir") +
        "/src/main/java/ForgotPasswordDetails/ft_forgot_password.properties";

    // *************Order history file********************/

    public static final String FT_Orders_Login_File =
        System.getProperty("user.dir") +
        "/src/main/java/Orders_LoginUsers/ft_orders_loginuser.properties";

    public static final String UAT_Orders_Login_File =
        System.getProperty("user.dir") +
        "/src/main/java/Orders_LoginUsers/uat_orders_loginuser.properties";
    
    // *************Orders ibuy user file********************/

    public static final String FT_Orders_Ibuy_File =
        System.getProperty("user.dir") +
        "/src/main/java/Orders_IbuyUsers/ft_orders_ibuyuser.properties";
    
    // *************Checkout Content File********************/

    public static final String Checkout_Content_File =
        System.getProperty("user.dir") +
        "/src/main/java/CheckoutContent/CheckoutPage.properties";
    
    // *************Registration Content File********************/

    public static final String Registration_Content_File =
        System.getProperty("user.dir") +
        "/src/main/java/RegistrationContent/RegistrationPage.properties";
    
    // to load property file
    public void loadProperty() throws IOException {
        String env = getEnv();

        // ****************************************************************

        envConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_ENV_FILE);
	    } else if (env.equalsIgnoreCase("ftstg")) {
		input = new FileInputStream(FTSTG_ENV_FILE);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(UAT_ENV_FILE);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(LIVE_ENV_FILE);
            } else if (env.equalsIgnoreCase("pp")) {
                input = new FileInputStream(PREPROD_ENV_FILE);
            } else if (env.equalsIgnoreCase("pstg")) {
                input = new FileInputStream(PSTG_ENV_FILE);
            } else if (env.equalsIgnoreCase("psstg")) {
                input = new FileInputStream(PSSTG_ENV_FILE);
            } else if (env.equalsIgnoreCase("ps")) {
                input = new FileInputStream(PRDSUPPORT_ENV_FILE);
            }
            envConfig.load(input);
        } catch (Exception e) {}

        // ******************************************************************

        ibuyConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_Ibuy_FILE);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(UAT_Ibuy_FILE);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(LIVE_Ibuy_FILE);
            }else if (env.equalsIgnoreCase("pp")) {
                input = new FileInputStream(PP_Ibuy_FILE);
            }
            ibuyConfig.load(input);
        } catch (Exception e) {}

        // ******************************************************************

        ibuyPfsaAdminConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_IbuyPfsaAdmin_FILE);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(UAT_IbuyPfsaAdmin_FILE);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(LIVE_IbuyPfsaAdmin_FILE);
            }else if (env.equalsIgnoreCase("pp")) {
                input = new FileInputStream(PP_IbuyPfsaAdmin_FILE);
            }
            ibuyPfsaAdminConfig.load(input);
        } catch (Exception e) {}

        // ******************************************************************

        contractConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_Contract_FILE);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(UAT_Contract_FILE);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(LIVE_Contract_FILE);
            }
            contractConfig.load(input);
        } catch (Exception e) {}

        // ******************************************************************

        loginConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_Login_FILE);
            } else if (env.equalsIgnoreCase("ftstg")) {
		input = new FileInputStream(FTSTG_Login_FILE);
	    } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(UAT_Login_FILE);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(LIVE_Login_FILE);
            }
            loginConfig.load(input);
        } catch (Exception e) {}

        // *************************************************** */
        xcomregConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_xcomreg_FILE);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(UAT_xcomreg_FILE);
            } else if (env.equalsIgnoreCase("pp")) {
                input = new FileInputStream(PP_xcomreg_FILE);
            } else if (env.equalsIgnoreCase("cicd")) {
                input = new FileInputStream(CICD_xcomreg_FILE);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(LIVE_xcomreg_FILE);
            }
            xcomregConfig.load(input);
        } catch (Exception e) {}

        // *************************************************** */
        applicationConfig = new Properties();
        try {
            input = new FileInputStream(APPLICATION_FILE);
            applicationConfig.load(input);
        } catch (Exception e) {}

        // ****************************************************/
        forgotPwdConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_ForgotPwd_File);
            }
            forgotPwdConfig.load(input);
        } catch (Exception e) {
            System.out.println(
                "Unable to get details sue to Exception: " + e.getMessage()
            );
        }

        // *************************************************** */
        ordersConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_Orders_Login_File);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(UAT_Orders_Login_File);
            }
            ordersConfig.load(input);
        } catch (Exception e) {}
        
        //*************************************************** */
        checkoutConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(Checkout_Content_File);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(Checkout_Content_File);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(Checkout_Content_File);
            }
            checkoutConfig.load(input);
        } catch (Exception e) {}
        
     // *************************************************** */
        ordersibuyConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(FT_Orders_Ibuy_File);
            }
            ordersibuyConfig.load(input);
        } catch (Exception e) {}

        //*************************************************** */
        registrationConfig = new Properties();
        try {
            if (env.equalsIgnoreCase("ft")) {
                input = new FileInputStream(Registration_Content_File);
            } else if (env.equalsIgnoreCase("uat")) {
                input = new FileInputStream(Registration_Content_File);
            } else if (env.equalsIgnoreCase("live")) {
                input = new FileInputStream(Registration_Content_File);
            }
            registrationConfig.load(input);

        } catch (Exception e) {}
    }
}
