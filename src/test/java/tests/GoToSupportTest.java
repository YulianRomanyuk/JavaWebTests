package tests;

import core.base.BaseTest;
import core.pages.AnonymRecoveryPage;
import core.pages.ChatConfirmPage;
import core.pages.ChatPage;
import core.pages.LoginPage;
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
