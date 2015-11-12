package com.frolova.steps;

import com.frolova.addition.Temp;
import com.frolova.pages.CampaignPages;
import com.frolova.pages.RegistrationPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;
import org.openqa.selenium.Cookie;

import java.util.Random;


import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;
import org.apache.log4j.xml.DOMConfigurator;
import org.apache.log4j.Logger;

/**
 * Created by Frolova.A on 11/10/2015.
 */
public class RegistrationSteps extends ScenarioSteps {

    CampaignPages campaignPages;
    RegistrationPages registrationPages;
    Temp temp;
    ///////////////////////////////////////////////////////////
    String name = "MMbwinw" + Temp.randomtxt(4)+"b";
    String username = "MMrankw" +  Temp.randomtxt(4)+"b";
    String mail = "MMrankw" + Temp.randomtxt(4) +new Random().nextInt(999)+ "@maxymiser.com";
    String phone = "85895758"+ new Random().nextInt(999);
    private Cookie mmcore;

    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
        public void openSite(String name,String url){

        campaignPages.open(name,  new String[] {url});
        System.out.println(name + "name");
        getDriver().manage().window().maximize();
        campaignPages.deleteAllCookies();
       // campaignPages.addCookies();
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void should_see_title_page(String text,String resultsTitle) {
        assertThat(campaignPages.getTitleLogPage(), hasItem(containsString(resultsTitle)));

    }

    ///////////////////////////////////////////////////////////
    @Step
    public void click_main_btn_join(){

        registrationPages.click_btn_registrationNow();

    } ///////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////
    @Step
    public void fill_all_fields(){
        campaignPages.check_cookie_bwinar("mmcore.bwinvar");
 //       campaignPages.log_in("mmtest699","123123q");
        registrationPages.fill_field_first_name(name);
        registrationPages.fill_field_surname(name);
        registrationPages.select_field_day("1");
//    ?    registrationPages.select_field_mon("Feb");
        registrationPages.select_field_year("1990");
     //?   registrationPages.select_field_privince("AVON");
    //    registrationPages.fill_field_addressCity("London");
   //     registrationPages.fill_field_addressZip("w1w6ql");
   //     registrationPages.fill_field_addressLine1("bla bla");
  //      registrationPages.fill_field_email(mail);
        registrationPages.select_field_сountryCode("+375");
        registrationPages.select_field_number(phone);


    } ///////////////////////////////////////////////////////////

}
