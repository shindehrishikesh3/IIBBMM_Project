package Common.CONSTANTS;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GlobalConstants {

    public static final String CONTENT_TYPE_CONST = "Content-Type";
    public static final String CONTENT_TYPE_XML = "text/xml";
    public static final String PROP_KEY_PREFIX = "pf.rest.api.";
    public static final String STORE_ID_CONST = "storeId";
    public static final String CATALOG_ID_CONST = "catalogId";
    public static final String ZERO_CONST = "0";
    public static final String XMLPATH_CXML_PL =
        "cXML.Response.PunchOutSetupResponse.StartPage.URL";
    public static final String XMLPATH_CXML_STATUSCODE = "cXML.Response.Status.@code";
    public static final String XMLPATH_CXML_STATUSTEXT = "cXML.Response.Status.@text";
    public static final String SITE_CONFIDENCE_NAME = "SiteConfidence";
    public static final String IFRAME_TEMPLATE_HTML = "iframeTemplate.html";
    public static final String SITE_CONFIDENCE_URL = "/webapp/wcs/stores/servlet/SiteConfidenceCmd?storeId=0&catalogId=0";

    // Headless project constants
    public static final String[] LOCATOR_TYPE_ARRAY = {"xpath","css","id","className","tagName","linkText","partialLinkText","name"};
    public static final String[] HEADLESS_PAGES_WEB_ARRAY = {"Login"};
    public static final String[] HEADLESS_PAGES_MOB_ARRAY = {"Login"};

    // homepage feedback form localStorage objs
    public static final Map<String, String> FEEDBACKFORM_OBJS = Stream.of(new String[][] {
	{"usbl.bd8b13f9bb40.c.9a660a75e87f", "T/4/////"},		// eu
	{"usbl.e7a32262083a.c.c520f4e5d527", "T/4/////"},		// apac
	}).collect(Collectors.toMap(data -> data[0], data -> data[1]));

    public static final String PROXY_STRING = "http://euproxy:8080";
}
