package aua.testingfundamentals.pom.pages;

import aua.testingfundamentals.pom.base.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {

  public HomePage(final WebDriver driver, final WebDriverWait wait) {
    super(driver, wait);
  }

  public Header getHeader() {
    return new Header(driver, webDriverWait);
  }

}
