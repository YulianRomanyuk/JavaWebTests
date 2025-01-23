package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByPhoneMobPage extends BaseMobPage {
    private SelenideElement getCodeButton = $("[id = 'getCode']");
    private SelenideElement numberField = $("[class= 'input-text_element']");
    private SelenideElement countryNameList = $("[data-no-country-text= 'noCountry']");

    //Локатор для эллемента с сообщением об ошибке
    private SelenideElement errorNumberMessage = $("[class= 'field_error-descr']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость эллементов на странице")
    private void verifyPageElements() {
        getCodeButton.shouldBe(visible);
        numberField.shouldBe(visible);
        countryNameList.shouldBe(visible);
    }

    @Step("Получаем код для восстановления по телефону")
    public void getCode() {
        getCodeButton.shouldBe(visible).click();
    }

    @Step("Вводим номер телефона")
    public void setPhoneNumber() {
        numberField.shouldBe(visible).click();
        numberField.shouldBe(visible).setValue("wrongNumber");
    }

    @Step("Раскрываем выпадающий список стран")
    public void openCountriesList() {
        countryNameList.shouldBe(visible).click();
    }

    @Step("Проверяем видимость сообщения об ошибке Логина")
    public boolean isErrorNumberMessageVisible() {
        return errorNumberMessage.shouldBe(visible).exists();
    }

    @Step("Получаем текст сообщения об ошибке Логина")
    public String getNumErrorMessageText() {
        return errorNumberMessage.shouldBe(visible).getText();
    }

    @Step("Ищем страну по названию")
    public SelenideElement selectCountryNameFromList(String countryName) {
        openCountriesList();
        SelenideElement countryItem = $(By.xpath(String.format("//div[contains(text(), '%s')]", countryName)));
        countryItem.click();
        return countryItem;
    }

}
