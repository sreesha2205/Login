package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.CommonFunctions;
import utils.InvoiceConstants;

public class Login extends CommonFunctions {

    @Given("^I'm On Invoice Manager Login Page$")
    public void i_m_On_Invoice_Manager_Login_Page()  {
        driver.get(InvoiceConstants.APPLICATION_URL);
    }

    @Given("^I enter Username as \"(.*?)\"$")
    public void i_enter_Username_as(String userName)  {
        driver.findElement(By.id("inputEmail")).sendKeys(userName);
    }

    @Given("^I enter Password as \"(.*?)\"$")
    public void i_enter_Password_as(String password)  {
        driver.findElement(By.id("inputPassword")).sendKeys(password);
    }

    @When("^I click on Login$")
    public void i_click_on_Login()  {
        driver.findElement(By.xpath("//button[contains(text(),'Login')]")).click();
    }

    @Then("^I redirected to Invoice Manager Home Page$")
    public void i_redirected_to_Invoice_Manager_Home_Page()  {
        WebElement loginSuccessfulElement = driver.findElement(By.xpath("//p[contains(text(),'Logged In Successfully')]"));
        Assert.assertTrue(loginSuccessfulElement.isDisplayed());
    }

    @Given("^I enter Invalid Username as \"(.*?)\"$")
    public void i_enter_Invalid_Username_as(String userName)  {
        driver.findElement(By.xpath("//input[@id='inputEmail']")).sendKeys(userName);

    }

    @Then("^I should get Unable to Login message \"(.*?)\"$")
    public void i_should_get_Unable_to_Login_message(String acctualResult)  {
        WebElement expectedResult = driver.findElement(By.xpath("//p[contains(text(),'Logged In Successfully')]"));
        Assert.assertEquals(expectedResult,acctualResult);
    }

    @Given("^I enter Invalid password \"(.*?)\"$")
    public void i_enter_Invalid_password(String invalidPassword)  {
        driver.findElement(By.xpath("//input[@id='inputPassword']")).sendKeys(invalidPassword);

    }

    @When("^I click Forgot Password$")
    public void i_click_Forgot_Password()  {
        driver.findElement(By.xpath("//a[contains(text(),'Click here to reset')]")).click();
    }

    @Then("^I should redirect to Forgot Password Page$")
    public void i_should_redirect_to_Forgot_Password_Page()  {
        WebElement forgotPasswordPageVerification = driver.findElement(By.xpath("//div[contains(text(),'Forgot Password?')]"));
        Assert.assertTrue(forgotPasswordPageVerification.isDisplayed());
    }

    @Then("^I enter Email Address \"(.*?)\"$")
    public void i_enter_Email_Address(String emailId)  {
        driver.findElement(By.xpath("//input[@id='email']")).sendKeys(emailId);
    }

    @Then("^I click submit$")
    public void i_click_submit()  {
        driver.findElement(By.xpath("//button[contains(text(),'Submit')]")).click();

    }

    @Then("^I should get message \"(.*?)\"$")
    public void i_should_get_message(String resetPageAcctualResult) {
        WebElement resetPageExpectedResult = driver.findElement(By.xpath("//strong[contains(text(),'Could not instantiate mail function.')]"));
        Assert.assertEquals(resetPageExpectedResult,resetPageAcctualResult);

    }
}



