package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import static utilities.Log.info;
import static utilities.readDataFromJson.readData;

public class HomePage extends BasePage {
    Select select;
    //locate home page elements
    By HotelTab = By.xpath("//a[text()='Hotel']");

    By BothTab = By.xpath("//a[text()='Both']");
    By BothFromInputField = By.xpath("//form[@id='both_oneway']//input[@name='source[]']");
    By BothToInputField = By.xpath("//form[@id='both_oneway']//input[@name='destination[]']");
    By BothDepartureInputField = By.xpath("//form[@id='both_oneway']//input[@name='departure[]']");

    // Locate elements for Logo part
    By ImageLogo = By.xpath("//a[@class='logo navbar-brand']/child::img[1]");

    // Locate elements for FAQs part
    By FAQsLink = By.xpath("//a[contains(@href, 'faqs')]");
    By FAQTitle = By.xpath("//h2[normalize-space()='Dummy Ticket FAQs']");
    By FAQDescription = By.tagName("p");

    // Locate elements for Blog part
    By BlogLink = By.xpath("//a[contains(@href, 'blog')]");
    By BlogImage = By.xpath("//img[contains(@alt, 'how to book dummy flight ticket') and @loading='lazy']");
    By HowToBookTitle = By.xpath("//h2[text()='How To Book Dummy Flight Ticket Free? A step-by-step guide']");

    // Locate elements for B2B part
    By B2BLink = By.xpath("//a[contains(@href, 'b2b')]");
    By B2BTitle = By.xpath("//h2[normalize-space()='B2B Onboarding']");

    // Locate elements for Phone number part
    By PhoneNumberLink = By.xpath("//a[contains(@href, 'tel:+917700006525')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void verifyLogo() {
        info("Asserting on the website logo...");
        Assert.assertTrue(elementIsDisplayed(ImageLogo), "Logo is displayed successfully");
    }

    public HomePage clickFAQ() {
        info("Asserting on the website FAQs...");
        Assert.assertTrue(elementIsDisplayed(FAQsLink));
        clickElement(FAQsLink);
        return this;
    }

    public HomePage verifyFAQsTitleDisplayed() {
        Assert.assertTrue(elementIsDisplayed(FAQTitle), "Title is displayed");
        Assert.assertTrue(elementIsDisplayed(FAQDescription), "Title is displayed");
        return this;
    }

    public HomePage clickBlog() {
        info("Asserting on the blog feature...");
        Assert.assertTrue(elementIsDisplayed(BlogLink));
        clickElement(BlogLink);
        return this;
    }

    public void verifyBlogImageDisplayed() {
        info("Asserting on the website blog image displayed or not...");
        Assert.assertTrue(elementIsDisplayed(BlogImage), "Image is displayed");
        clickElement(BlogImage);
        Assert.assertTrue(elementIsDisplayed(HowToBookTitle), "Title is displayed");

    }

    public HomePage clickB2B() {
        info("Checking B2B feature...");
        Assert.assertTrue(elementIsDisplayed(B2BLink));
        clickElement(B2BLink);
        return this;
    }

    public HomePage verifyB2BTitleDisplayed() {
        Assert.assertTrue(elementIsDisplayed(B2BLink), "Title is displayed");
        return this;
    }

    public HomePage clickPhoneNumber() {
        info("Checking B2B phone number...");
        Assert.assertTrue(elementIsDisplayed(PhoneNumberLink));
        clickElement(PhoneNumberLink);
        return this;
    }

    public void verifyPhoneNumber() throws InterruptedException {

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

    }

    public HomePage clickHotelTab() {
        info("Clicking Hotel tab");
        waitForElementToBeClickable(HotelTab);
        clickElement(HotelTab);
        return this;
    }

    public HomePage clickBothTab() {
        info("Clicking Both tab");
        waitForElementToBeClickable(BothTab);
        clickElement(BothTab);
        return this;
    }

    public HomePage verifyBothTabFunctionality() {
        clickBothTab();
        waitForElementToBeVisible(BothFromInputField);
        Assert.assertTrue(getElement(BothFromInputField).isDisplayed());
        Assert.assertTrue(getElement(BothToInputField).isDisplayed());
        Assert.assertTrue(getElement(BothDepartureInputField).isDisplayed());
        return this;
    }



















}
