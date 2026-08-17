package config;

public final class ConfigManager {
    private ConfigManager() {}

    public static String browser() {
        return System.getProperty("browser", "chrome").toLowerCase();
    }

    public static String environment() {
        return System.getProperty("environment", "qa").toLowerCase();
    }

    public static boolean headless() {
        return Boolean.parseBoolean(System.getProperty("headless", "false"));
    }

    public static String baseUrl() {
        return switch (environment()) {
            case "qa" -> "https://www.saucedemo.com/";
            default -> "https://www.saucedemo.com/";
        };
    }
}
