package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class iBuyCustomFields_Objs {

    // Creation of HashMap
    private static final Map<String, String> iBuyCustomFields;

    static {
        iBuyCustomFields = new HashMap<String, String>();

        iBuyCustomFields.put("customFields_text", "//*[@class='section my_account']/h1");

        //Field 1
        iBuyCustomFields.put("fieldLabelField1_textbox", "//*[@id='fieldLabelField1']");
        iBuyCustomFields.put(
            "shoppingBasket_radio",
            "(//*[@class='radioField radioFull']/label)[1]"
        );
        iBuyCustomFields.put(
            "requiredFieldsNo_radio",
            "(//*[@class='radio inlineRadios']/span)[2]"
        );
        iBuyCustomFields.put(
            "typeOfFieldDropdown_radio",
            "(//*[@class='radio inlineRadios']/span)[3]"
        );
        iBuyCustomFields.put("inputMask_textbox", "//*[@id='fieldInputMaskField1']");
        iBuyCustomFields.put("dropDownField1_textbox", "//*[@id='fieldDropDownField1']");
        iBuyCustomFields.put(
            "instructionalTextField1_textbox",
            "//*[@id='fieldInstructionalTextField1']"
        );

        //Field 2
        iBuyCustomFields.put("fieldLabelField2_textbox", "//*[@id='fieldLabelField2']");
        iBuyCustomFields.put(
            "orderInformationPage_radio",
            "(//*[@class='radioField radioFull']/label)[4]"
        );
        iBuyCustomFields.put(
            "requiredFieldYes2_radio",
            "(//*[@class='radio inlineRadios']/span)[5]"
        );
        iBuyCustomFields.put(
            "typeOfFieldtext2_radio",
            "(//*[@class='radio inlineRadios']/span)[8]"
        );
        iBuyCustomFields.put("inputMask2_textbox", "//*[@id='fieldInputMaskField2']");
        iBuyCustomFields.put(
            "instructionalTextField2_textbox",
            "//*[@id='fieldInstructionalTextField2']"
        );

        //PO Number
        iBuyCustomFields.put("fieldLabelField3_textbox", "//*[@id='fieldLabelField3']");
        iBuyCustomFields.put(
            "requiredFieldYes3_radio",
            "(//*[@class='radio inlineRadios']/span)[9]"
        );
        iBuyCustomFields.put(
            "typeOfFieldtext3_radio",
            "(//*[@class='radio inlineRadios']/span)[12]"
        );
        iBuyCustomFields.put("inputMask3_textbox", "//*[@id='fieldInputMaskField3']");
        iBuyCustomFields.put(
            "instructionalTextField3_textbox",
            "//*[@id='fieldInstructionalTextField3']"
        );

        //cost code
        iBuyCustomFields.put("fieldLabelField4_textbox", "//*[@id='fieldLabelField4']");
        iBuyCustomFields.put(
            "requiredFieldNo4_radio",
            "(//*[@class='radio inlineRadios']/span)[14]"
        );
        iBuyCustomFields.put(
            "typeOfFieldDropdown4_radio",
            "(//*[@class='radio inlineRadios']/span)[15]"
        );
        iBuyCustomFields.put("inputMask4_textbox", "//*[@id='fieldInputMaskField4']");
        iBuyCustomFields.put(
            "dropDownFieldCost_textbox",
            "//*[@id='fieldDropDownField4']"
        );
        iBuyCustomFields.put(
            "instructionalTextField4_textbox",
            "//*[@id='fieldInstructionalTextField4']"
        );

        //Line Note
        iBuyCustomFields.put("fieldLabelField5_textbox", "//*[@id='fieldLabelField5']");
        iBuyCustomFields.put(
            "requiredFieldNo5_radio",
            "//*[@id='mandField5']/label[2]/span"
        );
        iBuyCustomFields.put(
            "typeOfFieldDropdown5_radio",
            "//*[@id='typeField5']/label[1]/span"
        );
        iBuyCustomFields.put("inputMask5_textbox", "//*[@id='fieldInputMaskField5']");
        iBuyCustomFields.put(
            "dropDownFieldLineNote_textbox",
            "//*[@id='fieldDropDownField5']"
        );
        iBuyCustomFields.put(
            "instructionalTextField5_textbox",
            "//*[@id='fieldInstructionalTextField5']"
        );

        iBuyCustomFields.put("save_button", "(//*[@class='btn btnPrimary'])[2]");
        iBuyCustomFields.put("successfullyUpdated_text", "//*[@id='article']//p[2]");
        iBuyCustomFields.put(
            "returnToEditTier_button",
            "(//*[@class='btn btnTertiary'])[1]"
        );
    }

    public String findLocator(String elementName) {
        if (iBuyCustomFields.containsKey(elementName)) {
            return (iBuyCustomFields.get(elementName.trim()));
        }
        return null;
    }
}
