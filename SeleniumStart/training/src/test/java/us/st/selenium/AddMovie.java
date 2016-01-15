package us.st.selenium;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.testng.*;
import org.testng.annotations.*;
import static org.junit.Assert.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class AddMovie extends us.st.selenium.pages.TestBase {
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Test
  public void testAddMovie() throws Exception {
    driver.findElement(By.cssSelector("img[alt=\"Add movie\"]")).click();
    driver.findElement(By.id("imdbsearch")).clear();
    driver.findElement(By.id("imdbsearch")).sendKeys("New_movie");
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys("Anakonda");
    driver.findElement(By.name("name")).clear();
    driver.findElement(By.name("name")).sendKeys("Anakonda");
    driver.findElement(By.name("imdbid")).clear();
    driver.findElement(By.name("imdbid")).sendKeys("1234");
    driver.findElement(By.name("aka")).clear();
    driver.findElement(By.name("aka")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("year")).clear();
    driver.findElement(By.name("year")).sendKeys("2012");
    driver.findElement(By.name("duration")).clear();
    driver.findElement(By.name("duration")).sendKeys("20");
    driver.findElement(By.name("rating")).clear();
    driver.findElement(By.name("rating")).sendKeys("3.5");
    driver.findElement(By.name("notes")).clear();
    driver.findElement(By.name("notes")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("taglines")).clear();
    driver.findElement(By.name("taglines")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("plotoutline")).clear();
    driver.findElement(By.name("plotoutline")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("plots")).clear();
    driver.findElement(By.name("plots")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.id("text_languages_0")).clear();
    driver.findElement(By.id("text_languages_0")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("subtitles")).clear();
    driver.findElement(By.name("subtitles")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("audio")).clear();
    driver.findElement(By.name("audio")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("video")).clear();
    driver.findElement(By.name("video")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("country")).clear();
    driver.findElement(By.name("country")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("genres")).clear();
    driver.findElement(By.name("genres")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("director")).clear();
    driver.findElement(By.name("director")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("writer")).clear();
    driver.findElement(By.name("writer")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("producer")).clear();
    driver.findElement(By.name("producer")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("music")).clear();
    driver.findElement(By.name("music")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.name("cast")).clear();
    driver.findElement(By.name("cast")).sendKeys("Read the INSTALLATION/UPGRADE information above to read the explanation how\n    to install and which variables can be adjusted. When you want to adjust the\n    configuration, open config/config.php and adjust the variables. The default\n    configuration file is located at confg/config.default.php.\n    By default, guest users can view your move collection, but are not allowed\n    to change the movie collection. If you don't want guest users to view your\n    collection, set the 'guestview' variable to false in config/config.php after\n    installation or upgrade.");
    driver.findElement(By.id("submit")).click();
	Thread.sleep(4000);
    driver.findElement(By.cssSelector("h1")).click();
	Thread.sleep(4000);
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.cssSelector("div.nocover"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
