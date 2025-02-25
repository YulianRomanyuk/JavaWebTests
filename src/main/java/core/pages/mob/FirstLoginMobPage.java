package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FirstLoginMobPage extends BaseMobPage {
    private SelenideElement loginField = $("[id= 'field_login']");
    private SelenideElement passwordField = $("[id= 'field_password']");
    private SelenideElement loginButton = $("[name= 'button_login']");
    private SelenideElement forgotPasswordButton = $("[class = 'base-button __plain __modern __full-width']");

    //Локаторы для эллементов с сообщением об ошибке входа
    private SelenideElement errorMessageLog = $(By.xpath("//label[contains(text(),'Укажите логин')]"));
    private SelenideElement errorMessagePass = $(By.xpath("//label[contains(text(),'Укажите пароль')]"));
    private SelenideElement errorMessage = $("div[class='info-block_content'] ul li");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех эллементов страницы")
    private void verifyPageElements() {
        loginField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке Логина")
    public boolean isLogErrorMessageVisible() {
        return errorMessageLog.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке Логина")
    public String getLogErrorMessageText() {
        return errorMessageLog.shouldBe(visible).getText();
    }

    @Step("Проверяем видимость сообщения об ошибке Пароля")
    public boolean isPassErrorMessageVisible() {
        return errorMessagePass.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке Логина")
    public String getPassErrorMessageText() {
        return errorMessagePass.shouldBe(visible).getText();
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином {username} и паролем {password}")
    public void login(String username, String password) {
        loginField.shouldBe(visible).click();
        loginField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с логином {username}")
    public void loginWithUsername(String username) {
        loginField.shouldBe(visible).click();
        loginField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с паролем {password}")
    public void loginWithPassword(String password) {
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Переходим к восстановлению")
    public void goToRecovery() {
        forgotPasswordButton.shouldBe(visible).click();
    }
}
