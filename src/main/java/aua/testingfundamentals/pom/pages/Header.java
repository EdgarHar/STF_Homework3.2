package aua.testingfundamentals.pom.pages;

import aua.testingfundamentals.pom.base.BasePage;
import aua.testingfundamentals.pom.locators.HeaderLocators;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Header extends BasePage {

  public Header(final WebDriver driver, final WebDriverWait wait) {
    super(driver, wait);
  }

  public LoginPage navigateToLoginPage() {
    driver.findElement(HeaderLocators.LOGIN_BUTTON_LOCATOR).click();

    return new LoginPage(driver, webDriverWait);
  }

  public String getCustomerText() {
    return driver.findElement(HeaderLocators.CUSTOMER_TEXT_LOCATOR).getText();
  }

  public ItemPage searchItem(String itemName) {
    driver.findElement(HeaderLocators.SEARCH_LOCATOR).sendKeys(itemName);
    driver.findElement(HeaderLocators.SEARCH_LOCATOR).sendKeys(Keys.ENTER);

    return new ItemPage(driver, webDriverWait);
  }

}
