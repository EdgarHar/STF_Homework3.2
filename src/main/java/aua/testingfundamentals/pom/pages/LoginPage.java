package aua.testingfundamentals.pom.pages;

import aua.testingfundamentals.pom.base.BasePage;
import aua.testingfundamentals.pom.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

  public LoginPage(final WebDriver driver, final WebDriverWait wait) {
    super(driver, wait);
  }

  public HomePage loginSuccessfully() {
    driver.findElement(LoginPageLocators.SUBMIT_LOCATOR).click();

    return new HomePage(driver, webDriverWait);
  }

  public LoginPage loginFailed() {
    driver.findElement(LoginPageLocators.SUBMIT_LOCATOR).click();

    return this;
  }

  public LoginPage enterCredentials(final String username, final String password) {
    enterUsername(username);
    enterPassword(password);

    return this;
  }

  public String getErrorMessageText() {
    return driver.findElement(LoginPageLocators.ERROR_LOCATOR).getText();
  }

  private void enterUsername(final String username) {
    driver.findElement(LoginPageLocators.USERNAME_LOCATOR).sendKeys(username);
  }

  private void enterPassword(final String password) {
    driver.findElement(LoginPageLocators.PASSWORD_LOCATOR).sendKeys(password);
  }

}
