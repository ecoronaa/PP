package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;

public class HomePage extends Form {
    private final IButton hereBtn = AqualityServices.getElementFactory()
            .getButton(By.className("start__link"), "HERE link");

    public HomePage() {
        super(By.className("start"), "Home Page");
    }

    public void clickHereBtn() {
        hereBtn.click();
    }
}
