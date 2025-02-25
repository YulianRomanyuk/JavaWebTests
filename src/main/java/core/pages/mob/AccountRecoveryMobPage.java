package core.pages.mob;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseMobPage;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class AccountRecoveryMobPage extends BaseMobPage {
    private SelenideElement recoveryByPhone = $(By.xpath("//div[@class='content-card registration_step item __center-align'][1]"));
    private SelenideElement recoveryByEmail = $(By.xpath("//div[@class='content-card registration_step item __center-align'][2]"));
    private SelenideElement support = $("[class='registration_footer_link']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех эллементов страницы")
    private void verifyPageElements() {
        recoveryByPhone.shouldBe(visible);
        recoveryByEmail.shouldBe(visible);
        support.shouldBe(visible);
    }

    @Step("Переходим к восстановлению по телефону")
    public void goToRecoveryByPhone() {
        recoveryByPhone.shouldBe(visible).click();
    }

    @Step("Переходим к восстановлению по Email")
    public void goToRecoveryByEmail() {
        recoveryByEmail.shouldBe(visible).click();
    }

    @Step("Переходим в чат поддержки")
    public void goToSupport() {
        support.shouldBe(visible).click();
    }
}
