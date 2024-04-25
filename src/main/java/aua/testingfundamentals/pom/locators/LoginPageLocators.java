package aua.testingfundamentals.pom.locators;

import org.openqa.selenium.By;

public class LoginPageLocators {

  public static final By USERNAME_LOCATOR = By.name("loginname");
  public static final By PASSWORD_LOCATOR = By.name("password");
  public static final By SUBMIT_LOCATOR = By.xpath("//button[@title='Login']");
  public static final By ERROR_LOCATOR = By.cssSelector(".alert.alert-error.alert-danger");
  public static final By SUCCESSFUL_LOGOFF_LOCATOR = By.cssSelector(".contentpanel");
}
