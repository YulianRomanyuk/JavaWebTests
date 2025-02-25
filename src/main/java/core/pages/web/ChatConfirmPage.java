package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ChatConfirmPage extends BasePage {
    private SelenideElement yesButton = $("[class='button-core__0ej09 __size-m__0ej09 __wide__0ej09']");
    private SelenideElement noButton = $("[class='button-core__0ej09 __size-m__0ej09 __view-secondary__0ej09 __wide__0ej09']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех элементов на странице Подтверждения")
    private void verifyPageElements() {
        yesButton.shouldBe(visible);
        noButton.shouldBe(visible);
    }

    @Step("Подтвердить решение вопроса")
    public void confirm() {
        yesButton.shouldBe(visible).click();
    }

    @Step("Не подтвердить решение вопроса")
    public void reject() {
        yesButton.shouldBe(visible).click();
    }
}
