package core.base;

import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Map;

public class MobileBaseTest extends AbstractBaseTest {

    @Override
    public void configure() {
        Configuration.browser = "chrome";

        //Настройка эмуляции мобильного устройства
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation",
                Map.of("deviceName", "iPhone X") //Указываем устройство
        );
        //Применяем настройки ChromeOptions
        Configuration.browserCapabilities = chromeOptions;
    }
}
