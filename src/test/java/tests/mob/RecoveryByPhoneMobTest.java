package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.AccountRecoveryMobPage;
import core.pages.mob.FirstLoginMobPage;
import core.pages.mob.RecoveryByPhoneMobPage;
import core.pages.mob.StartMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RecoveryByPhoneMobTest extends MobileBaseTest {
    public static StartMobPage startMobPage;
    public static FirstLoginMobPage firstLoginMobPage;
    public static AccountRecoveryMobPage accountRecoveryMobPage;
    public static RecoveryByPhoneMobPage recoveryByPhoneMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        startMobPage = new StartMobPage();
    }

    @Test
    public void RecoveryByPhoneMobTest() {
        //Переход к странице восстановления по Телефону
        startMobPage.goToLogin();
        firstLoginMobPage = new FirstLoginMobPage();
        firstLoginMobPage.goToRecovery();
        accountRecoveryMobPage = new AccountRecoveryMobPage();
        accountRecoveryMobPage.goToRecoveryByPhone();
        recoveryByPhoneMobPage = new RecoveryByPhoneMobPage();

        //Выбираем страну из списка по имени
        recoveryByPhoneMobPage.selectCountryNameFromList("Аргентина");

        //Проверяем наличие ошибки после нажатия кнопки Получить код
        recoveryByPhoneMobPage.getCode();
        assertTrue(recoveryByPhoneMobPage.isErrorNumberMessageVisible(), "Ошибка не отображена");
        String expectedErrorPhone = "Введен неверный номер телефона";
        String actualErrorPhone = recoveryByPhoneMobPage.getNumErrorMessageText();
        assertEquals(expectedErrorPhone, actualErrorPhone, "Текст ошибки не совпадает");
    }
}
