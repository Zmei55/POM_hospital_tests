package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.newRequest.PatientPage;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Login']")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(id = "nextLoginBtn")
    WebElement nextBtn;

    @FindBy(xpath = "//input[@value='chirurgisch']")
    WebElement station;

    @FindBy(id = "loginBtn")
    WebElement loginBtn;

    public DesktopPage login(String name, String pwd) {
        type(userName, name);
        type(password, pwd);
        click(nextBtn);
        click(station);
        click(loginBtn);
        return new DesktopPage(driver);
    }

    @FindBy(xpath = "//p[contains(.,'Benutzerdaten wurden falsch eingegeben')]")
    WebElement error;

    public LoginPage loginError() {
        Assert.assertTrue(error.isDisplayed());
        return this;
    }

    @FindBy(id = "errorLoginBtn")
    WebElement okBtn;

    public LoginPage clickOkBtn() {
        click(okBtn);
        return this;
    }
}
