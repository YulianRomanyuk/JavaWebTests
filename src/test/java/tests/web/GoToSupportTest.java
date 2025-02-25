package tests.web;

import core.base.BaseTest;
import core.pages.web.AnonymRecoveryPage;
import core.pages.web.ChatConfirmPage;
import core.pages.web.ChatPage;
import core.pages.web.LoginPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class GoToSupportTest extends BaseTest {
    private static LoginPage loginPage;
    private static AnonymRecoveryPage anonymRecoveryPage;
    private static ChatPage chatPage;
    private static ChatConfirmPage chatConfirmPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        loginPage = new LoginPage();
    }

    @Test
    public void goToSupportTest() {
        loginPage.openForgotPassword();
        anonymRecoveryPage = new AnonymRecoveryPage();
        anonymRecoveryPage.goToRecoveryBySupport();
        chatPage = new ChatPage();
        chatPage.closeChat();
        chatConfirmPage = new ChatConfirmPage();
        chatConfirmPage.confirm();

    }
}
