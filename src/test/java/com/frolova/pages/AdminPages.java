package com.frolova.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

import static ch.lambdaj.Lambda.convert;

/**
 * Created by Frolova.A on 4/28/15.
 */

@DefaultUrl("")
@NamedUrls(
        {
                  @NamedUrl(name = "Bwin", url = "g")

        }
)
public class AdminPages extends PageObject {
    private WebDriver driver;
    private String adminCamp,checkCamp,baseUrl,m;
    private boolean checked_sandbox;
    private boolean checked_production;

    ///////////////////////////////
    @FindBy(id = "Login")
    private WebElementFacade login;
    ///////////////////////////////
    @FindBy(id = "Password")
    private WebElementFacade password;
    ///////////////////////////////
    @FindBy(css = "input.mm-dd-input")
    private WebElementFacade user_menu;
    ///////////////////////////////
    @FindBy(linkText = "Logout")
    private WebElementFacade logout;
    ///////////////////////////////
    @FindBy(css = "body > form > div.form-group.auth-form-group-submit > button")
    private WebElementFacade submit;
    ///////////////////////////////
    @FindBy (xpath = "//*[@id=\"ActionLog_colaps_block\"]/div[1]/div/div")
    private WebElementFacade configuration_text;
    ///////////////////////////////////////
    @FindBy(name = "ConfigType")
    private WebElementFacade sandbox;
    ///////////////////////////////////////
    @FindBy(css = "#lLive > input[name=\"ConfigType\"]")
    private WebElementFacade production;
    ///////////////////////////////////////
    @FindBy(name = "IpCategory")
    private WebElementFacade company_ip;
    ///////////////////////////////////////
    @FindBy(css = "#lGLOBAL_LIST > input[name=\"IpCategory\"]")
    private WebElementFacade other_ip;
    ///////////////////////////////////////
    @FindBy(id = "bDropToArchive")
    private WebElementFacade clear;
    ///////////////////////////////////////////////////////
    @FindBy(css = "div.stateStr")
    private WebElementFacade configuration;
    ///////////////////////////////////////
    @FindBy(id = "HIT")
    private WebElementFacade hit;
    ///////////////////////////////////////
    @FindBy(id = "CITY")
    private WebElementFacade city;
    ///////////////////////////////////////
    @FindBy(id = "PAGE")
    private WebElementFacade page;
    ///////////////////////////////////////
    @FindBy(id = "CAMPAIGN")
    private WebElementFacade campaign;
    ///////////////////////////////////////
    @FindBy(id = "CAMPAIGN_VERSION")
    private WebElementFacade campaign_version;
    ///////////////////////////////////////
    @FindBy(id = "ISGENERATION")
    private WebElementFacade isGeneration;
    ///////////////////////////////////////
    @FindBy(id = "ISCONTENTPAGE")
     private WebElementFacade isContentPage;
    ///////////////////////////////////////
    @FindBy(id = "CRITERIA")
    private WebElementFacade pc;
    ///////////////////////////////////////
    @FindBy(id = "SEGMENTS")
    private WebElementFacade segments;
    ///////////////////////////////////////
    @FindBy(id = "COOKIES")
    private WebElementFacade cookies;
    ///////////////////////////////////////
    @FindBy(id = "REFERRER")
    private WebElementFacade referrer;
    ///////////////////////////////////////
    @FindBy(id = "SERVER")
    private WebElementFacade server;
    ///////////////////////////////////////
    @FindBy(id = "AGENT")
    private WebElementFacade agent;
    ///////////////////////////////////////
    @FindBy(id = "BROWSER")
    private WebElementFacade browser;
    ///////////////////////////////////////
    @FindBy(id = "OS")
    private WebElementFacade os;
    ///////////////////////////////////////
    @FindBy(id = "DEVICETYPE")
    private WebElementFacade deviceType;
    ///////////////////////////////////////
    @FindBy(id = "SITELOCATION")
    private WebElementFacade siteLocation;
    ///////////////////////////////////////
    @FindBy(id = "GENERATIONMETHOD")
    private WebElementFacade generationmethod;
    ///////////////////////////////////////
    @FindBy(id = "bApply")
    private WebElementFacade apply;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_0__Weight")
    private WebElementFacade weigtdefault;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_1__Weight")
    private WebElementFacade weighta2;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_2__Weight")
    private WebElementFacade weighta3;
    ///////////////////////////////////////
    @FindBy(id = "Elements_0__Variants_3__Weight")
    private WebElementFacade weighta4;
    ///////////////////////////////////////
    @FindBy(id = "SaveElement")
    private WebElementFacade saveWeight;
    @FindBy(xpath = "//*[@id='ActionLog_colaps_block']/div[1]/span")
    private WebElementFacade btn_hide_settings;
    ///////////////////////////////////////
    private String count_column;
    private String content_campaign;
    private String content;
///////////////////////////////////////

    ///////////////////////////////////////////////////////////////////////////////////////////

    public void enterLoginPass(String log, String pass){
        login.sendKeys(log);
        password.sendKeys(pass);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void logInSubmit(){
        submit.click();
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void clearActionLog(){
        clear.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_user_menu(){
        user_menu.isPresent();
        user_menu.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_btn_logout(){
        logout.isPresent();
        logout.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_configuration_action_log(){

        campaign.click();
        pc.click();
        segments.click();
        browser.click();
        apply.click();

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
        getDriver().navigate().refresh();
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public void openWeights() {
        getDriver().get("https://ui61.maxymiser.com/Admin/account-igame/529/site-kolikkopelit-com/930/ActionLog/AjaxLoadGrid?configType=Sandbox&ipCategory=OWN_IP&_=1439620062197");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void closeDriver(){
        driver.quit();
    }
    /////////////////////////////////////////
    public List<String> getDefinitions() {
        WebElementFacade definitionList = find(By.tagName("body"));
        List<WebElement> results = definitionList.findElements(By.tagName("pre"));
        System.out.println("RESULTS"+results);
        return convert(results, toStrings());
    }
    /*String results = getDriver().getPageSource();
        System.out.println(results);
        return convert(results, toStrings());*/
    /////////////////////////////////////////////////////////////////////////////////////////////
    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigtsdef(String weigts){
        weigtdefault.clear();
        weigtdefault.sendKeys(weigts);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigts_a2(String weigts){
        weighta2.clear();
        weighta2.sendKeys(weigts);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigts_a3(String weigts){
        weighta3.clear();
        weighta3.sendKeys(weigts);
    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void change_weigts_a4(String weigts){
        weighta4.clear();
        weighta4.sendKeys(weigts);
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void click_button_save_weight(){
        saveWeight.click();

    }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////Content column
private String content_count = "//tr[y]/td[5]";

    private WebElement prepareWebElementWithDynamicXpathContent (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("y", substitutionValue)));
    }
    /////////////////////////////////action_count
    private String actiom_count = "//tr[x]/td[6]";

    private WebElement prepareWebElementWithDynamicXpathActions (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("x", substitutionValue)));
    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public void open_configuration_block() {
        configuration.isPresent();
        System.out.println("configuration text 1-" + getDriver().findElement(By.xpath("//*[@id=\"ActionLog_colaps_block\"]/div[1]/div/div")).getText());
        System.out.println("configuration text 2-" + configuration.getText());
        System.out.println("configuration text 3-" + configuration_text.getText());
        configuration_text.getText().equals("Configuration: Sandbox; IP Groups: Company IP Addresses");
        configuration.click()  ;
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_sandbox() {
        sandbox.isPresent();
        System.out.println("Sandbox text -"+ sandbox.getText());
        sandbox.getText().equals("Sandbox");
        sandbox.click();
        System.out.println("configuration text for sandbox -"+ configuration.getText());
        checked_sandbox = configuration_text.getText().equals("Configuration: Sandbox; IP Groups: Company IP Addresses");
        while (checked_sandbox = false){
            sandbox.click();
            checked_sandbox = configuration_text.getText().equals("Configuration: Sandbox; IP Groups: Company IP Addresses");
        }


    }


    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_product() {
        production.isPresent();
        System.out.println("production text -" + production.getText());
        production.getText().equals("Production");
        production.click();
        System.out.println("configuration text for production-" + configuration.getText());
        checked_sandbox = configuration.getText().equals("Configuration: Production; IP Groups: Company IP Addresses");
        while (checked_sandbox = false){
            sandbox.click();
            checked_sandbox = configuration.getText().equals("Configuration: Production; IP Groups: Company IP Addresses");
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_company_ip() {
        company_ip.isPresent();
        System.out.println("Company IP Addresses text -" + company_ip.getText());
        company_ip.getText().equals("Company IP Addresses");
        company_ip.click();
        System.out.println("configuration text for production-" + configuration.getText());
        checked_sandbox = configuration.getText().equals("Configuration: Production; IP Groups: Company IP Addresses");
        while (checked_sandbox = false){
            sandbox.click();
            checked_sandbox = configuration.getText().equals("Configuration: Production; IP Groups: Company IP Addresses");
        }

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void choose_other_ip() {
        other_ip.isPresent();
        System.out.println("Company IP Addresses text -" + other_ip.getText());
        other_ip.getText().equals("Company IP Addresses");
        other_ip.click();
        System.out.println("configuration text for production-" + configuration.getText());
        checked_sandbox = configuration.getText().equals("Configuration: Sandbox; IP Groups: Other IP Addresses");
        while (checked_sandbox = false){
            sandbox.click();
            checked_sandbox = configuration.getText().equals("Configuration: Sandbox; IP Groups: Other IP Addresses");
        }

    }

    ///////////////////////////////////////////////////////////////////////////////////////////
    public int choose_count_content() {
        int i;
        List<WebElement> list = getDriver().findElements(By.xpath("//*[@id='grid']/div[1]/table/tbody/tr"));
        for ( i=0;i<list.size();i++){
            System.out.println("list "+list.get(i));
//// проверки для каждого элемента отдельно: list.get(i) - вернет і-тый элемент списка всех элементов
        }
        System.out.println("list.size - "+list.size());
        return list.size();
////   XPathExpression xPathExpr = xpath.compile("count(.//*[@id='grid']/div[1]/table/tbody/tr)");

    }


    /////////////////////////////////////////////////////////////////////////////////////////////
    public String choose_content(String NameParametersContent) {
       System.out.println("Content title name"+ getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/table/thead/tr/th[5]")).getText());
        System.out.println("content_count"+content_count);
        WebElement RequiredNameParameters = prepareWebElementWithDynamicXpathContent(content_count, NameParametersContent);
        System.out.println("Имя поля content"+NameParametersContent);
        String content = RequiredNameParameters.getText();
        System.out.println("поле content"+content);

        return content;
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public String choose_actions(String NameParametersContent) {
        System.out.println("Campaign title name "+ getDriver().findElement(By.xpath("//*[@id='grid']/div[1]/table/thead/tr/th[6]")).getText());
        System.out.println("actiom_count "+actiom_count);
        WebElement RequiredNameParameters = prepareWebElementWithDynamicXpathActions(actiom_count, NameParametersContent);
        System.out.println("Номер поля  "+NameParametersContent);
        String content_action = RequiredNameParameters.getText();
        System.out.println("поле action"+content_action);
       if (content_action==null){
           content= "empty content";
           System.out.println("content_campaign"+content);
       }else
           content=content_action;
        return content;
    }
///////////////////////////////////////
/////////////////////////////////Content column
private String column = "//*[@id='grid']/div[1]/table/thead/tr/th[c]";

    private WebElement prepareWebElementWithDynamicXpathColumns(String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("c", substitutionValue)));
    }

    ///////////////////////////////
    public void check_column_what_we_see() {
        int i ;

        do {
            List<WebElement> list = getDriver().findElements(By.xpath(".//*[@id='grid']/div[1]/table/thead/tr/*"));
            for ( i=0;i<list.size();i++){
           System.out.println("list column "+list.get(i));

            }
        }while (i<=6);
        System.out.println("количество колонок"+i);
        while (i>0){
            count_column = String.valueOf(i);
            WebElement column_name = prepareWebElementWithDynamicXpathColumns(column,count_column);
            System.out.println("list.size column- "+i);
            column_name.getText();
            System.out.println(i+"-"+column_name.getText());
            i--;}
    }
}
