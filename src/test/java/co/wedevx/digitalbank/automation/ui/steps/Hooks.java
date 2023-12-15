package co.wedevx.digitalbank.automation.ui.steps;

import co.wedevx.digitalbank.automation.ui.utils.ConfigReader;
import co.wedevx.digitalbank.automation.ui.utils.DBUtils;
import co.wedevx.digitalbank.automation.ui.utils.Driver;
import io.cucumber.java.*;

import static co.wedevx.digitalbank.automation.ui.utils.Driver.getDriver;

public class Hooks {

    @Before("@Registration")
    public void establishConnectionToDB() {
        DBUtils.establishConnection();
    }


    @Before("not @Registration")
    public void the_user_is_on_dbank_homepage() {
        getDriver().get(ConfigReader.getPropertiesValue("digitalbank.url"));
    }


    @After("not @NegativeRegistrationCases")
    public void afterEachScenario(Scenario scenario) {
        Driver.takeScreenShot(scenario);
        Driver.closeDriver();
    }

    @After()
    public static void closeConnectionToDB(){
        DBUtils.closeConnection();
    }


}
