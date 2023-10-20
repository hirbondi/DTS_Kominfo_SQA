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
public class login {
    WebDriver driver;
    String baseUrl = "https://www.saucedemo.com/";
    @Given("Login page Saucedemo")
    public  void login_page_saucedemo() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        driver.get(baseUrl);

        //Assertion
        String loginPageAssert = driver.findElement(By.xpath("//div[contains(text(), 'Swag Labs')]")).getText();
        Assert.assertEquals(loginPageAssert, "Swag Labs");

    }

    @When("Input username")
    public void  input_username(){
        driver.findElement(By.id("user-name")).sendKeys("standard_user");
    }

    @And("Input password")
    public void  input_password(){
        driver.findElement(By.id("password")).sendKeys("secret_sauce");
    }

    @Then("User get error message")
    public void user_get_error_message() {
        String errPageAssert = driver.findElement(By.xpath("//h3[contains(text(), 'Username and password do not match')]")).getText();
        Assert.assertEquals(errPageAssert, "Epic sadface: Username and password do not match any user in this service");
        driver.close();
    }

    @And("Click login button")
    public void  click_login_button(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("User on dashboard page")
    public void  user_on_dashboard(){
        String homePageAssert = driver.findElement(By.xpath("//span[contains(text(), 'Products')]")).getText();
        Assert.assertEquals(homePageAssert, "Products");
        driver.close();
    }

    @And("Input wrong password")
    public void input_wrong_Password() {
        driver.findElement(By.id("password")).sendKeys("secret_sace");
    }
}
