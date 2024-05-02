package stepdefinitions;

import constants.Cards;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Assert;
import pages.GamePage;


public class GamePageSteps {
    private final GamePage gamePage = new GamePage();

    @When("I accept cookies")
    public void acceptCookies() {
        gamePage.acceptCookies();
    }

    @Then("the form is closed")
    public void isCookiesClosed() {
        Assert.assertTrue(gamePage.isCookiesFormClosed(),
                "Cookies form is not closed");
    }

    @When("I hide the help form")
    public void hideHelp() {
        gamePage.hideHelpForm();
    }

    @Then("the form content is hidden")
    public void isHelpHidden() {
        Assert.assertTrue(gamePage.isHelpFormHidden(),
                "Form content is not hidden");
    }

    @Then("I validate that timer starts from {string}")
    public void validateTimer(String timerToValidate) {
        Assert.assertEquals(gamePage.getTimer(), timerToValidate,
                String.format("Timer does not start from '%s'", timerToValidate));
    }

    @Then("the card {cards} is open")
    public void isCardOpen(Cards cards) {
        Assert.assertTrue(gamePage.isCardOpen(cards.getValue()),
                String.format("The card '%s' is not open", cards.getValue()));
    }
}
