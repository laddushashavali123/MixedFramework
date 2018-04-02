package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    WebDriver driver;

    @FindBy(id = "flash")
    private WebElement flash;

    public String getLoginText() {
        return flash.getText().substring(0, flash.getText().length() - 2);
    }

    BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }
}
