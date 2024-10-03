package Common.HELPERS;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import Common.UTILS.WebDriverConfig;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class LocalServerMethods extends WebDriverConfig {
	
	private static final int MAX_RETRIES = 5;
    private static final long INITIAL_DELAY_MS = 2000;
    private static final double BACKOFF_MULTIPLIER = 2.0;
	private static final Logger logger = LogManager.getLogger(LocalServerMethods.class);
    
    /**
     * POST method to get access token from AHEM local mail server
     *
     * @param baseURI
     * @return String access token
     */
    public String getAccessToken(String baseURI) {
        RestAssured.baseURI = baseURI;
        String access_response = RestAssured.given().log().all()
            .header("content-type", "application/json")
            .when().post(applicationConfig.getProperty("pf.rest.api.ahem.token"))
            .then().log().all()
            .assertThat().statusCode(200)
            .extract().response().asString();
        JsonPath js = new JsonPath(access_response);
        return js.get("token").toString();
    }
    
    /**
     * GET method to get Email ID
     *
     * @param baseURI, accessToken, mailbox
     * @return String email ID
     */
    public String getEmailId(String baseURI, String accessToken, String mailbox) {
        RestAssured.baseURI = baseURI;
        String emailIdPath = String.format(applicationConfig.getProperty("pf.rest.api.ahem.mailbox"), mailbox);
        long delay = INITIAL_DELAY_MS;

        for (int retryCount = 0; retryCount < MAX_RETRIES; retryCount++) {
            Response response = RestAssured.given()
                    .header("Authorization", "Bearer " + accessToken)
                    .header("Content-Type", "application/json")
                    .get(emailIdPath);
            if (response.getStatusCode() == 200) {
                String emailId = response.getBody().asString();
                JsonPath jsonPath = new JsonPath(emailId);
                int lastIndex = jsonPath.getList("").size() - 1;
                String temp = jsonPath.get("[" + lastIndex + "].emailId").toString();
                logger.info("JSONPath: " + temp);
                return temp;
            } else {
                try {
                    Thread.sleep(delay);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
                delay *= BACKOFF_MULTIPLIER;
            }
        }
        throw new RuntimeException("Failed to fetch email ID after multiple attempts.");
    }

    /**
     * GET method to get Email Body
     *
     * @param baseURI, accessToken, mailbox, emailID
     * @return String email body
     */
    public String getEmailBody(String baseURI, String accessToken, String mailbox, String emailID) {
        RestAssured.baseURI = baseURI;
        String emailBodyPath = String.format(applicationConfig.getProperty("pf.rest.api.ahem.email"),mailbox, emailID);
        String response_body = RestAssured.given().log().all()
            .header("Authorization", "Bearer " + accessToken)
            .header("content-type", "application/json")
            .when().get(emailBodyPath)
            .then().log().all()
            .assertThat().statusCode(200)
            .extract().response().asString();
        JsonPath js2 = new JsonPath(response_body);
        return js2.get("html").toString();
    }

    /**
     * Get link from a list of hrefs by index
     *
     * @param hrefs
     * @param index
     * @return String link
     */
    public String getLink(List<String> hrefs, int index) {
        if (index >= 0 && index < hrefs.size()) {
            return hrefs.get(index);
        } else {
            return null;
        }
    }
}
