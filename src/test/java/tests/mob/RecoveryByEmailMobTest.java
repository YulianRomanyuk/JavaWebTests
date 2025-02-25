package tests.mob;

import core.base.MobileBaseTest;
import core.pages.mob.AccountRecoveryMobPage;
import core.pages.mob.FirstLoginMobPage;
import core.pages.mob.RecoveryByEmailMobPage;
import core.pages.mob.StartMobPage;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selenide.open;

public class RecoveryByEmailMobTest extends MobileBaseTest {

    public static StartMobPage startMobPage;
    public static FirstLoginMobPage firstLoginMobPage;
    public static AccountRecoveryMobPage accountRecoveryMobPage;
    public static RecoveryByEmailMobPage recoveryByEmailMobPage;

    @BeforeEach
    public void prepare() {
        open(baseUrl);
        startMobPage = new StartMobPage();
    }

    @Test
    public void RecoveryByEmailMobTest() {
        startMobPage.goToLogin();
        firstLoginMobPage = new FirstLoginMobPage();
        firstLoginMobPage.goToRecovery();
        accountRecoveryMobPage = new AccountRecoveryMobPage();
        accountRecoveryMobPage.goToRecoveryByEmail();
        recoveryByEmailMobPage = new RecoveryByEmailMobPage();
        recoveryByEmailMobPage.setEmail();
    }
}
