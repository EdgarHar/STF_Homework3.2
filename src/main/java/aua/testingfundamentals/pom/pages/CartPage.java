package aua.testingfundamentals.pom.pages;

import aua.testingfundamentals.pom.base.BasePage;
import aua.testingfundamentals.pom.locators.CartPageLocators;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage extends BasePage {

  public CartPage(final WebDriver driver, final WebDriverWait wait) {
    super(driver, wait);
  }

  public CartPage checkout() {
    driver.findElement(CartPageLocators.CART_CHECKOUT_LOCATOR).click();

    return this;
  }

  public CartPage removeItemFromCart() {
    driver.findElement(CartPageLocators.REMOVE_ITEM_FROM_CART_LOCATOR).click();

    return this;
  }

  public String getEmptyCartMessage() {
    webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.GET_EMPTY_CART_LOCATOR));

    return driver.findElement(CartPageLocators.GET_EMPTY_CART_LOCATOR).getText();
  }

  public ConfirmPage confirmCheckout() {
    driver.findElement(CartPageLocators.CONFIRM_CHECKOUT_LOCATOR).click();

    return new ConfirmPage(driver, webDriverWait);
  }

  public static class ConfirmPage extends BasePage {

    public ConfirmPage(final WebDriver driver, final WebDriverWait wait) {
      super(driver, wait);
    }

    public String getConfirmMessage() {
      webDriverWait.until(ExpectedConditions.visibilityOfElementLocated(CartPageLocators.ORDER_CONFIRMED_TEXT_LOCATOR));

      return driver.findElement(CartPageLocators.ORDER_CONFIRMED_TEXT_LOCATOR).getText();
    }

  }

}
