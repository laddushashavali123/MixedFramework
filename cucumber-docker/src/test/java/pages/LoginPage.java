package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage {

    @FindBy(id = "username")
    private WebElement userName;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(className = "fa-sign-in")
    private WebElement loginButton;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    private void setUserName(String userNameInput) {
        this.userName.sendKeys(userNameInput);
    }


    private void setPassword(String passwordInput) {
        this.password.sendKeys(passwordInput);
    }


    private void clickLogin() {
        this.loginButton.click();
    }

    /**
     * Login method for use by test fixtures
     *
     * @param userNameInput
     * @param passwordInput
     * @passwordInput
     */

    public void login(String userNameInput, String passwordInput) {
        setUserName(userNameInput);
        setPassword(passwordInput);
        clickLogin();
    }

    public void navigateTo() {
        this.driver.get("http://the-internet.herokuapp.com/login");
    }
}
