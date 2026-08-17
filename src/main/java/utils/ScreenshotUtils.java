package utils;

import drivers.DriverManager;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public final class ScreenshotUtils {
    private ScreenshotUtils() {}

    public static String capture(String name) {
        try {
            Path directory = Path.of("reports", "screenshots");
            Files.createDirectories(directory);

            File source = ((TakesScreenshot) DriverManager.getDriver())
                    .getScreenshotAs(OutputType.FILE);

            Path destination = directory.resolve(name + ".png");
            Files.copy(source.toPath(), destination,
                    java.nio.file.StandardCopyOption.REPLACE_EXISTING);

            return destination.toString();
        } catch (Exception e) {
            throw new RuntimeException("Unable to capture screenshot.", e);
        }
    }
}
