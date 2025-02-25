package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class BaseMobPage {

    //Примеры общих элементов, которые могут использоваться в разных страницах
    protected SelenideElement headerLogo = $("[class = 'portal-logo  highlight-block-color']");
    protected SelenideElement headerSearchButton = $("[class = 'portal-search base-button __plain __modern __without-text __has-icon ic24 __show']");
    protected SelenideElement headerMenuButton = $("[class = 'sidebar-menu-icon toolbar_actions-i_inner']");

    @Step("Открываем меню")
    public void menuOpen() {
        headerMenuButton.shouldBe(visible).click();
    }

    @Step("Открываем поиск")
    public void searchOpen() {
        headerSearchButton.shouldBe(visible).click();
    }

    @Step("Нажимаем на логотип ОК")
    public void goLogo() {
        headerLogo.shouldBe(visible).click();
    }
}
