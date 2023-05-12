package pages.newRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.BasePage;

public class PatientPage extends BasePage {
    public PatientPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Name']")
    WebElement patientName;

    @FindBy(xpath = "//input[@placeholder='Date of Birth']")
    WebElement patientBirthDay;

    @FindBy(xpath = "//input[@placeholder='Card number']")
    WebElement patientCardNumber;

    @FindBy(id = "findSearchPatBtn")
    WebElement findBtn;

    public PatientPage findPatient(String name, String birthDay, String cardNumber) {
        type(patientName, name);
        type(patientBirthDay, birthDay);
        type(patientCardNumber, cardNumber);
        click(findBtn);
        return this;
    }

    @FindBy(className = "css-2efd0n")
    WebElement patient;

    public PatientPage assertPatient() {
        Assert.assertTrue(patient.isDisplayed());
        return this;
    }

    public PatientPage assertPatientByData(String patientName) {
        Assert.assertTrue(patient.getText().contains(patientName));
        return this;
    }

    @FindBy(id = "selectPatLink")
    WebElement selectPatientBtn;

    public PatientPage selectPatient() {
        click(selectPatientBtn);
        return this;
    }

    @FindBy(id = "morePatInfoBtn")
    WebElement morePatInfoBtn;

    public PatientPage morePatInfo() {
        click(morePatInfoBtn);
        return this;
    }

    @FindBy(xpath = "//h4[contains(.,'Wohnort')]")
    WebElement wohnort;

    public PatientPage assertPatSecondaryInfo() {
        Assert.assertTrue(wohnort.isDisplayed());
        return this;
    }

    @FindBy(id = "clearPatInfo")
    WebElement clearPatInfoBtn;

    public PatientPage deletePatient() {
        click(clearPatInfoBtn);
        return this;
    }

    @FindBy(id = "modalFindPatBtn")
    WebElement reqPatBtn;

    public RequestPage assertOfRemovalOfPatient() {
        Assert.assertTrue(reqPatBtn.isDisplayed());
        return new RequestPage(driver);
    }

    @FindBy(xpath = "//p[contains(.,'Patient mit solchen Daten wurde nicht gefunden')]")
    WebElement error;

    public PatientPage findPatientError() {
        Assert.assertTrue(error.isDisplayed());
        return this;
    }
}
