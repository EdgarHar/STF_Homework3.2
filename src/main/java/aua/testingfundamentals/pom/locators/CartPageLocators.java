package aua.testingfundamentals.pom.locators;

import org.openqa.selenium.By;

public class CartPageLocators {

  public static final By CART_CHECKOUT_LOCATOR    = By.id("cart_checkout1");
  public static final By CONFIRM_CHECKOUT_LOCATOR = By.id("checkout_btn");
  public static final By ORDER_CONFIRMED_TEXT_LOCATOR = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div/section" +
      "/p[2]");
  public static final By REMOVE_ITEM_FROM_CART_LOCATOR = By.cssSelector(".fa.fa-trash-o.fa-fw");
  public static final By GET_EMPTY_CART_LOCATOR = By.xpath("//*[@id=\"maincontainer\"]/div/div/div/div");

}
