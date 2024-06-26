package base;

import aua.testingfundamentals.pom.base.BasePage;
import aua.testingfundamentals.pom.pages.HomePage;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Duration;

public abstract class BaseTest {

  protected static final String PATH = "src/main/resources/";
  protected static final String PNG_EXTENSION = ".png";
  protected static final String LOGIN_USERNAME = "VaspurVaspuryan";
  protected static final String LOGIN_PASSWORD = "123456789";
  protected static final String INCORRECT_LOGIN_USERNAME = "SomeIncorrectUser";
  protected static final String INCORRECT_LOGIN_PASSWORD = "SomeIncorrectPassword";
  protected static final String REMOTE_WEB_DRIVER_URL = "http://localhost:4444";

  protected WebDriver     driver;
  protected WebDriverWait webDriverWait;
  protected HomePage      homePage;

  @BeforeMethod
  public void beforeClass() throws MalformedURLException {
    FirefoxOptions options = new FirefoxOptions();
    driver = new RemoteWebDriver(new URL(REMOTE_WEB_DRIVER_URL), options);
    driver.manage().window().maximize();
    webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(3));
    homePage = new HomePage(driver, webDriverWait);
    driver.get(BasePage.BASE_URL);
  }

  @AfterMethod
  public void screenshotAndTerminate(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
      final var screenshotMaker = (TakesScreenshot) driver;
      final Path screenShotBytes = screenshotMaker.getScreenshotAs(OutputType.FILE).getAbsoluteFile().toPath();
      final Path destination = Paths.get(PATH + result.getStartMillis() + "-" + "screenshot" + PNG_EXTENSION);
      try {
        Files.move(screenShotBytes, destination);
      } catch (IOException e) {
        throw new RuntimeException(e);
      }
    }
    driver.quit();
  }

}
