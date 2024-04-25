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
    final String description = homePage
        .getHeader()
        .navigateToLoginPage()
        .loginSuccessfully()
        .getHeader()
        .searchItem(ITEM_NAME)
        .getProductDescription();

    assertThat(description).isNotNull().contains(ITEM_DESCRIPTION);
  }

  @Test
  public void shouldCheckout() {
    final String orderSuccessMessage = homePage
        .getHeader()
        .navigateToLoginPage()
        .loginSuccessfully()
        .getHeader()
        .searchItem(ITEM_NAME)
        .addToCart()
        .checkout()
        .confirmCheckout()
        .getConfirmMessage();

    assertThat(orderSuccessMessage).isNotNull().contains(ORDER_SUCCESS_PREFIX).contains(ORDER_SUCCESS_SUFFIX);
  }

  @Test
  public void shouldDeleteItemFromCart() {
    final String emptyCartMessage = homePage
        .getHeader()
        .navigateToLoginPage()
        .loginSuccessfully()
        .getHeader()
        .searchItem(ITEM_NAME)
        .addToCart()
        .removeItemFromCart()
        .getEmptyCartMessage();

    assertThat(emptyCartMessage).isNotNull().contains(EMPTY_CART_MESSAGE);
  }

}
