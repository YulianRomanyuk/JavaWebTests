package core.base;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

import java.io.InputStream;
import java.util.Properties;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public abstract class AbstractBaseTest {
    //Базовый URL для веб-тестов
    protected static String baseUrl;

    @BeforeEach
    public void setUp() {
        baseUrl = determineBaseUrl();
        configure();
    }
    public abstract void configure(); //Метод для настройки среды

    private static String determineBaseUrl() {
        String environment = System.getProperty("env", "test");
        String configFileName = "application-" + environment + ".properties";

        Properties properties = new Properties();
        try (InputStream input = BaseTest.class.getClassLoader().getResourceAsStream(configFileName)) {
            if (input == null) {
                throw new IllegalStateException("Configuration not found:" + configFileName);
            }
            properties.load(input);
        } catch (Exception e) {
            throw new IllegalStateException("Unable to load configuration file: " + configFileName, e);
        }
        return properties.getProperty("baseUrl");
    }

    @AfterEach
    public void tearDown() {
        //Закрываем веб-драйвер после каждого теста
        closeWebDriver();
    }
}
