package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByPhonePage extends BasePage {
    private SelenideElement codeButton = $("[data-l='t,submit']");
    private SelenideElement phoneNumberField = $("[data-l='t,phone']");
    private SelenideElement countryCodeDropdown = $("[class='isl_w country-select_label']");

    //Локатор для эллемента с сообщением об ошибке
    private SelenideElement errorMessage = $("[class='input-e js-ph-vl-hint']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость кнопки на странице")
    public void verifyPageElements() {
        codeButton.shouldBe(visible);
        phoneNumberField.shouldBe(visible);
        countryCodeDropdown.shouldBe(visible);
    }

    @Step("Нажимаем кнопку 'Получить код'")
    public void getCode() {
        codeButton.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке входа")
    public boolean isErrorMessageVisible() {
        return errorMessage.shouldBe(visible).exists();
    }

    @Step("Выбираем код страны по названию: {countryName}")
    public String selectCountryByName(String countryName) {
        countryCodeDropdown.click();//Открываем выпадающий список
        SelenideElement countryItem = $(String.format(".country-select_i[data-name='%s']", countryName));//Находим нужную строку по названию
        countryItem.scrollTo();
        String countryCode = countryItem.find(".country-select_code").text();//Прокручиваем к строке и выбираем ее
        countryItem.click();
        return countryCode;
    }
}
