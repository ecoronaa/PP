package utils;

import aquality.selenium.browser.AqualityServices;
import lombok.experimental.UtilityClass;

import java.awt.*;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;

/**
 * Utility class for interacting with file explorers.
 */
@UtilityClass
public class FileExplorer {
    private static final int MAX_DELAY = 1000;

    /**
     * Uploads a file using the file explorer.
     *
     * @param file the file to upload
     */
    public static void uploadFile(File file) {
        StringSelection selection = new StringSelection(file.getAbsolutePath());
        Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
        Robot robot;
        try {
            robot = new Robot();
        } catch (AWTException e) {
            AqualityServices.getLogger().error(e.getMessage());
            throw new RuntimeException("Error occurred while initializing Robot instance.", e);
        }
        robot.delay(MAX_DELAY);
        robot.keyPress(KeyEvent.VK_CONTROL);
        robot.keyPress(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_V);
        robot.keyRelease(KeyEvent.VK_CONTROL);
        robot.delay(MAX_DELAY);
        robot.keyPress(KeyEvent.VK_ENTER);
        robot.keyRelease(KeyEvent.VK_ENTER);
    }
}
