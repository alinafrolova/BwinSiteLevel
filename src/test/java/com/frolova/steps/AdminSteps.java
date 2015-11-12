package com.frolova.steps;


import com.frolova.pages.AdminPages;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import java.util.ArrayList;
import java.util.Collections;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertThat;

/**
 * Created by Frolova.A on 5/12/15.
 */
public class AdminSteps extends ScenarioSteps {
    AdminPages adminPages;


    private boolean bla;
    private int i;
    private int amount;

    @Step
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void loginAdmin(){
        adminPages.enterLoginPass("","");
        adminPages.logInSubmit();
//        adminPages.choose_configuration_action_log();
    }
    @Step
    ///////////////////////////////////////////////////////////////////////////////////////////
    public void clearAdmin(){
        adminPages.clearActionLog();
        System.out.println("------------------------------------------------------------------------------------------------------------------------------------------------------");
    }
    /////////////////////////////////////////////////////////////////////////////////////////////
    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void openAdmin(String name,String url ){
        getDriver().manage().window().maximize();
        adminPages.open(name,  new String[] {url});
        System.out.println(name + "name");

        }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void logOut() {

        adminPages.click_user_menu();
        adminPages.click_btn_logout();
        adminPages.deleteAllCookies();
    }
    @Step
    //////////////////////////////////////////////////////////////////////////////////////////
    public void openActionLog(String name,String url ){
        adminPages.open(name,  new String[] {url});
        System.out.println("my url"+url);
//        mmdriver.trackAction("t12a_stepone=1");
//        mmdriver.trackAction("t12a_steptwo=1,unique;");
//        mmdriver.trackAction("t12a_stepthree=1,unique;");
//        mmdriver.trackAction("t12a_registration=1");
//        mmdriver.trackAction("t12a_firstdeposit");
       }

    @Step
    public void should_see_definition(String text,String definition, int amount) {
        assertThat(adminPages.getDefinitions(), hasItem(containsString(definition)));

    }
    /////////////////////////////////////////////////////////////////////////////////////////////
   /////////////////////////////////////////////////////////////////////////////////////////////
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void choose_configuration_for_sandbox_company_ip() {
        adminPages.open_configuration_block();
        adminPages.choose_sandbox();
        adminPages.choose_company_ip();
        adminPages.choose_configuration_action_log();

    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void choose_configuration_for_production_company_ip() {
        adminPages.open_configuration_block();
        adminPages.choose_product();
        adminPages.choose_company_ip();
        adminPages.choose_configuration_action_log();

        adminPages.check_column_what_we_see();
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void choose_configuration_for_sandbox_other_ip() {
        adminPages.open_configuration_block();
        adminPages.choose_sandbox();
        adminPages.choose_other_ip();
        adminPages.choose_configuration_action_log();
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void choose_configuration_for_production_other_ip() {
        adminPages.open_configuration_block();
        adminPages.choose_product();
        adminPages.choose_other_ip();
        adminPages.choose_configuration_action_log();
    }

    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public int check_content(String Variant) {
        amount=0;
        ArrayList<String> columnList = new ArrayList<String>();
        System.out.println("Открыть спиок полученых полей  ");
        int count= adminPages.choose_count_content();
        System.out.println("берем количество полей которые появились в админке "+count);

        for ( int i=count;i>0;i--){
            String nuber_column = Integer.toString(count);
            System.out.println("Номер колонки который мы берем для проверки "+nuber_column);
            adminPages.choose_content(nuber_column);
            count = count-1;

            System.out.println("номер слендующей колонки которую мы возьмем для проверки "+nuber_column);
            columnList.add(adminPages.choose_content(nuber_column));
            System.out.println("добавила в columnList значение которое мы получили проверяя поле"+columnList);
        }
        //если два элемента String content = Default.concat(VariantA2);
        System.out.println("значение которое мы получим- "+Variant);
        int count_content = Collections.frequency(columnList, Variant); // получим результат 2
        System.out.println("значение которое мы будем сравнивать с значением которое получили с текущего поля- "+count_content);
        System.out.println("String.valueOf(count)- " + String.valueOf(count)); // выводим результат в TextView
        ////поиск контента
        for (String num : columnList) {
            String strToPrint = num;
            System.out.println(strToPrint);
            bla = strToPrint.equals(Variant);
            System.out.println("проверяем количетсво раз загрузки контента "+bla);

            if (bla == true){
                amount = amount+1;

//// проверки для каждого элемента отдельно: list.get(i) - вернет і-тый элемент списка всех элементов
            }


        }

        System.out.println("amount content"+amount);

        return amount;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public int check_actions(Object Variant) {
        amount=0;
        ArrayList<String> columnList = new ArrayList<String>();
        System.out.println("Открыть спиок  ");
        int count= adminPages.choose_count_content();
        System.out.println("берем значение поля количество"+count);

        for ( int i=count;i>0;i--){
            String nuber_column = Integer.toString(count);
            System.out.println("Номер колонки "+nuber_column);
            count = count-1;
            adminPages.choose_actions(nuber_column);
            System.out.println("номер колонки если -1 "+nuber_column);
            columnList.add(adminPages.choose_actions(nuber_column));
            System.out.println("добавила в columnList значение"+columnList);
        }
        //если два элемента String content = Default.concat(VariantA2);
        System.out.println("значение которое мы получим- "+Variant);
        int count_content = Collections.frequency(columnList, Variant); // получим результат 2
        System.out.println("значение - "+count_content);
        System.out.println("String.valueOf(count)- " + String.valueOf(count)); // выводим результат в TextView

        for (String num : columnList) {
            String strToPrint = num;
            System.out.println(strToPrint);
            bla = strToPrint.equals(Variant);
            System.out.println("проверяем сколько раз трекнулся"+bla);

            if (bla == true){
                amount = amount+1;

//// проверки для каждого элемента отдельно: list.get(i) - вернет і-тый элемент списка всех элементов
            }


        }

        System.out.println("amount actions "+amount);
        return amount;
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    void amountaction() {

    }
    ///////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////////////////////////////////////////////////////////
   @Step
   public void settings_weight_all(){
       adminPages.openWeights();
       adminPages.change_weigtsdef("100");
       adminPages.change_weigts_a2("100");
       adminPages.change_weigts_a3("100");
       adminPages.change_weigts_a4("100");

       adminPages.click_button_save_weight();
   }
   //////////////////////////////////////////////////////////////////////////////////////////
   @Step
   public void settings_weight_default(){
       adminPages.openWeights();
       adminPages.change_weigtsdef("100");
       adminPages.change_weigts_a2("0");
       adminPages.change_weigts_a3("0");
       adminPages.change_weigts_a4("0");
       adminPages.click_button_save_weight();
   }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void settings_weight_a2(){
        adminPages.openWeights();
        adminPages.change_weigtsdef("0");
        adminPages.change_weigts_a2("100");
        adminPages.change_weigts_a3("0");
        adminPages.change_weigts_a4("0");
        adminPages.click_button_save_weight();
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void settings_weight_a3(){
        adminPages.openWeights();
        adminPages.change_weigtsdef("0");
        adminPages.change_weigts_a2("0");
        adminPages.change_weigts_a3("100");
        adminPages.change_weigts_a4("0");
        adminPages.click_button_save_weight();
    }
    //////////////////////////////////////////////////////////////////////////////////////////
    @Step
    public void settings_weight_a4(){
        adminPages.openWeights();
        adminPages.change_weigtsdef("0");
        adminPages.change_weigts_a2("0");
        adminPages.change_weigts_a3("0");
        adminPages.change_weigts_a4("100");
        adminPages.click_button_save_weight();
    }
}
