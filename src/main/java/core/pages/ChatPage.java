package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ChatPage extends BasePage {
    private SelenideElement closeButton = $("[name='ico_close_16']");
    private SelenideElement openWindow = $("[name='ico_fullscreen_16']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех эллементов страницы")
    private void verifyPageElements() {
        closeButton.shouldBe(visible);
        openWindow.shouldBe(visible);
    }

    @Step("Закрываем окно чата поддержки")
    public void closeChat() {
        closeButton.shouldBe(visible).click();
    }

    @Step("Раскрываем окно чата поддержки")
    public void openWindow() {
        openWindow.shouldBe(visible).click();
    }
}
