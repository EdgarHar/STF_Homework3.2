import aua.testingfundamentals.pom.pages.HomePage;
import base.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends BaseTest {

  private static final String LOGIN_SUCCESS_TEXT         = "Welcome back Vaspur";
  private static final String LOGIN_FAILED_ERROR_MESSAGE = "Error: Incorrect login or password provided.";

  @Test
  public void shouldLoginSuccessfully() {
    final HomePage homepage = homePage.getHeader().navigateToLoginPage().loginSuccessfully();

    assertThat(homepage.getHeader().getCustomerText())
        .isNotNull()
        .isEqualTo(LOGIN_SUCCESS_TEXT);
  }

  @Test
  public void shouldFailLogin() {
    final String errorMessageText = homePage.getHeader().navigateToLoginPage().loginFailed().getErrorMessageText();

    assertThat(errorMessageText)
        .isNotNull()
        .contains(LOGIN_FAILED_ERROR_MESSAGE);
  }

}
