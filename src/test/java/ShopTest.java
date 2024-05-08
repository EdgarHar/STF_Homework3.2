import aua.testingfundamentals.pom.pages.CartPage;
import aua.testingfundamentals.pom.pages.Header;
import aua.testingfundamentals.pom.pages.HomePage;
import aua.testingfundamentals.pom.pages.ItemPage;
import aua.testingfundamentals.pom.pages.LoginPage;
import base.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ShopTest extends BaseTest {

  private static final String ITEM_NAME        = "Viva Glam Lipstick" + "\n";
  private static final String ITEM_DESCRIPTION = "It's a gaga-glamorous look at our abiding passion";
  private static final String ORDER_SUCCESS_PREFIX = "Your order #";
  private static final String ORDER_SUCCESS_SUFFIX = "has been created!";
  private static final String EMPTY_CART_MESSAGE = "Your shopping cart is empty!";

  @Test
  public void shouldSearchItem() {
    final Header headerPage = homePage.getHeader();
    final LoginPage loginPage = headerPage.navigateToLoginPage();
    final HomePage loggedInHomePage = loginPage.enterCredentials(LOGIN_USERNAME, LOGIN_PASSWORD).loginSuccessfully();
    final Header loggedInHeader = loggedInHomePage.getHeader();
    final ItemPage searchedHomePage = loggedInHeader.searchItem(ITEM_NAME);
    final String description = searchedHomePage.getProductDescription();

    assertThat(description).isNotNull().contains(ITEM_DESCRIPTION);
  }

  @Test
  public void shouldCheckout() {
    final Header headerPage = homePage.getHeader();
    final LoginPage loginPage = headerPage.navigateToLoginPage();
    final HomePage loggedInHomePage = loginPage.enterCredentials(LOGIN_USERNAME, LOGIN_PASSWORD).loginSuccessfully();
    final Header loggedInHeader = loggedInHomePage.getHeader();
    final ItemPage searchedItemPage = loggedInHeader.searchItem(ITEM_NAME);
    final CartPage cartPage = searchedItemPage.addToCart();
    final CartPage checkoutCart = cartPage.checkout();
    final CartPage.ConfirmPage confirmationPage = checkoutCart.confirmCheckout();
    final String orderSuccessMessage = confirmationPage.getConfirmMessage();

    assertThat(orderSuccessMessage).isNotNull().contains(ORDER_SUCCESS_PREFIX).contains(ORDER_SUCCESS_SUFFIX);
  }

  @Test
  public void shouldDeleteItemFromCart() {
    final Header headerPage = homePage.getHeader();
    final LoginPage loginPage = headerPage.navigateToLoginPage();
    final HomePage loggedInHomePage = loginPage.enterCredentials(LOGIN_USERNAME, LOGIN_PASSWORD).loginSuccessfully();
    final Header loggedInHeader = loggedInHomePage.getHeader();
    final ItemPage searchedItemPage = loggedInHeader.searchItem(ITEM_NAME);
    final CartPage cartPage = searchedItemPage.addToCart();
    final CartPage cartAfterRemoval = cartPage.removeItemFromCart();
    final String emptyCartMessage = cartAfterRemoval.getEmptyCartMessage();

    assertThat(emptyCartMessage).isNotNull().contains(EMPTY_CART_MESSAGE);
  }

}
