package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class StartMobPage extends BaseMobPage {
    private SelenideElement loginButton = $("[name = 'loginButton']");
    private SelenideElement registerButton = $("[name = 'registerButton']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех эллементов страницы")
    private void verifyPageElements() {
        loginButton.shouldBe(visible);
        registerButton.shouldBe(visible);
    }

    @Step("Переходим к авторизации")
    public void goToLogin() {
        loginButton.shouldBe(visible).click();
    }

    @Step("Переходим к регистрации")
    public void goToRegister() {
        registerButton.shouldBe(visible).click();
    }

}
