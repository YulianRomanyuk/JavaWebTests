package core.base;

import com.codeborne.selenide.Configuration;

public class BaseTest extends AbstractBaseTest {

    @Override
    public void configure() {
        Configuration.browser = "chrome";
        Configuration.browserSize = "1920x1080";
    }
}

