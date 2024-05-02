package stepdefinitions;

import aquality.selenium.browser.AqualityServices;
import io.cucumber.java.en.When;
import io.qameta.allure.Allure;
import utils.SettingsTestData;

public class BrowserSteps {
    @When("I navigate to the home page")
    public void navigateToHomePage() {
        AqualityServices.getBrowser()
                .goTo(SettingsTestData.getEnvData().getHost());
        Allure.link(AqualityServices.getBrowser().getCurrentUrl());
    }
}
