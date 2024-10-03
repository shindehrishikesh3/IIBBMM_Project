package Common.UTILS;

import Translation.APAC_Countries.AU_Translation;
import Translation.APAC_Countries.CN_Translation;
//import Translation.APAC_Countries.KR_Translation;
import Translation.APAC_Countries.SG_Translation;
import Translation.APAC_Countries.TH_Translation;
import Translation.EU_Countries.BE_Translation;
import Translation.EU_Countries.BG_Translation;
import Translation.EU_Countries.CH_DE_Translation;
import Translation.EU_Countries.CH_FR_Translation;
import Translation.EU_Countries.CPC_Translation;
import Translation.EU_Countries.CZ_Translation;
import Translation.EU_Countries.DE_Translation;
import Translation.EU_Countries.DK_Translation;
import Translation.EU_Countries.EE_Translation;
import Translation.EU_Countries.ES_Translation;
import Translation.EU_Countries.FI_Translation;
import Translation.EU_Countries.FR_Translation;
import Translation.EU_Countries.HU_Translation;
import Translation.EU_Countries.IT_Translation;
import Translation.EU_Countries.LV_Translation;
import Translation.EU_Countries.NO_Translation;
import Translation.EU_Countries.PL_Translation;
import Translation.EU_Countries.PT_Translation;
import Translation.EU_Countries.RO_Translation;
import Translation.EU_Countries.RU_Translation;
import Translation.EU_Countries.SE_Translation;
import Translation.EU_Countries.SK_Translation;
import Translation.EU_Countries.TR_Translation;
import Translation.US_Countries.CANADA_Translation;
import Translation.US_Countries.PT_BR_Translation;
import Translation.US_Countries.US_ES_Translation;
import Translation.US_Countries.US_Translation;

public class TranslationConfig implements BaseTest {

    String RegionName = "";
    String StoreValue = "";
    String value = "";
    String getCurrentUrl = "";

    US_Translation us = new US_Translation();
    US_ES_Translation us_es = new US_ES_Translation();
    SG_Translation sg = new SG_Translation();
    AU_Translation au = new AU_Translation();
    FR_Translation fr = new FR_Translation();
    DE_Translation de = new DE_Translation();
    CH_FR_Translation ch_fr = new CH_FR_Translation();
    CH_DE_Translation ch_de = new CH_DE_Translation();
    CPC_Translation cpc = new CPC_Translation();
    CN_Translation cn = new CN_Translation();
    BE_Translation be = new BE_Translation();
    BG_Translation bg = new BG_Translation();
    CZ_Translation cz = new CZ_Translation();
    DK_Translation dk = new DK_Translation();
    EE_Translation ee = new EE_Translation();
    FI_Translation fi = new FI_Translation();
    HU_Translation hu = new HU_Translation();
    IT_Translation it = new IT_Translation();
    LV_Translation lv = new LV_Translation();
    NO_Translation no = new NO_Translation();
    PL_Translation pl = new PL_Translation();
    PT_Translation pt = new PT_Translation();
    RO_Translation ro = new RO_Translation();
    RU_Translation ru = new RU_Translation();
    SK_Translation sk = new SK_Translation();
    SE_Translation se = new SE_Translation();
    TH_Translation th = new TH_Translation();
    TR_Translation tr = new TR_Translation();
//    KR_Translation kr = new KR_Translation();
    PT_BR_Translation ptbr = new PT_BR_Translation();
    ES_Translation es = new ES_Translation();
    CANADA_Translation ca  = new CANADA_Translation();

    public String getStoreText(String text) {
        RegionName = driverConfig.getRegionName();
        StoreValue = driverConfig.getStore();
        getCurrentUrl = driverConfig.getCurrentUrl();
        System.out.println("Current Store: " + StoreValue);

        // ****************APAC Translation File*********************************
        if (RegionName.equalsIgnoreCase("apac")) {
            if (StoreValue.equalsIgnoreCase("sg")) {
                value = sg.sgTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("au")) {
                value = au.auTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("cn")) {
                value = cn.cnTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("th")) {
                value = th.thTranslations(text);
            } 
//            else if (StoreValue.equalsIgnoreCase("kr")) {
//                value = kr.krTranslations(text);
//            } 
            else {
                value = text.trim();
            }
        }

        // ****************NEWARK Translation File*********************************
        if (RegionName.equalsIgnoreCase("newark")) {
            if (
                StoreValue.equalsIgnoreCase("us") &&
                (getCurrentUrl.contains("/es") || getCurrentUrl.contains("langId=72"))
            ) {
                value = us_es.esUSTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("mexico") &&
                !(getCurrentUrl.contains("en-MX") || getCurrentUrl.contains("langId=95"))
            ) {
                value = us_es.esUSTranslations(text);
            }else if (
                StoreValue.equalsIgnoreCase("mexico") &&
                (getCurrentUrl.contains("en-MX") || getCurrentUrl.contains("langId=95"))
            ) {
                value = us.usTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("us") &&
                (getCurrentUrl.contains("pt-BR") || getCurrentUrl.contains("langId=-6"))
            ) {
                value = ptbr.ptbrTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("us")) {
                value = us.usTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("canada") && !getCurrentUrl.contains("fr-CA")) {
                value = ca.canadaTranslations(text);
            } else {
                value = text.trim();
            }
        }

        // ****************EUROPE Translation File*********************************
        if (RegionName.equalsIgnoreCase("europe")) {
            if (StoreValue.equalsIgnoreCase("uk")) {
                value = ukTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("fr")) {
                value = fr.frTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("de") &&
                (getCurrentUrl.contains("langId=74") || getCurrentUrl.contains("en-DE"))
            ) {
                value = ukTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("de") &&
                (!getCurrentUrl.contains("en-DE") || getCurrentUrl.contains("langId=-3"))
            ) {
                value = de.deTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("ch") &&
                (getCurrentUrl.contains("fr-CH") || getCurrentUrl.contains("langId=35"))
            ) {
                value = ch_fr.chFRTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("ch") || getCurrentUrl.contains("langId=41")
            ) {
                value = ch_de.chDETranslations(text);
            } else if (StoreValue.equalsIgnoreCase("cpc")) {
                value = cpc.cpcTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("at") && (!getCurrentUrl.contains("en-AT"))
            ) {
                value = de.deTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("be") &&
                (!getCurrentUrl.contains("en-BE") || getCurrentUrl.contains("fr-BE"))
            ) {
                value = be.beTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("be") && getCurrentUrl.contains("fr-BE")
            ) {
                value = fr.frTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("bg")) {
                value = bg.bgTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("cz") && !getCurrentUrl.contains("en-CZ")
            ) {
                value = cz.czTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("dk") && !getCurrentUrl.contains("en-DK")
            ) {
                value = dk.dkTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("ee")) {
                value = ee.eeTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("fi") && !getCurrentUrl.contains("en-FI")
            ) {
                value = fi.fiTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("hu") &&
                !(getCurrentUrl.contains("en-HU") || getCurrentUrl.contains("langId=96"))
            ) {
                value = hu.huTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("it") &&
                !(getCurrentUrl.contains("en-IT") || getCurrentUrl.contains("langId=39"))
            ) {
                value = it.itTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("lv")) {
                value = lv.lvTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("nl") &&
                !(getCurrentUrl.contains("en-NL") || getCurrentUrl.contains("langId=76"))
            ) {
                value = be.beTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("no") &&
                !(getCurrentUrl.contains("en-NO") || getCurrentUrl.contains("langId=79"))
            ) {
                value = no.noTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("pl") &&
                !(getCurrentUrl.contains("en-PL") || getCurrentUrl.contains("langId=48"))
            ) {
                value = pl.plTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("pt") &&
                !(getCurrentUrl.contains("en-PT") || getCurrentUrl.contains("langId=81"))
            ) {
                value = pt.ptTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("ro")) {
                value = ro.roTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("ru")) {
                value = ru.ruTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("sk")) {
                value = sk.skTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("es") &&
                !(getCurrentUrl.contains("en-ES") || getCurrentUrl.contains("langId=34"))
            ) {
                value = es.esTranslations(text);
            } else if (
                StoreValue.equalsIgnoreCase("se") &&
                !(getCurrentUrl.contains("en-SE") || getCurrentUrl.contains("langId=75"))
            ) {
                value = se.seTranslations(text);
            } else if (StoreValue.equalsIgnoreCase("tr")) {
                value = tr.trTranslations(text);
            } else {
                value = text.trim();
            }
        }

        return value;
    }

    // ############uk--English############
    public String ukTranslations(String text) {
        return (text.trim());
    }
}
