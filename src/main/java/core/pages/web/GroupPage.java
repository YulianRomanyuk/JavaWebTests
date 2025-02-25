package core.pages.web;

import com.codeborne.selenide.SelenideElement;
import core.base.BasePage;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class GroupPage extends BasePage {
    private SelenideElement groupSearchResult = $("[id='userGroupsSearchResultList']");
    private SelenideElement searchParams = $("[value='Тестировщик']");

    {
        verifyPageElements();
    }

    @Step("Проверяем видимость всех эллементов страницы")
    private void verifyPageElements() {
        groupSearchResult.shouldBe(visible);
        searchParams.shouldBe(visible);
    }

}
