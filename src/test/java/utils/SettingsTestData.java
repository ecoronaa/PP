package utils;

import aquality.selenium.browser.AqualityServices;
import aquality.selenium.core.utilities.ISettingsFile;
import aquality.selenium.core.utilities.JsonSettingsFile;
import com.google.gson.Gson;
import lombok.experimental.UtilityClass;
import models.EnvData;

import java.io.FileNotFoundException;
import java.io.FileReader;

@UtilityClass
public class SettingsTestData {
    public static final String RESOURCE_FILE_PATH = "src/test/resources/";
    private static final String ENVIRONMENT_PATH = RESOURCE_FILE_PATH + "environment/";
    private static final String ERROR_MSG = "File with environment settings not found or incorrect";
    private static final ISettingsFile ENVIRONMENT_CONFIG = new JsonSettingsFile("env.json");
    private static final Gson GSON = new Gson();

    private static String getEnvironment() {
        return ENVIRONMENT_CONFIG.getValue("/env").toString();
    }

    public static EnvData getEnvData() {
        String envConfigPath = String.format("%s%s.json", ENVIRONMENT_PATH, getEnvironment());
        try {
            return GSON.fromJson(new FileReader(envConfigPath), EnvData.class);
        } catch (FileNotFoundException e) {
            AqualityServices.getLogger().error(ERROR_MSG);
            throw new RuntimeException(ERROR_MSG);
        }
    }
}
