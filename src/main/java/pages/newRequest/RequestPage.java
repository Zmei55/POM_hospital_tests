package pages.newRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.BasePage;

public class RequestPage extends BasePage {
    public RequestPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "modalFindPatBtn")
    WebElement findPatientBtn;

    public PatientPage findPatient() {
        click(findPatientBtn);
        return new PatientPage(driver);
    }
}
