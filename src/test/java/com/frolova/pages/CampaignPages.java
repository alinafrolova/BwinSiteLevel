package com.frolova.pages;

import ch.lambdaj.function.convert.Converter;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import static ch.lambdaj.Lambda.convert;

/**
 * Created by Frolova.A on 4/29/15.
 */
@DefaultUrl("https://www.bwin.com/")

@NamedUrls(
        {
                @NamedUrl(name = "language.sports", url = "https://sports.bwin.com/{1}/sports"),
                @NamedUrl(name = "language.bwin", url = "https://www.bwin.com/{1}/registration"),
                ////exlude
                @NamedUrl(name = "exlude.sports", url = "https://sports.bwin.com/{1}/live/live-betting?trid="),
                @NamedUrl(name = "exlude.bwin", url = "https://www.bwin.com/")
        }
)

public class CampaignPages extends PageObject {

    private WebDriver driver;
    /////////////////////////////////
    Cookie mmcore = new Cookie("mmcore.opc.enabled", "1");
    Cookie cfgid = new Cookie("mmcore.cfgid", "1");


    //////////////////////////////////LogIn
    @FindBy(id = "username")
    private WebElementFacade username;
    //////////////////////////////////
    @FindBy(id = "password")
    private WebElementFacade password;
    /////////////////////////////////
    @FindBy(name = "submit")
    private WebElementFacade submit;
    /////////////////////////////////
    @FindBy(id = "auth-form-container")
    private WebElementFacade auth_form;
    /////////////////////////////////
    /////////////////////////////////
    private String RequiredSystemNameXpath = "(//button[@type='submit'])[y]";

    private WebElement prepareWebElementWithDynamicXpath (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("y", substitutionValue)));
    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void deleteAllCookies() {
        getDriver().manage().deleteAllCookies();
    }
   /////////////////////////////////////////////////////////////////////////////////////////////
   public void addCookies(){

       getDriver().manage().addCookie(mmcore);
       System.out.println("enabled");
       getDriver().manage().addCookie(cfgid);
       getDriver().navigate().refresh();
}
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void check_cookie_bwinar(String name){

        Set<Cookie> Cookie_bwinar = (Set<Cookie>) getDriver().manage().getCookieNamed(name);
        System.out.println("Cookie_bwinar"+Cookie_bwinar);

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void check_cookie(){
        Set<Cookie> allCookies = getDriver().manage().getCookies();
        System.out.println("allCookies"+allCookies);
        for (Cookie loadedCookie : allCookies) {
            System.out.println(String.format("%s -> %s", loadedCookie.getName(), loadedCookie.getValue()));

        }
    }

    /////////////////////////////////////////
    public List<String> getTitleLogPage() {
        WebElementFacade TitleList = find(By.id("header"));
        System.out.println(TitleList);
        List<WebElement> resultsTitle = TitleList.findElements(By.tagName("li"));
        System.out.println(resultsTitle);
        return convert(resultsTitle, toStrings());
    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    private Converter<WebElement, String> toStrings() {
        return new Converter<WebElement, String>() {
            public String convert(WebElement from) {
                return from.getText();
            }
        };
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void log_in(String name, String pass){
        username.type(name);
        password.type(pass);
        submit.click();
        waitFor(auth_form);
        getDriver().manage().timeouts().pageLoadTimeout(300, TimeUnit.SECONDS);

      }
    public void choose_bet(String NameParametersBet){
        WebElement RequiredNameParameters = prepareWebElementWithDynamicXpath(RequiredSystemNameXpath, NameParametersBet);
        System.out.println(NameParametersBet);
        RequiredNameParameters.click();
    }
}
