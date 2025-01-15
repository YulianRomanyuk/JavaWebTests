package core.base;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public abstract class BasePage {

    //Примеры общих элементов, которые могут использоваться в разных страницах
    protected SelenideElement headerLogo = $("[tsid='toolbar_logo']");
    protected SelenideElement searchField = $("[name='st.query']");
    protected SelenideElement vkServices = $("[data-l='t,vk_ecosystem']");
    protected SelenideElement acceptCookiesButton = $(".cb_accept");
    protected SelenideElement acceptPrivacyButton = $(".cmptxt_bth_yes");

    @Step("Выполняем поиск по сайту с запросом {query}")
    public void search(String query) {
        searchField.shouldBe(visible).setValue(query).pressEnter();
    }

    @Step("Заполняем поиск по сайту с запросом {query}")
    public void indicateSearch(String query) { searchField.shouldBe(visible).setValue(query); }

    @Step("Открываем VK Services")
    public void openVkServices() {
        vkServices.shouldBe(visible).click();
    }

    @Step("Кликаем на логотип ОК")
    public void clickLogo() {
        headerLogo.shouldBe(visible).click();
    }

    @Step("Принимаем куки")
    public void acceptCookies() {
        acceptCookiesButton.shouldBe(visible).click();
    }

    @Step("Принимаем политику конфеденциальности")
    public void acceptPrivacy() {
        acceptPrivacyButton.shouldBe(visible).click();
    }

}
