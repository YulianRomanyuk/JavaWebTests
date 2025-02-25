package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.LoginPage;
import core.pages.web.RecoveryByEmailPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class AnonymRecoverByEmailTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static RecoveryByEmailPage recoveryByEmailPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void anonymRecoveryTest() {
        //Попытка входа с некорректными данными
        loginPage.login("incorrectUser", "incorrectPassword");

        for (int i = 0; i < 2; i++) {
            loginPage.loginWithPassword("1");
        }

        loginPage.goToRecovery();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryByEmail();
        recoveryByEmailPage = new RecoveryByEmailPage();
    }
}
