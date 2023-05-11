package tests.newRequest;

import data.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DesktopPage;
import pages.LoginPage;
import pages.newRequest.PatientPage;
import tests.TestBase;

public class RequestPageTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
        new DesktopPage(driver).selectNewRequest();
    }


}
