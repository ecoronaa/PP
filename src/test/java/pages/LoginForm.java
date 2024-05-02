package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.elements.interfaces.ILabel;
import aquality.selenium.elements.interfaces.ITextBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomNumberUtils;

import java.util.List;

public class LoginForm extends Form {
    private final ITextBox passwordTxtBox = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Choose Password']"), "Password TextBox");
    private final ITextBox emailTxtBox = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Your email']"), "Email TextBox");
    private final ITextBox domainTxtBox = AqualityServices.getElementFactory()
            .getTextBox(By.xpath("//input[@placeholder='Domain']"), "Domain TextBox");
    private final ILabel tldDropdownLbl = AqualityServices.getElementFactory()
            .getLabel(By.cssSelector(".dropdown__field"), "Top-level domains Dropdown Label");
    private final By TLD_LABEL_LOCATOR = By.xpath("//div[@class='dropdown__list-item']");
    private final ICheckBox agreeTermsChk = AqualityServices.getElementFactory()
            .getCheckBox(By.className("checkbox__box"), "Accept terms conditions Checkbox");
    private final IButton nextBtn = AqualityServices.getElementFactory()
            .getButton(By.cssSelector(".button--secondary:not(.u-right)"), "Next Button");

    public LoginForm() {
        super(By.className("login-form-with-pw-check"), "Login Form");
    }

    public void typePassword(String password) {
        passwordTxtBox.clearAndType(password);
    }

    public void typeEmail(String email) {
        emailTxtBox.clearAndType(email);
    }

    public void typeDomain(String domain) {
        domainTxtBox.clearAndType(domain);
    }

    private void openTldDropdown() {
        tldDropdownLbl.click();
    }

    public void selectTld() {
        openTldDropdown();
        List<ILabel> tldLbl = AqualityServices.getElementFactory()
                .findElements(TLD_LABEL_LOCATOR, "Top-level domains Labels",
                        ElementType.LABEL);
        tldLbl.get(RandomNumberUtils.generateRandomInteger(tldLbl.size())).click();
    }

    public void acceptTermsConditions() {
        agreeTermsChk.toggle();
    }

    public void clickNextBtn() {
        nextBtn.click();
    }
}
