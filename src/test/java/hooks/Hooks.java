package hooks;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.browser.Browser;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import utils.BrowserUtils;
import utils.CustomCategoryUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Hooks {
    private final Browser browser = AqualityServices.getBrowser();

    @Before()
    public void setUp() {
        browser.maximize();
    }

    @AfterStep()
    public void screenshot() {
        BrowserUtils.attachScreenshot();
    }

    @After()
    public void tearDown() {
        generateEnvProperties();
        generateCategoriesJson();
        browser.quit();
    }

    public void generateEnvProperties() {
        String DIRECTORY_PATH = "target/allure-results/";
        String FILE_NAME = "environment.properties";
        String browserName = "Browser=" + browser.getBrowserName();
        String browserVersion = "Version=" + browser.getDriver().getCapabilities().getBrowserVersion();
        String content = browserName + "\n" + browserVersion;
        String ERROR_MSG = "File with environment properties not created";
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(DIRECTORY_PATH + FILE_NAME))) {
            writer.write(content);
        } catch (IOException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }

    public void generateCategoriesJson() {
        List<CustomCategoryUtils> customCategories = new ArrayList<>();

        customCategories.add(new CustomCategoryUtils("Ignored tests", List.of("skipped")));
        customCategories.add(new CustomCategoryUtils("Failed tests", List.of("failed")));
        customCategories.add(new CustomCategoryUtils("Broken tests", List.of("broken")));
        customCategories.add(new CustomCategoryUtils("Unknown tests", List.of("unknown")));
        customCategories.add(new CustomCategoryUtils("Passed tests", List.of("passed")));

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(customCategories);

        String ERROR_MSG = "File with categories not created";

        try (FileWriter writer = new FileWriter("target/allure-results/categories.json")) {
            writer.write(json);
        } catch (IOException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }
}
