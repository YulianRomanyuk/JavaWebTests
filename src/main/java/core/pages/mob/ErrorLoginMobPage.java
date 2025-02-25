package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class ErrorLoginMobPage extends BaseMobPage {

    private SelenideElement closeButton = $("[value= 'Закрыть']");
    private SelenideElement recoveryButton = $("[value= 'Восстановить']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость эллементов на странице")
    private void verifyPageElements() {
        closeButton.shouldBe(visible);
        recoveryButton.shouldBe(visible);
    }

    @Step("Закрываем форму")
    public void cancelLogin() {
        closeButton.shouldBe(visible).click();
    }

    @Step("Переходим к форме восстаноовления")
    public void goToRecovery() {
        recoveryButton.shouldBe(visible).click();
    }
}