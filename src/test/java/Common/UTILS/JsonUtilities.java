package Common.UTILS;

import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.ReadContext;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;
import net.minidev.json.JSONArray;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;

public class JsonUtilities {

    /**
     * Method to parse json document from given path
     *
     * @param path
     * @return ReadContext object
     */
    public ReadContext getJsonDocument(String path) {
        ReadContext readContext = null;
        File file = new File(path);
        if (file.exists()) {
        	try (FileInputStream input = new FileInputStream(path)) {
                String json = FileUtils.readFileToString(
                    new File(path),
                    StandardCharsets.UTF_8
                );
                readContext = JsonPath.parse(json);
                input.close();
            } catch (IOException e) {
                Assert.fail("Json document not found/loaded");
            }
        } else {
            Assert.fail("File " + path + " does not exists");
        }
        return readContext;
    }

    /**
     * Get key value from store specific json
     *
     * @param readContext
     * @param store
     * @param key         Examples - instock, visa.cardnumber.
     * @return string value of the key
     */
    public String getStringKeyValueFromStoreSpecificJson(
        ReadContext readContext,
        String store,
        String key
    ) {
	try{
        JSONArray value = readContext.read("$.." + store + "." + key);
        return value.get(0).toString();
	} catch (IndexOutOfBoundsException e){
		return null;
	}
    }

    /**
     * Get key value from common json
     *
     * @param readContext
     * @param store
     * @param key
     * @return String value of the key
     */
    public String getKeyValueFromCommonJson(ReadContext readContext, String key) {
        JSONArray value = readContext.read("$.." + key);
        return value.get(0).toString();
    }

    public int getTotalObjectFromJsonArray(ReadContext readContext, String key) {
        int value = readContext.read("$." + key + ".length()");
        return value;
    }

    /**
     * Applicable to fetch all the data from jsonArray
     * @param readContext
     * @param parentKey
     * @param childKey
     * @return
     * Example- CategoryHeaders_en_GB.json
     */
    public String getValueFromJsonArray(
        ReadContext readContext,
        int i,
        String parentKey,
        String childKey
    ) {
        String value = readContext.read("$." + parentKey + "[" + i + "]." + childKey);
        return value;
    }

    /**
     * Applicable to get value from nested jsonArray
     * @param readContext
     * @param parentKey
     * @param childKey
     * @return
     * Example- CategoryHeaders_en_GB.json
     */
    public int getTotalValuesFromNestedJsonArray(
        ReadContext readContext,
        int i,
        String parentKey,
        String childKey
    ) {
        int value = readContext.read(
            "$." + parentKey + "[" + i + "]." + childKey + ".length()"
        );
        return value;
    }

    public String getValueFromNestedJsonArray(
        ReadContext readContext,
        int i,
        String parentKey,
        String childKey,
        int j,
        String innerKey
    ) {
        String value = readContext.read(
            "$." + parentKey + "[" + i + "]." + childKey + "[" + j + "]." + innerKey
        );
        return value;
    }
}
