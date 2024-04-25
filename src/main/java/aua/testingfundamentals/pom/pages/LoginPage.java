package aua.testingfundamentals.pom.pages;

import aua.testingfundamentals.pom.base.BasePage;
import aua.testingfundamentals.pom.locators.LoginPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

  private static final String LOGIN_USERNAME           = "VaspurVaspuryan";
  private static final String LOGIN_PASSWORD           = "123456789";
  private static final String INCORRECT_LOGIN_USERNAME = "SomeIncorrectUser";
  private static final String INCORRECT_LOGIN_PASSWORD = "SomeIncorrectPassword";

  public LoginPage(final WebDriver driver, final WebDriverWait wait) {
    super(driver, wait);
  }

  public HomePage loginSuccessfully() {
    enterUsername(LOGIN_USERNAME);
    enterPassword(LOGIN_PASSWORD);
    driver.findElement(LoginPageLocators.SUBMIT_LOCATOR).click();

    return new HomePage(driver, webDriverWait);
  }

  public LoginPage loginFailed() {
    enterUsername(INCORRECT_LOGIN_USERNAME);
    enterPassword(INCORRECT_LOGIN_PASSWORD);
    driver.findElement(LoginPageLocators.SUBMIT_LOCATOR).click();

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
