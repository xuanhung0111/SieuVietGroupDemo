package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageObject.DriverManager;
import pageObject.UploadPage;

import java.net.URL;


public class UploadFileSteps {
    public static String FILE_NAME = "settings.jar";
    private WebDriver driver = DriverManager.getDriver();
    private UploadPage uploadPage = new UploadPage(driver);

    @After
    public void quitDriver() {
        DriverManager.quitDriver();
    }

    @Given("visit the upload page")
    public void userIsOnLoginPage() throws InterruptedException {
        driver.get("https://demo.guru99.com/test/upload/");
    }

    @Then("check maximum file size")
    public void checkStateOfUpload_page() {
        Assert.assertTrue(uploadPage.getMaxFileSize().contains("max 196.45 MB"));
    }

    @When("select file input")
    public void selectFileInput() {
        URL resource = UploadFileSteps.class.getClassLoader().getResource(FILE_NAME);
        String filePath = resource.getFile();
        uploadPage.inputFile(filePath);
    }
    @When("click submit button")
    public void clickSubmitButton() throws InterruptedException {
        uploadPage.clickSubmitButton();
    }

    @When("checked in the term checkbox")
    public void checkedTerm() {
        uploadPage.checkTerm();
        Assert.assertTrue(uploadPage.hasSuccessMessage());
    }

    @Then("check that file can upload successful")
    public void verifyUploadSuccessful() {
        Assert.assertTrue(uploadPage.hasSuccessMessage());
    }

    @Then("check that file cannot upload successful")
    public void verifyUploadFailure() {
        Assert.assertFalse(uploadPage.hasSuccessMessage(), "Still have success message");
    }

    @When("select file input name is {string}")
    public void selectFileInputByName(String fileName) {
        URL resource = UploadFileSteps.class.getClassLoader().getResource(fileName);
        String filePath = resource.getFile();
        uploadPage.inputFile(filePath);
    }
}