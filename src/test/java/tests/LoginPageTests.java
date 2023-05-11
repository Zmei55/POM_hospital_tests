package tests;

import data.UserData;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginPageTests extends TestBase{
    @Test
    public void loginPositiveTest() {
        new LoginPage(driver)
                .login(UserData.USER_NAME, UserData.USER_PASSWORD)
                .assertAccount();
    }

    @Test
    public void loginByUsernameNegativeTest() {
        new LoginPage(driver)
                .login("asd", UserData.USER_PASSWORD)
                .loginError()
                .clickOkBtn();
    }

    @Test
    public void loginByPasswordNegativeTest() {
        new LoginPage(driver)
                .login(UserData.USER_NAME, "asdasd")
                .loginError()
                .clickOkBtn();
    }
}
