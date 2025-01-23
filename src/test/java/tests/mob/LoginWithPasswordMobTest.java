package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.FirstLoginMobPage;
import core.pages.mob.StartMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithPasswordMobTest extends MobileBaseTest {
    private static FirstLoginMobPage firstLoginMobPage;
    private static StartMobPage startMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        startMobPage = new StartMobPage();
    }

    @Test
    public void LoginWithPasswordMobTest() {
        //Переходим к странице авторизации"
        startMobPage.goToLogin();
        firstLoginMobPage = new FirstLoginMobPage();
        //Пробуем авторизоваться только с {password}
        firstLoginMobPage.loginWithPassword("password");
        //Проверяем наличие сообщения об ошибке и его соответствие ожидаемому
        assertTrue(firstLoginMobPage.isLogErrorMessageVisible(), "Сообщение не отображается");
        String expectedMessage = "Укажите логин";
        String actualMessage = firstLoginMobPage.getLogErrorMessageText();
        assertEquals(expectedMessage, actualMessage, "Текст сообщения об ошибке не совпадает");
    }
}
