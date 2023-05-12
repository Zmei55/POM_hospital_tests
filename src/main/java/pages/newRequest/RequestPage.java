package pages.newRequest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
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

    @FindBy(className = "css-1edcxm")
    WebElement savedServicesList;

    public RequestPage assertAddedServicesList() {
        Assert.assertTrue(savedServicesList.isDisplayed());
        return new RequestPage(driver);
    }

    public RequestPage absenceAddedServicesList() {
        Assert.assertFalse(savedServicesList.isDisplayed());
        return new RequestPage(driver);
    }
}
