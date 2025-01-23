package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class LoginMobPage extends FirstLoginMobPage {

    private SelenideElement registrationButton = $(By.xpath("//div[contains(text(),'Регистрация')]"));

    //Локаторы для кнопок соцсетей
    private SelenideElement vkButton = $("[class = 'base-button_target __oauth-vkconnect']");
    private SelenideElement mailButton = $("[class = 'base-button_target __oauth-mailru']");
    private SelenideElement yaButton = $("[class = 'base-button_target __oauth-yandex']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость эллементов на странице")
    private void verifyPageElements() {
        vkButton.shouldBe(visible);
        mailButton.shouldBe(visible);
        yaButton.shouldBe(visible);
    }

    @Step("переходим к авторизации с помощью VK")
    public void loginWithVK() {
        vkButton.shouldBe(visible).click();
    }

    @Step("переходим к авторизации с помощью Mail")
    public void loginWithMail() {
        mailButton.shouldBe(visible).click();
    }

    @Step("переходим к авторизации с помощью Ya")
    public void loginWithYa() {
        yaButton.shouldBe(visible).click();
    }
}
