package pages;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.elements.ElementType;
import aquality.selenium.elements.interfaces.IButton;
import aquality.selenium.elements.interfaces.ICheckBox;
import aquality.selenium.forms.Form;
import org.openqa.selenium.By;
import utils.RandomNumberUtils;

import java.util.ArrayList;
import java.util.List;

public class AvatarInterestsForm extends Form {
    private final By INTERESTS_LOCATOR = By.cssSelector(".checkbox__label:not([for$='selectall'])");
    private final ICheckBox unselectAllChk = AqualityServices.getElementFactory()
            .getCheckBox(By.cssSelector("[for$='unselectall']"), "Unselect all checkbox");
    private final IButton uploadBtn = AqualityServices.getElementFactory()
            .getButton(By.className("avatar-and-interests__upload-button"), "Upload Button");
    private final IButton nextBtn = AqualityServices.getElementFactory()
            .getButton(By.className("button--stroked"), "Next Button");

    public AvatarInterestsForm() {
        super(By.className("avatar-and-interests-page"), "Avatar and interests Form");
    }

    public void chooseRandomInterests(int numberOfInterests) {
        unselectAllChk.toggle();
        List<ICheckBox> tmpInterestsChk = new ArrayList<>(getInterestsChk());
        for (int i = 0; i < numberOfInterests; i++) {
            tmpInterestsChk.remove(RandomNumberUtils.generateRandomInteger(tmpInterestsChk.size())).toggle();
        }
    }

    private List<ICheckBox> getInterestsChk() {
        return AqualityServices.getElementFactory()
                .findElements(INTERESTS_LOCATOR, "Interests list Checkboxes", ElementType.CHECKBOX);
    }

    public void clickUploadBtn() {
        uploadBtn.click();
    }

    public void clickNextBtn() {
        nextBtn.click();
    }
}
