package tests;

import com.codeborne.selenide.SelenideElement;
import core.base.BaseTest;
import core.pages.GroupPage;
import core.pages.LoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SearchGroupTest extends BaseTest {
    private static LoginPage loginPage;
    private static GroupPage groupPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    @Step("Вводим параметры поиска")
    public void searchGroupTest() {
        loginPage.indicateSearch("Тестировщик");
        SelenideElement resultSearch = $(By.xpath("(//a[@class='suggest-item__zd7xg'][contains(text(),'Тестировщик')])[4]"));
        resultSearch.click();
        groupPage = new GroupPage();
    }
}
