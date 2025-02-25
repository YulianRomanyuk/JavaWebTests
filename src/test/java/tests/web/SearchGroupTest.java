package tests.web;


import core.base.BaseTest;
import core.pages.web.GroupPage;
import core.pages.web.LoginPage;
import io.qameta.allure.Step;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
        loginPage.resultSearch();
        groupPage = new GroupPage();
    }
}
