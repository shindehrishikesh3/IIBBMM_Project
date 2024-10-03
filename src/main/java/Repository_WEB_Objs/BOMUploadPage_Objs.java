package Repository_WEB_Objs;

import java.util.HashMap;
import java.util.Map;

public class BOMUploadPage_Objs {

	// Creation of HashMap
	private static final Map<String, String> BOMUploadPage;

	static {
		BOMUploadPage = new HashMap<String, String>();
		
		BOMUploadPage.put("bomFileDetails_element", "//div[@class='bomDetailsHeader']");
		BOMUploadPage.put("noMatch_element", "//div[contains(@onclick,'nomatch')]");
		BOMUploadPage.put("noMatchCircle_element", "//*[@class='tab4-circle circle2']");
		BOMUploadPage.put("showallCircle_element","//*[@class='tab1-circle circle1']");
		BOMUploadPage.put("showallItems_element","//*[@class='tab1-circle circle3']");
		BOMUploadPage.put("bomUpload_element", "//div[@class='section BOMHome']");
		BOMUploadPage.put("delete_icon", "//*[@class='btn delBom']");
		BOMUploadPage.put("uploadFile_text", "//input[@id='upfile']");
		BOMUploadPage.put("fileName_text","//*[@class='fileNameLink fileName_1']");
		BOMUploadPage.put("selectAFile_text", "//*[@class='custom-file-upload']");
		BOMUploadPage.put("dateCreated_text", "//*[@id='datecreated1']");
		BOMUploadPage.put(
				"lastModified_text",
				"//*[@class='dtModified column2span']/strong"
				);
		BOMUploadPage.put("verfiedLines_text", "//*[@class='verfiedlines column2span']");
		BOMUploadPage.put("view_button", "//*[@id='viewBOMURL']");
		BOMUploadPage.put("deleteYes_button", "//*[@id='deleteYesBOMURL']");
		BOMUploadPage.put("deleteCancel_button", "//*[@id='delCancel']");
		BOMUploadPage.put("edit_icon", "(//*[@class='editFileNamePath'])[1]");
		BOMUploadPage.put("editFileName_text", "//*[@id='editFileNameText']");
		BOMUploadPage.put("allSelect_checkbox", "//*[@for='selectMasterCheckB']");
		BOMUploadPage.put("unmatchedPartNo_textbox", "//div[@id='bomSearchTextField']/input");
		BOMUploadPage.put("searchProduct_button", "//*[@class='bomSearchLinkPos bomSearchLink']//a");
		BOMUploadPage.put("deleteSelected_button", "//*[@id='selectAllDelete']");
		BOMUploadPage.put("productTobeDeleted_checkbox","//tr[contains(@id,'bomFileRow')][2]//td[1]//*[@class='checkbox']");
		BOMUploadPage.put("pagination_button","//*[@class='pages']");
			
		//Add Product
		BOMUploadPage.put("addPart_link", "//*[@class='bomDetailsHeader-addSec']");
		BOMUploadPage.put("ordercode_text", "//*[@id='partNumber']");
		BOMUploadPage.put("quantity_text", "//*[@id='quantity']");
		BOMUploadPage.put("addPart_button", "//*[@id='bomAddpartSubt']");
		BOMUploadPage.put("showAllitems_text", "//*[@class='tab1-circle circle2']");
        BOMUploadPage.put("qualifier9_text", "//*[@id='bomFileRow_9']/td[5]");

        BOMUploadPage.put("loginOrRegister_popup","//*[@id='guestUserQuoteContent']");
        BOMUploadPage.put("login_link","//*[@class='loginTxt']"); 
        BOMUploadPage.put("qualifier_text", "//td[@class='tCol5']");
        BOMUploadPage.put("qualifiersPartial_element", "//*[@id='bomFileRow_");

		//create  Quote
		BOMUploadPage.put("CreateQuote_link", "//*[@class='createQuoteIcn']");
		BOMUploadPage.put("pricingQuery_radio", "(//*[@name='quoteforgrp'])[1]");
		BOMUploadPage.put("intendedOrder_radio", "(//*[@name='quoteforgrp'])[2]");
		BOMUploadPage.put(
				"continue_button",
				"//*[contains(@class,'SaveBOMQuoteFooter')]/a[2]"
				);
		BOMUploadPage.put("bomQuote_link", "//a[contains(@href,'bomQuote')]");
		BOMUploadPage.put("selectAll_checkbox", "//*[@id='addAllLines']");
		BOMUploadPage.put("addToBasket_button", "//*[@id='buySelectedIdBom']");
		BOMUploadPage.put("editQuotename_text", "(//*[@class='saveBomTitle'])[1]/h3");
		BOMUploadPage.put("editQuoteName_icon", "(//*[@id='editFileName'])[2]");
		BOMUploadPage.put("editQuoteName_text", "//*[@id='editBomFileName']");
		BOMUploadPage.put(
				"saveQuoteName_button",
				"//*[@class='btn btnPrimary bomSaveBut']"
				);
		BOMUploadPage.put("fullReel_icon",
				"//*[contains(@id,'bomFileRow')]//*[@class='pf-icns pf-icn__full-reel']");
		BOMUploadPage.put("cutTape_icon",
				"//*[contains(@id,'bomFileRow')]//*[@class='pf-icns pf-icn__cut-tape']");
		BOMUploadPage.put("boxPackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Box']");
		BOMUploadPage.put("cardPackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Card']");
		BOMUploadPage.put("packPackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Pack']");
		BOMUploadPage.put("pairPackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Pair']");
		BOMUploadPage.put("footPackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Foot']");
		BOMUploadPage.put("kitPackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Kit']");
		BOMUploadPage.put("metrePackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Metre']");
		BOMUploadPage.put("cardPackaging_icon",
				"//*[contains(@id,'bomFileRow')]//*[text()='Card']");
		BOMUploadPage.put("multiplePackaging_icon",
				"//*[contains(@id,'bomFileRow')]//button[@id='drop-down-arrow']");
		BOMUploadPage.put("seeAlternatives_button",
				"//*[contains(@onclick,'See Alternative')]");
		BOMUploadPage.put("seeAlternatives_modal",
				"//*[@id='seeAltView']");
		BOMUploadPage.put("allAlternatives_link",
				"//*[@class='altMainUlList altRightPannel']//*[@class='typeHeaderTxt']/a");
		BOMUploadPage.put("exactAlternative_link",
				"//*[@class='mainColumn exactColumn']//*[@class='typeHeaderTxt']//a");
		BOMUploadPage.put("upgradeAlternative_link",
				"//*[@class='mainColumn upgradeColumn']//*[@class='typeHeaderTxt']//a");
		BOMUploadPage.put("suggestedAlternative_link",
				"//*[@class='mainColumn suggestedColumn']//*[@class='typeHeaderTxt']//a");
		
		
		//Packaging elements
		BOMUploadPage.put("firstPkgType_dropdown", "(//button[@id='drop-down-arrow'])[1]"); 
		BOMUploadPage.put("cutTapePkgType_element", "(//li[@id='altPkgProductUrlCutTape'])[1]");
		BOMUploadPage.put("reReelPkgType_element", "(//li[@id='altPkgProductUrlReel'])[1]");
		BOMUploadPage.put("minCutTapePkgQty_text", "(//li[@id='altPkgProductUrlCutTape']/a/span[2])[1]");
		BOMUploadPage.put("minRereelPkgQty_text", "(//li[@id='altPkgProductUrlReel']/a/span[2])[1]");
		BOMUploadPage.put("firstQty_textbox", "(//input[@class='qtyUpdate'])[1]");
		BOMUploadPage.put("selectFirstRereel_text", "(//li[@id='altPkgProductUrlReel'])[1]");
		BOMUploadPage.put("packageSelect_dropdown", "(//*[@class='package-select']/button)[1]");
		BOMUploadPage.put("packageDetail_dropdown", "(//*[@id='package-detail-wrap']/div[2]/ul/li)[2]/a");
		BOMUploadPage.put("fullReelPackage_element", "//a[contains(@onclick,'changePackaging')]");
		BOMUploadPage.put("fullReelPackageQuantity_textbox", "//button[@id='drop-down-arrow']//following::div[@class='qtyField BOMqtyField']/input");
		BOMUploadPage.put("minQunatity_text", "//button[@id='drop-down-arrow']//following::div[@class='qtyField BOMqtyField']//following::div/span");
		BOMUploadPage.put("multiPackage_dropdown", "//*[@id='drop-down-arrow']");
		BOMUploadPage.put("packageType_element", "(//*[@id='package-detail-wrap'])[1]/div[2]/ul/li");

		
		//MultipleMtach elements
		BOMUploadPage.put("multipleMatch_button","//div[contains(@onclick,'multimatch')]");
		BOMUploadPage.put("multipleMatch_rows","//*[@class='errorLinechange errorLineMain']");
		BOMUploadPage.put("viewAllResults_button","//*[@class='right btn btnSecondary allResult']");
		BOMUploadPage.put("multipleMatchcancel_button","//*[@id='viewAllProds']//a[@class='btn btnSecondary']");
		BOMUploadPage.put("nonExactMatch_text","//*[@id='bomFileRow_15']/td[5]");
		BOMUploadPage.put("exactMatchDirect_text","//*[@id='bomFileRow_14']/td[5]");
		BOMUploadPage.put("exactMatchAvailableForBackOrder_text","//*[@id='bomFileRow_14']/td[6]/div[1]/span/strong");
		BOMUploadPage.put("fullReel_text","//*[@id='bomFileRow_16']/td[7]/span");
		BOMUploadPage.put("partNumberMultipleMatch_column","//*[contains(@id,'bomSearchTextField')]");
		BOMUploadPage.put("viewAllResults_modal","//*[@id='BOMViewAllResults']");
		BOMUploadPage.put("backOrderViewAllResults_icon","//*[@id='BOMViewAllResults']//img[contains(@src,'warning_icon')]");
		
		//Choose Worksheet
		BOMUploadPage.put("worksheet_dropdown", "//*[@id='sheetDataNo']");
		BOMUploadPage.put("editColumnOne_dropdown", "//*[@id='editCol_1']");
		BOMUploadPage.put("editColumnTwo_dropdown", "//*[@id='editCol_2']");
		BOMUploadPage.put("editColumnThree_dropdown", "//*[@id='editCol_3']");
		BOMUploadPage.put("done_button", "//*[@id='doneBtn']");


		//UI Validation
		BOMUploadPage.put("instockProduct_icon", "//img[@alt='stock_avail_Icon']");
		BOMUploadPage.put("backOrderProduct_icon", "//*[@class='avlsty']//*[@clip-rule='evenodd']");
		BOMUploadPage.put("noMatchProduct_icon", "//img[contains(@src,'danger')]");
		BOMUploadPage.put("multipleMatchesProduct_icon", "//*[@class='matchstatus']");
		BOMUploadPage.put("multiMatchCircle_element", "//*[@class='tab3-circle circle2']");
		BOMUploadPage.put("matchedLinesCircle_element", "//*[contains(@class,'tab2-circle')]");
		BOMUploadPage.put("mpn_link", "//*[@class='fixed-side fou-col']/a[1]");
		
		BOMUploadPage.put("morePricing_link", "//*[@class='priceBreakMore']");
		BOMUploadPage.put("downloadBom_link", "//*[@class='downloadBomLink']/a[2]");
		BOMUploadPage.put("bomDetailsHeader_element", "//*[@class='bomDetailsHeader-piSec']");
		
		//BOM error
		BOMUploadPage.put("lineItemsExceeded_modal", "//*[@id='errorView']");
		BOMUploadPage.put("okLineItemsExceeded_button", "//*[@id='errorView']//*[@class='btn btnPrimary v2']");

		//See Alternatives
		BOMUploadPage.put("seeAlternatives_button", "//*[contains(@onclick,'SeeAlt')]");
		BOMUploadPage.put("alternativesManuPartNo_text", "(//*[@class='pf_col-12 altblueTxt']//a)[2]");
		BOMUploadPage.put("addToBOMAlt_button", "//*[@class='btn btnSecondary ajaxAddToCart ']");
		BOMUploadPage.put("alternativeManuPartNo_element", "//td[@class='tCol5']//preceding-sibling::td[1]//a[contains(@href,'");
		 
		//MPN verification
		BOMUploadPage.put("Bomtable_element","//*[@class='bomFileTable']/tbody/tr[contains(@id,'bomFileRow')]");
		BOMUploadPage.put("Resultclose_icon", "(//*[@id='BOMViewAllResults']/div[2]//*[@id='viewAllProds']/div/a)[1");
		BOMUploadPage.put("errorMsg_text","//*[@id='formErrors']/ul/li/ul/li");
		
		//BOM Manual match
		BOMUploadPage.put("BomManualMatch_modal","//*[@id='columnMatchView']");
		BOMUploadPage.put("manualMatchDescription_element","//*[@id='columnMatchView']//*[@class='headerContent']/p[2]");
		BOMUploadPage.put("editManualMatch_dropdown","//*[@id='firstRow']//select[contains(@id,'editCol')]");
		
	}

	public String findLocator(String elementName) {
		if (BOMUploadPage.containsKey(elementName)) {
			return (BOMUploadPage.get(elementName.trim()));
		}

		return null;
	}
}
