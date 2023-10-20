package sauceDemo.cucumber.stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class about {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";

    @Given("Users already login")
    public void users_already_login() {
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

    @When("User click burger menu")
    public void user_click_burger_menu(){
        driver.findElement(By.id("react-burger-menu-btn")).click();
    }
    @And("User click About")
    public void user_click_about(){
        driver.findElement(By.id("about_sidebar_link")).click();
    }
    @Then("User on About page")
    public void user_on_about_page(){
        String aboutPageAssert = driver.findElement(By.xpath("//button[contains(text(), 'Learn more')]")).getText();
        Assert.assertEquals(aboutPageAssert, "Learn more");
        driver.close();
    }
}
