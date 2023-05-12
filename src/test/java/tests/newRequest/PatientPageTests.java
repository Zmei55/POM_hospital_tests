package tests.newRequest;

import data.UserData;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DesktopPage;
import pages.LoginPage;
import pages.newRequest.PatientPage;
import pages.newRequest.RequestPage;
import tests.TestBase;

public class PatientPageTests extends TestBase {
    @BeforeMethod
    public void precondition() {
        new LoginPage(driver).login(UserData.USER_NAME, UserData.USER_PASSWORD);
        new DesktopPage(driver).selectNewRequest();
        new RequestPage(driver).findPatient();
    }

    @Test
    public void findAllPatientsPositiveTest() {
        new PatientPage(driver)
                .findPatient("", "", "")
                .assertPatient();
    }

    @Test
    public void findPatientByNamePositiveTest() {
        new PatientPage(driver)
                .findPatient("Sofia Wagner", "", "")
                .assertPatientByData("Sofia Wagner");
    }

    @Test
    public void findPatientByCardNumberPositiveTest() {
        new PatientPage(driver)
                .findPatient("", "", "446640502")
                .assertPatientByData("446640502");
    }

    @Test
    public void secondaryPatientInfoPositiveTest() {
        new PatientPage(driver)
                .findPatient("Sofia Wagner", "", "")
                .selectPatient()
                .morePatInfo()
                .assertPatSecondaryInfo();
    }

    @Test
    public void deletePatientPositiveTest() {
        new PatientPage(driver)
                .findPatient("Sofia Wagner", "", "")
                .selectPatient()
                .deletePatient()
                .assertOfRemovalOfPatient();
    }

    @Test
    public void findAllPatientsByNameNegativeTest() {
        new PatientPage(driver)
                .findPatient("Garry Osborn", "", "")
                .findPatientError();
    }

    @Test
    public void findAllPatientsByCardNumberNegativeTest() {
        new PatientPage(driver)
                .findPatient("", "", "446640802")
                .findPatientError();
    }
}
