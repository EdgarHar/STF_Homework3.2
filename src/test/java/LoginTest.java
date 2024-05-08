import aua.testingfundamentals.pom.pages.Header;
import aua.testingfundamentals.pom.pages.HomePage;
import aua.testingfundamentals.pom.pages.LoginPage;
import base.BaseTest;
import org.testng.annotations.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LoginTest extends BaseTest {

  private static final String LOGIN_SUCCESS_TEXT         = "Welcome back Vaspur";
  private static final String LOGIN_FAILED_ERROR_MESSAGE = "Error: Incorrect login or password provided.";

  @Test
  public void shouldLoginSuccessfully() {
    final Header headerPage = homePage.getHeader();
    final LoginPage loginPage = headerPage.navigateToLoginPage();
    final HomePage homePage = loginPage.enterCredentials(LOGIN_USERNAME, LOGIN_PASSWORD).loginSuccessfully();
    final Header finalHeaderPage = homePage.getHeader();
    final String customerText = finalHeaderPage.getCustomerText();

    assertThat(customerText)
        .isNotNull()
        .isEqualTo(LOGIN_SUCCESS_TEXT);
  }

  @Test
  public void shouldFailLogin() {
    final Header headerPage = homePage.getHeader();
    final LoginPage loginPage = headerPage.navigateToLoginPage();
    final LoginPage failedLoginPage = loginPage.enterCredentials(INCORRECT_LOGIN_USERNAME, INCORRECT_LOGIN_PASSWORD).loginFailed();
    final String errorMessageText = failedLoginPage.getErrorMessageText();

    assertThat(errorMessageText)
        .isNotNull()
        .contains(LOGIN_FAILED_ERROR_MESSAGE);
  }

}
