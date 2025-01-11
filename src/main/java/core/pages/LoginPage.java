package core.pages;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;


import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginPage extends BasePage {
    private SelenideElement usernameField = $("[name='st.email']");
    private SelenideElement passwordField = $("[name='st.password']");
    private SelenideElement loginButton = $("[data-l='t,sign_in']");
    private SelenideElement forgotPasswordLink = $("[data-l='t,restore']");
    private SelenideElement registrationButton = $(".button-pro.__sec.mb-3x.__wide");
    private SelenideElement loginByQrCodeButton = $("[data-l='t,get_qr']");

    //Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[class = 'i ic social-icon __s __vk_id']");
    private SelenideElement mailButton = $("[class = 'i ic social-icon __s __mailru']");
    private SelenideElement yaButton = $("[class = 'i ic social-icon __s __yandex']");

    //Локатор для эллемента с сообщением об ошибке входа
    private SelenideElement errorMessage = $(".input-e.login_error");

    //Локатор для перехода к восстановлению
    private SelenideElement goToRecoveryButton = $("[value='st.go_to_recovery']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех эллементов страницы")
    private void verifyPageElements() {
        usernameField.shouldBe(visible);
        passwordField.shouldBe(visible);
        loginButton.shouldBe(visible);
        forgotPasswordLink.shouldBe(visible);
        registrationButton.shouldBe(visible);
        loginByQrCodeButton.shouldBe(visible);
        vkButton.shouldBe(visible);
        mailButton.shouldBe(visible);
        yaButton.shouldBe(visible);
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке входа")
    public String getErrorMessageText() {
        return errorMessage.shouldBe(visible).getText();
    }

    @Step("Входим на сайт с логином {username} и {password}")
    public void login(String username, String password) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        passwordField.shouldBe(visible).click();
        passwordField.shouldBe(visible).setValue(password);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с логином {username}")
    public void loginWithUsername(String username) {
        usernameField.shouldBe(visible).click();
        usernameField.shouldBe(visible).setValue(username);
        loginButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт с паролем {password}")
    public void loginWithPassword(String password) {
        passwordField.shouldBe(visible).setValue(password);
        passwordField.shouldBe(visible).click();
        loginButton.shouldBe(visible).click();
    }

    @Step("Нажимаем восстановить профиль")
    public void goToRecovery() {
        goToRecoveryButton.shouldBe(visible).click();
    }


    @Step("Переходим на страницу восстановления пароля")
    public void openForgotPassword() {
        forgotPasswordLink.shouldBe(visible).click();
    }

    @Step("Переходим на страницу авторизации при помощи QR")
    public void openQrLogin() {
        loginByQrCodeButton.shouldBe(visible).click();
    }

    @Step("Переходим на страницу регистрации")
    public void openRegistration() {
        registrationButton.shouldBe(visible).click();
    }

    //Методы для перехода на страницу авторизации через соцсети
    @Step("Входим на сайт через ВКонтакте")
    public void loginByVkButton() {
        vkButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    public void loginByMailButton() {
        mailButton.shouldBe(visible).click();
    }

    @Step("Входим на сайт через ВКонтакте")
    public void loginByYaButton() {
        yaButton.shouldBe(visible).click();
    }
}
