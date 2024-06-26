package aua.testingfundamentals.pom.pages;

import aua.testingfundamentals.pom.base.BasePage;
import aua.testingfundamentals.pom.locators.ItemPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ItemPage extends BasePage {

  public ItemPage(final WebDriver driver, final WebDriverWait wait) {
    super(driver, wait);
  }

  public String getProductDescription() {
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ItemPageLocators.ITEM_DESCRIPTION_LOCATOR));
    return driver.findElement(ItemPageLocators.ITEM_DESCRIPTION_LOCATOR).getText();
  }

  public CartPage addToCart() {
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(ItemPageLocators.ADD_TO_CART_LOCATOR));

    driver.findElement(ItemPageLocators.ADD_TO_CART_LOCATOR).click();

    return new CartPage(driver, webDriverWait);
  }

}
