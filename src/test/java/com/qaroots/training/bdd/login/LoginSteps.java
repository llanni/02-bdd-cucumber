package com.qaroots.training.bdd.login;

import io.cucumber.java.en.*;
import org.junit.jupiter.api.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginSteps {

    private String baseUrl = "https://www.saucedemo.com/";

    private WebDriver driver;
    private WebDriverWait wait;

    @Given("I am on the SauceDemo login page")
    public void i_am_on_login_page() {
        ChromeOptions options = new ChromeOptions();
        if (Boolean.parseBoolean(System.getProperty("headless", "true"))) {
            options.addArguments("--headless=new");
        }
        options.addArguments("--window-size=1366,768");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.get(baseUrl);
    }

    @When("I log in with username {string} and password {string}")
    public void i_log_in(String user, String pass) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("user-name"))).sendKeys(user);
        driver.findElement(By.id("password")).sendKeys(pass);
        driver.findElement(By.id("login-button")).click();
    }

    @Then("I should land on the inventory page")
    public void i_should_land_on_inventory() {
        wait.until(ExpectedConditions.urlContains("inventory"));
        Assertions.assertTrue(driver.getCurrentUrl().contains("inventory"));
        driver.quit();
    }

    @Then("I should see an error message {string} in the login page")
    public void shouldSeeErrorAtLoginPage(String errorMessage) {
        WebElement error = driver.findElement(By.cssSelector("h3[data-test='error']"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("h3[data-test='error']")));
        Assertions.assertTrue(error.getText().contains(errorMessage));
        Assertions.assertTrue(driver.getCurrentUrl().equals(baseUrl));
        driver.quit();
    }
}
