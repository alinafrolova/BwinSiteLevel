package com.frolova.features;

import com.frolova.pages.CampaignPages;
import com.frolova.steps.AdminSteps;
import com.frolova.steps.RegistrationSteps;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.WithDriver;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;

/**
 * Created by Frolova.A on 11/10/2015.
 */
@RunWith(SerenityRunner.class)
public class RegistrationStory {
    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @Steps
    AdminSteps adminSteps;
    @Steps
    RegistrationSteps registrationSteps;
    @Steps
    CampaignPages campaignPages;

//    @Before
//    @WithDriver("chrome")
//    public void setUp(){
//        adminSteps.openAdmin("Bwin","account-bwin/458/site-bwin-com/258");
//        adminSteps.loginAdmin();
//        adminSteps.clearAdmin();
//    }
    @Test
    @WithDriver("firefox")
    public void work_with_campaign_popup_click(){
        String language = "en";
        registrationSteps.openSite("language.bwin", language);
        registrationSteps.fill_all_fields();


    }

}
