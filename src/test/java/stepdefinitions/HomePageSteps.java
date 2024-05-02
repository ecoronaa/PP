package stepdefinitions;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.HomePage;

public class HomePageSteps {
    private final HomePage homePage = new HomePage();

    @Then("the welcome page is open")
    public void isWelcomePageOpen() {
        Assert.assertTrue(homePage.state().waitForDisplayed(),
                "Welcome page is not open");
    }

    @When("I click the link in text 'Please click HERE to GO to the next page' to navigate the next page")
    public void clickHere() {
        homePage.clickHereBtn();
    }
}
