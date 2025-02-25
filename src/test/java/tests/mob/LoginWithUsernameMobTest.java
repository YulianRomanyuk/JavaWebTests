package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.FirstLoginMobPage;
import core.pages.mob.StartMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginWithUsernameMobTest extends MobileBaseTest {
    private static StartMobPage startMobPage;
    private static FirstLoginMobPage firstLoginMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        startMobPage = new StartMobPage();
    }

    @Test
    public void LoginWithUsernameMobTest() {
        //Переходим к странице авторизации"
        startMobPage.goToLogin();
        firstLoginMobPage = new FirstLoginMobPage();
        firstLoginMobPage.loginWithUsername("username");
        //Проверяем наличие сообщения об ошибке и его соответствие ожидаемому
        assertTrue(firstLoginMobPage.isPassErrorMessageVisible(), "Сообщение не отображается");
        String expectedMessage = "Укажите пароль";
        String actualMessage = firstLoginMobPage.getPassErrorMessageText();
        assertEquals(expectedMessage, actualMessage, "Текст сообщения об ошибке не совпадает");
    }
}
