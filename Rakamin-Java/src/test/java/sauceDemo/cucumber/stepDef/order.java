package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class order {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("User already login")
    public void user_already_login() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

        driver.findElement(By.id("user-name")).sendKeys("standard_user");
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
        driver.findElement(By.id("login-button")).click();
    }

    @When("User add Sauce Lab backpack")
    public void user_add_sauce_lab_backpack() {
        driver.findElement(By.id("add-to-cart-sauce-labs-backpack")).click();
        String addCart = driver.findElement(By.xpath("//button[contains(text(), 'Remove')]")).getText();
        Assert.assertEquals(addCart, "Remove");
    }

    @And("User click shopping cart")
    public void user_click_shopping_cart() {
        driver.findElement(By.className("shopping_cart_link")).click();
        String cartPage = driver.findElement(By.xpath("//span[contains(text(), 'Your Cart')]")).getText();
        Assert.assertEquals(cartPage, "Your Cart");
    }

    @And("User click checkout button")
    public void user_click_checkout_button() {
        driver.findElement(By.id("checkout")).click();
        String coPage = driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Your Information')]")).getText();
        Assert.assertEquals(coPage, "Checkout: Your Information");
    }

    @And("User fill data id")
    public void user_fill_data_id() {
        driver.findElement(By.id("first-name")).sendKeys("Budi");
        driver.findElement(By.id("last-name")).sendKeys("Apel");
        driver.findElement(By.id("postal-code")).sendKeys("12345");
        driver.findElement(By.id("continue")).click();
    }

    @And("User click finish")
    public void user_click_finish() {
        String finPage = driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Overview')]")).getText();
        Assert.assertEquals(finPage, "Checkout: Overview");
        String item = driver.findElement(By.xpath("//div[contains(text(), 'Sauce Labs Backpack')]")).getText();
        Assert.assertEquals(item, "Sauce Labs Backpack");
        driver.findElement(By.id("finish")).click();
    }

    @Then("Complete status shown")
    public void complete_status_shown() {
        String comp = driver.findElement(By.xpath("//span[contains(text(), 'Checkout: Complete!')]")).getText();
        Assert.assertEquals(comp, "Checkout: Complete!");
        String tks = driver.findElement(By.xpath("//h2[contains(text(), 'Thank you for your order!')]")).getText();
        Assert.assertEquals(tks, "Thank you for your order!");
        driver.close();
    }

    @And("User left data id blank")
    public void userLeftDataIdBlank() {
        driver.findElement(By.id("first-name")).sendKeys("");
        driver.findElement(By.id("last-name")).sendKeys("");
        driver.findElement(By.id("postal-code")).sendKeys("");
        driver.findElement(By.id("continue")).click();
    }

    @Then("Error message shown")
    public void errorMessageShown() {
        String comp = driver.findElement(By.xpath("//h3[contains(text(), 'Error')]")).getText();
        Assert.assertEquals(comp, "Error: First Name is required");
        driver.close();
    }
}
