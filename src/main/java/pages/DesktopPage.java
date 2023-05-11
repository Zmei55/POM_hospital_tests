package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.newRequest.RequestPage;

public class DesktopPage extends BasePage{
    public DesktopPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[contains(.,'Abmelden')]")
    WebElement logoutBtn;

    public DesktopPage assertAccount() {
        Assert.assertTrue(logoutBtn.isDisplayed());
        return this;
    }

    @FindBy(xpath = "//button[contains(.,'Erstellen Sie eine Bestellung')]")
    WebElement newRequestBtn;

    public RequestPage selectNewRequest() {
        click(newRequestBtn);
        return new RequestPage(driver);
    }

    @FindBy(xpath = "//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]")
    WebElement error;

    public DesktopPage loginError() {
        Assert.assertTrue(error.isDisplayed());
        return this;
    }

    @FindBy(id = "errorLoginBtn")
    WebElement okBtn;

    public DesktopPage clickOkBtn() {
        click(okBtn);
        return this;
    }
}
