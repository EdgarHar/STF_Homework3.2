package aua.testingfundamentals.pom.locators;

import org.openqa.selenium.By;

public class HeaderLocators {

  public static final By LOGIN_BUTTON_LOCATOR  = By.xpath("//a[text()='Login or register']");
  public static final By CUSTOMER_TEXT_LOCATOR = By.id("customernav");
  public static final By LOGOUT_LOCATOR = By.xpath(".//*[@id='customer_menu_top']/li/ul/li[10]/a");
  public static final By SEARCH_LOCATOR = By.name("filter_keyword");
}
