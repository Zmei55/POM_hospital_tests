package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@placeholder='Login']")
    WebElement userName;

    @FindBy(xpath = "//input[@placeholder='Password']")
    WebElement password;

    @FindBy(xpath = "//button[contains(.,'Weiter')]")
    WebElement nextBtn;

    @FindBy(xpath = "//input[@value='chirurgisch']")
    WebElement station;

    @FindBy(xpath = "//button[contains(.,'Log In')]")
    WebElement loginBtn;

    public DesktopPage login(String name, String pwd) {
        type(userName, name);
        type(password, pwd);
        click(nextBtn);
        click(station);
        click(loginBtn);
        return new DesktopPage(driver);
    }
}
