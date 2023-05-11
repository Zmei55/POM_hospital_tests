package tests;

import data.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends TestBase{
    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .assertAccount("Abmelden");
    }
}
