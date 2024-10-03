package Common.HELPERS;

import Common.UTILS.WebDriverConfig;
import io.restassured.RestAssured;
import io.restassured.config.RestAssuredConfig;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.path.xml.config.XmlPathConfig;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.util.List;
import java.util.Map;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class APIBaseMethods extends WebDriverConfig {

    private static final Logger logger = LogManager.getLogger(APIBaseMethods.class);

    public Response postRequest(
        RestAssuredConfig config,
        Map<String, String> headers,
        Map<String, String> queryParams,
        String resourcePath,
        String body
    ) {
        RequestSpecification rqSpec = prepareRequest(
            config,
            headers,
            queryParams,
            resourcePath,
            body
        );
        Response response = rqSpec.post();
        response.then().log().all();
        return response;
    }

    /**
     * Get method to verify punchoutLogin output url
     *
     * @param config
     * @param url
     * @return
     */
    public Response getRequest(
        RestAssuredConfig config,
        Map<String, String> headers,
        Map<String, String> queryParams,
        String resourcePath
    ) {
        RequestSpecification rqSpec = prepareRequest(
            config,
            headers,
            queryParams,
            resourcePath,
            null
        );
        Response response = rqSpec.get();
        response.then().log().all();
        return response;
    }

    public RequestSpecification prepareRequest(
        RestAssuredConfig config,
        Map<String, String> headers,
        Map<String, String> queryParams,
        String resourcePath,
        String body
    ) {
        RequestSpecification req = RestAssured
            .given()
            .log()
            .all()
            .config(config)
            .baseUri(getBaseURI())
            .basePath(resourcePath)
            .queryParams(queryParams);

        if (body != null) {
            req.headers(headers);
            req.body(body);
        }

        return req.when();
    }

    public String getxmlPathFromCxmlResponse(Response res, String path) {
        try {
            XmlPath xmlpath = new XmlPath(res.body().asString())
                .using(new XmlPathConfig().disableLoadingOfExternalDtd());
            return xmlpath.getString(path);
        } catch (Exception e) {
            System.out.println("Something went wrong");
            return null;
        }
    }

    public void setRestAssuredProxy()
    {
        if(System.getProperty("pHost") != null){
		RestAssured.proxy(getProxyHost(), getProxyPort());
	}
    }
    
}
