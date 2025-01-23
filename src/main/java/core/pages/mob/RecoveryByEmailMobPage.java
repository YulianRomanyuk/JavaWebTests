package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class RecoveryByEmailMobPage extends BaseMobPage {

    private SelenideElement emailField = $("[id= 'field_email']");
    private SelenideElement getCodeButton = $("[id= 'reg_email_button']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех эллементов страницы")
    private void verifyPageElements() {
        emailField.shouldBe(visible);
        getCodeButton.shouldBe(visible);
    }

    @Step("Указываем Email адрес")
    public void setEmail() {
        emailField.shouldBe(visible).click();
        emailField.shouldBe(visible).setValue("test@mail.ru");
    }

    @Step("Получение кода")
    public void getCode() {
        getCodeButton.shouldBe(visible).click();
    }
}
