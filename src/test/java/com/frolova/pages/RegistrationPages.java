package com.frolova.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.NamedUrl;
import net.thucydides.core.annotations.NamedUrls;
import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static net.thucydides.core.webdriver.ThucydidesWebDriverSupport.getDriver;
import static org.junit.Assert.assertEquals;

/**
 * Created by Frolova.A on 11/10/2015.
 */
@DefaultUrl("https://www.bwin.com/")
@NamedUrls(
        {
                @NamedUrl(name = "language.sports", url = "https://sports.bwin.com/{1}/sports"),
                @NamedUrl(name = "language.bwin", url = "https://www.bwin.com/{1}"),
                ////exlude
                @NamedUrl(name = "exlude.sports", url = "https://sports.bwin.com/{1}/live/live-betting?trid="),
                @NamedUrl(name = "exlude.bwin", url = "https://www.bwin.com/")
        }
)
public class RegistrationPages extends PageObject {
    private WebDriver driver;
    private String adminCamp,checkCamp,baseUrl,m;

    @Before
    public void setUp(){

        adminCamp = "https://www.bwin.com/";

    }

    @FindBy(css = "css=a.btn-s3")
    private WebElementFacade btn_top_Register;
    /////////////////////////////////
    @FindBy(id = "Input_LoginData_Username")
    private WebElementFacade usename;
    /////////////////////////////////
    @FindBy(id = "Input_LoginData_Password")
    private WebElementFacade password;
    /////////////////////////////////
    @FindBy(id = "Input_NameData_FirstName")
    private WebElementFacade firstName;
    /////////////////////////////////
    @FindBy(id = "Input_NameData_LastName")
    private WebElementFacade lastName;
    /////////////////////////////////
    @FindBy(id = "Input_BirthData_DateOfBirth_Day")
    private Select select_dateOfBirth_Day = new Select(driver.findElement(By.id("Input_BirthData_DateOfBirth_Day")));;
    ///////////////////////////////////////
    @FindBy(id = "Input_BirthData_DateOfBirth_Day")
    private WebElementFacade dateOfBirth_Day;
    /////////////////////////////////
    @FindBy(id = "Input_BirthData_DateOfBirth_Month")
    private Select select_dateOfBirth_Month;
    /////////////////////////////////
    @FindBy(id = "Input_BirthData_DateOfBirth_Month")
    private WebElementFacade dateOfBirth_Month;
    /////////////////////////////////
    @FindBy(id = "Input_BirthData_DateOfBirth_Year")
    private Select select_dateOfBirth_Year;
    /////////////////////////////////
    @FindBy(id = "Input_BirthData_DateOfBirth_Year")
    private WebElementFacade dateOfBirth_Year;
    /////////////////////////////////
    @FindBy(id = "Input_AddressData_AddressState")
    private Select select_addressState;
    /////////////////////////////////
    @FindBy(id = "Input_AddressData_AddressState")
    private WebElementFacade addressState;
    /////////////////////////////////
    @FindBy(id = "Input_AddressData_AddressCity")
    private WebElementFacade addressCity;
    /////////////////////////////////
    @FindBy(id = "Input_AddressData_AddressZip")
    private WebElementFacade addressZip;
    /////////////////////////////////
    @FindBy(id = "Input_AddressData_AddressLine1")
    private WebElementFacade addressLine1;
    /////////////////////////////////
    @FindBy(id = "Input_ContactData_EmailAddress")
    private WebElementFacade emailAddress;
    /////////////////////////////////
    @FindBy(id = "Input_ContactData_MobileCountryCode")
    private Select select_mobileCountryCode;
    /////////////////////////////////
    @FindBy(id = "Input_ContactData_MobileCountryCode")
    private WebElementFacade mobileCountryCode;
    /////////////////////////////////
    @FindBy(id = "Input_ContactData_MobileNumber")
    private WebElementFacade mobileNumber;
    /////////////////////////////////
    @FindBy(id = "mm-next-button")
    private WebElementFacade btn_mm_next_button;
    /////////////////////////////////
    @FindBy(id = "Input_SecurityData_SecurityQuestion")
    private WebElementFacade securityQuestion;
    /////////////////////////////////
    @FindBy(id = "Input_SecurityData_SecurityQuestion")
    private Select select_securityQuestion;
    /////////////////////////////////
    @FindBy(id = "Input_SecurityData_SecurityAnswer")
    private WebElementFacade securityAnswer;
    /////////////////////////////////
    @FindBy(id = "Input_SecurityData_SecurityAnswer")
    private Select select_securityAnswer;
    /////////////////////////////////
    @FindBy(id = "Input_TermsAndConditions_TacAcceptance")
    private WebElementFacade termsAndConditions;
    /////////////////////////////////
    @FindBy(id = "submit")
    private WebElementFacade btn_submit;

    /////////////////////////////////
    /*    @FindBy(id = "Input_BirthData_DateOfBirth_Day")
    private Select select_dateOfBirth_Day;
    /////////////////////////////////*/
    private String DaySystemNameXpath = "//option[@value='day']";

    private WebElement select_dateOfBirth_Day (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("day", substitutionValue)));
    }
    /////////////////////////////////
    private String privinceSystemNameXpath = "//option[@value='y']";

    private WebElement privince (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("y", substitutionValue)));
    }
    /////////////////////////////////
    private String CountryCodeSystemNameXpath = "//select[@id='x']";

    private WebElement сountryCode (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("x", substitutionValue)));
    }
    /////////////////////////////////
    private String SecurityQuestionSystemNameXpath = "//select[@id='z']";

    private WebElement securityQuestion (String xpathValue, String substitutionValue ) {

        return getDriver().findElement(By.xpath(xpathValue.replace("z", substitutionValue)));
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void fill_field_first_name(String name){
        firstName.isPresent();
        firstName.click();
        firstName.clear();
        firstName.type(name);
        String text_firstname = firstName.getValue();
        System.out.println(text_firstname + " getValue");
        assertEquals(text_firstname, name);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void fill_field_surname(String surname){
        lastName.isPresent();
        lastName.click();
        lastName.type(surname);
        String text_surname = lastName.getValue();
        assertEquals(text_surname, surname);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void select_field_privince (String AddressState){
        addressState.isPresent();
        addressState.click();
        select_addressState.selectByValue(AddressState);
        privince(privinceSystemNameXpath, AddressState).click();
        String text_addressState = addressState.getValue();
        assertEquals(text_addressState, AddressState);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void fill_field_addressCity(String surname){
        addressCity.isPresent();
        addressCity.click();
        addressCity.type(surname);
        String text_surname = addressCity.getValue();
        assertEquals(text_surname, surname);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void fill_field_addressZip(String zip){
        addressZip.isPresent();
        addressZip.click();
        addressZip.type(zip);
        String text_surname = addressZip.getValue();
        assertEquals(text_surname, zip);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void fill_field_addressLine1(String addressLine){
        addressLine1.isPresent();
        addressLine1.click();
        addressLine1.type(addressLine);
        String text_surname = addressLine1.getValue();
        assertEquals(text_surname, addressLine);

    }

    /////////////////////////////////////////////////////////////////////////////////////////////
    public void select_field_day (String day){
        dateOfBirth_Day.isPresent();
      dateOfBirth_Day.click();
        select_dateOfBirth_Day.selectByValue(day);
        WebElement RequiredDay= select_dateOfBirth_Day(DaySystemNameXpath, day);
        System.out.println("RequiredDay"+RequiredDay);
        System.out.println("DaySystemNameXpath"+DaySystemNameXpath);

        RequiredDay.click();
        String Birth_Day = dateOfBirth_Day.getValue();
        assertEquals(Birth_Day, day);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void select_field_mon (String mon){
        dateOfBirth_Month.isPresent();
        dateOfBirth_Month.click();
        dateOfBirth_Month.selectByValue(mon);
        String Birth_Mon = dateOfBirth_Month.getValue();
        assertEquals(Birth_Mon, mon);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void select_field_year (String year){
        dateOfBirth_Year.isPresent();
        dateOfBirth_Year.click();
        dateOfBirth_Year.type(year);
        String Birth_Mon = dateOfBirth_Year.getValue();
        assertEquals(Birth_Mon, year);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void fill_field_email(String email){
        emailAddress.isPresent();
        emailAddress.click();
        emailAddress.type(email);
        String text_surname = emailAddress.getValue();
        assertEquals(text_surname, email);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void select_field_сountryCode (String countryCode){
        mobileCountryCode.isPresent();
        mobileCountryCode.click();
        mobileCountryCode.selectByValue(countryCode);
        сountryCode(CountryCodeSystemNameXpath, countryCode).click();
        String text_mobileCountryCode = mobileCountryCode.getValue();
        assertEquals(text_mobileCountryCode, countryCode);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void select_field_number (String number){
        mobileNumber.isPresent();
        mobileNumber.click();
        mobileNumber.type(number);
        String numberMob = mobileNumber.getValue();
        assertEquals(numberMob, number);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void fill_field_username (String username){
        usename.isPresent();
        usename.click();
        usename.type(username);
        String usenameText = usename.getValue();
        assertEquals(usenameText, username);

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void select_field_securityQuestion (String Question){
        securityQuestion.isPresent();
        securityQuestion.click();
        select_securityQuestion.selectByVisibleText(Question);
        securityQuestion(SecurityQuestionSystemNameXpath, Question).click();
        String text_Question = securityQuestion.getValue();
        assertEquals(text_Question, Question);

    }
    ////////////////////////////////////////////////////////////////////////////////////////////
    public void select_Input_TermsAndConditions(){
        termsAndConditions.isPresent();
        termsAndConditions.click();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    // Button
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void click_btn_registrationNow(){

        btn_top_Register.isPresent();
        btn_top_Register.click();
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    public void click_btn_submit(){
        btn_submit.isPresent();
        btn_submit.click();
    }
}
