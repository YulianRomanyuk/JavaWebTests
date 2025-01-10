package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByPhone extends BasePage {
    private SelenideElement codeButton = $("[data-l='t,submit']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость кнопки на странице")
    public void verifyPageElements() {
        codeButton.shouldBe(visible);
    }
}
