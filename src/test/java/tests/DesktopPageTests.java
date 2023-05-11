package tests;

import data.UserData;
import org.testng.annotations.BeforeMethod;
import pages.DesktopPage;
import pages.LoginPage;

public class DesktopPageTests extends TestBase{
    @BeforeMethod
    public void precondition() {
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
        new DesktopPage(driver).assertAccount();
    }
}
