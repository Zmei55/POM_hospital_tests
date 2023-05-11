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

    @FindBy(xpath = "(//div[@class='css-rpav3i'])[0]")
    WebElement selectPatientBtn;

    public PatientPage selectPatient() {
        click(selectPatientBtn);
        return this;
    }

    @FindBy(xpath = "//p[contains(.,'Patient mit solchen Daten wurde nicht gefunden')]")
    WebElement error;

    public PatientPage findPatientError() {
        Assert.assertTrue(error.isDisplayed());
        return this;
    }
}
