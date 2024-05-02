package stepdefinitions;

import io.cucumber.java.en.When;
import pages.GamePage;
import utils.RandomStringUtils;

public class LoginCardSteps {
    private final int EMAIL_LENGTH = 18;
    private final int PASSWORD_LENGTH = 10;
    private final int DOMAIN_LENGTH = 7;
    private final GamePage gamePage = new GamePage();

    @When("I input random valid password, email, accept the terms of use and click 'next' button")
    public void fillInLoginCard() {
        String email = RandomStringUtils.generateRandomString(EMAIL_LENGTH);
        gamePage.getLoginForm().typePassword(RandomStringUtils.generateRandomPassword(email, PASSWORD_LENGTH));
        gamePage.getLoginForm().typeEmail(email);
        gamePage.getLoginForm().typeDomain(RandomStringUtils.generateRandomString(DOMAIN_LENGTH));
        gamePage.getLoginForm().selectTld();
        gamePage.getLoginForm().acceptTermsConditions();
        gamePage.getLoginForm().clickNextBtn();
    }
}
