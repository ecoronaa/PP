package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.forms.Form;
import lombok.Getter;
import org.openqa.selenium.By;

public class GamePage extends Form {
    private final IButton sendToBottomBtn = AqualityServices.getElementFactory()
            .getButton(By.className("help-form__send-to-bottom-button"), "Send to bottom Button");
    private final ILabel helpFormLbl = AqualityServices.getElementFactory()
            .getLabel(By.className("help-form__title"), "Help Label");
    private final IButton noCookiesBtn = AqualityServices.getElementFactory()
            .getButton(By.className("button--transparent"), "No cookies Button");
    private final ILabel timerLbl = AqualityServices.getElementFactory()
            .getLabel(By.className("timer"), "Timer Label");
    private final ILabel cookiesLbl = AqualityServices.getElementFactory()
            .getLabel(By.className("cookies__message"), "Cookies Label");
    @Getter
    private final LoginForm loginForm;
    @Getter
    private final AvatarInterestsForm avatarInterestsForm;
    @Getter
    private final PersonalDetailsForm personalDetailsForm;

    public GamePage() {
        super(By.className("game"), "Game Page");
        loginForm = new LoginForm();
        avatarInterestsForm = new AvatarInterestsForm();
        personalDetailsForm = new PersonalDetailsForm();
    }

    public void hideHelpForm() {
        sendToBottomBtn.click();
    }

    public boolean isHelpFormHidden() {
        return AqualityServices.getConditionalWait().waitFor(() -> !helpFormLbl.state().isDisplayed());
    }

    public void acceptCookies() {
        noCookiesBtn.click();
    }

    public boolean isCookiesFormClosed() {
        return !cookiesLbl.state().isExist();
    }

    public String getTimer() {
        return timerLbl.getText();
    }

    public boolean isCardOpen(int cardNumber) {
        return switch (cardNumber) {
            case 1 -> loginForm.state().isDisplayed();
            case 2 -> avatarInterestsForm.state().isDisplayed();
            case 3 -> personalDetailsForm.state().isDisplayed();
            default -> throw new IllegalArgumentException(String.format("The %s card it's not recorded", cardNumber));
        };
    }
}
