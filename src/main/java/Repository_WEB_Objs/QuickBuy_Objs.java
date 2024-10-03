package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class QuickBuy_Objs {

    // Creation of HashMap
    private static final Map<String, String> QuickBuy;

    static {
        QuickBuy = new HashMap<String, String>();

        //quick Buy
        QuickBuy.put("quickBuy_text", "//*[@class='mk-width-60pc']");
        QuickBuy.put("orderCodePartial_element", "//*[@id='partNumber_");
        QuickBuy.put("quantityPartial_element", "//*[@id='quantity_");
        QuickBuy.put("linNotePartial_element", "//*[@id='comment_");
        QuickBuy.put("partNoPartial_elements", "//*[@id='customerPartNumber_");
        QuickBuy.put("addToBasket_button", "//td[@colspan='4']//input");
        QuickBuy.put("quickBuy_icon","//*[@class='buyingtoolIcon']");
        QuickBuy.put("quickBuyPageTitle_text","//*[@class='buyingtoolTxt']");
        QuickBuy.put("quickOrder_tab","//*[@class='tabsMenu newtabMenu']/li/a");
        QuickBuy.put("BOMUpload_button","//*[@class='tabsMenu newtabMenu']/li[3]/a");
        QuickBuy.put("addToAllBasket_button","//*[@class='qb-addBtn']");
        QuickBuy.put("OrderCode_column","//*[@class='newQuickOrdTitle qOsku']");
        QuickBuy.put("resolvedLine_text","//*[@class='smlTxt']");
        QuickBuy.put("stockDiscrepency_text","//*[@class='btmSectxt1']");
        QuickBuy.put("Quantity_column","//*[@class='newQuickOrdTitle qOqty']");
        QuickBuy.put("matchedPart_column","//*[@class='newQuickOrdTitle qOMatchPartNo']");
        QuickBuy.put("priceFor_column","//*[@class='newQuickOrdTitle qOpriceFor']");
        QuickBuy.put("price_column","//*[@class='newQuickOrdTitle qOprice']");
        QuickBuy.put("availability_column","//*[@class='newQuickOrdTitle qOAvail']");
        QuickBuy.put("Description_column","//*[@class='newQuickOrdTitle qODisc']");
        QuickBuy.put("addRow_link","//*[@id='addRowSec']");
        QuickBuy.put("defaultRowCount_textbox", "//*[@class='qOsku']/input");
        QuickBuy.put("firstrow_textbox","//*[@id='partNumber_1']");
        QuickBuy.put("secondrow_textbox","//*[@id='partNumber_2']");
        QuickBuy.put("thirdrow_textbox","//*[@id='partNumber_3']");
        QuickBuy.put("fourthrow_textbox","//*[@id='partNumber_4']");
        QuickBuy.put("fifthrow_textbox","//*[@id='partNumber_5']");
        QuickBuy.put("addedNewRow_textbox","//*[@id='partNumber_6']");
        QuickBuy.put("addRowDisabled_button","//*[@class='addRowSec btnDisable']");
        QuickBuy.put("addToAllBasketDisabled_button","//*[@class='btn btnPrimary addAllBasket disabled']");
        QuickBuy.put("multipleMatchItems","//*[@id='row_3']//div[@class='qo-resolve-item']");
        

        QuickBuy.put("typeHead_text","//*[@class='qo-sku']");
        QuickBuy.put("invalidMessage_text","//*[@class='qo-lookahead-table2']//div[@class='qo-noResult']");
        QuickBuy.put("delete_icon", "//*[@class='delIcon']");
        QuickBuy.put("deletePopup_button","//*[@class='qo-deletepopup']//a[2]");
        QuickBuy.put("successfullyDeleted_text","//*[@id='ordCodeVal']");
        QuickBuy.put("matchedPartValue_text","//*[@class='qOMatchPartNo']//a");
        QuickBuy.put("priceForValue_text","//*[@class='qOpriceFor']//span");
        QuickBuy.put("priceValue1_text","//*[@class='qOprice']//div");
        QuickBuy.put("availabilityValue_text","//*[@class='qOAvail']/a");
        QuickBuy.put("DescriptionValue_text","//*[@class='qODisc']//span");
        QuickBuy.put("greenTick_icon","//*[@class='enhanceInstockIcon']");
        QuickBuy.put("bomUpload_button","//*[@id='bom']");
        
        //quick Paste
        QuickBuy.put("quickPaste_button", "//*[@rel='contentPaneTwo']");
        QuickBuy.put("quickPasteArea_textbox", ".//*[@id='quickPasteArea']");
        QuickBuy.put("addToCart_button", ".//*[@id='quickPasteSubmit']");
        QuickBuy.put("copyPaste_text","//*[@class='qpTxt']");
        QuickBuy.put("quickPaste_image","//*[@class='quickPastImg']");
        QuickBuy.put("belowAddToBasket_text","//*[@class='smltxt']");
    }

    public String findLocator(String elementName) {
        if (QuickBuy.containsKey(elementName)) {
            return (QuickBuy.get(elementName.trim()));
        }

        return null;
    }
}
