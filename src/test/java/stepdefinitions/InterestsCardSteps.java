package stepdefinitions;

import io.cucumber.java.en.When;
import pages.GamePage;
import utils.FileExplorer;
import utils.SettingsTestData;

import java.io.File;

public class InterestsCardSteps {
    private final GamePage gamePage = new GamePage();
    @When("I choose {int} random interests, upload {string}, click 'Next' button")
    public void fillInInterestsCard(int numberOfInterests, String avatarFile) {
        gamePage.getAvatarInterestsForm().chooseRandomInterests(numberOfInterests);
        gamePage.getAvatarInterestsForm().clickUploadBtn();

        FileExplorer.uploadFile(new File(SettingsTestData.RESOURCE_FILE_PATH + avatarFile));

        gamePage.getAvatarInterestsForm().clickNextBtn();
    }
}
