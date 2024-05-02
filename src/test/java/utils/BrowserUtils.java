package utils;

import aquality.selenium.browser.AqualityServices;
import io.qameta.allure.Attachment;
import lombok.experimental.UtilityClass;

@UtilityClass
public class BrowserUtils {
    @Attachment(value = "Screenshot", type = "image/png")
    public static byte[] attachScreenshot() {
        return AqualityServices.getBrowser().getScreenshot();
    }
}
