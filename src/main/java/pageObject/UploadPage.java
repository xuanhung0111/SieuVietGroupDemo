package pageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class UploadPage {

    private WebDriver driver;
    private WebDriverWait wait;

    @FindBy(css = "input[name^=\"uploadfile\"]")
    private WebElement chooseFileEl;

    @FindBy(id = "terms")
    private WebElement termsCheckbox;

    @FindBy(id = "submitbutton")
    private WebElement sumitButton;

    @FindBy(css = ".formbuttons .demo")
    private WebElement successMessage;

    @FindBy(xpath = "//b[contains(text(), \"Select file to send\")]")
    private WebElement fileSize;

    @FindBy(className = "spinner")
    private WebElement loadingIcon;

    public UploadPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        PageFactory.initElements(driver, this);
    }

    public void clickChooseFile() {
        wait.until(ExpectedConditions.visibilityOf(chooseFileEl)).click();
    }

    public void uncheckTerm() {
        if (isTermsSelected()) {
            termsCheckbox.click();
        }
    }

    public void checkTerm() {
        if (!isTermsSelected()) {
            termsCheckbox.click();
        }
    }
    public boolean isTermsSelected() {
        return wait.until(ExpectedConditions.visibilityOf(termsCheckbox)).isSelected();
    }

    public void clickSubmitButton() throws InterruptedException {
        wait.until(ExpectedConditions.visibilityOf(sumitButton)).click();
        Thread.sleep(1000); // Hardcode to make sure loading icon can be shown
//        wait.until(ExpectedConditions.visibilityOf(loadingIcon)); // Sometime loading icons never shows
        wait.until(ExpectedConditions.invisibilityOf(loadingIcon));
    }

    public void inputFile(String path) {
        wait.until(ExpectedConditions.visibilityOf(chooseFileEl)).sendKeys(path);
    }

    public boolean hasSuccessMessage() {
        return wait.until(ExpectedConditions.visibilityOf(successMessage)).isDisplayed();
    }
    public String getMaxFileSize() {
        return wait.until(ExpectedConditions.visibilityOf(fileSize)).getText();
    }
}